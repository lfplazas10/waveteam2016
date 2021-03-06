/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.waveteam.sistemahospital.api;

import co.edu.uniandes.waveteam.sistemahospital.entities.PacienteEntity;
import java.util.List;


public interface IPacienteLogic {
    public  PacienteEntity  getPaciente (Long id);
    public  void  deletePaciente (Long id);
    public  PacienteEntity  updatePaciente(PacienteEntity paciente);
    public  PacienteEntity  createPaciente(PacienteEntity paciente);
    public  PacienteEntity  findPacienteByName (String name);
    public  PacienteEntity  findPacienteByID(Long id);
    public  List<PacienteEntity> findAllPacientes(); 
}
