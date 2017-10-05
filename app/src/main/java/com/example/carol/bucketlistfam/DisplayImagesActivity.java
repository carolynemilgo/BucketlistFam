package com.example.carol.bucketlistfam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class DisplayImagesActivity extends AppCompatActivity {


    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_images);

     imageView=(ImageView)findViewById(R.id.image);

        String url="https://firebasestorage.googleapis.com/v0/b/bucketlistfam.appspot.com/o/images?alt=media&token=4ca4c935-c565-4807-8357-98bda10880d8";

        Glide.with(getApplicationContext()).load(url).into(imageView);

    }
}
