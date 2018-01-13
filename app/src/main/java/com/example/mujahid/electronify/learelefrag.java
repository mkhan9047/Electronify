package com.example.mujahid.electronify;


import android.app.Activity;
import android.app.ActivityOptions;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
public class learelefrag extends ListFragment {
    String data;
    LayoutInflater inflater;
    String lastSeen;
    customadapter customadapters;
    public learelefrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


    View view = getView();
        if(view!=null) {

            view.getRootView().setBackground(new ColorDrawable(Color.rgb(60, 58, 54)));
        }
        List<Contact> arrayList = new ArrayList<Contact>();
       arrayList.add(new Contact("Internet of Things",lastSeen));
        arrayList.add(new Contact("Things To Know Before Electronics",lastSeen));
        arrayList.add(new Contact("Basic Component Introduction",lastSeen));
        arrayList.add(new Contact("Measuring Instrument","2:45pm"));
        arrayList.add(new Contact("Soldering","4:45am"));
        arrayList.add(new Contact("Electronics Software Into","9:23am"));
        arrayList.add(new Contact("How Does It Works","2:43"));



     customadapters = new customadapter(getActivity(),R.layout.customlist,arrayList);

        setListAdapter(customadapters);

        return super.onCreateView(inflater,container,savedInstanceState);
    }

    public void onListItemClick(ListView l,View v,int pos,long id){

        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss yyyy/MM/dd", Locale.ENGLISH);
        Date date = new Date();
        lastSeen = dateFormat.format(date);


        MediaPlayer mediaPlayer  = MediaPlayer.create(getActivity(),R.raw.btnclick);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.start();
        if(pos == 0){
             data = "Internet of Things";
        }else if(pos==1){
            data = "Things To Know Before Electronics";
        }else if(pos == 2){
            data = "Basic Component Introduction";
        }else if(pos == 3){
            data = "Measuring Instrument";
        }else if(pos == 4){
            data = "Soldering";
        }else if(pos == 5){
            data = "Electronics Software Into";
        }else if(pos == 6){
            data = "How Does It Works";
        }
        customadapters.doAnimate();

        Intent intent = new Intent(getActivity().getApplicationContext(),webViews.class);
        ActivityOptions options = ActivityOptions.makeScaleUpAnimation(v, 0,
                0, v.getWidth(), v.getHeight());

        if(!(MainActivity.arrayList.contains("learnElect"))){
            MainActivity.arrayList.add("learnElect");
        }

        intent.putExtra(webViews.con, data);
        startActivity(intent, options.toBundle());

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView listView = getListView();
        listView.setBackgroundColor(Color.rgb(60,58,54));
    }


}
