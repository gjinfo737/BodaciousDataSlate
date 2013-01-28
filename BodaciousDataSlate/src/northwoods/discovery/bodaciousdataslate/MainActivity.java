package northwoods.discovery.bodaciousdataslate;

import java.util.ArrayList;
import java.util.List;

import northwoods.discovery.bodaciousdataslate.R.id;
import northwoods.discovery.bodaciousdataslate.R.layout;
import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

public class MainActivity extends Activity {

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
		bodaciousStringAdapter.setList(list, 1);

		int[] layouts = new int[] { layout.bod_radius_0, layout.bod_radius_1 };
		int[] layoutsItemIds = new int[] { id.bod_radius_item_0,
				id.bod_radius_item_1 };
		BodaciousRadiusMaximus<String> radial = new BodaciousRadiusMaximus<String>(
				getApplicationContext(), layouts, layoutsItemIds,
				getLayoutInflater(), (ViewGroup) findViewById(id.sub_rellay),
				id.sub_rellay);

		radial.setAdapter(bodaciousStringAdapter);

	}
}
