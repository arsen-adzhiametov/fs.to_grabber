package ua.com.adzhiametov.movie;

/**
 * Created by arsen_adzhiametov on 16/01/2016.
 */
public class MoviePriorityCalculator {

	public void calculateAndSetMoviePriority(Movie movie) {
		int positiveVotesCount = movie.getPositiveVotesCount();
		int negativeVotesCount = movie.getNegativeVotesCount();
		int totalViews = positiveVotesCount + negativeVotesCount;

		int totalScore = 0;
		totalScore += calculateTotalViewScore(totalViews);
		totalScore += calculatePositiveFeedbackScore(positiveVotesCount, totalViews);

		movie.setInternalCumulativeRating(totalScore);
	}

	private int calculateTotalViewScore(int views) {
		return views / 100;
	}

	private int calculatePositiveFeedbackScore(int positiveFeedback, int totalViews) {
		if (totalViews !=0) {
			return positiveFeedback / totalViews;
		} else return 0;
	}
}
