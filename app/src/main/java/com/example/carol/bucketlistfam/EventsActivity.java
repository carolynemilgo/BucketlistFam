package com.example.carol.bucketlistfam;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EventsActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = EventsActivity.class.getSimpleName();
    @Bind(R.id.appNameTextView)
    TextView mAppNameTextView;
    @Bind(R.id.findEventsButton) Button mFindEventsButton;
    @Bind(R.id.eventsEditText) EditText mEventsEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        ButterKnife.bind(this);

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Thin.ttf");
        mAppNameTextView.setTypeface(ostrichFont);


        mFindEventsButton.setOnClickListener(this);
    }


            @Override
            public void onClick(View v) {

                String location = mEventsEditText.getText().toString();
                Log.d(TAG, location);
                Intent intent = new Intent(EventsActivity.this, TimeineActivity.class);
                startActivity(intent);
            }
        }




//    private void getEvents(String event) {
//        final BriteService yelpService = new BriteService();
//        //yelpService.findEvents(event, new Callback() {
//
//        //  });
//    }
//}