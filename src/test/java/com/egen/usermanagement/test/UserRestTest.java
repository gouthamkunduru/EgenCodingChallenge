package com.egen.usermanagement.test;

import java.net.URI;
import java.util.UUID;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.egen.usermanagement.entities.Users;

/**
 * 	Testcases using Junit Framework
 * Created by Goutham Kunduru on 06/29/2017.
 * 
 * @author Goutham Kunduru
 * @version 1.0
 */
// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations="file:src/main/webapp/WEB-INF/applicationContext.xml")
public class UserRestTest {

	public static final String URI = "http://localhost:8080/";

	@Test
	public void testPostUser() {
		RestTemplate restTemplate = new RestTemplate();
		Users users = new Users(UUID.randomUUID(),"firstName", "middleName", "lastName", 25, "M", 5454784514l, "zip");
		URI uri = restTemplate.postForLocation(URI + "/createuser", users, Users.class);
	}

	@Test
	public void testGetAllUsers() {
		RestTemplate restTemplate = new RestTemplate();
		Users user = restTemplate.getForObject(URI + "/getallusers", Users.class);
		System.out.println(user);
	}

	@Test
	public void testUpdateUser() {
		RestTemplate restTemplate = new RestTemplate();
		Users user = new Users(UUID.randomUUID(), "firstName", "middleName", "lastName", 26, "M", 5454784514l, "zip");
		restTemplate.put(URI + "/updateuser", user);
	}
}
