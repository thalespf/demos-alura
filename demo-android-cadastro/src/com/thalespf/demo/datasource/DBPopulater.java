package com.thalespf.demo.datasource;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.thalespf.demo.Constants;
import com.thalespf.demo.R;
import com.thalespf.demo.Registry;
import com.thalespf.demo.android.presentation.ui.exception.ValidationError;
import com.thalespf.demo.android.presentation.ui.helper.Validater;
import com.thalespf.demo.datasource.DBDefinition.StudentDescription;
import com.thalespf.demo.datasource.DBDefinition.Tables;
import com.thalespf.demo.domain.Student;
import com.thalespf.demo.service.StudentService;

public class DBPopulater {

	public DBPopulater() {
	}

	public void populateDatabase(SQLiteDatabase db) {
		Context context = Registry.getInstance().getContext();
		XmlResourceParser alunos = context.getResources().getXml(R.xml.alunos_data);
		try {
			// Check for end of document
			int eventType = alunos.getEventType();
			while (eventType != XmlPullParser.END_DOCUMENT) {
				// Search for record tags
				if ((eventType == XmlPullParser.START_TAG) && (alunos.getName().equals("aluno"))) {
					addAlunosValues(alunos, db);
				}
				eventType = alunos.next();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			alunos.close();
		}
	}

	/**
	 * @param db 
	 * @param db 
	 * @param values
	 * @param clothings
	 * @throws ValidationError 
	 */
	private void addAlunosValues(XmlResourceParser xml, SQLiteDatabase db) throws ValidationError {
		String name = xml.getAttributeValue(null, StudentDescription.NAME.getColumn());
		String site = xml.getAttributeValue(null, StudentDescription.SITE.getColumn());
		String photo = xml.getAttributeValue(null, StudentDescription.PHOTO.getColumn());
		String street = xml.getAttributeValue(null, StudentDescription.STREET.getColumn());
		String telephony = xml.getAttributeValue(null, StudentDescription.TELEPHONY.getColumn());
		String notaColumn = StudentDescription.NOTA.getColumn();
		String nota = xml.getAttributeValue(null, notaColumn);
		
		Student student = new Student();
		student.setEndereco(street);
		student.setFoto(photo);
		student.setNome(name);
		student.setNota(Double.parseDouble(nota));
		student.setSite(site);
		student.setTelefone(telephony);
		
		insertStudent(student, db);
	}
	
	public void insertStudent(Student student, SQLiteDatabase connection) throws ValidationError {
		Validater validater = new Validater();
		validater.valid(student);
		
		ContentValues values = new ContentValues();
		values.put(StudentDescription.NAME.getColumn(), student.getNome());
		values.put(StudentDescription.SITE.getColumn(), student.getSite());
		values.put(StudentDescription.PHOTO.getColumn(), student.getFoto());
		values.put(StudentDescription.STREET.getColumn(), student.getEndereco());
		values.put(StudentDescription.TELEPHONY.getColumn(), student.getTelefone());
		values.put(StudentDescription.NOTA.getColumn(), student.getNota());
		
		connection.insert(Tables.STUDENT.getTableName(), null, values); //the android close this
	}

}
