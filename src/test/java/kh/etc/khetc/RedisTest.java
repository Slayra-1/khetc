package kh.etc.khetc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisTest {

	static final String REDIS_KEY = "1102_r";

	@Autowired
	RedisTemplate stringRedisTemplate;


	@Test
	public void redisTest() {
		String value = "hello 1102";

		stringRedisTemplate.opsForValue().set(REDIS_KEY, value);

		System.out.println(stringRedisTemplate.opsForValue().get(REDIS_KEY));

	}

}
