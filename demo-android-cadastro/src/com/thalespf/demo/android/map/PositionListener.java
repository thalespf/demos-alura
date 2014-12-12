/**
 * 
 */
package com.thalespf.demo.android.map;

import com.google.android.gms.maps.model.LatLng;
import com.thalespf.demo.android.presentation.ui.fragment.StudentMapFragment;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class PositionListener implements LocationListener {
	
	private LocationManager locationManager;
	private LatLng locationLatlng;
	private StudentMapFragment mapFragment;

	public PositionListener(Activity activity, StudentMapFragment mapFragment) {
		this.mapFragment = mapFragment;
		locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
		
		String provider = LocationManager.GPS_PROVIDER;
		long tempoMinimo = 20000;
		float distancia = 20;
		locationManager.requestLocationUpdates(provider, tempoMinimo, distancia, this);
	}

	/* (non-Javadoc)
	 * @see android.location.LocationListener#onLocationChanged(android.location.Location)
	 */
	@Override
	public void onLocationChanged(Location location) {
		locationLatlng = new LatLng(location.getLatitude(), location.getLongitude());
		
		mapFragment.center(locationLatlng);
	}
	
	public LatLng getLocationLatlng() {
		return locationLatlng;
	}

	/* (non-Javadoc)
	 * @see android.location.LocationListener#onStatusChanged(java.lang.String, int, android.os.Bundle)
	 */
	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
	}

	/* (non-Javadoc)
	 * @see android.location.LocationListener#onProviderEnabled(java.lang.String)
	 */
	@Override
	public void onProviderEnabled(String provider) {
	}

	/* (non-Javadoc)
	 * @see android.location.LocationListener#onProviderDisabled(java.lang.String)
	 */
	@Override
	public void onProviderDisabled(String provider) {
	}

	public void cancel() {
		locationManager.removeUpdates(this);
	}

}
