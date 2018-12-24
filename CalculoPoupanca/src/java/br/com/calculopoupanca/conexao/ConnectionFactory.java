
package br.com.calculopoupanca.conexao;




import br.com.calculopoupanca.util.ErroSistema;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory {
    
    
    private static  Connection con = null;
   
    private static final String DB_DRIVER ="com.mysql.jdbc.Driver";
   
//    private static final String DB_USER ="rejud";
//  
//    private static final String DB_PASSWORD ="giEC8e";
    
//    private static final String DB_USER ="rejud";
//  
//    private static final String DB_PASSWORD ="rejud";
//    
//    private static final String DB_USER ="jocimar";
//  
//    private static final String DB_PASSWORD ="jwalter1983";

    
    
        private static final String DB_USER ="root";
  
        private static final String DB_PASSWORD ="root";
      
    

   
    
    
    
    
    public static Connection conectar(String banco) throws ErroSistema{
        
         String DB_CONEXAO ="jdbc:mysql://localhost/" + banco;
       
        
        try {
            Class.forName(DB_DRIVER);
            con  = DriverManager.getConnection(DB_CONEXAO,DB_USER,DB_PASSWORD);
            return con;
          
        } catch (ClassNotFoundException ex) { //  quando a conexao cai na exceção retorna a  variavel con do tipo connection nulo assim quem chamou o método sabe que a conexão falhou
            
            throw new ErroSistema("O drive do banco de dados não foi encontrado",ex);
        
        } catch (SQLException ex) {
            throw new ErroSistema("Não foi possível conectar ao banco de dados",ex);
            
        } 
            
        
        
        
        
        
        
        
    
    }

    
    public static void fecharConexao() throws ErroSistema {
        
        if(con != null){
            
            try {
                con.close();
            } catch (SQLException ex) {
                
                throw new ErroSistema("Erro ao fechar a conexão com o banco de dados",ex);
            }
        }
        
    }
    
}
