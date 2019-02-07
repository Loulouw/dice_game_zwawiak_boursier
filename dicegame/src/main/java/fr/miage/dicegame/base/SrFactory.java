package fr.miage.dicegame.base;

public class SrFactory implements DatabaseAbstractFactory{

	@Override
	public Database getDatabase() {
		return new DatabaseSr();
	}

}
