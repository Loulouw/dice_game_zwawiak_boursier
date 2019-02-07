package fr.miage.dicegame.persist;

import java.util.ArrayList;
import java.util.List;

import fr.miage.dicegame.core.Entree;
import fr.miage.dicegame.core.HighScore;
import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import redis.clients.jedis.Jedis;

public class HighScoreRedis extends HighScore{

	@Override
	public void load() {
		Jedis jedis = new Jedis();
		try {
			ArrayList<Entree> entrees = new ArrayList<Entree>();
			
			String res = "";
			res = jedis.rpop("Id");
			while(!res.isEmpty()) {
				Entree e = new Entree(0, "", 0);
				e.setId(Long.parseLong(res));
				e.setName(jedis.rpop("Name"));
				e.setScore(Integer.parseInt(jedis.rpop("Score")));
				entrees.add(e);
				try {
					res = jedis.rpop("Id");
				}catch(Exception ex) {
					res = "";
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		highscore.setEntrees(entrees);
		jedis.close();
	}

	@Override
	public void save() {
		Jedis jedis = new Jedis();
		try {
			for(Entree e : highscore.getEntrees()) {
				jedis.lpush("Id", e.getId()+"");
				jedis.lpush("Name", e.getName());
				jedis.lpush("Score", e.getScore()+"");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		jedis.close();
	}


	@Override
	public void which() {
		System.out.println("Je suis la base Redis");
	}

}
