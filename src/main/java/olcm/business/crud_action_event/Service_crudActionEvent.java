/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.crud_action_event;

import java.util.HashSet;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
@Path("crud")
public class Service_crudActionEvent {

    @Inject
    Bean_crudActionEvent bean_crudActionEvent;
    @Inject
    Bean_crudActionEventPosting Bean_crudActionEventPosting;
    @Inject
    Json json;

//    @POST
//    @Consumes(MediaType.WILDCARD)
//    @Produces(MediaType.WILDCARD)
//    public Response create(final CrudActionEventPostingTemplate crudActionEventPostingTemplate, @Context HttpServletRequest request) {
//        return Bean_crudActionEventPosting.save(crudActionEventPostingTemplate)
//                ? CreateResponse.CreateResponse("Operation Successfull", Boolean.TRUE)
//                : CreateResponse.CreateResponse("Operation Failed", Boolean.FALSE);
//    }

    @POST
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response create_List(final List<CrudActionEventPostingTemplate> crudActionEventPostingTemplates, @Context HttpServletRequest request) {
        HashSet crudActionEventPostingTemplates_has=new HashSet();
        crudActionEventPostingTemplates_has.addAll(crudActionEventPostingTemplates);
        crudActionEventPostingTemplates.clear();
        crudActionEventPostingTemplates.addAll(crudActionEventPostingTemplates_has);
        return Bean_crudActionEventPosting.save_List(crudActionEventPostingTemplates)
                ? CreateResponse.CreateResponse("Operation Successfull", Boolean.TRUE)
                : CreateResponse.CreateResponse("Operation Failed", Boolean.FALSE);
    }

    @GET
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getAll(@Context HttpServletRequest request) {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_crudActionEvent.getAll()), request.getHeader(HttpHeaders.AUTHORIZATION), "Result", Boolean.TRUE);
    }

}
