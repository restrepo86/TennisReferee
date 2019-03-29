package co.com.star.tennisreferee.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.star.tennisreferee.dto.ScoreRequestDTO;
import co.com.star.tennisreferee.dto.ScoreTennis;
import co.com.star.tennisreferee.enums.EScoreGame;
import co.com.star.tennisreferee.exception.TennisRefereeValidationException;
import co.com.star.tennisreferee.validation.Validation;
import co.com.star.tennisreferee.validation.gamescore.ScoreGameRules;

@RunWith(MockitoJUnitRunner.class)
public class TennisRefereeBusinessTest {
	
	@InjectMocks
	private TennisRefereeBusiness tennisRefereeBusiness;
	
	@Mock
	private Validation validation;
	
	@Mock
	private ScoreGameRules scoreGameRules;

	private ScoreRequestDTO scoreRequestDTO;

	
	@Before
	public void setUp() {
		 
		scoreRequestDTO = new ScoreRequestDTO();
		
	}
	
	@Test
	public void shouldBeCalculateScore() throws TennisRefereeValidationException {
		 
		scoreRequestDTO.setPlayerOnePoint(true);
		scoreRequestDTO.setPlayerTwoPoint(false);
		when(scoreGameRules.getScoreGame(anyInt(), anyInt())).thenReturn(Optional.empty());
		ScoreTennis scoreResponseDTO = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertEquals(1, scoreResponseDTO.getScorePlayerOne());
		assertEquals(0, scoreResponseDTO.getScorePlayerTwo()); 
		verify(validation).validateScore(scoreRequestDTO);
		verify(scoreGameRules).getScoreGame(anyInt(), anyInt());
		
	}
	
	@Test 
	public void shouldBeThrowExcepcionByPointsInBothPlayers() throws TennisRefereeValidationException {
		
		ScoreTennis.restartGame();
		scoreRequestDTO.setPlayerOnePoint(true);
		scoreRequestDTO.setPlayerTwoPoint(true);
		when(scoreGameRules.getScoreGame(anyInt(), anyInt())).thenReturn(Optional.empty());
		tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		verify(validation).validateScore(scoreRequestDTO);
		
	}
	
	@Test
	public void shouldBeCalculateScoreAndAssertNotEqualsRestartingGame() throws TennisRefereeValidationException {
		
		ScoreTennis.restartGame();
		scoreRequestDTO.setPlayerOnePoint(true);
		scoreRequestDTO.setPlayerTwoPoint(false);
		when(scoreGameRules.getScoreGame(anyInt(), anyInt())).thenReturn(Optional.of(EScoreGame.DEUCE.getNameGame()));
		ScoreTennis scoreResponseDTO = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertNotEquals(2, scoreResponseDTO.getScorePlayerOne());
		assertNotEquals(1, scoreResponseDTO.getScorePlayerTwo()); 
		verify(validation).validateScore(scoreRequestDTO);
		
	}
	
	@Test
	public void shouldBeCalculateScoreAndAssertNotEqualsRestartingGameTestTwo() throws TennisRefereeValidationException {
		
		ScoreTennis.restartGame();
		scoreRequestDTO.setPlayerOnePoint(true);
		scoreRequestDTO.setPlayerTwoPoint(false);
		when(scoreGameRules.getScoreGame(anyInt(), anyInt())).thenReturn(Optional.empty());
		ScoreTennis scoreResponseDTO = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertNotEquals(0, scoreResponseDTO.getScorePlayerOne());
		assertNotEquals(1, scoreResponseDTO.getScorePlayerTwo()); 
		verify(validation).validateScore(scoreRequestDTO);
		
	}
	
	@Test
	public void shouldBeCalculateScoreAndReturnEqualsScorePlayerTwoByNotPointsRestartingGame() throws TennisRefereeValidationException {
		
		ScoreTennis.restartGame();
		scoreRequestDTO.setPlayerOnePoint(true);
		scoreRequestDTO.setPlayerTwoPoint(false);
		when(scoreGameRules.getScoreGame(anyInt(), anyInt())).thenReturn(Optional.empty());
		ScoreTennis scoreResponseDTO = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertEquals(0, scoreResponseDTO.getScorePlayerTwo()); 
		verify(validation).validateScore(scoreRequestDTO);
		
	}
	
	@Test
	public void shouldBeCalculateScoreWithTennisAccumulatedScoreRestartingGame() throws TennisRefereeValidationException {
		
		ScoreTennis.restartGame();
		scoreRequestDTO.setPlayerOnePoint(true);
		scoreRequestDTO.setPlayerTwoPoint(false);
		when(scoreGameRules.getScoreGame(anyInt(), anyInt())).thenReturn(Optional.empty());
		ScoreTennis scoreTennisSetOne = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertEquals(1, scoreTennisSetOne.getScorePlayerOne()); 
		assertEquals(0, scoreTennisSetOne.getScorePlayerTwo()); 
		scoreRequestDTO.setPlayerOnePoint(true);
		scoreRequestDTO.setPlayerTwoPoint(false);
		ScoreTennis scoreTennisSetTwo = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertEquals(2, scoreTennisSetTwo.getScorePlayerOne()); 
		assertEquals(0, scoreTennisSetTwo.getScorePlayerTwo()); 
		verify(validation, times(2)).validateScore(scoreRequestDTO);
		
	}
	
	@Test
	public void shouldBeCalculateScoreWithTennisAccumulatedScoreRestartingGameTestTwo() throws TennisRefereeValidationException {
		
		ScoreTennis.restartGame();
		scoreRequestDTO.setPlayerOnePoint(false);
		scoreRequestDTO.setPlayerTwoPoint(true);
		when(scoreGameRules.getScoreGame(anyInt(), anyInt())).thenReturn(Optional.empty());
		ScoreTennis scoreTennisSetOne = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertEquals(0, scoreTennisSetOne.getScorePlayerOne()); 
		assertEquals(1, scoreTennisSetOne.getScorePlayerTwo()); 
		scoreRequestDTO.setPlayerOnePoint(true);
		scoreRequestDTO.setPlayerTwoPoint(false);
		ScoreTennis scoreTennisSetTwo = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertEquals(1, scoreTennisSetTwo.getScorePlayerOne()); 
		assertEquals(1, scoreTennisSetTwo.getScorePlayerTwo()); 
		verify(validation, times(2)).validateScore(scoreRequestDTO); 
		
	}
	 
	@Test 
	public void shouldBeCalculateScoreWithTennisAccumulatedScoreRestartingGameTestThree() throws TennisRefereeValidationException {
		
		ScoreTennis.restartGame();
		scoreRequestDTO.setPlayerOnePoint(false);
		scoreRequestDTO.setPlayerTwoPoint(true);
		when(scoreGameRules.getScoreGame(anyInt(), anyInt())).thenReturn(Optional.empty());
		ScoreTennis scoreTennisSetOne = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertEquals(0, scoreTennisSetOne.getScorePlayerOne()); 
		assertEquals(1, scoreTennisSetOne.getScorePlayerTwo()); 
		scoreRequestDTO.setPlayerOnePoint(false);
		scoreRequestDTO.setPlayerTwoPoint(true);
		ScoreTennis scoreTennisSetTwo = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertEquals(0, scoreTennisSetTwo.getScorePlayerOne()); 
		assertEquals(2, scoreTennisSetTwo.getScorePlayerTwo()); 
		verify(validation, times(2)).validateScore(scoreRequestDTO);
		 
	}
	
}
