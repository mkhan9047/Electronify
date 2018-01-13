package com.example.mujahid.electronify;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

//created by Mujahid khan
public class MainActivity extends AppCompatActivity {
    Fragment fragment;
    public int count = 0;
    ActionBarDrawerToggle drawerToggle;
     DrawerLayout drawerLayout;
    NavigationView navigationView;
    static ArrayList<String> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

            fragment = new homefrag();
        onFragTran();
         navigationView = (NavigationView)findViewById(R.id.navigation_view);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        fragment = new homefrag();
                        break;
                    case R.id.learelct:
                        fragment = new learelefrag();
                        break;

                    case R.id.learnmicro:
                        fragment = new learnmicro();
                        break;
                    case R.id.elecpro:
                        fragment = new elepro();
                        break;
                    case R.id.Fourm:
                        Toast.makeText(MainActivity.this, "Fourm", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.micpro:
                        fragment = new micropro();
                        break;
                    case R.id.pcb:
                        String data = "PCB";

                        Intent intent = new Intent(MainActivity.this, webViews.class);
                        if(!(MainActivity.arrayList.contains("pic"))){
                            MainActivity.arrayList.add("pic");
                        }

                        intent.putExtra(webViews.con, data);
                        startActivity(intent);
                        break;
                    case R.id.Store:
                        String datas = "Store";

                        Intent intents = new Intent(MainActivity.this, webViews.class);

                        if(!(MainActivity.arrayList.contains("store"))){
                            MainActivity.arrayList.add("store");
                        }
                        intents.putExtra(webViews.con, datas);
                        startActivity(intents);
                        break;
                }

                onFragTran();
                getSupportActionBar().setTitle(menuItem.getTitle());
                return true;

            }
        });

         drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer){
            public void onDrawerClosed(View view){
            super.onDrawerClosed(view);
            }

            public void onDrawerOpened(View v){
            super.onDrawerOpened(v);
            }
        };
drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }
    //hare the fragment is transacting
public void onFragTran(){
    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
    fragmentTransaction.replace(R.id.main, fragment);
    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

    fragmentTransaction.addToBackStack(null);
    fragmentTransaction.commit();
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }

    public void image(View v){
        Intent intent = new Intent(MainActivity.this, webViews.class);
        intent.putExtra(webViews.con,"Donate");
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if(id==R.id.about){
            Intent intent = new Intent(MainActivity.this,abouts.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

    //created by Mujahid khan
  @Override
    protected void onResume(){
      super.onResume();



      if(arrayList.contains("learnElect")){
          fragment = new learelefrag();
          onFragTran();
          arrayList.clear();
      }else if(arrayList.contains("learnMicro")){
          fragment = new learnmicro();
          onFragTran();
          arrayList.clear();
      }else if(arrayList.contains("MicroPro")){
          fragment = new micropro();
          onFragTran();
          arrayList.clear();
      }else if(arrayList.contains("ElecPro")){
          fragment = new elepro();
          onFragTran();
          arrayList.clear();
      }else if(arrayList.contains("pic")){
          fragment = new homefrag();
          onFragTran();
          getSupportActionBar().setTitle("Home");
          arrayList.clear();
      }else if(arrayList.contains("store")){
          fragment = new homefrag();
          onFragTran();
          getSupportActionBar().setTitle("Home");
          arrayList.clear();
      }
  }


    @Override
    public void onBackPressed() {

        if(getSupportActionBar().getTitle().toString().contains("Home")){

            if(!drawerLayout.isDrawerOpen(GravityCompat.START)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Exit");
                builder.setMessage("Do you want to Exit?");
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }else {
                drawerLayout.closeDrawers();
            }

        }else {
            fragment = new homefrag();
            onFragTran();
            getSupportActionBar().setTitle("Home");
        }

    }


    /**
     * A simple {@link Fragment} subclass.
     */
    public static class micropro extends ListFragment {


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
            if(!(arrayList.contains("MicroPro"))){
                arrayList.add("MicroPro");
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
}


