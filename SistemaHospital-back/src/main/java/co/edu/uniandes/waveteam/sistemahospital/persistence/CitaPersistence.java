/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.waveteam.sistemahospital.persistence;

import co.edu.uniandes.waveteam.sistemahospital.entities.CitaEntity;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jm.lizarazo10
 */
@Stateless
public class CitaPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(CitaPersistence.class.getName());
    
    @PersistenceContext(unitName = "WaveTeamPU")
    protected EntityManager em;
    
    public CitaEntity fin(long id){
        String atrib = "Consultando cita con id = (" + id + ")";
        LOGGER.log(Level.INFO, atrib, id);
        return em.find(CitaEntity.class, id);
    }
    
}
