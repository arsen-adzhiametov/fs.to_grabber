package ua.com.adzhiametov.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.com.adzhiametov.movie.Movie;

import java.util.Map;

/**
 * Created by arsen_adzhiametov on 15/01/2016.
 */
public class Utils {

	public static String getTextForElement(WebDriver driver, WebElement element) {
		return (String) ((JavascriptExecutor) driver).executeScript(
				"return jQuery(arguments[0]).text();", element);
	}

	public static void printEntry(Map.Entry<String, Movie> e) {
		System.out.println(e.getKey() + " " + e.getValue().getPositiveVotesCount() + "/" + e.getValue().getNegativeVotesCount());
	}
}
