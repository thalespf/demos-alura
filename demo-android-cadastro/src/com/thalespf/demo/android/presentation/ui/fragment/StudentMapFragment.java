package com.thalespf.demo.android.presentation.ui.fragment;

import java.util.List;

import android.annotation.SuppressLint;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.thalespf.demo.Registry;
import com.thalespf.demo.android.map.AddressToPosition;
import com.thalespf.demo.android.map.PositionListener;
import com.thalespf.demo.domain.Student;
import com.thalespf.demo.service.StudentService;

@SuppressLint("ValidFragment") public class StudentMapFragment extends SupportMapFragment {
	
	public StudentMapFragment() {
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
		StudentService studentService = Registry.getInstance().getStudentService();
		List<Student> students = studentService.findAll();
		for (Student student : students) {
			MarkerOptions marcador = new MarkerOptions();
			LatLng position = new AddressToPosition(getActivity()).getPosition(student.getEndereco());
			if(position != null) {
				marcador.position(position);
				marcador.title(student.getNome()).snippet(student.getEndereco());
	            getMap().addMarker(marcador);
			}
		}
	}

	public void center(LatLng position) {
		GoogleMap map = getMap();
		CameraUpdate camera = CameraUpdateFactory.newLatLngZoom(position, 15);
		map.animateCamera(camera);
	}

}