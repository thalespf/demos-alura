/**
 * 
 */
package com.thalespf.demo;

import java.io.File;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.view.Gravity;
import android.widget.Toast;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 * 
 */
public class Util {

	public static String getTag(Object clazz) {
		return clazz.getClass().getSimpleName();
	}

	public static File getProfilePictureDir(Activity activity) {
		File externalStoragePublicDirectory = Environment.
				getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
		return new File(externalStoragePublicDirectory, "AgendaAlura");
	}
	
	public static void showMessage(Context activity, String message) {
		Toast makeText = Toast.makeText(activity, message,
				Toast.LENGTH_SHORT);
		makeText.setGravity(Gravity.CENTER, 0, 0);
		makeText.show();
	}
}
