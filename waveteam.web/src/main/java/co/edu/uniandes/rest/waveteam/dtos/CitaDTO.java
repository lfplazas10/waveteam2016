/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.waveteam.dtos;

import java.util.Date;

/**
 *
 * @author jm.lizarazo10
 */
public class CitaDTO {
    
    private Long id;
    private Date fecha;
    private Long hora;
    private Long duracion;
    private MedicoDTO medico;
    private PacienteDTO paciente;
    
    
    public CitaDTO(){
        
    }
    
    public CitaDTO(Long id, Date fecha, Long hora, Long duracion, MedicoDTO medico, PacienteDTO paciente){
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
        this.medico = medico;
        this.paciente = paciente; 
        
    }
    
    public Long getId(){
        return id;
    }
    
    
    
    public void setId(Long id){
        this.id = id;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    
    
    public Long getHora(){
        return hora;
    }
    
    
    public void setHora(Long hora){
        this.hora = hora;
    }
    
    
    public Long getDuracion(){
        return duracion;
    }
    
    public void setDuracion(Long duracion){
        this.duracion = duracion;
    }
    
    
    public MedicoDTO getMedico(){
        return medico;
    }
    
    public void setMedico(MedicoDTO medico){
        this.medico = medico;
    }
    
    
    public PacienteDTO getPaciente(){
        return paciente;
    }
    
    
    public void setPaciente(PacienteDTO paciente){
        this.paciente = paciente;
    }
    
    
    
    @Override
    public String toString(){
        return "{ id : " + getId() + ", " + "\n" + "fecha : " + getFecha() + ", "+"\n" + "hora : " + getFecha() + ", "+"\n"+ "duracion : " + getDuracion() + ", " + "\n"+ " medico : " + medico.toString() + ", " + "\n" + "paciente : " + paciente.toString() + " }";
    }
    
    
}
