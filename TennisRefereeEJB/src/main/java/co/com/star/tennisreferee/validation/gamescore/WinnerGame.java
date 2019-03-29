package co.com.star.tennisreferee.validation.gamescore;

import co.com.star.tennisreferee.enums.EScoreGame;

public class WinnerGame implements IScoreGame {

	@Override
	public String executeRule(int scorePlayerOne, int scorePlayerTwo) {
		
		String gameScore = null;
		
		if (scorePlayerOne >= 4 && (scorePlayerOne - scorePlayerTwo >= 2)) {
			gameScore = EScoreGame.WINNER_GAME_PLAYER_ONE.getNameGame();
		} else if (scorePlayerTwo >= 4 && (scorePlayerTwo - scorePlayerOne >= 2)) {
			gameScore = EScoreGame.WINNER_GAME_PLAYER_TWO.getNameGame();
		}
		
		return gameScore;
		
	}

}
