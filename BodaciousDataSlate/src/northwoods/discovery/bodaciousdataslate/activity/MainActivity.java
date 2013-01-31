package northwoods.discovery.bodaciousdataslate.activity;

import java.util.ArrayList;
import java.util.List;

import northwoods.discovery.bodaciousdataslate.BodaciousAdapter;
import northwoods.discovery.bodaciousdataslate.BodaciousRadiusMaximus;
import northwoods.discovery.bodaciousdataslate.R;
import northwoods.discovery.bodaciousdataslate.R.id;
import northwoods.discovery.bodaciousdataslate.R.layout;
import northwoods.discovery.bodaciousdataslate.RadiusItemusPopulus_IconTitleSubTitle;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends Activity {
	private static final int BODACIOUS_LISTVIEW_ID = id.bodacious_listView;
	private static final int[] btnIds = new int[] { id.button2, id.button3,
			id.button4, id.button5, id.button6, id.button7, id.button8,
			id.button9, id.button10, id.button11, id.button12 };
	private static final int THE_BODACIOUS_ONE = 0;
	public static final int RADIUS_ITEM_BODACIOUS = id.bod_radius_item_bodacious;
	public static final int RADIUS_SUB_LAYOUT_ID = id.sub_rellay;
	public static final int RADIUS_ITEM_CONTAINER_ID = id.bod_radius_item_container;
	public static final int[] RADIUS_LAYOUTS = new int[] { layout.bod_radius_0,
			layout.bod_radius_1, layout.bod_radius_2, layout.bod_radius_3,
			layout.bod_radius_4, layout.bod_radius_5, layout.bod_radius_6,
			layout.bod_radius_7, layout.bod_radius_8,

	};
	public static final int[] RADIUS_LAYOUT_ITEM_IDS = new int[] {
			id.bod_radius_item_0, id.bod_radius_item_1, id.bod_radius_item_2,
			id.bod_radius_item_3, id.bod_radius_item_4, id.bod_radius_item_5,
			id.bod_radius_item_6, id.bod_radius_item_7, id.bod_radius_item_8, };
	private BodaciousRadiusMaximus<String> radial;
	private RadiusItemusPopulus_IconTitleSubTitle radiusItemPopulater;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// GridView grid = (GridView) findViewById(id.gridView1);

		// grid.setAdapter(bodStringAdapter);

		radiusItemPopulater = new RadiusItemusPopulus_IconTitleSubTitle(
				layout.item_layout, id.item_imageView, id.item_textView_title,
				id.item_textView_subTitle);
		this.radial = new BodaciousRadiusMaximus<String>(
				layout.bod_radius_default, RADIUS_LAYOUTS,
				RADIUS_LAYOUT_ITEM_IDS, getLayoutInflater(),
				(ViewGroup) findViewById(RADIUS_SUB_LAYOUT_ID),
				RADIUS_ITEM_CONTAINER_ID, RADIUS_ITEM_BODACIOUS,
				radiusItemPopulater, BODACIOUS_LISTVIEW_ID);

		int numberOfItems = 2;
		setUpList(numberOfItems);
		setupButtons();
		// CircleMaker.printCarts(4);
	}

	private void setupButtons() {

		int offset = 2;
		for (int i = offset; i < btnIds.length + offset; i++) {
			((Button) findViewById(btnIds[i - offset]))
					.setOnClickListener(new BodOnClickListener(i));
		}

	}

	public void setUpList(int numberOfItems) {
		BodaciousAdapter<String> bodaciousStringAdapter = new BodaciousAdapter<String>(
				radiusItemPopulater, getLayoutInflater());
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < numberOfItems; i++)
			list.add("~" + i);
		bodaciousStringAdapter.setList(list, THE_BODACIOUS_ONE);

		radial.setAdapter(bodaciousStringAdapter);
	}

	private class BodOnClickListener implements OnClickListener {
		private int numberOfItems;

		public BodOnClickListener(int numberOfItems) {
			this.numberOfItems = numberOfItems;
		}

		@Override
		public void onClick(View v) {
			setUpList(numberOfItems);
		}
	}
}
