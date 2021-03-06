package com.example.launcher_avn;

import java.util.List;
import java.util.Vector;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {
	private PageAdapter1 mPagerAdapter;
	

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewpager_layout);
		initialisePaging();
		
	}

	private void initialisePaging() {
		// TODO Auto-generated method stub
		List<Fragment> fragments = new Vector<Fragment>();
		fragments.add(Fragment.instantiate(this, Main_page.class.getName()));
		fragments.add(Fragment.instantiate(this, List_Page.class.getName()));

		mPagerAdapter = new PageAdapter1(this.getSupportFragmentManager(),
				fragments);
		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(mPagerAdapter);
		
		
		
	}
	
}
