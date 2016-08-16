/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.waveteam.mocks;
/**
 * Mock del recurso Citas
 * 
 * 
 */
import co.edu.uniandes.rest.waveteam.dtos.CitaDTO;
import co.edu.uniandes.rest.waveteam.dtos.MedicoDTO;
import co.edu.uniandes.rest.waveteam.exceptions.CitaLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

/**
 *
 * @author jm.lizarazo10
 */
public class AppLogicMock {
    
    private final static Logger logger = Logger.getLogger(AppLogicMock.class.getName());    

    private static ArrayList<CitaDTO> citas;
    
    
    public AppLogicMock(){
        
        if(citas==null){
            citas = new ArrayList<>();
            citas.add(new CitaDTO("1", new Date(), "0700", "30", new MedicoDTO(), new PacienteDTO()));
            citas.add(new CitaDTO("2", new Date(), "0900", "15", new MedicoDTO(), new PacienteDTO()));
        }    
        
        
        logger.setLevel(Level.INFO);
        
        logger.info("Se inicia la lista de citas");
        logger.info("Citas: " + citas);
        }
    
    public List<CitaDTO> getCitas() throws CitaLogicException {
        if(citas==null){
            logger.severe("Error obteniendo citas, la lista no está inicializada");
            throw new CitaLogicException("Error obteniendo citas, la lista no está inicializada");
            
        }
        logger.info("Retornando todas las citas");
        return citas;
        
        
    }
    
    
    public CitaDTO getCita(Long id) throws CitaLogicException{
     
        if(citas==null){
            logger.severe("Error obteniendo citas, la lista no está inicializada");
            throw new CitaLogicException("Error obteniendo citas, la lista no está inicializada");
            
        }
        
        for(CitaDTO cita : citas){
            
            if(id.equals(cita.getId())){
            } else {
                logger.info("Retornando cita con ID: " + id);
                return cita;
            }
        }
        logger.info("No se encontró una cita con ese ID");        
        throw new CitaLogicException("No se encontró una cita con ese ID");
        
        
    }
    
    
    public CitaDTO updateCita(Long id, CitaDTO nueva) throws CitaLogicException{
      if(citas==null){
            logger.severe("Error obteniendo citas, la lista no está inicializada");
            throw new CitaLogicException("Error obteniendo citas, la lista no está inicializada");
            
        }
      boolean encontrado = false;
      if(nueva.getId()!=null){
          for(CitaDTO cita : citas){
           
              if(id.equals(cita.getId())){
               
                  logger.info("Actualizando la inforamcion de la cita con id: ");
                  cita.setId(nueva.getId());
                  cita.setFecha((nueva.getFecha()));
                  cita.setHora(nueva.getHora());
                  cita.setDuracion(nueva.getDuracion());
                  cita.setMedico(nueva.getMedico());
                  cita.setPaciente(nueva.getPaciente());
                  encontrado = true;
                  break;
              }
          }
          if(!encontrado){
           
              logger.severe("No se encontró una cita con el ID solicitado");
              throw new CitaLogicException("No se encontró una cita con el ID solicitado");
          }
      }
          else{
           
              logger.severe("Error con el id ingresado");
              throw new CitaLogicException("Error con el id ingresado");
          }
          
          
        logger.info("Retornando el octor actualizado");
        return nueva;
    
        
    }
    
    
    public CitaDTO crearCita(CitaDTO nueva) throws CitaLogicException {
        
        logger.info("Se trata de agregar una nueva cita: " + nueva);
        
        if(nueva.getId()!=null){
            for(CitaDTO cita : citas){
                if(cita.getId().equals(nueva.getId())){
                    logger.severe("Una cita con ese id ya existe en la lista");
                    throw new CitaLogicException("Una cita con ese id ya existe en la lista");
                }
            }
        }
        else {
            logger.severe("El ID suministrado no es coherente");
            throw new CitaLogicException("El ID suministrado no es coherente");
        }
        
        logger.info("Creando la cita " + nueva);
        citas.add(nueva);
        return nueva;
        
    }
    
    
    
    public void deleteCita(Long id) throws CitaLogicException{
        if(citas==null){
            logger.severe("La lista de citas no ha sido inicializada");
            throw new CitaLogicException("La lista de citas no ha sido inicializada");
        }
        for(CitaDTO cita : citas){
            if(id.equals(cita.getId())){
                logger.info("Se borra la cita con ID: " + id);
                citas.remove(cita);
                return;
            }
        }
        logger.info("No se encontró una cita con ese ID");
        throw new CitaLogicException("No se encontró una cita con ese ID");
    }
    


}
