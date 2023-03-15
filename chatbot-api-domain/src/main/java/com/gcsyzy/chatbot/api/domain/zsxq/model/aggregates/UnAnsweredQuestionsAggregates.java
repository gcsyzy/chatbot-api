package com.gcsyzy.chatbot.api.domain.zsxq.model.aggregates;

import com.gcsyzy.chatbot.api.domain.zsxq.model.res.RespData;

/**
 * 未回答问题的信息
 */
public class UnAnsweredQuestionsAggregates {
    private boolean succeeded;
    private RespData respData;

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public RespData getRespData() {
        return respData;
    }

    public void setRespData(RespData respData) {
        this.respData = respData;
    }
}
