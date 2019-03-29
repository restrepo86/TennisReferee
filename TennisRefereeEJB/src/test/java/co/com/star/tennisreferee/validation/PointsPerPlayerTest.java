package co.com.star.tennisreferee.validation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.star.tennisreferee.dto.ValidateDTO;
import co.com.star.tennisreferee.exception.SinglePlayerPointsException;

@RunWith(MockitoJUnitRunner.class)
public class PointsPerPlayerTest {
	
	@InjectMocks
	private PointsPerPlayer pointsPerPlayer;
	
	private ValidateDTO validateDTO;

	@Before
	public void setUp() {
		validateDTO = new ValidateDTO();
	}
	
	@Test(expected = SinglePlayerPointsException.class)
	public void shouldBeThrowExceptionBySinglePlayerPoints() throws SinglePlayerPointsException {
		validateDTO.setPlayerOnePoint(true);
		validateDTO.setPlayerTwoPoint(true);
		pointsPerPlayer.validate(validateDTO);
	}
	
	@Test
	public void shouldBeContinueByValidationOk() throws SinglePlayerPointsException {
		validateDTO.setPlayerOnePoint(false);
		validateDTO.setPlayerTwoPoint(true);
		pointsPerPlayer.validate(validateDTO);
	}
	
	@Test
	public void shouldBeContinueByValidationOkTestTwo() throws SinglePlayerPointsException {
		validateDTO.setPlayerOnePoint(true);
		validateDTO.setPlayerTwoPoint(false);
		pointsPerPlayer.validate(validateDTO);
	}
	
}
