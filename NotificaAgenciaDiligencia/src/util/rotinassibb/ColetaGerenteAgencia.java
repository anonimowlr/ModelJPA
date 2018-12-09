package util.rotinassibb;

import br.com.bb.cenopserv.model.dao.ColetaAgenciaSubsidioDAO;
import br.com.bb.cenopserv.model.dao.NotificacaoDAO;
import br.com.bb.jibm3270.RoboException;
import br.com.cenopserv.model.entity.Notificacao;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import sisbbgeneric.LogarUsuarioSisbb;
import sisbbgeneric.Janela3270;

/**
 *
 * @author suporte
 */
public class ColetaGerenteAgencia {
     List<Notificacao> lista = null;
     NotificacaoDAO notificacaoDAO = new NotificacaoDAO();
     ColetaAgenciaSubsidioDAO coletaAgenciaSubsidioDAO = new ColetaAgenciaSubsidioDAO();
    
     
    public void inicioRotinaSisbb(Janela3270 sisbb, String sistema) throws Throwable {

        LogarUsuarioSisbb logar = new LogarUsuarioSisbb();
        logar.autenticar(sistema, sisbb);

        posicionarTela(sisbb);

        createList(sisbb);

        lerLista(sisbb);
        
       

    }

    private void posicionarTela(Janela3270 sisbb) throws RoboException {

        sisbb.aguardar(1, 3, "DJOM000M");
        sisbb.teclarAguardarTroca("@E");
        sisbb.posicionar(21, 11);
        sisbb.teclar("12");
        sisbb.teclarAguardarTroca("@E");
        sisbb.aguardar(21, 3, "Informe");
        sisbb.posicionar(21, 44);
        sisbb.teclarAguardarTroca("@E");
        sisbb.aguardar(21, 3, "Conta");
        sisbb.posicionar(19, 11);
        sisbb.teclar("18");
        sisbb.teclarAguardarTroca("@E");
        sisbb.posicionar(21, 11);
        sisbb.teclar("51");
        sisbb.teclarAguardarTroca("@E");
        sisbb.posicionar(21, 11);
        sisbb.teclar("01");
        sisbb.teclarAguardarTroca("@E");
        sisbb.posicionar(6, 59);
        sisbb.teclar("             ");

    }

    public void createList(Janela3270 sisbb) throws SQLException {

      lista = notificacaoDAO.buscarParaColetarGerenteAgencia();
        if (lista.size() < 1) {
            JOptionPane.showMessageDialog(null, "Não há registros para coletar");
        } 

    }

    public void lerLista(Janela3270 sisbb) throws Throwable {


        for (Notificacao notificacao : lista) {

          

            coletaDadosGerente( notificacao, sisbb);

           

        }

    }

    private void coletaDadosGerente(Notificacao notificacao ,Janela3270 sisbb) throws RoboException {
        int i;
        while (!sisbb.copiar(5, 44, 7).equals("Mandado")) {
            sisbb.teclarAguardarTroca("@3");
        }

        sisbb.posicionar(6, 59);
        sisbb.teclar("             ");
        sisbb.posicionar(6, 59);
        sisbb.teclarAguardarTroca("@E");
        
        
    }

    
    
    
    
    

    
}
