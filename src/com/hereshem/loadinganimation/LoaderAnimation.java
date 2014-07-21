package com.hereshem.loadinganimation;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class LoaderAnimation extends ImageView {

	private AnimationDrawable frameAnimation;
	private boolean loadingState = false;

	public LoaderAnimation(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public LoaderAnimation(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public LoaderAnimation(Context context) {
		super(context);
		init();
	}

	private void init() {
		setBackgroundResource(R.drawable.frame_loading);
		frameAnimation = (AnimationDrawable) getBackground();
		post(new Runnable() {
			public void run() {
				frameAnimation.start();
			}
		});
	}

	public boolean stopAnimation() {

		if (frameAnimation != null) {
			frameAnimation.stop();
			return true;
		} else {
			return false;
		}
	}

	public boolean startAnimation() {
		if (frameAnimation != null) {
			frameAnimation.start();
			return true;
		} else {

			return false;
		}

	}

	public void setLoadingState(boolean isLoading) {
		this.loadingState = isLoading;
	}

	public boolean getLoadingState() {
		return loadingState;
	}
}
