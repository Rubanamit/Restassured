package RestAssuredProject.RestAssuredapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Getextractedbody {
	@Test
	void weatherdetails() {
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET,"?page=2");
		JsonPath path=response.jsonPath();
		System.out.println(path.get("page"));
		System.out.println(path.get("per_page"));
		System.out.println(path.get("total"));
		Assert.assertEquals(path.get("page"), 2);

}
}
