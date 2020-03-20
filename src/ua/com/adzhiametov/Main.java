package ua.com.adzhiametov;

import ua.com.adzhiametov.fs.to.FstoDatabaseMovieCollector;
import ua.com.adzhiametov.movie.Movie;
import ua.com.adzhiametov.movie.MoviePriorityCalculator;
import ua.com.adzhiametov.movie.MovieRatingComparator;
import ua.com.adzhiametov.util.Utils;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by arsen_adzhiametov on 14/01/2016.
 * rely on guides from below links
 * https://code.google.com/p/selenium/wiki/GettingStarted
 * https://sites.google.com/a/chromium.org/chromedriver/getting-started
 */
public class Main {

	public static void main(String[] args) {

		Map<String, Movie> movies = new FstoDatabaseMovieCollector().grab();

		MoviePriorityCalculator moviePriorityCalculator = new MoviePriorityCalculator();

		movies.forEach((k,v) -> moviePriorityCalculator.calculateAndSetMoviePriority(v));

		Map<String, Movie> sortedMovies = new TreeMap<>(new MovieRatingComparator(movies));

		sortedMovies.putAll(movies);

		sortedMovies.entrySet()
				.stream()
				.filter(movieEntry -> movieEntry.getValue().getPositiveVotesCount() > 4000)
				.forEach(Utils::printEntry);
	}
}