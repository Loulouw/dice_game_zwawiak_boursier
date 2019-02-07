package fr.miage.dicegame.core;

import java.io.Serializable;

public class Entree implements Serializable{

	private long id;
	private String name;
	private int score;


	public Entree(long id, String name, int score) {
		this.id = id;
		this.name=name;
		this.score=score;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
