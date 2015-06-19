package com.example.launcher;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.StateListDrawable;
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

	private StateListDrawable mRadioSeletor;
	private StateListDrawable mAudioSeletor;
	private StateListDrawable mVideoSeletor;
	private StateListDrawable mGallerySeletor;
	private StateListDrawable mInternetSeletor;
	private StateListDrawable mSettingSeletor;
	private StateListDrawable mClockSeletor;

	private View mRadioWidget;
	private View mAudioWidget;
	private View mVideoWidget;
	private View mClockWidget;
	private ViewGroup mWidgetView;

	private final static int RADIO_ID = 1;
	private final static int AUDIO_ID = 2;
	private final static int VIDEO_ID = 3;
	private final static int GALLERY_ID = 4;
	private final static int INTERNET_ID = 5;
	private final static int SETTING_ID = 6;
	private final static int CLOCK_ID = 7;

	private final static int CUSTOM_RADIO_ID = 11;
	private final static int CUSTOM_AUDIO_ID = 22;
	private final static int CUSTOM_VIDEO_ID = 33;
	private final static int CUSTOM_GALLERY_ID = 44;
	private final static int CUSTOM_INTERNET_ID = 55;
	private final static int CUSTOM_SETTING_ID = 66;
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
				mRadioicon.setBackground(mRadioSeletor);

			}
				break;
			case CUSTOM_RADIO_ID: {

				text.setText("IMAGE");
				mRadioWidget.setVisibility(View.VISIBLE);
				mAudioWidget.setVisibility(View.INVISIBLE);
				mVideoWidget.setVisibility(View.INVISIBLE);
				mClockWidget.setVisibility(View.INVISIBLE);
				mRadioicon_Custom.setBackground(mRadioSeletor);

			}
				break;
			case AUDIO_ID: {
				select = 1;
				text.setText("AUDIO");
				mRadioWidget.setVisibility(View.INVISIBLE);
				mAudioWidget.setVisibility(View.VISIBLE);
				mVideoWidget.setVisibility(View.INVISIBLE);
				mClockWidget.setVisibility(View.INVISIBLE);
				mAudioicon.setBackground(mAudioSeletor);
			}
				break;
			case CUSTOM_AUDIO_ID: {
				select = 1;
				text.setText("AUDIO");
				mRadioWidget.setVisibility(View.INVISIBLE);
				mAudioWidget.setVisibility(View.VISIBLE);
				mVideoWidget.setVisibility(View.INVISIBLE);
				mClockWidget.setVisibility(View.INVISIBLE);
				mAudioicon_Custom.setBackground(mAudioSeletor);
			}
				break;
			case VIDEO_ID: {
				select = 0;
				text.setText("VIDEO");
				mRadioWidget.setVisibility(View.INVISIBLE);
				mAudioWidget.setVisibility(View.INVISIBLE);
				mVideoWidget.setVisibility(View.VISIBLE);
				mClockWidget.setVisibility(View.INVISIBLE);
				mVideoicon.setBackground(mVideoSeletor);
			}
				break;
			case CUSTOM_VIDEO_ID: {
				select = 0;
				text.setText("VIDEO");
				mRadioWidget.setVisibility(View.INVISIBLE);
				mAudioWidget.setVisibility(View.INVISIBLE);
				mVideoWidget.setVisibility(View.VISIBLE);
				mClockWidget.setVisibility(View.INVISIBLE);
				mVideoicon_Custom.setBackground(mVideoSeletor);
			}
				break;
			case GALLERY_ID: {
				select = 0;
				text.setText("GALLERY");
				mGalleryicon.setBackground(mGallerySeletor);
			}
			case CUSTOM_GALLERY_ID: {
				select = 0;
				text.setText("GALLERY");
				mGalleryicon_Custom.setBackground(mGallerySeletor);
			}
				break;
			case INTERNET_ID: {
				select = 0;
				text.setText("INTERNET");
				mInterneticon.setBackground(mInternetSeletor);
			}

				break;
			case CUSTOM_INTERNET_ID: {
				select = 0;
				text.setText("INTERNET");
				mInterneticon_Custom.setBackground(mInternetSeletor);
			}

				break;
			case SETTING_ID: {
				select = 0;
				text.setText("SETTING");
				mSettingicon.setBackground(mSettingSeletor);
			}
				break;
			case CUSTOM_SETTING_ID: {
				select = 0;
				text.setText("SETTING");
				mSettingicon_Custom.setBackground(mSettingSeletor);
			}
				break;

			case CLOCK_ID: {
				select = 0;
				text.setText("CLOCK");
				mRadioWidget.setVisibility(View.INVISIBLE);
				mAudioWidget.setVisibility(View.INVISIBLE);
				mVideoWidget.setVisibility(View.INVISIBLE);
				mClockWidget.setVisibility(View.VISIBLE);
				mClockicon.setBackground(mClockSeletor);

			}
				break;
			case CUSTOM_CLOCK_ID: {
				select = 0;
				text.setText("CLOCK");
				mRadioWidget.setVisibility(View.INVISIBLE);
				mAudioWidget.setVisibility(View.INVISIBLE);
				mVideoWidget.setVisibility(View.INVISIBLE);
				mClockWidget.setVisibility(View.VISIBLE);
				mClockicon_Custom.setBackground(mClockSeletor);

			}
				break;

			}

			/*switch (select) {
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

			}*/

		}

	};

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		mV = (RelativeLayout) inflater.inflate(R.layout.mainpage_layout,
				container, false);
		mlayout = (RelativeLayout) mV.findViewById(R.id.main_page);
		mWidgetView = (ViewGroup) mV.findViewById(R.id.widget_layout);
		dm = getResources().getDisplayMetrics();

		mRadioSeletor = new StateListDrawable();
		mAudioSeletor = new StateListDrawable();
		mVideoSeletor = new StateListDrawable();
		mGallerySeletor = new StateListDrawable();
		mInternetSeletor = new StateListDrawable();
		mInternetSeletor = new StateListDrawable();
		mSettingSeletor = new StateListDrawable();
		mClockSeletor = new StateListDrawable();

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

		mRadioSeletor.addState(new int[] { android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.main_btn_radio_foc));
		mRadioSeletor.addState(new int[] { android.R.attr.state_focused },
				getResources().getDrawable(R.drawable.main_btn_radio_foc));
		mRadioSeletor.addState(new int[] { android.R.attr.state_drag_hovered },
				getResources().getDrawable(R.drawable.main_btn_radio_foc));
		mRadioSeletor.addState(new int[] {},
				getResources().getDrawable(R.drawable.main_btn_radio_nor));

		mAudioSeletor.addState(new int[] { android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.main_btn_audio_foc));
		mAudioSeletor.addState(new int[] { android.R.attr.state_focused },
				getResources().getDrawable(R.drawable.main_btn_audio_foc));
		mAudioSeletor.addState(new int[] { android.R.attr.state_drag_hovered },
				getResources().getDrawable(R.drawable.main_btn_audio_foc));
		mAudioSeletor.addState(new int[] {},
				getResources().getDrawable(R.drawable.main_btn_audio_nor));

		mVideoSeletor.addState(new int[] { android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.main_btn_video_foc));
		mVideoSeletor.addState(new int[] { android.R.attr.state_focused },
				getResources().getDrawable(R.drawable.main_btn_video_foc));
		mVideoSeletor.addState(new int[] { android.R.attr.state_drag_hovered },
				getResources().getDrawable(R.drawable.main_btn_video_foc));
		mVideoSeletor.addState(new int[] {},
				getResources().getDrawable(R.drawable.main_btn_video_nor));

		mGallerySeletor.addState(new int[] { android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.main_btn_dmb_foc));
		mGallerySeletor.addState(new int[] { android.R.attr.state_focused },
				getResources().getDrawable(R.drawable.main_btn_dmb_foc));
		mGallerySeletor.addState(
				new int[] { android.R.attr.state_drag_hovered }, getResources()
						.getDrawable(R.drawable.main_btn_dmb_foc));
		mGallerySeletor.addState(new int[] {},
				getResources().getDrawable(R.drawable.main_btn_dmb_nor));

		mInternetSeletor.addState(new int[] { android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.main_btn_internet_foc));
		mInternetSeletor.addState(new int[] { android.R.attr.state_focused },
				getResources().getDrawable(R.drawable.main_btn_internet_foc));
		mInternetSeletor.addState(
				new int[] { android.R.attr.state_drag_hovered }, getResources()
						.getDrawable(R.drawable.main_btn_internet_foc));
		mInternetSeletor.addState(new int[] {},
				getResources().getDrawable(R.drawable.main_btn_internet_nor));

		mSettingSeletor.addState(new int[] { android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.main_btn_setting_foc));
		mSettingSeletor.addState(new int[] { android.R.attr.state_focused },
				getResources().getDrawable(R.drawable.main_btn_setting_foc));
		mSettingSeletor.addState(
				new int[] { android.R.attr.state_drag_hovered }, getResources()
						.getDrawable(R.drawable.main_btn_setting_foc));
		mSettingSeletor.addState(new int[] {},
				getResources().getDrawable(R.drawable.main_btn_setting_nor));

		mClockSeletor.addState(new int[] { android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.main_btn_bt_foc));
		mClockSeletor.addState(new int[] { android.R.attr.state_focused },
				getResources().getDrawable(R.drawable.main_btn_bt_foc));
		mClockSeletor.addState(new int[] { android.R.attr.state_drag_hovered },
				getResources().getDrawable(R.drawable.main_btn_bt_foc));
		mClockSeletor.addState(new int[] {},
				getResources().getDrawable(R.drawable.main_btn_bt_nor));

		createRadioIcon();
		createAudioIcon();
		createVideoIcon();
		// createGalleryIcon();
		createInternetIcon();
		createSettingIcon();
		// createClockIcon();

		mRadioicon.setOnDragListener(mButtonDrag);
		mRadioicon.setOnClickListener(mButtonClick);
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
		mClockicon.setOnClickListener(mButtonClick);
		// mClockicon.setOnTouchListener(mButtonTouch);
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
		mSettingicon.setOnClickListener(mButtonClick);
		// mSettingicon.setOnTouchListener(mButtonTouch);
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
		mInterneticon.setOnClickListener(mButtonClick);
		// mInterneticon.setOnTouchListener(mButtonTouch);
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
		mGalleryicon.setOnClickListener(mButtonClick);
		// mGalleryicon.setOnTouchListener(mButtonTouch);
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
		mVideoicon.setOnClickListener(mButtonClick);
		// mVideoicon.setOnTouchListener(mButtonTouch);
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
		mAudioicon.setOnClickListener(mButtonClick);
		// mAudioicon.setOnTouchListener(mButtonTouch);
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
		mClockicon_Custom.setOnClickListener(mButtonClick);
		// mClockicon_Custom.setOnTouchListener(mButtonTouch);
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
		mSettingicon_Custom.setOnClickListener(mButtonClick);
		// mSettingicon_Custom.setOnTouchListener(mButtonTouch);
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
		mInterneticon_Custom.setOnClickListener(mButtonClick);
		// mInterneticon_Custom.setOnTouchListener(mButtonTouch);
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
		mGalleryicon_Custom.setOnClickListener(mButtonClick);
		// mGalleryicon_Custom.setOnTouchListener(mButtonTouch);
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
		mVideoicon_Custom.setOnClickListener(mButtonClick);
		// mVideoicon_Custom.setOnTouchListener(mButtonTouch);
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
		mAudioicon_Custom.setOnClickListener(mButtonClick);
		// mAudioicon_Custom.setOnTouchListener(mButtonTouch);
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
		mRadioicon_Custom.setOnClickListener(mButtonClick);
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
