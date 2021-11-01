package tests;

import constants.ENDPOINTS;
import static io.restassured.RestAssured.*;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojo.films;
import pojo.peoples;
import pojo.results;
import pojo.starships;
import utils.ApiMethods;
import utils.CommonMethods;

import java.util.ArrayList;

public class TEST_ValidateAPI {
	@Test(dataProvider = "getData")
	public void RestAPI(String strTitle,String strCharacterName,String strStarShip,String strPilot) {
		String nameOfStarShip = "";
		String classOfStarShip = "";
		String nameOfPilot = "";
		String filmID = "";
		String nameOfCharacter = "";
		peoples peopleResopnse = null;
		String titleOfFilm = "";

		ArrayList < String > starship = new ArrayList < String > ();
		ArrayList < String > pilotsOnStartShip = new ArrayList < String > ();

		// Saving the request spec builder
		RequestSpecification req = utils.SpecBuilder.requestBuilder();
		//Saving the response spec builder
		ResponseSpecification resspec = utils.SpecBuilder.responseBuilder();
		RequestSpecification res = given().spec(req);

		//Get all the films
		films responseforAllFilms =
				res.when().get(ENDPOINTS.STAR_WARS_FILMS)
						.then().spec(resspec).extract().response()
						.as(films.class);

		// Searching the Film with the Name "A New Hope " and getting its ID after the search
		filmID = ApiMethods.getFilmURL(responseforAllFilms,strTitle);

		// Searching the film on the basis on the basis of Above filmID and saving its resposne
		results films1Response =
				res.when().get(ENDPOINTS.STAR_WARS_FILMS + filmID)
						.then().spec(resspec).extract().response()
						.as(results.class);
		titleOfFilm=films1Response.getTitle ();
		Assert.assertEquals(titleOfFilm, strTitle, "Verifying the Name of the Character");


		// Searching the Characters inside the Film 1 and saving the character with name "Biggs Darklighter"
		// Saving the Starship for character with Name "Biggs DarkLighter"

		for (int i = 0; i < films1Response.getCharacters().size(); i++) {
			String peopleID = CommonMethods.getID(films1Response.getCharacters().get(i));
			peopleResopnse =
					res.when().log().all().get(ENDPOINTS.STAR_WARS_PEOPLE + peopleID)
							.then().spec(resspec).extract().response()
							.as(peoples.class);
			if (ApiMethods.validateCharacterName(peopleResopnse) == true) {
				nameOfCharacter = peopleResopnse.getName();
				starship = ApiMethods.addStarships(peopleResopnse);
				break;
			}
		}
		Assert.assertEquals(nameOfCharacter, strCharacterName, "Verifying the Name of the Character");

		// Verifying the Starship which the character "Biggs DarkLighter" had contains
		// starship class as StarFighter
		for (int i = 0; i < starship.size(); i++) {
			String starshipID = CommonMethods.getID(starship.get(i));

			starships starshipsResponse =
					res.when().log().all().get(ENDPOINTS.STAR_WARS_STARSHIPS + starshipID)
							.then().spec(resspec).extract().response()
							.as(starships.class);
			nameOfStarShip = starshipsResponse.getName();
			classOfStarShip = starshipsResponse.getStarship_class();
			pilotsOnStartShip = ApiMethods.addPilots(starshipsResponse);

		}
		Assert.assertEquals(nameOfStarShip, "X-wing", "Verifying the Name of the Starship");
		Assert.assertEquals(classOfStarShip, strStarShip, "Verifying the Class of Starship");

		// Verifying that “Luke Skywalker” is among pilots that were also flying this kind of starship

		for (int i = 0; i < pilotsOnStartShip.size(); i++) {

			String peopleID = CommonMethods.getID(pilotsOnStartShip.get(i));
			peopleResopnse =
					res.when().log().all().get(ENDPOINTS.STAR_WARS_PEOPLE + peopleID)
							.then().spec(resspec).extract().response()
							.as(peoples.class);
			if (ApiMethods.validatePilotName(peopleResopnse) == true) {
				nameOfPilot = peopleResopnse.getName();
				break;
			}
		}
		Assert.assertEquals(strPilot, nameOfPilot, "Verifying Pilot");

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][4];
		data[0][0] = "A New Hope";
		data[0][1] = "Biggs Darklighter";
		data[0][2] = "Starfighter";
		data[0][3] = "Luke Skywalker";
		return data;
	}
}
