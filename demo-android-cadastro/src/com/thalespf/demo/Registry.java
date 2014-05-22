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
package com.thalespf.demo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.thalespf.demo.dao.StudentDAO;
import com.thalespf.demo.datasource.DB;
import com.thalespf.demo.datasource.DBPopulater;
import com.thalespf.demo.service.StudentService;

/**
 * Posteriormente substituir os dados aqui por injecao de dependencia
 * 
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class Registry {
	
	private static Registry instance;

	private DB db;

	private StudentDAO alunoDAO;
	
	private StudentService alunoService;
	
	private Context context = null;
	
	private Registry() { }

	/**
	 * @return
	 */
	public static Registry getInstance() {
		if(instance == null) {
			instance = new Registry();
		}
		return instance;
	}
	
	public void init(Context aContext) {
		context = aContext;
		
		db = new DB(context);
		alunoDAO = new StudentDAO(db);
		alunoService = new StudentService(alunoDAO);
		
		SQLiteDatabase conn = db.openForWrite();
		conn.beginTransaction();
		try {
			if(!conn.isDatabaseIntegrityOk()) {
				Log.w(Util.getTag(this), "Banco de dados nao esta integro");
			}
			conn.setTransactionSuccessful();
		} finally {
			conn.endTransaction();
			conn.close();
		}
	}

	/**
	 * 
	 */
	public StudentService getStudentService() {
		if(context == null)
			throw new IllegalStateException("No context in the registry");
		return alunoService;
	}

	/**
	 * @return
	 */
	public Context getContext() {
		return context;
	}

}
