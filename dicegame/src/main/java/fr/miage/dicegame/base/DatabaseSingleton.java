package fr.miage.dicegame.base;

import java.util.Random;

public final class DatabaseSingleton {

	private static DatabaseSingleton databaseSingleton = null;
	
	private Database database;
	
	private DatabaseSingleton() {
		int r = new Random().nextInt(3);
		switch (r) {
		case 0:
			database = DatabaseFactory.getDatabase(new JdbcFactory());
			break;
		case 1:
			database = DatabaseFactory.getDatabase(new SrFactory());
			break;
		case 2:
			database = DatabaseFactory.getDatabase(new RedisFactory());
			break;
		default:
			database = DatabaseFactory.getDatabase(new SrFactory());
			break;
		}
	}
	
	public static synchronized DatabaseSingleton getInstance() {
		if(databaseSingleton == null) {
			databaseSingleton = new DatabaseSingleton();
		}
		return databaseSingleton;
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}
	
	
}
