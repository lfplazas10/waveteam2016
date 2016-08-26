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
public class AppLogicMock {
    
    private final static Logger logger = Logger.getLogger(AppLogicMock.class.getName());    

    private static ArrayList<CitaDTO> citas;
    private Long a = 2L;
    
    
    public AppLogicMock() throws ParseException{
        
        if(citas==null){
            citas = new ArrayList<>();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date d = sdf.parse("17/08/2016");
            Date e = sdf.parse("18/8/2016");
            Date f = sdf.parse("19/8/2016");
            
            citas.add(new CitaDTO(1L, "17/08/2016", 700L, 30, new MedicoDTO(1L, "Pedro Pablo Jaramillo", "Cardiólogo", 301L), new PatientDTO(1L, "Pepe Pombo", 35 , "macho", "A-", "SaludCoop")));
            citas.add(new CitaDTO(2L, "18/8/2016", 900L, 15, new MedicoDTO(2L, "Jairo Aristizabal", "Neumólogo", 305L), new PatientDTO(2L, "Magdalena Mejia", 28 , "hembra", "o+", "CafeSalud")));
            citas.add(new CitaDTO(3L, "19/8/2016", 1100L, 40, new MedicoDTO(3L, "Fernando Vallejo", "Traumatólogo", 320L), new PatientDTO(3L, "Silvio Salgar", 52 , "macho", "b-", "SonrisaSalud")));
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
