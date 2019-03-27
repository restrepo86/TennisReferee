package co.com.star.tennisreferee.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.star.tennisreferee.dto.ScoreRequestDTO;
import co.com.star.tennisreferee.dto.ScoreResponseDTO;

@RunWith(MockitoJUnitRunner.class)
public class TennisRefereeBusinessTest {
	
	@InjectMocks
	private TennisRefereeBusiness tennisRefereeBusiness;
	
	private ScoreRequestDTO scoreRequestDTO;
	
	@Before
	public void setUp() {
		
		scoreRequestDTO = new ScoreRequestDTO();
		scoreRequestDTO.setScorePlayerOne(1);
		scoreRequestDTO.setScorePlayerTwo(0);
		
	}
	
	@Test
	public void shouldBeCalculateScore() {
		
		scoreRequestDTO.setScorePlayerOne(1);
		scoreRequestDTO.setScorePlayerTwo(0);
		ScoreResponseDTO scoreResponseDTO = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertEquals(1, scoreResponseDTO.getScorePlayerOne());
		assertEquals(0, scoreResponseDTO.getScorePlayerTwo()); 
		
	}
	
	@Test
	public void shouldBeCalculateScoreAndAssertNotEquals() {
		
		scoreRequestDTO.setScorePlayerOne(1);
		scoreRequestDTO.setScorePlayerTwo(0);
		ScoreResponseDTO scoreResponseDTO = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertNotEquals(2, scoreResponseDTO.getScorePlayerOne());
		assertNotEquals(1, scoreResponseDTO.getScorePlayerTwo()); 
		
	}
	
	@Test
	public void shouldBeCalculateScoreAndAssertNotEqualsTestTwo() {
		
		scoreRequestDTO.setScorePlayerOne(1);
		scoreRequestDTO.setScorePlayerTwo(0);
		ScoreResponseDTO scoreResponseDTO = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertNotEquals(0, scoreResponseDTO.getScorePlayerOne());
		assertNotEquals(1, scoreResponseDTO.getScorePlayerTwo()); 
		
	}
	
	@Test
	public void shouldBeCalculateScoreAndReturnEqualsScorePlayerTwoByNotPoints() {
		
		scoreRequestDTO.setScorePlayerOne(1);
		scoreRequestDTO.setScorePlayerTwo(0);
		scoreRequestDTO.setPlayerOnePoint(true);
		scoreRequestDTO.setPlayerOnePoint(false);
		ScoreResponseDTO scoreResponseDTO = tennisRefereeBusiness.calculateScore(scoreRequestDTO);
		assertEquals(0, scoreResponseDTO.getScorePlayerTwo()); 
		
	}
	
}
