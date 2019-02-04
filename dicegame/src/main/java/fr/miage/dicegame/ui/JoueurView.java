package fr.miage.dicegame.ui;

import java.awt.Label;
import java.awt.Panel;
import java.util.Observable;
import java.util.Observer;

import fr.miage.dicegame.core.Joueur;

public class JoueurView extends Panel implements Observer{

	private static final long serialVersionUID = 1L;
	private Label nameLabel;
    private Label scoreLabel;
    private Label tourLabel;

    public JoueurView(Joueur joueur) {
	this.add(nameLabel=new Label("Name:"+joueur.getName()));
	this.add(scoreLabel=new Label("Score:"+joueur.getScore()));
	this.add(tourLabel=new Label("Turn:"+joueur.getTour()));
		 
    }
    
    public void update(Observable o, Object arg) {
	scoreLabel.setText("Score:"+((Joueur)o).getScore());
	tourLabel.setText("Tour:"+((Joueur)o).getTour());
    }
}
