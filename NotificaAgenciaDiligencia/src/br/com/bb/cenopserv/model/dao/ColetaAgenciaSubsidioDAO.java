/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.cenopserv.model.dao;

import br.com.bb.cenopserv.conexao.ConnectionFactory;
import br.com.cenopserv.model.entity.Notificacao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author f5078775
 */
public class ColetaAgenciaSubsidioDAO {
   

    
 
 
 
 
 public List<Notificacao> buscarParaLerAgenciaSubsidio(){
        EntityManager em = new ConnectionFactory().conectarJpa();
        
        List<Notificacao>  listaNotificacao = new ArrayList<>();
        
        try{
          listaNotificacao = em.createQuery("from Notificacao n ").getResultList();
            
            
            
            
        }catch(Exception ex){
            System.err.println(ex);
        }finally{
        em.close();
        }
       
        return  listaNotificacao;
        
    }
    
 
 
    
    
    
    public void salvar(Notificacao notificacao) {
    EntityManager em = new ConnectionFactory().conectarJpa();

        try {
             em.getTransaction().begin();

            if (notificacao.getCodigo()== null) {
                em.persist(notificacao);     
            } else{
                em.merge(notificacao);
            }

           
           
            em.getTransaction().commit();

        } catch (Exception ex) {
            System.err.println(ex);

        } finally {
            em.close();
        }

    }
    
    
}
