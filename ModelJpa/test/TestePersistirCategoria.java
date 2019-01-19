/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.modeljpa.jpa.EntityManagerUtil;
import br.com.modeljpa.modelo.Categoria;
import br.com.modeljpa.modelo.Endereco;
import br.com.modeljpa.modelo.Estado;
import br.com.modeljpa.modelo.Marca;
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
public class TestePersistirCategoria {
    
    EntityManager em;
    
    
    public TestePersistirCategoria() {
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
            Categoria categoria = new Categoria();
           categoria.setDescricaoCategoria("Categoria1");
           
          
           
            
            
            
            em.getTransaction().begin();
            em.persist(categoria);
            em.getTransaction().commit();
        }catch(Exception e){
            exception=true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
        
    }
    
    
}
