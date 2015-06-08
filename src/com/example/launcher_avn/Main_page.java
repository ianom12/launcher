package com.example.launcher_avn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Main_page extends Fragment {
	private View mV;

	private ImageView mRadioicon;
	private ImageView mAudioicon;
	private ImageView mVideoicon;
	private ImageView mGalleryicon;
	private ImageView mInterneticon;
	private ImageView mSettingicon;
	private ImageView mClockicon;
	private RelativeLayout mlayout;

	private RelativeLayout.LayoutParams radioparams;
	private RelativeLayout.LayoutParams audioparams;
	private RelativeLayout.LayoutParams videoparams;
	private RelativeLayout.LayoutParams galleryparams;
	private RelativeLayout.LayoutParams internetparams;
	private RelativeLayout.LayoutParams settingparams;
	private RelativeLayout.LayoutParams clockparams;

	private FocusListenerClass mFocusListener;
	private HoverListenerClass mHoverListener;

	private View mRadioWidget;
	private View mAudioWidget;
	private View mVideoWidget;
	private View mClockWidget;
	private ViewGroup mWidgetView;

	private final static int RADIOID = 10;
	private final static int AUDIOID = 20;
	private final static int VIDEOID = 30;
	private final static int GALLERYID = 40;
	private final static int INTERNETID = 50;
	private final static int SETTINGID = 60;
	private final static int CLOCKID = 70;

	private final static int RADIO_WIDGET = 1;
	private final static int AUDIO_WIDGET = 2;
	private final static int VIDEO_WIDGET = 3;

	TextView text;
	DisplayMetrics dm;
	int size;
	int select;
	
	private OnClickListener mButtonClick = new OnClickListener() {

		public void onClick(View v) {
			text = (TextView) getActivity().findViewById(R.id.View1);
			mRadioWidget = getActivity().findViewById(R.id.widget_radio);
			mAudioWidget = getActivity().findViewById(R.id.widget_audio);
			mVideoWidget = getActivity().findViewById(R.id.widget_video);
			mClockWidget = getActivity().findViewById(R.id.digital_clock);

			switch (v.getId()) {
			case RADIOID: {
				text.setText("IMAGE");
				mRadioWidget.setVisibility(View.VISIBLE);
				mAudioWidget.setVisibility(View.INVISIBLE);
				mVideoWidget.setVisibility(View.INVISIBLE);
				mClockWidget.setVisibility(View.INVISIBLE);
			}
				break;
			case AUDIOID: {
				select = 1;
				text.setText("AUDIO");
				mRadioWidget.setVisibility(View.INVISIBLE);
				mAudioWidget.setVisibility(View.VISIBLE);
				mVideoWidget.setVisibility(View.INVISIBLE);
				mClockWidget.setVisibility(View.INVISIBLE);
			}
				break;
			case VIDEOID: {
				text.setText("VIDEO");
				mRadioWidget.setVisibility(View.INVISIBLE);
				mAudioWidget.setVisibility(View.INVISIBLE);
				mVideoWidget.setVisibility(View.VISIBLE);
				mClockWidget.setVisibility(View.INVISIBLE);
			}
				break;
			case GALLERYID: {
				text.setText("GALLERY");
			}
				break;
			case INTERNETID: {
				text.setText("INTERNET");
			}

				break;
			case SETTINGID: {
				text.setText("SETTING");
			}
				break;
			case CLOCKID: {
				select = 0;
				text.setText("CLOCK");
				mRadioWidget.setVisibility(View.INVISIBLE);
				mAudioWidget.setVisibility(View.INVISIBLE);
				mVideoWidget.setVisibility(View.INVISIBLE);
				mClockWidget.setVisibility(View.VISIBLE);

			}
				break;
			}
			switch (select) {
			case 0:
				Intent i = new Intent();
				i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

				i.setClassName("com.example.clock_app",
						"com.example.clock_app.ClockMainActivity");
				startActivity(i);
				break;
			case CLOCKID:
				Intent imusic = new Intent();
				imusic.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				imusic.setClassName("com.android.music",
						"com.android.music.MusicBrowserActivity");
				startActivity(imusic);
				break;

			}

		}
	};
	
	class FocusListenerClass implements View.OnFocusChangeListener {

		public void onFocusChange(View v, boolean hasFocus) {
			// TODO Auto-generated method stub

			switch (v.getId()) {
			case RADIOID: {

				if (hasFocus == true) {

					mRadioicon
							.setBackgroundResource(R.drawable.main_btn_radio_foc);
					mAudioicon
							.setBackgroundResource(R.drawable.main_btn_audio_nor);
					mVideoicon
							.setBackgroundResource(R.drawable.main_btn_video_nor);
					mGalleryicon
							.setBackgroundResource(R.drawable.main_btn_dmb_nor);
					mInterneticon
							.setBackgroundResource(R.drawable.main_btn_internet_nor);
					mSettingicon
							.setBackgroundResource(R.drawable.main_btn_setting_nor);
					mClockicon
							.setBackgroundResource(R.drawable.main_btn_bt_nor);

				}

			}
				break;
			case AUDIOID: {

				if (hasFocus == true) {

					mRadioicon
							.setBackgroundResource(R.drawable.main_btn_radio_nor);
					mAudioicon
							.setBackgroundResource(R.drawable.main_btn_audio_foc);
					mVideoicon
							.setBackgroundResource(R.drawable.main_btn_video_nor);
					mGalleryicon
							.setBackgroundResource(R.drawable.main_btn_dmb_nor);
					mInterneticon
							.setBackgroundResource(R.drawable.main_btn_internet_nor);
					mSettingicon
							.setBackgroundResource(R.drawable.main_btn_setting_nor);
					mClockicon
							.setBackgroundResource(R.drawable.main_btn_bt_nor);

				}

			}
				break;

			case VIDEOID: {

				if (hasFocus == true) {

					mRadioicon
							.setBackgroundResource(R.drawable.main_btn_radio_nor);
					mAudioicon
							.setBackgroundResource(R.drawable.main_btn_audio_nor);
					mVideoicon
							.setBackgroundResource(R.drawable.main_btn_video_foc);
					mGalleryicon
							.setBackgroundResource(R.drawable.main_btn_dmb_nor);
					mInterneticon
							.setBackgroundResource(R.drawable.main_btn_internet_nor);
					mSettingicon
							.setBackgroundResource(R.drawable.main_btn_setting_nor);
					mClockicon
							.setBackgroundResource(R.drawable.main_btn_bt_nor);

				}

			}
				break;
			case GALLERYID: {

				if (hasFocus == true) {

					mRadioicon
							.setBackgroundResource(R.drawable.main_btn_radio_nor);
					mAudioicon
							.setBackgroundResource(R.drawable.main_btn_audio_nor);
					mVideoicon
							.setBackgroundResource(R.drawable.main_btn_video_nor);
					mGalleryicon
							.setBackgroundResource(R.drawable.main_btn_dmb_foc);
					mInterneticon
							.setBackgroundResource(R.drawable.main_btn_internet_nor);
					mSettingicon
							.setBackgroundResource(R.drawable.main_btn_setting_nor);
					mClockicon
							.setBackgroundResource(R.drawable.main_btn_bt_nor);
				}

			}
				break;
			case INTERNETID: {

				if (hasFocus == true) {

					mRadioicon
							.setBackgroundResource(R.drawable.main_btn_radio_nor);
					mAudioicon
							.setBackgroundResource(R.drawable.main_btn_audio_nor);
					mVideoicon
							.setBackgroundResource(R.drawable.main_btn_video_nor);
					mGalleryicon
							.setBackgroundResource(R.drawable.main_btn_dmb_nor);
					mInterneticon
							.setBackgroundResource(R.drawable.main_btn_internet_foc);
					mSettingicon
							.setBackgroundResource(R.drawable.main_btn_setting_nor);
					mClockicon
							.setBackgroundResource(R.drawable.main_btn_bt_nor);

				}

			}
				break;
			case SETTINGID: {

				if (hasFocus == true) {

					mRadioicon
							.setBackgroundResource(R.drawable.main_btn_radio_nor);
					mAudioicon
							.setBackgroundResource(R.drawable.main_btn_audio_nor);
					mVideoicon
							.setBackgroundResource(R.drawable.main_btn_video_nor);
					mGalleryicon
							.setBackgroundResource(R.drawable.main_btn_dmb_nor);
					mInterneticon
							.setBackgroundResource(R.drawable.main_btn_internet_nor);
					mSettingicon
							.setBackgroundResource(R.drawable.main_btn_setting_foc);
					mClockicon
							.setBackgroundResource(R.drawable.main_btn_bt_nor);

				}

			}
				break;
			case CLOCKID: {

				if (hasFocus == true) {

					mRadioicon
							.setBackgroundResource(R.drawable.main_btn_radio_nor);
					mAudioicon
							.setBackgroundResource(R.drawable.main_btn_audio_nor);
					mVideoicon
							.setBackgroundResource(R.drawable.main_btn_video_nor);
					mGalleryicon
							.setBackgroundResource(R.drawable.main_btn_dmb_nor);
					mInterneticon
							.setBackgroundResource(R.drawable.main_btn_internet_nor);
					mSettingicon
							.setBackgroundResource(R.drawable.main_btn_setting_nor);
					mClockicon
							.setBackgroundResource(R.drawable.main_btn_bt_foc);

				}

			}
				break;
			}

		}
	}

	class HoverListenerClass implements View.OnHoverListener {

		public boolean onHover(View v, MotionEvent event) {
			switch (v.getId()) {
			case RADIOID:
				mRadioicon.setBackgroundResource(R.drawable.main_btn_radio_foc);
				mAudioicon.setBackgroundResource(R.drawable.main_btn_audio_nor);
				mVideoicon.setBackgroundResource(R.drawable.main_btn_video_nor);
				mGalleryicon.setBackgroundResource(R.drawable.main_btn_dmb_nor);
				mInterneticon
						.setBackgroundResource(R.drawable.main_btn_internet_nor);
				mSettingicon
						.setBackgroundResource(R.drawable.main_btn_setting_nor);
				mClockicon.setBackgroundResource(R.drawable.main_btn_bt_nor);

				break;
			case AUDIOID:
				mRadioicon.setBackgroundResource(R.drawable.main_btn_radio_nor);
				mAudioicon.setBackgroundResource(R.drawable.main_btn_audio_foc);
				mVideoicon.setBackgroundResource(R.drawable.main_btn_video_nor);
				mGalleryicon.setBackgroundResource(R.drawable.main_btn_dmb_nor);
				mInterneticon
						.setBackgroundResource(R.drawable.main_btn_internet_nor);
				mSettingicon
						.setBackgroundResource(R.drawable.main_btn_setting_nor);
				mClockicon.setBackgroundResource(R.drawable.main_btn_bt_nor);

				break;
			case VIDEOID:
				mRadioicon.setBackgroundResource(R.drawable.main_btn_radio_nor);
				mAudioicon.setBackgroundResource(R.drawable.main_btn_audio_nor);
				mVideoicon.setBackgroundResource(R.drawable.main_btn_video_foc);
				mGalleryicon.setBackgroundResource(R.drawable.main_btn_dmb_nor);
				mInterneticon
						.setBackgroundResource(R.drawable.main_btn_internet_nor);
				mSettingicon
						.setBackgroundResource(R.drawable.main_btn_setting_nor);
				mClockicon.setBackgroundResource(R.drawable.main_btn_bt_nor);

				break;

			case GALLERYID:
				mRadioicon.setBackgroundResource(R.drawable.main_btn_radio_nor);
				mAudioicon.setBackgroundResource(R.drawable.main_btn_audio_nor);
				mVideoicon.setBackgroundResource(R.drawable.main_btn_video_nor);
				mGalleryicon.setBackgroundResource(R.drawable.main_btn_dmb_foc);
				mInterneticon
						.setBackgroundResource(R.drawable.main_btn_internet_nor);
				mSettingicon
						.setBackgroundResource(R.drawable.main_btn_setting_nor);
				mClockicon.setBackgroundResource(R.drawable.main_btn_bt_nor);

				break;
			case INTERNETID:

				mRadioicon.setBackgroundResource(R.drawable.main_btn_radio_nor);
				mAudioicon.setBackgroundResource(R.drawable.main_btn_audio_nor);
				mVideoicon.setBackgroundResource(R.drawable.main_btn_video_nor);
				mGalleryicon.setBackgroundResource(R.drawable.main_btn_dmb_nor);
				mInterneticon
						.setBackgroundResource(R.drawable.main_btn_internet_foc);
				mSettingicon
						.setBackgroundResource(R.drawable.main_btn_setting_nor);
				mClockicon.setBackgroundResource(R.drawable.main_btn_bt_nor);

				break;
			case SETTINGID:
				mRadioicon.setBackgroundResource(R.drawable.main_btn_radio_nor);
				mAudioicon.setBackgroundResource(R.drawable.main_btn_audio_nor);
				mVideoicon.setBackgroundResource(R.drawable.main_btn_video_nor);
				mGalleryicon.setBackgroundResource(R.drawable.main_btn_dmb_nor);
				mInterneticon
						.setBackgroundResource(R.drawable.main_btn_internet_nor);
				mSettingicon
						.setBackgroundResource(R.drawable.main_btn_setting_foc);
				mClockicon.setBackgroundResource(R.drawable.main_btn_bt_nor);
				break;
			case CLOCKID:

				mRadioicon.setBackgroundResource(R.drawable.main_btn_radio_nor);
				mAudioicon.setBackgroundResource(R.drawable.main_btn_audio_nor);
				mVideoicon.setBackgroundResource(R.drawable.main_btn_video_nor);
				mGalleryicon.setBackgroundResource(R.drawable.main_btn_dmb_nor);
				mInterneticon
						.setBackgroundResource(R.drawable.main_btn_internet_nor);
				mSettingicon
						.setBackgroundResource(R.drawable.main_btn_setting_nor);
				mClockicon.setBackgroundResource(R.drawable.main_btn_bt_foc);
				break;

			}

			return true;
		}
	}



	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mV = (RelativeLayout) inflater.inflate(R.layout.mainpage_layout,
				container, false);
		dm = getResources().getDisplayMetrics();

		mlayout = (RelativeLayout) mV.findViewById(R.id.main_page);
		mWidgetView = (ViewGroup) mV.findViewById(R.id.widget_layout);

		mFocusListener = new FocusListenerClass();
		mHoverListener = new HoverListenerClass();

		createBtn();

		mWidgetView.setOnClickListener(mButtonClick);
		mRadioicon.setOnFocusChangeListener(mFocusListener);
		mRadioicon.setOnHoverListener(mHoverListener);
		mRadioicon.setOnClickListener(mButtonClick);
		mRadioicon.requestFocus();

		mAudioicon.setOnFocusChangeListener(mFocusListener);
		mAudioicon.setOnHoverListener(mHoverListener);
		mAudioicon.setOnClickListener(mButtonClick);

		mVideoicon.setOnFocusChangeListener(mFocusListener);
		mVideoicon.setOnHoverListener(mHoverListener);
		mVideoicon.setOnClickListener(mButtonClick);

		mGalleryicon.setOnFocusChangeListener(mFocusListener);
		mGalleryicon.setOnClickListener(mButtonClick);
		mGalleryicon.setOnHoverListener(mHoverListener);

		mInterneticon.setOnFocusChangeListener(mFocusListener);
		mInterneticon.setOnHoverListener(mHoverListener);
		mInterneticon.setOnClickListener(mButtonClick);

		mSettingicon.setOnFocusChangeListener(mFocusListener);
		mSettingicon.setOnHoverListener(mHoverListener);
		mSettingicon.setOnClickListener(mButtonClick);

		mClockicon.setOnFocusChangeListener(mFocusListener);
		mClockicon.setOnHoverListener(mHoverListener);
		mClockicon.setOnClickListener(mButtonClick);

		return mV;

	}

	public void createBtn() {
		mRadioicon = new ImageView(getActivity());
		mAudioicon = new ImageView(getActivity());
		mVideoicon = new ImageView(getActivity());
		mGalleryicon = new ImageView(getActivity());
		mInterneticon = new ImageView(getActivity());
		mSettingicon = new ImageView(getActivity());
		mClockicon = new ImageView(getActivity());

		mRadioicon.setId(RADIOID);
		mRadioicon.setBackgroundResource(R.drawable.main_btn_radio_nor);
		radioparams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		size = Math.round(5 * dm.density);
		radioparams.topMargin = size;
		size = Math.round(440 * dm.density);
		radioparams.leftMargin = size;
		mRadioicon.setLayoutParams(radioparams);
		mlayout.addView(mRadioicon);

		mAudioicon.setId(AUDIOID);
		mAudioicon.setBackgroundResource(R.drawable.main_btn_audio_nor);
		audioparams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		size = Math.round(15 * dm.density);
		audioparams.topMargin = size;
		size = Math.round(665 * dm.density);
		audioparams.leftMargin = size;
		mAudioicon.setLayoutParams(audioparams);
		mlayout.addView(mAudioicon);

		mVideoicon.setId(VIDEOID);
		mVideoicon.setBackgroundResource(R.drawable.main_btn_video_nor);
		videoparams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		size = Math.round(105 * dm.density);
		videoparams.topMargin = size;
		size = Math.round(820 * dm.density);
		videoparams.leftMargin = size;
		mVideoicon.setLayoutParams(videoparams);
		mlayout.addView(mVideoicon);

		mGalleryicon.setId(GALLERYID);
		mGalleryicon.setBackgroundResource(R.drawable.main_btn_dmb_nor);
		galleryparams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		size = Math.round(230 * dm.density);
		galleryparams.topMargin = size;
		size = Math.round(690 * dm.density);
		galleryparams.leftMargin = size;
		mGalleryicon.setLayoutParams(galleryparams);
		mlayout.addView(mGalleryicon);

		mInterneticon.setId(INTERNETID);
		mInterneticon.setBackgroundResource(R.drawable.main_btn_internet_nor);
		internetparams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		size = Math.round(260 * dm.density);
		internetparams.topMargin = size;
		size = Math.round(440 * dm.density);
		internetparams.leftMargin = size;
		mInterneticon.setLayoutParams(internetparams);
		mlayout.addView(mInterneticon);

		mSettingicon.setId(SETTINGID);
		mSettingicon.setBackgroundResource(R.drawable.main_btn_setting_nor);
		settingparams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		size = Math.round(230 * dm.density);
		settingparams.topMargin = size;
		size = Math.round(165 * dm.density);
		settingparams.leftMargin = size;
		mSettingicon.setLayoutParams(settingparams);
		mlayout.addView(mSettingicon);

		mClockicon.setId(CLOCKID);
		mClockicon.setBackgroundResource(R.drawable.main_btn_bt_nor);
		clockparams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		size = Math.round(105 * dm.density);
		clockparams.topMargin = size;
		size = Math.round(50 * dm.density);
		clockparams.leftMargin = size;
		mClockicon.setLayoutParams(clockparams);
		mlayout.addView(mClockicon);
	}

}
