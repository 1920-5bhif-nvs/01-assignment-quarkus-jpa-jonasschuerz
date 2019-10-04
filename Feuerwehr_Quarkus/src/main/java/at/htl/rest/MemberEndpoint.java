package at.htl.rest;

import at.htl.model.Member;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("member")
public class MemberEndpoint {
    @Inject
    EntityManager em;

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findAll() {
        TypedQuery<Member> query = em.createNamedQuery("Member.findAll", Member.class);
        List<Member> members = query.getResultList();
        return Response.ok().entity(members).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response findById(@PathParam("id") long id) {
        Member member = em.find(Member.class, id);
        if (member == null) {
            return Response.status(404).build();
        }
        return Response.ok().entity(member).build();
    }

    @DELETE
    @Path("/deleteMember/{id}")
    @Transactional
    public Response deleteById(@PathParam("id") long id) {
        Member member = em.find(Member.class, id);
        if (member == null) {
            return Response.status(404).build();
        }
        em.remove(member);
        return Response.noContent().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Member member){
        em.persist(member);
        return Response.ok().entity(member).build();
    }

}
