package Demo;

import org.junit.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class TrelloBoard {
    String id;
    
@Test(enabled = true, priority = 1)
public void createBoard() {
    RestAssured.baseURI="https://trello.com/";
            Response rep = given().queryParam("name", "jas")
            .queryParam("key", "9b599c5a910c0daf4447b5f291960088")
            .queryParam("token", "ATTAe6b35b84b6fc2dd510f7d1072dd50abcebb2baae21508c2399bc5dc8d48d954fF1E04F6F")
            .header("Content-Type","json/application")
            .when().post("/1/boards/").then().statusCode(200).contentType(ContentType.JSON).extract().response();
            JsonPath path=new JsonPath(rep.asString());//want response as string
            System.out.println(path);
            id = path.get("id");//getting id 
            System.out.println(id);
}
@Test(enabled = true,priority = 2)
public void deleteBoard() {
    RestAssured.baseURI="https://trello.com/";
         given().queryParam("name", "jas")
        .queryParam("key", "9b599c5a910c0daf4447b5f291960088")
        .queryParam("token", "ATTAe6b35b84b6fc2dd510f7d1072dd50abcebb2baae21508c2399bc5dc8d48d954fF1E04F6F")
        .header("Content-Type","json/application")
        .when().delete("/1/boards/"+id).then().statusCode(200).contentType(ContentType.JSON).log().all();
}
}

