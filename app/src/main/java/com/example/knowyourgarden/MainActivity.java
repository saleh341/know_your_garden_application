package com.example.knowyourgarden;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements TabLayoutMediator.TabConfigurationStrategy {

    //global variables
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    ArrayList<String> titles;
    Button btn,btn1,button2;
    TextView healthcondition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        int persetange = new Random().nextInt(((99) - 70) + 1) + 70;
        viewPager2 = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        btn=findViewById(R.id.button4);
        btn1=findViewById(R.id.button5);
        button2=findViewById(R.id.button2);
        healthcondition=findViewById(R.id.healthcondition);

        healthcondition.setText(persetange+"%");

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // This method will be executed once the timer is over
                Intent ip = new Intent(MainActivity.this, camera.class);
                startActivity(ip);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // This method will be executed once the timer is over
                Intent ip = new Intent(MainActivity.this, GridView.class);
                startActivity(ip);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // This method will be executed once the timer is over
                Intent la = new Intent(MainActivity.this, Login.class);
                startActivity(la);
            }
        });

        titles = new ArrayList<String>();
        titles.add("Disease");
        titles.add("Treatment");

        setViewPagerAdapter();
        new TabLayoutMediator(tabLayout, viewPager2, this).attach();

    }

    public void setViewPagerAdapter() {
        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(this);
        ArrayList<Fragment> fragmentList = new ArrayList<>(); //creates an ArrayList of Fragments
        fragmentList.add(new disease());
        fragmentList.add(new treatment());
        viewPager2Adapter.setData(fragmentList); //sets the data for the adapter
        viewPager2.setAdapter(viewPager2Adapter);

    }


    @Override
    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
        tab.setText(titles.get(position));

    }
}