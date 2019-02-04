package fr.miage.dicegame.core;

import fr.miage.dicegame.persist.PersistKit;

public class DiceGame {

	private static DiceGame dg;
	
	private De[] des = new De[2];
	
	private Joueur joueur;
	
	public static DiceGame getInstance() {
		if (dg==null) {
			dg=new DiceGame();
		}
		return dg;
	}
	
	private DiceGame() {
		this.des[0]=new De();
		this.des[1]=new De();
		PersistKit.getInstance().makeKit();
		this.joueur = null;
	}
	
	public void start(String name) {
		joueur=new Joueur(name);
	}

	/**
	 * @return the des
	 */
	public De getDes(int i) {
		return des[i];
	}

	/**
	 * @return the joueur
	 */
	public Joueur getJoueur() {
		return joueur;
	}
}
