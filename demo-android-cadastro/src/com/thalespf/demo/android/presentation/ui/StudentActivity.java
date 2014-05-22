package com.thalespf.demo.android.presentation.ui;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.thalespf.demo.R;
import com.thalespf.demo.Registry;
import com.thalespf.demo.Util;
import com.thalespf.demo.android.presentation.ui.exception.ValidationError;
import com.thalespf.demo.android.presentation.ui.helper.ScreenStudentHelper;
import com.thalespf.demo.android.presentation.util.Extras;
import com.thalespf.demo.domain.Student;
import com.thalespf.demo.service.StudentService;

public class StudentActivity extends ActionBarActivity {

	protected static final int CAMERA_REQUEST_CODE = 0;
	private ScreenStudentHelper helper;
	private Student student;
	protected String profilePicture;

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if(requestCode == CAMERA_REQUEST_CODE) {
			if(resultCode ==  ActionBarActivity.RESULT_OK) {
				helper.loadImage(profilePicture);
			} else {
				profilePicture = null;
			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aluno);

		Bundle extras = getIntent().getExtras();
		student = null;
		if(extras != null) {
			student = (Student) extras.getSerializable(Extras.STUDENT_SELECTED);
			Log.i(Util.getTag(this), "Student selected: " + student);			
		}

		helper = new ScreenStudentHelper(this, student);

		Button botao = (Button) findViewById(R.id.salvarAlunoBotao);

		botao.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					Student formStudent = helper.getStudent();

					Registry registry = Registry.getInstance();
					StudentService studentService = registry.getStudentService();

					//indica que o aluno eh novo ou foi modificado
					if(formStudent != null) {
						Log.i(Util.getTag(this), "Salvando aluno");
						formStudent = studentService.save(formStudent);	
						Toast.makeText(StudentActivity.this, "Objeto aluno criado: " + formStudent.getNome(),
								Toast.LENGTH_SHORT).show();
					}

					finish();
				} catch(ValidationError e) {
					Toast.makeText(StudentActivity.this, "Por favor, " + e.getMessage(),
							Toast.LENGTH_LONG).show();
				} catch (Exception e) {
					Toast.makeText(StudentActivity.this, "Desculpe, " + e.getMessage(),
							Toast.LENGTH_LONG).show();
					Log.e(Util.getTag(this), "Error ao salvar aluno", e);
				}
			}

		});

		helper.getProfilePicture().setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

				File dir = Util.getProfilePictureDir(StudentActivity.this);
				String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
						Locale.getDefault()).format(new Date());
				String picture = String.format("profilePicture_%s.png", timeStamp);

				if(!dir.exists())
					dir.mkdirs();
				File image = new File(dir, picture);

				profilePicture = image.getName();

				camera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(image));

				startActivityForResult(camera, CAMERA_REQUEST_CODE);

			}

		});
	}

}
