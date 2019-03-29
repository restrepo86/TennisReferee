package co.com.star.tennisreferee.validation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.star.tennisreferee.dto.ValidateDTO;
import co.com.star.tennisreferee.exception.GameWithoutPointsException;

@RunWith(MockitoJUnitRunner.class)
public class GameHavePointsTest {

	@InjectMocks
	private GameHavePoints gameHavePoints;
	
	private ValidateDTO validateDTO;
	
	@Before
	public void setUp() {
		validateDTO = new ValidateDTO();
	}
	
	@Test(expected = GameWithoutPointsException.class)
	public void shouldBeThrowExceptionByGameWithoutPoints() throws GameWithoutPointsException {
		validateDTO.setPlayerOnePoint(false);
		validateDTO.setPlayerTwoPoint(false); 
		gameHavePoints.validate(validateDTO);
	}
	
	@Test
	public void shouldBeContinueByValidationOk() throws GameWithoutPointsException {
		validateDTO.setPlayerOnePoint(true);
		validateDTO.setPlayerTwoPoint(true); 
		gameHavePoints.validate(validateDTO);
	} 
	
	@Test
	public void shouldBeContinueByValidationOkTestTwo() throws GameWithoutPointsException {
		validateDTO.setPlayerOnePoint(false);
		validateDTO.setPlayerTwoPoint(true); 
		gameHavePoints.validate(validateDTO);
	}
	
	@Test
	public void shouldBeContinueByValidationOkTestThree() throws GameWithoutPointsException {
		validateDTO.setPlayerOnePoint(true);
		validateDTO.setPlayerTwoPoint(false); 
		gameHavePoints.validate(validateDTO);
	}
	
}
