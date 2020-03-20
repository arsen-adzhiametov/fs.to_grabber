package ua.com.adzhiametov.fs.to;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.com.adzhiametov.movie.Movie;
import ua.com.adzhiametov.util.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by arsen_adzhiametov on 15/01/2016.
 */
public class FstoMoviesPage {

	private static final String FS_TO_URL = "http://fs.life/video/films/?page=";

	private final By movie = By.cssSelector(".b-section-list .b-poster-tile__link");
	private final By title = By.className("b-poster-tile__title-short");
	private final By positiveVotes = By.className("b-poster-tile__title-info-vote-positive");
	private final By negativeVotes = By.className("b-poster-tile__title-info-vote-negative");

	private WebDriver driver;

	public FstoMoviesPage(WebDriver driver) {
		this.driver = driver;
	}

	public void visit(int pageNumber) {
		driver.get(FS_TO_URL + pageNumber);
	}

	public Map<String, Movie> getMovies() {
		Map<String, Movie> movies = new HashMap<>();

		List<WebElement> elements = driver.findElements(movie);

		for (WebElement webElement : elements) {
			String movieTitle = webElement.findElement(title).getText();
			String moviePositiveVotes = Utils.getTextForElement(driver, webElement.findElement(positiveVotes));
			String movieNegativeVotes = Utils.getTextForElement(driver, webElement.findElement(negativeVotes));

			Movie movie = new Movie(movieTitle, Integer.parseInt(moviePositiveVotes), Integer.parseInt(movieNegativeVotes));

			movies.putIfAbsent(movieTitle, movie);
		}
		return movies;
	}
}
