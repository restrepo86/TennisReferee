package co.com.star.tennisreferee.validation.gamescore;

import co.com.star.tennisreferee.enums.EGameScore;

public class DeuceGame implements IGameScore {

	@Override
	public String executeRule(int scorePlayerOne, int scorePlayerTwo) {
		
		String gameScore = null;
		
		if (scorePlayerOne >= 3 && scorePlayerTwo >=3 && scorePlayerOne == scorePlayerTwo) {
			gameScore = EGameScore.DEUCE.getNameGame();
		}
		
		return gameScore;
		
	}

}
