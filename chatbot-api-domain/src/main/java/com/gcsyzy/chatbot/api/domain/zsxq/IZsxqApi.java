package com.gcsyzy.chatbot.api.domain.zsxq;

import com.gcsyzy.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

public interface IZsxqApi {


    UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicId(String groupId, String cookie) throws IOException, ParseException;
    boolean answer(String groupId , String cookie , String topicId , String text , boolean silenced) throws IOException;

}
