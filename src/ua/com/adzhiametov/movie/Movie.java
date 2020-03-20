package ua.com.adzhiametov.movie;

/**
 * Created by arsen_adzhiametov on 15/01/2016.
 */
public class Movie {

	private String title;
	private int positiveVotesCount;
	private int negativeVotesCount;
	private int internalCumulativeRating;

	public Movie(String title, int positiveVotesCount, int negativeVotesCount) {
		this.title = title;
		this.positiveVotesCount = positiveVotesCount;
		this.negativeVotesCount = negativeVotesCount;
	}

	public String getTitle() {
		return title;
	}

	public int getPositiveVotesCount() {
		return positiveVotesCount;
	}

	public int getNegativeVotesCount() {
		return negativeVotesCount;
	}

	public int getInternalCumulativeRating() {
		return internalCumulativeRating;
	}

	public void setInternalCumulativeRating(int internalCumulativeRating) {
		this.internalCumulativeRating = internalCumulativeRating;
	}
}
