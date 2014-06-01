package com.thalespf.demo.android.presentation.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.thalespf.demo.R;
import com.thalespf.demo.android.map.PositionListener;
import com.thalespf.demo.android.presentation.ui.fragment.StudentMapFragment;

public class StudentMap extends ActionBarActivity {

	private PositionListener positionListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_map);
		
		if (savedInstanceState == null) {
			StudentMapFragment studentMapFragment = new StudentMapFragment();
			getSupportFragmentManager().beginTransaction().add(R.id.container,
					studentMapFragment).commit();
			positionListener = new PositionListener(this, studentMapFragment);
		}
		
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		positionListener.cancel();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.student_map, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
