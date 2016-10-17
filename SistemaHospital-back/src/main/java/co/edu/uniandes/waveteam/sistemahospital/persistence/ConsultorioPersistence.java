/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.waveteam.sistemahospital.persistence;

import co.edu.uniandes.waveteam.sistemahospital.entities.ConsultorioEntity;
import co.edu.uniandes.waveteam.sistemahospital.entities.EspecialidadEntity;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author r.garcia11eeeeeeeeeee    y6
 */
@Stateless
public class ConsultorioPersistence {

    private static final Logger LOGGER = Logger.getLogger(ConsultorioPersistence.class.getName());

    @PersistenceContext(unitName = "WaveteamPU")
    protected EntityManager em;
    
    public ConsultorioEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando consultorio con id={0}", id);
        return em.find(ConsultorioEntity.class, id);
    }
    
    public ConsultorioEntity findByName(String name){
        LOGGER.log(Level.INFO, "Consultando consultorio con nombre={}",name);
        TypedQuery<ConsultorioEntity> q 
            = em.createQuery("select u from ConsultorioEntity u where u.name = :name", ConsultorioEntity.class);
        q = q.setParameter("name", name);
        return q.getSingleResult();
    }
}
