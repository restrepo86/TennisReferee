package co.com.star.tennisreferee.validation;

import co.com.star.tennisreferee.dto.ValidateDTO;
import co.com.star.tennisreferee.exception.TennisRefereeValidationException;

public interface IValidation {

	void validate(ValidateDTO validateDTO) throws TennisRefereeValidationException;
	
}
