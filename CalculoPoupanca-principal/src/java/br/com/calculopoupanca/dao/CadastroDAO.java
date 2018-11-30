package br.com.calculopoupanca.dao;

import br.com.calculopoupanca.conexao.Conexao;
import br.com.calculopoupanca.entity.Cadastro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.swing.JOptionPane;

public class CadastroDAO {
    
    
    
    public EntityManager getEM(){
       EntityManagerFactory factory = Persistence.createEntityManagerFactory("IniciandoComSpringPU");
     return factory.createEntityManager();
    }
    
    
    
    
    
    
    public void  salvar(Cadastro cadastro) throws  SQLException{
        
        EntityManager  em = getEM();
        em.getTransaction().begin();
        em.persist(cadastro);
        em.getTransaction().commit();
        em.close();
        
        
//    
//
//        Connection con = null;
//        try {
//            con = Conexao.conectar("testestring");
//
//            String sql = "insert into cadastro (nome, endereco, telefone, email) values(?,?,?,?)";
//             PreparedStatement stmt = con.prepareStatement(sql);
//            
//             stmt.setString(1, cadastro.getNome());
//             stmt.setString(2, cadastro.getEndereco());
//             stmt.setInt(3, (int) cadastro.getTelefone());
//             stmt.setString(4, cadastro.getEmail());
//           
//
//            stmt.executeUpdate();
//            //JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!!");
//            con.close();
//            stmt.close();
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
//        } finally{
//            Conexao.fecharConexao();
//        }
//
//        
       
        
    }
    
     public List<Cadastro> buscar(){
         //  Cadastro cadastro = null;
          List<Cadastro> listaCadastro = new ArrayList<>();
          
            EntityManager  em = getEM();// abre a conexao com jpa  eclipselink
            CriteriaQuery criteria =  em.getCriteriaBuilder().createQuery();
            criteria.select(criteria.from(Cadastro.class) ); 
             listaCadastro = em.createQuery(criteria).getResultList();
          
          
          
             return listaCadastro;  
          
          
//        try {
//            Connection con = Conexao.conectar("testestring");
//            String sql = "select * from cadastro";
//            PreparedStatement stmt = con.prepareStatement(sql);
//            ResultSet rs = stmt.executeQuery();
//           
//
//            while (rs.next()) {
//
//                 cadastro = new Cadastro();
//
//                cadastro.setNome(rs.getString("nome"));
//                cadastro.setEndereco(rs.getString("endereco"));
//                cadastro.setTelefone(rs.getInt("telefone"));
//                cadastro.setEmail(rs.getString("email"));
//
//                listaCadastro.add(cadastro);
//                
//
//            }
//
//            
//           
//            
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        } finally {
//            Conexao.fecharConexao();
//        }
      
        }
    
    
    
}
