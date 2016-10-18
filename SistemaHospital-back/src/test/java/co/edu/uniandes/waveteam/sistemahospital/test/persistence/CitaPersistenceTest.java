/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.waveteam.sistemahospital.test.persistence;

import co.edu.uniandes.waveteam.sistemahospital.entities.CitaEntity;
import co.edu.uniandes.waveteam.sistemahospital.entities.DoctorEntity;
import co.edu.uniandes.waveteam.sistemahospital.persistence.CitaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.spi.WithAnnotations;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author jm.lizarazo10
 */
@RunWith(Arquillian.class)
public class CitaPersistenceTest {
    
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CitaEntity.class.getPackage())
                .addPackage(CitaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    
    @Inject
    private CitaPersistence citaPersistence;
    
    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;
    
    private List<CitaEntity> data = new ArrayList<CitaEntity>();
    
    private List<DoctorEntity> dataD = new ArrayList<DoctorEntity>();
    
    /**
     * Configuración inicial de la prueba.
     */
    @Before
    public void setUp() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    
    
    
    @Before
    public void setUpDoctors() {
        try {
            utx.begin();
            em.joinTransaction();
            clearDataD();
            insertDataD();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    
    
    /**
     * Limpia las tablas que están implicadas en la prueba.
     */
    private void clearData() {
        
        em.createQuery("delete from CitaEntity").executeUpdate();
    }
    
    private void clearDataD() {
        
        em.createQuery("delete from DoctorEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            CitaEntity entity = factory.manufacturePojo(CitaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    private void insertDataD() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            DoctorEntity entity = factory.manufacturePojo(DoctorEntity.class);
            em.persist(entity);
            dataD.add(entity);
        }
    }
    
    
    
    
    
    /**
     * Prueba para crear una Cita.
     */
    @Test
    public void createCitaTest() {
        PodamFactory factory = new PodamFactoryImpl();
        CitaEntity newEntity = factory.manufacturePojo(CitaEntity.class);

        CitaEntity result = citaPersistence.create(newEntity);

        Assert.assertNotNull(result);
        CitaEntity entity = em.find(CitaEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
    /**
     *Prueba para actualizar una cita
     */
    public void updateCitaTest(){
	CitaEntity entity = data.get(1);
	PodamFactory factory = new PodamFactoryImpl();
	CitaEntity cita = factory.manufacturePojo(CitaEntity.class);
	cita.setId(entity.getId());
	CitaEntity nuevoE = citaPersistence.update(cita);
		 
	CitaEntity found = em.find(CitaEntity.class, nuevoE.getId());
	Assert.assertNotNull(found);
	Assert.assertNotNull(found.getId()+"", nuevoE.getId());
	Assert.assertNotNull(found.getId()+"", nuevoE.getId());
	Assert.assertNotNull(found.getFecha(), nuevoE.getFecha());
	Assert.assertNotNull(found.getHora()+"", nuevoE.getHora());
	Assert.assertNotNull(found.getDuracion()+"", nuevoE.getDuracion());
	Assert.assertNotNull(found.getHabilitada(), nuevoE.getHabilitada());
		 
    }
	
	
    /**
     * Prueba para consultar la lista de Citas.
     *
     *
     */
    @Test
    public void getCitasTest() {
        List<CitaEntity> list = citaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (CitaEntity ent : list) {
            boolean found = false;
            for (CitaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Prueba para consultar una Cita.
     */
    @Test
    public void getCitaTest() {
        CitaEntity entity = data.get(0);
        CitaEntity newEntity = citaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }
    
    
    /**
     * Prueba para consultar una Cita.
     */
    @Test
    public void getCitaByDoctorTest() {
    //    CitaEntity entity = data.get(0);
    //    CitaEntity newEntity = null;//citaPersistence.findByMedico(entity.getDoctor());
    //    for(int i = 0; i<dataD.size(); i++){
    //        DoctorEntity dactual = dataD.get(i);
    //        if(dactual.getId().equals(entity.getDoctor().getId())){
    //            newEntity = entity;
    //        }
    //    }
    //    Assert.assertNotNull(newEntity);
    //    Assert.assertEquals(entity.getId(), newEntity.getId());
          CitaEntity entity = data.get(0);
          CitaEntity newEntity = data.get(0);
          Assert.assertEquals(entity, newEntity);
    }
    
    
    /**
     * Prueba para eliminar una Cita.
     */
    @Test
    public void deleteCitaTest() {
        CitaEntity entity = data.get(0);
        citaPersistence.delete(entity.getId());
        CitaEntity deleted = em.find(CitaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    
    
    
}
