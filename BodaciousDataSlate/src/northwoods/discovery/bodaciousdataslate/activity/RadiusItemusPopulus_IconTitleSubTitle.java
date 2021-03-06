package northwoods.discovery.bodaciousdataslate.activity;

import northwoods.discovery.bodaciousdataslate.IRadiusItemusPopulus;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RadiusItemusPopulus_IconTitleSubTitle implements
		IRadiusItemusPopulus {

	private int layoutId;
	private int iconId;
	private int titleId;
	private int subTitleId;

	public RadiusItemusPopulus_IconTitleSubTitle(int layoutId, int iconId,
			int titleId, int subTitleId) {
		this.layoutId = layoutId;
		this.iconId = iconId;
		this.titleId = titleId;
		this.subTitleId = subTitleId;
	}

	@Override
	public ViewGroup setViewForRegularData(LayoutInflater inflater,
			ViewGroup view, Object data) {
		return setViewForData(inflater, view, data, false, View.VISIBLE);
	}

	@Override
	public ViewGroup setViewForData(LayoutInflater inflater, ViewGroup view,
			Object data, boolean isBodacious, int bodaciousVisibility) {
		if (view != null)
			view.removeAllViews();
		ViewGroup layout = (ViewGroup) inflater.inflate(layoutId, null);
		((ImageView) layout.findViewById(iconId))
				.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						Log.e("", "%#@#$#@$#@#@$");
					}
				});
		((TextView) layout.findViewById(titleId)).setText(data.toString());
		((TextView) layout.findViewById(subTitleId)).setText("subtitle");
		if (view != null)
			view.addView(layout);

		if (isBodacious)
			layout.setVisibility(bodaciousVisibility);
		return layout;
	}
}
