package fr.miage.dicegame.core;

public class De {

	private int valeur = 1;

	public int roll() {
		setValeur((int) (Math.random() * (6 - 1)) + 1);
		return getValeur();
	}

	/**
	 * @return the valeur
	 */
	public int getValeur() {
		return valeur;
	}

	/**
	 * @param valeur
	 *            the valeur to set
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

}
