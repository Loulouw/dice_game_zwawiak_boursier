package fr.miage.dicegame.persist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import fr.miage.dicegame.core.HighScore;

public class HighScoreSr extends HighScore {

	private static String fichier = "C:\\temp\\high.sco";

	public HighScoreSr() {
		load();
	}

	@Override
	public void load() {
		try {
			FileInputStream fis = new FileInputStream(fichier);
			ObjectInputStream ois = new ObjectInputStream(fis);

			highscore = (HighScoreSr) ois.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("Le fichier n'existe pas");
			highscore = this;
		} catch (Exception e) {
			e.printStackTrace();
			new Error("Problème de chargement");
		}
	}

	@Override
	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream(fichier);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(this);
			oos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
			new Error("Erreur lors de l'enregistrement");
		}
	}

	@Override
	public void which() {
		System.out.println("Je suis la base file");
	}

}
