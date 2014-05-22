/**
 * 
 */
package com.thalespf.demo.android.presentation.ui.adapter;

import java.util.List;

import com.thalespf.demo.R;
import com.thalespf.demo.android.presentation.util.UIUtil;
import com.thalespf.demo.domain.Student;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class ListStudentAdapter extends BaseAdapter {
	
	private List<Student> students;
	private FragmentActivity activity;

	public ListStudentAdapter(List<Student> students, FragmentActivity activity) {
		this.students = students;
		this.activity = activity;
	}
	
	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if(convertView == null) {
			LayoutInflater layoutInflater = activity.getLayoutInflater();
			convertView = layoutInflater.inflate(R.layout.row_list_student, null);
			viewHolder = new ViewHolder();
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		
		viewHolder.background = (LinearLayout) convertView.findViewById(R.id.fundo);
		viewHolder.profilePicture = (ImageView) convertView.findViewById(R.id.foto);
		viewHolder.nome = (TextView) convertView.findViewById(R.id.nome);
		
		Student student = students.get(position);
		viewHolder.nome.setText(student.getNome());
		
		if(position % 2 == 0) {
			viewHolder.background.setBackgroundColor(activity.getResources().getColor(R.color.linha_par));
		} else {
			viewHolder.background.setBackgroundColor(activity.getResources().getColor(R.color.linha_impar));
		}
		
		String foto = student.getFoto();
		if(foto != null) {
			UIUtil.loadImage(activity, viewHolder.profilePicture, foto);
		} else {
			viewHolder.profilePicture.setImageResource(R.drawable.ic_launcher);
		}
		
		return convertView;
	}
	
	static class ViewHolder {

		public LinearLayout background;
		public TextView nome;
		public ImageView profilePicture;

	}
	
	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		return students.size();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int position) {
		return students.get(position);
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int position) {
		return students.get(position).getId();
	}

}
