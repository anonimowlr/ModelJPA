/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.modeljpa.jpa.EntityManagerUtil;
import br.com.modeljpa.modelo.Estado;
import br.com.modeljpa.modelo.Pais;
import br.com.modeljpa.modelo.PessoaFisica;
import br.com.modeljpa.modelo.Produto;
import java.util.Calendar;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC_LENOVO
 */
public class TestePersistirDesejos {
    
    EntityManager em;
    
    
    public TestePersistirDesejos() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    

   
    @Test
    public void teste(){
        boolean exception = false;
        
        try{
            PessoaFisica pf = em.find(PessoaFisica.class, 1);
            Produto p = em.find(Produto.class, 1);
            
            pf.getDesejos().add(p);
            
            
            
            
            
            
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
        }catch(Exception e){
            exception=true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, false);
        
    }
    
    
}
