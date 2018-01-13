package com.example.mujahid.electronify;


import android.app.ListFragment;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class elepro extends ListFragment {
customadapter customadapters;
    List<Contact> arrayList;

    String data;
  String test;

    //time holder vaiable
String lastSeen;
   String[] holder = new String[5];

    //end
    public elepro() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        if(savedInstanceState!=null){
            holder[0] = savedInstanceState.getString("first");
            holder[1] = savedInstanceState.getString("second");
            holder[2] = savedInstanceState.getString("third");
            holder[3] = savedInstanceState.getString("fourth");
            holder[4] = savedInstanceState.getString("fifth");
            test = savedInstanceState.getString("test");
        }

    arrayList = new ArrayList<Contact>();
    arrayList.add(new Contact("Transistor-Project", test));
    arrayList.add(new Contact("555 Timer IC Project",  holder[1]));
    arrayList.add(new Contact("FM Radio Transmitter Receiver",  holder[2]));
    arrayList.add(new Contact("Basic Robotic Car", holder[3]));
    arrayList.add(new Contact("Digital Logic IC Project",  holder[4]));






    customadapters = new customadapter(getActivity(), R.layout.customlist, arrayList);


    setListAdapter(customadapters);



        return super.onCreateView(inflater,container,savedInstanceState);

    }
    public void onListItemClick(ListView l,View v,int pos,long id){
        MediaPlayer mediaPlayer  = MediaPlayer.create(getActivity(),R.raw.btnclick);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.start();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss yyyy/MM/dd", Locale.ENGLISH);
        Date date = new Date();
        lastSeen = dateFormat.format(date);


        if(pos == 0){
            data = "Transistor-Project";
            test = lastSeen;
            holder[0] = lastSeen;
        }else if(pos == 1){
            data = "555 Timer IC Project";
            holder[1] = lastSeen;
        }else if(pos == 2){
            data = "FM Radio Transmitter Receiver";
            holder[2] = lastSeen;
        }else if(pos == 3){
            data = "Basic Robotic Car";
            holder[3] = lastSeen;
        }else if(pos == 4){
            data = "Digital Logic IC Project";
            holder[4] = lastSeen;
        }

        customadapters.doAnimate();

        Intent intent = new Intent(getActivity().getApplicationContext(),webViews.class);
        if(!(MainActivity.arrayList.contains("ElecPro"))){
            MainActivity.arrayList.add("ElecPro");
        }

        intent.putExtra(webViews.con, data);
        startActivity(intent);

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView listView = getListView();
        listView.setBackgroundColor(Color.rgb(60, 58, 54));
    }



}
