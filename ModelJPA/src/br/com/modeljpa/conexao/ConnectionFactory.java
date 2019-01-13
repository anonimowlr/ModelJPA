/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modeljpa.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author PC_LENOVO
 */
public class ConnectionFactory {

    static EntityManagerFactory emf = null;
    static EntityManager em = null;

    static EntityManager conectarJpa() {

        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ModelPU");
        }

        if (em == null) {
            em = emf.createEntityManager();
        }

        return em;

    }

    public static void fecharConexao() {
        if (em.isOpen()) {
            em.close();
        }
        if (emf.isOpen()) {
            emf.close();
        }

    }

}
