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
import android.view.ViewGroup;

public class MainActivity extends Activity {

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// GridView grid = (GridView) findViewById(id.gridView1);

		// grid.setAdapter(bodStringAdapter);

		BodaciousAdapter<String> bodaciousStringAdapter = new BodaciousAdapter<String>(
				getApplicationContext());
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 4; i++)
			list.add("~" + i);
		bodaciousStringAdapter.setList(list, 0);

		RadiusItemusPopulus_IconTitleSubTitle radiusItemPopulater = new RadiusItemusPopulus_IconTitleSubTitle(
				layout.item_layout, id.item_imageView, id.item_textView_title,
				id.item_textView_subTitle);
		BodaciousRadiusMaximus<String> radial = new BodaciousRadiusMaximus<String>(
				RADIUS_LAYOUTS, RADIUS_LAYOUT_ITEM_IDS, getLayoutInflater(),
				(ViewGroup) findViewById(RADIUS_SUB_LAYOUT_ID),
				RADIUS_ITEM_CONTAINER_ID, RADIUS_ITEM_BODACIOUS,
				radiusItemPopulater);

		radial.setAdapter(bodaciousStringAdapter);

	}
}
