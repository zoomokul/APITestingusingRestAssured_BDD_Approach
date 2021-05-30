package paven;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import java.util.HashMap;



public class Demo02_post_request {
	public static HashMap map = new HashMap();
	@BeforeClass
	public void loadData() {
		
		map.put("title","ahmett");
		map.put("body","can1");
		map.put("userId",10);
		
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		RestAssured.basePath="/posts";
	}
	@Test
	public void postData() {
		given()
			.contentType("application/json; charset=utf-8")
			.body(map)
		
		.when()
			.post()
		
		.then()
			.statusCode(201)
			.body("body",equalTo("can1"))
			.and()
			.body("title",equalTo("ahmett"));
		
	}

}
