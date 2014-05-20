/*
 * Copyright 2013 Thales Ferreira
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.thalespf.demo.datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.thalespf.demo.Constants;
import com.thalespf.demo.datasource.DBDefinition.Tables;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 * 
 */
public class DB {

	public static final String DATABASE_NAME = "cadastro_db";

	public static final int DATABASE_VERSION = 1;

	public static final String CLASSNAME = DB.class.getSimpleName();

	private DBOpenHelper dbOpenHelper;

	public DB(Context context) {
		dbOpenHelper = new DBOpenHelper(context);
	}

	public SQLiteDatabase openForWrite() {
		return dbOpenHelper.getWritableDatabase();
	}

	public SQLiteDatabase openForRead() {
		return dbOpenHelper.getReadableDatabase();
	}

	public void close() {
		dbOpenHelper.close();
	}

	private class DBOpenHelper extends SQLiteOpenHelper {
		
		public DBOpenHelper(final Context context) {
			super(context, DB.DATABASE_NAME, null, DB.DATABASE_VERSION);
		}

		@Override
		public void onCreate(final SQLiteDatabase db) {
			Log.i(Constants.getTag(this), "Creating database...");
			for (Tables table : Tables.values()) {
				db.execSQL(table.getCreateCmd());
			}
			
			//popula o banco
			DBPopulater populater = new DBPopulater();
			populater.populateDatabase(db);
		}

		@Override
		public void onOpen(final SQLiteDatabase db) {
			Log.i(Constants.getTag(this), "Open database...");
			super.onOpen(db);
		}

		@Override
		public void onUpgrade(final SQLiteDatabase db, final int oldVersion,
				final int newVersion) {
			Log.i(Constants.getTag(this), "Upgrading database...");
			for (Tables table : Tables.values()) {
				db.execSQL("DROP TABLE IF EXISTS " + table.getTableName());
			}
			onCreate(db);
		}
	}

}
