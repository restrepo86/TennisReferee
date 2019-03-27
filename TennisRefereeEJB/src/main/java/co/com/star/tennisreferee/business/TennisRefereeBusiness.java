package co.com.star.tennisreferee.business;

import co.com.star.tennisreferee.dto.ScoreRequestDTO;
import co.com.star.tennisreferee.dto.ScoreResponseDTO;

public class TennisRefereeBusiness {

	public ScoreResponseDTO calculateScore(ScoreRequestDTO scoreRequestDTO) {
		
		ScoreResponseDTO scoreResponseDTO = new ScoreResponseDTO();
		scoreResponseDTO.setScorePlayerOne(scoreRequestDTO.isPlayerOnePoint() ? scoreRequestDTO.getScorePlayerOne() + 1 : scoreRequestDTO.getScorePlayerOne());
		scoreRequestDTO.setScorePlayerTwo(scoreRequestDTO.isPlayerTwoPoint() ? scoreRequestDTO.getScorePlayerTwo() + 1 : scoreRequestDTO.getScorePlayerTwo());
		
		return scoreResponseDTO;
		
	}

}
