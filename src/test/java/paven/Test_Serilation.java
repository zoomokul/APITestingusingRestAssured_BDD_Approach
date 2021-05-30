package paven;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class Test_Serilation {
	
	@Test(priority=1)
	public void createUserwithSerilation() {
		ArrayList<String> coursesList=new ArrayList<String>();
		coursesList.add("sql");
		coursesList.add("jdbc");
		
		Users usr=new Users();
		usr.setId(5);
		usr.setName("imran");
		usr.setNumber("563");
		usr.setCourses(coursesList);
		
		given()
			.contentType(ContentType.JSON)
			.body(usr)
		.when()
			.post("http://localhost:3000/users")
		.then()
			.statusCode(201);
		
		
	}
	
	/*
	@Test
	public void getUserwithSerilation() {
		
		Users usr=get("http://localhost:3000/users/5").as(Users.class);
		

		
		
	}
	*/

}
