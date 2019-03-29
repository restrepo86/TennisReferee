package co.com.star.tennisreferee.validation.gamescore;

import co.com.star.tennisreferee.enums.EScoreGame;

public class DeuceGame implements IScoreGame {

	@Override
	public String executeRule(int scorePlayerOne, int scorePlayerTwo) {
		
		String gameScore = null;
		
		if (scorePlayerOne >= 3 && scorePlayerTwo >=3 && scorePlayerOne == scorePlayerTwo) {
			gameScore = EScoreGame.DEUCE.getNameGame();
		}
		
		return gameScore;
		
	}

}
