package org.cxt.yt;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import android.content.Context;

public class T {

	private static Context sContext;

	public static void setContext(Context aContext) {
		sContext = aContext;
	}

	public static Context getContext() {
		return sContext;
	}

	public static String readTextFromAssets(String aResName) {

		try {
			InputStreamReader inputReader = new InputStreamReader(getContext().getAssets().open(aResName));
			BufferedReader bufReader = new BufferedReader(inputReader);
			String line;
			StringBuilder ret = new StringBuilder();
			while ((line = bufReader.readLine()) != null) {
				ret.append(line);
			}
			return ret.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
}
