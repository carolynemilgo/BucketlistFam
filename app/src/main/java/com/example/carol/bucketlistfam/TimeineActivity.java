package com.example.carol.bucketlistfam;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;

public class TimeineActivity extends AppCompatActivity {
    private ListView mListView;
    private TextView mEventTextView;


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
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, events);
        mListView.setAdapter(adapter);
        Intent intent = getIntent();
        String events = intent.getStringExtra("event");
        mEventTextView.setText("Events related to your search!");
    }
}
