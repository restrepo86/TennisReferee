package co.com.star.tennisreferee.business;

import java.util.Map;

import javax.inject.Inject;

import co.com.star.tennisreferee.dto.ScoreRequestDTO;
import co.com.star.tennisreferee.dto.ScoreTennis;
import co.com.star.tennisreferee.exception.TennisRefereeValidationException;
import co.com.star.tennisreferee.homologations.Build;
import co.com.star.tennisreferee.validation.Validation;

public class TennisRefereeBusiness {

	@Inject
	private Validation validation;
	  
	public ScoreTennis calculateScore(ScoreRequestDTO scoreRequestDTO) throws TennisRefereeValidationException {
		      
		validation.validateScore(scoreRequestDTO);
		ScoreTennis scoreTennis = ScoreTennis.getInstance();
		
		int scorePlayerOne = scoreRequestDTO.isPlayerOnePoint() ? scoreTennis.getScorePlayerOne() + 1 : scoreTennis.getScorePlayerOne();
		int scorePlayerTwo = scoreRequestDTO.isPlayerTwoPoint() ? scoreTennis.getScorePlayerTwo() + 1 : scoreTennis.getScorePlayerTwo();
					
		Map<Integer, String> scoreDescription = Build.getScoreDescription();
 
		scoreTennis.setScorePlayerOneDescription(scoreDescription.get(scorePlayerOne));
		scoreTennis.setScorePlayerTwoDescription(scoreDescription.get(scorePlayerTwo));
		
		scoreTennis.setScorePlayerOne(scorePlayerOne);
		scoreTennis.setScorePlayerTwo(scorePlayerTwo); 
		
		return scoreTennis;
		
	}

	

}
