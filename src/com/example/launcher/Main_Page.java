package com.example.launcher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main_Page extends Fragment {

	private View mV;

	private View mRadioicon;
	private View mAudioicon;
	private View mVideoicon;
	private View mGalleryicon;
	private View mInterneticon;
	private View mSettingicon;
	private View mClockicon;

	private View mRadioicon_Custom;
	private View mAudioicon_Custom;
	private View mVideoicon_Custom;
	private View mGalleryicon_Custom;
	private View mInterneticon_Custom;
	private View mSettingicon_Custom;
	private View mClockicon_Custom;

	private RelativeLayout mlayout;

	private RelativeLayout.LayoutParams radioparams;
	private RelativeLayout.LayoutParams audioparams;
	private RelativeLayout.LayoutParams videoparams;
	private RelativeLayout.LayoutParams galleryparams;
	private RelativeLayout.LayoutParams internetparams;
	private RelativeLayout.LayoutParams settingparams;
	private RelativeLayout.LayoutParams clockparams;

	private RelativeLayout.LayoutParams postionparams1;
	private RelativeLayout.LayoutParams postionparams2;
	private RelativeLayout.LayoutParams postionparams3;
	private RelativeLayout.LayoutParams postionparams4;
	private RelativeLayout.LayoutParams postionparams5;
	private RelativeLayout.LayoutParams postionparams6;
	private RelativeLayout.LayoutParams postionparams7;
	private RelativeLayout.LayoutParams postionparams8;

	private View mRadioWidget;
	private View mAudioWidget;
	private View mVideoWidget;
	private View mClockWidget;
	private ViewGroup mWidgetView;

	private final static int RADIO_ID = 1;
	private final static int CUSTOM_RADIO_ID = 11;
	private final static int AUDIO_ID = 2;
	private final static int CUSTOM_AUDIO_ID = 22;
	private final static int VIDEO_ID = 3;
	private final static int CUSTOM_VIDEO_ID = 33;
	private final static int GALLERY_ID = 4;
	private final static int CUSTOM_GALLERY_ID = 44;
	private final static int INTERNET_ID = 5;
	private final static int CUSTOM_INTERNET_ID = 55;
	private final static int SETTING_ID = 6;
	private final static int CUSTOM_SETTING_ID = 66;
	private final static int CLOCK_ID = 7;
	private final static int CUSTOM_CLOCK_ID = 77;

	public final static int DRAG_RADIO = 40;
	public final static int DRAG_AUDIO = 41;
	public final static int DRAG_VIDEO = 42;
	public final static int DRAG_GALLERY = 43;
	public final static int DRAG_INTERNET = 44;
	public final static int DRAG_SETTING = 45;
	public final static int DRAG_CLOCK = 46;
	public static int DRAG_DATA;

	private final static int RADIO_WIDGET = 0x21;
	private final static int AUDIO_WIDGET = 0x22;
	private final static int VIDEO_WIDGET = 0x23;

	private final static int TOP = 0;
	private final static int LEFT = 1;

	// icon top,left margin 값을 저장하는 배열

	private int[] iRadio_Icon_Margin = new int[2];
	private int[] iAudio_Icon_Margin = new int[2];
	private int[] iVideo_Icon_Margin = new int[2];
	private int[] iGallery_Icon_Margin = new int[2];
	private int[] iInternet_Icon_Margin = new int[2];
	private int[] iSetting_Icon_Margin = new int[2];
	private int[] iClock_Icon_Margin = new int[2];

	private int[] iPostion1_Margin = new int[2];
	private int[] iPostion2_Margin = new int[2];
	private int[] iPostion3_Margin = new int[2];
	private int[] iPostion4_Margin = new int[2];
	private int[] iPostion5_Margin = new int[2];
	private int[] iPostion6_Margin = new int[2];
	private int[] iPostion7_Margin = new int[2];
	private int[] iPostion8_Margin = new int[2];

	private int[] iIcon_chk = new int[7];
	private HoverListenerClass mHoverListener;

	TextView text;
	DisplayMetrics dm;
	ImageView view;
	int select;
	View testview;
	private OnDragListener mButtonDrag = new OnDragListener() {

		@Override
		public boolean onDrag(View v, DragEvent event) {
			// TODO Auto-generated method stub
			switch (event.getAction()) {

			case DragEvent.ACTION_DRAG_STARTED:

				break;

			case DragEvent.ACTION_DRAG_ENTERED:

				break;

			case DragEvent.ACTION_DRAG_EXITED:

				break;

			case DragEvent.ACTION_DROP:
				if (confirm_Icon(iIcon_chk) == false) {
					View view = (View) event.getLocalState();
					Context context = getActivity().getApplicationContext();
					Toast.makeText(context, "같은 아이콘이 존재 합니다.",
							Toast.LENGTH_LONG).show();
				} else {
					if (v == mRadioicon) {
						View view = (View) event.getLocalState();
						ViewGroup viewgroup = (ViewGroup) view.getParent();
						ImageView containView = (ImageView) v;

						mlayout.removeView(mRadioicon);
						delete_Icon_Chk(mRadioicon);
						mRadioicon = custom_icon(iPostion1_Margin[TOP],
								iPostion1_Margin[LEFT]);

						add_Icon_Chk(mRadioicon);

						view.setVisibility(View.VISIBLE);
					} else if (v == mAudioicon) {
						View view = (View) event.getLocalState();
						ViewGroup viewgroup = (ViewGroup) view.getParent();
						ImageView containView = (ImageView) v;
						mlayout.removeView(mAudioicon);
						delete_Icon_Chk(mAudioicon);
						mAudioicon = custom_icon(iPostion2_Margin[TOP],
								iPostion2_Margin[LEFT]);
						add_Icon_Chk(mAudioicon);
						view.setVisibility(View.VISIBLE);
					}

					else if (v == mVideoicon) {
						View view = (View) event.getLocalState();
						ViewGroup viewgroup = (ViewGroup) view.getParent();
						ImageView containView = (ImageView) v;
						mlayout.removeView(mVideoicon);
						delete_Icon_Chk(mVideoicon);
						mVideoicon = custom_icon(iPostion3_Margin[TOP],
								iPostion3_Margin[LEFT]);
						add_Icon_Chk(mVideoicon);
						view.setVisibility(View.VISIBLE);
					} else if (v == mGalleryicon) {
						View view = (View) event.getLocalState();
						ViewGroup viewgroup = (ViewGroup) view.getParent();
						ImageView containView = (ImageView) v;
						mlayout.removeView(mGalleryicon);
						delete_Icon_Chk(mGalleryicon);
						mGalleryicon = custom_icon(iPostion4_Margin[TOP],
								iPostion4_Margin[LEFT]);
						add_Icon_Chk(mGalleryicon);
						view.setVisibility(View.VISIBLE);

					} else if (v == mInterneticon) {
						View view = (View) event.getLocalState();
						ViewGroup viewgroup = (ViewGroup) view.getParent();
						ImageView containView = (ImageView) v;
						mlayout.removeView(mInterneticon);
						delete_Icon_Chk(mInterneticon);
						mInterneticon = custom_icon(iPostion5_Margin[TOP],
								iPostion5_Margin[LEFT]);
						add_Icon_Chk(mInterneticon);
						view.setVisibility(View.VISIBLE);

					} else if (v == mSettingicon) {
						View view = (View) event.getLocalState();
						ViewGroup viewgroup = (ViewGroup) view.getParent();
						ImageView containView = (ImageView) v;
						mlayout.removeView(mSettingicon);
						delete_Icon_Chk(mSettingicon);
						mSettingicon = custom_icon(iPostion6_Margin[TOP],
								iPostion6_Margin[LEFT]);
						add_Icon_Chk(mSettingicon);
						view.setVisibility(View.VISIBLE);
					} else if (v == mClockicon) {
						View view = (View) event.getLocalState();
						ViewGroup viewgroup = (ViewGroup) view.getParent();
						ImageView containView = (ImageView) v;
						mlayout.removeView(mClockicon);
						delete_Icon_Chk(mClockicon);
						mClockicon = custom_icon(iPostion7_Margin[TOP],
								iPostion7_Margin[LEFT]);
						add_Icon_Chk(mClockicon);
						view.setVisibility(View.VISIBLE);

					} else {
						View view = (View) event.getLocalState();
						view.setVisibility(View.VISIBLE);
						Context context = getActivity().getApplicationContext();

						Toast.makeText(context,
								"You can't drop the image here",
								Toast.LENGTH_LONG).show();
						// break;
					}
				}
				break;

			case DragEvent.ACTION_DRAG_ENDED:
				DRAG_DATA = 0;

			default:
				break;
			}
			return true;
		}
	};

	public View custom_icon(int pos1, int pos2) {

		if (DRAG_DATA == DRAG_RADIO) {
			testview = createRadioIcon(pos1, pos2);
		}

		if (DRAG_DATA == DRAG_AUDIO) {
			testview = createAudioIcon(pos1, pos2);

		}
		if (DRAG_DATA == DRAG_VIDEO) {
			testview = createVideoIcon(pos1, pos2);

		}
		if (DRAG_DATA == DRAG_GALLERY) {
			testview = createGalleryIcon(pos1, pos2);

		}
		if (DRAG_DATA == DRAG_INTERNET) {
			testview = createInternetIcon(pos1, pos2);

		}
		if (DRAG_DATA == DRAG_SETTING) {
			testview = createSettingIcon(pos1, pos2);

		}
		if (DRAG_DATA == DRAG_CLOCK) {
			testview = createClockIcon(pos1, pos2);
		}
		return testview;
	}

	private OnTouchListener mButtonTouch = new OnTouchListener() {

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			int action = event.getAction();
			if (action == MotionEvent.ACTION_DOWN) {
				switch (v.getId()) {
				case RADIO_ID:
					mRadioicon
							.setBackgroundResource(R.drawable.main_btn_radio_foc);
					break;
				case CUSTOM_RADIO_ID:
					mRadioicon_Custom
							.setBackgroundResource(R.drawable.main_btn_radio_foc);
					break;
				case AUDIO_ID:
					mAudioicon
							.setBackgroundResource(R.drawable.main_btn_audio_foc);

					break;
				case CUSTOM_AUDIO_ID:
					mAudioicon_Custom
							.setBackgroundResource(R.drawable.main_btn_audio_foc);

					break;
				case VIDEO_ID:
					mVideoicon
							.setBackgroundResource(R.drawable.main_btn_video_foc);
					break;
				case CUSTOM_VIDEO_ID:
					mVideoicon_Custom
							.setBackgroundResource(R.drawable.main_btn_video_foc);
					break;
				case GALLERY_ID:
					mGalleryicon
							.setBackgroundResource(R.drawable.main_btn_dmb_foc);

					break;
				case CUSTOM_GALLERY_ID:
					mGalleryicon_Custom
							.setBackgroundResource(R.drawable.main_btn_dmb_foc);
					break;
				case INTERNET_ID:
					mInterneticon
							.setBackgroundResource(R.drawable.main_btn_internet_foc);

					break;
				case CUSTOM_INTERNET_ID:
					mInterneticon_Custom
							.setBackgroundResource(R.drawable.main_btn_internet_foc);

					break;

				case SETTING_ID:
					mSettingicon
							.setBackgroundResource(R.drawable.main_btn_setting_foc);
					break;
				case CUSTOM_SETTING_ID:
					mSettingicon_Custom
							.setBackgroundResource(R.drawable.main_btn_setting_foc);

					break;
				case CLOCK_ID:
					mClockicon
							.setBackgroundResource(R.drawable.main_btn_bt_foc);

					break;
				case CUSTOM_CLOCK_ID:
					mClockicon_Custom
							.setBackgroundResource(R.drawable.main_btn_bt_foc);

					break;

				}
			}
			if (action == MotionEvent.ACTION_UP) {

				text = (TextView) getActivity().findViewById(R.id.View1);
				mRadioWidget = getActivity().findViewById(R.id.widget_radio);
				mAudioWidget = getActivity().findViewById(R.id.widget_audio);
				mVideoWidget = getActivity().findViewById(R.id.widget_video);
				mClockWidget = getActivity().findViewById(R.id.digital_clock);

				switch (v.getId()) {
				case RADIO_ID: {
					text.setText("Radio");
					mRadioicon
							.setBackgroundResource(R.drawable.main_btn_radio_nor);

					mRadioWidget.setVisibility(View.VISIBLE);
					mAudioWidget.setVisibility(View.INVISIBLE);
					mVideoWidget.setVisibility(View.INVISIBLE);
					mClockWidget.setVisibility(View.INVISIBLE);
				}
					break;
				case CUSTOM_RADIO_ID:
					mRadioicon_Custom
							.setBackgroundResource(R.drawable.main_btn_radio_nor);
					break;
				case AUDIO_ID: {
					text.setText("audio");
					mAudioicon
							.setBackgroundResource(R.drawable.main_btn_audio_nor);

					mRadioWidget.setVisibility(View.INVISIBLE);
					mAudioWidget.setVisibility(View.VISIBLE);
					mVideoWidget.setVisibility(View.INVISIBLE);
					mClockWidget.setVisibility(View.INVISIBLE);

				}
					break;
				case CUSTOM_AUDIO_ID:
					mAudioicon_Custom
							.setBackgroundResource(R.drawable.main_btn_audio_nor);

					break;
				case VIDEO_ID: {
					select = 0;
					text.setText("VIDEO");
					mVideoicon
							.setBackgroundResource(R.drawable.main_btn_video_nor);

					mRadioWidget.setVisibility(View.INVISIBLE);
					mAudioWidget.setVisibility(View.INVISIBLE);
					mVideoWidget.setVisibility(View.VISIBLE);
					mClockWidget.setVisibility(View.INVISIBLE);
				}
					break;
				case CUSTOM_VIDEO_ID:
					mVideoicon_Custom
							.setBackgroundResource(R.drawable.main_btn_video_nor);
					break;
				case GALLERY_ID: {
					select = 0;
					text.setText("GALLERY");
					mGalleryicon
							.setBackgroundResource(R.drawable.main_btn_dmb_nor);

				}
					break;
				case CUSTOM_GALLERY_ID:
					mGalleryicon_Custom
							.setBackgroundResource(R.drawable.main_btn_dmb_nor);
					break;
				case INTERNET_ID: {
					select = 0;
					mInterneticon
							.setBackgroundResource(R.drawable.main_btn_internet_nor);

					text.setText("INTERNET");
				}

					break;
				case CUSTOM_INTERNET_ID:
					mInterneticon_Custom
							.setBackgroundResource(R.drawable.main_btn_internet_nor);

					break;
				case SETTING_ID: {
					select = 0;
					text.setText("SETTING");
					mSettingicon
							.setBackgroundResource(R.drawable.main_btn_setting_nor);

				}
					break;
				case CUSTOM_SETTING_ID:
					mSettingicon_Custom
							.setBackgroundResource(R.drawable.main_btn_setting_nor);

					break;
				case CLOCK_ID: {
					select = 0;
					text.setText("CLOCK");
					mClockicon
							.setBackgroundResource(R.drawable.main_btn_bt_nor);

					mRadioWidget.setVisibility(View.INVISIBLE);
					mAudioWidget.setVisibility(View.INVISIBLE);
					mVideoWidget.setVisibility(View.INVISIBLE);
					mClockWidget.setVisibility(View.VISIBLE);

				}
					break;
				case CUSTOM_CLOCK_ID:
					mClockicon_Custom
							.setBackgroundResource(R.drawable.main_btn_bt_nor);

					break;
				}

				switch (select) {
				case 0:
					Intent i = new Intent();
					// i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

					i.setClassName("com.example.clock_app",
							"com.example.clock_app.ClockMainActivity");
					startActivity(i);
					break;
				case 1:
					Intent imusic = new Intent();
					// imusic.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					imusic.setClassName("com.android.music",
							"com.android.music.MusicBrowserActivity");
					startActivity(imusic);
					break;

				}
			}

			return false;
		}
	};
	private OnClickListener mButtonClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
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
				select = 0;
				text.setText("VIDEO");
				mRadioWidget.setVisibility(View.INVISIBLE);
				mAudioWidget.setVisibility(View.INVISIBLE);
				mVideoWidget.setVisibility(View.VISIBLE);
				mClockWidget.setVisibility(View.INVISIBLE);
			}
				break;
			case GALLERY_ID: {
				select = 0;
				text.setText("GALLERY");
			}
				break;
			case INTERNET_ID: {
				select = 0;
				text.setText("INTERNET");
			}

				break;
			case SETTING_ID: {
				select = 0;
				text.setText("SETTING");
			}
				break;
			/*
			 * case CLOCK_ID: { select = 0; text.setText("CLOCK");
			 * mRadioWidget.setVisibility(View.INVISIBLE);
			 * mAudioWidget.setVisibility(View.INVISIBLE);
			 * mVideoWidget.setVisibility(View.INVISIBLE);
			 * mClockWidget.setVisibility(View.VISIBLE);
			 * 
			 * } break;
			 */

			}

			switch (select) {
			case 0:
				Intent i = new Intent();
				i.setClassName("com.example.clock_app",
						"com.example.clock_app.ClockMainActivity");
				startActivity(i);
				break;
			case 1:
				Intent imusic = new Intent();
				imusic.setClassName("com.android.music",
						"com.android.music.MusicBrowserActivity");
				startActivity(imusic);
				break;

			}

		}

	};

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
		mlayout = (RelativeLayout) mV.findViewById(R.id.main_page);
		mWidgetView = (ViewGroup) mV.findViewById(R.id.widget_layout);
		dm = getResources().getDisplayMetrics();
		mHoverListener = new HoverListenerClass();

	

		iPostion1_Margin[TOP] = Math.round(5 * dm.density);
		iPostion1_Margin[LEFT] = Math.round(440 * dm.density);
		iPostion2_Margin[TOP] = Math.round(15 * dm.density);
		iPostion2_Margin[LEFT] = Math.round(665 * dm.density);
		iPostion3_Margin[TOP] = Math.round(105 * dm.density);
		iPostion3_Margin[LEFT] = Math.round(820 * dm.density);
		iPostion4_Margin[TOP] = Math.round(230 * dm.density);
		iPostion4_Margin[LEFT] = Math.round(690 * dm.density);
		iPostion5_Margin[TOP] = Math.round(260 * dm.density);
		iPostion5_Margin[LEFT] = Math.round(440 * dm.density);
		iPostion6_Margin[TOP] = Math.round(230 * dm.density);
		iPostion6_Margin[LEFT] = Math.round(165 * dm.density);
		iPostion7_Margin[TOP] = Math.round(105 * dm.density);
		iPostion7_Margin[LEFT] = Math.round(50 * dm.density);

		createRadioIcon();
		createAudioIcon();
		createVideoIcon();
		// createGalleryIcon();
		// createInternetIcon();
		// createSettingIcon();
		// createClockIcon();
		// text.setText(DRAG_DATA);
		if(mRadioicon.isHovered())
		{
			mRadioicon.setBackgroundResource(R.drawable.main_btn_radio_foc);
		}
		return mV;

	}

	public void createClockIcon() {

		mClockicon = new ImageView(getActivity());
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
		mClockicon.setClickable(true);
		mlayout.addView(mClockicon);
		mClockicon.setOnDragListener(mButtonDrag);
		mClockicon.setOnTouchListener(mButtonTouch);
		// mClockicon.setOnHoverListener(mHoverListener);
		
		iIcon_chk[6] = 1;
	}

	public void createSettingIcon() {
		
		mSettingicon = new ImageView(getActivity());
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
		mSettingicon.setClickable(true);
		mlayout.addView(mSettingicon);
		mSettingicon.setOnDragListener(mButtonDrag);
		mSettingicon.setOnTouchListener(mButtonTouch);
		// mSettingicon.setOnHoverListener(mHoverListener);
		iIcon_chk[5] = 1;
	}

	public void createInternetIcon() {
		
		mInterneticon = new ImageView(getActivity());
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
		mInterneticon.setClickable(true);
		mlayout.addView(mInterneticon);
		mInterneticon.setOnDragListener(mButtonDrag);
		mInterneticon.setOnTouchListener(mButtonTouch);
		// mInterneticon.setOnHoverListener(mHoverListener);
		iIcon_chk[4] = 1;
	}

	public void createGalleryIcon() {
	
		mGalleryicon = new ImageView(getActivity());
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
		mGalleryicon.setClickable(true);
		mlayout.addView(mGalleryicon);
		mGalleryicon.setOnDragListener(mButtonDrag);
		mGalleryicon.setOnTouchListener(mButtonTouch);
		// mGalleryicon.setOnHoverListener(mHoverListener);
		iIcon_chk[3] = 1;
	}

	public void createVideoIcon() {

		mVideoicon = new ImageView(getActivity());
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
		mVideoicon.setClickable(true);
		mlayout.addView(mVideoicon);
		mVideoicon.setOnDragListener(mButtonDrag);
		mVideoicon.setOnTouchListener(mButtonTouch);
		// mVideoicon.setOnHoverListener(mHoverListener);
		iIcon_chk[2] = 1;
	}

	public void createAudioIcon() {

		mAudioicon = new ImageView(getActivity());
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
		mAudioicon.setClickable(true);
		mlayout.addView(mAudioicon);
		mAudioicon.setOnDragListener(mButtonDrag);
		mAudioicon.setOnTouchListener(mButtonTouch);
		// mAudioicon.setOnHoverListener(mHoverListener);
		iIcon_chk[1] = 1;
	}

	public void createRadioIcon() {
		DRAG_DATA = DRAG_RADIO;
		mRadioicon = new ImageView(getActivity());
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
		mRadioicon.setClickable(true);
		mlayout.addView(mRadioicon);
		mRadioicon.setOnDragListener(mButtonDrag);
		mRadioicon.setOnTouchListener(mButtonTouch);
		// mRadioicon.setOnHoverListener(mHoverListener);
		iIcon_chk[0] = 1;
	}

	/************************************************************************/
	public View createClockIcon(int pos1, int pos2) {

		mClockicon_Custom = new ImageView(getActivity());
		mClockicon_Custom.setId(CUSTOM_CLOCK_ID);
		mClockicon_Custom.setBackgroundResource(R.drawable.main_btn_bt_nor);
		clockparams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);

		clockparams.topMargin = pos1;
		clockparams.leftMargin = pos2;
		mClockicon_Custom.setLayoutParams(clockparams);
		mClockicon_Custom.setClickable(true);
		mlayout.addView(mClockicon_Custom);
		mClockicon_Custom.setOnDragListener(mButtonDrag);
		mClockicon_Custom.setOnTouchListener(mButtonTouch);
		// mClockicon.setOnHoverListener(mHoverListener);
		iIcon_chk[6] = 1;
		return mClockicon_Custom;
	}

	public View createSettingIcon(int pos1, int pos2) {

		mSettingicon_Custom = new ImageView(getActivity());
		mSettingicon_Custom.setId(CUSTOM_SETTING_ID);
		mSettingicon_Custom
				.setBackgroundResource(R.drawable.main_btn_setting_nor);
		settingparams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		settingparams.topMargin = pos1;
		settingparams.leftMargin = pos2;
		mSettingicon_Custom.setLayoutParams(settingparams);
		mSettingicon_Custom.setClickable(true);
		mlayout.addView(mSettingicon_Custom);
		mSettingicon_Custom.setOnDragListener(mButtonDrag);
		mSettingicon_Custom.setOnTouchListener(mButtonTouch);
		// mSettingicon.setOnHoverListener(mHoverListener);
		iIcon_chk[5] = 1;
		return mSettingicon_Custom;
	}

	public View createInternetIcon(int pos1, int pos2) {
		
		mInterneticon_Custom = new ImageView(getActivity());
		mInterneticon_Custom.setId(CUSTOM_INTERNET_ID);
		mInterneticon_Custom
				.setBackgroundResource(R.drawable.main_btn_internet_nor);
		internetparams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);

		internetparams.topMargin = pos1;
		internetparams.leftMargin = pos2;
		mInterneticon_Custom.setLayoutParams(internetparams);
		mInterneticon_Custom.setClickable(true);
		mlayout.addView(mInterneticon_Custom);
		mInterneticon_Custom.setOnDragListener(mButtonDrag);
		mInterneticon_Custom.setOnTouchListener(mButtonTouch);
		// mInterneticon.setOnHoverListener(mHoverListener);
		iIcon_chk[4] = 1;
		return mInterneticon_Custom;
	}

	public View createGalleryIcon(int pos1, int pos2) {
		
		mGalleryicon_Custom = new ImageView(getActivity());
		mGalleryicon_Custom.setId(CUSTOM_GALLERY_ID);
		mGalleryicon_Custom.setBackgroundResource(R.drawable.main_btn_dmb_nor);
		galleryparams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);

		galleryparams.topMargin = pos1;
		galleryparams.leftMargin = pos2;
		mGalleryicon_Custom.setLayoutParams(galleryparams);
		mGalleryicon_Custom.setClickable(true);
		mlayout.addView(mGalleryicon_Custom);
		mGalleryicon_Custom.setOnDragListener(mButtonDrag);
		mGalleryicon_Custom.setOnTouchListener(mButtonTouch);
		// mGalleryicon.setOnHoverListener(mHoverListener);
		iIcon_chk[3] = 1;
		return mGalleryicon_Custom;
	}

	public View createVideoIcon(int pos1, int pos2) {
		
		mVideoicon_Custom = new ImageView(getActivity());
		mVideoicon_Custom.setId(CUSTOM_VIDEO_ID);
		mVideoicon_Custom.setBackgroundResource(R.drawable.main_btn_video_nor);
		videoparams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);

		videoparams.topMargin = pos1;
		videoparams.leftMargin = pos2;
		mVideoicon_Custom.setLayoutParams(videoparams);
		mVideoicon_Custom.setClickable(true);
		mlayout.addView(mVideoicon_Custom);
		mVideoicon_Custom.setOnDragListener(mButtonDrag);
		mVideoicon_Custom.setOnTouchListener(mButtonTouch);
		// mVideoicon.setOnHoverListener(mHoverListener);
		iIcon_chk[2] = 1;
		return mVideoicon_Custom;
	}

	public View createAudioIcon(int pos1, int pos2) {
		
		mAudioicon_Custom = new ImageView(getActivity());
		mAudioicon_Custom.setId(CUSTOM_AUDIO_ID);
		mAudioicon_Custom.setBackgroundResource(R.drawable.main_btn_audio_nor);
		audioparams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);

		audioparams.topMargin = pos1;
		audioparams.leftMargin = pos2;
		mAudioicon_Custom.setLayoutParams(audioparams);
		mAudioicon_Custom.setClickable(true);
		mlayout.addView(mAudioicon_Custom);
		mAudioicon_Custom.setOnDragListener(mButtonDrag);
		mAudioicon_Custom.setOnTouchListener(mButtonTouch);
		// mAudioicon.setOnHoverListener(mHoverListener);
		iIcon_chk[1] = 1;
		return mAudioicon_Custom;
	}

	public View createRadioIcon(int pos1, int pos2) {
		
		mRadioicon_Custom = new ImageView(getActivity());
		mRadioicon_Custom.setId(CUSTOM_RADIO_ID);
		mRadioicon_Custom.setBackgroundResource(R.drawable.main_btn_radio_nor);
		radioparams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);

		radioparams.topMargin = pos1;
		radioparams.leftMargin = pos2;
		mRadioicon_Custom.setLayoutParams(radioparams);
		mRadioicon_Custom.setClickable(true);
		mlayout.addView(mRadioicon_Custom);
		mRadioicon_Custom.setOnDragListener(mButtonDrag);
		mRadioicon_Custom.setOnTouchListener(mButtonTouch);
		// mRadioicon.setOnHoverListener(mHoverListener);
		iIcon_chk[0] = 1;
		return mRadioicon_Custom;
	}

	public boolean confirm_Icon(int[] iIcon_chk) {
		if (DRAG_DATA == DRAG_RADIO) {
			if (iIcon_chk[0] == 1)
				return false;

		}
		if (DRAG_DATA == DRAG_AUDIO) {
			if (iIcon_chk[1] == 1)
				return false;

		}
		if (DRAG_DATA == DRAG_VIDEO) {
			if (iIcon_chk[2] == 1)
				return false;

		}
		if (DRAG_DATA == DRAG_GALLERY) {
			if (iIcon_chk[3] == 1)
				return false;

		}
		if (DRAG_DATA == DRAG_INTERNET) {
			if (iIcon_chk[4] == 1)
				return false;

		}
		if (DRAG_DATA == DRAG_SETTING) {
			if (iIcon_chk[5] == 1)
				return false;

		}
		if (DRAG_DATA == DRAG_CLOCK) {
			if (iIcon_chk[6] == 1)
				return false;

		}

		return true;

	}

	public void delete_Icon_Chk(View v) {
		if (v.getId() == RADIO_ID || v.getId() == CUSTOM_RADIO_ID)
			iIcon_chk[0] = 0;
		if (v.getId() == AUDIO_ID || v.getId() == CUSTOM_AUDIO_ID)
			iIcon_chk[1] = 0;
		if (v.getId() == VIDEO_ID || v.getId() == CUSTOM_VIDEO_ID)
			iIcon_chk[2] = 0;
		if (v.getId() == GALLERY_ID || v.getId() == CUSTOM_GALLERY_ID)
			iIcon_chk[3] = 0;
		if (v.getId() == INTERNET_ID || v.getId() == CUSTOM_INTERNET_ID)
			iIcon_chk[4] = 0;
		if (v.getId() == SETTING_ID || v.getId() == CUSTOM_SETTING_ID)
			iIcon_chk[5] = 0;
		if (v.getId() == CLOCK_ID || v.getId() == CUSTOM_CLOCK_ID)
			iIcon_chk[6] = 0;

	}

	public void add_Icon_Chk(View v) {
		if (v.getId() == RADIO_ID || v.getId() == CUSTOM_RADIO_ID)
			iIcon_chk[0] = 1;
		if (v.getId() == AUDIO_ID || v.getId() == CUSTOM_AUDIO_ID)
			iIcon_chk[1] = 1;
		if (v.getId() == VIDEO_ID || v.getId() == CUSTOM_VIDEO_ID)
			iIcon_chk[2] = 1;
		if (v.getId() == GALLERY_ID || v.getId() == CUSTOM_GALLERY_ID)
			iIcon_chk[3] = 1;
		if (v.getId() == INTERNET_ID || v.getId() == CUSTOM_INTERNET_ID)
			iIcon_chk[4] = 1;
		if (v.getId() == SETTING_ID || v.getId() == CUSTOM_SETTING_ID)
			iIcon_chk[5] = 1;
		if (v.getId() == CLOCK_ID || v.getId() == CUSTOM_CLOCK_ID)
			iIcon_chk[6] = 1;

	}

}
