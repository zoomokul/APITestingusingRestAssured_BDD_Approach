package paven;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import java.util.HashMap;

public class Demo04_Delete_Request {
	

	

@Test
public void postData() {
	RestAssured.baseURI="https://jsonplaceholder.typicode.com";
	RestAssured.basePath="/posts/1";
	
	given()
		
	.when()
		.delete()
	
	.then()
		.statusCode(200)
		.log().all();
		
	
}

}
