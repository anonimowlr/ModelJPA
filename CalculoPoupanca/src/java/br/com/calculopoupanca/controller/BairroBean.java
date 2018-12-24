/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calculopoupanca.controller;

import br.com.calculopoupanca.model.dao.BairroDAO;
import br.com.calculopoupanca.model.dao.CrudDAO;
import br.com.calculopoupanca.model.entity.Bairro;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author PC_LENOVO
 */
@SessionScoped
@ManagedBean
public class BairroBean extends CrudBean<Bairro, BairroDAO>{

    
    

    public BairroDAO getBairroDAO() {
        return bairroDAO;
    }

    public void setBairroDAO(BairroDAO bairroDAO) {
        this.bairroDAO = bairroDAO;
    }
    
    
    private BairroDAO  bairroDAO;
     
     
     
    
    
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     

    @Override
    public BairroDAO  getDao() {

     if(bairroDAO == null){
            bairroDAO = new BairroDAO();
        }
        return bairroDAO;


    }

    @Override
    public Bairro criarNovaEntidade() {
      
       return new Bairro();

    }
    
    
}
