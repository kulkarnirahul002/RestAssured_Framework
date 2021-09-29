package com.rmg.projecttest;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetProjectsUsingBddTest {
	@Test
	public void getProjectsBDD() {
		
		baseURI="http://localhost:8084";
		port=8084;
		when()
		.get("/projects")
		
		.then()
		.assertThat().statusCode(200)
		.assertThat().time(Matchers.lessThan(10000L), TimeUnit.MILLISECONDS)//hamcrest validation used for duration of request less than 10000 ms
		.log().all();
	}

}
