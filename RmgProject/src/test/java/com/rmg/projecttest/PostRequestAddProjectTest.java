package com.rmg.projecttest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestAddProjectTest {
	@Test
	public void createProject() {
		
		JSONObject jobj=new JSONObject();
		
		jobj.put("createdBy", "Wilson");
		jobj.put("projectName", "W2");
		jobj.put("status", "Created");
		jobj.put("teamSize",10);
		
		//Request Specification
		
		RequestSpecification req=RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jobj);
		Response res=req.post("http://localhost:8084/addProject");
		
		//Print response 
		
		System.out.println(res.prettyPrint());
		System.out.println(res.prettyPeek());
		
	}

}
