package co.com.star.tennisreferee.validation.gamescore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.star.tennisreferee.enums.EGameScore;

@RunWith(MockitoJUnitRunner.class)
public class WinnerGameTest {

	@InjectMocks
	private WinnerGame winnerGame;
	 
	@Test
	public void shouldBeExecuteRuleWinnerGameAndReturnWinnerPlayerOne() {
		String gameScore = winnerGame.executeRule(4, 2);
		assertEquals(EGameScore.WINNER_GAME_PLAYER_ONE.getNameGame(), gameScore);
	}
	
	@Test
	public void shouldBeExecuteRuleWinnerGameAndReturnWinnerPlayerOneTestTwo() {
		String gameScore = winnerGame.executeRule(90, 88);
		assertEquals(EGameScore.WINNER_GAME_PLAYER_ONE.getNameGame(), gameScore);
	}
	
	@Test
	public void shouldBeExecuteRuleWinnerGameAndReturnWinnerPlayerTwo() {
		String gameScore = winnerGame.executeRule(2, 4);
		assertEquals(EGameScore.WINNER_GAME_PLAYER_TWO.getNameGame(), gameScore);
	}
	
	@Test
	public void shouldBeExecuteRuleWinnerGameAndReturnWinnerPlayerTwoTestTwo() {
		String gameScore = winnerGame.executeRule(40, 42);
		assertEquals(EGameScore.WINNER_GAME_PLAYER_TWO.getNameGame(), gameScore);
	}
	
	@Test
	public void shouldBeExecuteRuleWinnerGameAndReturnGameScoreNull() {
		String gameScore = winnerGame.executeRule(0, 3);
		assertNull(gameScore);
	}
	
	@Test
	public void shouldBeExecuteRuleWinnerGameAndReturnGameScoreNullTestTwo() {
		String gameScore = winnerGame.executeRule(3, 0);
		assertNull(gameScore);
	}
	
	@Test
	public void shouldBeExecuteRuleWinnerGameAndReturnGameScoreNullTestThree() {
		String gameScore = winnerGame.executeRule(4, 3);
		assertNull(gameScore);
	}
}
