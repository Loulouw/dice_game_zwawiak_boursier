package fr.miage.dicegame.ui;


import fr.miage.dicegame.core.DiceGame;
import fr.miage.dicegame.core.Joueur;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class DeView implements View {

	@Override
	public Pane getPane() {
		final GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(25, 25, 25, 25));

		final TextField nomJoueur = new TextField();

		final Label lancerNumeroUn = new Label("Numéro du premier dé : X");
		final Label lancerNumeroDeux = new Label("Numéro du second dé : X");

		final Button jouer = new Button("Jouer");
		jouer.setOnAction(value -> {

			//Vérification nom du joueur non vide
			if (nomJoueur.getText().trim().isEmpty()) {
				Alert a2 = new Alert(AlertType.WARNING);
				a2.setTitle("Attention");
				a2.setHeaderText("Le nom du joueur ne peut pas être vide");
				a2.show();
			} else {
				Joueur j = DiceGame.getInstance().getJoueur();
				if (j == null || j.getTour() == 0) {
					DiceGame.getInstance().start(nomJoueur.getText());
					nomJoueur.setDisable(true);
					DiceGame.getInstance().getJoueur().jouer();
				} else {
					j.jouer();
					if (j.getTour() == 10) {

						Alert a2 = new Alert(AlertType.INFORMATION);
						a2.setTitle("BRAVO");
						a2.setHeaderText("Bravo " + j.getName() + " tu as fais un score de " + j.getScore());
						a2.show();

						DiceGame.getInstance().setJoueur(null);
						nomJoueur.setDisable(false);
					}
				}
			}
		});

		gp.add(new Label("Nom du joueur "), 0, 0);
		gp.add(nomJoueur, 1, 0);
		gp.add(lancerNumeroUn, 0, 1);
		gp.add(lancerNumeroDeux, 0, 2);
		gp.add(jouer, 0, 3, 2, 1);

		return gp;
	}

}
