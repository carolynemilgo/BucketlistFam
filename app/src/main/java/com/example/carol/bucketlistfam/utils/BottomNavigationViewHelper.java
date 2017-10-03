package com.example.carol.bucketlistfam.utils;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by carol on 10/3/17.
 */

public class BottomNavigationViewHelper {
    private static final String TAG="BottomNavigationViewHel1";
    public static void setUpBottomNavigationView(BottomNavigationViewEx bottomNavigationView){
       //  Log.d(TAG, "setUpBottomNavigationView: setting up botom nav view");
        bottomNavigationView.enableAnimation(false);
        bottomNavigationView.enableItemShiftingMode(false)  ;
        bottomNavigationView.enableItemShiftingMode(false);
        bottomNavigationView.setTextVisibility(false);
    }
}
