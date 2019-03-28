package co.com.star.tennisreferee.validation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.star.tennisreferee.dto.ScoreRequestDTO;
import co.com.star.tennisreferee.exception.GameWithoutPointsException;

@RunWith(MockitoJUnitRunner.class)
public class GameHavePointsTest {

	@InjectMocks
	private GameHavePoints gameHavePoints;
	
	private ScoreRequestDTO scoreRequestDTO;
	
	@Before
	public void setUp() {
		scoreRequestDTO = new ScoreRequestDTO();
	}
	
	@Test(expected = GameWithoutPointsException.class)
	public void shouldBeThrowExceptionByGameWithoutPoints() throws GameWithoutPointsException {
		scoreRequestDTO.setPlayerOnePoint(false);
		scoreRequestDTO.setPlayerTwoPoint(false); 
		gameHavePoints.validate(scoreRequestDTO);
	}
	
	@Test
	public void shouldBeContinueByValidationOk() throws GameWithoutPointsException {
		scoreRequestDTO.setPlayerOnePoint(true);
		scoreRequestDTO.setPlayerTwoPoint(true); 
		gameHavePoints.validate(scoreRequestDTO);
	}
	
	@Test
	public void shouldBeContinueByValidationOkTestTwo() throws GameWithoutPointsException {
		scoreRequestDTO.setPlayerOnePoint(false);
		scoreRequestDTO.setPlayerTwoPoint(true); 
		gameHavePoints.validate(scoreRequestDTO);
	}
	
	@Test
	public void shouldBeContinueByValidationOkTestThree() throws GameWithoutPointsException {
		scoreRequestDTO.setPlayerOnePoint(true);
		scoreRequestDTO.setPlayerTwoPoint(false); 
		gameHavePoints.validate(scoreRequestDTO);
	}
	
}
