/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calculopoupanca.dao;

import java.util.List;
import br.com.calculopoupanca.util.ErroSistema;

/**
 *
 * @author PC_LENOVO
 */
public interface CrudDAO<E> {//E representa a entidade
    
    
    public void salvar(E entidade)throws ErroSistema;
    public void avocar(E entidade)throws ErroSistema;
    public void priorizar(E entidade)throws ErroSistema;
    public void liberar(E entidade)throws ErroSistema;
    public Boolean verAvocacao(E entidade);
    public void deletar(E entidade)throws ErroSistema;
    public List<E> buscar()throws ErroSistema;
    public List<E> buscarPorParametro(E entidade)throws ErroSistema;
    public List<E> buscarPorParametro(String parametro)throws ErroSistema;
    
    public Boolean avaliarParaSalvar(E entidade);
    public Boolean compararValor(E entidade);
    
    
    
    
}
