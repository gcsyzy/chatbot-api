package com.yzy.chatbot.api.test;


import com.alibaba.fastjson.JSON;
import com.gcsyzy.chatbot.api.ApiApplication;
import com.gcsyzy.chatbot.api.domain.ai.IOpenAI;
import com.gcsyzy.chatbot.api.domain.zsxq.IZsxqApi;
import com.gcsyzy.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import com.gcsyzy.chatbot.api.domain.zsxq.model.vo.Topics;
import org.apache.hc.core5.http.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class SpringBootRunTest {

    private Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);

    @Value("${chatbot-api.groupId}")
    private String groupId;

    @Value("${chatbot-api.cookie}")
    private String cookie;

    @Resource
    private IZsxqApi zsxqApi;

    @Resource
    private IOpenAI openAI;

    @Test
    public void test_zsxqApi() throws IOException, ParseException {
        UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnsweredQuestionsTopicId(groupId,cookie);
        logger.info("测试结果：{}", JSON.toJSONString(unAnsweredQuestionsAggregates));

        List<Topics> topics = unAnsweredQuestionsAggregates.getRespData().getTopics();
        for (Topics topic : topics) {
            String topicId = topic.getTopic_id();
            String text = topic.getQuestion().getText();
            logger.info("topicId: {} text: {}", topicId, text);

            //回答问题
            zsxqApi.answer(groupId, cookie ,topicId , text ,false);
        }
    }

    @Test
    public void  test_openAi() throws IOException {
        String response = openAI.doChatGPT("java应届生应该掌握哪些技术栈？");
        logger.info("测试结果: {}", response);
    }

}
