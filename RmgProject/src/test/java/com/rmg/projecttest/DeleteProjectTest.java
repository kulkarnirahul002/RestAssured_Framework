package com.rmg.projecttest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProjectTest {
	
	@Test
	public void deleteProject() {
		Response resp=RestAssured.delete("http://localhost:8084/projects/TY_PROJ_602");
		//System.out.println(resp.asString());
		System.out.println(resp.prettyPrint());
		//resp.then().log().all();
	}

}
