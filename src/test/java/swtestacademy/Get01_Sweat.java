package swtestacademy;

import org.junit.*;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Get01_Sweat {
	//https://www.swtestacademy.com/rest-assured-tutorial-api-testing/
	
	
@Test 
public void getRequest() {
	
	// /gen/clients 
	RestAssured.baseURI="https://generator.swagger.io/api";
	given().when().get("/gen/clients").then().statusCode(200);
}
}
