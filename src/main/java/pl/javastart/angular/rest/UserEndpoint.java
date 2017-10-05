package pl.javastart.angular.rest;
 
import java.util.List;
 
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import pl.javastart.model.User;
import pl.javastart.model.UserPhotoComments;
import pl.javastart.model.UserPhotos;
import pl.javastart.repository.UserRepository;
 

 
@RequestScoped
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserEndpoint {
 
    @Inject
    private UserRepository userRepository;
 
 
    @GET
    public Response getAllProducts() {
        List<User> users = userRepository.getAll();
        return Response.ok(users).build();
    }
    
    @GET
    @Path("/{username}/{password}")
    public Response getProduct(@PathParam("username") String username, @PathParam("password") String password) {
        User user = userRepository.getUserByEmail(username, password);
        if (user == null) {
            return Response.noContent().build();
        } else {
            return Response.ok(user).build();
        }
    }
 
    @GET
    @Path("/photos/{username}/{password}")
    public Response getUserPhotos(@PathParam("username") String username, @PathParam("password") String password) {
        List<UserPhotos> userPhotosList = userRepository.getUserPhotos(username, password);
        if (userPhotosList == null) {
            return Response.noContent().build();
        } else {
            return Response.ok(userPhotosList).build();
        }
    }
    
    @GET
    @Path("/photos/comments/{username}/{path}")
    public Response getUserPhotoComments(@PathParam("username") String username,@PathParam("path") String path) {
        List<UserPhotoComments> userPhotoCommentsList = userRepository.getUserPhotoComments(username, path);
        if (userPhotoCommentsList == null) {
            return Response.noContent().build();
        } else {
            return Response.ok(userPhotoCommentsList).build();
        }
    }
    
    
    @POST
    @Path("/photos/comments")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response savePhotoComments(UserPhotoComments userPhotoComments, @Context UriInfo uriInfo) {
    	System.out.println("photos/comments  savePhotoComments działa!!!");
    	userRepository.addComment(userPhotoComments);
        return Response
                .accepted(userPhotoComments)
                .build();
    }
 
}