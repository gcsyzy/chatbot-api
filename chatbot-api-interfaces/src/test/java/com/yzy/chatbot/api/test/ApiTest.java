package com.yzy.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/48884885154588/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie","UM_distinctid=186cf6fc7d54ed-01cb9d76fd7b75-7452547c-144000-186cf6fc7d661c; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22184221542188112%22%2C%22first_id%22%3A%2218696355d33287-07ad0df9f5bef6c-74525471-1327104-18696355d3464b%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2OTYzNTVkMzMyODctMDdhZDBkZjlmNWJlZjZjLTc0NTI1NDcxLTEzMjcxMDQtMTg2OTYzNTVkMzQ2NGIiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIxODQyMjE1NDIxODgxMTIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22184221542188112%22%7D%2C%22%24device_id%22%3A%2218696355d33287-07ad0df9f5bef6c-74525471-1327104-18696355d3464b%22%7D; zsxqsessionid=28e17db461dd81adc5a2ba12f4d4f23c; zsxq_access_token=D0F38907-A3B3-ACF1-F3C1-7DE1FE5E3F9F_CDB3F064FD906290; abtest_env=beta");
        get.addHeader("Content-Type","application/json; charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/584184581414414/answer");
        post.addHeader("cookie","UM_distinctid=186cf6fc7d54ed-01cb9d76fd7b75-7452547c-144000-186cf6fc7d661c; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22184221542188112%22%2C%22first_id%22%3A%2218696355d33287-07ad0df9f5bef6c-74525471-1327104-18696355d3464b%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2OTYzNTVkMzMyODctMDdhZDBkZjlmNWJlZjZjLTc0NTI1NDcxLTEzMjcxMDQtMTg2OTYzNTVkMzQ2NGIiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIxODQyMjE1NDIxODgxMTIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22184221542188112%22%7D%2C%22%24device_id%22%3A%2218696355d33287-07ad0df9f5bef6c-74525471-1327104-18696355d3464b%22%7D; zsxqsessionid=28e17db461dd81adc5a2ba12f4d4f23c; zsxq_access_token=D0F38907-A3B3-ACF1-F3C1-7DE1FE5E3F9F_CDB3F064FD906290; abtest_env=beta");
        post.addHeader("Content-Type","application/json; charset=UTF-8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"晚上吃好！\\n\",\n" +
                "    \"image_ids\": []\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }


    @Test
    public void test_chatGPT() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

//        curl https://api.openai.com/v1/chat/completions \
////        -H 'Content-Type: application/json' \
////        -H 'Authorization: Bearer YOUR_API_KEY' \
////        -d '{
////        "model": "gpt-3.5-turbo",
////                "messages": [{"role": "user", "content": "Say this is a test!"}],
////        "temperature": 0.7
////    }'
        HttpPost post = new HttpPost("https://api.openai.com/v1/chat/completions");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer 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");

        String paramJson = "{\n" +
                "  \"model\": \"gpt-3.5-turbo\",\n" +
                "  \"messages\": [{\"role\": \"user\", \"content\": \"Java应届生要掌握哪些专业技能？\"}],\n" +
                "  \"temperature\": 0.7\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
