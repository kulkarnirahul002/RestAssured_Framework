package com.rmg.projecttest;

import java.io.FileInputStream;

import org.testng.annotations.Test;

import GenericUtils.EndPoints;
import GenericUtils.IPathConstants;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatingProjectWithJson {
	@Test
	public void createProjectWithJson() throws Throwable {
		FileInputStream file=new FileInputStream(IPathConstants.JsonFilePath);
		baseURI="http://localhost";
		port=8084;
		
		given()
		.contentType(ContentType.JSON)
		.body(file)
		
		 .when()
		 .post(EndPoints.addProject)
		 
		 .then()
		 .assertThat().statusCode(201).log().all();
		
		
		
		
	}
	

}
