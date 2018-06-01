/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.business.customer;

import crm.core.CreateResponse;
import crm.core.Json;
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

/**
 *
 * @author Admin
 */
@Stateless
@Path("customer")

public class Service_Customer {

    @Inject
    Json json;

    @Inject
    Bean_Customer bean_Customer;

    @POST
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response create(final DmCustomer dmCustomer, @Context HttpServletRequest request) {
        try {
            bean_Customer.save(dmCustomer);
            return CreateResponse.CreateResponse("Operation Successfull", Boolean.TRUE);
        } catch (Exception e) {
            return CreateResponse.CreateResponse("Operation Failed", Boolean.FALSE);
        }

    }

    @GET
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getAll(@Context HttpServletRequest request) {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_Customer.getAll()), request.getHeader(HttpHeaders.AUTHORIZATION), "Result", Boolean.TRUE);
    }

    @GET
    @Path("/{state}/state")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getAllByState(@PathParam("state") String state, @Context HttpServletRequest request) throws ParseException {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_Customer.getAllByState(state)), request.getHeader(HttpHeaders.AUTHORIZATION), "Result", Boolean.TRUE);
    }

    @GET
    @Path("/{id}/")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getCustomerInfoById(@PathParam("id") Long id, @Context HttpServletRequest request) throws ParseException {
        return CreateResponse.CreateResponse(json.JsonStringify(bean_Customer.getById(id)), request.getHeader(HttpHeaders.AUTHORIZATION), "Result", Boolean.TRUE);
    }

    
    @PUT
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response edit(final List<DmCustomer> dmCustomers, @Context HttpServletRequest request) {
        Boolean result = bean_Customer.editList(dmCustomers);
        if (result == true) {
            return CreateResponse.CreateResponse("Operation Successfull", Boolean.TRUE);
        } else {
            return CreateResponse.CreateResponse("Operation Failed", Boolean.FALSE);
        }
    }
}
