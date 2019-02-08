package fr.miage.dicegame.base;

import java.util.ArrayList;
import java.util.List;

import fr.miage.dicegame.core.Entree;
import fr.miage.dicegame.core.HighScore;
import redis.clients.jedis.Jedis;

public class DatabaseRedis extends Database {

	private Jedis jedis;
	
	public DatabaseRedis() {
	}
	
	
	@Override
	public void load() {
		jedis = new Jedis("localhost", 6379);
		try {
			List<Entree> entrees = new ArrayList<>();

			String res = "";
			res = jedis.rpop("Id");
			System.out.println(res);
			while (res != null && res != "" ) {
				Entree e = new Entree(0, "", 0);
				e.setId(Long.parseLong(res));
				e.setName(jedis.rpop("Name"));
				e.setScore(Integer.parseInt(jedis.rpop("Score")));
				entrees.add(e);
				try {
					res = jedis.rpop("Id");
				} catch (Exception ex) {
					res = "";
				}
			}

			HighScore.getInstance().setEntrees(entrees);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jedis.close();
		save();
	}

	@Override
	public void save() {
		jedis = new Jedis("localhost", 6379);
		try {
			for (Entree e : HighScore.getInstance().getEntrees()) {
				jedis.rpush("Id", e.getId() + "");
				jedis.rpush("Name", e.getName());
				jedis.rpush("Score", e.getScore() + "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		jedis.close();
	}

	@Override
	public void whoiam() {
		System.out.println("Redis");
	}

}
