package com.ivis.launcher;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.directionalviewpager.DirectionalViewPager;
import com.directionalviewpager.sample.R;

public class SampleActivity extends FragmentActivity {
	static DirectionalViewPager pager;
    @Override
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Set up the pager
        pager = (DirectionalViewPager)findViewById(R.id.pager);
        pager.setAdapter(new TestFragmentAdapter(getSupportFragmentManager()));
        pager.setOrientation(DirectionalViewPager.HORIZONTAL);
        //pager.setCurrentItem(0);
        //Bind to control buttons
      
    }
}
