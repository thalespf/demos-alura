/**
 * 
 */
package com.thalespf.demo.android.presentation.task;

import java.util.List;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

import com.thalespf.demo.Registry;
import com.thalespf.demo.android.presentation.ui.StudentListActivity;
import com.thalespf.demo.domain.Student;
import com.thalespf.demo.util.JSONConverter;
import com.thalespf.demo.util.WebClient;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class SyncStudentTask extends AsyncTask<Integer, Double, String> {

	private StudentListActivity activity;
	private ProgressDialog progress;

	public SyncStudentTask(StudentListActivity activity) {
		this.activity = activity;
	}
	
	@Override
	protected void onPreExecute() {
		progress = ProgressDialog.show(activity, "Aguarde...", "Enviando dados...", true, true);
		
	}

	/* (non-Javadoc)
	 * @see android.os.AsyncTask#doInBackground(Params[])
	 */
	@Override
	protected String doInBackground(Integer... params) {
		String url = "http://www.caelum.com.br/mobile";
		
		List<Student> student = Registry.getInstance().getStudentService().findAll();
		
		JSONConverter jsonConverter = new JSONConverter();
		
		String dadosJson = jsonConverter.toJSON(student);
		WebClient webClient = new WebClient(url);
		String respostaJson = webClient.post(dadosJson);
		
		return respostaJson;
	}
	
	@Override
	protected void onPostExecute(String result) {
		progress.dismiss();
		Toast.makeText(activity, result, Toast.LENGTH_LONG).show();
	}

}
