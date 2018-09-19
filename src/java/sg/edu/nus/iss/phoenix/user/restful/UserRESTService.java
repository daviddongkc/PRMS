/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.restful;

/**
 *
 * @author dong
 */
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import sg.edu.nus.iss.phoenix.authenticate.entity.Role;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.user.service.UserService;


@Path("user")
@RequestScoped
public class UserRESTService {
    @Context
    private UriInfo context;
    private UserService service;
    
    /**
     * Creates a new instance of RadioProgramRESTService
     */    
    
    public UserRESTService(){
        service = new UserService();    
    }

    /**
     * Retrieves representation of an instance of resource
     * @return an instance of resource
     */
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(){
        throw new UnsupportedOperationException();
    }
    
    @GET
    @Path("/allusers")
    @Produces(MediaType.APPLICATION_JSON)
    public Users getAllUsers(){
        ArrayList<User> userlist = service.findAllUser();
        Users userslist = new Users();
        userslist.setUserList(new ArrayList<User>());
        
        for (int i = 0; i < userlist.size(); i++){
            User user = new User();
            /*if (userlist.get(i).getRoles().isEmpty()){
                ArrayList<Role> rolesTest = new ArrayList<>();
                String temp = new String("test");
                Role roleTest = new Role(temp);
                rolesTest.add(roleTest);
                user = new User(userlist.get(i).getId(),userlist.get(i).getPassword(), userlist.get(i).getName(),rolesTest);
            }
            else{
                user = new User(userlist.get(i).getId(),userlist.get(i).getPassword(), userlist.get(i).getName(),userlist.get(i).getRoles());
            }*/
            try{
                user = new User(userlist.get(i).getId(),userlist.get(i).getPassword(), userlist.get(i).getName(),userlist.get(i).getRoles());
            }
            catch(Exception e){
                System.out.println("Exception occurred");
            }
            userslist.getUserList().add(user);
            //System.out.println("password" + userlist.get(i).getPassword());
        }
        return userslist;        
    }

    /**
     * PUT method for updating or creating an instance of resource
     * @param content representation for the resource
     */
    
    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(User user){
        service.processModify(user);
    }
     
    /**
     * POST method for creating an instance of resource
     * @param content representation for the resource
     */
    
    @PUT
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(User user) {
        service.processCreate(user);
    }
   
    /**
     * DELETE method for deleting an instance of resource
     * @param name name of the resource
     */
    
    @DELETE
    @Path("/delete/{id}")
    //0909modify userID or username?
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("id") String name) {
        String name2;
        try { 
            name2 = URLDecoder.decode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace(); 
            return;
        }

        service.processDelete(name2);
    }   
    
    
    @GET
    @Path("/allpp")
    @Produces(MediaType.APPLICATION_JSON)
    public Users getAllPP(){
        ArrayList<User> userlist = service.findAllPP();
        Users userslist = new Users();
        userslist.setUserList(new ArrayList<>());
        
        for (int i = 0; i < userlist.size(); i++){
            userslist.getUserList().add(
                    new User(userlist.get(i).getId(),userlist.get(i).getPassword(),
                            userlist.get(i).getName(),
                            userlist.get(i).getRoles()));
        }
        return userslist;        
    }
}
