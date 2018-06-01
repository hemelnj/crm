/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.action_event;

import java.text.ParseException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import olcm.core.CreateResponse;
import olcm.core.Json;

/**
 *
 * @author Admin
 */
@Stateless
@Path("event")
public class Service_actionEvent {

    @Inject
    Bean_actionEvent bean_actionEvent;
    @Inject
    Json json;

    @GET
    @Path("/{id}")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getById(@PathParam("id") Long id, @Context HttpServletRequest request) {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_actionEvent.getById(id)), "n/a", "Result has been shown according to your request", Boolean.TRUE);
    }

    @GET
    @Path("class/{classId}/status/{statusId}/role/{roleId}")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getAllAllowableActions(@PathParam("classId") Long classId, @PathParam("statusId") Long statusId, @PathParam("roleId") Long roleId, @Context HttpServletRequest request) throws ParseException {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_actionEvent.allAllowableActions(classId, statusId, roleId)), "n/a", "Result has been shown according to your request", Boolean.TRUE);
    }
    
    
    @GET
    @Path("name/{name}")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getEventByName(@PathParam("name") String name, @Context HttpServletRequest request) throws ParseException {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_actionEvent.getEventByName(name, "n/a")), "n/a", "Result has been shown according to your request", Boolean.TRUE);
    }

    @GET
    @Path("class/{classId}/status/{statusId}/role/{roleId}/crud")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getAllAllowableCRUDActions(@PathParam("classId") Long classId, @PathParam("statusId") Long statusId, @PathParam("roleId") Long roleId, @Context HttpServletRequest request) throws ParseException {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_actionEvent.allAllowableCRUDActions(classId, statusId, roleId)), "n/a", "Result has been shown according to your request", Boolean.TRUE);
    }

    @POST
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response create(final List<ActionEvent> actionEvents, @Context HttpServletRequest request) {

        return bean_actionEvent.saveList(actionEvents)
                ? CreateResponse.CreateResponse("Operation Successfull", Boolean.TRUE)
                : CreateResponse.CreateResponse("Operation Failed", Boolean.FALSE);
    }

    @GET
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getAll(@Context HttpServletRequest request) {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_actionEvent.getAll()), request.getHeader(HttpHeaders.AUTHORIZATION), "Result", Boolean.TRUE);
    }

    @GET
    @Path("type/{type}")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getAll(@PathParam("type") String type, @Context HttpServletRequest request) throws ParseException {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_actionEvent.allAllByType(type)), request.getHeader(HttpHeaders.AUTHORIZATION), "Result", Boolean.TRUE);
    }

    @GET
    @Path("regular")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getAllWithouCRUD(@Context HttpServletRequest request) throws ParseException {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_actionEvent.allAllByType("n/a")), request.getHeader(HttpHeaders.AUTHORIZATION), "Result", Boolean.TRUE);
    }

    @GET
    @Path("crudtypes")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getAllByCRUDTypes(@Context HttpServletRequest request) throws ParseException {

        return CreateResponse.CreateResponse(json.JsonStringify(bean_actionEvent.allAllByCRUDTypes()), request.getHeader(HttpHeaders.AUTHORIZATION), "Result", Boolean.TRUE);
    }
    
    @PUT
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response edit(final ActionEvent actionEvent, @Context HttpServletRequest request) {
        Boolean result = bean_actionEvent.update(actionEvent);
        if (result == true) {
            return CreateResponse.CreateResponse("Operation Successfull", Boolean.TRUE);
        } else {
            return CreateResponse.CreateResponse("Operation Failed", Boolean.FALSE);
        }
    }

}
