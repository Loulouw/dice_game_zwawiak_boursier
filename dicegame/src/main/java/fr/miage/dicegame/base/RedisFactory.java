package fr.miage.dicegame.base;

public class RedisFactory implements DatabaseAbstractFactory {

	@Override
	public Database getDatabase() {
		return new DatabaseRedis();
	}

}
