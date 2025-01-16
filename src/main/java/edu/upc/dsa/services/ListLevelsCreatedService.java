package edu.upc.dsa.services;

import edu.upc.dsa.dao.LevelsCreatedDao;
import edu.upc.dsa.dao.LevelsCreatedDao;
import edu.upc.dsa.models.CustomLevel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Api(value = "/levels", description = "Service to manage levels")
@Path("/levels")
public class ListLevelsCreatedService {

    public LevelsCreatedDao levelDao;

    @GET
    @Path("/user/{userId}")
    @ApiOperation(value = "Get levels by user ID", notes = "Retrieves all levels created by a user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLevelsByUserId(@PathParam("userId") String userId) {
        try {
            List<CustomLevel> levels = levelDao.getLevelsByUserId(userId);
            return Response.ok(levels).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
