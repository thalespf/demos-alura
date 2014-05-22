package com.thalespf.demo.android.presentation.ui.helper;

import java.io.File;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.thalespf.demo.R;
import com.thalespf.demo.Util;
import com.thalespf.demo.android.presentation.ui.StudentActivity;
import com.thalespf.demo.android.presentation.ui.exception.ValidationError;
import com.thalespf.demo.android.presentation.util.UIUtil;
import com.thalespf.demo.domain.Student;

public class ScreenStudentHelper {
	
	private EditText nomeText;
	private EditText telefoneText;
	private Student student;
	private EditText enderecoText;
	private EditText siteText;
	private SeekBar notaText;
	private StudentActivity activity;
	private ImageView profilePictureView;
	private String profilePicture;

	public ScreenStudentHelper(StudentActivity activity, Student student) {
		this.activity = activity;
		this.student = student;
		getComponents(activity);
		updateUI(student);
	}

	private void updateUI(Student student) {
		if(student != null) {
			Button botao = (Button) activity.findViewById(R.id.salvarAlunoBotao);
			botao.setText("Alterar");
			
			nomeText.setText(student.getNome());
			telefoneText.setText(student.getTelefone());
			enderecoText.setText(student.getEndereco());
			siteText.setText(student.getSite());
			notaText.setProgress((int) student.getNota());
			
			if(student.getFoto() != null) {
				loadImage(student.getFoto());
			}
		}
	}

	private void getComponents(StudentActivity activity) {
		nomeText = (EditText) activity.findViewById(R.id.nome);
		telefoneText = (EditText) activity.findViewById(R.id.telefone);
		enderecoText = (EditText) activity.findViewById(R.id.endereco);
		siteText = (EditText) activity.findViewById(R.id.site);
		notaText = (SeekBar) activity.findViewById(R.id.nota);
		profilePictureView = (ImageView) activity.findViewById(R.id.profilePicture);
	}

	public Student getStudent() throws ValidationError {
		String nome = nomeText.getEditableText().toString();
		String telefone = telefoneText.getEditableText().toString();
		String endereco = enderecoText.getEditableText().toString();
		String site = siteText.getEditableText().toString();
		int nota = notaText.getProgress();
		//verifique se houve modificacao
		if(student != null && telefone.equals(student.getTelefone()) &&
				nome.equals(student.getNome()) &&
				endereco.equals(student.getEndereco()) &&
				site.equals(student.getSite()) &&
				nota == student.getNota() &&
				profilePicture != null && profilePicture.equals(student.getFoto())) {
			return null;
		}
		
		Student newStudent = new Student();
		if(student != null) {
			Long id = student.getId();
			newStudent.setId(id);
		}
		
		newStudent.setNome(nome);
		newStudent.setTelefone(telefone);
		newStudent.setEndereco(endereco);
		newStudent.setSite(site);
		newStudent.setNota(nota);
		newStudent.setFoto(profilePicture);
		
		Validater validater = new Validater();  
		validater.valid(newStudent);

		return newStudent;
	}
	
	public ImageView getProfilePicture() {
		return profilePictureView;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public void loadImage(String profilePicture) {
		setProfilePicture(profilePicture);
		UIUtil.loadImage(activity, profilePictureView, profilePicture);
	}

	public void loadImage(Bitmap imageBitmap) {
		profilePictureView.setImageBitmap(imageBitmap);
	}

}
