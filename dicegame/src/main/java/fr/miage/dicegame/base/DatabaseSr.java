package fr.miage.dicegame.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import fr.miage.dicegame.core.Entree;
import fr.miage.dicegame.core.HighScore;

public class DatabaseSr extends Database {

	private final String fichier = "C:\\temp\\high.sco";

	@Override
	public void load() {
		try (FileInputStream fis = new FileInputStream(fichier); ObjectInputStream ois = new ObjectInputStream(fis)) {
			HighScore.getInstance().setEntrees((ArrayList<Entree>) ois.readObject());
		} catch (FileNotFoundException e) {
			System.out.println("Le fichier n'existe pas");
		} catch (Exception e) {
			e.printStackTrace();
			new Error("Problème de chargement");
		}
	}

	@Override
	public void save() {
		try (FileOutputStream fos = new FileOutputStream(fichier);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {

			oos.writeObject(HighScore.getInstance().getEntrees());

		} catch (Exception e) {
			e.printStackTrace();
			new Error("Erreur lors de l'enregistrement");
		}
	}

	@Override
	public void whoiam() {
		System.out.println("SR");
	}

}
