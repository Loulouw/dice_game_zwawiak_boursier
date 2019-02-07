package fr.miage.dicegame.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public final class HighScore extends Observable implements Serializable {

	private static final long serialVersionUID = -1356324523504304014L;

	private static HighScore highscore = null;

	private List<Entree> entrees = new ArrayList<>();

	public static HighScore getInstance() {
		if (highscore == null) {
			highscore = new HighScore();
		}
		return highscore;
	}

	public void ajouterEntree(Entree entree) {
		entrees.add(entree);
		this.setChanged();
		this.notifyObservers();
	}

	public List<Entree> getEntrees() {
		return this.entrees;
	}

	public void setEntrees(List<Entree> entree) {
		this.entrees = entree;
	}

}
