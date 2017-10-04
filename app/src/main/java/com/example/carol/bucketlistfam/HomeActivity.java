//package com.example.carol.bucketlistfam;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//
//import com.example.carol.bucketlistfam.utils.BottomNavigationViewHelper;
//import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
//
//public class HomeActivity extends AppCompatActivity {
//    public static final String TAG="HomeActivity";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
//
//        //to load to bottom navigation view for the home activity
//        setUpBottomNavigationView();
//    }
//
//    //customize bottom nav bar for use in all activities
//    private void setUpBottomNavigationView(){
//        Log.d(TAG,"setupBottomNavBarOnView");
//        BottomNavigationViewEx bottomNavigationViewEx=(BottomNavigationViewEx) findViewById(R.id.bottomNavigationView);
//        BottomNavigationViewHelper.setUpBottomNavigationView(bottomNavigationViewEx);//pass widget here which contains animations
//
//    }
//}
