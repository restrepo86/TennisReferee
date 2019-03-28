package co.com.star.tennisreferee.business;

import co.com.star.tennisreferee.dto.ScoreRequestDTO;
import co.com.star.tennisreferee.dto.ScoreTennis;

public class TennisRefereeBusiness {

	public ScoreTennis calculateScore(ScoreRequestDTO scoreRequestDTO) {
		
		ScoreTennis scoreTennis = ScoreTennis.obtenerInstancia();
		
		scoreTennis.setScorePlayerOne(scoreRequestDTO.isPlayerOnePoint() ? scoreTennis.getScorePlayerOne() + 1 : scoreTennis.getScorePlayerOne());
		scoreTennis.setScorePlayerTwo(scoreRequestDTO.isPlayerTwoPoint() ? scoreTennis.getScorePlayerTwo() + 1 : scoreTennis.getScorePlayerTwo());
		
		return scoreTennis;
		
	}

	

}
