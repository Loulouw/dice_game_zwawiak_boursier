package fr.miage.dicegame.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Observable;

public abstract class HighScore extends Observable implements Serializable{
	
	protected static HighScore highscore = null;
	
	protected ArrayList<Entree> entrees = new ArrayList<Entree>();
	
	public abstract void load();
	
	public abstract void save();
	
	public void ajouterEntree(Entree entree) {
		entrees.add(entree);
		this.setChanged();
		this.notifyObservers();
	}
	
	public List<Entree> getEntrees() {
		return this.entrees;
	}
	
	public void setEntrees(ArrayList<Entree> entree) {
		this.entrees = entree;
	}
	
	public abstract void which();

	public static HighScore getInstance() {
		if (highscore==null) {
		    new Error("No Persist Kit declared");
		}
		return highscore;
	}
}
