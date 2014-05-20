package com.thalespf.demo.android.presentation.ui.helper;

import android.widget.EditText;
import android.widget.SeekBar;

import com.thalespf.demo.R;
import com.thalespf.demo.android.presentation.ui.StudentActivity;
import com.thalespf.demo.android.presentation.ui.exception.ValidationError;
import com.thalespf.demo.domain.Student;

public class ScreenStudentHelper {
	
	private EditText nome;
	private EditText telefone;
	private Student student;
	private EditText endereco;
	private EditText site;
	private SeekBar nota;

	public ScreenStudentHelper(StudentActivity activity) {
		nome = (EditText) activity.findViewById(R.id.nome);
		telefone = (EditText) activity.findViewById(R.id.telefone);
		endereco = (EditText) activity.findViewById(R.id.endereco);
		site = (EditText) activity.findViewById(R.id.site);
		nota = (SeekBar) activity.findViewById(R.id.nota);
	}

	public Student getAluno() throws ValidationError {
		student = new Student();
		
		student.setNome(nome.getEditableText().toString());
		student.setTelefone(telefone.getEditableText().toString());
		student.setEndereco(endereco.getEditableText().toString());
		student.setSite(site.getEditableText().toString());
		student.setNota(nota.getProgress());
		
		Validater validater = new Validater();  
		validater.valid(student);

		return student;
	}

}
