package co.com.star.tennisreferee.exception;

public class TennisRefereeException extends Exception {


	private static final long serialVersionUID = 1L;

	public TennisRefereeException(String message) {
        super(message);
    }

    public TennisRefereeException(String message, Throwable cause) {
        super(message, cause);
    }
}
