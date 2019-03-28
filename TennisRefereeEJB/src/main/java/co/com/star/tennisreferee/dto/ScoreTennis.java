package co.com.star.tennisreferee.dto;

public class ScoreTennis {

	private static ScoreTennis INSTANCE = null;
	
	private ScoreTennis() {}
	
	private int scorePlayerOne;
	private int scorePlayerTwo;
	private String scorePlayerOneDescription;
	private String scorePlayerTwoDescription;
	private String scoreGame;
	
	public static ScoreTennis getInstance() {
		if (INSTANCE == null) buildInstance();
		return INSTANCE;
	}

	private synchronized static void buildInstance() {
		INSTANCE = new ScoreTennis();
	}

	public static void restartGame() {
		buildInstance();
	}

	public int getScorePlayerOne() {
		return scorePlayerOne;
	}

	public void setScorePlayerOne(int scorePlayerOne) {
		this.scorePlayerOne = scorePlayerOne;
	}

	public int getScorePlayerTwo() {
		return scorePlayerTwo;
	}

	public void setScorePlayerTwo(int scorePlayerTwo) {
		this.scorePlayerTwo = scorePlayerTwo;
	}

	public String getScorePlayerOneDescription() {
		return scorePlayerOneDescription;
	}

	public void setScorePlayerOneDescription(String scorePlayerOneDescription) {
		this.scorePlayerOneDescription = scorePlayerOneDescription;
	}

	public String getScorePlayerTwoDescription() {
		return scorePlayerTwoDescription;
	}

	public void setScorePlayerTwoDescription(String scorePlayerTwoDescription) {
		this.scorePlayerTwoDescription = scorePlayerTwoDescription;
	}

	public String getScoreGame() {
		return scoreGame;
	}

	public void setScoreGame(String scoreGame) {
		this.scoreGame = scoreGame;
	}


}
