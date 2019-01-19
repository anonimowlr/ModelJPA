/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modeljpa.junit;

import br.com.modeljpa.jpa.EntityManagerUtil;
import br.com.modeljpa.modelo.PessoaFisica;
import br.com.modeljpa.modelo.Produto;
import br.com.modeljpa.modelo.Venda;
import br.com.modeljpa.modelo.VendaItens;
import java.util.Calendar;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author PC_LENOVO
 */
public class TestePersistirVenda {
    
    EntityManager em;
    
    
    public TestePersistirVenda() {
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
            Produto produto = em.find(Produto.class, 1);
            Venda v = new Venda();
          
           
           
           v.setData(Calendar.getInstance());
            v.setParcelas(3);
            v.setPessoaFisica(pf);
            
            VendaItens itens = new VendaItens();
            
          
            itens.setProduto(produto);
            itens.setQuantidade(2.0);
            itens.setValorUnitario(10.00);
            itens.setValorTotal(itens.getQuantidade() * itens.getValorUnitario());
          
            
          
            
            v.adicionarItem(itens);
            itens.setVenda(v);
            
            
            em.getTransaction().begin();
            em.persist(v);
            
            em.getTransaction().commit();
        }catch(Exception e){
            exception=true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
        
    }
    
    
}
