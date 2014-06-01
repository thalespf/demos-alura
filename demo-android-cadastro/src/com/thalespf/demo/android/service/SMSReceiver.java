/**
 * 
 */
package com.thalespf.demo.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.telephony.SmsMessage;
import android.util.Log;

import com.thalespf.demo.R;
import com.thalespf.demo.Registry;
import com.thalespf.demo.Util;
import com.thalespf.demo.domain.Student;
import com.thalespf.demo.service.StudentService;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class SMSReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Object[] messages = (Object[]) intent.getExtras().get("pdus");
		
		byte[] content = (byte[]) messages[0];
		
		SmsMessage smsMessage = SmsMessage.createFromPdu(content);
		
		String telephonyNumber = smsMessage.getDisplayOriginatingAddress();
		Log.i(Util.getTag(this), telephonyNumber);
		
		StudentService studentService = Registry.getInstance().getStudentService();
		Student student = studentService.findByTelephony(telephonyNumber);
		
		if(student != null) {
			MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.msg);
			mediaPlayer.start();
		}
	}

}
