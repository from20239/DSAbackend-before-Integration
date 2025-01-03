package edu.upc.dsa.services;

import edu.upc.dsa.models.ScoreData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/scores", description = "Service to manage user scores")
@Path("/scores")
public class ScoresService {

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
            // Logic to store the score and level for the user
            System.out.println("Received score for user: " + userID); //TODO !!!!! no es pot utilitzar això
            System.out.println("Score: " + scoreData.getScore() + ", Level: " + scoreData.getLevel());

            // Assuming the score is stored successfully
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
