package com.ivis.launcher;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.directionalviewpager.DirectionalViewPager;
import com.directionalviewpager.sample.R;

public class TestFragment2 extends Fragment {
	DirectionalViewPager pager;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View root = inflater.inflate(R.layout.frag2, container, false);
		

		return root;
	}

}
