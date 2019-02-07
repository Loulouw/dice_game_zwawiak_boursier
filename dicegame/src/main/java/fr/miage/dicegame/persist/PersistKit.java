package fr.miage.dicegame.persist;

import fr.miage.dicegame.core.HighScore;

public abstract class PersistKit {

	protected static PersistKit persist = null;

	protected PersistKit() {
	}

	public static PersistKit getInstance() {
		if (persist == null) {
			new Error("Pas de PersistKit existant");
		}
		return persist;
	}

	public abstract HighScore makeKit();
}
