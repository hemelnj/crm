/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.class_type;

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
import olcm.business.class_status.Bean_classStatus;
import olcm.business.class_status_mapping.Bean_classStatusMapping;
import olcm.business.crud_action_event.Bean_crudActionEvent;
import olcm.business.edge.Bean_DetailedEdgeView;
import olcm.business.edge.Bean_edge;
import olcm.business.edge_role_mapping.Bean_edgeRoleMapping;
import olcm.core.CreateResponse;
import olcm.core.Json;

/**
 *
 * @author Admin
 */
@Stateless
@Path("class")
public class Service_classType {

    @Inject
    Bean_classType bean_classType;
    @Inject
    Bean_classStatus bean_classStatus;
    @Inject
    Bean_DetailedEdgeView bean_DetailedEdgeView;
    @Inject
    Bean_edge bean_edge;
    @Inject
    Bean_edgeRoleMapping bean_edgeRoleMapping;
    @Inject
    Bean_crudActionEvent bean_crudActionEvent;
    @Inject
    Bean_classStatusMapping bean_classStatusMapping;
    @Inject
    Json json;

    @POST
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response create(final List<ClassType> classTypes, @Context HttpServletRequest request) {
        try {
            bean_classType.saveList(classTypes);
            return CreateResponse.CreateResponse("Operation Successfull", Boolean.TRUE);
        } catch (Exception e) {
            return CreateResponse.CreateResponse("Operation Failed", Boolean.FALSE);
        }

    }

    @GET
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getAll(@Context HttpServletRequest request) {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_classType.getAll()), request.getHeader(HttpHeaders.AUTHORIZATION), "Result", Boolean.TRUE);
    }

    @GET
    @Path("/{id}/statuses")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getAllByClass(@PathParam("id") Long id, @Context HttpServletRequest request) throws ParseException {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_classStatus.allStatusOfAClass(id)), request.getHeader(HttpHeaders.AUTHORIZATION), "Result", Boolean.TRUE);
    }

    @GET
    @Path("/{id}/notmappedstatuses")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getAllNotMappedStatues(@PathParam("id") Long id, @Context HttpServletRequest request) throws ParseException {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_classStatus.notMappedStatuses(id)), request.getHeader(HttpHeaders.AUTHORIZATION), "Result", Boolean.TRUE);
    }

    @GET
    @Path("/{classId}/event/{actionEventId}/role/{roleId}/status")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response nextAllowableStatuByClassTypeAndActionEventAnRole(@PathParam("classId") Long classId, @PathParam("actionEventId") Long eventId,@PathParam("roleId") Long roleId, @Context HttpServletRequest request) throws ParseException {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_classStatus.nextAllowableStatuByClassTypeAndActionEventAnRole(classId, eventId,roleId)), request.getHeader(HttpHeaders.AUTHORIZATION), "Result", Boolean.TRUE);
    }

    @GET
    @Path("/{id}/edges")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response allEdgesByClassType(@PathParam("id") Long id, @Context HttpServletRequest request) throws ParseException {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_edge.allEdgesByClassType(id)), request.getHeader(HttpHeaders.AUTHORIZATION), "Result", Boolean.TRUE);
    }

    @GET
    @Path("/{id}/detailededgeinfo")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getDetailedEdgesInfoByClassType(@PathParam("id") Long id, @Context HttpServletRequest request) throws ParseException {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_DetailedEdgeView.detailedEdgesInfoByClassType(id)), request.getHeader(HttpHeaders.AUTHORIZATION), "Result", Boolean.TRUE);
    }

    @GET
    @Path("/{id}/edgerole")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getAllEdgeRoleMappingsByClassType(@PathParam("id") Long id, @Context HttpServletRequest request) throws ParseException {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_edgeRoleMapping.getAllEdgeRoleMappingsByClassType(id)), request.getHeader(HttpHeaders.AUTHORIZATION), "Result", Boolean.TRUE);
    }

    @GET
    @Path("/{id}/crud")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getAllCRUDsByClassType(@PathParam("id") Long id, @Context HttpServletRequest request) throws ParseException {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_crudActionEvent.allEdgesByClassType(id)), request.getHeader(HttpHeaders.AUTHORIZATION), "Result", Boolean.TRUE);
    }

    @GET
    @Path("/{id}/mappings")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getAllMappedClassAndStatusByClassType(@PathParam("id") Long id, @Context HttpServletRequest request) throws ParseException {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_classStatusMapping.getAllByClassType(id)), request.getHeader(HttpHeaders.AUTHORIZATION), "Result", Boolean.TRUE);
    }

    @PUT
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response edit(final ClassType classType, @Context HttpServletRequest request) {
        Boolean result = bean_classType.edit(classType);
        if (result == true) {
            return CreateResponse.CreateResponse("Operation Successfull", Boolean.TRUE);
        } else {
            return CreateResponse.CreateResponse("Operation Failed", Boolean.FALSE);
        }
    }
}
