package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {
	private List<Voto> voti;
	private Map<String, Voto> votiMap; //identity map
	
	public Libretto() {
		this.voti = new ArrayList<Voto>();
		this.votiMap = new HashMap<String, Voto>();
	}
	
	public void add(Voto v) {
		this.voti.add(v);
		this.votiMap.put(v.getNome(), v);
	}
	
	public String toString() {
		String s = "";
		for(Voto v : this.voti) {
			s += v.toString() + "\n";
		}
		return s;
	}
	
	public List<Voto> listaVotiUguali(int punteggio){
		List<Voto> s = new ArrayList<Voto>();
		for(Voto v : voti)
			if(v.getVoto() == punteggio)
				s.add(v);
		return s;
	}
	
	public Libretto votiUguali(int punteggio) {
		Libretto s = new Libretto();
		
		for(Voto v : voti)
			if(v.getVoto() == punteggio)
				s.add(v);
		return s;
	}
	/**
	 * Verifica se nel libretto c'è già lo stesso esame con lo stesso voto
	 * @param v
	 * @return
	 */
	public boolean esisteDuplicato(Voto v) {
		Voto voto = this.votiMap.get(v.getNome());
		if(voto == null)
			return false;
		if(voto.getVoto() == v.getVoto())
			return true;
		else
			return false;
	}
	/**
	 * Verifica se nel libretto c'è già lo stesso esame con diverso voto
	 * @param v
	 * @return
	 */
	public boolean esisteConflitto(Voto v) {
		Voto voto = this.votiMap.get(v.getNome());
		if(voto == null)
			return false;
		if(voto.getVoto() != v.getVoto())
			return true;
		else
			return false;
	}

	public Voto ricercaCorso(String nomeCorso) {
		return this.votiMap.get(nomeCorso);
	}
}
