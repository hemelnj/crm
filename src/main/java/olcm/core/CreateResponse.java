/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.core;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class CreateResponse {
    public static Response CreateResponse(String bodyData, String token, String message, Boolean requestStatus, String functionId){
        return Response
                        .ok(bodyData, MediaType.WILDCARD_TYPE)
                        .header("AUTHORIZATION", token)
                        .header("MESSAGE", message)
                        .header("REQEUSTSTATUS", requestStatus)
                        .header("FUNCTIONID", functionId)
                        .build();
    }
    
    public static Response CreateResponse(String bodyData, String token, String message, Boolean requestStatus){
        return Response
                        .ok(bodyData, MediaType.WILDCARD_TYPE)
                        .header("AUTHORIZATION", token)
                        .header("MESSAGE", message)
                        .header("REQEUSTSTATUS", requestStatus)
                        .header("FUNCTIONID", "")
                        .build();
    }
    
    public static Response CreateResponse(String token, String message, Boolean requestStatus){
        return Response
                        .ok("", MediaType.WILDCARD_TYPE)
                        .header("AUTHORIZATION", token)
                        .header("MESSAGE", message)
                        .header("REQEUSTSTATUS", requestStatus)
                        .header("FUNCTIONID", "")
                        .build();
    }
    
    public static Response CreateResponse(String message, Boolean requestStatus){
        return Response
                        .ok(message, MediaType.WILDCARD_TYPE)
                        .header("AUTHORIZATION", "")
                        .header("MESSAGE", message)
                        .header("REQEUSTSTATUS", requestStatus)
                        .header("FUNCTIONID", "")
                        .build();
    }
    
    public static Response CreateUnAuthorisedResponse(String token, String message){
        return Response.status(Response.Status.UNAUTHORIZED)
                .header("AUTHORIZATION", token)
                .header("MESSAGE", message)
                .header("REQEUSTSTATUS", false)
                .build();
    }
    
    public static Response CreateUnAuthorisedResponse(String message){
        return Response.status(Response.Status.UNAUTHORIZED)
                .header("AUTHORIZATION", "")
                .header("MESSAGE", message)
                .header("REQEUSTSTATUS", false)
                .build();
    }
    
    public static Response CreateUnAuthorisedResponse(){
        return Response.status(Response.Status.UNAUTHORIZED)
                .header("AUTHORIZATION", "")
                .header("MESSAGE", "")
                .header("REQEUSTSTATUS", false)
                .build();
    }
    
    public static Response CreateBadResponse(String token, String message){
        return Response.status(Response.Status.BAD_REQUEST)
                .header("AUTHORIZATION", token)
                .header("MESSAGE", message)
                .header("REQEUSTSTATUS", false)
                .build();
    }
    
    public static Response CreateBadResponse(String message){
        return Response.status(Response.Status.BAD_REQUEST)
                .header("AUTHORIZATION", "")
                .header("MESSAGE", message)
                .header("REQEUSTSTATUS", false)
                .build();
    }
    
    public static Response CreateBadResponse(){
        return Response.status(Response.Status.BAD_REQUEST)
                .header("AUTHORIZATION", "")
                .header("MESSAGE", "Unknown")
                .header("REQEUSTSTATUS", false)
                .build();
    }
}
