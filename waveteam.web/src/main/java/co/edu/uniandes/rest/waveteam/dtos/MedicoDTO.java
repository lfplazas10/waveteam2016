/*
 * MedicoDTO
 * Objeto de transferencia de datos de Médicos.
 */
package co.edu.uniandes.rest.waveteam.dtos;

import co.edu.uniandes.rest.waveteam.mocks.MedicoLogicMock;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
/**
 * Objeto de transferencia de datos de Ciudades.
 *
 * @author Asistente
 */
public class MedicoDTO {
    private Long id;
    private String name;
    private String especialidad;
    private Long consultorio;
    
    //Un medico tiene citas
    private List<CitaDTO> disponibilidad = new ArrayList<CitaDTO>();

    /**
     * Constructor por defecto
     */
    public MedicoDTO() {

    }

    public MedicoDTO(Long id, String name, String especialidad, Long consultorio) {
        this.id = id;
        this.name = name;
        this.especialidad = especialidad;
        this.consultorio = consultorio;
        
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Long getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Long consultorio) {
        this.consultorio = consultorio;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    //REQUERIMIENTOS R4 Y R7 - MEDICO Y SUS DISPONIBILIDADES
    
    //Esto es una idea para la disponibilidad
    //Podemos manejarlo con una matriz, o luego con un mapa/tablas de la base de daticos
    public void setDisponibilidad(long inicio, long fin)
    {
        long rango = fin - inicio;
        long cuenta = rango / 900000;
        int r = (int) cuenta;
        for (int i = 0; i < r; i++)
        {
            CitaDTO cita = new CitaDTO();
            cita.setHora(inicio+i*900000);
            cita.setDuracion(15);
            cita.setMedico(this.id);
            cita.desactivar();
            cita.setId(1L);
            cita.setPaciente(1L);
            disponibilidad.add(cita);
        }
    }
    
    public List<CitaDTO> getDisponibilidad()
    {
        return disponibilidad;
    }
            
   
    /**
     * Convierte el objeto a una cadena
     */
    @Override
    public String toString() {
        return "{ id : " + getId() + ", name : \"" + getName() + "\" }";
    }
}
