/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.waveteam.sistemahospital.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author d.marino10
 */
@Entity
public class EspecialidadEntity extends BaseEntity implements Serializable {
    
    @PodamExclude
    @OneToMany(mappedBy = "especialidad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConsultaHistoricaEntity> consultas;
    
    @PodamExclude
    @OneToMany(mappedBy = "especialidad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DoctorEntity> doctores = new ArrayList<>();
    
    
    //@PodamExclude
    //@OneToMany(mappedBy = "especialidad", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<CitaEntity> citas = new ArrayList<>();
    
    private String gruposEdad;
    private String tipo;
    
    
    public String getGruposEdad() {
		return gruposEdad;
	}

    public void setGruposEdad(String gruposEdad) {
		this.gruposEdad = gruposEdad;
	}
    
    public String getTipo() {
		return tipo;
	}

    public void setTipo(String tipo) {
		this.tipo = tipo;
	}
    
    public List<ConsultaHistoricaEntity> getConsultaActual() {
		return consultas;
	}

    public void setConsultActual(ArrayList<ConsultaHistoricaEntity> consultas) {
		this.consultas = consultas;
	}
    
    public List<DoctorEntity> getDoctores() {
		return doctores;
	}

    public void setDoctores(ArrayList<DoctorEntity> doctores) {
		this.doctores = doctores;
	}
        
    //public List<CitaEntity> getCitas() {
	//	return citas;
	//}

    //public void setCitas(ArrayList<CitaEntity> citas) {
	//	this.citas = citas;
	//}
}
