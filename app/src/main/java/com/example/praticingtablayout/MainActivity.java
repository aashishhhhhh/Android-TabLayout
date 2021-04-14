package com.example.praticingtablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager)findViewById(R.id.vpager);
        tabLayout=(TabLayout)findViewById(R.id.tLayout);

        viewPager.setAdapter(new myOwnFragment(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    class myOwnFragment extends FragmentPagerAdapter{
        String Data[]={"Idea","Implementation","NeverSayNever"};

        public myOwnFragment(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position==0)
            {
                return  new Idea();
            }
            if(position==1)
            {
                return new Implementation();
            }
            if(position ==2)
            {
                return new NeverSayNever();
            }
            return null;
        }

        @Override
        public int getCount() {
            return Data.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return Data[position];
        }
    }

}