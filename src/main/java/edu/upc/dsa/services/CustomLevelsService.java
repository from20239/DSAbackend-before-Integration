package edu.upc.dsa.services;

import edu.upc.dsa.Manager;
import edu.upc.dsa.dao.DAO;
import edu.upc.dsa.models.CustomLevel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/levels", description = "Service to manage user custom levels")
@Path("/levels")
public class CustomLevelsService {

    Manager manager = DAO.getInstance();
    final static Logger logger = Logger.getLogger(CustomLevelsService.class);

    @POST
    @Path("/uploadLevel")
    @ApiOperation(value = "Submit level for a user", notes = "Receives and stores the level data for a given user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @Consumes(MediaType.APPLICATION_JSON)
    public Response submitLevel(CustomLevel customLevel) {
        //TODO verify the user is logged in
        try {
            manager.addCustomLevel(customLevel);
            return Response.ok().build();
        } catch (Exception e) {
            logger.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
