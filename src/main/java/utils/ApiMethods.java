package utils;

import pojo.films;
import pojo.peoples;
import pojo.starships;

import java.util.ArrayList;
/**
 * @author ASHAR IJAZ
 * Dated: 28/10/2021
 */
public class ApiMethods
{
	CommonMethods cm =new CommonMethods ();

	/**
	 * getFilmURL method returns the ID of the Film from the URL
	 * @param response   response of films api
	 * @param strTitle   title of the film to be searched
	 */
	public static String getFilmURL(films response,String strTitle){
       String urlOfFilm="";
		for (int i=0;i<response.getCount ();i++){
			if (response.getResults ().get (i).getTitle ().equals (strTitle)){
				urlOfFilm=response.getResults ().get (i).getUrl ();
				break;
			}
		}
	String idOfFilm=CommonMethods.getID(urlOfFilm);
		return idOfFilm;
	}


	/**
	 * addStarships method returns the starships for a particular Character
	 * @param response   response of peoples
	 */
	public static  ArrayList<String> addStarships(peoples response)    {
		ArrayList<String> starship = new ArrayList<String>();
       for (int i=0;i<response.getStarships ().size ();i++){
       	starship.add (response.getStarships ().get (i));
	   }
       return starship;
	}

	/**
	 * addPilots method returns the Pilots for a particular Character
	 * @param response   response of starships api
	 */
	public static  ArrayList<String> addPilots(starships response)    {
		ArrayList<String> strPilots = new ArrayList<String>();
		for (int i=0;i<response.getPilots ().size ();i++){
			strPilots.add (response.getPilots ().get (i));
		}
		return strPilots;
	}

	/**
	 * validatePilotName method validates the Pilot Name
	 * @param response   response of peoples api
	 */
	public static Boolean validatePilotName(peoples response){
        if (response.getName ().equals ("Luke Skywalker")){
        	return true;
		}
		return false;
	}

	/**
	 * validateCharacterName method validates the Name of the Character
	 * @param response   response of peoples api
	 */
	public static Boolean validateCharacterName(peoples response){
		if (response.getName ().equals ("Biggs Darklighter")){
			return true;
		}
		return false;
	}
}
