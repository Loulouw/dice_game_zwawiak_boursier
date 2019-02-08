package fr.miage.dicegame.core;

import java.util.Observable;

public class Joueur {

	private String name;
	private int score;
	private int tour;

	private static final int POINT = 7;
	private static final int GAIN = 10;

	public Joueur(String name) {
		this.name = name;
		this.score = 0;
		this.tour = 0;
	}

	private De de1() {
		return DiceGame.getInstance().getDes(0);
	}

	private De de2() {
		return DiceGame.getInstance().getDes(1);
	}

	public void jouer() {
		int d1 = de1().roll();
		int d2 = de2().roll();
		if ((d1 + d2) == POINT) {
			score += GAIN;
		}
		tour++;
		
		if(tour == 10) {
			long randomId = 1000000 + (long) (Math.random() * (9999999 - 1000000));
			Entree e = new Entree(randomId, name, score);
			HighScore.getInstance().ajouterEntree(e);
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the tour
	 */
	public int getTour() {
		return tour;
	}

	/**
	 * @param tour
	 *            the tour to set
	 */
	public void setTour(int tour) {
		this.tour = tour;
	}

}
