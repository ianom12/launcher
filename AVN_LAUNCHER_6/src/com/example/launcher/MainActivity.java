package com.example.launcher;

import java.net.InterfaceAddress;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

	private int NUM_PAGES = 2;
	public final static int FRAGMENT_PAGE1 = 0;
	public final static int FRAGMENT_PAGE2 = 1;
	public static ViewPager mViewPager;
	private BroadcastReceiver mReceiver1 = null;
	private BroadcastReceiver mReceiver2 = null;
	private BroadcastReceiver mReceiver3 = null;
	private BroadcastReceiver mReceiver4 = null;
	private BroadcastReceiver mReceiver_radio = null;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewpager_layout);
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
		mViewPager.setCurrentItem(FRAGMENT_PAGE1);
		
		
		IntentFilter intentFilter1 = new IntentFilter();
		intentFilter1
				.addAction("com.glowingpigs.tutorialstreamaudiopart1b.senddata");
		
		IntentFilter intentFilter2 = new IntentFilter();
		intentFilter2
				.addAction("com.glowingpigs.tutorialstreamaudiopart1b.curpos");
		
		IntentFilter intentFilter3 = new IntentFilter();
		intentFilter3
				.addAction("com.example.server_idb.appvalue");
		
		IntentFilter intentFilter4 = new IntentFilter();
		intentFilter4
				.addAction("com.example.videoplayer.sendData");
		
		IntentFilter intentFilter_radio=new IntentFilter();
		intentFilter_radio.addAction("wseemann.media.fmpdemo.sendname");
		

		mReceiver1 = new BroadcastReceiver() {

			@Override
			public void onReceive(Context context, Intent intent) {
				String musicname;
				String musiclength;
				
				/*Main_Page.name=intent.getStringExtra("MUSIC_NAME");
				Main_Page.music_max_length=intent.getStringExtra("MUSIC_MAX");
				Main_Page.max_length=Integer.parseInt(Main_Page.music_max_length);
				Main_Page.execute_music_title.performClick();*/
				
				musicname=intent.getStringExtra("MUSIC_NAME");
				musiclength=intent.getStringExtra("MUSIC_MAX");
				
				if(musicname==null || musiclength==null)
				{
					Main_Page.name="Audio";
					Main_Page.max_length=0;
				}
				else
				{
					Main_Page.name=intent.getStringExtra("MUSIC_NAME");
					Main_Page.music_max_length=intent.getStringExtra("MUSIC_MAX");
					Main_Page.max_length=Integer.parseInt(Main_Page.music_max_length);
					Main_Page.execute_music_title.performClick();
				}
				
				
				
			}
		};
		
		mReceiver2 = new BroadcastReceiver() {

			@Override
			public void onReceive(Context context, Intent intent) {

				Main_Page.music_cur_pos=intent.getIntExtra("MUSIC_CURPOS", 0);
				//Toast.makeText(context, "값:"+Main_Page.music_cur_pos,Toast.LENGTH_LONG).show();
			}
		};
		mReceiver3 = new BroadcastReceiver() {

			@Override
			public void onReceive(Context context, Intent intent) {

				String appvalue=intent.getStringExtra("appvalue");
				//Main_Page.text.setText(data);
				Main_Page.APPVALUE=appvalue;
				//Main_Page.test1.performClick();
				Toast.makeText(context, "값:"+appvalue,Toast.LENGTH_LONG).show();
				
			}
		};
		mReceiver4 = new BroadcastReceiver() {

			@Override
			public void onReceive(Context context, Intent intent) {

				String movetitle=intent.getStringExtra("mMove_Title");
				Toast.makeText(context, movetitle,Toast.LENGTH_LONG).show();
				
			}
		};
		mReceiver_radio=new BroadcastReceiver(){

			@Override
			public void onReceive(Context context, Intent intent) {
				// TODO Auto-generated method stub
				Main_Page.RADIO_TITLE=intent.getStringExtra("BRONAME");
				Toast.makeText(context,Main_Page.RADIO_TITLE,Toast.LENGTH_LONG).show();
			}
			
		};
		
		registerReceiver(mReceiver1, intentFilter1);
		registerReceiver(mReceiver2, intentFilter2);
		registerReceiver(mReceiver3, intentFilter3);
		registerReceiver(mReceiver4, intentFilter4);
		registerReceiver(mReceiver_radio, intentFilter_radio);
		
		
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		unregisterReceiver(mReceiver1);
		unregisterReceiver(mReceiver2);
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