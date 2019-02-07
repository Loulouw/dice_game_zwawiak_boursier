package fr.miage.dicegame.base;

public class DatabaseFactory {

	private DatabaseFactory() {
		throw new IllegalStateException("factory class");
	}
	
	public static Database getDatabase(DatabaseAbstractFactory factory) {
		return factory.getDatabase();
	}
	
}
