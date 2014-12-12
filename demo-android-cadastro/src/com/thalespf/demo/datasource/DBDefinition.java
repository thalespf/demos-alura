/**
 * 
 */
package com.thalespf.demo.datasource;

import java.util.Arrays;

import android.database.Cursor;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 * 
 */
public class DBDefinition {

	public enum StudentDescription {
		ID("id", 0), NAME("name", 1), TELEPHONY("telephony", 2), STREET("street", 3), SITE(
				"site", 4), PHOTO("photo", 5), NOTA("nota", 6);

		private String column;
		private int columnId;

		private StudentDescription(String column, int columnId) {
			this.column = column;
			this.columnId = columnId;
		}

		public String getColumn() {
			return column;
		}
		
		public int getColumnId() {
			return columnId;
		}

	}
	
	/**
	 * define as tabelas no banco
	 * 
	 *
	 */
	public enum Tables {
		STUDENT("student", "CREATE TABLE IF NOT EXISTS student ("
				+ StudentDescription.ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ StudentDescription.NAME + " TEXT UNIQUE NOT NULL, "
				+ StudentDescription.TELEPHONY + " TEXT UNIQUE NOT NULL, "
				+ StudentDescription.STREET + " TEXT, "
				+ StudentDescription.SITE + " TEXT, "
				+ StudentDescription.PHOTO + " TEXT, "
				+ StudentDescription.NOTA + " TEXT)", (String[]) Arrays
				.asList(StudentDescription.ID.column,
						StudentDescription.NAME.column,
						StudentDescription.TELEPHONY.column,
						StudentDescription.STREET.column,
						StudentDescription.SITE.column,
						StudentDescription.PHOTO.column,
						StudentDescription.NOTA.column).toArray());

		private String tableName;
		private String createCmd;
		private String[] columns;

		private Tables(String tableName, String createCmd, String[] columns) {
			this.tableName = tableName;
			this.createCmd = createCmd;
			this.columns = columns;
		}

		public String getTableName() {
			return tableName;
		}

		public void setTableName(String tableName) {
			this.tableName = tableName;
		}
		
		public String getCreateCmd() {
			return createCmd;
		}

		public String[] getColumns() {
			return columns;
		}

	}

	public static int getId(Cursor cursor) {
		return cursor.getInt(StudentDescription.ID.getColumnId());
	}

	public static String getName(Cursor cursor) {
		return cursor.getString(StudentDescription.NAME.getColumnId());
	}

	public static String getTelephony(Cursor cursor) {
		return cursor.getString(StudentDescription.TELEPHONY.getColumnId());
	}

	public static String getStreet(Cursor cursor) {
		return cursor.getString(StudentDescription.STREET.getColumnId());
	}

	public static String getSite(Cursor cursor) {
		return cursor.getString(StudentDescription.SITE.getColumnId());
	}

	public static String getPhoto(Cursor cursor) {
		return cursor.getString(StudentDescription.PHOTO.getColumnId());
	}

	public static String getNota(Cursor cursor) {
		return cursor.getString(StudentDescription.NOTA.getColumnId());
	}

}
