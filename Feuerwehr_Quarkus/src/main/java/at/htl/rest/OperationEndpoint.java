package at.htl.rest;

import at.htl.model.Operation;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("operation")
public class OperationEndpoint {
    @Inject
    EntityManager em;

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        TypedQuery<Operation> query = em.createNamedQuery("Operation.findAll", Operation.class);
        List<Operation> operations = query.getResultList();
        return Response.ok().entity(operations).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") long id) {
        Operation operation = em.find(Operation.class, id);
        if (operation == null) {
            return Response.status(404).build();
        }
        return Response.ok().entity(operation).build();
    }

    @DELETE
    @Path("/deleteOperation/{id}")
    public Response deleteById(@PathParam("id") long id) {
        Operation operation = em.find(Operation.class, id);
        if (operation == null) {
            return Response.status(404).build();
        }
        em.remove(operation);
        return Response.noContent().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Operation operation){
        em.persist(operation);
        return Response.ok().entity(operation).build();
    }

}
