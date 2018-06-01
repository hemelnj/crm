/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
Modified by Hemel
 */
package crm.common;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import static javax.ws.rs.client.Entity.json;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import olcm.core.CreateResponse;
import olcm.core.Json;

/**
 *
 * @author MSI
 */
@Stateless
@Path("ObjectDefinition")
public class Service {

    @Inject
    Bean_ObjectDefinitionAndFieldRecording bean;
    @Inject
    Bean_ObjectDefinition bean_ObjectDefinition;
    @Inject
    Json json;

    @GET
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public String RecreateObjectDefinition(@Context HttpServletRequest request) throws IllegalArgumentException, IllegalAccessException {
        return bean.RecreateObjectDefinition();
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getById(@PathParam("id") Long id, @Context HttpServletRequest request) {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_ObjectDefinition.getById(id)), "n/a", "Result has been shown according to your request", Boolean.TRUE);
    }

    
    @GET
    @Path("/getall")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getAll( @Context HttpServletRequest request) {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_ObjectDefinition.getAll()), "n/a", "Result has been shown according to your request", Boolean.TRUE);
    }
}
