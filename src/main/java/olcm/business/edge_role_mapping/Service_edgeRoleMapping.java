/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.edge_role_mapping;

import java.text.ParseException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
@Path("edgerolemapping")
public class Service_edgeRoleMapping {

    @Inject
    Bean_edgeRoleMapping bean_edgeRoleMapping;
    @Inject
    Bean_edgeRoleMappingPosting Bean_edgeRoleMappingPosting;
    @Inject
    Json json;

    @POST
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response create(final List<EdgeRoleMappingPostingTemplate> edgeRoleMappingPostingTemplate_List, @Context HttpServletRequest request) {
        return Bean_edgeRoleMappingPosting.save(edgeRoleMappingPostingTemplate_List)
                ? CreateResponse.CreateResponse("Operation Successfull", Boolean.TRUE)
                : CreateResponse.CreateResponse("Operation Failed", Boolean.FALSE);
    }

    @GET
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getAll(@Context HttpServletRequest request) {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_edgeRoleMapping.getAll()), request.getHeader(HttpHeaders.AUTHORIZATION), "Result", Boolean.TRUE);
    }



}
