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
import co.edu.uniandes.rest.waveteam.dtos.PatientDTO;
import co.edu.uniandes.rest.waveteam.exceptions.CitaLogicException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class CitaLogicMock {
    
    private final static Logger logger = Logger.getLogger(CitaLogicMock.class.getName());    

    private static ArrayList<CitaDTO> citas;
    private Long a = 2L;
    
    
    public CitaLogicMock(){
        
        if(citas==null){
            citas = new ArrayList<>();
            
            
            citas.add(new CitaDTO(1L, "17/08/2016", 700L, 30,1L , 1L));
            citas.add(new CitaDTO(2L, "18/8/2016", 900L,15, 2L, 2L));
            citas.add(new CitaDTO(3L, "19/8/2016", 1100L,15, 1L,2L));
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
            
            if(Objects.equals(id, cita.getId())){
                logger.info("Retornando la cita con id: " + id);
                return cita;
            
        }
        }
        logger.info("No se encontró una cita con ese ID");        
        throw new CitaLogicException("No se encontró una cita con ese ID");
        
        
    }
    
    
    
    public CitaDTO updateCita(Long id, CitaDTO nueva) throws CitaLogicException
    {
      if(citas==null){
            logger.severe("Error obteniendo citas, la lista no está inicializada");
            throw new CitaLogicException("Error obteniendo citas, la lista no está inicializada");
            
        }      
      
        for(CitaDTO cita : citas){
           
            if(Objects.equals(id, cita.getId())){
               
                logger.info("Actualizando la informacion de la cita con id: ");
                cita.setId(nueva.getId());
                cita.setFecha((nueva.getFecha()));
                cita.setHora(nueva.getHora());
                cita.setDuracion(nueva.getDuracion());
                cita.setMedico(nueva.getMedico());
                cita.setPaciente(nueva.getPaciente());
               
                return cita;
              }
          }
          
           
            logger.severe("No se encontró una cita con el ID solicitado");
            throw new CitaLogicException("No se encontró una cita con el ID solicitado");
          
      }
         
          
          
      
    
    
    public CitaDTO crearCita(CitaDTO nueva) throws CitaLogicException {
        
        logger.info("Se trata de agregar una nueva cita: " + nueva);
        
        if(citas==null){
            
              
            logger.severe("La lista de citas no existe");
            throw new CitaLogicException("La lista de citas no existe");
                
            
        }
        else if(nueva.getId()==null){
            logger.severe("El ID no es valido");
            throw new CitaLogicException("Debe ingresar un ID válido");
        }
        else{
            for (CitaDTO cita : citas) {
                if (Objects.equals(nueva.getId(), cita.getId())) {
                    logger.info("Ya hay un consultorio con ID " + nueva.getId());
                    throw new CitaLogicException("Debe ingresar un id válido.");
                }
            }
        
        
        logger.info("Creando la cita " + nueva);
        citas.add(nueva);
        return nueva;
        }
        
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
