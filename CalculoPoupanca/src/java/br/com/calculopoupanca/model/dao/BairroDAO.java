/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calculopoupanca.model.dao;

import br.com.calculopoupanca.model.entity.Bairro;
import br.com.calculopoupanca.model.entity.Cidade;
import br.com.calculopoupanca.model.model.HttpClient;
import br.com.calculopoupanca.util.ErroSistema;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC_LENOVO
 */
public class BairroDAO implements CrudDAO<Bairro> {

    @Override
    public void salvar(Bairro entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Bairro entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Bairro> buscar(Bairro entidade) throws ErroSistema {
        List<Bairro> listaBairros = new ArrayList<>();
 
      
        HttpClient consumidor = HttpClient.getInstance();

        listaBairros = leitorJson(consumidor.doRequest(Integer.toString(Integer.parseInt(entidade.getCep()))));
      
        return listaBairros;

    }

    private static List<Bairro> leitorJson(String conteudo) throws ErroSistema {
        Cidade cidade = new Cidade();
        List<Bairro> lista = null;

       
            Bairro bairro = null;
            Gson gson = new Gson();
            String reader = conteudo;
            bairro = gson.fromJson(reader, Bairro.class);
            lista = new ArrayList<>();
            lista.add(bairro);
     
        return lista;

    }

}
