package org.cxt.yt;
import org.cxt.yt.BuildConfig;

public class L {
	public static void i(Object aI) {
		if (BuildConfig.DEBUG) {
			System.out.println(YunicaTovah.class.getSimpleName() + " " + System.currentTimeMillis() + " : " + aI);
		}
	}

	public static void e(Object aI) {
		if (BuildConfig.DEBUG) {
			System.err.println(YunicaTovah.class.getSimpleName() + " " + System.currentTimeMillis() + " : " + aI);
		}
	}

}
