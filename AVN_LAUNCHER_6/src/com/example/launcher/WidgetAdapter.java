package com.example.launcher;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class WidgetAdapter extends FragmentPagerAdapter {


	public WidgetAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			return new RadioWidget();
		case 1:
			return new AudioWidget();
		case 2:
			return new VideoWidget();
		default:
			return null;
		}
	}

	@Override
	public int getCount() {
		return 3;
	}
}