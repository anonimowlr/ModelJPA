/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calculopoupanca.controller;

import br.com.calculopoupanca.dao.CadastroDAO;
import br.com.calculopoupanca.entity.Cadastro;
import br.com.calculopoupanca.entity.Funcionario;
import br.com.calculopoupanca.model.DataEHora;
import com.google.gson.Gson;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author PC_LENOVO
 */
@Controller
@SessionAttributes("usuarioLogado")
public class HomeController {

    @RequestMapping("/sucesso")
    public String iniciando(Model model, Cadastro cadastro) throws SQLException {
        CadastroDAO dao = new CadastroDAO();

        dao.salvar(cadastro);
        model.addAttribute("retorno", cadastro.getNome());

        return "sucesso";
    }

    @RequestMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }
    @RequestMapping("/aula")
    public String aula() {
        return "aula";
    }
    @RequestMapping("/aula2")
    public String aula2() {
        return "aula2";
    }

    @RequestMapping("/cadastro2")
    public String cadastro2() {
        return "cadastro2";
    }
    @RequestMapping("/home")
    public String home(@ModelAttribute("usuarioLogado") Funcionario funcionario, Model model) {
         if(funcionario.getChave() == null || funcionario.getChave().equals("")){
            return "acessoNegado";
        } else{
        return "home";
        }
    }

    
    @RequestMapping("/exibir")
    public String buscar(Model model){
        CadastroDAO dao = new  CadastroDAO();
      
        model.addAttribute("lista", dao.buscar());
        
        dao.buscar();   
        
        return "exibir";
    }
    @RequestMapping("/retorno")
    public  @ResponseBody    String retorno(){
          CadastroDAO dao = new  CadastroDAO();
          Gson gson = new Gson();
          String retorno = gson.toJson(dao.buscar());
        
        return  retorno;
        
    }
    
    
    @RequestMapping("/ip")
    public  @ResponseBody    String ipReal(){
         DataEHora dataehora  = new  DataEHora();
        
         
        return "Seu ip verdadeiro é :" +  dataehora.getIpReal();
        
    }
    
    
    @RequestMapping("/rodape")
    public String rodape(@ModelAttribute("usuarioLogado") Funcionario funcionario, 
                         Model model) {
        model.addAttribute(funcionario);
      
        return "rodape";
        
    }
    
    
    
    
    
    @RequestMapping("/novo-calculo")
    public String novoCalculo(@ModelAttribute("usuarioLogado") Funcionario funcionario, 
                         Model model) {
        model.addAttribute(funcionario);
        return "novo-calculo";
    }
    @RequestMapping("/calculo-anterior")
    public String calculoAnterior(@ModelAttribute("usuarioLogado") Funcionario funcionario, 
                         Model model) {
        model.addAttribute(funcionario);
        return "calculo-anterior";
    }
    
    @RequestMapping("/acessoNegado")
    public String acessoNegado(@ModelAttribute("usuarioLogado") Funcionario funcionario, 
                         Model model) {
        model.addAttribute(funcionario);
        return "acessoNegado";
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
