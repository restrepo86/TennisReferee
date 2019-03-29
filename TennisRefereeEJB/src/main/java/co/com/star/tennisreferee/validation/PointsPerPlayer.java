package co.com.star.tennisreferee.validation;

import co.com.star.tennisreferee.dto.ValidateDTO;
import co.com.star.tennisreferee.exception.SinglePlayerPointsException;

public class PointsPerPlayer implements IValidation {

	@Override
	public void validate(ValidateDTO validateDTO) throws SinglePlayerPointsException {
		if (validateDTO.isPlayerOnePoint() && validateDTO.isPlayerTwoPoint()) {
			throw new SinglePlayerPointsException("No es posible que ambos jugadores ganen punto en el mismo momento");
		}
	}
	
}
