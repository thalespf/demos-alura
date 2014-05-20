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

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 * 
 */
public class AgendaApplication extends Application {
	
	private static AgendaApplication singleton;

	public AgendaApplication getInstance() {
		return singleton;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		
		singleton = this;
		
		Log.i(Constants.getTag(this), "onCreate(). Criando aplicacao.");
		Log.i(Constants.getTag(this), "onCreate(). Inicializando Registry.");
		Registry.getInstance().init(getBaseContext());
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}
 
	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}
 
	@Override
	public void onTerminate() {
		super.onTerminate();
	}

}
