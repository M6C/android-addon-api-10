package com.addon.api.graphics;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;

import com.google.android.maps.MapView;

public class ScreenShoot {

	public static byte[] toByteArray(MapView mapView, int quality) throws IOException {
    	ByteArrayOutputStream baos = null;
		BufferedOutputStream bos = null;
		byte[] ret = null;
		try {
			// Android GingerBread 2.3
			Bitmap bm = getMapScreenShoot(mapView);
			baos = new ByteArrayOutputStream();
			bos = new BufferedOutputStream(baos);
			if (bm.compress(CompressFormat.JPEG, quality, bos)) {
				bos.flush();
				baos.flush();
				ret = baos.toByteArray();
			}
		}
		finally {
			if (bos!=null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (baos!=null) {
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}


	private static Bitmap getMapScreenShoot(MapView mapView) {
		boolean enabled = mapView.isDrawingCacheEnabled();
		if (!enabled) {
			mapView.setDrawingCacheEnabled(true);
		}
		return mapView.getDrawingCache();
	}
}
