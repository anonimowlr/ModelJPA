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
public class NotificacaoDAO {

    
    
     
    public List<Notificacao> buscarParaEnviarCorreio(){
        EntityManager em = new ConnectionFactory().conectarJpa();
        
        List<Notificacao>  listaNotificacao = new ArrayList<>();
        
        try{
          listaNotificacao = em.createQuery("FROM Notificacao n WHERE n.situacaoSubsidio = 'Solicitado' AND n.obs = null").getResultList();
            
            
            
            
            
        }catch(Exception ex){
            System.err.println(ex);
        }finally{
        em.close();
        }
       
        return  listaNotificacao;
        
    }
    
    
    public List<Notificacao> buscarParaColetarGerenteAgencia(){
        EntityManager em = new ConnectionFactory().conectarJpa();
        
        List<Notificacao>  listaNotificacao = new ArrayList<>();
        
        try{
          listaNotificacao = em.createQuery("FROM Notificacao n").getResultList();
            
            
            
            
            
        }catch(Exception ex){
            System.err.println(ex);
        }finally{
        em.close();
        }
       
        return  listaNotificacao;
        
    }
    
    
    
    
    
    
    
    public List<Notificacao> buscarTudo(){
        EntityManager em = new ConnectionFactory().conectarJpa();
        
        List<Notificacao>  listaNotificacao = new ArrayList<>();
        
        try{
          listaNotificacao = em.createQuery("FROM Notificacao n ").getResultList();
            
            
            
            
            
        }catch(Exception ex){
            System.err.println(ex);
        }finally{
        em.close();
        }
       
        return  listaNotificacao;
        
    }
    
    
     public List<Notificacao> consultaPorProtocolo(int protocolo){
        EntityManager em = new ConnectionFactory().conectarJpa();
        
     
        
        List<Notificacao>  listaNotificacao = new ArrayList<>();
        
        try{
          listaNotificacao = em.createQuery("from Notificacao n where n.gsv =" + protocolo  ).getResultList();
            
            
            
            
            
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
