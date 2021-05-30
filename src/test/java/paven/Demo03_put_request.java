package paven;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import java.util.HashMap;

public class Demo03_put_request {
	public static HashMap map = new HashMap();
	@BeforeClass
	public void loadData() {
		map.put("id", 1);
		map.put("title","ahmett");
		map.put("body","can1");
		map.put("userId",10);
		
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		RestAssured.basePath="/posts/1";
	}
	@Test
	public void postData() {
		given()
			.contentType("application/json; charset=utf-8")
			.body(map)
		
		.when()
			.put()
		
		.then()
			.statusCode(200);
			
		
	}


}
