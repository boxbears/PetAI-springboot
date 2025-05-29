package com.petaiprogram.controller;

import com.petaiprogram.config.ChatGPTConfig;
import com.petaiprogram.config.QuestionMatcher;
import com.petaiprogram.domain.Questions;
import com.petaiprogram.domain.gpt.ChatRequest;
import com.petaiprogram.domain.vo.ResponseResult;
import com.petaiprogram.service.QuestionsService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chatgpt")
public class ChatGPTController {

    @Autowired // 自动注入ChatGPTConfig实例
    private ChatGPTConfig chatGPTConfig;
    @Autowired
    private QuestionsService questionsService;

    private Map<String, List<String>> userSessions = new HashMap<>();

    @PostMapping("/GPT001") // 处理POST请求
    public ResponseResult dealQuestion(@RequestBody ChatRequest chatRequest) {
        // 获取用户的标识和消息
        String userId = chatRequest.getUserId();
        String message = chatRequest.getMessage();
        System.out.println(userId);
        System.out.println(message);

//        问题的答案
        String answer;
        // 在用户传入问题后首先对比问题库中的问题
        String result = questionAnswer(message);
//        if (result.isEmpty()) {
//            answer = result;
//        } else {
//            answer = chatWithGPT(chatRequest);
//        }
        answer = chatWithGPT(chatRequest);
        return ResponseResult.ok(answer);
    }

    public String chatWithGPT(ChatRequest chatRequest) {

        // 获取用户的标识和消息
        String userId = chatRequest.getUserId();
        String message = chatRequest.getMessage();
        System.out.println(userId);
        System.out.println(message);

        // 检查用户会话是否存在
        if (!userSessions.containsKey(userId)) {
            // 第一次进来肯定不存在会话中，这时候我们放进去
            userSessions.put(userId, new ArrayList<>());
        }

        // 把发送的消息扔进这个人的list中
        List<String> sessionMessages = userSessions.get(userId);
        sessionMessages.add(message);

        // 构建请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(chatGPTConfig.getOpenaiApiKey());
        // 设置Content-Type为application/json
        headers.setContentType(MediaType.APPLICATION_JSON);
        // 构建请求体
        String requestBody = buildRequestBody(userId, sessionMessages);


        RestTemplate restTemplate = new RestTemplate();


        if (chatGPTConfig.isProxyEnabled()) {
            // 检查是否启用代理

            // 创建一个新的请求工厂
            SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();

            // 设置代理信息
            factory.setProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(chatGPTConfig.getProxyHost(), chatGPTConfig.getProxyPort())));

            // 将新的请求工厂应用于RestTemplate
            restTemplate.setRequestFactory(factory);
        }

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        // 这行代码发送了一个 POST 请求到指定的 URL，使用了 postForEntity() 方法。它接收三个参数：URL、请求实体对象和响应类型。
        ResponseEntity<String> response = restTemplate.postForEntity(chatGPTConfig.getOpenaiApiUrl(), request, String.class);

        // 提取回复消息
        String responseBody = response.getBody();
        String reply = extractReplyFromResponse(responseBody);
        System.out.println("-------------------" + reply + "--------------------");

        // 把回复消息也存进当前用户的的list中，方便上下文记忆
        sessionMessages.add(reply);

//        return ResponseResult.ok(reply);
        return reply;
    }

    private String buildRequestBody(String userId, List<String> sessionMessages) {
        // 创建一个JSONArray来存储用户会话的消息
        JSONArray messagesArray = new JSONArray();

        // 遍历用户会话的消息列表
        for (String message : sessionMessages) {
            // 创建一个JSONObject来表示每条消息
            JSONObject messageObj = new JSONObject();

            // 设置消息的角色为用户
            messageObj.put("role", "user");

            // 设置消息的内容为实际的用户消息
            messageObj.put("content", message);

            // 将每条消息的JSONObject添加到JSONArray中
            messagesArray.put(messageObj);
        }

        // 创建最终的请求体JSONObject
        JSONObject requestBodyObj = new JSONObject();

        // 设置模型为ChatGPT的版本
        requestBodyObj.put("model", "gpt-3.5-turbo");
        // 删除不必要的引擎参数，如果存在的话
        requestBodyObj.remove("engine");

        // 将用户会话的所有消息JSONArray添加到请求体JSONObject中
        requestBodyObj.put("messages", messagesArray);

        // 将最终的请求体JSONObject转换为字符串并返回
        return requestBodyObj.toString();
    }

    private String extractReplyFromResponse(String response) {
        // 使用 org.json 库解析 JSON 字符串
        JSONObject jsonObject = new JSONObject(response);

        // 获取 "choices" 数组
        JSONArray choices = jsonObject.getJSONArray("choices");

        // 获取数组中的第一个元素
        JSONObject firstChoice = choices.getJSONObject(0);

        // 从元素中获取 "message" 对象
        JSONObject message = firstChoice.getJSONObject("message");

        // 从 "message" 对象中获取 "content" 字段的值作为回复
        String reply = message.getString("content");

        return reply;
    }

    //    测试
    @GetMapping("/Test")
    public ResponseResult TestGPT(@RequestParam("userId") String userId) {

        System.out.println("当前会话数据");
        System.out.println(userSessions.get(userId));
        return ResponseResult.ok(userSessions.get(userId));
    }

    //    保留聊天内容
    @GetMapping("/ChatData")
    public ResponseResult InitializeChatData(@RequestParam("userId") String userId) {

        System.out.println("当前会话数据");
        System.out.println(userSessions.get(userId));
        return ResponseResult.ok(userSessions.get(userId));
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


