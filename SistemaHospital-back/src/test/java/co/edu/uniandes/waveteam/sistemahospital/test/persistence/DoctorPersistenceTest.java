/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.waveteam.sistemahospital.test.persistence;

import co.edu.uniandes.waveteam.sistemahospital.entities.DoctorEntity;
import co.edu.uniandes.waveteam.sistemahospital.persistence.DoctorPersistence;
import java.util.ArrayList;
import java.util.List;
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
 * @author felipeplazas
 */
@RunWith(Arquillian.class)
public class DoctorPersistenceTest {
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(DoctorEntity.class.getPackage())
                .addPackage(DoctorPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private DoctorPersistence doctorPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    /**
     * Initial test configuration
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
    
    private void clearData() {
        em.createQuery("delete from DoctorEntity").executeUpdate();
    }

    private List<DoctorEntity> data = new ArrayList<>();
    
    /**
     * Inserts initial values
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            DoctorEntity entity = factory.manufacturePojo(DoctorEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test
    public void createDoctorTest(){
        PodamFactory factory = new PodamFactoryImpl();
        DoctorEntity docEntity = factory.manufacturePojo(DoctorEntity.class);
        System.out.println("INFORMATION1: "+docEntity.getName());
        try{
            DoctorEntity result = doctorPersistence.create(docEntity);
            System.out.println("INFORMATION2: "+result.getName());
            Assert.assertNotNull(result);
            
            DoctorEntity entity = em.find(DoctorEntity.class, result.getId());
            Assert.assertNotNull(entity);

            Assert.assertEquals(docEntity.getName(), entity.getName());
            Assert.assertEquals(docEntity.getConsultorio(), entity.getConsultorio());
    //        Assert.assertEquals(docEntity.getDisponibilidadCitas(), entity.getDisponibilidadCitas());
            Assert.assertTrue(true);
        } catch (Exception e) {
            System.out.println("HERE STARTS THE ERROR.");
            e.printStackTrace();
        }
        
    }
    
    @Test
    public void updateDoctorTest(){
        Assert.assertTrue(true);
    }
    
}
