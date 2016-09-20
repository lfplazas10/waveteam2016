/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.waveteam.mocks;

import co.edu.uniandes.rest.waveteam.dtos.CitaDTO;
import co.edu.uniandes.rest.waveteam.dtos.ConsultaHistoricaDTO;
import co.edu.uniandes.rest.waveteam.dtos.EspecialidadDTO;
import co.edu.uniandes.rest.waveteam.exceptions.ConsultaHistoricaLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author d.marino10
 */
public class ConsultaHistoricaLogicMock {
    
     // objeto para presentar logs de las operaciones
    private final static Logger logger = Logger.getLogger(EspecialidadLogicMock.class.getName());
    private static ArrayList<ConsultaHistoricaDTO> consultasHistoricas;
    
    public ConsultaHistoricaLogicMock()
    {
        if (consultasHistoricas == null) {
            consultasHistoricas = new ArrayList<ConsultaHistoricaDTO>();
            consultasHistoricas.add(new ConsultaHistoricaDTO(new EspecialidadDTO(1L, "Cardiologia", "0-95", "clinica",new ArrayList(),new ArrayList<CitaDTO>()),0,0,0,0));
        }
        
        // indica que se muestren todos los mensajes
        logger.setLevel(Level.INFO);

        // muestra información 
        logger.info("Inicializa la lista de consultasHistoricas");
        logger.info("consultasHistoricas: " + consultasHistoricas);
    }
    
    /**
     * Obtiene el listado de especialidades.
     *
     * @return lista de especialidades
     * @throws EspecialidadLogicException cuando no existe la lista en memoria
     */
    public List<ConsultaHistoricaDTO> getConsultasHisotircas() throws ConsultaHistoricaLogicException {
        if (consultasHistoricas == null) {
            logger.severe("Error interno: lista de consultasHistoricas no existe.");
            throw new ConsultaHistoricaLogicException("Error interno: lista de consultasHistoricas no existe.");
        }

        logger.info("Retornando todas las consultasHistoricas");
        return consultasHistoricas;
    }

    public ConsultaHistoricaDTO getConsultaHistorica(String nombreEspecialidad) throws ConsultaHistoricaLogicException {
        if (consultasHistoricas == null) {
            logger.severe("Error interno: lista de consultasHistoricas no existe.");
            throw new ConsultaHistoricaLogicException("Error interno: lista de consultasHistoricas no existe.");
        }

        for (ConsultaHistoricaDTO consultaHistorica : consultasHistoricas) {
            if (Objects.equals(nombreEspecialidad, consultaHistorica.getEspecialidad().getNombre())) {
                logger.info("Retornando la consultaHistorica de la especialidad" + nombreEspecialidad);
                return consultaHistorica;
            }
        }
        logger.info("No se encontro consultaHistorica de esa especialidad");
        throw new ConsultaHistoricaLogicException("No existe consultaHistorica con esa especialidad");
    }

    public ConsultaHistoricaDTO updateConsultaHistorica(String nombreEsp, ConsultaHistoricaDTO updated) throws ConsultaHistoricaLogicException {
        if (consultasHistoricas == null) {
            logger.severe("Error interno: lista de consultasHistoricas no existe.");
            throw new ConsultaHistoricaLogicException("Error interno: lista de consultasHistoricas no existe.");
        }

        boolean found = false;
        if (updated.getEspecialidad() != null) {
            for (ConsultaHistoricaDTO consulta : consultasHistoricas) {
                if (Objects.equals(nombreEsp, consulta.getEspecialidad().getNombre())) {
                    logger.info("Actualizando informacion de la consultaHistorica con");
                    consulta.setEspecialidad(updated.getEspecialidad());
                    consulta.setNumeroDoctores(updated.getNumeroDoctores());
                    consulta.setNumeroCitas(updated.getNumeroCitas());
                    consulta.setPromedioDuracion(updated.getPromedioDuracion());
                    consulta.setCitasLibres(updated.getCitasLibres());
                    found = true;
                    break;
                }
            }
            if (!found) {
                logger.severe("No se encontro una consultaHistorica con esa especialidad");
                throw new ConsultaHistoricaLogicException("No existe una consultaHistorica con esea especialidad");
            }

        } else {
            logger.severe("El nombre de la");
            throw new ConsultaHistoricaLogicException("El id es nulo");

        }
        logger.info("Retornando la consultaHistorica actualizada");
        return updated;
    }

    /**
     * Agrega una especialidad a la lista.
     *
     * @param newEsp consultaHistorica a adicionar
     * @throws EspecialidadLogicException cuando ya existe una especialidad con el id
     * suministrado
     * @return Especialidad agregada
     */
    public ConsultaHistoricaDTO createConsultaHistorica(ConsultaHistoricaDTO newEsp) throws ConsultaHistoricaLogicException {
        logger.info("Recibiendo solicitud de agregar consultaHistorica " + newEsp);

        if (newEsp.getEspecialidad() != null) {
            for (ConsultaHistoricaDTO consulta : consultasHistoricas) {
                if (Objects.equals(consulta.getEspecialidad().getNombre(), newEsp.getEspecialidad().getNombre())) {
                    logger.severe("Ya existe una consultaHistorica para esa especialidad, se borra la consulta historica anterior");
                    deleteConsultaHistorica(consulta.getEspecialidad().getNombre());
                }
            }

        } else {
            logger.severe("La especialidad suministrada es nula");
            throw new ConsultaHistoricaLogicException("no se puede crear una consutaHistorica sin una especialidad");
        }

        logger.info("Agregando consultaHistorica " + newEsp);
        consultasHistoricas.add(newEsp);
        return newEsp;
    }
    
    public void deleteConsultaHistorica(String nombreEsp) throws ConsultaHistoricaLogicException{
        if (consultasHistoricas == null) {
            logger.severe("Error interno: lista de consultasHistoricas no existe.");
            throw new ConsultaHistoricaLogicException("Error interno: lista de consultasHistoricas no existe.");
        }
        for (ConsultaHistoricaDTO consulta : consultasHistoricas) {
            if (Objects.equals(nombreEsp, consulta.getEspecialidad().getNombre())) {
                logger.info("Borrando la consultaHistorica de la especialidad "+nombreEsp);
                consultasHistoricas.remove(consulta);
                return;
            }
        }
        logger.info("No se encontro una  consultaHistorica para esa especialidad");
        throw new ConsultaHistoricaLogicException("No existe una  consultaHistorica para esa especialidad");
    }
}
