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
	private int itemContainerLayoutId;
	private IRadiusItemusPopulus radiusItemusPopulus;

	public BodaciousRadiusMaximus(Context context, int[] layouts,
			int[] layoutsItemIds, LayoutInflater layoutInflater,
			ViewGroup mainLayout, int itemContainerLayoutId,
			IRadiusItemusPopulus radiusItemusPopulus) {
		this.context = context;
		this.layouts = layouts;
		this.layoutsItemIds = layoutsItemIds;
		this.layoutInflater = layoutInflater;
		this.mainLayout = mainLayout;
		this.itemContainerLayoutId = itemContainerLayoutId;
		this.radiusItemusPopulus = radiusItemusPopulus;
		//
		this.currentLayout = this.layouts[0];
	}

	public void setAdapter(BodaciousAdapter<E> bodaciousStringAdapter) {
		this.adapter = bodaciousStringAdapter;
		updateView();
	}

	private void updateView() {
		this.currentLayout = determineAppropriateLayout(adapter);
		mainLayout.removeAllViews();
		ViewGroup newLayout = (ViewGroup) layoutInflater.inflate(currentLayout,
				null);
		ViewGroup subLayout = (ViewGroup) newLayout
				.findViewById(itemContainerLayoutId);
		newLayout.removeView(subLayout);
		mainLayout.addView(subLayout);
		populateItems();
	}

	private void populateItems() {
		int count = calculateNumberOfItemsIndex(adapter) + 1;
		for (int i = 0; i < count; i++) {
			radiusItemusPopulus.setViewForData(layoutInflater,
					(ViewGroup) mainLayout.findViewById(layoutsItemIds[i]),
					adapter.getItem(i));
		}
	}

	public int determineAppropriateLayout(
			BodaciousAdapter<E> bodaciousStringAdapter) {
		int index = calculateNumberOfItemsIndex(bodaciousStringAdapter);
		return layouts[index];
	}

	public int calculateNumberOfItemsIndex(
			BodaciousAdapter<E> bodaciousStringAdapter) {
		int indexWithBod = bodaciousStringAdapter.getCount() - 1;
		int index = indexWithBod - 1;
		index = index >= layouts.length ? layouts.length - 1 : index;
		index = index < 0 ? 0 : index;
		return index;
	}

}