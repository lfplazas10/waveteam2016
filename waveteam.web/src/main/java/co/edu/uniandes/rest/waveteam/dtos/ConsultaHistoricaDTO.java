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
    private int citasCanceladas;
    private int citasTerminadas;
    
    public ConsultaHistoricaDTO(){
        
    }
    
    public ConsultaHistoricaDTO(EspecialidadDTO es,int numDoc,int numCitas,int prom,int citasLi,int citasCan,int citasTer){
        this.especialidad=es;
        this.numeroDoctores=numDoc;
        this.numeroCitas=numCitas;
        this.promedioDuracion=prom;
        this.citasLibres=citasLi;
        this.citasCanceladas=citasCan;
        this.citasTerminadas=citasTer;
    }
    
    	public EspecialidadDTO getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(EspecialidadDTO especialidad) {
		this.especialidad = especialidad;
	}

	public int getNumeroDoctores() {
		return numeroDoctores;
	}

	public void setNumeroDoctores(int numeroDoctores) {
		this.numeroDoctores = numeroDoctores;
	}

	public int getNumeroCitas() {
		return numeroCitas;
	}

	public void setNumeroCitas(int numeroCitas) {
		this.numeroCitas = numeroCitas;
	}

	public int getPromedioDuracion() {
		return promedioDuracion;
	}

	public void setPromedioDuracion(int promedioDuracion) {
		this.promedioDuracion = promedioDuracion;
	}

	public int getCitasLibres() {
		return citasLibres;
	}

	public void setCitasLibres(int citasLibres) {
		this.citasLibres = citasLibres;
	}    
        
        public int getCitasCanceladas() {
		return citasCanceladas;
	}

	public void setCitasCanceladas(int citasCanceladas) {
		this.citasCanceladas = citasCanceladas;
	}    
        
        public int getCitasTerminadas() {
		return citasTerminadas;
	}

	public void setCitasTerminadas(int citasTerminadas) {
		this.citasTerminadas = citasTerminadas;
	}    
}
