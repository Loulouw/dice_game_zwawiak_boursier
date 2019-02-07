package fr.miage.dicegame.base;

public class JdbcFactory implements DatabaseAbstractFactory {

	@Override
	public Database getDatabase() {
		return new DatabaseJDBC();
	}

}
