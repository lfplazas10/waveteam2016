/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.waveteam.sistemahospital.logic;

import co.edu.uniandes.waveteam.sistemahospital.api.ICitaLogic;
import co.edu.uniandes.waveteam.sistemahospital.entities.CitaEntity;
import co.edu.uniandes.waveteam.sistemahospital.persistence.CitaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jm.lizarazo10
 */
@Stateless
public class CitaLogic implements ICitaLogic{
    
     @Inject private CitaPersistence persistence;
     
     /**
     * Obtiene la lista de los registros de Company.
     *
     * @return Colección de objetos de CompanyEntity.
     * 
     */
    @Override
    public List<CitaEntity> getCitas() {
        return persistence.findAll();
    }
    
    
    
    /**
     * Obtiene los datos de una instancia de Company a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de CompanyEntity con los datos del Company consultado.
     * 
     */
    public CitaEntity getCita(Long id) {
        return persistence.find(id);
    }
    
    
    /**
     * Se encarga de crear un Company en la base de datos.
     *
     * @param entity Objeto de CompanyEntity con los datos nuevos
     * @return Objeto de CompanyEntity con los datos nuevos y su ID.
     * 
     */
    @Override
    public CitaEntity createCita(CitaEntity entity) {
        persistence.create(entity);
        return entity;
    }
    
    /**
     * Actualiza la información de una instancia de Company.
     *
     * @param entity Instancia de CompanyEntity con los nuevos datos.
     * @return Instancia de CompanyEntity con los datos actualizados.
     * 
     */
    @Override
    public CitaEntity updateCita(CitaEntity entity) {
        return persistence.update(entity);
    }
    
    
    
    /**
     * Elimina una instancia de Company de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * 
     */
    @Override
    public void deleteCita(Long id) {
        persistence.delete(id);
    }
    
    
}
