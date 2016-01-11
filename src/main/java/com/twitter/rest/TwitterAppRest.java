package com.twitter.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import twitter4j.Status;

public interface TwitterAppRest {

	@GET
	@Path("/search/username/{username}/count/{count}/dateSince/{dateSince}/dateUntil/{dateUntil}")
	@Produces({ MediaType.APPLICATION_JSON })
	List<Status> getTweets(@PathParam("username") String user,
			@PathParam("count") int count,
			@PathParam("dateSince") String dateSince,
			@PathParam("dateUntil") String dateUntil) throws Exception;

}
