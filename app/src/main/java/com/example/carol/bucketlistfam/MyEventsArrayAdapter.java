package com.example.carol.bucketlistfam;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * Created by carol on 10/5/17.
 */

public class MyEventsArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mEvents;
   // private String[] mCuisines;

    public MyEventsArrayAdapter(Context mContext, int resource, String[] mEvents) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mEvents = mEvents;
    }

    @Override
    public Object getItem(int position) {
        String event = mEvents[position];

        return String.format(event);
    }

    @Override
    public int getCount() {
        return mEvents.length;
    }
}
