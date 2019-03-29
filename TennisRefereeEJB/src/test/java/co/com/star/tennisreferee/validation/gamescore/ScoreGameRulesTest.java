package co.com.star.tennisreferee.validation.gamescore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.star.tennisreferee.enums.EScoreGame;

@RunWith(MockitoJUnitRunner.class)
public class ScoreGameRulesTest {

	@InjectMocks
	private ScoreGameRules scoreGame;
	
	@Spy
	private WinnerGame winnerGame;
	
	@Spy
	private DeuceGame deuceGame;

	@Spy
	private VentajeGame ventajaGame;

	@Test
	public void shouldBeGetScoreGameNull() {
		int scorePlayerOne = 0;
		int scorePlayerTwo = 0;
		Optional<String> scoreGameResultOpt = scoreGame.getScoreGame(scorePlayerOne, scorePlayerTwo);
		assertFalse(scoreGameResultOpt.isPresent());
	}
	
	@Test
	public void shouldBeGetScoreGameNullTestTwo() {
		int scorePlayerOne = 2; 
		int scorePlayerTwo = 2; 
		Optional<String> scoreGameResultOpt = scoreGame.getScoreGame(scorePlayerOne, scorePlayerTwo);
		assertFalse(scoreGameResultOpt.isPresent());
	}
	
	@Test
	public void shouldBeGetScoreGameNullTestThree() {
		int scorePlayerOne = 3; 
		int scorePlayerTwo = 2; 
		Optional<String> scoreGameResultOpt = scoreGame.getScoreGame(scorePlayerOne, scorePlayerTwo);
		assertFalse(scoreGameResultOpt.isPresent());
	}
	
	@Test
	public void shouldBeGetScoreGameNullTestFour() {
		int scorePlayerOne = 1; 
		int scorePlayerTwo = 3; 
		Optional<String> scoreGameResultOpt = scoreGame.getScoreGame(scorePlayerOne, scorePlayerTwo);
		assertFalse(scoreGameResultOpt.isPresent());
	}
	
	@Test
	public void shouldBeGetScoreGameWinnerPlayerOne() {
		int scorePlayerOne = 4;
		int scorePlayerTwo = 2;
		Optional<String> scoreGameResultOpt = scoreGame.getScoreGame(scorePlayerOne, scorePlayerTwo);
		assertEquals(EScoreGame.WINNER_GAME_PLAYER_ONE.getNameGame(), scoreGameResultOpt.get());
	}
	
	@Test
	public void shouldBeGetScoreGameWinnerPlayerTwo() {
		int scorePlayerOne = 12;
		int scorePlayerTwo = 14;
		Optional<String> scoreGameResultOpt = scoreGame.getScoreGame(scorePlayerOne, scorePlayerTwo);
		assertEquals(EScoreGame.WINNER_GAME_PLAYER_TWO.getNameGame(), scoreGameResultOpt.get());
	}
	
	@Test
	public void shouldBeGetScoreGameDeuce() {
		int scorePlayerOne = 3;
		int scorePlayerTwo = 3;
		Optional<String> scoreGameResultOpt = scoreGame.getScoreGame(scorePlayerOne, scorePlayerTwo);
		assertEquals(EScoreGame.DEUCE.getNameGame(), scoreGameResultOpt.get());
	}
	
	@Test
	public void shouldBeGetScoreGameDeuceTestTwo() {
		int scorePlayerOne = 38;
		int scorePlayerTwo = 38;
		Optional<String> scoreGameResultOpt = scoreGame.getScoreGame(scorePlayerOne, scorePlayerTwo);
		assertEquals(EScoreGame.DEUCE.getNameGame(), scoreGameResultOpt.get());
	}
	
	@Test
	public void shouldBeGetScoreGameVentajaPlayerOne() {
		int scorePlayerOne = 4;
		int scorePlayerTwo = 3;
		Optional<String> scoreGameResultOpt = scoreGame.getScoreGame(scorePlayerOne, scorePlayerTwo);
		assertEquals(EScoreGame.VENTAJA_PLAYER_ONE.getNameGame(), scoreGameResultOpt.get());
	}
	
	@Test
	public void shouldBeGetScoreGameVentajaPlayerTwo() {
		int scorePlayerOne = 3;
		int scorePlayerTwo = 4;
		Optional<String> scoreGameResultOpt = scoreGame.getScoreGame(scorePlayerOne, scorePlayerTwo);
		assertEquals(EScoreGame.VENTAJA_PLAYER_TWO.getNameGame(), scoreGameResultOpt.get());
	}
	
	
}
