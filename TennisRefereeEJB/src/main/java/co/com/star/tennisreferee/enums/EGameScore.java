package co.com.star.tennisreferee.enums;

public enum EGameScore {

	WINNER_GAME_PLAYER_ONE("WINNER GAME PLAYER ONE"),
	WINNER_GAME_PLAYER_TWO("WINNER GAME PLAYER TWO"), 
	DEUCE("Deuce"), 
	VENTAJA_PLAYER_ONE("Ventaja Jugador Uno"), 
	VENTAJA_PLAYER_TWO("Ventaja Jugador Dos");
	
	private final String nameGame;
	
	private EGameScore(String nameGame) {
		this.nameGame = nameGame;
	}

	public String getNameGame() {
		return nameGame;
	}
}
