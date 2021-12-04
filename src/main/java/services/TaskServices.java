package services;

import entity.Message;
import entity.Task;
import provider.TaskProvider;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("tasks")
@Stateless
public class TaskServices {

    @GET
    @Path("index")
    public String index(){
        return "index";
    }

    @OPTIONS
    @Path("create")
    public Response options(Task task){
        return Response.status(200)
                .header("access-control-allow-origin", "*")
                .header("access-control-allow-methods", "*")
                .header("access-control-allow-headers", "*")
                .build();
    }

    @POST
    @Path("create")
    @Consumes("application/json")
    public Response create(Task task){
        try {
            TaskProvider provider = new TaskProvider();
            provider.create(task);
            return Response.status(200)
                    .header("access-control-allow-origin", "*")
                    .header("access-control-allow-methods", "*")
                    .header("access-control-allow-headers", "*")
                    .entity(new Message("Task was created successfully")).build();
        }catch (ClassNotFoundException | SQLException ex){
            return Response.status(500)
                    .header("access-control-allow-origin", "*")
                    .header("access-control-allow-methods", "*")
                    .header("access-control-allow-headers", "*")
                    .entity(new Message(ex.getMessage())).build();
        }

    }
    @OPTIONS
    @Path("update")
    public Response optionsUpdate(Task task){
        return Response.status(200)
                .header("access-control-allow-origin", "*")
                .header("access-control-allow-methods", "*")
                .header("access-control-allow-headers", "*")
                .build();
    }


    @PUT
    @Path("update")
    @Consumes("application/json")
    public Response updateUser(Task task){

        try {
            TaskProvider provider = new TaskProvider();
            provider.update(task);
            return Response.status(200)
                    .header("access-control-allow-origin", "*")
                    .header("access-control-allow-methods", "*")
                    .header("access-control-allow-headers", "*")
                    .entity(new Message("Task was updated successfully")).build();
        }catch (ClassNotFoundException | SQLException ex){
            return Response.status(500)
                    .header("access-control-allow-origin", "*")
                    .header("access-control-allow-methods", "*")
                    .header("access-control-allow-headers", "*")
                    .entity(new Message(ex.getMessage())).build();
        }
    }
    @OPTIONS
    @Path("getall")
    public Response optionsGetAll(Task task){
        return Response.status(200)
                .header("access-control-allow-origin", "*")
                .header("access-control-allow-methods", "*")
                .header("access-control-allow-headers", "*")
                .build();
    }

    @GET
    @Path("getall")
    @Produces("application/json")
    public Response getAll(){
        try {
            TaskProvider provider = new TaskProvider();
            ArrayList<Task> tasks = provider.getAll();
            return Response.status(200)
                    .header("access-control-allow-origin", "*")
                    .header("access-control-allow-methods", "*")
                    .header("access-control-allow-headers", "*")
                    .entity(tasks).build();
        }catch (ClassNotFoundException | SQLException ex){
            return Response.status(500)
                    .header("access-control-allow-origin", "*")
                    .header("access-control-allow-methods", "*")
                    .header("access-control-allow-headers", "*")
                    .entity(new Message(ex.getMessage())).build();
        }

    }

    @OPTIONS
    @Path("delete")
    public Response optionsDelete(Task task){
        return Response.status(200)
                .header("access-control-allow-origin", "*")
                .header("access-control-allow-methods", "*")
                .header("access-control-allow-headers", "*")
                .build();
    }
    @DELETE
    @Path("delete")
    @Consumes("application/json")
    public Response delete(Task task) {
        try {
            TaskProvider provider = new TaskProvider();
            provider.delete(task);

            return Response.status(200)
                    .header("access-control-allow-origin", "*")
                    .header("access-control-allow-methods", "*")
                    .header("access-control-allow-headers", "*")
                    .entity(new Message("Task was deleted successfully")).build();
        } catch (ClassNotFoundException | SQLException ex) {
            return Response.status(500)
                    .header("access-control-allow-origin", "*")
                    .header("access-control-allow-methods", "*")
                    .header("access-control-allow-headers", "*")
                    .entity(new Message(ex.getMessage())).build();
        }
    }
}
