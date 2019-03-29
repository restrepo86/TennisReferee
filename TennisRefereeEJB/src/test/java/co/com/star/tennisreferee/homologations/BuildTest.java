package co.com.star.tennisreferee.homologations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Test;

public class BuildTest {
	
	
	@Test
	public void shouldBeGetHomologationCeroLove() {
		Map<Integer, String> scoreDescription = Build.getScoreDescription();
		assertEquals("Love", scoreDescription.get(0)); 
	}
	
	@Test
	public void shouldBeGetHomologationOneQuince() {
		Map<Integer, String> scoreDescription = Build.getScoreDescription();
		assertEquals("Quince", scoreDescription.get(1)); 
	}
	
	@Test
	public void shouldBeGetHomologationTwoTreinta() {
		Map<Integer, String> scoreDescription = Build.getScoreDescription();
		assertEquals("Treinta", scoreDescription.get(2)); 
	}
	
	@Test
	public void shouldBeGetHomologationThreeCuarenta() {
		Map<Integer, String> scoreDescription = Build.getScoreDescription();
		assertEquals("Cuarenta", scoreDescription.get(3)); 
	}
	
	@Test
	public void shouldBeGetHomologation() {
		Map<Integer, String> scoreDescription = Build.getScoreDescription();
		assertNull(scoreDescription.get(9)); 
	}

}
