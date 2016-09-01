/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.waveteam.mocks;

import co.edu.uniandes.rest.waveteam.dtos.EspecialidadDTO;
import co.edu.uniandes.rest.waveteam.exceptions.EspecialidadLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author d.marino10
 */
public class EspecialidadLogicMock {
 
    // objeto para presentar logs de las operaciones
    private final static Logger logger = Logger.getLogger(EspecialidadLogicMock.class.getName());

    private static ArrayList<EspecialidadDTO> especialidades;
    
    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public EspecialidadLogicMock() {

        if (especialidades == null) {
            especialidades = new ArrayList<>();
            especialidades.add(new EspecialidadDTO(1L, "Pediatria", "0-18", "clinica"));
            especialidades.add(new EspecialidadDTO(2L, "neurocirugia", "0-95", "quirurgica"));
        }

        // indica que se muestren todos los mensajes
        logger.setLevel(Level.INFO);

        // muestra información 
        logger.info("Inicializa la lista de especialidades");
        logger.info("Especialidades: " + especialidades);
    }
    /**
     * Obtiene el listado de especialidades.
     *
     * @return lista de especialidades
     * @throws EspecialidadLogicException cuando no existe la lista en memoria
     */
    public List<EspecialidadDTO> getEspecialidades() throws EspecialidadLogicException {
        if (especialidades == null) {
            logger.severe("Error interno: lista de especialidades no existe.");
            throw new EspecialidadLogicException("Error interno: lista de especialidades no existe.");
        }

        logger.info("Retornando todas las especialidades");
        return especialidades;
    }

    public EspecialidadDTO getEspecialidad(Long id) throws EspecialidadLogicException {
        if (especialidades == null) {
            logger.severe("Error interno: lista de especialidades no existe.");
            throw new EspecialidadLogicException("Error interno: lista de especialidades no existe.");
        }

        for (EspecialidadDTO especialidad : especialidades) {
            if (Objects.equals(id, especialidad.getId())) {
                logger.info("Retornando la especialidad con ID " + id);
                return especialidad;
            }
        }
        logger.info("No se encontro especialidad con ese ID");
        throw new EspecialidadLogicException("No existe especialidad con ese ID");
    }

    public EspecialidadDTO updateEspecialidad(Long id, EspecialidadDTO updatedEsp) throws EspecialidadLogicException {
        if (especialidades == null) {
            logger.severe("Error interno: lista de especialidades no existe.");
            throw new EspecialidadLogicException("Error interno: lista de especialidades no existe.");
        }

        boolean found = false;
        if (updatedEsp.getId() != null) {
            for (EspecialidadDTO especialidad : especialidades) {
                if (Objects.equals(id, especialidad.getId())) {
                    logger.info("Actualizando informacion de la especialidad con");
                    especialidad.setId(updatedEsp.getId());
                    especialidad.setNombre(updatedEsp.getNombre());
                    especialidad.setGruposEdad(updatedEsp.getGruposEdad());
                    especialidad.setTipo(updatedEsp.getTipo());
                    found = true;
                    break;
                }
            }
            if (!found) {
                logger.severe("No se encontro una especialidad con ese ID");
                throw new EspecialidadLogicException("No existe una especialidad con ese ID");
            }

        } else {
            logger.severe("El ID dado es nulo");
            throw new EspecialidadLogicException("El id es nulo");

        }
        logger.info("Retornando la especialidad actualizada");
        return updatedEsp;
    }

    /**
     * Agrega una especialidad a la lista.
     *
     * @param newEsp especialidad a adicionar
     * @throws EspecialidadLogicException cuando ya existe una especialidad con el id
     * suministrado
     * @return Especialidad agregada
     */
    public EspecialidadDTO createEspecialidad(EspecialidadDTO newEsp) throws EspecialidadLogicException {
        logger.info("Recibiendo solicitud de agregar especiaidad " + newEsp);

        if (newEsp.getId() != null) {
            for (EspecialidadDTO especialidad : especialidades) {
                if (Objects.equals(especialidad.getId(), newEsp.getId())) {
                    logger.severe("Ya existe una especialidad con ese id");
                    throw new EspecialidadLogicException("Ya existe una especialidad con ese id");
                }
            }

        } else {
            logger.severe("El ID suministrado es nulo, se agrega con id maximo");
            long nuevoid=(long)especialidades.size()+1;
            newEsp.setId(nuevoid);
        }

        logger.info("Agregando especialidad " + newEsp);
        especialidades.add(newEsp);
        return newEsp;
    }
    
    public void deleteEspecialidad(Long id) throws EspecialidadLogicException{
        if (especialidades == null) {
            logger.severe("Error interno: lista de especialidades no existe.");
            throw new EspecialidadLogicException("Error interno: lista de especialidades no existe.");
        }
        for (EspecialidadDTO especialidad : especialidades) {
            if (Objects.equals(id, especialidad.getId())) {
                logger.info("Borrando la especialidad con ID "+id);
                especialidades.remove(especialidad);
                return;
            }
        }
        logger.info("No se encontro una especialidad con ese ID");
        throw new EspecialidadLogicException("No existe una especialidad con ese ID");
    }
}
