package com.example.mujahid.electronify;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mujahid.electronify.Contact;
import com.example.mujahid.electronify.R;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Random;

/**
 * Created by Mujahid on 10/27/2016on 6:44 PM
 */
public class customadapter extends ArrayAdapter<Contact> {
    TextView graphic;
    int resource;
    Contact contacts;
    String responce;
    Context context;
    public customadapter(Context context, int resource, List<Contact> item){
        super(context,resource,item);
        this.resource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LinearLayout contactView;
         contacts = getItem(position);
        if(convertView==null){
            contactView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi;
            vi = (LayoutInflater) getContext().getSystemService(inflater);
            vi.inflate(resource,contactView,true);

        }else {
        contactView = (LinearLayout)convertView;
        }
         graphic = (TextView)contactView.findViewById(R.id.main);
        TextView data =  (TextView)contactView.findViewById(R.id.data);
        TextView time = (TextView)contactView.findViewById(R.id.seen);
        graphic.setText(String.valueOf(position+1));
        doAnimate();

        data.setText(contacts.getMaindata());
        time.setText(contacts.getTimedata());

        return contactView;
    }

    public  void doAnimate(){
        int x = (int) (Math.random()*10);

        if(x==1){
            graphic.setBackgroundResource(R.drawable.shape4);
        }else if(x==2){
            graphic.setBackgroundResource(R.drawable.shape3);
        }else if(x==3){
            graphic.setBackgroundResource(R.drawable.shape2);
        }else if(x==4){
            graphic.setBackgroundResource(R.drawable.shape);
        }else if(x==5){
            graphic.setBackgroundResource(R.drawable.shape5);
        }else if(x==6){
            graphic.setBackgroundResource(R.drawable.shape6);
        }else if(x==7){
            graphic.setBackgroundResource(R.drawable.shape7);
        }else if(x==8){
            graphic.setBackgroundResource(R.drawable.shape8);
        }else if(x==9){
            graphic.setBackgroundResource(R.drawable.shape9);
        }else if(x==10){
            graphic.setBackgroundResource(R.drawable.shape10);
        }

    }

    public String toString(){
        return contacts.getMaindata();
    }
}
