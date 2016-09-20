/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.waveteam.dtos;


import java.util.ArrayList;

/**
 *
 * @author jm.lizarazo10
 */
public class CitaDTO {

    public ArrayList a = new ArrayList();

    
    private Long id;
    private String fecha;
    private Long hora;
    private int duracion;
    private Long medico;
    private Long paciente;
    private boolean habilitada;
    
    
    public CitaDTO(){
        
    }
    
    public CitaDTO(Long id, String fecha, Long hora, int duracion, Long medico, Long paciente){
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
        this.medico = medico;
        this.paciente = paciente; 
        this.habilitada = true;

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
        return medico;
    }
    
    public void setMedico(Long medico){
        this.medico = medico;
    }
    
    
    public Long getPaciente(){
        return paciente;
    }
    
    
    public void setPaciente(Long paciente){
        this.paciente = paciente;
    }
    
    
    public void desactivar(){
        this.habilitada = false;
    }
    
    public boolean getHabilitada(){
        return this.habilitada;
    }

    public void addSm(Long t){
        a.add(t);
    }
    
    
    @Override
    public String toString(){

        return  "{ id : " + id +
                ", fecha : " + fecha + 
                ", hora : " +hora + 
                ", duracion : " + duracion + 
                ", medico : " + medico + 
                ", paciente : " + paciente +
                ", habilitada : " + habilitada
                +" }";
    }
    
    
}
