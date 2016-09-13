/*
 * MedicoDTO
 * Objeto de transferencia de datos de Médicos.
 */
package co.edu.uniandes.rest.waveteam.dtos;

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

    /**
     * Convierte el objeto a una cadena
     */
    @Override
    public String toString() {
        return "{ id : " + getId() + ", name : \"" + getName() + "\" }";
    }
}
