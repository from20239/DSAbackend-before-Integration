package edu.upc.dsa.services;

import edu.upc.dsa.models.CustomLevel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/levels", description = "Service to manage user levels")
@Path("/levels")
public class LevelsService {

    @POST
    @Path("/uploadLevel")
    @ApiOperation(value = "Submit level for a user", notes = "Receives and stores the level data for a given user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response submitLevel(CustomLevel customLevel) {
        try {

            System.out.println("Received level for user: " + customLevel.getUserId());
            System.out.println("Level name: " + customLevel.getLevelName());
            System.out.println("Elements: " + customLevel.getElements());


            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
