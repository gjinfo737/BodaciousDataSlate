package northwoods.discovery.bodaciousdataslate;

import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class BodaciousAdapter<E> extends BaseAdapter {
	private List<E> dataList;
	private IRadiusItemusPopulus radiusItemusPopulus;
	private LayoutInflater inflater;
	private BodaciousRadiusMaximus<E> radiusMaximus;

	public BodaciousAdapter(IRadiusItemusPopulus radiusItemusPopulus,
			LayoutInflater inflater) {
		this.dataList = new ArrayList<E>();
		this.radiusItemusPopulus = radiusItemusPopulus;
		this.inflater = inflater;
	}

	@Override
	public int getCount() {
		return dataList.size();
	}

	@Override
	public E getItem(int position) {
		return dataList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null)
			return radiusItemusPopulus.setViewForData(inflater, null,
					getItem(position), position == getBodaciousPosition(),
					radiusMaximus.determineBodaciousVisibility());

		return convertView;
	}

	public int getBodaciousPosition() {
		return getCount() - 1;
	}

	public void setBodaciousRadiusMaximus(
			BodaciousRadiusMaximus<E> radiusMaximus) {
		this.radiusMaximus = radiusMaximus;
	}

	public void setList(List<E> theFullDataList, int indexOfBodacious) {
		this.dataList = theFullDataList;
		if (theFullDataList != null)
			if (theFullDataList.size() > indexOfBodacious)
				sortList(indexOfBodacious);
	}

	private void sortList(int indexOfBodacious) {
		List<E> sortedList = new ArrayList<E>();
		for (int i = 0; i < dataList.size(); i++) {
			if (i != indexOfBodacious)
				sortedList.add(dataList.get(i));
		}
		sortedList.add(dataList.get(indexOfBodacious));
		dataList = sortedList;
	}
}
