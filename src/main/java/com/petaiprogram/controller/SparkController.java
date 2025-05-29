package com.petaiprogram.controller;

import com.petaiprogram.config.QuestionMatcher;
import com.petaiprogram.domain.Questions;
import com.petaiprogram.domain.gpt.ChatRequest;
import com.petaiprogram.domain.vo.ResponseResult;
import com.petaiprogram.service.QuestionsService;
import io.github.briqt.spark4j.SparkClient;
import io.github.briqt.spark4j.constant.SparkApiVersion;
import io.github.briqt.spark4j.model.SparkMessage;
import io.github.briqt.spark4j.model.SparkSyncChatResponse;
import io.github.briqt.spark4j.model.request.SparkRequest;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chatgpt")
public class SparkController {

    @Resource
    private SparkClient sparkClient;
    @Autowired
    private QuestionsService questionsService;

    /**
     * AI生成问题的预设条件
     */
    public static final String PRECONDITION = "你是一个数据分析师和前端开发专家，接下来我会按照以下固定格式给你提供内容：\n" +
            "分析需求：\n" +
            "{数据分析的需求或者目标}\n" +
            "原始数据：\n" +
            "{csv格式的原始数据，用,作为分隔符}\n" +
            "请根据这两部分内容，按照以下指定格式生成内容（此外不要输出任何多余的开头、结尾、注释）\n" +
            "【【【【【\n" +
            "{前端 Echarts V5 的 option 配置对象js代码，合理地将数据进行可视化，不要生成任何多余的内容，比如注释}\n" +
            "【【【【【\n" +
            "{明确的数据分析结论，越详细越好，不要生成多余的注释\n}" +
            "最终格式是：【【【【【前端代码【【【【【分析结论";

    private Map<String, List<String>> userSessions = new HashMap<>();

    @PostMapping("/XunFei001") // 处理POST请求
    public ResponseResult dealQuestion(@RequestBody ChatRequest chatRequest) {
        // 获取用户的标识和消息
        String userId = chatRequest.getUserId();
        String message = chatRequest.getMessage();
        System.out.println(userId);
        System.out.println(message);

//        问题的答案
        String answer;
        // 在用户传入问题后首先对比问题库中的问题
//        String result = questionAnswer(message);
//        if (result.isEmpty()) {
//            answer = result;
//        } else {
//            answer = chatWithGPT(chatRequest);
//        }

        answer = sendMesToAIUseXingHuo(message);
        return ResponseResult.ok(answer);
    }


//    获取讯飞星火回答
    public String sendMesToAIUseXingHuo(final String content) {
        // 消息列表，可以在此列表添加历史对话记录
        List<SparkMessage> messages = new ArrayList<>();
        messages.add(SparkMessage.systemContent(PRECONDITION));
        messages.add(SparkMessage.userContent(content));
        // 构造请求
        SparkRequest sparkRequest = SparkRequest.builder()
                // 消息列表
                .messages(messages)
                // 模型回答的tokens的最大长度，非必传，默认为2048
                .maxTokens(2048)
                // 结果随机性，取值越高随机性越强，即相同的问题得到的不同答案的可能性越高，非必传，取值为[0,1]，默认为0.5
                .temperature(0.2)
                // 指定请求版本
                .apiVersion(SparkApiVersion.V3_5)
                .build();
        // 同步调用
        SparkSyncChatResponse chatResponse = sparkClient.chatSync(sparkRequest);
        String responseContent = chatResponse.getContent();
        System.out.println("星火AI返回的结果{}"+responseContent);
        return responseContent;
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
        System.out.println("答案的值" + answer);
        return answer;
    }
}


