/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.business.accounttype;

import crm.business.customer.DmCustomer;
import crm.core.CreateResponse;
import crm.core.Json;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Admin
 */
@Stateless
@Path("AccountType")
public class Service_AccountType {

    @Inject
    Json json;

    @Inject
    Bean_AccountType bean_AccountType;

    @POST
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response create(final List<DmAccountType> dmAccountTypes, @Context HttpServletRequest request) {
        try {
            bean_AccountType.saveList(dmAccountTypes);
            return CreateResponse.CreateResponse("Operation Successfull", Boolean.TRUE);
        } catch (Exception e) {
            return CreateResponse.CreateResponse("Operation Failed", Boolean.FALSE);
        }

    }

    @GET
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getAll(@Context HttpServletRequest request) {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_AccountType.getAll()), request.getHeader(HttpHeaders.AUTHORIZATION), "Result", Boolean.TRUE);
    }

    @PUT
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response edit(final DmAccountType dmAccountType, @Context HttpServletRequest request) {
        Boolean result = bean_AccountType.edit(dmAccountType);
        if (result == true) {
            return CreateResponse.CreateResponse("Operation Successfull", Boolean.TRUE);
        } else {
            return CreateResponse.CreateResponse("Operation Failed", Boolean.FALSE);
        }
    }

}
