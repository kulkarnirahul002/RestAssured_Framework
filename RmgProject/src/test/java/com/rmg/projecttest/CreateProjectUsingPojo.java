package com.rmg.projecttest;

import org.testng.annotations.Test;

import GenericUtils.EndPoints;

import PojoClass.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingPojo {
	
	@Test
	public void createProjectUsingPojo() {
		baseURI="http://localhost";
		port=8084;
		
		ProjectLibrary plib=new ProjectLibrary("Keanu", "Created", "Mat2", 1);
		
		given()
		.contentType(ContentType.JSON)
		.body(plib)
		
		.when()
		.post(EndPoints.addProject)
		
		.then()
		.assertThat().statusCode(201).log().all();
		
		
		
	
	}

}
