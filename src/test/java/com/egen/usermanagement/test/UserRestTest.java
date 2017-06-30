package com.egen.usermanagement.test;
import java.net.URI;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.egen.usermanagement.entities.Users;
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/applicationContext.xml")
public class UserRestTest {

	public static final String URI = "http://localhost:8080/";
	
	@Test
	public void testPostUser() {
        RestTemplate restTemplate = new RestTemplate();
        Users users = new Users(3,"firstName", "middleName", "lastName", 25, "M", 5454784514l, "zip");
        URI uri = restTemplate.postForLocation(URI+"/createuser", users, Users.class);
	}

	@Test
	public void testGetAllUsers() {
		RestTemplate restTemplate = new RestTemplate();
        Users user = restTemplate.getForObject(URI+"/getallusers", Users.class);
        System.out.println(user);
	}

	@Test
	public void testUpdateUser() {
		RestTemplate restTemplate = new RestTemplate();
        Users user  = new Users(3,"firstName", "middleName", "lastName", 26, "M", 5454784514l, "zip");
        restTemplate.put(URI+"/updateuser", user);
	}
}
