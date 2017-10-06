package com.example.carol.bucketlistfam;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by carol on 10/5/17.
 */

public class MyEventsArrayAdapter extends RecyclerView.Adapter<MyEventsArrayAdapter.EventViewHolder> {
    private Context mContext;
    // private String[] mEvents;
    private ArrayList<Event> mEvents = new ArrayList<>();
    // private String[] mCuisines;


    public MyEventsArrayAdapter(Context context, ArrayList<Event> events) {

        this.mContext = context;
        this.mEvents = events;
    }

    @Override
    public MyEventsArrayAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_items,parent, false);
        EventViewHolder viewHolder=new EventViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyEventsArrayAdapter.EventViewHolder holder, int position) {
        holder.bindEvent(mEvents.get(position));

    }
    @Override
    public int getItemCount() {
        return mEvents.size();
    }


//    @Override
//    public int getItemCount() {
//        return 0;
//    }


//    @Override
//    public Object getItem(int position) {
//        String event = mEvents[position];
//
//        return String.format(event);
//    }
//
//    @Override
//    public int getCount() {
//        return mEvents.length;
//    }


    public class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.tweetTextView)
        TextView mTextView;
        @Bind(R.id.tweetImageView)
        ImageView mImageView;
        @Bind(R.id.nameTextView) TextView mNameTextView;
        private Context mContext;

        public EventViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
            mContext = v.getContext();
            //itemView.setOnClickListener(this);
        }

        public void bindEvent(Event event) {
            Picasso.with(mContext).load(event.getImageUrl()).into(mImageView);
            mTextView.setText(event.getName());
            mNameTextView.setText(event.getText());
        }

        @Override
        public void onClick(View v) {
            int viewPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, TimeineActivity.class);
            intent.putExtra("position", viewPosition);
            intent.putExtra("events", Parcels.wrap(mEvents));
            mContext.startActivity(intent);
        }


    }
}


