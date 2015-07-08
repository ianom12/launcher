package com.example.launcher;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class All_Memu_Page extends Fragment {

	private ImageView mRadio_list_icon;
	private ImageView mAudio_list_icon;
	private ImageView mVideo_list_icon;
	private ImageView mGallery_list_icon;
	private ImageView mInternet_list_icon;
	private ImageView mSetting_list_icon;
	private ImageView mClock_list_icon;
	private View mlistView;
	static TextView testview;
	private static final String IMAGEVIEW_TAG = "The Android Logo";
	static ViewPager pager1;
	
	private OnLongClickListener mLongButtonClick = new OnLongClickListener() {

		@Override
		public boolean onLongClick(View view) {

			// TODO Auto-generated method stub
			switch (view.getId()) {
			case R.id.allmenu_radio: {
				mRadio_list_icon
						.setBackgroundResource(R.drawable.allmenu_radio_nor);
				Main_Page.DRAG_DATA = Main_Page.DRAG_RADIO;
				dragStart(view);
			}
				break;
			case R.id.allmenu_audio: {
				mAudio_list_icon
						.setBackgroundResource(R.drawable.allmenu_audio_nor);
				Main_Page.DRAG_DATA = Main_Page.DRAG_AUDIO;
				dragStart(view);
			}
				break;
			case R.id.allmenu_video: {
				mVideo_list_icon
						.setBackgroundResource(R.drawable.allmenu_video_nor);
				Main_Page.DRAG_DATA = Main_Page.DRAG_VIDEO;
				dragStart(view);
			}
				break;
			case R.id.allmenu_gallery: {
				mGallery_list_icon
						.setBackgroundResource(R.drawable.allmenu_dmb_nor);
				Main_Page.DRAG_DATA = Main_Page.DRAG_GALLERY;
				dragStart(view);
			}
				break;
			case R.id.allmenu_internet: {
				mInternet_list_icon
						.setBackgroundResource(R.drawable.allmenu_internet_nor);
				Main_Page.DRAG_DATA = Main_Page.DRAG_INTERNET;
				dragStart(view);
			}
				break;
			case R.id.allmenu_setting: {
				mSetting_list_icon
						.setBackgroundResource(R.drawable.allmenu_setting_nor);
				Main_Page.DRAG_DATA = Main_Page.DRAG_SETTING;
				dragStart(view);
			}
				break;
			case R.id.allmenu_clock: {
				mClock_list_icon
						.setBackgroundResource(R.drawable.allmenu_phone_nor);
				Main_Page.DRAG_DATA = Main_Page.DRAG_CLOCK;
				dragStart(view);
			}
				break;
			}
			return true;
		}

		public void dragStart(View view) {
			ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());

			String[] mimeTypes = { ClipDescription.MIMETYPE_TEXT_PLAIN };
			ClipData data = new ClipData(view.getTag().toString(), mimeTypes,
					item);
			DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

			view.startDrag(data, shadowBuilder, view, 0);

			view.setVisibility(View.VISIBLE);
			MainActivity.mViewPager.setCurrentItem(0);
		}
	};

	private OnClickListener mButtonClick = new OnClickListener() {
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.allmenu_radio: {
				testview.setText("radio");
				mRadio_list_icon.setBackgroundResource(R.drawable.radio_icon);
				pager1.setCurrentItem(0);

				
			}
				break;
			case R.id.allmenu_audio: {
				testview.setText("audio");
				mAudio_list_icon.setBackgroundResource(R.drawable.audio_icon);
				pager1.setCurrentItem(1);

				
			}
				break;
			case R.id.allmenu_video: {
				testview.setText("video");
				mVideo_list_icon.setBackgroundResource(R.drawable.video_icon);
				pager1.setCurrentItem(2);
			}
				break;
			case R.id.allmenu_gallery: {
				testview.setText("gallery");
				mGallery_list_icon
						.setBackgroundResource(R.drawable.gallery_icon);
			}
				break;
			case R.id.allmenu_internet: {
				testview.setText("internet");
				mInternet_list_icon
						.setBackgroundResource(R.drawable.internet_icon);
			}
				break;
			case R.id.allmenu_setting: {
				testview.setText("setting");
				mSetting_list_icon
						.setBackgroundResource(R.drawable.setting_icon);
			}
				break;
			case R.id.allmenu_clock: {
				testview.setText("clock");
				mClock_list_icon.setBackgroundResource(R.drawable.clock_icon);
				
			}
				break;
			}

		}
	};

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		mlistView = (RelativeLayout) inflater.inflate(R.layout.allmenu_layout,
				container, false);

		// mFocusListener = new FocusListenerClass();
		// mHoverListener = new HoverListenerClass();
		
		
		
		mRadio_list_icon = (ImageView) mlistView
				.findViewById(R.id.allmenu_radio);
		mAudio_list_icon = (ImageView) mlistView
				.findViewById(R.id.allmenu_audio);
		mVideo_list_icon = (ImageView) mlistView
				.findViewById(R.id.allmenu_video);
		mGallery_list_icon = (ImageView) mlistView
				.findViewById(R.id.allmenu_gallery);
		mInternet_list_icon = (ImageView) mlistView
				.findViewById(R.id.allmenu_internet);
		mSetting_list_icon = (ImageView) mlistView
				.findViewById(R.id.allmenu_setting);
		mClock_list_icon = (ImageView) mlistView
				.findViewById(R.id.allmenu_clock);

		testview = (TextView) mlistView.findViewById(R.id.testview);

		mRadio_list_icon.setOnClickListener(mButtonClick);
		mRadio_list_icon.setOnLongClickListener(mLongButtonClick);
		mRadio_list_icon.setTag(IMAGEVIEW_TAG);

		mAudio_list_icon.setOnClickListener(mButtonClick);
		mAudio_list_icon.setOnLongClickListener(mLongButtonClick);
		mAudio_list_icon.setTag(IMAGEVIEW_TAG);

		mVideo_list_icon.setOnClickListener(mButtonClick);
		mVideo_list_icon.setOnLongClickListener(mLongButtonClick);
		mVideo_list_icon.setTag(IMAGEVIEW_TAG);

		mGallery_list_icon.setOnClickListener(mButtonClick);
		mGallery_list_icon.setOnLongClickListener(mLongButtonClick);
		mGallery_list_icon.setTag(IMAGEVIEW_TAG);

		mInternet_list_icon.setOnClickListener(mButtonClick);
		mInternet_list_icon.setOnLongClickListener(mLongButtonClick);
		mInternet_list_icon.setTag(IMAGEVIEW_TAG);

		mSetting_list_icon.setOnClickListener(mButtonClick);
		mSetting_list_icon.setOnLongClickListener(mLongButtonClick);
		mSetting_list_icon.setTag(IMAGEVIEW_TAG);

		mClock_list_icon.setOnClickListener(mButtonClick);
		mClock_list_icon.setOnLongClickListener(mLongButtonClick);
		mClock_list_icon.setTag(IMAGEVIEW_TAG);
		
		pager1 = (ViewPager) mlistView.findViewById(R.id.pager1);
		pager1.setAdapter(new WidgetAdapter(getFragmentManager()));
		
		pager1.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int postion) {
				// TODO Auto-generated method stub
				switch(postion)
				{
				case 0://radio
					break;
				case 1://audio
					break;
				case 2://video
					break;	
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});

		return mlistView;
	}

}
