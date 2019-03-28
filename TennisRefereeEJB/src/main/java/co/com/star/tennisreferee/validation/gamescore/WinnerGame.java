package co.com.star.tennisreferee.validation.gamescore;

import co.com.star.tennisreferee.enums.EGameScore;

public class WinnerGame implements IGameScore {

	@Override
	public String executeRule(int scorePlayerOne, int scorePlayerTwo) {
		
		String gameScore = null;
		
		if (scorePlayerOne >= 4 && (scorePlayerOne - scorePlayerTwo >= 2)) {
			gameScore = EGameScore.WINNER_GAME_PLAYER_ONE.getNameGame();
		} else if (scorePlayerTwo >= 4 && (scorePlayerTwo - scorePlayerOne >= 2)) {
			gameScore = EGameScore.WINNER_GAME_PLAYER_TWO.getNameGame();
		}
		
		return gameScore;
		
	}

}
