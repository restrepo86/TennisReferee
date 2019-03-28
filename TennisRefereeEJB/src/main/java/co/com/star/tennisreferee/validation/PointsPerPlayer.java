package co.com.star.tennisreferee.validation;

import co.com.star.tennisreferee.dto.ScoreRequestDTO;
import co.com.star.tennisreferee.exception.SinglePlayerPointsException;

public class PointsPerPlayer implements IValidation {

	@Override
	public void validate(ScoreRequestDTO scoreRequestDTO) throws SinglePlayerPointsException {
		if (scoreRequestDTO.isPlayerOnePoint() && scoreRequestDTO.isPlayerTwoPoint()) {
			throw new SinglePlayerPointsException("No es posible que ambos jugadores ganen punto en el mismo momento");
		}
	}
	
}
