package paven;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class Demo6_basicValidation_XML {
	@Test(priority=1)
	void testSingleContent() {
		
		given()
		
		.when()
		.get("https://www.w3schools.com/xml/note.xml")
		.then()
		.body("note.from", equalTo("Jani"))
		.log().all();
		
		
		
	}
	
	@Test(priority=2)
	void testMultipleContent() {
		
		given()
		
		.when()
		.get("https://www.w3schools.com/xml/note.xml")
		.then()
		.body("note.to", equalTo("Tove"))
		.body("note.from", equalTo("Jani"))
		.body("note.heading", equalTo("Reminder"))
		.body("note.body", equalTo("Don't forget me this weekend!"));
		

		
	}
	
	@Test(priority=3)
	void testMultipleContentOneGo() {
		
		given()
		
		.when()
		.get("https://www.w3schools.com/xml/note.xml")
		.then()
		.body("note.text()", equalTo("ToveJaniReminderDon't forget me this weekend!"));
		
		

		
	}
	
	@Test(priority=4)
	void testSingleContenthasXpath() {
		
		given()
		
		.when()
		.get("https://www.w3schools.com/xml/note.xml")
		.then()
		.body(hasXPath("/note/from"), containsString("Jani"));
		
		
		
		
	}
	
	@Test(priority=5)
	void testMultipleContenthasXpath() {
		
		given()
		
		.when()
		.get("https://www.w3schools.com/xml/cd_catalog.xml")
		.then()
		.body(hasXPath("/CATALOG/CD/ARTIST[text()='Bob Dylan']"));
		
		
		
		
	}

}
