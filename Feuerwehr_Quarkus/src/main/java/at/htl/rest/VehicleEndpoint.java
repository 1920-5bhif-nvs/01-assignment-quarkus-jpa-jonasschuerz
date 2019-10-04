package at.htl.rest;

import at.htl.model.Vehicle;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("vehicle")
public class VehicleEndpoint {
    @Inject
    EntityManager em;

    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findAll() {
        TypedQuery<Vehicle> query = em.createNamedQuery("Vehicle.findAll", Vehicle.class);
        List<Vehicle> vehicles = query.getResultList();
        return Response.ok().entity(vehicles).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findById(@PathParam("id") long id) {
        Vehicle vehicle = em.find(Vehicle.class, id);
        if (vehicle == null) {
            return Response.status(404).build();
        }
        return Response.ok().entity(vehicle).build();
    }

    @DELETE
    @Path("/deleteVehicle/{id}")
    @Transactional
    public Response deleteById(@PathParam("id") long id) {
        Vehicle vehicle = em.find(Vehicle.class, id);
        if (vehicle == null) {
            return Response.status(404).build();
        }
        em.remove(vehicle);
        return Response.noContent().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Vehicle vehicle){
        em.persist(vehicle);
        return Response.ok().entity(vehicle).build();
    }

}
