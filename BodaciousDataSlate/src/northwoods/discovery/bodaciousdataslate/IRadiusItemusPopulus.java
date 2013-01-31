package northwoods.discovery.bodaciousdataslate;

import android.view.LayoutInflater;
import android.view.ViewGroup;

public interface IRadiusItemusPopulus {
	public ViewGroup setViewForRegularData(LayoutInflater inflater,
			ViewGroup view, Object data);

	public ViewGroup setViewForData(LayoutInflater inflater, ViewGroup view,
			Object data, boolean isBodacious, int bodaciousVisibility);
}
