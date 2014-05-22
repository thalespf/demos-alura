package com.thalespf.demo.android.presentation.ui.fragment;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.thalespf.demo.R;
import com.thalespf.demo.Registry;
import com.thalespf.demo.android.presentation.ui.StudentActivity;
import com.thalespf.demo.android.presentation.ui.adapter.ListStudentAdapter;
import com.thalespf.demo.android.presentation.util.Extras;
import com.thalespf.demo.domain.Student;
import com.thalespf.demo.service.StudentService;

/**
 * Fragmento para exibir a lista de alunos
 * 
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class ListStudentFragment extends Fragment {
	
	private ListView listaAlunos;
	private BaseAdapter adapter;
	private Student studentSelected;

	@Override
	public void onResume() {
		super.onResume();
		
		loadList();
	}

	public ListStudentFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_list_student, container, false);

		listaAlunos = (ListView) rootView.findViewById(R.id.lista);

		registerForContextMenu(listaAlunos);
		
		loadList();
		
		listaAlunos.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Student student = (Student) adapter.getItem(position);
				Intent studentForm = new Intent(ListStudentFragment.this.getActivity(), 
						StudentActivity.class);
				studentForm.putExtra(Extras.STUDENT_SELECTED, student);
				startActivity(studentForm);
			}

		});

		listaAlunos.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position,
					long id) {
				
				setStudentSelected((Student) adapter.getItem(position));
				
				return false;
			}

		});

		return rootView;
	}

	protected void setStudentSelected(Student student) {
		this.studentSelected = student;
	}

	public void loadList() {
		StudentService studentService = Registry.getInstance().getStudentService();
		List<Student> alunos = studentService.findAll();
		adapter = new ListStudentAdapter(alunos, getActivity());
		listaAlunos.setAdapter(adapter);
	}

	public Student getStudentSelected() {
		return studentSelected;
	}
	
}