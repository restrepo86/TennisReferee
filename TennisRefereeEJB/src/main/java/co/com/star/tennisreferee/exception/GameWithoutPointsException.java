package co.com.star.tennisreferee.exception;

public class GameWithoutPointsException extends TennisRefereeValidationException {


	private static final long serialVersionUID = 1L;

	public GameWithoutPointsException(String message) {
		super(message);
	}

}
