/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.waveteam.sistemahospital.persistence;

import co.edu.uniandes.waveteam.sistemahospital.entities.CitaEntity;
import co.edu.uniandes.waveteam.sistemahospital.entities.DoctorEntity;
import co.edu.uniandes.waveteam.sistemahospital.entities.PacienteEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author jm.lizarazo10
 */
@Stateless
public class CitaPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(CitaPersistence.class.getName());
    
    @PersistenceContext(unitName = "WaveteamPU")
    protected EntityManager em;
    
    public CitaEntity find(long id){
        String atrib = "Consultando cita con id = (" + id + ")";
        LOGGER.log(Level.INFO, atrib, id);
        return em.find(CitaEntity.class, id);
    }
    
    
    public CitaEntity findByDoctor(DoctorEntity doctor) {
        LOGGER.log(Level.INFO, "Consultando cita con doctor = {0}", doctor.getId());
        TypedQuery<CitaEntity> q = em.createQuery("select u, m from CitaEntity u, DoctorEntity m where u.doctor = m", CitaEntity.class);
        q = q.setParameter("doctor", doctor); 
        return q.getSingleResult();
    }
    
    public CitaEntity findByPaciente(PacienteEntity paciente){
        LOGGER.log(Level.INFO, "Consultando cita con paciente = {0}", paciente.getId());
        TypedQuery<CitaEntity> q = em.createQuery("select u, p from CitaEntity u, PacienteEntity p where u.paciente = p", CitaEntity.class);
        q = q.setParameter("paciente", paciente);
        return q.getSingleResult();
    }
    
    
    public List<CitaEntity> findAll() {
        LOGGER.info("Consultando todass las citas");
        Query q = em.createQuery("select u from CitaEntity u");
        return q.getResultList();
    }
    
    
    public CitaEntity create(CitaEntity entity) {
        LOGGER.info("Creando una cita nueva");
        em.persist(entity);
        LOGGER.info("Cita creada");
        return entity;
    }
    
    public CitaEntity update(CitaEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando cita con id={0}", entity.getId());
        return em.merge(entity);
    }
    
    
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando cita con id={0}", id);
        CitaEntity entity = em.find(CitaEntity.class, id);
        em.remove(entity);
    }
    
    
}
