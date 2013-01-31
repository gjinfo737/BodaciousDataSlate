package northwoods.discovery.bodaciousdataslate.tests.unit.adapter;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import northwoods.discovery.bodaciousdataslate.BodaciousAdapter;
import northwoods.discovery.bodaciousdataslate.BodaciousRadiusMaximus;
import northwoods.discovery.bodaciousdataslate.IRadiusItemusPopulus;
import northwoods.discovery.bodaciousdataslate.R.id;
import northwoods.discovery.bodaciousdataslate.R.layout;
import northwoods.discovery.bodaciousdataslate.activity.RadiusItemusPopulus_IconTitleSubTitle;
import northwoods.discovery.bodaciousdataslate.tests.unit.BodaciousTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations.Mock;

import android.app.Activity;

@RunWith(BodaciousTestRunner.class)
public class BodaciousAdapterTests {

	private static final int NUM_OF_OBJECTS = 10;
	private BodaciousAdapter<String> bodaciousAdapter;
	private Activity activity;
	@SuppressWarnings("deprecation")
	@Mock
	private BodaciousRadiusMaximus<String> radiusMaximus;

	@Before
	public void setUp() {
		activity = new Activity();
		IRadiusItemusPopulus radiusItemusPopulus = new RadiusItemusPopulus_IconTitleSubTitle(
				layout.item_layout, id.item_imageView, id.item_textView_title,
				id.item_textView_subTitle);
		this.bodaciousAdapter = new BodaciousAdapter<String>(
				radiusItemusPopulus, activity.getLayoutInflater());
		bodaciousAdapter.setBodaciousRadiusMaximus(radiusMaximus);
	}

	@Test
	public void itGivesTheCorrectCount() {
		assertThat(bodaciousAdapter.getCount(), is(theEmptyDataList().size()));
		bodaciousAdapter.setList(theFullDataList(), 0);
		assertThat(bodaciousAdapter.getCount(), is(theFullDataList().size()));
	}

	@Test
	public void itPutsTheBodaciousObjectLast() {
		bodaciousAdapter.setList(theFullDataList(), 5);
		assertThat(bodaciousAdapter.getItem(NUM_OF_OBJECTS - 1),
				is(getItemID(5)));
	}

	@Test
	public void itCreatesAView() {
		bodaciousAdapter.setList(theFullDataList(), 5);
		assertThat(bodaciousAdapter.getView(0, null, null), notNullValue());
	}

	@Test
	public void itSortsCorrectlyWhenBodaciousIsZero() {
		List<String> theFullDataList = theFullDataList();
		bodaciousAdapter.setList(theFullDataList, 0);
		assertThat(bodaciousAdapter.getItem(bodaciousAdapter.getCount() - 1),
				is(theFullDataList.get(0)));
	}

	@Test
	public void itSortsCorrectlyWhenBodaciousIsInTheMiddle() {
		List<String> theFullDataList = theFullDataList();
		bodaciousAdapter.setList(theFullDataList, 5);
		assertThat(bodaciousAdapter.getItem(bodaciousAdapter.getCount() - 1),
				is(theFullDataList.get(5)));
	}

	@Test
	public void itSortsCorrectlyWhenBodaciousIsTheLast() {
		List<String> theFullDataList = theFullDataList();
		bodaciousAdapter.setList(theFullDataList, theFullDataList.size() - 1);
		assertThat(bodaciousAdapter.getItem(bodaciousAdapter.getCount() - 1),
				is(theFullDataList.get(theFullDataList.size() - 1)));
	}

	//
	private List<String> theFullDataList() {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < NUM_OF_OBJECTS; i++)
			list.add(getItemID(i));
		return list;
	}

	public String getItemID(int i) {
		return "_" + i;
	}

	private List<String> theEmptyDataList() {
		return new ArrayList<String>();
	}

}
