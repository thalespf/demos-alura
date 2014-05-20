package com.thalespf.demo.android.presentation.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.thalespf.demo.Constants;
import com.thalespf.demo.R;
import com.thalespf.demo.Registry;
import com.thalespf.demo.android.presentation.ui.exception.ValidationError;
import com.thalespf.demo.android.presentation.ui.helper.ScreenStudentHelper;
import com.thalespf.demo.domain.Student;
import com.thalespf.demo.service.StudentService;

public class StudentActivity extends ActionBarActivity {

	private ScreenStudentHelper helper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aluno);
		
        helper = new ScreenStudentHelper(this);

        Button botao = (Button) findViewById(R.id.salvarAlunoBotao);

        botao.setOnClickListener(new OnClickListener() {
        	
            @Override
            public void onClick(View v) {
				try {
					Student student = helper.getAluno();
					
					Registry registry = Registry.getInstance();
					StudentService studentService = registry.getStudentService();
					
					student = studentService.save(student);
					
	                Toast.makeText(StudentActivity.this, "Objeto aluno criado: " + student.getNome(),
	                         Toast.LENGTH_SHORT).show();
	                
	                finish();
				} catch(ValidationError e) {
	                Toast.makeText(StudentActivity.this, "Por favor, " + e.getMessage(),
	                         Toast.LENGTH_LONG).show();
				} catch (Exception e) {
	                Toast.makeText(StudentActivity.this, "Desculpe, " + e.getMessage(),
	                         Toast.LENGTH_LONG).show();
					Log.e(Constants.getTag(this), "Error ao salvar aluno", e);
				}
            }
            
        });
	}
	
}
