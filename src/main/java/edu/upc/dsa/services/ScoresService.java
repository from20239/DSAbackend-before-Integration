package edu.upc.dsa.services;

import edu.upc.dsa.Manager;
import edu.upc.dsa.dao.DAO;
import edu.upc.dsa.models.ScoreData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/scores", description = "Service to manage user scores")
@Path("/scores")
public class ScoresService {

    Manager manager = DAO.getInstance();
    final static Logger logger = Logger.getLogger(ScoresService.class);

    @POST
    @Path("/{userID}")
    @ApiOperation(value = "Submit score for a user", notes = "Receives and stores the score and level for a given user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response submitScore(@PathParam("userID") String userID, ScoreData scoreData) {
        try {
            manager.addScore(userID, scoreData);
            return Response.ok().build();
        } catch (Exception e) {
            logger.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}