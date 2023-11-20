package Demo;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
public class REST_demo {
		
			@Test ( enabled = false)
			public void getAllUsers()
			{
				io.restassured.response.Response a = RestAssured.get("https://reqres.in/api/users?page=2");
				System.out.println(a.getBody()); // to get response body
				int act= a.getStatusCode(); // to get status code of the response
				Assert.assertEquals(act,200);
				System.out.println(a.time()); // to get response time
				System.out.println(a.asString());	// to get response body data in the form of string
			}
			
			@Test ( enabled = true)
			public void getOneUser()
			{
				given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();
			//	given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().body("data.id[0]",equalTo(7));
			//	System.out.println(given().get("https://reqres.in/api/users?page=2".then().statusCode(200).log().all());
		// TODO Auto-generated method stub

	}

}
