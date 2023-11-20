package Demo;

import org.junit.Assert;
import org.junit.Test;
import io.restassured.RestAssured;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class REST_DEMO {
	@Test
	public void getAllUsers()
	{
		io.restassured.response.Response a = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(a.getBody()); // to get response body
		int act= a.getStatusCode(); // to get status code of the response
		Assert.assertEquals(act,200);
		System.out.println(a.time()); // to get response time
		System.out.println(a.asString());	// to get response body data in the form of string
	}

}
