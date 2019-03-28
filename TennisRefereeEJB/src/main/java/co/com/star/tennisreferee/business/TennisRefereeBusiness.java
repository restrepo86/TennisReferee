package co.com.star.tennisreferee.business;

import javax.inject.Inject;

import co.com.star.tennisreferee.dto.ScoreRequestDTO;
import co.com.star.tennisreferee.dto.ScoreTennis;
import co.com.star.tennisreferee.exception.TennisRefereeValidationException;
import co.com.star.tennisreferee.validation.Validation;

public class TennisRefereeBusiness {

	@Inject
	private Validation validation;
	  
	public ScoreTennis calculateScore(ScoreRequestDTO scoreRequestDTO) throws TennisRefereeValidationException {
		     
		validation.validateScore(scoreRequestDTO);
		ScoreTennis scoreTennis = ScoreTennis.obtenerInstancia();
		
		scoreTennis.setScorePlayerOne(scoreRequestDTO.isPlayerOnePoint() ? scoreTennis.getScorePlayerOne() + 1 : scoreTennis.getScorePlayerOne());
		scoreTennis.setScorePlayerTwo(scoreRequestDTO.isPlayerTwoPoint() ? scoreTennis.getScorePlayerTwo() + 1 : scoreTennis.getScorePlayerTwo());
		
		return scoreTennis;
		
	}

	

}
