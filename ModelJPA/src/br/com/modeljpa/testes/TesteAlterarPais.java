/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modeljpa.testes;

import br.com.modeljpa.modelo.Pais;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author PC_LENOVO
 */
public class TesteAlterarPais {
    
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf  = Persistence.createEntityManagerFactory("ModelPU");
        EntityManager em = emf.createEntityManager();
        Pais p = em.find(Pais.class, 1);
        
        p.setNome("Brasil");
        p.setIso("Br");
        
        
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        
        
        
    }
    
    
}
