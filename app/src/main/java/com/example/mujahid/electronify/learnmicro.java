package com.example.mujahid.electronify;


import android.app.ListFragment;
import android.content.Intent;
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

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class learnmicro extends ListFragment {
customadapter customadapters;
String data;
    public learnmicro() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        List<Contact> arrayList = new ArrayList<Contact>();
        arrayList.add(new Contact("AVR","4:56pm"));
        arrayList.add(new Contact("ARM","1:20am"));
        arrayList.add(new Contact("Arduino","3:27am"));
        arrayList.add(new Contact("8051","2:45pm"));
        arrayList.add(new Contact("PIC","4:45am"));
        arrayList.add(new Contact("Respberry-pi","9:23am"));
        arrayList.add(new Contact("FPGA","2:43"));



        customadapters = new customadapter(getActivity(),R.layout.customlist,arrayList);

        setListAdapter(customadapters);


   return super.onCreateView(inflater,container,savedInstanceState);

    }

    public void onListItemClick(ListView l,View v,int pos,long id){

        MediaPlayer mediaPlayer  = MediaPlayer.create(getActivity(),R.raw.btnclick);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.start();
        
      if(pos == 0){
          data = "AVR";
      }else if(pos == 1){
          data  = "ARM";
      }else if(pos == 2){
          data = "Arduino";
      }else if(pos == 3){
          data = "8051";
      }else if(pos == 4){
          data = "PIC";
      }else if(pos == 5){
          data = "Respberry-pi";
      }else if(pos == 6){
          data = "FPGA";
      }

        customadapters.doAnimate();
        Intent intent = new Intent(getActivity().getApplicationContext(),webViews.class);
        if(!(MainActivity.arrayList.contains("learnMicro"))){
            MainActivity.arrayList.add("learnMicro");
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
