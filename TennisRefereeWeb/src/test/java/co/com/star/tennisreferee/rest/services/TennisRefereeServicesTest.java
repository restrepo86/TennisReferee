package co.com.star.tennisreferee.rest.services;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.star.tennisreferee.business.TennisRefereeBusiness;
import co.com.star.tennisreferee.dto.ScoreRequestDTO;
import co.com.star.tennisreferee.exception.TennisRefereeValidationException;

@RunWith(MockitoJUnitRunner.class)
public class TennisRefereeServicesTest {

	
	@InjectMocks
	private TennisRefereeServices tennisRefereeServices;
	
	@Mock
	private TennisRefereeBusiness tennisRefereeBusiness;
 
	
	private ScoreRequestDTO scoreRequestDTO;
	
	@Test 
	public void shouldBeCalculateTheScoreOfTheGame() throws TennisRefereeValidationException {
		tennisRefereeServices.calculateScore(scoreRequestDTO);
		verify(tennisRefereeBusiness).calculateScore(scoreRequestDTO);
	}
	
}
