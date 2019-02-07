package fr.miage.dicegame.ui;

import fr.miage.dicegame.core.Entree;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class HighScoreView implements View{

	@Override
	public Pane getPane() {
		HBox hb = new HBox();
		
		
		final TableView<Entree> table = new TableView<>();
		table.setEditable(false);
		
		return hb;
	}

}
