package com.rmg.projecttest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtils.EndPoints;
import PojoClass.ProjectLibrary;
import io.restassured.http.ContentType;

public class CreateProjectWithMultipleData {
	
	@Test (dataProvider = "giveData")
	public void createProjectWithMultipleData(String createdBy,String status,String projectName,int teamSize) {
		
		
		ProjectLibrary plib=new ProjectLibrary(createdBy, status, projectName, teamSize);
		baseURI="http://localhost";
		port=8084;
		
		given()
		.contentType(ContentType.JSON)
		.body(plib)
		
		 .when()
		 .post(EndPoints.addProject)
		 
		 .then()
		 .assertThat().statusCode(201).log().all();
		
	}
	
	@DataProvider
	public Object[][] giveData(){
		
		Object[][] obj=new Object[2][4];
		
		obj[0][0]="Raj";
		obj[0][1]="Created";
		obj[0][2]="Matte";
		obj[0][3]=20;
		
		obj[1][0]="Rajesh";
		obj[1][1]="Created";
		obj[1][2]="Matte 2";
		obj[1][3]=10;
		
		return obj;
		
	}
}


