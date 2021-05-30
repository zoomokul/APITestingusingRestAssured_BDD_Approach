package paven;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import java.util.HashMap;


public class Demo05_Delete_response_Request {
	

@Test
public void delData() {
	RestAssured.baseURI="https://jsonplaceholder.typicode.com";
	RestAssured.basePath="/posts/1";
	
	Response response=
	given()
		
	.when()
		.delete()
	
	.then()
		.statusCode(200)
		.log().all().extract().response();
	
	System.out.println("Response :"+response.asPrettyString());
	
	String str=response.asPrettyString();
	
	Assert.assertEquals(str.contains("{"), true);
		
	
}

}
