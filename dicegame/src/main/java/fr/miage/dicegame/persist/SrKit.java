package fr.miage.dicegame.persist;

import fr.miage.dicegame.core.HighScore;

public class SrKit extends PersistKit {

	public HighScore makeKit() {
		return new HighScoreSr();
	}

	public SrKit() {
		persist = this;
	}
}
