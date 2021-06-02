package devqa;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matcher.*;
import static io.restassured.RestAssured.*;
import org.testng.Assert;

public class Get01_request {
	
	//https://devqa.io/rest-assured-api-requests-examples/
	@Test(priority=1)
	public static void getRequest() {
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
			Response response=given().contentType(ContentType.JSON)
		
			.when().get("/posts")
		
			.then().extract().response();
			
			// statusLine:HTTP/1.1 200 OK
			//System.out.println(response.jsonPath().getString("title[1]")); //"qui est esse"
			Assert.assertEquals("qui est esse", response.jsonPath().getString("title[1]"));
			Assert.assertEquals("HTTP/1.1 200 OK", response.statusLine());
		
	}
	@Test(priority=2)
	public static void getRequestWithQueryParams() {
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		Response response=
				given().contentType(ContentType.JSON).param("postId", "2").
				
				when().get("/comments").
				
				then().extract().response();
		
		Assert.assertEquals(200, response.statusCode());
		//System.out.println(response.jsonPath().getString("email[1]")); //Dallas@ole.me
		Assert.assertEquals("Dallas@ole.me", response.jsonPath().getString("email[1]"));
	}

		

}
