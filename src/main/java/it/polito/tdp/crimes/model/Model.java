package it.polito.tdp.crimes.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

import it.polito.tdp.crimes.db.EventsDao;

public class Model {
	private Graph<Distretto, DefaultWeightedEdge> grafo;
	private EventsDao dao;
	private List<Distretto> distretti;
	private Map<Integer, Distretto> idMap;
	private List<Adiacenza> adiacenze;
	
	public Model() {
		this.dao = new EventsDao();
	}
	
	public void creaGrafo(int anno) {
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		//Aggiungo vertici
		this.idMap = new HashMap<>();
		this.distretti = new ArrayList<>(dao.getDistretti(anno, idMap));
		Graphs.addAllVertices(this.grafo, this.distretti);
		
		//aggiungo archi
		Double distanza = 0.0;
		adiacenze =  new ArrayList<>();
		for(Distretto d1: distretti) {
			for(Distretto d2: distretti) {
				if(d1.getId() > d2.getId()) {
					distanza = LatLngTool.distance(d1.getPosizione(), d2.getPosizione(), LengthUnit.KILOMETER);
					adiacenze.add(new Adiacenza(d1, d2, distanza));
					Graphs.addEdgeWithVertices(this.grafo, d1, d2, distanza);
				}
			}
		}
	}
	public int nVertici() {
		return this.grafo.vertexSet().size();
	}
	
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	
	public List<Integer> getAnni(){
		return this.dao.getAnni();
	}
	
	public List<Adiacenza> getAdiacenze(){
		return this.adiacenze;
	}
	
}
