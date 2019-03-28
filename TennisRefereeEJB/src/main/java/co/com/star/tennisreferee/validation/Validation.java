package co.com.star.tennisreferee.validation;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import co.com.star.tennisreferee.dto.ScoreRequestDTO;
import co.com.star.tennisreferee.exception.TennisRefereeValidationException;

public class Validation {

	@Inject
	private PointsPerPlayer pointsPerPlayer;
	
	@Inject
	private GameHavePoints gameHavePoints;

	public void validateScore(ScoreRequestDTO scoreRequestDTO) throws TennisRefereeValidationException {
	
		List<IValidation> validationsScore = new ArrayList<>();
		
		validationsScore.add(pointsPerPlayer);
		validationsScore.add(gameHavePoints);
		
		for (IValidation iValidation : validationsScore) {
			iValidation.validate(scoreRequestDTO);
		}
		
	}
	
}
