package it.polito.tdp.crimes.model;

import com.javadocmd.simplelatlng.LatLng;

public class Distretto {
	private Integer id;
	private LatLng posizione;
	public Distretto(Integer id, LatLng posizione) {
		super();
		this.id = id;
		this.posizione = posizione;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LatLng getPosizione() {
		return posizione;
	}
	public void setPosizione(LatLng posizione) {
		this.posizione = posizione;
	}
	
	
}
