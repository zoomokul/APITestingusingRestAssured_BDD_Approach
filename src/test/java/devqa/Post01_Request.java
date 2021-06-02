package devqa;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//import static org.hamcrest.Matcher.*;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
//import static io.restassured.RestAssured.given;

//https://devqa.io/rest-assured-api-requests-examples/
public class Post01_Request {
	@Test(priority=1)
	public static void postRequest() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		JSONObject requestParams=new JSONObject();
		  
		
		  requestParams.put("title", "foo");
		  requestParams.put("body", "bar");
		  requestParams.put("userId", 1);
		  String requestBody=requestParams.toJSONString();
		
		Response response=given().header("Content-type", "application/json").and().body(requestBody).
				
							when().post("/posts").
							then().extract().response();
		//System.out.println(response.statusCode());
		Assert.assertEquals(201, response.statusCode());
		
		Assert.assertEquals("foo", response.jsonPath().getString("title"));
        Assert.assertEquals("bar", response.jsonPath().getString("body"));
        Assert.assertEquals("1", response.jsonPath().getString("userId"));
        Assert.assertEquals("101", response.jsonPath().getString("id"));
	}
	@Test(priority=2)
	public static void postRequestWithMap() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		HashMap requestParams=new HashMap();
		  
		
		  requestParams.put("title", "foo1");
		  requestParams.put("body", "bar1");
		  requestParams.put("userId", 11);
		 
		
		Response response=given().contentType(ContentType.JSON).and().body(requestParams).
				
							when().post("/posts").
							then().extract().response();
		//System.out.println(response.statusCode());
		Assert.assertEquals(201, response.statusCode());
		
		Assert.assertEquals("foo1", response.jsonPath().getString("title"));
        Assert.assertEquals("bar1", response.jsonPath().getString("body"));
        Assert.assertEquals("11", response.jsonPath().getString("userId"));
        
	}
	
	
	@Test(priority=3)
	public static void postRequestWithString() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		String requestBody = "{\n" +
	            "  \"title\": \"foo12\",\n" +
	            "  \"body\": \"bar12\",\n" +
	            "  \"userId\": \"12\" \n}";
		 
		
		Response response=given().contentType(ContentType.JSON).and().body(requestBody).
				
							when().post("/posts").
							then().extract().response();
		//System.out.println(response.statusCode());
		Assert.assertEquals(201, response.statusCode());
		
		Assert.assertEquals("foo12", response.jsonPath().getString("title"));
        Assert.assertEquals("bar12", response.jsonPath().getString("body"));
        Assert.assertEquals("12", response.jsonPath().getString("userId"));
        
	}
	
	

}
