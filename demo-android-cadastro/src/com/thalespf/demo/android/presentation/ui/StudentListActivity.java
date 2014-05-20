package com.thalespf.demo.android.presentation.ui;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.thalespf.demo.Constants;
import com.thalespf.demo.R;
import com.thalespf.demo.Registry;
import com.thalespf.demo.domain.Student;
import com.thalespf.demo.service.StudentService;

public class StudentListActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Log.i(Constants.getTag(this), "onCreate()");
		
		setContentView(R.layout.activity_lista_alunos);

		if (savedInstanceState == null) {
			PlaceholderFragment placeholderFragment = new PlaceholderFragment();
			getSupportFragmentManager().beginTransaction().add(R.id.container, placeholderFragment).commit();
		}
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		
		Log.i(Constants.getTag(this), "onStart()");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		
		Log.i(Constants.getTag(this), "onStop()");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		Log.i(Constants.getTag(this), "onDestroy()");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista_alunos, menu);
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
			Log.i(Constants.getTag(this), "Adicionando aluno");
			Intent intent = new Intent(this, StudentActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		menu.add("Ligar");
		menu.add("Enviar SMS");
		menu.add("Navegar no Site");
		menu.add("Deletar");
		menu.add("Ver no Mapa");
		menu.add("Enviar E-mail");

		super.onCreateContextMenu(menu, v, menuInfo);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container, false);

			ListView listaAlunos = (ListView) rootView.findViewById(R.id.lista);

			registerForContextMenu(listaAlunos);

			StudentService studentService = Registry.getInstance().getStudentService();
			List<Student> alunos = studentService.findAll();
			BaseAdapter adapter = new ArrayAdapter<Student>(getActivity(),
					android.R.layout.simple_list_item_1, alunos);
			listaAlunos.setAdapter(adapter);

			listaAlunos.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					Toast makeText = Toast.makeText(getActivity(), "Click na posicao " + position,
							Toast.LENGTH_SHORT);
					makeText.setGravity(Gravity.CENTER, 0, 0);
					makeText.show();
				}

			});

			listaAlunos.setOnItemLongClickListener(new OnItemLongClickListener() {

				@Override
				public boolean onItemLongClick(AdapterView<?> parent, View view, int position,
						long id) {
					Toast makeText = Toast.makeText(getActivity(), "Click na posicao " + position,
							Toast.LENGTH_SHORT);
					makeText.setGravity(Gravity.CENTER, 0, 0);
					makeText.show();
					return false;
				}

			});

			return rootView;
		}
	}

}
