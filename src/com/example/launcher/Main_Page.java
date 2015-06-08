package com.example.launcher;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Main_Page extends Fragment {

	private View mV;

	private ImageView mRadioicon;
	private ImageView mAudioicon;
	private ImageView mVideoicon;
	private ImageView mGalleryicon;
	private ImageView mInterneticon;
	private ImageView mSettingicon;
	private ImageView mClockicon;
	private RelativeLayout mlayout;
	private RelativeLayout mlayout1;

	private CheckBox mRadio_Chkbox;
	private CheckBox mAudio_Chkbox;
	private CheckBox mVideo_Chkbox;
	private CheckBox mGallery_Chkbox;
	private CheckBox mInternet_Chkbox;
	private CheckBox mSetting_Chkbox;
	private CheckBox mClock_Chkbox;

	private RelativeLayout.LayoutParams radioparams;
	private RelativeLayout.LayoutParams audioparams;
	private RelativeLayout.LayoutParams videoparams;
	private RelativeLayout.LayoutParams galleryparams;
	private RelativeLayout.LayoutParams internetparams;
	private RelativeLayout.LayoutParams settingparams;
	private RelativeLayout.LayoutParams clockparams;
	private RelativeLayout.LayoutParams params;

	private RelativeLayout.LayoutParams radio_chk_params;
	private RelativeLayout.LayoutParams audio_chk_params;
	private RelativeLayout.LayoutParams video_chk_params;
	private RelativeLayout.LayoutParams gallery_chk_params;
	private RelativeLayout.LayoutParams internet_chk_params;
	private RelativeLayout.LayoutParams setting_chk_params;
	private RelativeLayout.LayoutParams clock_chk_params;

	private FocusListenerClass mFocusListener;
	private HoverListenerClass mHoverListener;

	private View mRadioWidget;
	private View mAudioWidget;
	private View mVideoWidget;
	private View mClockWidget;
	private ViewGroup mWidgetView;

	private final static int RADIO_ID = 0x01;
	private final static int AUDIO_ID = 0x02;
	private final static int VIDEO_ID = 0x03;
	private final static int GALLERY_ID = 0x04;
	private final static int INTERNET_ID = 0x05;
	private final static int SETTING_ID = 0x06;
	private final static int CLOCK_ID = 0x07;

	private final static int RADIO_CHK_ID = 0x11;
	private final static int AUDIO_CHK_ID = 0x22;
	private final static int VIDEO_CHK_ID = 0x33;
	private final static int GALLERY_CHK_ID = 0x44;
	private final static int INTERNET_CHK_ID = 0x55;
	private final static int SETTING_CHK_ID = 0x66;
	private final static int CLOCK_CHK_ID = 0x77;

	private final static int RADIO_WIDGET = 0x21;
	private final static int AUDIO_WIDGET = 0x22;
	private final static int VIDEO_WIDGET = 0x23;

	private final static int TOP = 0;
	private final static int LEFT = 1;

	private boolean mbradio_chk;
	private boolean mbaudio_chk;
	private boolean mbvideo_chk;
	private boolean mbgallery_chk;
	private boolean mbinternet_chk;
	private boolean mbsetting_chk;
	private boolean mbclock_chk;

	// icon top,left margin 값을 저장하는 배열

	private int[] iRadio_Icon_Margin = new int[2];
	private int[] iAudio_Icon_Margin = new int[2];
	private int[] iVideo_Icon_Margin = new int[2];
	private int[] iGallery_Icon_Margin = new int[2];
	private int[] iInternet_Icon_Margin = new int[2];
	private int[] iSetting_Icon_Margin = new int[2];
	private int[] iClock_Icon_Margin = new int[2];

	private int[] iRadio_Chk_Margin = new int[2];
	private int[] iAudio_Chk_Margin = new int[2];
	private int[] iVideo_Chk_Margin = new int[2];
	private int[] iGallery_Chk_Margin = new int[2];
	private int[] iInternet_Chk_Margin = new int[2];
	private int[] iSetting_Chk_Margin = new int[2];
	private int[] iClock_Chk_Margin = new int[2];

	Button deleteBtn;
	Button completeBtn;
	TextView text;
	DisplayMetrics dm;
	ImageView view;
	int select;

	private OnClickListener mButtonClick = new OnClickListener() {

		public void onClick(View v) {
			text = (TextView) getActivity().findViewById(R.id.View1);
			mRadioWidget = getActivity().findViewById(R.id.widget_radio);
			mAudioWidget = getActivity().findViewById(R.id.widget_audio);
			mVideoWidget = getActivity().findViewById(R.id.widget_video);
			mClockWidget = getActivity().findViewById(R.id.digital_clock);

			switch (v.getId()) {
			case RADIO_ID: {
				text.setText("IMAGE");
				mRadioWidget.setVisibility(View.VISIBLE);
				mAudioWidget.setVisibility(View.INVISIBLE);
				mVideoWidget.setVisibility(View.INVISIBLE);
				mClockWidget.setVisibility(View.INVISIBLE);
			}
				break;
			case AUDIO_ID: {
				select = 1;
				text.setText("AUDIO");
				mRadioWidget.setVisibility(View.INVISIBLE);
				mAudioWidget.setVisibility(View.VISIBLE);
				mVideoWidget.setVisibility(View.INVISIBLE);
				mClockWidget.setVisibility(View.INVISIBLE);
			}
				break;
			case VIDEO_ID: {
				text.setText("VIDEO");
				mRadioWidget.setVisibility(View.INVISIBLE);
				mAudioWidget.setVisibility(View.INVISIBLE);
				mVideoWidget.setVisibility(View.VISIBLE);
				mClockWidget.setVisibility(View.INVISIBLE);
			}
				break;
			case GALLERY_ID: {
				text.setText("GALLERY");
			}
				break;
			case INTERNET_ID: {
				text.setText("INTERNET");
			}

				break;
			case SETTING_ID: {
				text.setText("SETTING");
			}
				break;
			case CLOCK_ID: {
				select = 0;
				text.setText("CLOCK");
				mRadioWidget.setVisibility(View.INVISIBLE);
				mAudioWidget.setVisibility(View.INVISIBLE);
				mVideoWidget.setVisibility(View.INVISIBLE);
				mClockWidget.setVisibility(View.VISIBLE);

			}
				break;
			case R.id.chkdeletebtn: {
				mlayout1.setVisibility(View.VISIBLE);
				if (mRadio_Chkbox.isChecked() == false) {
					mRadio_Chkbox.setVisibility(View.VISIBLE);
				}
				if (mAudio_Chkbox.isChecked() == false) {
					mAudio_Chkbox.setVisibility(View.VISIBLE);
				}
				if (mVideo_Chkbox.isChecked() == false) {

					mVideo_Chkbox.setVisibility(View.VISIBLE);
				}
				if (mGallery_Chkbox.isChecked() == false) {

					mGallery_Chkbox.setVisibility(View.VISIBLE);
				}
				if (mInternet_Chkbox.isChecked() == false) {

					mInternet_Chkbox.setVisibility(View.VISIBLE);
				}
				if (mSetting_Chkbox.isChecked() == false) {

					mSetting_Chkbox.setVisibility(View.VISIBLE);
				}
				if (mClock_Chkbox.isChecked() == false) {

					mClock_Chkbox.setVisibility(View.VISIBLE);
				}

				deleteBtn.setVisibility(View.INVISIBLE);
				completeBtn.setVisibility(View.VISIBLE);
				text.setText("삭제");

			}
				break;
			case R.id.chkcompletebtn: {
				mlayout1.setVisibility(View.GONE);
				mRadio_Chkbox.setVisibility(View.INVISIBLE);
				mAudio_Chkbox.setVisibility(View.INVISIBLE);
				mVideo_Chkbox.setVisibility(View.INVISIBLE);
				mGallery_Chkbox.setVisibility(View.INVISIBLE);
				mInternet_Chkbox.setVisibility(View.INVISIBLE);
				mSetting_Chkbox.setVisibility(View.INVISIBLE);
				mClock_Chkbox.setVisibility(View.INVISIBLE);
				deleteBtn.setVisibility(View.VISIBLE);
				completeBtn.setVisibility(View.INVISIBLE);
				if (mRadio_Chkbox.isChecked()) {
					mRadioicon.setVisibility(View.INVISIBLE);

				}

				if (mAudio_Chkbox.isChecked()) {
					mAudioicon.setVisibility(View.INVISIBLE);

				}
				if (mVideo_Chkbox.isChecked()) {
					mVideoicon.setVisibility(View.INVISIBLE);

				}
				if (mGallery_Chkbox.isChecked()) {
					mGalleryicon.setVisibility(View.INVISIBLE);

				}
				if (mInternet_Chkbox.isChecked()) {
					mInterneticon.setVisibility(View.INVISIBLE);

				}
				if (mSetting_Chkbox.isChecked()) {
					mSettingicon.setVisibility(View.INVISIBLE);

				}
				if (mClock_Chkbox.isChecked()) {
					mClockicon.setVisibility(View.INVISIBLE);

				}
				text.setText("완료");
			}

				break;
			}
			/*
			 * switch (select) { case 0: Intent i = new Intent();
			 * i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			 * 
			 * i.setClassName("com.example.clock_app",
			 * "com.example.clock_app.ClockMainActivity"); startActivity(i);
			 * break; case CLOCKID: Intent imusic = new Intent();
			 * imusic.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			 * imusic.setClassName("com.android.music",
			 * "com.android.music.MusicBrowserActivity"); startActivity(imusic);
			 * break;
			 * 
			 * }
			 */

		}
	};

	class FocusListenerClass implements View.OnFocusChangeListener {

		public void onFocusChange(View v, boolean hasFocus) {
			// TODO Auto-generated method stub

			switch (v.getId()) {
			case RADIO_ID: {

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
			case AUDIO_ID: {

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

			case VIDEO_ID: {

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
			case GALLERY_ID: {

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
			case INTERNET_ID: {

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
			case SETTING_ID: {

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
			case CLOCK_ID: {

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
			case RADIO_ID:
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
			case AUDIO_ID:
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
			case VIDEO_ID:
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

			case GALLERY_ID:
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
			case INTERNET_ID:

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
			case SETTING_ID:
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
			case CLOCK_ID:

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

		mV = (RelativeLayout) inflater.inflate(R.layout.mainpage_layout,
				container, false);
		dm = getResources().getDisplayMetrics();

		mlayout = (RelativeLayout) mV.findViewById(R.id.main_page);
		mlayout1 = new RelativeLayout(getActivity());
		mlayout1.setBackgroundColor(Color.parseColor("#44FFFFFF"));

		params = new RelativeLayout.LayoutParams(900,700);
		mlayout1.setLayoutParams(params);
		mlayout.addView(mlayout1);
		mlayout1.setVisibility(View.GONE);

		mWidgetView = (ViewGroup) mV.findViewById(R.id.widget_layout);

		mFocusListener = new FocusListenerClass();
		mHoverListener = new HoverListenerClass();

		deleteBtn = (Button) mV.findViewById(R.id.chkdeletebtn);
		completeBtn = (Button) mV.findViewById(R.id.chkcompletebtn);
		deleteBtn.setOnClickListener(mButtonClick);
		completeBtn.setOnClickListener(mButtonClick);
		createIcon();
		createChkBox();

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

	public void createChkBox() {
		mRadio_Chkbox = new CheckBox(getActivity());
		mAudio_Chkbox = new CheckBox(getActivity());
		mVideo_Chkbox = new CheckBox(getActivity());
		mGallery_Chkbox = new CheckBox(getActivity());
		mInternet_Chkbox = new CheckBox(getActivity());
		mSetting_Chkbox = new CheckBox(getActivity());
		mClock_Chkbox = new CheckBox(getActivity());

		mRadio_Chkbox.setId(RADIO_CHK_ID);
		radio_chk_params = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		iRadio_Chk_Margin[TOP] = Math.round(12 * dm.density);
		radio_chk_params.topMargin = iRadio_Chk_Margin[TOP];
		iRadio_Chk_Margin[LEFT] = Math.round(575 * dm.density);
		radio_chk_params.leftMargin = iRadio_Chk_Margin[LEFT];
		mRadio_Chkbox.setLayoutParams(radio_chk_params);
		mlayout.addView(mRadio_Chkbox);
		mRadio_Chkbox.setVisibility(View.INVISIBLE);
		mRadio_Chkbox.setChecked(false);

		mAudio_Chkbox.setId(AUDIO_CHK_ID);
		audio_chk_params = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		iAudio_Chk_Margin[TOP] = Math.round(19 * dm.density);
		audio_chk_params.topMargin = iAudio_Chk_Margin[TOP];
		iAudio_Chk_Margin[LEFT] = Math.round(800 * dm.density);
		audio_chk_params.leftMargin = iAudio_Chk_Margin[LEFT];
		mAudio_Chkbox.setLayoutParams(audio_chk_params);
		mlayout.addView(mAudio_Chkbox);
		mAudio_Chkbox.setVisibility(View.INVISIBLE);
		mAudio_Chkbox.setChecked(false);

		mVideo_Chkbox.setId(VIDEO_CHK_ID);
		video_chk_params = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		iVideo_Chk_Margin[TOP] = Math.round(110 * dm.density);
		video_chk_params.topMargin = iVideo_Chk_Margin[TOP];
		iVideo_Chk_Margin[LEFT] = Math.round(950 * dm.density);
		video_chk_params.leftMargin = iVideo_Chk_Margin[LEFT];
		mVideo_Chkbox.setLayoutParams(video_chk_params);
		mlayout.addView(mVideo_Chkbox);
		mVideo_Chkbox.setVisibility(View.INVISIBLE);
		mVideo_Chkbox.setChecked(false);

		mGallery_Chkbox.setId(GALLERY_CHK_ID);
		gallery_chk_params = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		iGallery_Chk_Margin[TOP] = Math.round(235 * dm.density);
		gallery_chk_params.topMargin = iGallery_Chk_Margin[TOP];
		iGallery_Chk_Margin[LEFT] = Math.round(820 * dm.density);
		gallery_chk_params.leftMargin = iGallery_Chk_Margin[LEFT];
		mGallery_Chkbox.setLayoutParams(gallery_chk_params);
		mlayout.addView(mGallery_Chkbox);
		mGallery_Chkbox.setVisibility(View.INVISIBLE);
		mGallery_Chkbox.setChecked(false);

		mInternet_Chkbox.setId(INTERNET_CHK_ID);
		internet_chk_params = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		iInternet_Chk_Margin[TOP] = Math.round(265 * dm.density);
		internet_chk_params.topMargin = iInternet_Chk_Margin[TOP];
		iInternet_Chk_Margin[LEFT] = Math.round(600 * dm.density);
		internet_chk_params.leftMargin = iInternet_Chk_Margin[LEFT];
		mInternet_Chkbox.setLayoutParams(internet_chk_params);
		mlayout.addView(mInternet_Chkbox);
		mInternet_Chkbox.setVisibility(View.INVISIBLE);
		mInternet_Chkbox.setChecked(false);

		mSetting_Chkbox.setId(SETTING_ID);
		setting_chk_params = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		iSetting_Chk_Margin[TOP] = Math.round(240 * dm.density);
		setting_chk_params.topMargin = iSetting_Chk_Margin[TOP];
		iSetting_Chk_Margin[LEFT] = Math.round(310 * dm.density);
		setting_chk_params.leftMargin = iSetting_Chk_Margin[LEFT];
		mSetting_Chkbox.setLayoutParams(setting_chk_params);
		mlayout.addView(mSetting_Chkbox);
		mSetting_Chkbox.setVisibility(View.INVISIBLE);
		mSetting_Chkbox.setChecked(false);

		mClock_Chkbox.setId(CLOCK_CHK_ID);
		clock_chk_params = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		iClock_Chk_Margin[TOP] = Math.round(110 * dm.density);
		clock_chk_params.topMargin = iClock_Chk_Margin[TOP];
		iClock_Chk_Margin[LEFT] = Math.round(180 * dm.density);
		clock_chk_params.leftMargin = iClock_Chk_Margin[LEFT];
		mClock_Chkbox.setLayoutParams(clock_chk_params);
		mlayout.addView(mClock_Chkbox);
		mClock_Chkbox.setVisibility(View.INVISIBLE);
		mClock_Chkbox.setChecked(false);
	}

	public void createIcon() {
		mRadioicon = new ImageView(getActivity());
		mAudioicon = new ImageView(getActivity());
		mVideoicon = new ImageView(getActivity());
		mGalleryicon = new ImageView(getActivity());
		mInterneticon = new ImageView(getActivity());
		mSettingicon = new ImageView(getActivity());
		mClockicon = new ImageView(getActivity());

		mRadioicon.setId(RADIO_ID);
		mRadioicon.setBackgroundResource(R.drawable.main_btn_radio_nor);
		radioparams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		iRadio_Icon_Margin[TOP] = Math.round(5 * dm.density);
		radioparams.topMargin = iRadio_Icon_Margin[0];
		iRadio_Icon_Margin[LEFT] = Math.round(440 * dm.density);
		radioparams.leftMargin = iRadio_Icon_Margin[1];
		mRadioicon.setLayoutParams(radioparams);
		mlayout.addView(mRadioicon);

		mAudioicon.setId(AUDIO_ID);
		mAudioicon.setBackgroundResource(R.drawable.main_btn_audio_nor);
		audioparams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		iAudio_Icon_Margin[TOP] = Math.round(15 * dm.density);
		audioparams.topMargin = iAudio_Icon_Margin[0];
		iAudio_Icon_Margin[LEFT] = Math.round(665 * dm.density);
		audioparams.leftMargin = iAudio_Icon_Margin[1];
		mAudioicon.setLayoutParams(audioparams);
		mlayout.addView(mAudioicon);

		mVideoicon.setId(VIDEO_ID);
		mVideoicon.setBackgroundResource(R.drawable.main_btn_video_nor);
		videoparams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		iVideo_Icon_Margin[TOP] = Math.round(105 * dm.density);
		videoparams.topMargin = iVideo_Icon_Margin[TOP];
		iVideo_Icon_Margin[LEFT] = Math.round(820 * dm.density);
		videoparams.leftMargin = iVideo_Icon_Margin[LEFT];
		mVideoicon.setLayoutParams(videoparams);
		mlayout.addView(mVideoicon);

		mGalleryicon.setId(GALLERY_ID);
		mGalleryicon.setBackgroundResource(R.drawable.main_btn_dmb_nor);
		galleryparams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		iGallery_Icon_Margin[TOP] = Math.round(230 * dm.density);
		galleryparams.topMargin = iGallery_Icon_Margin[TOP];
		iGallery_Icon_Margin[LEFT] = Math.round(690 * dm.density);
		galleryparams.leftMargin = iGallery_Icon_Margin[LEFT];
		mGalleryicon.setLayoutParams(galleryparams);
		mlayout.addView(mGalleryicon);

		mInterneticon.setId(INTERNET_ID);
		mInterneticon.setBackgroundResource(R.drawable.main_btn_internet_nor);
		internetparams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		iInternet_Icon_Margin[TOP] = Math.round(260 * dm.density);
		internetparams.topMargin = iInternet_Icon_Margin[TOP];
		iInternet_Icon_Margin[LEFT] = Math.round(440 * dm.density);
		internetparams.leftMargin = iInternet_Icon_Margin[LEFT];
		mInterneticon.setLayoutParams(internetparams);
		mlayout.addView(mInterneticon);

		mSettingicon.setId(SETTING_ID);
		mSettingicon.setBackgroundResource(R.drawable.main_btn_setting_nor);
		settingparams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		iSetting_Icon_Margin[TOP] = Math.round(230 * dm.density);
		settingparams.topMargin = iSetting_Icon_Margin[TOP];
		iSetting_Icon_Margin[LEFT] = Math.round(165 * dm.density);
		settingparams.leftMargin = iSetting_Icon_Margin[LEFT];
		mSettingicon.setLayoutParams(settingparams);
		mlayout.addView(mSettingicon);

		mClockicon.setId(CLOCK_ID);
		mClockicon.setBackgroundResource(R.drawable.main_btn_bt_nor);
		clockparams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		iClock_Icon_Margin[TOP] = Math.round(105 * dm.density);
		clockparams.topMargin = iClock_Icon_Margin[TOP];
		iClock_Icon_Margin[LEFT] = Math.round(50 * dm.density);
		clockparams.leftMargin = iClock_Icon_Margin[LEFT];
		mClockicon.setLayoutParams(clockparams);
		mlayout.addView(mClockicon);
	}

}
