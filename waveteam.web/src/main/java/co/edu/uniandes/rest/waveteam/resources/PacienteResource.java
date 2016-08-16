/*
 * PatientResource.java
 * Clase que representa el recurso "/patients"
 * Implementa varios métodos para manipular los pacientes
 */
package co.edu.uniandes.rest.waveteam.resources;

import co.edu.uniandes.rest.waveteam.dtos.PatientDTO;
import co.edu.uniandes.rest.waveteam.exceptions.PatientLogicException;
import co.edu.uniandes.rest.waveteam.mocks.PatientLogicMock;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;

/**
 * Clase que implementa el recurso REST correspondiente a "patients".
 *
 * Note que la aplicación (definida en RestConfig.java) define la ruta "/api" y
 * este recurso tiene la ruta "cities". Al ejecutar la aplicación, el recurse
 * será accesibe a través de la ruta "/api/cities"
 *
 * @author je.ardila1501
 */
@Path("patients")
@Produces("application/json")
public class PacienteResource {

    PatientLogicMock patientLogic = new PatientLogicMock();

    /**
     * Obtiene el listado de pacientes.
     *
     * @return lista de pacientes
     * @throws PatientLogicException excepción retornada por la lógica
     */
    @GET
    public List<PatientDTO> getPatients() throws PatientLogicException {
        return patientLogic.getPatients();
    }
    
     /**
     * Obtieneel paciente identificado con el id del parametro
     * @param id
     * @return el paciente cuyo id corresponde al del parametro
     * @throws CityLogicException 
     */
    @GET
    @Path("{id: \\d+}")
    public PatientDTO getPatient (@PathParam("id") Long id) throws PatientLogicException{
        return patientLogic.getPatient(id);
    }
    
    /**
     * 
     * Modifica los atributos del paciente identificado con el id por parametro,
     * de acuerdo a los atributos del objeto ingresado por paramtero
     * @param id
     * @param patient
     * @return el paciente con los nuevos valor(es) de atributo(s) 
     * @throws PatientLogicException
     */
    @PUT
    @Path("{id: \\d+}")
    public PatientDTO updatePatient (@PathParam("id") Long id, PatientDTO patient) throws PatientLogicException{
        return patientLogic.updatePatient(id, patient);
    }
    
    /**
     * elimina el paciente identificado con el id del parametro
     * @param id
     * @throws PatientLogicException 
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deltePatient (@PathParam("id") Long id) throws PatientLogicException{
        patientLogic.deletePatient(id);
    }

    /**
     * Agrega un nuevo paciente
     *
     * @param patient paciente a agregar
     * @return datos del paciente a agregar
     * @throws PatientLogicException cuando ya existe una ciudad con el id
     * suministrado
     */
    @POST
    public PatientDTO createPatient(PatientDTO patient) throws PatientLogicException {
        return patientLogic.createPatient(patient);
    }

  
}
