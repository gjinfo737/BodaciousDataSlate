package northwoods.discovery.bodaciousdataslate.tests.unit.radius;

import static northwoods.discovery.bodaciousdataslate.activity.MainActivity.BODACIOUS_LISTVIEW_ID;
import static northwoods.discovery.bodaciousdataslate.activity.MainActivity.BOD_RADIUS_DEFAULT_LAYOUT;
import static northwoods.discovery.bodaciousdataslate.activity.MainActivity.RADIUS_ITEM_BODACIOUS;
import static northwoods.discovery.bodaciousdataslate.activity.MainActivity.RADIUS_ITEM_CONTAINER_ID;
import static northwoods.discovery.bodaciousdataslate.activity.MainActivity.RADIUS_LAYOUTS;
import static northwoods.discovery.bodaciousdataslate.activity.MainActivity.RADIUS_LAYOUT_ITEM_IDS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import northwoods.discovery.bodaciousdataslate.BodaciousAdapter;
import northwoods.discovery.bodaciousdataslate.BodaciousRadiusMaximus;
import northwoods.discovery.bodaciousdataslate.IRadiusItemusPopulus;
import northwoods.discovery.bodaciousdataslate.R.id;
import northwoods.discovery.bodaciousdataslate.R.layout;
import northwoods.discovery.bodaciousdataslate.RadiusItemusPopulus_IconTitleSubTitle;
import northwoods.discovery.bodaciousdataslate.tests.unit.BodaciousTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations.Mock;

import android.app.Activity;
import android.view.ViewGroup;

@RunWith(BodaciousTestRunner.class)
public class BodaciousRadiusMaximusTests {

	private Activity activity;
	private BodaciousRadiusMaximus<String> bodaciousRadiusMaximus;
	@Mock
	private ViewGroup mainLayout;
	@Mock
	private BodaciousAdapter<String> bodaciousStringAdapter;

	@Before
	public void setUp() {
		activity = new Activity();
		IRadiusItemusPopulus radiusItemusPopulus = new RadiusItemusPopulus_IconTitleSubTitle(
				layout.item_layout, id.item_imageView, id.item_textView_title,
				id.item_textView_subTitle);
		// this.bodaciousRadiusMaximus = new BodaciousRadiusMaximus<String>(
		// RADIUS_LAYOUTS, RADIUS_LAYOUT_ITEM_IDS,
		// activity.getLayoutInflater(), mainLayout,
		// RADIUS_ITEM_CONTAINER_ID, RADIUS_ITEM_BODACIOUS, null);
		this.bodaciousRadiusMaximus = new BodaciousRadiusMaximus<String>(
				BOD_RADIUS_DEFAULT_LAYOUT, RADIUS_LAYOUTS,
				RADIUS_LAYOUT_ITEM_IDS, activity.getLayoutInflater(),
				mainLayout, RADIUS_ITEM_CONTAINER_ID, RADIUS_ITEM_BODACIOUS,
				radiusItemusPopulus, BODACIOUS_LISTVIEW_ID);
	}

	@Test
	public void setAdapterCallsMainLayoutRemoveAllViewsAndAddView() {
		setupTheAdapter(0);
		bodaciousRadiusMaximus.setAdapter(bodaciousStringAdapter);
		Mockito.verify(mainLayout).removeAllViews();
		Mockito.verify(mainLayout).addView(Mockito.any(ViewGroup.class));
	}

	@Test
	public void itChoosesTheCorrectLayoutAtTheMin() {
		setupTheAdapter(2);
		assertThat(
				bodaciousRadiusMaximus
						.determineAppropriateLayout(bodaciousStringAdapter),
				is(RADIUS_LAYOUTS[0]));
	}

	@Test
	public void itChoosesTheCorrectLayoutWithCountTooMany() {
		setupTheAdapter(100);
		assertThat(
				bodaciousRadiusMaximus
						.determineAppropriateLayout(bodaciousStringAdapter),
				is(BOD_RADIUS_DEFAULT_LAYOUT));
	}

	@Test
	public void itChoosesTheCorrectLayoutWithCountNegative() {
		setupTheAdapter(-100);
		assertThat(
				bodaciousRadiusMaximus
						.determineAppropriateLayout(bodaciousStringAdapter),
				is(RADIUS_LAYOUTS[0]));
	}

	@Test
	public void itChoosesTheCorrectLayoutWithCountZero() {
		setupTheAdapter(0);
		assertThat(
				bodaciousRadiusMaximus
						.determineAppropriateLayout(bodaciousStringAdapter),
				is(RADIUS_LAYOUTS[0]));
	}

	private void setupTheAdapter(Integer count) {
		Mockito.when(bodaciousStringAdapter.getCount()).thenReturn(count);
	}
}
