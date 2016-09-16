/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.waveteam.dtos;

/**
 *
 * @author d.marino10
 */
public class ConsultaHistoricaDTO {
    
    private EspecialidadDTO especialidad;
    private int numeroDoctores;
    private int numeroCitas;
    private int promedioDuracion;
    private int citasLibres;
    
    public ConsultaHistoricaDTO(){
        
    }
    
    public ConsultaHistoricaDTO(EspecialidadDTO es,int numDoc,int numCitas,int prom,int citasLi){
        this.especialidad=es;
        this.numeroDoctores=numDoc;
        this.numeroCitas=numCitas;
        this.promedioDuracion=prom;
        this.citasLibres=citasLi;
    }
    
    
        
}
