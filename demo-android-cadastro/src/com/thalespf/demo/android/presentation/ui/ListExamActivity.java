/**
 * 
 */
package com.thalespf.demo.android.presentation.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.thalespf.demo.R;
import com.thalespf.demo.android.presentation.ui.fragment.ListExamFragment;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 * 
 */
public class ListExamActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_exams);

		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.exams_view, new ListExamFragment(), "listExams");
		transaction.commit();

	}
}
