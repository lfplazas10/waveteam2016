/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.waveteam.resources;
import co.edu.uniandes.rest.waveteam.dtos.CitaDTO;
import co.edu.uniandes.rest.waveteam.exceptions.ConsultorioLogicException;
import co.edu.uniandes.rest.waveteam.mocks.ConsultorioLogicMock;
import co.edu.uniandes.rest.waveteam.dtos.ConsultorioDTO;
import co.edu.uniandes.rest.waveteam.dtos.MedicoDTO;

import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Clase que implementa el recurso REST de "Consultorio"
 * 
 * El path de la clase es /api/consultorios.
 * 
 * @author Rogelio García
 */
@Path("consultorios")
@Produces("application/json")
@Consumes("application/json")
public class ConsultorioResource {
        private final static Logger logger = Logger.getLogger(ConsultorioLogicMock.class.getName());

    ConsultorioLogicMock consultorioLogic = new ConsultorioLogicMock();
    /**
     * Devuelve la lista de los consultorios
     * 
     * @return List de consultorios
     * @throws ConsultorioLogicException 
     */
    @GET
    public List<ConsultorioDTO> getConsultorios() throws ConsultorioLogicException
    {
        return consultorioLogic.getConsultorios();
    }
    
    /**
     * Devuelve un consultorio con el id/nombre dado
     * 
     * @param id
     * @return ConsultorioDTO
     * @throws ConsultorioLogicException 
     */
    @GET
    @Path("{id: \\d+}")
    public ConsultorioDTO getConsultorio(@PathParam("id") long id) throws ConsultorioLogicException
    {
        return consultorioLogic.getConsultorio(id);
    }
    
    /**
     * Actualiza la información de un consultorio con el id/nombre dado
     * 
     * @param id
     * @return ConsultorioDTO
     * @throws ConsultorioLogicException 
     */
    @PUT
    @Path("{id: \\d+}")
    public ConsultorioDTO updateConsultorio(@PathParam("id") long id, ConsultorioDTO updatedConsultorio) throws ConsultorioLogicException            
    {
        return consultorioLogic.updateConsultorio(id, updatedConsultorio);
    }
    
    /**
     * Crea un consultorio con la información dada
     * 
     * @param consultorioNuevo
     * @return ConsultorioDTO
     * @throws ConsultorioLogicException
     */
    @POST
    public ConsultorioDTO createConsultorio(ConsultorioDTO consultorioNuevo) throws ConsultorioLogicException
    {
        return consultorioLogic.createConsultorio(consultorioNuevo);
    }
    
    /**
     * Elimina el consultorio con el id/nombre dado
     * 
     * @param id
     * @throws ConsultorioLogicException 
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteConsultorio(@PathParam("id") long id) throws ConsultorioLogicException
    {
        consultorioLogic.deleteConsultorio(id);
    }
    
    //REQUERIMIENTO R8 - ASIGNAR CONSULTORIO A MEDICO
    
    /**
     * Elimina todos los doctores asignados de un consultorio
     * @param idConsultorio
     * @return
     * @throws ConsultorioLogicException 
     */
    @DELETE
    @Path("{idConsultorio: \\d+}/doctores")
    public ConsultorioDTO unasignDoctors(@PathParam("idConsultorio") long idConsultorio) throws ConsultorioLogicException
    {
        return consultorioLogic.unasignDoctors(idConsultorio);
    }
    
    /**
     * Elimina un doctor asignado de un consultorio
     * @param idConsultorio
     * @param idDoctor
     * @return
     * @throws ConsultorioLogicException 
     */
    @DELETE
    @Path("{idConsultorio: \\d+}/doctores/{idDoctor: \\d+}")
    public ConsultorioDTO unasignDoctor(@PathParam("idConsultorio") long idConsultorio, @PathParam("idDoctor") long idDoctor) throws ConsultorioLogicException
    {
        return consultorioLogic.unasignDoctor(idConsultorio, idDoctor);
    }
    
    /**
     * Asigna un nuevo doctor al consultorio
     * @param idConsultorio
     * @param idDoctor
     * @return
     * @throws ConsultorioLogicException 
     */
    @POST
    @Path("{idConsultorio: \\d+}/doctores")
    public ConsultorioDTO asignDoctor(@PathParam("idConsultorio") long idConsultorio, MedicoDTO doc) throws ConsultorioLogicException
    {

        return consultorioLogic.asignDoctor(idConsultorio, doc);
    }
    
    /**
     * Asigna doctores al consultorio
     * @param idConsultorio
     * @param idDoctor
     * @return
     * @throws ConsultorioLogicException 
     */
    @PUT
    @Path("{idConsultorio: \\d+}/doctores")
    public ConsultorioDTO asignDoctors(@PathParam("idConsultorio") long idConsultorio, List<MedicoDTO> nuevaLista) throws ConsultorioLogicException
    {
        return consultorioLogic.asignDoctors(idConsultorio, nuevaLista);
    }
}
