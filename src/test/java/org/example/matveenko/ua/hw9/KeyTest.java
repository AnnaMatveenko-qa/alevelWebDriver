package org.example.matveenko.ua.hw9;


import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.Asserts;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class KeyTest {

    @Test
    public void hasKey() throws IOException {
        String baseURI = "https://api.github.com/emojis";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(baseURI);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String json = EntityUtils.toString(entity);
        Gson gson = new Gson();
        Emojis emojis = gson.fromJson(json, Emojis.class);
        Assert.assertNotNull(emojis.getArticulatedLorry());
        System.out.println("Status code: " + response.getStatusLine().getStatusCode());
        System.out.println("Reason phrase: " + response.getStatusLine().getReasonPhrase());
        System.out.println("Key articulated_lorry: " + emojis.getArticulatedLorry());




    }

}
