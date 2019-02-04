package fr.miage.dicegame.core;

import java.io.Serializable;

public class Entree implements Serializable{

	public String name;
	public int score;
	
	public Entree(String name, int score) {
		this.name=name;
		this.score=score;
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
	
}
