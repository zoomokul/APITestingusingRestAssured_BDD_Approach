package paven;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class Demo01_get_request {
	@Test
	public void getTodos() {
		
		given().
		
		when().
			get("https://jsonplaceholder.typicode.com/todos/1").
			
		then().
			statusCode(200).
			statusLine("HTTP/1.1 200 OK").
			assertThat().
			body("title",equalTo("delectus aut autem")).
			header("Content-Type", "application/json; charset=utf-8");


		
	

}
}