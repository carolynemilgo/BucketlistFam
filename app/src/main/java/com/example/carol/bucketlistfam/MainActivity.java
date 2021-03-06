package com.example.carol.bucketlistfam;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    //varibales
    private Button btnChoose,btnUpload;
    private ImageView imageView;

    private Uri filePath;
    private final int PICK_IMAGE_REQUEST=71;
    private TextView mTextView;
    private TextView mTextView2;

    //firebase
    FirebaseStorage storage;
    StorageReference storageReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//firebase init
        storage=FirebaseStorage.getInstance();
        storageReference=storage.getReference();

        StorageReference imagesRef=storageReference.child("images");



        //initialize view
        btnChoose=(Button) findViewById(R.id.btnChoose);
        btnUpload=(Button) findViewById(R.id.btnUpload);
        imageView=(ImageView) findViewById(R.id.imgView);
        mTextView=(TextView) findViewById(R.id.timeline);
        mTextView2=(TextView) findViewById(R.id.gallery);

        mTextView2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, DisplayImagesActivity.class);
                //intent.putExtra("location", location);
                startActivity(intent);
            }

        });
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();

            }
        });
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();

            }
        });
        mTextView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this, EventsActivity.class);
                //intent.putExtra("location", location);
                startActivity(intent);
            }
        });

    }

    private void uploadImage(){
        if(filePath !=null){
            final ProgressDialog progressDialog= new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();
            StorageReference ref=storageReference.child("images/" +UUID.randomUUID().toString());
            ref.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>(){
                @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot){
                        progressDialog.dismiss();
                 Toast.makeText(MainActivity.this, "Uploaded", Toast.LENGTH_SHORT).show();

                }}
                    )

                .addOnFailureListener(new OnFailureListener(){
                    @Override
                            public void onFailure(@NonNull Exception e){
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, "Failed" +e.getMessage(), Toast.LENGTH_SHORT).show();


                    }
                })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>(){
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot){
                            double progress=(100.0*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                            progressDialog.setMessage("UPloaded"+(int)progress +"%");

                        }

                    });

            }
        }



    private void chooseImage(){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select picture"),PICK_IMAGE_REQUEST);
                //(Intent.createChooser(intent, "Select picture", PICK_IMAGE_REQUEST));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode,data);
        if(requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data!=null && data.getData() !=null){
            filePath = data.getData();
            try
            {
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);
            }
            catch(IOException e){
            e.printStackTrace();

            }

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout() {
        FirebaseAuth.getInstance().signOut();//frebase inbuilt signout method
    }
}
