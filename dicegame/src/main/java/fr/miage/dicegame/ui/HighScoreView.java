package fr.miage.dicegame.ui;

import java.awt.Panel;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Observable;

import fr.miage.dicegame.core.HighScore;

public class HighScoreView extends Panel implements Serializable{

	private static final long serialVersionUID = 1L;
	private java.awt.List l=null;

    public HighScoreView(HighScore hs) {
	l=new java.awt.List(10);
	for (Enumeration e = hs.getEntrees() ; e.hasMoreElements() ;) {
	    l.add(e.nextElement().toString());
	}	
	this.add(l);
    }
    /**
       @roseuid 3803329E00CA
     */
    public void update(Observable o, Object arg) {
	HighScore hs=(HighScore)o;
	l.clear();
	for (Enumeration e = hs.getEntrees() ; e.hasMoreElements() ;) {
	    l.add(e.nextElement().toString());
	}
    }
}
