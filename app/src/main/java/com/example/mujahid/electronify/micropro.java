package com.example.mujahid.electronify;


import android.app.ListFragment;
import android.content.Intent;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class micropro extends ListFragment {


    public micropro() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("AVR Project");
        arrayList.add("ARM Project");
        arrayList.add("PIC Project");
        arrayList.add("Arduino Project");
        arrayList.add("8051 Project");
        arrayList.add("Respberry-pi Project");
        arrayList.add("FPGA Project");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(),android.R.layout.simple_list_item_1,arrayList);
        setListAdapter(adapter);
       return super.onCreateView(inflater,container,savedInstanceState);
    }

    public void onListItemClick(ListView l,View v,int pos,long id){
        MediaPlayer mediaPlayer  = MediaPlayer.create(getActivity(),R.raw.btnclick);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.start();
        String data = l.getItemAtPosition(pos).toString();

        Intent intent = new Intent(getActivity().getApplicationContext(),webViews.class);
        if(!(MainActivity.arrayList.contains("MicroPro"))){
            MainActivity.arrayList.add("MicroPro");
        }

        intent.putExtra(webViews.con, data);
        startActivity(intent);

    }


}
