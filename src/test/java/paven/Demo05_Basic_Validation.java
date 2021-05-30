package paven;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import junit.framework.Assert;

public class Demo05_Basic_Validation {
	@Test(priority=1)  //status code
	public void testSatusCode() {
		given()
		
		.when()
			.get("https://jsonplaceholder.typicode.com/posts/5")
			
		.then()
			.statusCode(200);
	}
	
	@Test(priority=2)
	public void testLog() {
		given()
		
		.when()
			.get("https://jsonplaceholder.typicode.com/posts/5")
		.then()
		.log().all();
	}
	
	@Test(priority=3)
	public void singleValidation() {
		given()
		
		.when()
			.get("https://jsonplaceholder.typicode.com/posts/5")
		.then()
		.statusCode(200)
		.body("title",equalTo("nesciunt quas odio"));
	}
	
	@Test(priority=4)
	public void multipleValidation() {
		given()
		
		.when()
			.get("https://jsonplaceholder.typicode.com/posts/1/comments")
		.then()
		.statusCode(200)
		.body("email",hasItems("Jayne_Kuhic@sydney.com","Eliseo@gardner.biz"));
	}
	
	//param and header except
	
}
