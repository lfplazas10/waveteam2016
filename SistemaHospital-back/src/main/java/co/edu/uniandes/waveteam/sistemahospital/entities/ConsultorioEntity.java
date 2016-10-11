/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.waveteam.sistemahospital.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author r.garcia11
 */
@Entity
public class ConsultorioEntity extends BaseEntity implements Serializable{
    
//    @OneToMany
//    private List<DoctorEntity> doctoresAsignados = new ArrayList<DoctorEntity>;
    
//    private String nombre;
    private String horario;
    private boolean atencionUrgencias;
    private boolean unidadCuidadosIntensivos;
    
    public String getHorario(){
        return horario;
    }
    
    public void setHorario(){
        this.horario = horario;
    }
    
    public boolean getAtencionUrgencias(){
        return atencionUrgencias;
    }
    
    public void setAtencionUrgencias(boolean atencionUrgencias){
        this.atencionUrgencias = atencionUrgencias;
    }
    
    public boolean getUnidadCuidadosintensivos(){
        return unidadCuidadosIntensivos;
    }
    
    public void setUnidadCuidadosIntensivos(){
        this.unidadCuidadosIntensivos = unidadCuidadosIntensivos;
    }
    
//    public List<DoctorEntity> getDoctoresAsignados(){
//        return doctoresAsignados;
//    }
    
//    public void setDoctoresAsignados(List<DoctorEntity> doctoresAsignados){
//        this.doctoresAsignados = doctoresAsignados;
//    }
    
//    public void agregarDoctorAsignado(DoctorEntity doc){
//        doctoresAsignados.add(doc);
//    }
    
//    public boolean eliminarDoctorAsignado(Long idDoctor)
//    {
//        for (DoctorEntity doc: doctoresAsignados)
//        {
//            if (Objects.equals(doc.getId(), idDoctor))
//            {
//                doctoresAsignados.remove(doc);
//                return true;
//            }
//        }
//        return false;
//    }
}
