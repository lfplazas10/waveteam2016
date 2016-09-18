/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.waveteam.mappers;

import co.edu.uniandes.rest.waveteam.exceptions.ConsultaHistoricaLogicException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *Convertidor de Excepciones ConsultaHistoricaLogicException a mensajes REST.
 * @author d.marino10
 */
@Provider
public class ConsultaHistoricaExceptionMapper implements ExceptionMapper<ConsultaHistoricaLogicException>{
 
     /**
     * Generador de una respuesta a partir de una excepción
     *
     * @param ex excecpión a convertir a una respuesta REST
     */
    @Override
    public Response toResponse(ConsultaHistoricaLogicException ex) {
        // retorna una respuesta
        return Response
                .status(Response.Status.NOT_FOUND) // estado HTTP 404
                .entity(ex.getMessage()) // mensaje adicional
                .type("text/plain")
                .build();
    }  
}
