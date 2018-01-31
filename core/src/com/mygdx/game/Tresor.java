package com.mygdx.game;

public class Tresor {

	private String nom;
	
	public Tresor(String name){
		this.nom = name;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "Tresor [nom=" + nom + "]";
	}
	
}
