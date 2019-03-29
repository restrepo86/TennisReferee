package co.com.star.tennisreferee.rest.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger;

import co.com.star.tennisreferee.exception.TennisRefereeValidationException;

@Provider
public class TennisRefereeValidationExceptionMapper implements ExceptionMapper<TennisRefereeValidationException> {

	public static final String HEADER_NAME = "badRequestMessage";
	private static final Logger LOG = Logger.getLogger(TennisRefereeValidationExceptionMapper.class);
	    
	@Override
	public Response toResponse(TennisRefereeValidationException tennisRefereeValidationException) {
         
		LOG.info(tennisRefereeValidationException);

        if (tennisRefereeValidationException instanceof TennisRefereeValidationException) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .header(HEADER_NAME, tennisRefereeValidationException.getMessage())
                    .build();
        }

        return Response.serverError()
                .header(HEADER_NAME, tennisRefereeValidationException.getMessage())
                .build();

	}

}
