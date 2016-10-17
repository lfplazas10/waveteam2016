/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.waveteam.sistemahospital.persistence;

import co.edu.uniandes.waveteam.sistemahospital.entities.EspecialidadEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author d.marino10
 */

@Stateless
public class EspecialidadPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(EspecialidadPersistence.class.getName());

    @PersistenceContext(unitName = "WaveteamPU")
    protected EntityManager em;
 
    public EspecialidadEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando especialidad con id={0}", id);
        return em.find(EspecialidadEntity.class, id);
    }
    
    public List<EspecialidadEntity> findAll() {
        LOGGER.info("Consultando todas las especialidad");
        Query q = em.createQuery("select u from EspecialidadEntity u");
        return q.getResultList();
    }
    
     public EspecialidadEntity create(EspecialidadEntity entity) {
        LOGGER.info("Creando una especialidad nueva");
        em.persist(entity);
        LOGGER.info("Especialidad creada");
        return entity;
    }
}
