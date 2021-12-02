package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;

import com.example.newsapp.adapter.NewsListAdapter;
import com.example.newsapp.adapter.SectionPagerAdapter;
import com.example.newsapp.fragment.HomeFragment;
import com.example.newsapp.model.MasterResponceModel;
import com.example.newsapp.model.Source;
import com.example.newsapp.network.APIInterface;
import com.example.newsapp.network.RetroInstance;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TabLayout tablayout;
    TabItem mhome,msport,mhealth,entertainment,business,science,technology;
    Toolbar mtoolbar;
    private ViewPager viewpager;
    private SectionPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mtoolbar=findViewById(R.id.toolbar);


        tablayout=findViewById(R.id.tablayout);
         mhome=findViewById(R.id.home);
         msport=findViewById(R.id.sport);
         mhealth=findViewById(R.id.health);
        entertainment=findViewById(R.id.entertainment);
        business=findViewById(R.id.business);
        science=findViewById(R.id.science);
        technology=findViewById(R.id.technology);

        viewpager=findViewById(R.id.fragment_container);

        adapter = new SectionPagerAdapter(getSupportFragmentManager(),tablayout.getTabCount());
        viewpager.setAdapter(adapter);






        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());

                if (tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5||tab.getPosition()==6||tab.getPosition()==7){
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
    }

    private void onChangeTab(int position) {



    }


}