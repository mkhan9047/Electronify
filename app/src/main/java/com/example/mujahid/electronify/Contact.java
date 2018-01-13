package com.example.mujahid.electronify;

/**
 * Created by Mujahid on 11/7/2016on 2:28 PM
 */
public class Contact {
    public String maindata;
    public String timedata;

    public Contact(String n, String p){
        maindata = n;
        timedata = p;

    }


    public String getMaindata(){
        return maindata;
    }

    public String getTimedata(){
        return timedata;
    }



}
