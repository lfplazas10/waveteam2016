/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.waveteam.resources;

import co.edu.uniandes.rest.waveteam.dtos.EspecialidadDTO;
import co.edu.uniandes.rest.waveteam.dtos.MedicoDTO;
import co.edu.uniandes.rest.waveteam.exceptions.EspecialidadLogicException;
import co.edu.uniandes.rest.waveteam.mocks.EspecialidadLogicMock;
import java.util.ArrayList;
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
@Path("especialidades")
@Produces("application/json")
@Consumes("application/json")
public class EspecialidadResource {
    
    EspecialidadLogicMock espLogic = new EspecialidadLogicMock();

    /**
     * Obtiene el listado de especialidades.
     *
     * @return lista de especialidades
     * @throws EspecialidadLogicException excepción retornada por la lógica
     */
    @GET
    public List<EspecialidadDTO> getEspecialidades() throws EspecialidadLogicException {
        return espLogic.getEspecialidades();
    }

    @GET
    @Path("{id: \\d+}")
    public EspecialidadDTO getEspecialidad(@PathParam("id") Long id) throws EspecialidadLogicException {
        return espLogic.getEspecialidad(id);
    }

    /**
     * 
     * @param id
     * @param especialidad
     * @return
     * @throws EapecialidadLogicException 
     */
    @PUT
    @Path("{id: \\d+}")
    public EspecialidadDTO updateEspecialidad(@PathParam("id") Long id, EspecialidadDTO especialidad) throws EspecialidadLogicException {
        return espLogic.updateEspecialidad(id, especialidad);
    }

    /**
     * Agrega una especialidad
     *
     * @param especialidad
     * @return especialidad2 Datos del médico agregado
     * @throws EspecialidadLogicException cuando ya existe una especialidad con el id 
     * suministrado
     */
    @POST
    public EspecialidadDTO createEspecialidad(EspecialidadDTO especialidad) throws EspecialidadLogicException {
        return espLogic.createEspecialidad(especialidad);
    }

    /**
     * 
     * @param id
     * @throws EspecialidadLogicException 
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteEspecialidad(@PathParam("id") Long id) throws EspecialidadLogicException {
        espLogic.deleteEspecialidad(id);
    }
    
    
    @GET
    @Path("{id: \\d+}/doctores")
    public List<MedicoDTO> getDoctoresPorEspecialidad(@PathParam("id") Long id) throws EspecialidadLogicException {
        return espLogic.getDoctoresPorEspecialidad(id);
    }
    
     @GET
    @Path("{id: \\d+}/citas")
    public List<MedicoDTO> getCitasPorEspecialidad(@PathParam("id") Long id) throws EspecialidadLogicException {
        return espLogic.getDoctoresPorEspecialidad(id);
    }
}
