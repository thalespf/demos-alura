/**
 * 
 */
package com.thalespf.demo.android.presentation.ui.fragment;

import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.thalespf.demo.R;
import com.thalespf.demo.domain.Exam;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class ListExamFragment extends Fragment {
	
	private ListView listViewExams;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View layoutProvas = inflater.inflate(R.layout.fragment_list_exam, container, false);
		
		Exam Exam1 = new Exam("20/03/2012", "Matematica");
		Exam1.setTopics(Arrays.asList("Algebra linear", "Integral", "Diferencial"));

		Exam Exam2 = new Exam("25/03/2012", "Portugues");
		Exam2.setTopics(Arrays.asList("Complemento nominal", "Oracoes Subordinadas"));

		List<Exam> Exams = Arrays.asList(Exam1, Exam2);

		this.listViewExams = (ListView) layoutProvas.findViewById(R.id.exams_list);
		this.listViewExams.setAdapter(new ArrayAdapter<Exam>(getActivity(),
				android.R.layout.simple_list_item_1, Exams));
		
		return layoutProvas;
	}

}
