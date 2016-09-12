/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.waveteam.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author r.garcia11
 */
public class ConsultorioDTO {
    
    private Long id;
    private String horario;
    private boolean atencionUrgencias;
    private boolean unidadCuidadosIntensivos;
    
    // Un consultorio puede estar asignado a muchos doctores
    private List<Long> doctoresAsignados = new ArrayList<Long>();

    /**
     * Constructor vacío
     */
    public ConsultorioDTO()
    {        
    }
    
    /**
     * Constructor con parámetros
     */
    public ConsultorioDTO(Long id, String horario, boolean atencionUrgencias, boolean unidadCuidadosIntensivos)
    {
        this.id = id;
        this.horario = horario;
        this.atencionUrgencias = atencionUrgencias;
        this.unidadCuidadosIntensivos = unidadCuidadosIntensivos;
    }
    
    /**
     * Devuelve el id del consultorio
     */
    public Long getId()
    {
        return id;
    }
    
    /**
     * Cambia el id por el id por parámetro
     * 
     * @param id 
     */
    public void setId(Long id)
    {
        this.id = id;
    }
    
    /**
     * Devuelve el horario
     */
    public String getHorario()
    {
        return horario;   
    }
    
    /**
     * Cambia el horario
     * @param horario 
     */
    public void setHorario(String horario)
    {
        this.horario = horario;
    }
    
    /**
     * Devuelve si atiende urgencias
     * @return 
     */
    public boolean getAtencionUrgencias()
    {
        return atencionUrgencias;
    }
    
    /**
     * Cambia el estado de atención a urgencias
     * 
     * @param atencionUrgencias 
     */
    public void setAtencionUrgencias(boolean atencionUrgencias)
    {
        this.atencionUrgencias = atencionUrgencias;
    }
    
    /**
     * Devuelve si tiene unidad de cuidados intensivos
     */
    public boolean getUnidadCuidadosIntensivos()
    {
        return unidadCuidadosIntensivos;
    }
    
    /**
     * Cambia si tiene UCI
     * @param unidadCuidadosIntensivos 
     */
    public void setUnidadCuidadosIntensivos(boolean unidadCuidadosIntensivos)
    {
        this.unidadCuidadosIntensivos = unidadCuidadosIntensivos;
    }
    
    /**
     * Retorna los doctores asignados a este consultorio
     */
    public List<Long> getDoctoresAsignados(){
        return doctoresAsignados;
    }
    
    /**
     * Edita la lista de doctores asignados con la lista por parámetro
     * @param nuevosDoctores lista de doctores asignados
     */
    public void setDoctoresAsignados(List<Long> nuevosDoctores){
        doctoresAsignados = nuevosDoctores;
    }
    
    public void agregarDoctorAsignado(Long idDoctor)
    {
        doctoresAsignados.add(idDoctor);
    }
    
    public boolean eliminarDoctorAsignado(Long idDoctor)
    {
        for (Long id: doctoresAsignados)
        {
            if (Objects.equals(id, idDoctor))
            {
                doctoresAsignados.remove(id);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Devuelve un String con los parámetros del objeto
     */
    public String toString()
    {
        return "Id: " + id + 
                ", horario: " + horario + 
                ", atiende urgencias: " + (atencionUrgencias?"Si":"No") + 
                ", UCI: " + (unidadCuidadosIntensivos?"Si":"No");
    }
}
