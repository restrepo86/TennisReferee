package co.com.star.tennisreferee.validation.gamescore;

import co.com.star.tennisreferee.enums.EGameScore;

public class VentajeGame implements IGameScore {

	@Override
	public String executeRule(int scorePlayerOne, int scorePlayerTwo) {
		
		String scoreGame = null;
		
		if (scorePlayerOne >= 3 && scorePlayerTwo >= 3) {
			scoreGame = getPlayerWithAdvantage(scorePlayerOne, scorePlayerTwo);
		}
		
		return scoreGame;
		
	}

	private String getPlayerWithAdvantage(int scorePlayerOne, int scorePlayerTwo) {
		
		String scoreGame = null;
		
		if (scorePlayerOne - scorePlayerTwo == 1) {
			scoreGame = EGameScore.VENTAJA_PLAYER_ONE.getNameGame();
		} else if (scorePlayerTwo - scorePlayerOne == 1) {
			scoreGame = EGameScore.VENTAJA_PLAYER_TWO.getNameGame();
		}
		
		return scoreGame;
		
	}

	
}
