/**
 * 
 */
package com.thalespf.demo.android.presentation.ui.fragment;

import com.thalespf.demo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 * 
 */
public class ExamDetailsFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View layoutExamsDetails = inflater.inflate(R.layout.fragment_exam_details, container, false);
		return layoutExamsDetails;
	}

}
