package fr.miage.dicegame;

import fr.miage.dicegame.ui.DeView;
import fr.miage.dicegame.ui.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Jeu de dé");
		Pane root = new StackPane();

		TabPane tabPane = new TabPane();

		tabPane.getTabs().add(createTabPane("Jeu", new DeView()));

		root.getChildren().add(tabPane);
		primaryStage.setScene(new Scene(root, 500, 450));
		primaryStage.show();

	}

	private static Tab createTabPane(String name, View view) {
		final Tab tab = new Tab(name);
		tab.selectedProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue) {
				tab.setContent(view.getPane());
			}
		});
		tab.setContent(view.getPane());
		tab.setClosable(false);
		return tab;
	}
}
