package org.cxt.yt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.cxt.yt.NanoHTTPD.Response.Status;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;

public class LtHTTPD extends NanoHTTPD {

	public interface IDelegate {

		String getResourceTextByName(String aResName);

		String getNotFoundResPageText();

		Bitmap getTextImage();

		String getViewHieracryJSON();

		Bitmap getBitmapByViewHashCode(int aHashCode);

	}

	private IDelegate mDelegate;

	public LtHTTPD(IDelegate aDelegate) {
		super(GConfig.HTTP_PORT);
		this.mDelegate = aDelegate;
	}

	@Override
	public Response serve(IHTTPSession session) {
		
		
		if (false)
		{

			Method method = session.getMethod();
			String uri = session.getUri();

			System.out.println("LTHTTPD:" + method + " '" + uri + "' ");

			if (uri.endsWith("png")) {
				// request image.

				// url like : http://hostname/viewSnap/12312312.png

				// Bitmap bitmap = this.mDelegate.getTextImage();

				int indexOfHashCodeStart = uri.indexOf("viewSnap") + "viewSnap".length() + 1;
				int indexOfPngSuffix = uri.indexOf("png") - 1;
				String hashCode = uri.substring(indexOfHashCodeStart, indexOfPngSuffix);

				Bitmap bitmap = this.mDelegate.getBitmapByViewHashCode(Integer.valueOf(hashCode));

				if (null == bitmap) {
					return null;
				}

				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				bitmap.compress(CompressFormat.PNG, 100 /* ignored for PNG */, bos);
				byte[] bitmapdata = bos.toByteArray();
				ByteArrayInputStream bs = new ByteArrayInputStream(bitmapdata);

				NanoHTTPD.Response imageRsp = new NanoHTTPD.Response(Status.OK, "image/png", bs);
				return imageRsp;
			} else {
				String vhJSON = this.mDelegate.getViewHieracryJSON();
				return new NanoHTTPD.Response(vhJSON);
			}

		
		}
		
		
		return new NanoHTTPD.Response("hi....");

		
	}

	private String getNotFoundResPageText() {
		return this.mDelegate.getNotFoundResPageText();
	}

	private String getResourceTextByName(String aResName) {
		String ret = null;

		ret = this.mDelegate.getResourceTextByName(aResName);

		return ret;
	}

}
