package northwoods.discovery.bodaciousdataslate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class BodaciousRadiusMaximus<E> {

	private Context context;
	private int[] layouts;
	private int[] layoutsItemIds;
	private LayoutInflater layoutInflater;
	private ViewGroup mainLayout;
	private BodaciousAdapter<E> adapter;
	private int currentLayout;
	private int subLayoutId;

	public BodaciousRadiusMaximus(Context context, int[] layouts,
			int[] layoutsItemIds, LayoutInflater layoutInflater,
			ViewGroup mainLayout, int containerLayoutId) {
		this.context = context;
		this.layouts = layouts;
		this.layoutsItemIds = layoutsItemIds;
		this.layoutInflater = layoutInflater;
		this.mainLayout = mainLayout;
		this.subLayoutId = containerLayoutId;
		//
		this.currentLayout = this.layouts[0];
	}

	public void setAdapter(BodaciousAdapter<E> bodaciousStringAdapter) {
		this.adapter = bodaciousStringAdapter;
		updateView();
	}

	private void updateView() {
		determineAppropriateLayout();
		mainLayout.removeAllViews();
		ViewGroup layout = (ViewGroup) layoutInflater.inflate(currentLayout,
				null);
		ViewGroup subLayout = (ViewGroup) layout.findViewById(subLayoutId);
		layout.removeView(subLayout);
		mainLayout.addView(subLayout);
	}

	private void determineAppropriateLayout() {
		int index = adapter.getCount();
		this.currentLayout = layouts[index];
	}

}