package edu.upc.dsa.services;

import edu.upc.dsa.Manager;
import edu.upc.dsa.dao.DAO;
import edu.upc.dsa.exceptions.UserNotFoundException;
import edu.upc.dsa.models.CustomLevel;
import edu.upc.dsa.models.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Api(value = "/levels", description = "Service to manage levels")
@Path("/levels")
public class ListLevelsCreatedService {

    Manager manager = DAO.getInstance();

    @GET
    @Path("/user/{username}")
    @ApiOperation(value = "Get levels by username", notes = "Retrieves all levels created by a user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLevelsByUsername(@PathParam("username") String username) {
        try {
            User user = manager.getUser(username);
            List<CustomLevel> levels = manager.getCustomLevelsByUserId(user.getId());
            GenericEntity<List<CustomLevel>> entity = new GenericEntity<>(levels) {};
            return Response.ok(entity).build();
        } catch (SQLException | UserNotFoundException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
