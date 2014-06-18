package org.cxt.yt;

import java.io.IOException;

import android.content.Context;
import android.graphics.Bitmap;

public class YunicaTovah {

	public static void setup(Context aContext) {

		T.setContext(aContext);

		L.i("YunicaTovah setup");

		IHTTPD httpdIhttpd = new LtHTTPD(new LtHTTPD.IDelegate() {

			@Override
			public String getViewHieracryJSON() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Bitmap getTextImage() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getResourceTextByName(String aResName) {
				return T.readTextFromAssets(aResName);

			}

			@Override
			public String getNotFoundResPageText() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Bitmap getBitmapByViewHashCode(int aHashCode) {
				// TODO Auto-generated method stub
				return null;
			}
		});

		try {
			httpdIhttpd.start();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

}
