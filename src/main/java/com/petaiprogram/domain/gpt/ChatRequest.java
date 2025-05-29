package com.petaiprogram.domain.gpt;

/**
 * 功能描述
 *
 * @author 27609
 * @date 2024/02/07  16:24
 */
public class ChatRequest {
    private String userId;
    private String message;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
