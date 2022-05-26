package com.example.knowyourgarden;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

class ViewPager2Adapter extends FragmentStateAdapter {
    private ArrayList<Fragment> fragments; //variable holds the fragments the ViewPager2 allows us to swipe to.

    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {         //this is the constructor
        super(fragmentActivity);

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }

    public void setData(ArrayList<Fragment> fragments) {
        this.fragments = fragments;
    }
}