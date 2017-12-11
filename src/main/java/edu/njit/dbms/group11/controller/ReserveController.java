package edu.njit.dbms.group11.controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.njit.dbms.group11.bean.ReserveOrBorrowBean;
import edu.njit.dbms.group11.service.ReserveService;
 
@Path("reserveOrBorrowBook")
public class ReserveController {

    ReserveService reserveService = new ReserveService ();
 
    @Path("reader")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public ReserveOrBorrowBean reserveABook (ReserveOrBorrowBean reserveBean) {
        return reserveService.reserveABook (reserveBean);
    }
    
    @Path("admin")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public ReserveOrBorrowBean borroweABook (ReserveOrBorrowBean borrowBean) {
        return reserveService.borrowABook (borrowBean);
    }
}