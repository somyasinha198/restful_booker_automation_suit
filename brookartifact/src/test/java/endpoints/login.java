package endpoints;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class login {
	
	public static String createToken()
	{
		Response res = given()
                .contentType("application/json")
                .body("{\"username\":\"admin\",\"password\":\"password123\"}")
        .when()
                .post("https://restful-booker.herokuapp.com/auth");

    String token=res.jsonPath().getString("token");
       // return token;
        
        System.out.println("token beig passed--------"+  token);
		return token;


	}

}
