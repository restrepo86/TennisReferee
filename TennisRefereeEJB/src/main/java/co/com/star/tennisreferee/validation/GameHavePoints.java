package co.com.star.tennisreferee.validation;

import co.com.star.tennisreferee.dto.ValidateDTO;
import co.com.star.tennisreferee.exception.GameWithoutPointsException;

public class GameHavePoints implements IValidation {

	@Override
	public void validate(ValidateDTO validateDTO) throws GameWithoutPointsException {
		if (!validateDTO.isPlayerOnePoint() && !validateDTO.isPlayerTwoPoint()) {
			throw new GameWithoutPointsException("No es posible ingresar un juego en el que ningun jugador gane puntos");
		}
	}
	
}
