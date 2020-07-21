package com.example.apptechround2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Events> mEventList;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextTitle, mTextDescription, mTextPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.mainimage);
            mTextTitle = itemView.findViewById(R.id.eventname);
            mTextDescription = itemView.findViewById(R.id.eventplace);
            mTextPrice = itemView.findViewById(R.id.price);
        }
    }
    public Adapter(ArrayList<Events> eventList) {
        mEventList = eventList;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Events currentItem = mEventList.get(position);

        holder.mImageView.setImageResource(currentItem.getmImageResource());
        holder.mTextTitle.setText(currentItem.getEventName());
        holder.mTextDescription.setText(currentItem.getEventPlace());
        holder.mTextPrice.setText(currentItem.getPrice());


    }


    @Override
    public int getItemCount() {
        return mEventList.size();
    }


}
