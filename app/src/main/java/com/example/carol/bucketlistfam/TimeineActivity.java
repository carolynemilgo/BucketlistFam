package com.example.carol.bucketlistfam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class TimeineActivity extends AppCompatActivity {
    private ListView mListView;
    private TextView mEventTextView;
    private MyEventsArrayAdapter mAdapter;
    //private Context context;
    private RecyclerView mEventsRecyclerView;

    private ArrayList<Event> mEvents;

    public static final String TAG = TimeineActivity.class.getSimpleName();


//    private String[] events = new String[] {"Mi Mero Mole", "Mother's Bistro",
//            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
//            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
//            "Lardo", "Portland City Grill", "Fat Head's Brewery",
//            "Chipotle", "Subway"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeine);
        //Intent intent = getIntent();



        mListView = (ListView) findViewById(R.id.listView);

        mEventTextView = (TextView) findViewById(R.id.eventTextView);

        Intent intent = getIntent();
        String event = intent.getStringExtra("event");
        Log.v("event", event);
       // MyEventsArrayAdapter adapter = new MyEventsArrayAdapter(this, android.R.layout.event_items, event);
       // mListView.setAdapter(adapter);

    mEventsRecyclerView=(RecyclerView) findViewById(R.id.eventsRecyclerView);
        mEventTextView.setText("Events related to your search!");
       // context=getApplicationContext();
        getEvents(event);
    }



    private void getEvents(String event) {
        final BriteService briteService = new BriteService();
        briteService.findEvents(event, new Callback() {
            //on failure
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
//on response
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mEvents = briteService.processResults(response);
                Log.v("results",mEvents.toString());

                TimeineActivity.this.runOnUiThread(new Runnable(){
                    @Override
                    public void run(){


                        for (Event event1:mEvents){
                            Log.v("name", event1.getName());
                        }
                        mAdapter=new MyEventsArrayAdapter(getApplicationContext(), mEvents);
                        mEventsRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(TimeineActivity.this);
                        mEventsRecyclerView.setLayoutManager(layoutManager);
                        mEventsRecyclerView.setHasFixedSize(true);
                    }

                });


//                try {
//                    String jsonData = response.body().string();
//                    Log.v(TAG, jsonData);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }


            }

         });
    }


}

