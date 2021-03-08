package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {
	private List<Voto> voti;

	public Libretto() {
		this.voti = new ArrayList<Voto>();
	}
	
	public void add(Voto v) {
		this.voti.add(v);
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
	
	public Voto ricercaCorso(String nomeCorso) {
		Voto s = null;
		for(Voto v : voti)
			if(v.getNome().compareTo(nomeCorso) == 0){
				s = v;
				break;
			}
		return s;
	}
}
