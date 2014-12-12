package com.thalespf.demo.android.presentation.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.thalespf.demo.R;
import com.thalespf.demo.Registry;
import com.thalespf.demo.Util;
import com.thalespf.demo.android.presentation.task.SyncStudentTask;
import com.thalespf.demo.android.presentation.ui.fragment.ListStudentFragment;
import com.thalespf.demo.domain.Student;
import com.thalespf.demo.service.StudentService;

public class StudentListActivity extends ActionBarActivity {

	private ListStudentFragment listStudentFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Log.i(Util.getTag(this), "onCreate()");
		
		setContentView(R.layout.activity_lista_alunos);

		if (savedInstanceState == null) {
			listStudentFragment = new ListStudentFragment();
			getSupportFragmentManager().beginTransaction().add(R.id.container, listStudentFragment).commit();
		}
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Log.i(Util.getTag(this), "onStart()");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.i(Util.getTag(this), "onStop()");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(Util.getTag(this), "onDestroy()");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_student_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch (id) {
		case R.id.menu_novo:
			Log.i(Util.getTag(this), "Adicionando aluno");
			Intent intent = new Intent(this, StudentActivity.class);
			startActivity(intent);
			break;
		case R.id.menu_enviar_alunos:
			SyncStudentTask studentTask = new SyncStudentTask(this);
			studentTask.execute();
			break;
		case R.id.menu_receber_provas:
			Intent exams = new Intent(this, ListExamActivity.class);
			startActivity(exams);
			break;
		case R.id.menu_mapa:
			Intent goMap = new Intent(this, StudentMap.class);
			startActivity(goMap);
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		int id = item.getItemId();
		Uri data = null;
		switch (id) {
		case R.id.deletar:
			StudentService studentService = Registry.getInstance().getStudentService();
			studentService.delete(getStudentSelected());
			Log.i(Util.getTag(this), "Aluno deletado");
			listStudentFragment.loadList();
			break;
		case R.id.ligar:
			Intent telaDiscagem = new Intent(Intent.ACTION_CALL);
			data = Uri.parse("tel:" + getStudentSelected().getTelefone());
			telaDiscagem.setData(data);
			startActivity(telaDiscagem);
			break;
		case R.id.ir_site:
			Intent irSite = new Intent(Intent.ACTION_VIEW);
			String site = "www.google.com.br";
			data = Uri.parse("http://" + site);
			irSite.setData(data);
			startActivity(irSite);
			break;
		default:
			break;
		}
		return super.onContextItemSelected(item);
	}

	private Student getStudentSelected() {
		return listStudentFragment.getStudentSelected();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		getMenuInflater().inflate(R.menu.context_menu_student_list, menu);
		super.onCreateContextMenu(menu, v, menuInfo);
	}

}
