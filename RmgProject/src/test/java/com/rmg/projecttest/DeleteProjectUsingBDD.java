package com.rmg.projecttest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DeleteProjectUsingBDD {
	@Test
	public void deleteProject() {
		
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_603")
		
		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
		
		
	}

}
