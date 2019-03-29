package co.com.star.tennisreferee.validation.gamescore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.star.tennisreferee.enums.EGameScore;

@RunWith(MockitoJUnitRunner.class)
public class DeuceGameTest {

	@InjectMocks
	private DeuceGame deuceGame;
	
	@Test
	public void shouldBeExecuteRuleDeuceGameAndReturnDeuceByEqualsScore() {
		String gameScore = deuceGame.executeRule(3, 3);
		assertEquals(EGameScore.DEUCE.getNameGame(), gameScore);
	}
	
	@Test
	public void shouldBeExecuteRuleDeuceGameAndReturnDeuceByEqualsScoreTestTwo() {
		String gameScore = deuceGame.executeRule(4, 4);
		assertEquals(EGameScore.DEUCE.getNameGame(), gameScore);
	}
	
	@Test
	public void shouldBeExecuteRuleDeuceGameAndReturnDeuceByEqualsScoreTestThree() {
		String gameScore = deuceGame.executeRule(150, 150);
		assertEquals(EGameScore.DEUCE.getNameGame(), gameScore);
	}
	
	@Test
	public void shouldBeExecuteRuleDeuceGameAndContinueByNotEqualsScore() {
		String gameScore = deuceGame.executeRule(3, 4);
		assertNull(gameScore);
	}
	
	@Test
	public void shouldBeExecuteRuleDeuceGameAndContinueByNotEqualsScoreTestTwo() {
		String gameScore = deuceGame.executeRule(85, 40);
		assertNull(gameScore);
	}
	
	@Test
	public void shouldBeExecuteRuleDeuceGameAndContinueByNotEqualsScoreTestThree() {
		String gameScore = deuceGame.executeRule(100, 101);
		assertNull(gameScore);
	}
	
	@Test
	public void shouldBeExecuteRuleDeuceGameAndContinueByScoreLessThanThree() {
		String gameScore = deuceGame.executeRule(2, 2);
		assertNull(gameScore);
	}
	
	@Test
	public void shouldBeExecuteRuleDeuceGameAndContinueByScoreLessThanThreeTestTwo() {
		String gameScore = deuceGame.executeRule(1, 1);
		assertNull(gameScore);
	}
	
	@Test
	public void shouldBeExecuteRuleDeuceGameAndContinueByScoreLessThanThreeTestThree() {
		String gameScore = deuceGame.executeRule(0, 0);
		assertNull(gameScore);
	}
	
	
}
