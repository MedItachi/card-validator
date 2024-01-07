package org.java.mql.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.java.mql.models.Card;
import org.java.mql.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Path("/card")

public class CardResources {
	@Autowired
	private CardService cardService;

	@GET
	@Produces("application/json")
	public Response getCards() {
		return Response.ok(cardService.getAll()).build();

	}

	@GET
	@Path("/test")
	public Response test() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
     return Response.ok(authentication.getName()).build();
	}

	@POST
	@Path("/save")
	@Consumes("application/json")
	@Produces("application/json")
	public Response save(Card card) {

//		if(HelperCard.validateCardNumber(card.getCardNumber())) {
//            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Card Number").build();
//			
//		}
		if (cardService.isCardNumberExists(card.getCardNumber())) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Card number already exists").build();
		}

		cardService.saveCard(card);
		return Response.status(Response.Status.OK).entity("Card saved successfully").build();
	}

}
