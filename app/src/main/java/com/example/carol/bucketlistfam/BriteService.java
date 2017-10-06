package com.example.carol.bucketlistfam;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/**
 * Created by carol on 10/4/17.
 */

public class BriteService {

    public static void findEvents(String event, okhttp3.Callback callback){

        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(Constants.BRITE_CONSUMER_KEY, Constants.BRITE_CONSUMER_SECRET);
        consumer.setTokenWithSecret(Constants.BRITE_TOKEN, Constants.BRITE_TOKEN_SECRET);

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.BRITE_QUERY_PARAMETER, event);
        String url = urlBuilder.build().toString();

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new SigningInterceptor(consumer))
                .build();


        Request request=new Request.Builder()
                .url(url)
                .build();



        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Event> processResults(Response response) {
        ArrayList<Event> events = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject twitterJSON = new JSONObject(jsonData);
                JSONArray statusesJSON = twitterJSON.getJSONArray("statuses");
                for (int i = 0; i < statusesJSON.length(); i++) {
                    JSONObject tweetJSON = statusesJSON.getJSONObject(i);
                    String text = tweetJSON.getString("text");
                    //String retweeted = tweetJSON.getString("retweeted");
                    String name = tweetJSON.getJSONObject("user").getString("name");
                    //int followers = tweetJSON.getJSONObject("user").getInt("followers_count");
                    String imageUrl = tweetJSON.getJSONObject("user").getString("profile_image_url");
                   // int retweets = tweetJSON.getInt("retweet_count");

                    Event event = new Event(text, name, imageUrl);
                    events.add(event);
                    Log.d("Response", name);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return events;
    }

}
