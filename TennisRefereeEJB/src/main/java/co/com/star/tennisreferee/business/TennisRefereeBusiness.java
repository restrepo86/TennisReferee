package co.com.star.tennisreferee.business;

import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;

import co.com.star.tennisreferee.dto.ScoreRequestDTO;
import co.com.star.tennisreferee.dto.ScoreTennis;
import co.com.star.tennisreferee.exception.TennisRefereeValidationException;
import co.com.star.tennisreferee.homologations.Build;
import co.com.star.tennisreferee.validation.Validation;
import co.com.star.tennisreferee.validation.gamescore.ScoreGameRules;

public class TennisRefereeBusiness {

	@Inject
	private Validation validation;
	
	@Inject
	private ScoreGameRules scoreGameRules;
	  
	public ScoreTennis calculateScore(ScoreRequestDTO scoreRequestDTO) throws TennisRefereeValidationException {
		        
		validation.validateScore(scoreRequestDTO);
		ScoreTennis scoreTennis = ScoreTennis.getInstance();
		
		int scorePlayerOne = scoreRequestDTO.isPlayerOnePoint() ? scoreTennis.getScorePlayerOne() + 1 : scoreTennis.getScorePlayerOne();
		int scorePlayerTwo = scoreRequestDTO.isPlayerTwoPoint() ? scoreTennis.getScorePlayerTwo() + 1 : scoreTennis.getScorePlayerTwo();
		scoreTennis.setScorePlayerOne(scorePlayerOne);
		scoreTennis.setScorePlayerTwo(scorePlayerTwo); 
		
		Optional<String> scoreGameOpt = scoreGameRules.getScoreGame(scorePlayerOne, scorePlayerTwo);
		scoreGameOpt.ifPresent(scoreGame -> scoreTennis.setScoreGame(scoreGame)); 
		
		Map<Integer, String> scoreDescription = Build.getScoreDescription();
 
		scoreTennis.setScorePlayerOneDescription(scoreDescription.get(scorePlayerOne));
		scoreTennis.setScorePlayerTwoDescription(scoreDescription.get(scorePlayerTwo));
		
		return scoreTennis; 
		
	}

	

}
