package co.com.star.tennisreferee.validation;

import co.com.star.tennisreferee.dto.ScoreRequestDTO;
import co.com.star.tennisreferee.exception.GameWithoutPointsException;

public class GameHavePoints implements IValidation {

	@Override
	public void validate(ScoreRequestDTO scoreRequestDTO) throws GameWithoutPointsException {
		if (!scoreRequestDTO.isPlayerOnePoint() && !scoreRequestDTO.isPlayerTwoPoint()) {
			throw new GameWithoutPointsException("No es posible ingresar un juego en el que ningun jugador gane puntos");
		}
	}
	
}
