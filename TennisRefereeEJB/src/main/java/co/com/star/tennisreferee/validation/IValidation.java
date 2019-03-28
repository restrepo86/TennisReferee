package co.com.star.tennisreferee.validation;

import co.com.star.tennisreferee.dto.ScoreRequestDTO;
import co.com.star.tennisreferee.exception.TennisRefereeValidationException;

public interface IValidation {

	void validate(ScoreRequestDTO scoreRequestDTO) throws TennisRefereeValidationException;
	
}
