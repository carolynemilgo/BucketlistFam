package com.example.carol.bucketlistfam;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/**
 * Created by carol on 10/4/17.
 */

public class BriteService {

    public static void findEvents(String event, okhttp3.Callback callback){

        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(Constants.BRITE_CONSUMER_KEY, Constants.BRITE_CONSUMER_SECRET);
       // consumer.setTokenWithSecret(Constants.BRITE_TOKEN, Constants.BRITE_TOKEN_SECRET);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new SigningInterceptor(consumer))
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.BRITE_QUERY_PARAMETER, event);
        String url = urlBuilder.build().toString();

        Request request= new Request.Builder()
                .url(url)
                .build();

//calling a request asynchronously
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

}
