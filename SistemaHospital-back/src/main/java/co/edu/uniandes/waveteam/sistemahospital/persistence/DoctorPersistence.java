package co.edu.uniandes.waveteam.sistemahospital.persistence;

import co.edu.uniandes.waveteam.sistemahospital.entities.DoctorEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by felipeplazas on 10/11/16.
 */
public class DoctorPersistence {

    private static final Logger LOGGER = Logger.getLogger(EspecialidadPersistence.class.getName());

    @PersistenceContext(unitName = "WaveteamPU")
    protected EntityManager em;

    public DoctorEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando especialidad con id={0}", id);
        return em.find(DoctorEntity.class, id);
    }
}
