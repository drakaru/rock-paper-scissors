package uk.co.desecrated.resources;

import uk.co.desecrated.game.Hand;
import uk.co.desecrated.service.RpsService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;
import static javax.ws.rs.core.Response.Status.OK;

@Path("rps/")
public class RpsResource {

    @Inject
    private RpsService service;

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHello() {
        return Response.status(OK).entity("hello").build();
    }

    @GET
    @Path("/game/new/{player}")
    @Produces(MediaType.TEXT_HTML)
    public Response joinGame(@PathParam("player") String player) {
        try {
            String gameId = service.findOrCreateGame(player);
            List<String> links = new ArrayList<>();

            StringBuilder messageBody = new StringBuilder();
            messageBody.append("<html><body>");
            for (Hand hand : Hand.values()) {
                String handName = hand.getDisplayName();
                String url = "/rps/game/" + gameId + "/" + player + "/" + handName;
                messageBody.append("<p>Play <a href=\"");
                messageBody.append(url);
                messageBody.append("\">");
                messageBody.append(handName);
                messageBody.append("</a></p>");
            }
            messageBody.append("</body></html>");
            return Response.status(OK).entity(messageBody.toString()).build();
        } catch (Exception e) {
            return Response.status(INTERNAL_SERVER_ERROR).entity("Failed to create game session: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/game/{id}/{player}/{choice}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response makeChoice(
            @PathParam("id") String id,
            @PathParam("player") String player,
            @PathParam("choice") String choice) {
        try {
            service.makeChoice(id, player, choice);
            String gameStatus = service.getGameStatus(id);
            return Response.status(OK).entity(gameStatus).build();
        } catch (Exception e) {
            return Response.status(INTERNAL_SERVER_ERROR).entity("Failed to make choice: " + e.getMessage()).build();
        }
    }

}
