/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.modeljpa.jpa.EntityManagerUtil;
import br.com.modeljpa.modelo.Endereco;
import br.com.modeljpa.modelo.Estado;
import br.com.modeljpa.modelo.Pais;
import br.com.modeljpa.modelo.PessoaFisica;
import br.com.modeljpa.modelo.TipoEndereco;
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
public class TestePersistirEndereco {
    
    EntityManager em;
    
    
    public TestePersistirEndereco() {
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
            Endereco  e  = new Endereco();
            TipoEndereco te = em.find(TipoEndereco.class, 1);
            e.setBairro("Jardim menino deus");
            e.setCep("83420000");
            e.setComplemento("casa");
            e.setRua("Rua 13 de maio");
            e.setTipoEndereco(te);
            e.setNickname("Endereco da Casa");
            e.setNumero(379);
            e.setReferencia("Perto de la");
             pf.adicionarEndereco(e);
           
          
           
            
            
            
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
        }catch(Exception e){
            exception=true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
        
    }
    
    
}
