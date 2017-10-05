package com.example.carol.bucketlistfam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class TimeineActivity extends AppCompatActivity {
    private ListView mListView;
    private TextView mEventTextView;

    public static final String TAG = TimeineActivity.class.getSimpleName();


    private String[] events = new String[] {"Mi Mero Mole", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeine);
        //Intent intent = getIntent();



        mListView = (ListView) findViewById(R.id.listView);
        mEventTextView = (TextView) findViewById(R.id.eventTextView);
        MyEventsArrayAdapter adapter = new MyEventsArrayAdapter(this, android.R.layout.simple_list_item_1, events);

        mListView.setAdapter(adapter);
        Intent intent = getIntent();
        String events = intent.getStringExtra("event");
        mEventTextView.setText("Events related to your search!");
    }



    private void getEvents(String event) {
        final BriteService yelpService = new BriteService();
        BriteService.findEvents(event, new Callback() {
            //on failure
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
//on response
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    Log.v(TAG, jsonData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

         });
    }
}
}
