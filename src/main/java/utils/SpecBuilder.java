package utils;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder
{
	public static RequestSpecification requestBuilder(){
		RequestSpecification req = new RequestSpecBuilder ().setBaseUri ("https://swapi.dev/api/")
				.setContentType (ContentType.JSON).build ();
		return req;

	}

	public static ResponseSpecification responseBuilder(){
		ResponseSpecification resspec = new ResponseSpecBuilder ().expectStatusCode (200)
				.expectContentType (ContentType.JSON).build ();
		return resspec;


	}


}
