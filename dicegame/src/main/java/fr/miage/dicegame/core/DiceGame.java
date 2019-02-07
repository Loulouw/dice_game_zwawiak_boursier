package fr.miage.dicegame.core;


public final class DiceGame {

	private static DiceGame dg = null;

	private De[] des = new De[2];

	private Joueur joueur;

	private DiceGame() {
		this.des[0] = new De();
		this.des[1] = new De();
		this.joueur = null;
	}

	public static synchronized DiceGame getInstance() {
		if (dg == null) {
			dg = new DiceGame();
		}
		return dg;
	}
	

	public void start(String name) {
		joueur = new Joueur(name);
	}

	public De getDes(int i) {
		return des[i];
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	
	
}
