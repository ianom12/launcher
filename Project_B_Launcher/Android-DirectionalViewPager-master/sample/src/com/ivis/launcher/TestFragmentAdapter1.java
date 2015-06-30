package com.ivis.launcher;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class TestFragmentAdapter1 extends FragmentPagerAdapter {


	public TestFragmentAdapter1(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			return new TestFragment1();
		case 1:
			return new TestFragment2();
		case 2:
			return new TestFragment3();
		case 3:
			return new TestFragment4();
		default:
			return null;
		}
	}

	@Override
	public int getCount() {
		return 4;
	}
}