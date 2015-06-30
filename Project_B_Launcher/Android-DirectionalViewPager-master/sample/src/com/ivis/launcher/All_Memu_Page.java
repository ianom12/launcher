package com.ivis.launcher;

import com.directionalviewpager.DirectionalViewPager;
import com.directionalviewpager.sample.R;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
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
	static DirectionalViewPager pager1;
	private static final String IMAGEVIEW_TAG = "The Android Logo";

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
			SampleActivity.pager.setCurrentItem(0);
		}
	};

	private OnClickListener mButtonClick = new OnClickListener() {
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.allmenu_radio: {
				testview.setText("radio");
				mRadio_list_icon.setBackgroundResource(R.drawable.radio_icon);
				//pager1.setOrientation(DirectionalViewPager.VERTICAL);
				pager1.setCurrentItem(0);

			}
				break;
			case R.id.allmenu_audio: {
				testview.setText("audio");
				mAudio_list_icon.setBackgroundResource(R.drawable.audio_icon);
				//pager1.setOrientation(DirectionalViewPager.VERTICAL);
				pager1.setCurrentItem(1);
			}
				break;
			case R.id.allmenu_video: {
				testview.setText("video");
				mVideo_list_icon.setBackgroundResource(R.drawable.video_icon);
				//pager1.setOrientation(DirectionalViewPager.VERTICAL);
				pager1.setCurrentItem(2);
				
			}
				break;
			case R.id.allmenu_gallery: {
				testview.setText("gallery");
				mGallery_list_icon
						.setBackgroundResource(R.drawable.gallery_icon);
				//pager1.setOrientation(DirectionalViewPager.VERTICAL);
				pager1.setCurrentItem(3);
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

		pager1 = (DirectionalViewPager) mlistView.findViewById(R.id.pager1);
		pager1.setAdapter(new TestFragmentAdapter1(getFragmentManager()));
		pager1.setOrientation(DirectionalViewPager.VERTICAL);
		return mlistView;
	}

}
