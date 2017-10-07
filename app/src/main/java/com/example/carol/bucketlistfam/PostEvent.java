package com.example.carol.bucketlistfam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

//import com.firebase.ui

public class PostEvent extends AppCompatActivity {
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseListAdapter<Story> adapter;
    @Bind(R.id.btn_save)
    Button mbtnSave;
    @Bind(R.id.eventName)
    EditText mEventName;
    @Bind(R.id.eventDesc)
    EditText mEventDesc;
    //@Bind(R.id. eventsList) ListView mEventsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_event);

        ButterKnife.bind(this);

        //retrieve inputs

            String eventName = mEventName.getText().toString();
        String eventDesc= mEventDesc.getText().toString();

        displayEvents();

       //init
    mbtnSave.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            saveToFirebase();
        }
    });

    }

    private void saveToFirebase(){
        mFirebaseDatabase.getInstance().getReference().push().setValue(new Story(mEventName.getText().toString(), mEventDesc.getText().toString()));
    }

    private void displayEvents(){
        ListView mEventsList=(ListView) findViewById(R.id.eventsList);

        adapter=new FirebaseListAdapter<Story>(this, Story.class,R.layout.eventlayout,FirebaseDatabase.getInstance().getReference()) {
            @Override
            protected void populateView(View v, Story model, int position) {
                //ref to the views of the event layout
                TextView eventName1=(TextView) v.findViewById(R.id.eventName1);
                TextView eventDesc1=(TextView) v.findViewById(R.id.eventDesc1);

                        //set their text
                eventName1.setText(model.getTitle());
                eventDesc1.setText(model.getStory());
            }
        };

        mEventsList.setAdapter(adapter);

    }
}
