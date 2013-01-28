package northwoods.discovery.bodaciousdataslate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class BodaciousItem extends RelativeLayout {

	public BodaciousItem(Context context) {
		super(context);
		init();
	}

	public BodaciousItem(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public BodaciousItem(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init() {
		View child = new BodaciousImageView(getContext());
		addView(child);
	}

	private class BodaciousImageView extends View {
		private static final int DEFAULT_SIZE = 10;

		public BodaciousImageView(Context context) {
			super(context);
			init();
		}

		public BodaciousImageView(Context context, AttributeSet attrs) {
			super(context, attrs);
			init();
		}

		public BodaciousImageView(Context context, AttributeSet attrs,
				int defStyle) {
			super(context, attrs, defStyle);
			init();
		}

		private void init() {
			setLayoutParams(new LayoutParams(DEFAULT_SIZE, DEFAULT_SIZE));
		}

		@Override
		protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			canvas.drawColor(Color.MAGENTA);
		}

	}
}
