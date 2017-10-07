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
    @Bind(R.id.findEventsButton)
    Button mFindEventsButton;
    @Bind(R.id.eventsEditText)
    EditText mEventsEditText;
    @Bind(R.id.photoUploadButton)
    Button mUploadPhotosButton;
    @Bind(R.id.postEventBtn) Button mPostEventBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        ButterKnife.bind(this);

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Thin.ttf");
        mAppNameTextView.setTypeface(ostrichFont);


        mFindEventsButton.setOnClickListener(this);
        mUploadPhotosButton.setOnClickListener(this);
        mPostEventBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v == mFindEventsButton) {

            String event = mEventsEditText.getText().toString();
            Log.d(TAG, event);
            Intent intent = new Intent(EventsActivity.this, TimeineActivity.class);
            intent.putExtra("event", event);
            startActivity(intent);
        }
        if(v==mUploadPhotosButton){
            Intent intent = new Intent(EventsActivity.this, MainActivity.class);
            startActivity(intent);
        }

        if(v==mPostEventBtn){
            Intent intent = new Intent(EventsActivity.this, PostEvent.class);
            startActivity(intent);
        }
    }
}



