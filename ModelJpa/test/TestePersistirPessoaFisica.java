/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.modeljpa.jpa.EntityManagerUtil;
import br.com.modeljpa.modelo.Estado;
import br.com.modeljpa.modelo.Pais;
import br.com.modeljpa.modelo.PessoaFisica;
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
public class TestePersistirPessoaFisica {
    
    EntityManager em;
    
    
    public TestePersistirPessoaFisica() {
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
            PessoaFisica pf = new PessoaFisica();
            pf.setNome("Jocimar walter");
            pf.setNomeUsuario("jocimarwrl");
          pf.setCpf("03861581930");
          pf.setEmail("jocimarwlr@gmai.com");
          pf.setSenha("jwalter1983");
          pf.setTelefone("997282239");
          pf.setNascimento(Calendar.getInstance());
          pf.setRg("84552020");
            
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
