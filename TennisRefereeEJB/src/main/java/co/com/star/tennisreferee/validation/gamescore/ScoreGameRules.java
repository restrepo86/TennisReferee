package co.com.star.tennisreferee.validation.gamescore;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

public class ScoreGameRules {

	
	@Inject
	private WinnerGame winnerGame;
	
	@Inject
	private DeuceGame deuceGame;

	@Inject
	private VentajeGame ventajaGame;
	 

	public Optional<String> getScoreGame(int scorePlayerOne, int scorePlayerTwo) {

		List<IScoreGame> rulesScoreGame = new ArrayList<>();
		
		rulesScoreGame.add(winnerGame);
		rulesScoreGame.add(deuceGame);
		rulesScoreGame.add(ventajaGame);
		
		
		return rulesScoreGame
				.stream()
				.map(rule -> rule.executeRule(scorePlayerOne, scorePlayerTwo))
				.filter(scoreGame -> scoreGame != null).findFirst();
		
	}
	
}
