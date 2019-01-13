/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modeljpa.testes;

import br.com.modeljpa.modelo.Pais;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.hibernate.validator.ap.ConstraintValidationProcessor;

/**
 *
 * @author PC_LENOVO
 */
public class TesteValidacaoPais {
    
    public static void main(String[] args) {
         
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModelPU");
        EntityManager em = emf.createEntityManager();
        
          Pais p = new Pais();
           // p.setId(1);
        p.setNome("Romenia");
        p.setIso("rom");
          
        
        
        Validator validator  = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Pais>> erros = validator.validate(p);
      
      
        
        em.getTransaction().begin();
        if(erros.size()>0){
            for (ConstraintViolation<Pais> erro : erros) {
                System.out.println(erro.getMessage());
                
                
                
            }
            
        } else{
        
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
        }
        
        
    }
    
    
}
