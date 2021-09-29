package com.rmg.projecttest;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectNameTest {
	
	@Test
	public void updaterequestprojects() {
		HashMap map = new HashMap();
		
		map.put("createdBy", "Wilson");
		map.put("projectName", "W2");
		//Updated status previously Created --> Completed
		map.put("status", "Completed");
		map.put("teamSize",10);
		
		
		RequestSpecification req=RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(map);
		Response res=req.put("http://localhost:8084/projects/TY_PROJ_602");
		System.out.println(res.prettyPrint());

		
	}

}
