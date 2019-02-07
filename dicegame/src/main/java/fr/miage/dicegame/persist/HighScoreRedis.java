package fr.miage.dicegame.persist;

import java.util.ArrayList;
import java.util.List;

import fr.miage.dicegame.core.Entree;
import fr.miage.dicegame.core.HighScore;
import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import redis.clients.jedis.Jedis;

public class HighScoreRedis extends HighScore {

	@Override
	public void load() {
		try {
			Jedis jedis = new Jedis();
			for (Entree e : highscore.getEntrees()) {
				jedis.lpush("Id", e.getId() + "");
				jedis.lpush("Name", e.getName());
				jedis.lpush("Score", e.getScore() + "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	@Override
	public void which() {
		System.out.println("Je suis la base Redis");
	}

}
