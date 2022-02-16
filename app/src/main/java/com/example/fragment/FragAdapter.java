package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class FragAdapter extends FragmentPagerAdapter {


    private final ArrayList<Fragment> fragLists=new ArrayList<>();
    private final ArrayList<String> fragTitle= new ArrayList<>();
    public FragAdapter(FragmentManager fm, int behavior) {
        super(fm, behavior);

    }


    @Override
    public Fragment getItem(int position) {
        return fragLists.get(position);
    }

    @Override
    public int getCount() {
        return fragLists.size();
    }

    public void addFragment(Fragment fragment, String title){
        fragLists.add(fragment);
        fragTitle.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragTitle.get(position);
    }
}
