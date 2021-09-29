package ParametersAndAuthentication;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {

	@Test
	public void givePathParameter()
	{
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		.pathParam("projId", "TY_PROJ_001")
		
		.when()
		.get("/projects/{projId}")
		.then().log().all();
	}
}
