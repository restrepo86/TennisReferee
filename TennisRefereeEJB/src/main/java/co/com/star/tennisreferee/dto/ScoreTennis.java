package co.com.star.tennisreferee.dto;

public class ScoreTennis {

	private static ScoreTennis INSTANCIA = null;
	
	private ScoreTennis() {}
	
	private int scorePlayerOne;
	private int scorePlayerTwo;
	private String score;
	
	public static ScoreTennis obtenerInstancia() {
		if (INSTANCIA == null) crearInstancia();
		return INSTANCIA;
	}

	public static void reiniciarJuego() {
		crearInstancia();
	}
	
	private synchronized static void crearInstancia() {
			INSTANCIA = new ScoreTennis();
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

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

}
