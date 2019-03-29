package co.com.star.tennisreferee.validation.gamescore;

import co.com.star.tennisreferee.enums.EScoreGame;

public class VentajeGame implements IScoreGame {

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
			scoreGame = EScoreGame.VENTAJA_PLAYER_ONE.getNameGame();
		} else if (scorePlayerTwo - scorePlayerOne == 1) {
			scoreGame = EScoreGame.VENTAJA_PLAYER_TWO.getNameGame();
		}
		
		return scoreGame;
		
	}

	
}
