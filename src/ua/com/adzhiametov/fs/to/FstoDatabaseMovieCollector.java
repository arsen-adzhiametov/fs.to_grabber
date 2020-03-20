package ua.com.adzhiametov.fs.to;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ua.com.adzhiametov.movie.Movie;
import ua.com.adzhiametov.util.Config;

import java.util.HashMap;
import java.util.Map;

import static ua.com.adzhiametov.util.Config.chromeDriverPath;
import static ua.com.adzhiametov.util.Config.pagesCount;

/**
 * Created by arsen_adzhiametov on 15/01/2016.
 */
public class FstoDatabaseMovieCollector {

	private static final String CHROME_DRIVER_KEY = "webdriver.chrome.driver";

	private int pages;
	private WebDriver driver;

	public FstoDatabaseMovieCollector() {
		System.setProperty(CHROME_DRIVER_KEY, chromeDriverPath());
		driver = new ChromeDriver();
		pages = pagesCount();
	}

	public Map<String, Movie> grab() {
		Map<String, Movie> movies = new HashMap<>();

		for (int i = 0; i < pages; i++) {
			FstoMoviesPage page = new FstoMoviesPage(driver);
			page.visit(i);

			movies.putAll(page.getMovies());
		}

		driver.close();
		return movies;
	}

}
