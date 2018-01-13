package com.example.mujahid.electronify;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class webViews extends AppCompatActivity {
   static final String con = "EXTRA";
 ProgressBar progressBar;
 public WebView webView;
    String url;

   private class WebClient extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_views);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        String id = getIntent().getStringExtra(con);
        getSupportActionBar().setTitle(id);
        webView = (WebView)findViewById(R.id.webView);
        webView.setWebViewClient(new WebClient());


if(isNetworkAvailable()){

        if(id.contains("Internet of Things")){

            url = "http://www.electronify.org/iot";

        }else if(id.contains("Things To Know Before Electronics")){

            url = "http://www.electronify.org/things-to-know-before-electronics";

        }else if(id.contains("Basic Component Introduction")){

            url = "http://www.electronify.org/basic-component-introduction";

        }else if(id.contains("Measuring Instrument")){
            url = "http://www.electronify.org/measuring-instruments";
        }else if(id.contains("Soldering")){
            url = "http://www.electronify.org/soldering";
        }else if(id.contains("Electronics Software Into")){
            url = "http://www.electronify.org/electronics-software-intro";
        }else if(id.contains("How Does It Works")){
            url = "http://www.electronify.org/how-does-it-works";
        }else if(id.contains("AVR")){
            url = "http://www.electronify.org/learn-microcontrolleravr";
        }else if(id.contains("ARM")){
            url = "http://www.electronify.org/learn-microcontrollerarm";
        }else if(id.contains("Arduino")){

            url = "http://www.electronify.org/arduino";
        }else if(id.contains("8051")){
            url = "http://www.electronify.org/learn-microcontroller8051";
        }else if(id.contains("PIC")){
            url = "http://www.electronify.org/learn-microcontrollerpic";
        }else if(id.contains("Respberry-pi")){
            url = "http://www.electronify.org/learn-microcontrollerrespberry-pi";
        }else if(id.contains("FPGA")){
            url = "http://www.electronify.org/learn-microcontrollerfpga";
        }else if(id.contains("Transistor-Project")){

            url = "http://www.electronify.org/transistor-projects";
        }else if(id.contains("555 Timer IC Project")){
            url = "http://www.electronify.org/555-timer-ic-projects";
        }else if(id.contains("FM Radio Transmitter Receiver")){
            url = "http://www.electronify.org/fm-radio-transmitter-receiver";
        }else if(id.contains("Basic Robotic Car")){
            url = "http://www.electronify.org/basic-robotic-car";
        }else if(id.contains("Digital Logic IC Project")){
            url = "http://www.electronify.org/miscelleneous-electronics-projects";
        }else if (id.contains("AVR Project")){
            url = "http://www.electronify.org/avr-projects";
        }else if(id.contains("ARM Project")){
            url = "http://www.electronify.org/arm-projects";
        }else if(id.contains("PIC Project")){
            url = "http://www.electronify.org/pic-projects";
        }else if(id.contains("Arduino Project")){
            url = "http://www.electronify.org/arduino-projects";
        }else if(id.contains("8051 Project")){
            url = "http://www.electronify.org/8051-projects-2";
        }else if(id.contains("Respberry-pi Project")){
            url = "http://www.electronify.org/respberry-pi-projects";
        }else if(id.contains("FPGA Project")){
            url = "http://www.electronify.org/fpga-projects";
        }else if(id.contains("PCB")){
            url = "http://www.electronify.org/printed-circuit-board-pcb";
        }else if(id.contains("Store")){
            JsON();
            url = "http://store.electronify.org";

        }else if(id.contains("Donate")){
            url = "https://www.paypal.com/us";
        }


      progressBar = (ProgressBar)findViewById(R.id.progressBar);

        webView.getSettings().setLoadsImagesAutomatically(true);
        progressBar.setProgress(webView.getProgress());
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(url);

        webView.setWebChromeClient(new WebChromeClient() {




            public void onProgressChanged(WebView view, int progress) {
                if (progress < 100 && progressBar.getVisibility() == ProgressBar.GONE) {
                    progressBar.setVisibility(ProgressBar.VISIBLE);

                }

                progressBar.setProgress(progress);
                if (progress == 100) {
                    progressBar.setVisibility(ProgressBar.GONE);

                }
            }


        });



    }else {

    Toast.makeText(this,"No Internet Connection!",Toast.LENGTH_LONG).show();

    }



    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void JsON(){
        webView.getSettings().setJavaScriptEnabled(true);
    }
    private void JsOff(){
        webView.getSettings().setJavaScriptEnabled(false);
    }

public void onDestroy(){
    super.onDestroy();
    if(getSupportActionBar().getTitle().toString().contains("Store")){
        JsOff();
    }
}

}

