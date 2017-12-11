package edu.njit.dbms.group11.controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.njit.dbms.group11.bean.LoginBean;
import edu.njit.dbms.group11.service.LoginService;
 
@Path("/login")
public class LoginController {
    LoginService loginService = new LoginService ();
 
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public LoginBean doLoginAndReturnDetails (LoginBean loginBean) {
    	LoginBean returnLoginBean = new LoginBean ();
    	returnLoginBean.setUserName (loginBean.getUserName ());
    	returnLoginBean.setPassword (loginBean.getPassword ());
    	returnLoginBean.setCheckAdmin (loginBean.getCheckAdmin ());
    	returnLoginBean.setId (loginService.doLoginAndReturnDetails (loginBean));
    	System.out.println ("LoginController.doLoginAndReturnDetails::" + returnLoginBean);
    	System.out.println ("returnLoginBean.getCheckAdmin ()::" + returnLoginBean.getCheckAdmin ());
    	System.out.println ("returnLoginBean.getId ()::" + returnLoginBean.getId ());
    	System.out.println ("returnLoginBean.getPassword ()::" + returnLoginBean.getPassword ());
    	System.out.println ("returnLoginBean.getUserName ()::" + returnLoginBean.getUserName ());
        return returnLoginBean;
    }
}