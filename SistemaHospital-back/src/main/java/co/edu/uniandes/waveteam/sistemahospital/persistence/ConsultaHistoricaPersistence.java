/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.waveteam.sistemahospital.persistence;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author d.marino10
 */
@Stateless
public class ConsultaHistoricaPersistence {

    private static final Logger LOGGER = Logger.getLogger(EspecialidadPersistence.class.getName());

    @PersistenceContext(unitName = "WaveteamPU")
    protected EntityManager em;
    
}
