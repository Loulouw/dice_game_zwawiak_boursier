package fr.miage.dicegame.base;

import java.util.Random;

public final class DatabaseSingleton {

	private static DatabaseSingleton databaseSingleton = null;
	
	private Database database;
	
	private DatabaseSingleton() {
		Random r = new Random();
		switch (r.nextInt(3)) {
		case 0:
			database = DatabaseFactory.getDatabase(new RedisFactory());
			break;
		case 1:
			database = DatabaseFactory.getDatabase(new SrFactory());
			break;
		case 2:
			database = DatabaseFactory.getDatabase(new JdbcFactory());
			break;
		default:
			database = DatabaseFactory.getDatabase(new JdbcFactory());
			break;
		}
	}
	
	public synchronized DatabaseSingleton getInstance() {
		if(databaseSingleton == null) {
			databaseSingleton = new DatabaseSingleton();
		}
		return databaseSingleton;
	}
	
}
