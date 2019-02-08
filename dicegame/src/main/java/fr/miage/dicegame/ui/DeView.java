package fr.miage.dicegame.ui;

import fr.miage.dicegame.base.DatabaseSingleton;
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

	private Label lancerNumeroUn;
	private Label lancerNumeroDeux;
	private Label tour;
	private Label scoreActuel;

	@Override
	public Pane getPane() {
		final GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(25, 25, 25, 25));

		final TextField nomJoueur = new TextField();

		final Pane saut1 = new Pane();
		saut1.minHeight(30);

		lancerNumeroUn = new Label("Numéro du premier dé :");
		lancerNumeroDeux = new Label("Numéro du second dé :");

		final Pane saut2 = new Pane();
		saut2.minHeight(30);

		tour = new Label("Tour :");
		scoreActuel = new Label("Score :");

		final Button jouer = new Button("Jouer");
		jouer.setMinWidth(300);
		jouer.setOnAction(value -> {

			// Vérification nom du joueur non vide
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
					updateLabel();
				} else {
					j.jouer();
					updateLabel();
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
		
		final Label bdd = new Label("Utilisation de : " + DatabaseSingleton.getInstance().getDatabase().whoiam());

		gp.add(new Label("Nom du joueur "), 0, 0);
		gp.add(nomJoueur, 1, 0);

		gp.add(saut1, 0, 1);

		gp.add(tour, 0, 2);
		gp.add(scoreActuel, 0, 3);

		gp.add(saut2, 0, 4);

		gp.add(lancerNumeroUn, 0, 5);
		gp.add(lancerNumeroDeux, 0, 6);

		gp.add(jouer, 0, 7, 2, 1);
		
		gp.add(bdd, 0, 8);

		return gp;
	}

	private void updateLabel() {
		Joueur j = DiceGame.getInstance().getJoueur();
		lancerNumeroUn.setText("Numéro du premier dé : " + DiceGame.getInstance().getDes(0).getValeur());
		lancerNumeroDeux.setText("Numéro du second dé : "+ DiceGame.getInstance().getDes(1).getValeur());
		tour.setText("Tour : " + j.getTour());
		scoreActuel.setText("Score : " + j.getScore());
	}

}
