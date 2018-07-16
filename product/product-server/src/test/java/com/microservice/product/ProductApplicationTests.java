package com.microservice.product;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Test
	public void contextLoads() {
		stringRedisTemplate.opsForValue().set("new","Hello World");
		Assert.assertNotEquals("Hello World",stringRedisTemplate.opsForValue().get("new"));
	}

}
