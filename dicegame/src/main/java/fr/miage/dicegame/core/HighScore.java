package fr.miage.dicegame.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.miage.dicegame.base.DatabaseSingleton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public final class HighScore implements Serializable {

	private static final long serialVersionUID = -1356324523504304014L;

	private static HighScore highscore = null;

	private List<Entree> entrees = new ArrayList<>();

	public final ObservableList<Entree> entreesObservable = FXCollections.observableArrayList();

	public static HighScore getInstance() {
		if (highscore == null) {
			highscore = new HighScore();
		}
		return highscore;
	}

	public void ajouterEntree(Entree entree) {
		entrees.add(entree);
		entreesObservable.add(entree);
		sortList();

		DatabaseSingleton.getInstance().getDatabase().save();
	}

	public List<Entree> getEntrees() {
		return this.entrees;
	}

	public void setEntrees(List<Entree> entree) {
		this.entrees = entree;
		entreesObservable.clear();
		entreesObservable.addAll(entrees);
		sortList();
	}

	public ObservableList<Entree> getEntreesObservable() {
		return entreesObservable;
	}

	private void sortList() {
		FXCollections.sort(entreesObservable, (o1, o2) -> Integer.compare(o2.getScore(), o1.getScore()));
	}

}
