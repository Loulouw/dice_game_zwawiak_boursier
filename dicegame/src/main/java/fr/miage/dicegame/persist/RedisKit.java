package fr.miage.dicegame.persist;

import fr.miage.dicegame.core.HighScore;

public class RedisKit extends PersistKit {

	public HighScore makeKit() {
		return new HighScoreRedis();
	}

	public RedisKit() {
		persist = this;
	}
}
