package com.rmg.projecttest;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class UpdateProjectUsingBDDTest {

	@Test
	public void updateProjects() {
		
		//create json object
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Wilson");
		jobj.put("projectName", "W3");
		jobj.put("status", "Created");
		jobj.put("teamSize",20);
		
		//set content type
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat().statusCode(201).log().all();
	}
}
