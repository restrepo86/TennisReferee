package co.com.star.tennisreferee.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.star.tennisreferee.dto.ScoreRequestDTO;
import co.com.star.tennisreferee.dto.ScoreTennis;
import co.com.star.tennisreferee.exception.TennisRefereeValidationException;
import co.com.star.tennisreferee.validation.Validation;

@RunWith(MockitoJUnitRunner.class)
public class TennisRefereeBusinessTest {
	
	@InjectMocks
	private TennisRefereeBusiness tennisRefereeBusiness;
	
	@Mock
	private Validation validation;
	
	private ScoreRequestDTO scoreRequestDTO;
	
	@Before
	public void setUp() {
		
		scoreRequestDTO = new ScoreRequestDTO();
		
	}
	
	@Test
	public void shouldBeCalculateScore() throws TennisRefereeValidationException {
		
		scoreRequestDTO.setPlayerOnePoint(true);
		scoreRequestDTO.setPlayerTwoPoint(false);
		ScoreTennis scoreResponseDTO = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertEquals(1, scoreResponseDTO.getScorePlayerOne());
		assertEquals(0, scoreResponseDTO.getScorePlayerTwo()); 
		
	}
	
	@Test 
	public void shouldBeThrowExcepcionByPointsInBothPlayers() throws TennisRefereeValidationException {
		
		ScoreTennis.reiniciarJuego();
		scoreRequestDTO.setPlayerOnePoint(true);
		scoreRequestDTO.setPlayerTwoPoint(true);
		tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		
	}
	
	@Test
	public void shouldBeCalculateScoreAndAssertNotEqualsRestartingGame() throws TennisRefereeValidationException {
		
		ScoreTennis.reiniciarJuego();
		scoreRequestDTO.setPlayerOnePoint(true);
		scoreRequestDTO.setPlayerTwoPoint(false);
		ScoreTennis scoreResponseDTO = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertNotEquals(2, scoreResponseDTO.getScorePlayerOne());
		assertNotEquals(1, scoreResponseDTO.getScorePlayerTwo()); 
		
	}
	
	@Test
	public void shouldBeCalculateScoreAndAssertNotEqualsRestartingGameTestTwo() throws TennisRefereeValidationException {
		
		ScoreTennis.reiniciarJuego();
		scoreRequestDTO.setPlayerOnePoint(true);
		scoreRequestDTO.setPlayerTwoPoint(false);
		ScoreTennis scoreResponseDTO = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertNotEquals(0, scoreResponseDTO.getScorePlayerOne());
		assertNotEquals(1, scoreResponseDTO.getScorePlayerTwo()); 
		
	}
	
	@Test
	public void shouldBeCalculateScoreAndReturnEqualsScorePlayerTwoByNotPointsRestartingGame() throws TennisRefereeValidationException {
		
		ScoreTennis.reiniciarJuego();
		scoreRequestDTO.setPlayerOnePoint(true);
		scoreRequestDTO.setPlayerTwoPoint(false);
		ScoreTennis scoreResponseDTO = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertEquals(0, scoreResponseDTO.getScorePlayerTwo()); 
		
	}
	
	@Test
	public void shouldBeCalculateScoreWithTennisAccumulatedScoreRestartingGame() throws TennisRefereeValidationException {
		
		ScoreTennis.reiniciarJuego();
		scoreRequestDTO.setPlayerOnePoint(true);
		scoreRequestDTO.setPlayerTwoPoint(false);
		ScoreTennis scoreTennisSetOne = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertEquals(1, scoreTennisSetOne.getScorePlayerOne()); 
		assertEquals(0, scoreTennisSetOne.getScorePlayerTwo()); 
		scoreRequestDTO.setPlayerOnePoint(true);
		scoreRequestDTO.setPlayerTwoPoint(false);
		ScoreTennis scoreTennisSetTwo = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertEquals(2, scoreTennisSetTwo.getScorePlayerOne()); 
		assertEquals(0, scoreTennisSetTwo.getScorePlayerTwo()); 
		
	}
	
	@Test
	public void shouldBeCalculateScoreWithTennisAccumulatedScoreRestartingGameTestTwo() throws TennisRefereeValidationException {
		
		ScoreTennis.reiniciarJuego();
		scoreRequestDTO.setPlayerOnePoint(false);
		scoreRequestDTO.setPlayerTwoPoint(true);
		ScoreTennis scoreTennisSetOne = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertEquals(0, scoreTennisSetOne.getScorePlayerOne()); 
		assertEquals(1, scoreTennisSetOne.getScorePlayerTwo()); 
		scoreRequestDTO.setPlayerOnePoint(true);
		scoreRequestDTO.setPlayerTwoPoint(false);
		ScoreTennis scoreTennisSetTwo = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertEquals(1, scoreTennisSetTwo.getScorePlayerOne()); 
		assertEquals(1, scoreTennisSetTwo.getScorePlayerTwo()); 
		
	}
	 
	@Test 
	public void shouldBeCalculateScoreWithTennisAccumulatedScoreRestartingGameTestThree() throws TennisRefereeValidationException {
		
		ScoreTennis.reiniciarJuego();
		scoreRequestDTO.setPlayerOnePoint(false);
		scoreRequestDTO.setPlayerTwoPoint(true);
		ScoreTennis scoreTennisSetOne = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertEquals(0, scoreTennisSetOne.getScorePlayerOne()); 
		assertEquals(1, scoreTennisSetOne.getScorePlayerTwo()); 
		scoreRequestDTO.setPlayerOnePoint(false);
		scoreRequestDTO.setPlayerTwoPoint(true);
		ScoreTennis scoreTennisSetTwo = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertEquals(0, scoreTennisSetTwo.getScorePlayerOne()); 
		assertEquals(2, scoreTennisSetTwo.getScorePlayerTwo()); 
		
	}
	
}
