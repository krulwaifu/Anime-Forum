package controllers;

import domain.AccessToken;
import domain.LoginData;
import services.AuthorizationService;
import services.interfaces.IAuthorizationService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("auth")
public class AuthorizationController {
    private final IAuthorizationService authService = new AuthorizationService();
    @POST
    public Response login(LoginData loginData){
        try {
            AccessToken token = authService.authenticate(loginData);
            return Response.ok(token).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

    }
}
