package com.example.apptechround2;

import java.util.ArrayList;

public class Events {
    private int mImageResource;
    private String mEventName;
    private String mEventPlace;
    private String mPrice;

    public Events(int imageResource, String eventName, String eventPlace, String price) {
        mImageResource = imageResource;
        mEventName = eventName;
        mEventPlace = eventPlace;
        mPrice = price;
    }

    public Events(ArrayList<Events> eventList) {
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getEventName() {
        return mEventName;
    }

    public String getEventPlace() {
        return mEventPlace;
    }

    public String getPrice() {
        return mPrice;
    }






}
