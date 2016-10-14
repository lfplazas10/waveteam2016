/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.waveteam.sistemahospital.api;

import co.edu.uniandes.waveteam.sistemahospital.entities.CitaEntity;
import java.util.List;

/**
 *
 * @author jm.lizarazo10
 */
public interface ICitaLogic {
    
    public List<CitaEntity> getCitas();
    public CitaEntity getCita(Long id);
    public CitaEntity createCita(CitaEntity entity);
    public CitaEntity updateCita(CitaEntity entity);
    public void deleteCita(Long id);
    
}
