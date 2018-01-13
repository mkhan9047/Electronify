package com.example.mujahid.electronify;



import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



/**
 * A simple {@link Fragment} subclass.
 */
public class homefrag extends Fragment {
public int second = 0;
    CardView cardView1;
    TextView textView;
    Runnable  runnable;
    ImageView imageView;
    public homefrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_homefrag, container, false);


    }


    public void onStart() {
        super.onStart();


             View view = getView();
            if (view != null) {
                CardView cardView = (CardView) view.findViewById(R.id.card_view1);
                cardView.setShadowPadding(10, 10, 10, 10);



                 imageView = (ImageView) view.findViewById(R.id.mainimg);


                //second handler
                final Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        second++;
                        
                        int sec = second % 60;
if(sec==1){
    imageView.setImageResource(R.drawable.navihead1);
}else if(sec==4){
    imageView.setImageResource(R.drawable.navihead2);
}else if(sec == 8){
    imageView.setImageResource(R.drawable.navihead3);

}else if(sec==12){
    imageView.setImageResource(R.drawable.navihead4);
    sec = 1;
    second  = 0;
}


                        handler.postDelayed(this,1000);

                    }

                });




            }



        }


    }


