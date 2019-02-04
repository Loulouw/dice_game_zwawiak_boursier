package fr.miage.dicegame.ui;

import java.awt.Label;
import java.awt.Panel;
import java.util.Observable;
import java.util.Observer;

import fr.miage.dicegame.core.De;

public class DeView extends Panel implements Observer{

	private static final long serialVersionUID = 1L;
	public Label l;
	
	public DeView(De de) {
		this.add(l=new Label("De:" + de.getValeur()));
	}
	
	public void update(Observable o, Object arg) {
		l.setText("De:"+((De)o).getValeur());
	}
}
