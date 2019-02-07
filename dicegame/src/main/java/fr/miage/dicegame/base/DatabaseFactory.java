package fr.miage.dicegame.base;

public class DatabaseFactory {

	public static Database getDatabase(DatabaseAbstractFactory factory) {
		return factory.getDatabase();
	}
	
}
