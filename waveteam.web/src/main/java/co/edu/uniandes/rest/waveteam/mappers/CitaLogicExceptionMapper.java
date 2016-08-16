/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.waveteam.mappers;

import co.edu.uniandes.rest.waveteam.exceptions.CitaLogicException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author jm.lizarazo10
 */
public class CitaLogicExceptionMapper implements ExceptionMapper<CitaLogicException>{
    
    @Override
    public Response toResponse(CitaLogicException exception){
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(exception.getMessage())
                .type("text/plain")
                .build();
    }
    
}
