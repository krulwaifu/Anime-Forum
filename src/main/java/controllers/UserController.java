package controllers;

import domain.User;
import services.UserService;
import services.interfaces.IUserService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("users")
public class UserController {
    private final IUserService userService = new UserService();

    @GET
    public String index(){
      return "hello from user controller";
    }

    @GET
    @Path("/{param}")
    public Response getUserByID(@PathParam("param") int id) {
        User user;
        try{
            user = userService.getUserByID(id);
        } catch (ServerErrorException ex){
            return Response.serverError().build();
        }catch(BadRequestException ex){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if (user == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }else {
            return Response.ok(user).build();
        }

    }

}
