package co.com.star.tennisreferee.validation;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import co.com.star.tennisreferee.dto.ScoreRequestDTO;
import co.com.star.tennisreferee.dto.ValidateDTO;
import co.com.star.tennisreferee.exception.TennisRefereeValidationException;

public class Validation {

	@Inject
	private GameComplete gameComplete;
	
	@Inject
	private PointsPerPlayer pointsPerPlayer;
	
	@Inject
	private GameHavePoints gameHavePoints;


	public void validateScore(ScoreRequestDTO scoreRequestDTO, String scoreGame) throws TennisRefereeValidationException {
	
		List<IValidation> validationsScore = new ArrayList<>();
		
		validationsScore.add(gameComplete);
		validationsScore.add(pointsPerPlayer); 
		validationsScore.add(gameHavePoints); 
		
		ValidateDTO validateDTO = buildValidateDTO(scoreRequestDTO, scoreGame);
		
		for (IValidation iValidation : validationsScore) {
			iValidation.validate(validateDTO);
		}
		
	}

	private ValidateDTO buildValidateDTO(ScoreRequestDTO scoreRequestDTO, String scoreGame) {

		ValidateDTO validateDTO = new ValidateDTO();
		validateDTO.setPlayerOnePoint(scoreRequestDTO.isPlayerOnePoint());
		validateDTO.setPlayerTwoPoint(scoreRequestDTO.isPlayerTwoPoint());
		validateDTO.setScoreGame(scoreGame); 
		
		return validateDTO;
		
	}
	
}
