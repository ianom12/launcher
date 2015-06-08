package com.example.launcher;

import com.example.launcher.Main_Page.FocusListenerClass;
import com.example.launcher.Main_Page.HoverListenerClass;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
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
	private FocusListenerClass mFocusListener;
	private HoverListenerClass mHoverListener;
	TextView testview;

	private OnClickListener mButtonClick = new OnClickListener() {
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.allmenu_radio: {
				testview.setText("radio");
			}
				break;
			case R.id.allmenu_audio: {
				testview.setText("audio");
			}
				break;
			case R.id.allmenu_video: {
				testview.setText("video");
			}
				break;
			case R.id.allmenu_gallery: {
				testview.setText("gallery");
			}
				break;
			case R.id.allmenu_internet: {
				testview.setText("internet");
			}
				break;
			case R.id.allmenu_setting: {
				testview.setText("setting");
			}
				break;
			case R.id.allmenu_clock: {
				testview.setText("clock");
			}
				break;
			}

		}
	};

	class FocusListenerClass implements View.OnFocusChangeListener {

		public void onFocusChange(View v, boolean hasFocus) {
			// TODO Auto-generated method stub

			switch (v.getId()) {
			case R.id.allmenu_radio: {

				if (hasFocus == true) {

					mRadio_list_icon
							.setBackgroundResource(R.drawable.allmenu_radio_foc);
					mAudio_list_icon
							.setBackgroundResource(R.drawable.allmenu_audio_nor);
					mVideo_list_icon
							.setBackgroundResource(R.drawable.allmenu_video_nor);
					mGallery_list_icon
							.setBackgroundResource(R.drawable.allmenu_dmb_nor);
					mInternet_list_icon
							.setBackgroundResource(R.drawable.allmenu_internet_nor);
					mSetting_list_icon
							.setBackgroundResource(R.drawable.allmenu_setting_nor);
					mClock_list_icon
							.setBackgroundResource(R.drawable.allmenu_phone_nor);

				}

			}
				break;
			case R.id.allmenu_audio: {

				if (hasFocus == true) {

					mRadio_list_icon
							.setBackgroundResource(R.drawable.allmenu_radio_nor);
					mAudio_list_icon
							.setBackgroundResource(R.drawable.allmenu_audio_foc);
					mVideo_list_icon
							.setBackgroundResource(R.drawable.allmenu_video_nor);
					mGallery_list_icon
							.setBackgroundResource(R.drawable.allmenu_dmb_nor);
					mInternet_list_icon
							.setBackgroundResource(R.drawable.allmenu_internet_nor);
					mSetting_list_icon
							.setBackgroundResource(R.drawable.allmenu_setting_nor);
					mClock_list_icon
							.setBackgroundResource(R.drawable.allmenu_phone_nor);

				}

			}
				break;

			case R.id.allmenu_video: {

				if (hasFocus == true) {

					mRadio_list_icon
							.setBackgroundResource(R.drawable.allmenu_radio_nor);
					mAudio_list_icon
							.setBackgroundResource(R.drawable.allmenu_audio_nor);
					mVideo_list_icon
							.setBackgroundResource(R.drawable.allmenu_video_foc);
					mGallery_list_icon
							.setBackgroundResource(R.drawable.allmenu_dmb_nor);
					mInternet_list_icon
							.setBackgroundResource(R.drawable.allmenu_internet_nor);
					mSetting_list_icon
							.setBackgroundResource(R.drawable.allmenu_setting_nor);
					mClock_list_icon
							.setBackgroundResource(R.drawable.allmenu_phone_nor);

				}

			}
				break;
			case R.id.allmenu_gallery: {

				if (hasFocus == true) {

					mRadio_list_icon
							.setBackgroundResource(R.drawable.allmenu_radio_nor);
					mAudio_list_icon
							.setBackgroundResource(R.drawable.allmenu_audio_nor);
					mVideo_list_icon
							.setBackgroundResource(R.drawable.allmenu_video_nor);
					mGallery_list_icon
							.setBackgroundResource(R.drawable.allmenu_dmb_foc);
					mInternet_list_icon
							.setBackgroundResource(R.drawable.allmenu_internet_nor);
					mSetting_list_icon
							.setBackgroundResource(R.drawable.allmenu_setting_nor);
					mClock_list_icon
							.setBackgroundResource(R.drawable.allmenu_phone_nor);
				}

			}
				break;
			case R.id.allmenu_internet: {

				if (hasFocus == true) {

					mRadio_list_icon
							.setBackgroundResource(R.drawable.allmenu_radio_nor);
					mAudio_list_icon
							.setBackgroundResource(R.drawable.allmenu_audio_nor);
					mVideo_list_icon
							.setBackgroundResource(R.drawable.allmenu_video_nor);
					mGallery_list_icon
							.setBackgroundResource(R.drawable.allmenu_dmb_nor);
					mInternet_list_icon
							.setBackgroundResource(R.drawable.allmenu_internet_foc);
					mSetting_list_icon
							.setBackgroundResource(R.drawable.allmenu_setting_nor);
					mClock_list_icon
							.setBackgroundResource(R.drawable.allmenu_phone_nor);

				}

			}
				break;
			case R.id.allmenu_setting: {

				if (hasFocus == true) {

					mRadio_list_icon
							.setBackgroundResource(R.drawable.allmenu_radio_nor);
					mAudio_list_icon
							.setBackgroundResource(R.drawable.allmenu_audio_nor);
					mVideo_list_icon
							.setBackgroundResource(R.drawable.allmenu_video_nor);
					mGallery_list_icon
							.setBackgroundResource(R.drawable.allmenu_dmb_nor);
					mInternet_list_icon
							.setBackgroundResource(R.drawable.allmenu_internet_nor);
					mSetting_list_icon
							.setBackgroundResource(R.drawable.allmenu_setting_foc);
					mClock_list_icon
							.setBackgroundResource(R.drawable.allmenu_phone_nor);

				}

			}
				break;
			case R.id.digital_clock: {

				if (hasFocus == true) {

					mRadio_list_icon
							.setBackgroundResource(R.drawable.allmenu_radio_nor);
					mAudio_list_icon
							.setBackgroundResource(R.drawable.allmenu_audio_nor);
					mVideo_list_icon
							.setBackgroundResource(R.drawable.allmenu_video_nor);
					mGallery_list_icon
							.setBackgroundResource(R.drawable.allmenu_dmb_nor);
					mInternet_list_icon
							.setBackgroundResource(R.drawable.allmenu_internet_nor);
					mSetting_list_icon
							.setBackgroundResource(R.drawable.allmenu_setting_nor);
					mClock_list_icon
							.setBackgroundResource(R.drawable.allmenu_phone_foc);

				}

			}
				break;
			}

		}
	}

	class HoverListenerClass implements View.OnHoverListener {

		public boolean onHover(View v, MotionEvent event) {
			switch (v.getId()) {
			case R.id.allmenu_radio:

				mRadio_list_icon
						.setBackgroundResource(R.drawable.allmenu_radio_foc);
				mAudio_list_icon
						.setBackgroundResource(R.drawable.allmenu_audio_nor);
				mVideo_list_icon
						.setBackgroundResource(R.drawable.allmenu_video_nor);
				mGallery_list_icon
						.setBackgroundResource(R.drawable.allmenu_dmb_nor);
				mInternet_list_icon
						.setBackgroundResource(R.drawable.allmenu_internet_nor);
				mSetting_list_icon
						.setBackgroundResource(R.drawable.allmenu_setting_nor);
				mClock_list_icon
						.setBackgroundResource(R.drawable.allmenu_phone_nor);

				break;
			case R.id.allmenu_audio:
				mRadio_list_icon
						.setBackgroundResource(R.drawable.allmenu_radio_nor);
				mAudio_list_icon
						.setBackgroundResource(R.drawable.allmenu_audio_foc);
				mVideo_list_icon
						.setBackgroundResource(R.drawable.allmenu_video_nor);
				mGallery_list_icon
						.setBackgroundResource(R.drawable.allmenu_dmb_nor);
				mInternet_list_icon
						.setBackgroundResource(R.drawable.allmenu_internet_nor);
				mSetting_list_icon
						.setBackgroundResource(R.drawable.allmenu_setting_nor);
				mClock_list_icon
						.setBackgroundResource(R.drawable.allmenu_phone_nor);

				break;
			case R.id.allmenu_video:
				mRadio_list_icon
						.setBackgroundResource(R.drawable.allmenu_radio_nor);
				mAudio_list_icon
						.setBackgroundResource(R.drawable.allmenu_audio_nor);
				mVideo_list_icon
						.setBackgroundResource(R.drawable.allmenu_video_foc);
				mGallery_list_icon
						.setBackgroundResource(R.drawable.allmenu_dmb_nor);
				mInternet_list_icon
						.setBackgroundResource(R.drawable.allmenu_internet_nor);
				mSetting_list_icon
						.setBackgroundResource(R.drawable.allmenu_setting_nor);
				mClock_list_icon
						.setBackgroundResource(R.drawable.allmenu_phone_nor);

				break;

			case R.id.allmenu_gallery:

				mRadio_list_icon
						.setBackgroundResource(R.drawable.allmenu_radio_nor);
				mAudio_list_icon
						.setBackgroundResource(R.drawable.allmenu_audio_nor);
				mVideo_list_icon
						.setBackgroundResource(R.drawable.allmenu_video_nor);
				mGallery_list_icon
						.setBackgroundResource(R.drawable.allmenu_dmb_foc);
				mInternet_list_icon
						.setBackgroundResource(R.drawable.allmenu_internet_nor);
				mSetting_list_icon
						.setBackgroundResource(R.drawable.allmenu_setting_nor);
				mClock_list_icon
						.setBackgroundResource(R.drawable.allmenu_phone_nor);

				break;
			case R.id.allmenu_internet:

				mRadio_list_icon
						.setBackgroundResource(R.drawable.allmenu_radio_nor);
				mAudio_list_icon
						.setBackgroundResource(R.drawable.allmenu_audio_nor);
				mVideo_list_icon
						.setBackgroundResource(R.drawable.allmenu_video_nor);
				mGallery_list_icon
						.setBackgroundResource(R.drawable.allmenu_dmb_nor);
				mInternet_list_icon
						.setBackgroundResource(R.drawable.allmenu_internet_foc);
				mSetting_list_icon
						.setBackgroundResource(R.drawable.allmenu_setting_nor);
				mClock_list_icon
						.setBackgroundResource(R.drawable.allmenu_phone_nor);

				break;
			case R.id.allmenu_setting:
				mRadio_list_icon
						.setBackgroundResource(R.drawable.allmenu_radio_nor);
				mAudio_list_icon
						.setBackgroundResource(R.drawable.allmenu_audio_nor);
				mVideo_list_icon
						.setBackgroundResource(R.drawable.allmenu_video_nor);
				mGallery_list_icon
						.setBackgroundResource(R.drawable.allmenu_dmb_nor);
				mInternet_list_icon
						.setBackgroundResource(R.drawable.allmenu_internet_nor);
				mSetting_list_icon
						.setBackgroundResource(R.drawable.allmenu_setting_foc);
				mClock_list_icon
						.setBackgroundResource(R.drawable.allmenu_phone_nor);
				break;
			case R.id.allmenu_clock:

				mRadio_list_icon
						.setBackgroundResource(R.drawable.allmenu_radio_nor);
				mAudio_list_icon
						.setBackgroundResource(R.drawable.allmenu_audio_nor);
				mVideo_list_icon
						.setBackgroundResource(R.drawable.allmenu_video_nor);
				mGallery_list_icon
						.setBackgroundResource(R.drawable.allmenu_dmb_nor);
				mInternet_list_icon
						.setBackgroundResource(R.drawable.allmenu_internet_nor);
				mSetting_list_icon
						.setBackgroundResource(R.drawable.allmenu_setting_nor);
				mClock_list_icon
						.setBackgroundResource(R.drawable.allmenu_phone_foc);
				break;

			}

			return true;
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		mlistView = (RelativeLayout) inflater.inflate(R.layout.listpage_layout,
				container, false);
		
		mFocusListener = new FocusListenerClass();
		mHoverListener = new HoverListenerClass();
		
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

		
		mRadio_list_icon.setOnHoverListener(mHoverListener);
		mRadio_list_icon.setOnClickListener(mButtonClick);
		mRadio_list_icon.setOnClickListener(mButtonClick);
		
		mAudio_list_icon.setOnHoverListener(mHoverListener);
		mAudio_list_icon.setOnClickListener(mButtonClick);
		mAudio_list_icon.setOnClickListener(mButtonClick);
		
		mVideo_list_icon.setOnHoverListener(mHoverListener);
		mVideo_list_icon.setOnClickListener(mButtonClick);
		mVideo_list_icon.setOnClickListener(mButtonClick);
		
		mGallery_list_icon.setOnHoverListener(mHoverListener);
		mGallery_list_icon.setOnClickListener(mButtonClick);
		mGallery_list_icon.setOnClickListener(mButtonClick);
		
		mInternet_list_icon.setOnHoverListener(mHoverListener);
		mInternet_list_icon.setOnClickListener(mButtonClick);
		mInternet_list_icon.setOnClickListener(mButtonClick);
		
		mSetting_list_icon.setOnHoverListener(mHoverListener);
		mSetting_list_icon.setOnClickListener(mButtonClick);
		mSetting_list_icon.setOnClickListener(mButtonClick);
		
		mClock_list_icon.setOnHoverListener(mHoverListener);
		mClock_list_icon.setOnClickListener(mButtonClick);
		mClock_list_icon.setOnClickListener(mButtonClick);
		
	
		return mlistView;
	}

}
