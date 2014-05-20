/**
 * 
 */
package com.thalespf.demo.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.thalespf.demo.android.presentation.ui.exception.ValidationError;
import com.thalespf.demo.android.presentation.ui.helper.Validater;
import com.thalespf.demo.datasource.DB;
import com.thalespf.demo.datasource.DBDefinition;
import com.thalespf.demo.datasource.DBDefinition.StudentDescription;
import com.thalespf.demo.datasource.DBDefinition.Tables;
import com.thalespf.demo.domain.Student;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 * 
 */
public class StudentDAO {

	private DB db;

	public StudentDAO(DB db) {
		this.db = db;
	}

	public Student save(Student student) {
		SQLiteDatabase connection = null;
		try {
			connection = db.openForWrite();
			connection.beginTransaction();
			insertStudent(student, connection);
			connection.setTransactionSuccessful();
			
			return student;
		} catch(Exception e) {
			throw new RuntimeException("error ao salvar aluno", e);
		} finally {
			if(connection != null) {
				connection.endTransaction();
				connection.close();				
			}
		}
	}
	
	public void insertStudent(Student student, SQLiteDatabase connection) throws ValidationError {
		Validater validater = new Validater();
		validater.valid(student);
		
		ContentValues values = toValues(student);
		
		connection.insert(Tables.STUDENT.getTableName(), null, values);
	}

	private ContentValues toValues(Student student) {
		ContentValues values = new ContentValues();
		values.put(StudentDescription.NAME.getColumn(), student.getNome());
		values.put(StudentDescription.SITE.getColumn(), student.getSite());
		values.put(StudentDescription.PHOTO.getColumn(), student.getFoto());
		values.put(StudentDescription.STREET.getColumn(), student.getEndereco());
		values.put(StudentDescription.TELEPHONY.getColumn(), student.getTelefone());
		values.put(StudentDescription.NOTA.getColumn(), student.getNota());
		return values;
	}

	public List<Student> findAll() {
		SQLiteDatabase connection = null;
		try {
			connection = db.openForRead();
			String[] columns = DBDefinition.Tables.STUDENT.getColumns();
			Cursor cursor = connection.query(DBDefinition.Tables.STUDENT.getTableName(), columns, null, 
					null, null, null, null);
			List<Student> students = new ArrayList<Student>();
			cursor.moveToFirst();
		    while (!cursor.isAfterLast()) {
		    	Student student = cursorToStudent(cursor);
		    	students.add(student);
		    	cursor.moveToNext();
		    }
			return students;
		} catch(Exception e) {
			throw new RuntimeException("error ao salvar aluno", e);
		} finally {
			if(connection != null) {
				connection.close();				
			}
		}
	}

	private Student cursorToStudent(Cursor cursor) {
		int id = DBDefinition.getId(cursor);
		String name = DBDefinition.getName(cursor);
		String telephony = DBDefinition.getTelephony(cursor);
		String street = DBDefinition.getStreet(cursor);;
		String site = DBDefinition.getSite(cursor);;
		String photo = DBDefinition.getPhoto(cursor);;
		String nota = DBDefinition.getNota(cursor);;
		
		Student student = new Student();
		student.setEndereco(street);
		student.setFoto(photo);
		student.setId(Long.valueOf(id));
		student.setNome(name);
		student.setNota(Double.parseDouble(nota));
		student.setSite(site);
		student.setTelefone(telephony);
		
		return student;
	}

	public void delete(Student student) {
		SQLiteDatabase connection = null;
		try {
			connection = db.openForWrite();
			connection.beginTransaction();
			String[] whereArgs = { student.getId().toString() };
			connection.delete(DBDefinition.Tables.STUDENT.getTableName(), "id=?", whereArgs);
			connection.setTransactionSuccessful();
		} catch(Exception e) {
			throw new RuntimeException("error ao deletar aluno", e);
		} finally {
			if(connection != null) {
				connection.endTransaction();
				connection.close();				
			}
		}
	}

}
