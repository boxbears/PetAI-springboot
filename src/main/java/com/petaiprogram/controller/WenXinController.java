package com.petaiprogram.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.petaiprogram.config.QuestionMatcher;
import com.petaiprogram.config.WenXinConfig;
import com.petaiprogram.domain.Questions;
import com.petaiprogram.domain.gpt.ChatRequest;
import com.petaiprogram.domain.vo.ResponseResult;
import com.petaiprogram.service.QuestionsService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 功能描述
 *
 * @author 27609
 * @date 2024/05/17  13:29
 */
@RestController
@RequestMapping("/wenxinyiyan")
@Slf4j
public class WenXinController {

    @Autowired
    private WenXinConfig wenXinConfig;
    @Autowired
    private QuestionsService questionsService;
//    对话记录
    private Map<String, Map<String,String>> userSessions = new HashMap<>();

    //历史对话，需要按照user,assistant
    List<Map<String,String>> messages = new ArrayList<>();

//    预设对话条件
    private String outsetMessage="请你站在一个宠物猫狗专家的角度，采用的语言风格偏人性化，精细化的回答内容但回答内容不应太多，请按照上面我给出的要求回答，我接下来提供给你的问题 ";

    private int chatFlag=0;

    /**
     * 非流式问答
     * @param chatRequest 用户的问题对象
     * @return
     * @throws IOException
     */
    @PostMapping("/chat")
    public ResponseResult dealQuestion(@org.springframework.web.bind.annotation.RequestBody ChatRequest chatRequest)  {
        // 获取用户的标识和消息
        String userId = chatRequest.getUserId();
        String message = chatRequest.getMessage();
        System.out.println(userId);
        System.out.println(message);


//        先进行预设条件训练
        if(chatFlag==0){
            ChatRequest chatRequest1=new ChatRequest();
            chatRequest1.setMessage(outsetMessage);
            chatRequest1.setUserId(chatRequest.getUserId());
            chatWithWeiXin(chatRequest1);
            chatFlag=chatFlag+1;
        }

//        问题的答案
        String answer;
        // 在用户传入问题后首先对比问题库中的问题
        String result = questionAnswer(message);
        System.out.println("result:"+result);
        if (result.isEmpty()||result==null) {
            answer = chatWithWeiXin(chatRequest);
            System.out.println("答案1:"+answer);
        } else {
            answer = result;
            System.out.println("答案2:"+answer);
        }
        return ResponseResult.ok(answer);
    }
    public String chatWithWeiXin(ChatRequest chatRequest)  {
        String userId=chatRequest.getUserId();
        String question=chatRequest.getMessage();
        System.out.println("传入的数据:"+chatRequest.getMessage());
//        最终回复结果
        String answer=null;
        if(question == null || question.equals("")){
            return "请输入问题";
        }
        String responseJson = null;
        //先获取令牌然后才能访问api
        if (wenXinConfig.flushAccessToken() != null) {
            HashMap<String, String> user = new HashMap<>();
            user.put("role","user");
            user.put("content",question);
            messages.add(user);
            String requestJson = constructRequestJson(1,0.95,0.8,1.0,false,messages);
            RequestBody body = RequestBody.create(MediaType.parse("application/json"), requestJson);
            Request request = new Request.Builder()
                    .url(wenXinConfig.ERNIE_Bot_4_0_URL + "?access_token=" + wenXinConfig.flushAccessToken())
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .build();
            OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();
            try {
                responseJson = HTTP_CLIENT.newCall(request).execute().body().string();
                //将回复的内容转为一个JSONObject
                JSONObject responseObject = JSON.parseObject(responseJson);
                System.out.println(responseObject);
//                将文心一言返回的结果放入answer中
                answer=responseObject.getString("result");
                //将回复的内容添加到消息中
                HashMap<String, String> assistant = new HashMap<>();
                assistant.put("role","assistant");
                assistant.put("content",responseObject.getString("result"));
                messages.add(assistant);
            } catch (IOException e) {
                messages.remove(user);
                log.error("网络有问题");
                return "网络有问题，请稍后重试";
            }
        }
        System.out.println(answer);
        return answer;
    }

    /**
     * 构造请求的请求参数
     * @param userId 用户id、
     * @param temperature 1
     * @param topP 1
     * @param penaltyScore 1
     * @param messages 信息
     * @return String
     */
    public String constructRequestJson(Integer userId,
                                       Double temperature,
                                       Double topP,
                                       Double penaltyScore,
                                       boolean stream,
                                       List<Map<String, String>> messages) {
        Map<String,Object> request = new HashMap<>();
        request.put("user_id",userId.toString());
        request.put("temperature",temperature);
        request.put("top_p",topP);
        request.put("penalty_score",penaltyScore);
        request.put("stream",stream);
        request.put("messages",messages);
        System.out.println(JSON.toJSONString(request));
        return JSON.toJSONString(request);
    }


    // 匹配数据库问题
    public String questionAnswer(String ques) {
        String answer;
//        获取数据库中所有的问题集合
        List<Questions> questionList = questionsService.list();
        System.out.println(questionList);

        HashMap<Integer, String> st = new HashMap<>();
        for (Questions qs : questionList) {
            st.put(qs.getId(), qs.getQuestion());
        }
        System.out.println(st);
//        相似度比较算法
        QuestionMatcher qm = new QuestionMatcher(st);
        int index = qm.match(ques);
        System.out.println("答案的索引：" + index);
        if (index == -1) {
            System.out.println("未找到相关问题");
            answer = "";
            return answer;
        }
        answer = questionList.get(index - 1).getAnswer();
        System.out.println("答案" + answer);

//        将回答记录放到message
        HashMap<String, String> user = new HashMap<>();
        user.put("role","user");
        user.put("content",ques);
        HashMap<String, String> assistant = new HashMap<>();
        assistant.put("role","assistant");
        assistant.put("content",answer);
        messages.add(user);
        messages.add(assistant);

        return answer;
    }
    //    保留聊天内容
    @GetMapping("/ChatData")
    public ResponseResult InitializeChatData(@RequestParam("userId") String userId) {

        System.out.println("当前会话数据:id:"+userId);
        //新建对话列表
        List<String> contentValues = new ArrayList<>();
        for (Map<String, String> message : messages) {
            String content = message.get("content");
            if (content != null) {
                contentValues.add(content);
            }
        }
        // 删除前两个对象
        if (contentValues.size() >= 2) {
            contentValues.subList(0, 2).clear();
        }
        System.out.println(contentValues);
//        返回对话记录
        return ResponseResult.ok(contentValues);
    }

}