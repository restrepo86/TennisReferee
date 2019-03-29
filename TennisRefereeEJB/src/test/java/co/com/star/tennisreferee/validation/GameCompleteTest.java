package co.com.star.tennisreferee.validation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.star.tennisreferee.dto.ValidateDTO;
import co.com.star.tennisreferee.enums.EScoreGame;
import co.com.star.tennisreferee.exception.GameCompleteException;
import co.com.star.tennisreferee.exception.TennisRefereeValidationException;

@RunWith(MockitoJUnitRunner.class)
public class GameCompleteTest {

	@InjectMocks
	private GameComplete gameComplete;
	
	private ValidateDTO validateDTO;
	
	
	@Before
	public void setUp() {
		
		validateDTO = new ValidateDTO();
		
	}
	
	@Test(expected = GameCompleteException.class)
	public void shouldBeValidateGameCompleteAndThrowGameCompleteException() throws TennisRefereeValidationException {
		validateDTO.setScoreGame(EScoreGame.WINNER_GAME_PLAYER_ONE.getNameGame());
		gameComplete.validate(validateDTO);
	}
	
	@Test(expected = GameCompleteException.class)
	public void shouldBeValidateGameCompleteAndThrowGameCompleteExceptionTestTwo() throws TennisRefereeValidationException {
		validateDTO.setScoreGame(EScoreGame.WINNER_GAME_PLAYER_TWO.getNameGame());
		gameComplete.validate(validateDTO);
	}
	
	@Test
	public void shouldBeValidateGameCompleteAndContinue() throws TennisRefereeValidationException {
		validateDTO.setScoreGame(EScoreGame.DEUCE.getNameGame());
		gameComplete.validate(validateDTO);
	}
	
	@Test
	public void shouldBeValidateGameCompleteAndContinueTestTwo() throws TennisRefereeValidationException {
		validateDTO.setScoreGame(null);
		gameComplete.validate(validateDTO);
	}
}
