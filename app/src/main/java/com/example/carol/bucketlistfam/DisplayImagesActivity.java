package com.example.carol.bucketlistfam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class DisplayImagesActivity extends AppCompatActivity {


    private ImageView imageView;
    private ImageView imageView2;
    private ImageView imageView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_images);

     imageView=(ImageView)findViewById(R.id.image);
        imageView2=(ImageView) findViewById(R.id.image2);
        imageView3=(ImageView) findViewById(R.id.image3);


       // StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("myimage");


        String url="https://firebasestorage.googleapis.com/v0/b/bucketlistfam.appspot.com/o/images%2F0965c2e8-c305-4961-a42e-3b956a5274de?alt=media&token=4ca4c935-c565-4807-8357-98bda10880d8";

        Glide.with(getApplicationContext()).load(url).into(imageView);

        String url2="https://firebasestorage.googleapis.com/v0/b/bucketlistfam.appspot.com/o/images%2Fc195dbbb-1fe6-4361-8bf1-b6b73d29b15f?alt=media&token=9ef603c9-9f26-41d5-a703-237a848d39eb";

        Glide.with(getApplicationContext()).load(url2).into(imageView2);

        String url3="https://firebasestorage.googleapis.com/v0/b/bucketlistfam.appspot.com/o/images%2F7f172a37-5b1a-46b8-b14c-d62e6698e8f3?alt=media&token=d1d8c3c9-3446-40ea-89d0-c431643e2d8c";

        Glide.with(getApplicationContext()).load(url3).into(imageView3);
    }
}
