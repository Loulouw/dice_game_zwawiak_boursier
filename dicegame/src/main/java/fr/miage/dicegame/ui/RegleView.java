package fr.miage.dicegame.ui;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class RegleView implements View {

	@Override
	public Pane getPane() {
		HBox hb = new HBox();

		Label text = new Label("Voici les règles de l'application DiceGame : \n On commence par rentrer le nom \n Vous avez 10 tours pour faire le meilleur score \n Si la combinaison des dés vaut 7, alors vous gagnez 10 points \n sinon 0.\n\n Bonne chance !");
		
		
		hb.getChildren().add(text);
		return hb;
	}

}
