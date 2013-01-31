package northwoods.discovery.bodaciousdataslate.tests.unit.radius;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import northwoods.discovery.bodaciousdataslate.IRadiusItemusPopulus;
import northwoods.discovery.bodaciousdataslate.R.id;
import northwoods.discovery.bodaciousdataslate.R.layout;
import northwoods.discovery.bodaciousdataslate.RadiusItemusPopulus_IconTitleSubTitle;
import northwoods.discovery.bodaciousdataslate.tests.unit.BodaciousTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations.Mock;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

@SuppressWarnings("deprecation")
@RunWith(BodaciousTestRunner.class)
public class RadiusItemusPopulus_IconTitleSubTitleTests {
	private Activity activity;
	private IRadiusItemusPopulus radiusItemusPopulus;
	@Mock
	private ViewGroup layoutMock;

	@Before
	public void setUp() {
		activity = new Activity();
		radiusItemusPopulus = new RadiusItemusPopulus_IconTitleSubTitle(
				layout.item_layout, id.item_imageView, id.item_textView_title,
				id.item_textView_subTitle);
	}

	@Test
	public void itCreatesAView() {
		ViewGroup actualView = radiusItemusPopulus
				.setViewForData(activity.getLayoutInflater(), null, "data",
						false, View.VISIBLE);

		assertThat(actualView, notNullValue());
	}

	@Test
	public void itModifiesAnExistingView() {

		ViewGroup actualView = radiusItemusPopulus.setViewForData(
				activity.getLayoutInflater(), layoutMock, "data", false,
				View.VISIBLE);

		assertThat(actualView, notNullValue());
	}

	@Test
	public void itDoesNotModifyNonBodaciousViewVisibility() {

		ViewGroup actualView = radiusItemusPopulus.setViewForData(
				activity.getLayoutInflater(), layoutMock, "data", false,
				View.GONE);

		assertThat(actualView.getVisibility(), is(View.VISIBLE));
	}

	@Test
	public void itDoesNotModifyNonBodaciousViewVisibilityOverload() {

		ViewGroup actualView = radiusItemusPopulus.setViewForRegularData(
				activity.getLayoutInflater(), layoutMock, "data");

		assertThat(actualView.getVisibility(), is(View.VISIBLE));
	}

	@Test
	public void itDoesModifyBodaciousViewVisibility() {

		ViewGroup actualView = radiusItemusPopulus.setViewForData(
				activity.getLayoutInflater(), layoutMock, "data", true,
				View.GONE);

		assertThat(actualView.getVisibility(), is(View.GONE));
	}
}
