/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.waveteam.dtos;

import java.util.Date;
import co.edu.uniandes.rest.waveteam.dtos.PatientDTO;

/**
 *
 * @author jm.lizarazo10
 */
public class CitaDTO {
    
    private Long id;
    private String fecha;
    private Long hora;
    private int duracion;
    private Long idMedico;
    private Long idPaciente;
    
    
    public CitaDTO(){
        
    }
    
    public CitaDTO(Long id, String fecha, Long hora, int duracion, Long medico, Long paciente){
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
        this.idMedico = medico;
        this.idPaciente = paciente; 
        
    }
    
    public Long getId(){
        return id;
    }
    
    
    
    public void setId(Long id){
        this.id = id;
    }
    
    public String getFecha(){
        return fecha;
    }
    
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    
    
    public Long getHora(){
        return hora;
    }
    
    
    public void setHora(Long hora){
        this.hora = hora;
    }
    
    
    public int getDuracion(){
        return duracion;
    }
    
    public void setDuracion(int duracion){
        this.duracion = duracion;
    }
    
    
    public Long getMedico(){
        return idMedico;
    }
    
    public void setMedico(Long medico){
        this.idMedico = medico;
    }
    
    
    public Long getPaciente(){
        return idPaciente;
    }
    
    
    public void setPaciente(Long paciente){
        this.idPaciente = paciente;
    }
    
    
    
    @Override
    public String toString(){
        return  "id : " + id +
                ", fecha : " + fecha + 
                ", hora : " +hora + 
                ", duracion : " + duracion + 
                ",  medico : " + idMedico + 
                ", paciente : " + idPaciente
                ;
    }
    
    
}
