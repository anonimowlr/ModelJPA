/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.rotinasportal;

import br.com.bb.cenopserv.model.dao.ColetaAgenciaSubsidioDAO;
import br.com.bb.cenopserv.model.dao.NotificacaoDAO;
import br.com.cenopserv.model.entity.Notificacao;

import java.util.List;
import javax.swing.JOptionPane;
import static util.rotinasportal.Coletas.driver;


/**
 *
 * @author f5078775
 */
public class ColetaAgenciaSubsidio{
    
   Coletas coletas = new Coletas();
    
     List<Notificacao> lista = null;
     NotificacaoDAO notificacaoDAO = new NotificacaoDAO();
     ColetaAgenciaSubsidioDAO coletaAgenciaSubsidioDAO = new ColetaAgenciaSubsidioDAO();

    public ColetaAgenciaSubsidio() {
    }

   

  
    public void inicio() {

        createList();
        lerLista();
       // coletas.encerraPortal(driver);
    }

    public void createList() {
        lista = coletaAgenciaSubsidioDAO.buscarParaLerAgenciaSubsidio();
        if (lista.size() < 1) {
            JOptionPane.showMessageDialog(null, "Não há registros para consultar");
        } else {
           // coletas.autenticarUsuario();
        }
    }

    public void lerLista() {

        for (Notificacao notificacao : lista) {
//            capturarAgencia(notificacao);
//            n++;

            System.out.println(notificacao.getEmail());
        }
        
    }
    
    
    
    
    private void capturarAgencia(Notificacao notificacao) {
        int tamanhoNpj = notificacao.getNpj().length();

        driver.manage().window().maximize();
        coletas.setURL("https://juridico.intranet.bb.com.br/paj/processo/pesquisarSolicitacao");
        coletas.aguardaElementoTelaByID("pesquisarSolicitacaoForm:j_id74");




        coletas.procuraElementoPorId(driver, "pesquisarSolicitacaoForm:numerobbjurDecorate:numerobbjurAnoDecorate:numerobbjurAnoInput", notificacao.getNpj().subSequence(0, 4).toString());
        coletas.procuraElementoPorId(driver, "pesquisarSolicitacaoForm:numerobbjurDecorate:numerobbjurAnoDecorate:numerobbjurAnoNumeroProcessoInput", notificacao.getNpj().subSequence(4, tamanhoNpj-3).toString());
        coletas.procuraElementoPorId(driver, "pesquisarSolicitacaoForm:numerobbjurDecorate:numerobbjurAnoDecorate:numerobbjurAnoVariacaoInput", notificacao.getNpj().subSequence(11, tamanhoNpj).toString());




        coletas.clickElementId(driver, "pesquisarSolicitacaoForm:btPesquisarSolicitacao");

        
        
        
        
        if (coletas.isElementPresentID(driver, "modaldivMessagesGlobal")) {

            String n = coletas.lerValorElementoID("modaldivMessagesGlobal");

            if (!n.equals("")) {
                
                notificacao.setObs(n);
                coletaAgenciaSubsidioDAO.salvar(notificacao);
                return;
            }
        }

        // ler gegistros na pagina
        Integer qtdreg = null;
        if (coletas.isElementPresentID(driver, "pesquisarSolicitacaoForm:j_id336")) {

            String n = coletas.lerValorElementoID("pesquisarSolicitacaoForm:j_id336");

            qtdreg = Integer.parseInt(coletas.quantidadeRegistrosListados(n));
        } else {

            
            notificacao.setObs("Não localizado nenhum subsídio para este npj");
            coletaAgenciaSubsidioDAO.salvar(notificacao);
            return;
        }
        
        
        if(qtdreg>9){
          coletas.clickElementId(driver, "pesquisarSolicitacaoForm:j_id365");
          coletas.aguardaElementoTelaByID("pesquisarSolicitacaoForm:dataTabletableSolicitacaoComplemento:10:colDependenciaSolicitanteDecorate:j_id390");
        }


        for (int reg = 0; reg < qtdreg; reg++) {
        
            
            String agenciaOrigemSubsidio = coletas.lerValorElementoID("pesquisarSolicitacaoForm:dataTabletableSolicitacaoComplemento:" + reg + ":colDependenciaSolicitanteDecorate:j_id390");
            String agenciaDestinoSubsidio = coletas.lerValorElementoID("pesquisarSolicitacaoForm:dataTabletableSolicitacaoComplemento:" +  reg + ":colDependenciaDestinoDecorate:j_id423");
            String estadoSubsidio = coletas.lerValorElementoID("pesquisarSolicitacaoForm:dataTabletableSolicitacaoComplemento:" +  reg + ":colEstadoDecorate");

        
            if((agenciaOrigemSubsidio.equals("1915") && (!agenciaDestinoSubsidio.equals("1915")) && (estadoSubsidio.equals("Solicitado")))){
                
                notificacao.setAgeDestinoSubsidio(Integer.parseInt(agenciaDestinoSubsidio));
                notificacao.setSituacaoSubsidio(estadoSubsidio);
                notificacao.setEmail("age" + agenciaDestinoSubsidio + "@bb.com.br");
                coletaAgenciaSubsidioDAO.salvar(notificacao);
                return;
            } 
             
             
             
        }

    }

    
    
}
