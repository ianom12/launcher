package com.example.launcher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

	private int NUM_PAGES = 2;
	public final static int FRAGMENT_PAGE1 = 0;
	public final static int FRAGMENT_PAGE2 = 1;
	public static ViewPager mViewPager;
	private BroadcastReceiver mReceiver = null;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewpager_layout);
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
		mViewPager.setCurrentItem(FRAGMENT_PAGE1);

		IntentFilter intentFilter = new IntentFilter();
		intentFilter
				.addAction("com.glowingpigs.tutorialstreamaudiopart1b.senddata");

		mReceiver = new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
				

				Main_Page.name = intent.getStringExtra("MUSIC_NAME");
				/*String max=intent.getStringExtra("MUSIC_MAX");
				String curpos=intent.getStringExtra("MUSIC_CURPOS");
				int pos=intent.getIntExtra("MUSIC_CURPOS", 0);
				String temp=intent.getStringExtra("MUSIC_CURPOS");
				Main_Page.music_max_length=Integer.parseInt(max);
				Main_Page.music_cur_pos=Integer.parseInt(curpos);*/
				Main_Page.execute_music_title.performClick();
				
				Toast.makeText(context,Main_Page.name, Toast.LENGTH_LONG).show();
				

			}
		};

		registerReceiver(mReceiver, intentFilter);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		unregisterReceiver(mReceiver);
		super.onDestroy();
	}

	private class pagerAdapter extends FragmentPagerAdapter {

		public pagerAdapter(android.support.v4.app.FragmentManager fm) {
			super(fm);
		}

		// 특정 위치에 있는 Fragment를 반환해준다.
		@Override
		public Fragment getItem(int position) {

			switch (position) {
			case 0:
				return new Main_Page();
			case 1:
				return new All_Memu_Page();

			default:
				return null;
			}
		}

		// 생성 가능한 페이지 개수를 반환해준다.
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return NUM_PAGES;
		}
	}

}