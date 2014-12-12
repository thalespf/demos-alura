/**
 * 
 */
package com.thalespf.demo.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class BatteryReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		int valor = intent.getIntExtra("level", 0);
		Toast.makeText(context, valor + "%", Toast.LENGTH_SHORT).show() ;
	}

}
