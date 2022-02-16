package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabView;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        nowBtn=findViewById(R.id.nowPlayingbtn);
//        topBtn=findViewById(R.id.topRatedBtn);
        tabView=findViewById(R.id.tabView);
        viewPager=findViewById(R.id.fragHolder);

        tabView.setupWithViewPager(viewPager);
        FragAdapter adapter= new FragAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter.addFragment(new NowPlaying(),"Now Playing");
        adapter.addFragment(new TopRated(),"Top Rated");
        viewPager.setAdapter(adapter);
//        nowBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                replaceView(new NowPlaying());
//
//            }
//        });

//        topBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                replaceView(new TopRated());
//
//            }
//        });

    }

//    private void replaceView(Fragment fragment) {
//
//        getSupportFragmentManager().beginTransaction().replace(R.id.tabView,fragment).commit();
//
//    }
}