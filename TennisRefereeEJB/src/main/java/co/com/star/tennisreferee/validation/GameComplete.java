package co.com.star.tennisreferee.validation;

import co.com.star.tennisreferee.dto.ValidateDTO;
import co.com.star.tennisreferee.enums.EScoreGame;
import co.com.star.tennisreferee.exception.GameCompleteException;
import co.com.star.tennisreferee.exception.TennisRefereeValidationException;

public class GameComplete implements IValidation {

	@Override
	public void validate(ValidateDTO validateDTO) throws TennisRefereeValidationException {
		
		if (EScoreGame.WINNER_GAME_PLAYER_ONE.getNameGame().equals(validateDTO.getScoreGame()) 
				|| EScoreGame.WINNER_GAME_PLAYER_TWO.getNameGame().equals(validateDTO.getScoreGame())) {
			
			throw new GameCompleteException("El juego ha terminado porque ya fue nombrado un ganador");
			
		}
	}

}
