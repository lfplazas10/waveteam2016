package co.edu.uniandes.rest.waveteam.mocks;

/**
 * Mock del recurso Patient (Mock del servicio REST)
 *
 * @author je.ardila1501
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import co.edu.uniandes.rest.waveteam.dtos.PatientDTO;
import co.edu.uniandes.rest.waveteam.exceptions.PatientLogicException;

/*
 * CityLogicMock
 * Mock del recurso Patient (Mock del servicio REST)
 */
public class PatientLogicMock {

    // objeto para presentar logs de las operaciones
    private final static Logger logger = Logger.getLogger(PatientLogicMock.class.getName());

    private static ArrayList<PatientDTO> patients;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public PatientLogicMock() {

        if (patients == null) {
            patients = new ArrayList<>();
            patients.add(new PatientDTO(1L, "Pepe Pombo", 35 , "Hombre", "A-", "SaludCoop"));
            patients.add(new PatientDTO(2L, "Magdalena Mejia", 28 , "Mujer", "o+", "CafeSalud"));
            patients.add(new PatientDTO(3L, "Silvio Salgar", 52 , "Hombre", "b-", "SonrisaSalud"));
        }

        // indica que se muestren todos los mensajes
        logger.setLevel(Level.INFO);

        // muestra información 
        logger.info("Inicializa la lista de patients");
        logger.info("Patients: " + patients);
    }
    
    
    /**
	 * Obtiene el listado de pacientes. 
	 * @return lista de pacientes
	 * @throws PatientLogicException cuando no existe la lista en memoria  
	 */    
    public List<PatientDTO> getPatients() throws PatientLogicException {
    	if (patients == null) {
    		logger.severe("Error interno: lista de pacientes no existe.");
    		throw new PatientLogicException("Error interno: lista de pacientes no existe.");    		
    	}
    	
    	logger.info("retornando todas los pacientes");
    	return patients;
    }

    /**
     * obtiene un paciente de la lista
     * @param id de laciudad
     * @throw PatientLogicException cuando no existe un paciente con el id suministrado
     * @return paciente correspondiente al id ingresado por parametro
     */
    public PatientDTO getPatient(long id) throws PatientLogicException{
        if (patients==null){
            throw  new PatientLogicException("Error Interno: lista de pacientes no existe");
        }
            for (PatientDTO patient : patients){
                if(patient.getId().equals(id)){
                return patient;
                }    
               }
      throw  new PatientLogicException("El numero de identificacion (id) ingresado: " + id + 
              " no corresponde a ninguna ciudad");
    }
    
    /**
     * elimina un paciente de la lista
     * @param id del paciente
     * @throw PatientLogicException cuando no existe un paciente con el id suministrado
     */
    
    public void deletePatient(long id) throws PatientLogicException{
        if (patients==null){
            throw  new PatientLogicException("Error Interno: lista de pacientes no existe");
        }
        
            for (PatientDTO patient : patients) {
                if(patient.getId().equals(id)){
                    patients.remove(patient);
                    logger.info("el paciente con id: "+id+" ha sido eliminada");
                    return;
                } 
                
            }
        throw  new PatientLogicException("El numero de identificacion (id) ingresado: " + id + 
                " no corresponde a ningun paciente");
            
    }
    
    
    /**
     * actualiza la informacion de un paciente
     * @param id del paciente
     * @param pPatient objeto tipo paciente
     * @throw PatientLogicException cuando no existe un paciente con el id suministrado
     * @return paciente con la informacion actualizada
     */
    
    public PatientDTO updatePatient (long id, PatientDTO pPatient) throws PatientLogicException{
        PatientDTO patientTmp = new PatientDTO();
        boolean cambio=false;
        
        if (pPatient.getId()==null || pPatient.getName()==null || pPatient.getEdad()<=0 ||
                pPatient.getSexo()==null || pPatient.getEps()==null || pPatient.getTipoSangre()==null){
            throw  new PatientLogicException("Error: ninguno atributo del paciente puede ser null "
                    + "o su edad no pude ser menor o igual a cero");
        }
        if (patients==null){
            throw  new PatientLogicException("Error Interno: lista de pacientes no existe");
        }
       
            for (PatientDTO patient : patients) {
                if(pPatient.getId().equals(patient.getId()) && (id!=pPatient.getId())){
                    throw  new PatientLogicException("Error: el nuevo codigo de identificacion (id): "
                            + ""+pPatient.getId()+" ya esta asiganado a otra ciudad");
                }
                else if(patient.getId().equals(id)){
                    patient.setName(pPatient.getName());
                    patient.setId(pPatient.getId());
                    patient.setEdad(pPatient.getEdad());
                    patient.setSexo(pPatient.getSexo());
                    patient.setEps(pPatient.getEps());
                    patient.setTipoSangre(pPatient.getTipoSangre());
                    cambio=true;
                    patientTmp=patient;
                    
                }
                else if(!cambio){
                    throw  new PatientLogicException("El numero de identificacion (id) ingresado: " + id +
                            " no corresponde a ningun paciente");
                }
            }
        
        return patientTmp;
    }
    
    /**
     * Agrega un paciente a la lista.
     * @param newPatient paciente a adicionar
     * @throws PatientLogicException cuando ya existe un paciente con el id suministrado
     * @return paciente agregado
     */
    public PatientDTO createPatient(PatientDTO newPatient) throws PatientLogicException {
    	logger.info("recibiendo solicitud de agregar paciente " + newPatient);
    	
    	// nuevo paciente tiene id ?
    	if ( newPatient.getId() != null ) {
	    	// busca el paciente con el id suministrado
	        for (PatientDTO patient : patients) {
	        	// si existe un paciente con ese id
	            if (Objects.equals(patient.getId(), newPatient.getId())){
	            	logger.severe("Ya existe una ciudad con ese id");
	                throw new PatientLogicException("Ya existe una ciudad con ese id");
	            }
	        }
	        
	    //el nuevo paciente no tiene id ? 
    	} else {

    		// genera un id para el paciente
    		logger.info("Generando id para el nuevo paciente");
    		long newId = 1;
	        for (PatientDTO city : patients) {
	            if (newId <= city.getId()){
	                newId =  city.getId() + 1;
	            }
	        }
	        newPatient.setId(newId);
    	}
    	
        // agrega el paciente
    	logger.info("agregando paciente " + newPatient);
        patients.add(newPatient);
        return newPatient;
    }

    
}