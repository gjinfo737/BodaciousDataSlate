package northwoods.discovery.bodaciousdataslate;

import android.view.LayoutInflater;
import android.view.ViewGroup;

public class BodaciousRadiusMaximus<E> {

	private int[] layouts;
	private int[] layoutsItemIds;
	private int bodaciousItemId;
	private LayoutInflater layoutInflater;
	private ViewGroup mainLayout;
	private BodaciousAdapter<E> adapter;
	private int currentLayout;
	private int itemContainerLayoutId;
	private IRadiusItemusPopulus radiusItemusPopulus;

	public BodaciousRadiusMaximus(int[] layouts, int[] layoutsItemIds,
			LayoutInflater layoutInflater, ViewGroup mainLayout,
			int itemContainerLayoutId, int bodaciousItemId,
			IRadiusItemusPopulus radiusItemusPopulus) {

		this.layouts = layouts;
		this.layoutsItemIds = layoutsItemIds;
		this.layoutInflater = layoutInflater;
		this.mainLayout = mainLayout;
		this.itemContainerLayoutId = itemContainerLayoutId;
		this.radiusItemusPopulus = radiusItemusPopulus;
		this.bodaciousItemId = bodaciousItemId;
		//
		this.currentLayout = this.layouts[0];
	}

	public void setAdapter(BodaciousAdapter<E> bodaciousStringAdapter) {
		this.adapter = bodaciousStringAdapter;
		updateView();
	}

	public BodaciousAdapter<E> getAdapter() {
		return adapter;
	}

	private void updateView() {
		this.currentLayout = determineAppropriateLayout();
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
		int count = adapter.getCount();
		for (int i = 0; i < count; i++) {
			if (i < count - 1 && i < layoutsItemIds.length) {
				ViewGroup viewGroup = (ViewGroup) mainLayout
						.findViewById(layoutsItemIds[i]);
				if (viewGroup != null) {
					radiusItemusPopulus.setViewForData(layoutInflater,
							viewGroup, adapter.getItem(i));
				}
			} else {
				radiusItemusPopulus.setViewForData(layoutInflater,
						(ViewGroup) mainLayout.findViewById(bodaciousItemId),
						adapter.getItem(i));
			}
		}
	}

	private int determineAppropriateLayout() {
		return determineAppropriateLayout(adapter);
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