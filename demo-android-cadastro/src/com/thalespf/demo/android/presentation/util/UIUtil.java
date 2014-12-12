/**
 * 
 */
package com.thalespf.demo.android.presentation.util;

import java.io.File;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.thalespf.demo.Util;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class UIUtil {
	
	public static void loadImage(Activity activity, ImageView imageView, String profilePicture) {
		File dir = Util.getProfilePictureDir(activity);
		File image = new File(dir + File.separator + profilePicture);
		
		Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(), null);
		
		if(bitmap == null) {
			Util.showMessage(activity, "Desculpe, nao foi possivel carregar a imagem");
			return;
		}
			
		Bitmap bitmapScaled = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
		imageView.setImageBitmap(bitmapScaled);
	}

}
