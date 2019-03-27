package co.com.star.tennisreferee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreRequestDTO {

	private int scorePlayerOne;
	private int scorePlayerTwo;

	private boolean isPlayerOnePoint;
	private boolean isPlayerTwoPoint;
	
}
