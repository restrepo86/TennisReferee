package co.com.star.tennisreferee.validation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.star.tennisreferee.dto.ScoreRequestDTO;
import co.com.star.tennisreferee.exception.SinglePlayerPointsException;

@RunWith(MockitoJUnitRunner.class)
public class PointsPerPlayerTest {
	
	@InjectMocks
	private PointsPerPlayer pointsPerPlayer;
	
	private ScoreRequestDTO scoreRequestDTO;

	@Before
	public void setUp() {
		scoreRequestDTO = new ScoreRequestDTO();
	}
	
	@Test(expected = SinglePlayerPointsException.class)
	public void shouldBeThrowExceptionBySinglePlayerPoints() throws SinglePlayerPointsException {
		scoreRequestDTO.setPlayerOnePoint(true);
		scoreRequestDTO.setPlayerTwoPoint(true);
		pointsPerPlayer.validate(scoreRequestDTO);
	}
	
	@Test
	public void shouldBeContinueByValidationOk() throws SinglePlayerPointsException {
		scoreRequestDTO.setPlayerOnePoint(false);
		scoreRequestDTO.setPlayerTwoPoint(true);
		pointsPerPlayer.validate(scoreRequestDTO);
	}
	
	@Test
	public void shouldBeContinueByValidationOkTestTwo() throws SinglePlayerPointsException {
		scoreRequestDTO.setPlayerOnePoint(true);
		scoreRequestDTO.setPlayerTwoPoint(false);
		pointsPerPlayer.validate(scoreRequestDTO);
	}
	
}
