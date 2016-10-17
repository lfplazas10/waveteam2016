/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.waveteam.sistemahospital.test.persistence;

import co.edu.uniandes.waveteam.sistemahospital.entities.EspecialidadEntity;
import co.edu.uniandes.waveteam.sistemahospital.persistence.EspecialidadPersistence;
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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author d.marino10
 */
@RunWith(Arquillian.class)
public class EspecialidadPersistenceTest {
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EspecialidadEntity.class.getPackage())
                .addPackage(EspecialidadPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private EspecialidadPersistence persistence;

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;

    private List<EspecialidadEntity> data = new ArrayList<EspecialidadEntity>();
    
    
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
        em.createQuery("delete from EspecialidadEntity").executeUpdate();
    }
    
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 5; i++) {
            EspecialidadEntity entity = factory.manufacturePojo(EspecialidadEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Test of find method, of class EspecialidadPersistence.
     */
    @Test
    public void testFind() throws Exception {
        EspecialidadEntity entity = data.get(0);
        EspecialidadEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }

    /**
     * Test of findAll method, of class EspecialidadPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<EspecialidadEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (EspecialidadEntity ent : list) {
            boolean found = false;
            for (EspecialidadEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Test of create method, of class EspecialidadPersistence.
     */
    @Test
    public void testCreate() throws Exception {
         PodamFactory factory = new PodamFactoryImpl();
        EspecialidadEntity newEntity = factory.manufacturePojo(EspecialidadEntity.class);

        EspecialidadEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);
        EspecialidadEntity entity = em.find(EspecialidadEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
    @Test
    public void testDelete() {
        EspecialidadEntity entity = data.get(0);
        persistence.delete(entity.getId());
        EspecialidadEntity deleted = em.find(EspecialidadEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void testFindByName() {
        EspecialidadEntity entity = data.get(0);
        EspecialidadEntity newEntity = persistence.findByName(entity.getName());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }
}
