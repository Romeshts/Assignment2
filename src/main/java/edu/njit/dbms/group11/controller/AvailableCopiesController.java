package edu.njit.dbms.group11.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.njit.dbms.group11.service.AvailableCopiesService;
 
@Path("availableBookCopies")
public class AvailableCopiesController {

    AvailableCopiesService availableCopiesService = new AvailableCopiesService ();

    @GET
    @Produces (MediaType.APPLICATION_JSON)
    public List getAvailableBookCopies () {
        List listOfAvailableBooks = availableCopiesService.getAllAvaiableBookCopies ();
        return listOfAvailableBooks;
    }
}