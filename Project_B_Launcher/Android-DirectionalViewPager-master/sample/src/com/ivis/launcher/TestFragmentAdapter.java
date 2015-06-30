package com.ivis.launcher;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class TestFragmentAdapter extends FragmentPagerAdapter {


	public TestFragmentAdapter(FragmentManager fm) {
		super(fm);
	}

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

	@Override
	public int getCount() {
		return 2;
	}
}