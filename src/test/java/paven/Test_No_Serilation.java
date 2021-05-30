package paven;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.*;

public class Test_No_Serilation {
	public HashMap map=new HashMap();

	@Test(priority=1)
	public void createUser() {
		
		map.put("id", 4);
		map.put("name", "akif");
		map.put("number", "555");
		
		List<String> courseList=new ArrayList<String>();
		courseList.add("csharp");
		courseList.add("javascript");
		map.put("courses", courseList);
		
		given()
			.contentType(ContentType.JSON)
			.body(map)
		
		.when()
		.post("http://localhost:3000/users")
		.then()
		.statusCode(201);
		
	}
	
	@Test(priority=2)
	public void getUser() {
		
		
		
		given()
			
		
		.when()
			.get("http://localhost:3000/users/4")
		.then()
			.statusCode(200)
			.assertThat()
			.body("id", equalTo(4));
		
	}

}
