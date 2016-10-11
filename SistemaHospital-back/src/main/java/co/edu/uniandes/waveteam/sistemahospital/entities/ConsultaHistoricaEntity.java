/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.waveteam.sistemahospital.entities;

import java.io.Serializable;
import javax.persistence.Entity;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author d.marino10
 */
@Entity
public class ConsultaHistoricaEntity extends BaseEntity implements Serializable{

    @OneToOne
    private EspecialidadEntity especialidad;
    
    private String fecha;
    private int numeroDoctores;
    private int numeroCitas;
    private long promedioDuracion;
    private int citasLibres;
    private int citasCanceladas;
    private int citasTerminadas;
    
    public EspecialidadEntity getEspecialidad() {
		return especialidad;
	}

    public void setEspecialidad(EspecialidadEntity especialidad) {
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

    public long getPromedioDuracion() {
		return promedioDuracion;
	}

    public void setPromedioDuracion(long promedioDuracion) {
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
        
    public String getFecha() {
		return fecha;
	}

    public void setFecha(String fecha) {
		this.fecha=fecha;
	}   
}
