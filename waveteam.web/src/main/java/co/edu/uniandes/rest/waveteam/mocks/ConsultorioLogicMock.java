/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.waveteam.mocks;

import co.edu.uniandes.rest.waveteam.dtos.ConsultorioDTO;
import co.edu.uniandes.rest.waveteam.exceptions.ConsultorioLogicException;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ConsultorioLogicMock. Mock del servicio REST del recurso Consultorio.
 * 
 * @author Rogelio García
 */
public class ConsultorioLogicMock {
    // objeto para imprimir logs de las operaciones
    private final static Logger logger = Logger.getLogger(ConsultorioLogicMock.class.getName());
    
    private static ArrayList<ConsultorioDTO> consultorios;
    
    /**
     * Constructor de los consultorios de prueba
     */
    public ConsultorioLogicMock(){
        if (consultorios == null)
        {
            consultorios = new ArrayList<>();
            consultorios.add(new ConsultorioDTO(202L, "8:00am-6:00pm", false, true));
            consultorios.add(new ConsultorioDTO(315L, "8:00am-6:00pm", false, false));
            consultorios.add(new ConsultorioDTO(100L, "24 horas", true, false));
        }
        
        logger.setLevel(Level.INFO);
        logger.info("Inicializa la lista de consultorios");
        logger.info("Consultorios: " + consultorios);
    }
    
    /**
     * Devuelve el listado de consultorios.
     *
     * @return List de consultorios
     * @throws ConsultorioLogicException
     */
    public List<ConsultorioDTO> getConsultorios() throws ConsultorioLogicException {
        if (consultorios == null) {
            logger.severe("Error interno: la lista de consultorios no existe.");
            throw new ConsultorioLogicException("Error interno: lista de consultorios no existe.");
        }
        logger.info("Retornando la lista de consultorios");
        return consultorios;
    }

    /**
     * Devuelve el consultorio con el id dado
     * 
     * @return ConsultorioDTO
     * @throws ConsultorioLogicException
     */
    public ConsultorioDTO getConsultorio(Long id) throws ConsultorioLogicException
    {
        if (consultorios == null) {
            logger.severe("Error interno: la lista de consultorios no existe.");
            throw new ConsultorioLogicException("Error interno: lista de consultorios no existe.");
        }  
        for (ConsultorioDTO consultorio : consultorios) {
            if (Objects.equals(id, consultorio.getId())) {
                logger.info("Retornando el consultorio con ID " + id);
                return consultorio;
            }
        }
        logger.info("No se encontro consultorio con ese ID");
        throw new ConsultorioLogicException("No existe consultorio con ese ID");
    }
    
    /**
     * Actualiza un consultorio con el id dado, con la información dada
     * 
     * @param Long id
     * @param ConsultorioDTO updatedConsultorio
     * @return ConsultorioDTO consultorio actualizado
     * @throws ConsultorioLogicException 
     */
    public ConsultorioDTO updateConsultorio (Long id, ConsultorioDTO updatedConsultorio) throws ConsultorioLogicException
    {
        if (consultorios == null) {
            logger.severe("Error interno: la lista de consultorios no existe.");
            throw new ConsultorioLogicException("Error interno: lista de consultorios no existe.");
        }  
        for (ConsultorioDTO consultorio : consultorios) {
            if (Objects.equals(id, consultorio.getId())) {
                consultorio.setId(updatedConsultorio.getId());
                consultorio.setHorario(updatedConsultorio.getHorario());
                consultorio.setAtencionUrgencias(updatedConsultorio.getAtencionUrgencias());
                consultorio.setUnidadCuidadosIntensivos(updatedConsultorio.getUnidadCuidadosIntensivos());
                
                logger.info("Retornando el consultorio actualizado con ID " + id);
                return consultorio;
            }
        }
        logger.info("No se encontro consultorio con ese ID");
        throw new ConsultorioLogicException("No existe consultorio con ese ID");
    }
    
    /**
     * Crea el consultorio con la información dada
     * 
     * @param Consultorio DTO newConsultorio
     * @return ConsultorioDTO newConsultorio
     * @throws ConsultorioLogicException 
     */
    public ConsultorioDTO createConsultorio (ConsultorioDTO newConsultorio) throws ConsultorioLogicException
    {
        logger.info("Creando un consultorio nuevo");
        if (consultorios == null) {
            logger.severe("Error interno: la lista de consultorios no existe.");
            throw new ConsultorioLogicException("Error interno: lista de consultorios no existe.");
        }  
        else if(newConsultorio.getId() == null)
        {
            logger.severe("El ID suministrado es nulo");
            throw new ConsultorioLogicException("Debe suministrar un ID válido");
        }
        else
        {
            for (ConsultorioDTO consultorio : consultorios) {
                if (Objects.equals(newConsultorio.getId(), consultorio.getId())) {
                    logger.info("Ya hay un consultorio con ID " + newConsultorio.getId());
                    throw new ConsultorioLogicException("Debe ingresar un id válido.");
                }
            }
            logger.info("Agregando el consultorio " + newConsultorio);
            consultorios.add(newConsultorio);
            return newConsultorio;
        }
    }
    
    /**
     * Elimina el consultorio con el id dado
     * 
     * @param id del consultorio
     * @throws ConsultorioLogicException 
     */
    public void deleteConsultorio (long id) throws ConsultorioLogicException
    {
        logger.info("Eliminando consultorio");
        if (consultorios == null) {
            logger.severe("Error interno: la lista de consultorios no existe.");
            throw new ConsultorioLogicException("Error interno: lista de consultorios no existe.");
        }
        
        for (ConsultorioDTO consultorio : consultorios) {
            if (Objects.equals(id, consultorio.getId())) {
                logger.info("Se encontró consultorio con ID " + id +", eliminando.");
                consultorios.remove(consultorio);
                return;
            }
        }
        
        logger.info("No se encontró un consultorio con el ID "+ id);
        throw new ConsultorioLogicException("Ingrese un consultorio con un id correcto");
    }
}
