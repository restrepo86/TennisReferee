package co.com.star.tennisreferee.validation.gamescore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.star.tennisreferee.enums.EGameScore;

@RunWith(MockitoJUnitRunner.class)
public class VentajaGameTest {

	@InjectMocks
	private VentajeGame ventajaGame;
	
	@Test
	public void shouldBeExecuteRuleVentajaGameAndReturnVentajaByPlayerOnePointMoreOpponentAfterThreePonts() {
		String scoreGame = ventajaGame.executeRule(4, 3);
		assertEquals(EGameScore.VENTAJA_PLAYER_ONE.getNameGame(), scoreGame);
	}
	
	@Test
	public void shouldBeExecuteRuleVentajaGameAndReturnVentajaByPlayerOnePointMoreOpponentAfterThreePontsTestTwo() {
		String scoreGame = ventajaGame.executeRule(78, 77);
		assertEquals(EGameScore.VENTAJA_PLAYER_ONE.getNameGame(), scoreGame);
	}
	
	@Test
	public void shouldBeExecuteRuleVentajaGameAndReturnVentajaByPlayerTwoPointMoreOpponentAfterThreePonts() {
		String scoreGame = ventajaGame.executeRule(3, 4);
		assertEquals(EGameScore.VENTAJA_PLAYER_TWO.getNameGame(), scoreGame);
	}

	@Test
	public void shouldBeExecuteRuleVentajaGameAndReturnVentajaByPlayerTwoPointMoreOpponentAfterThreePontsTestTwo() {
		String scoreGame = ventajaGame.executeRule(80, 81);
		assertEquals(EGameScore.VENTAJA_PLAYER_TWO.getNameGame(), scoreGame);
	}

	
	@Test
	public void shouldBeExecuteRuleVentajaGameAndContinueByInvalidScore() {
		String scoreGame = ventajaGame.executeRule(2, 3);
		assertNull(scoreGame);
	}
	
	@Test
	public void shouldBeExecuteRuleVentajaGameAndContinueByInvalidScoreTestTwo() {
		String scoreGame = ventajaGame.executeRule(3, 3);
		assertNull(scoreGame);
	}
	
	@Test
	public void shouldBeExecuteRuleVentajaGameAndContinueByInvalidScoreTestThree() {
		String scoreGame = ventajaGame.executeRule(0, 1);
		assertNull(scoreGame);
	}
	
}
