package northwoods.discovery.bodaciousdataslate;

import java.util.ArrayList;
import java.util.List;

import northwoods.discovery.bodaciousdataslate.R.id;
import northwoods.discovery.bodaciousdataslate.R.layout;
import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

public class MainActivity extends Activity {

	private static final int RADIUS_ITEM_BODACIOUS = id.bod_radius_item_bodacious;
	public static final int RADIUS_SUB_LAYOUT_ID = id.sub_rellay;
	public static final int RADIUS_ITEM_CONTAINER_ID = id.bod_radius_item_container;
	public static final int[] RADIUS_LAYOUTS = new int[] { layout.bod_radius_0,
			layout.bod_radius_1 };
	public static final int[] RADIUS_LAYOUT_ITEM_IDS = new int[] {
			id.bod_radius_item_0, id.bod_radius_item_1 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// GridView grid = (GridView) findViewById(id.gridView1);

		// grid.setAdapter(bodStringAdapter);

		BodaciousAdapter<String> bodaciousStringAdapter = new BodaciousAdapter<String>(
				getApplicationContext());
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 2; i++)
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
