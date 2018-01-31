package com.mygdx.game;
import java.util.ArrayList;

public class Joueur {

	private String pseudo;
	private int pa;
	private int point;
	private ArrayList<Tresor> tresors;
	private Boolean actif;
	
	public Joueur(String pseudo){
		this.pa = 10;
		this.actif = false;
		this.pseudo = pseudo;
		this.point = 0;
		tresors = new ArrayList<Tresor>();
	}
	
	
	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public ArrayList<Tresor> getTresors() {
		return tresors;
	}


	public void setTresors(ArrayList<Tresor> tresors) {
		this.tresors = tresors;
	}


	public int getPa() {
		return pa;
	}


	public void setPa(int pa) {
		this.pa = pa;
	}

	
	public Boolean getActif() {
		return actif;
	}


	public void setActif() {
		actif = true;
	}
	
	public void setNonActif() {
		actif = false;
	}

	public void ajouterTresor(Tresor tresor){
		tresors.add(tresor);
	}
	
	public void retirerTresor(Tresor tresor){
		tresors.remove(tresor);
	}
	
	public void echangerTresor(Tresor tresorVoulu, Joueur jDemandeur, Joueur jEchangeur, Tresor tresorDonne){
		boolean possede = false;
		int nbTresorVoulu = 0;
		
		//On va compter le nombre de fois que le joueur Donneur à le trésor demandé
		for (Tresor t : jEchangeur.tresors)
        {
            if(tresorVoulu.equals(t))
            {
            	nbTresorVoulu++;
            }
        }
		//Vérifie si le joueur demandeur à bien le trésor
		for (Tresor t : jDemandeur.tresors)
        {
            if(tresorDonne.equals(t))
            {
            	possede = true;
            }
        }
		//On procéde à l'échange si toutes les conditions sont réunies
		if(possede == true && nbTresorVoulu == 1){
        	jEchangeur.ajouterTresor(tresorDonne);
			jDemandeur.ajouterTresor(tresorVoulu);
			jEchangeur.retirerTresor(tresorVoulu);
			jDemandeur.retirerTresor(tresorDonne);
            System.out.println("Le tresor a été échangé");
		}
	}

	public void Afficher(){
		System.out.println("Joueur [pseudo=" + pseudo + ", point=" + point + "]");
		for (Tresor t : tresors){
			System.out.println(t.toString());
		}
	}

	public boolean placerPionPoint(){
		if(pa>=1){
			pa = pa-1;
			return true;
		}else{return false;}
	}
	
	public boolean deplacerPionPoint(){
		if(pa>=1){
			pa = pa-1;
			return true;
		}else{return false;}
	}
	
	public Boolean placerCampementPoint(){
		if(pa>=5){
			pa = pa-5;
			return true;
		}else{return false;}
	}
	

	public Boolean deterrerTresorPoint(){
		if(pa>=3){
			pa = pa-3;
			return true;
		}else{return false;}
	}
	
	public Boolean echangerTresorPoint(){
		if(pa>=3){
			pa = pa-3;
			return true;
		}else{return false;}
	}
	
	public Boolean AmeliorerTemplePoint(){
		if(pa>=2){
			pa = pa-2;
			return true;
		}else{return false;}
	}
	
	public Boolean PlacerGardienPoint(){
		if(pa>=3){
			pa = pa-3;
			return true;
		}else{return false;}
	}
	
	
}
