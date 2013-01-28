package northwoods.discovery.bodaciousdataslate.activity;

import android.util.Log;

public class CircleMaker {
	public static void printCarts(int num) {
		// ~~~~~~~~~~~~~~~~~~~~~~
		double radius = 200;
		double angle_step = 360 / num;
		double angle = 0;
		Log.e("", num + "  :::::::::::::::::::::::::::::::::");
		for (int i = 0; i < num; i++) {
			angle = i * angle_step;
			double rads = angle * Math.PI / 180;
			int x = (int) (radius * Math.cos(rads));
			int y = (int) (-radius * Math.sin(rads));
			Log.e("", x + ":   :" + y);

		}
		Log.e("", ":: :::::::::::::::::::::::::::::::::");
		// ~~~~~~~~~~~~~~~~~~~~~~
	}
}
