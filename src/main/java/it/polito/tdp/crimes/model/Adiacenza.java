package it.polito.tdp.crimes.model;

public class Adiacenza {
	private Distretto d1;
	private Distretto d2;
	private Double distanza;
	public Adiacenza(Distretto d1, Distretto d2, Double distanza) {
		super();
		this.d1 = d1;
		this.d2 = d2;
		this.distanza = distanza;
	}
	public Distretto getD1() {
		return d1;
	}
	public void setD1(Distretto d1) {
		this.d1 = d1;
	}
	@Override
	public String toString() {
		return  d1.getId() + " " + d2.getId() + " " + distanza;
	}
	public Distretto getD2() {
		return d2;
	}
	public void setD2(Distretto d2) {
		this.d2 = d2;
	}
	public Double getDistanza() {
		return distanza;
	}
	public void setDistanza(Double distanza) {
		this.distanza = distanza;
	}
	
}
