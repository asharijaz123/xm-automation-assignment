package pojo;

import java.util.List;
/**
 * @author MUHAMMAD ASHAR
 * Dated: 29/10/2021
 */
public class results {
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String title;
	public String url;

	public int getEpisode_id() {
		return episode_id;
	}

	public void setEpisode_id(int episode_id) {
		this.episode_id = episode_id;
	}


	public String getOpening_crawl() {
		return opening_crawl;
	}

	public void setOpening_crawl(String opening_crawl) {
		this.opening_crawl = opening_crawl;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public List < String > getCharacters() {
		return characters;
	}

	public void setCharacters(List < String > characters) {
		this.characters = characters;
	}

	public List < String > getPlanets() {
		return planets;
	}

	public void setPlanets(List < String > planets) {
		this.planets = planets;
	}

	public List < String > getStarships() {
		return starships;
	}

	public void setStarships(List < String > starships) {
		this.starships = starships;
	}

	public List < String > getVehicles() {
		return vehicles;
	}

	public void setVehicles(List < String > vehicles) {
		this.vehicles = vehicles;
	}

	public List < String > getSpecies() {
		return species;
	}

	public void setSpecies(List < String > species) {
		this.species = species;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getEdited() {
		return edited;
	}

	public void setEdited(String edited) {
		this.edited = edited;
	}


	public int episode_id;
	public String opening_crawl;
	public String director;
	public String producer;
	public String release_date;
	public List < String > characters;
	public List < String > planets;
	public List < String > starships;
	public List < String > vehicles;
	public List < String > species;
	public String created;
	public String edited;






}
