package co.com.star.tennisreferee.rest.services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.star.tennisreferee.business.TennisRefereeBusiness;
import co.com.star.tennisreferee.dto.ScoreRequestDTO;
import co.com.star.tennisreferee.dto.ScoreTennis;

@Path("score")
public class TennisRefereeServices {

	
	@Inject
	private TennisRefereeBusiness tennisRefereeBusiness;

	@Path("/")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ScoreTennis calculateScore(ScoreRequestDTO scoreRequestDTO) {
		return tennisRefereeBusiness.calculateScore(scoreRequestDTO);
	}

}
