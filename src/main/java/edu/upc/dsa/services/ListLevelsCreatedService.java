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
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Api(value = "/levels", description = "Service to manage levels")
@Path("/levels")
public class ListLevelsCreatedService {

    // Logger for logging errors and info
    private static final Logger logger = Logger.getLogger(ListLevelsCreatedService.class);

    Manager manager = DAO.getInstance();

    @GET
    @Path("/")
    @ApiOperation(value = "Get all custom levels", notes = "Retrieves all custom levels created by any user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLevels() {
        try {
            logger.info("Fetching all custom levels");
            List<CustomLevel> levels = manager.getAllCustomLevels(); // 使用新的方法获取所有 CustomLevel
            if (levels == null || levels.isEmpty()) {
                logger.warn("No custom levels found");
                return Response.status(Response.Status.NOT_FOUND).entity("No custom levels found").build();
            }
            GenericEntity<List<CustomLevel>> entity = new GenericEntity<>(levels) {};
            return Response.ok(entity).build();
        } catch (SQLException e) {
            logger.error("SQL error while fetching levels", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Database error").build();
        } catch (Exception e) {
            logger.error("Unexpected error while fetching levels", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Unexpected error").build();
        }
    }
}
