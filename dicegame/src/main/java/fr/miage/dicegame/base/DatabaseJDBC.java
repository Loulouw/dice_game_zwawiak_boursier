package fr.miage.dicegame.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.miage.dicegame.core.Entree;
import fr.miage.dicegame.core.HighScore;

public class DatabaseJDBC extends Database {

	public Connection conn;

	public DatabaseJDBC() {
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/jeude", "root", null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void load() {

		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("select * from highscore")) {
			List<Entree> entrees = new ArrayList<>();
			while (rs.next()) {
				entrees.add(new Entree(rs.getLong(1), rs.getString(2), rs.getInt(3)));
			}

			HighScore.getInstance().setEntrees(entrees);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void save() {
		try {
			Entree e = HighScore.getInstance().getEntrees().get(HighScore.getInstance().getEntrees().size() - 1);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO highscore VALUES (?, ?, ?)");
			ps.setLong(1, e.getId());
			ps.setString(2, e.getName());
			ps.setInt(3, e.getScore());

			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void whoiam() {
		System.out.println("jdbc");
	}

}
