package co.com.star.tennisreferee.enums;

public enum EGameScore {

	WINNER_GAME_PLAYER_ONE("WINNER GAME PLAYER ONE"),
	WINNER_GAME_PLAYER_TWO("WINNER GAME PLAYER TWO");
	
	private final String nameGame;
	
	private EGameScore(String nameGame) {
		this.nameGame = nameGame;
	}

	public String getNameGame() {
		return nameGame;
	}
}
