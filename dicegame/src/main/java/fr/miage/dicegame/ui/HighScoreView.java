package fr.miage.dicegame.ui;

import fr.miage.dicegame.core.Entree;
import fr.miage.dicegame.core.HighScore;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class HighScoreView implements View {

	@Override
	public Pane getPane() {
		HBox hb = new HBox();

		final ListView<Entree> list = new ListView<>();
		list.setItems(HighScore.getInstance().getEntreesObservable());

		hb.getChildren().add(list);
		return hb;
	}

}
