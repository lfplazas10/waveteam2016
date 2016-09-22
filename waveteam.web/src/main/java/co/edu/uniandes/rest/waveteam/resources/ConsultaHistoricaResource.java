/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.waveteam.resources;

import co.edu.uniandes.rest.waveteam.dtos.ConsultaHistoricaDTO;
import co.edu.uniandes.rest.waveteam.exceptions.ConsultaHistoricaLogicException;
import co.edu.uniandes.rest.waveteam.mocks.ConsultaHistoricaLogicMock;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author d.marino10
 */
@Path("consultasHistoricas")
@Produces("application/json")
@Consumes("application/json")
public class ConsultaHistoricaResource {
    
    ConsultaHistoricaLogicMock logic = new ConsultaHistoricaLogicMock();

    /**
     * Obtiene el listado de especialidades.
     *
     * @return lista de especialidades
     * @throws EspecialidadLogicException excepción retornada por la lógica
     */
    @GET
    public List<ConsultaHistoricaDTO> getConsultasHistoricas() throws ConsultaHistoricaLogicException {
        return logic.getConsultasHisotircas();
    }

    @GET
    @Path("{nombre: }")
    public ConsultaHistoricaDTO getConsultaHistorica(@PathParam("nombre") String nombreEsp) throws ConsultaHistoricaLogicException {
        return logic.getConsultaHistorica(nombreEsp);
    }

    @PUT
    @Path("{nombre: }")
    public ConsultaHistoricaDTO updateConsultaHistorica(@PathParam("nombre") String nombreEsp) throws ConsultaHistoricaLogicException {
        return logic.updateConsultaHistorica(nombreEsp);
    }
    
    @GET
    @Path("editAll")
    public List<ConsultaHistoricaDTO> generarTodas() throws ConsultaHistoricaLogicException {
        return logic.generarTodas();
    }

    @POST
    public ConsultaHistoricaDTO createConsultaHistorica(String nombreEsp) throws ConsultaHistoricaLogicException {
        return logic.createConsultaHistorica(nombreEsp);
    }

    @DELETE
    @Path("{nombre: }")
    public void deleteConsultaHistorica(@PathParam("nombre") String nombreEsp) throws ConsultaHistoricaLogicException {
        logic.deleteConsultaHistorica(nombreEsp);
    }
}
