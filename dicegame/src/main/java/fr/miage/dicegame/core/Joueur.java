package fr.miage.dicegame.core;

import java.util.Observable;

public class Joueur extends Observable{

	private String name;
	private int score;
	private int tour;
	private final int POINT = 7;
	private final int GAIN = 10;
	
	public Joueur(String name) {
		this.name = name;
		this.score = 0;
		this.tour = 0;
	}
	
	private De de1(){
		return null;
	}
	
	private De de2() {
		return null;
	}
	
	public void jouer() {
		int d1=de1().roll();
		int d2=de2().roll();
		if ((d1+d2)==POINT) {
		    setScore(score+GAIN);
		}
		setTour(getTour()+1);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
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
	 * @param score the score to set
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
	 * @param tour the tour to set
	 */
	public void setTour(int tour) {
		this.tour = tour;
	}
	
}
