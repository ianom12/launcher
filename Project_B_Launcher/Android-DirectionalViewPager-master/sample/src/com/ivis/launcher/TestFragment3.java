package com.ivis.launcher;

import com.directionalviewpager.DirectionalViewPager;
import com.directionalviewpager.sample.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class TestFragment3 extends Fragment {

	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View root = inflater.inflate(R.layout.frag3, container, false);
		//SampleActivity.pager.setOrientation(DirectionalViewPager.VERTICAL);
		Button btnButton = (Button) root.findViewById(R.id.button1);

		btnButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SampleActivity.pager.setOrientation(DirectionalViewPager.VERTICAL);
				SampleActivity.pager.setCurrentItem(3);
			}
		});
		return root;
		
		
	}

}
