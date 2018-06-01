/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.data.user;

import java.text.ParseException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import olcm.business.role.Role;
import olcm.core.CreateResponse;
import olcm.core.Json;

/**
 *
 * @author shamim
 */
@Stateless
@Path("user")
public class serive_user {

    @Inject
    Json json;
    @Inject
    Repo_User repo;

    @GET
    @Path("/username/{uname}/password/{password}/roleId")
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    public Response getById(@PathParam("uname") String username, @PathParam("password") String password, @Context HttpServletRequest request) throws ParseException {
        try {
            return CreateResponse.CreateResponse(json.JsonStringify(repo.getRoleId(username, password)), "n/a", "Result has been shown according to your request", Boolean.TRUE);
        } catch (Exception e) {
            return CreateResponse.CreateResponse(json.JsonStringify("null"), "n/a", "Result has been shown according to your request", Boolean.FALSE);
        }
    }
}
