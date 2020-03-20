package ua.com.adzhiametov.movie;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by arsen_adzhiametov on 15/01/2016.
 */
public class MovieRatingComparator implements Comparator<String> {

	private Map<String, Movie> map;

	public MovieRatingComparator(Map<String, Movie> map) {
		this.map = map;
	}

	@Override
	public int compare(String o1, String o2) {
		Movie movie1 = map.get(o1);
		Movie movie2 = map.get(o2);

		return movie2.getInternalCumulativeRating() - movie1.getInternalCumulativeRating();
	}
}
