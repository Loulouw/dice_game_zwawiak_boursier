package fr.miage.dicegame.base;

import java.util.ArrayList;
import java.util.List;

import fr.miage.dicegame.core.Entree;
import fr.miage.dicegame.core.HighScore;
import redis.clients.jedis.Jedis;

public class DatabaseRedis extends Database {

	private Jedis jedis;
	
	public DatabaseRedis() {
		jedis = new Jedis("hostname.redislabs.com", 6379);
	    jedis.auth("password");
	}
	
	
	@Override
	public void load() {
		try {
			List<Entree> entrees = new ArrayList<>();

			String res = "";
			res = jedis.rpop("Id");
			while (!res.isEmpty()) {
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
	}

	@Override
	public void save() {
		try {
			for (Entree e : HighScore.getInstance().getEntrees()) {
				jedis.lpush("Id", e.getId() + "");
				jedis.lpush("Name", e.getName());
				jedis.lpush("Score", e.getScore() + "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void whoiam() {
		System.out.println("Redis");
	}

}
