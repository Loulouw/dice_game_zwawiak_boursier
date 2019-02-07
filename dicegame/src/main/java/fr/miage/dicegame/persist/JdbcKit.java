package fr.miage.dicegame.persist;

import fr.miage.dicegame.core.HighScore;

public class JdbcKit extends PersistKit{

	public HighScore makeKit() {
		return new HighScoreJdbc();
	}

	public JdbcKit() {
		persist=this;
	}
}