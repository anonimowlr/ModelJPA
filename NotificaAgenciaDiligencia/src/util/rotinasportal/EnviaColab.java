/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.rotinasportal;

import br.com.bb.cenopserv.model.dao.NotificacaoDAO;
import br.com.cenopserv.model.entity.Notificacao;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.text.WordUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author PC_LENOVO
 */
public class EnviaColab extends Thread {

    List<Notificacao> lista = null;
    NotificacaoDAO notificacaoDAO = new NotificacaoDAO();
    WebDriver driver;
    WebDriverWait espera;
    

    @Override
    public void run() {
        createList();
        try {
            lerLista();
        } catch (Exception ex) {
            Logger.getLogger(EnviaColab.class.getName()).log(Level.SEVERE, null, ex);
        }
        currentThread().interrupt();
    }

    private void createList() {
        lista = notificacaoDAO.buscarParaEnviarCorreio();
        if (lista.size() < 1) {
            JOptionPane.showMessageDialog(null, "Não há registros a complementar");
        } else {
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> prefs = new HashMap<>();
            options.setExperimentalOption("prefs", prefs);
            //System.setProperty("webdriver.chrome.driver", "P:\\CENOP1915\\CENOP SERVIÇOS\\ADMINISTRATIVO\\CAPTURA JAVA\\chromedriver.exe"); //habilitar bb
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC_LENOVO\\Desktop\\selenium_java\\chromedriver.exe"); //habilitar casa
           driver = new ChromeDriver();
           espera = new WebDriverWait(driver, 30000);
           
           

        }

    }

    private void lerLista() throws ParseException, Exception {

        for (Notificacao notificacao : lista) {

            try {
                enviarTeste(notificacao);
            } catch (InterruptedException ex) {
                Logger.getLogger(EnviaColab.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void enviar(Notificacao notificacao) throws ParseException, InterruptedException, Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
       
        JavascriptExecutor js; 
        js = (JavascriptExecutor) driver;
        
        // JOptionPane.showMessageDialog(null, "Não existem registros!");

        //             driver.get("https://correioweb.bb.com.br/mail/dom919002/85962-g.nsf");
        driver.get("https://correioweb.bb.com.br/mail/dom144002/10544-c.nsf");
        int indice = 0;
        String email = notificacao.getEmail();
        //String email = "f5078775@bb.com.br";
        String copia = notificacao.getChaveFunciRespGsv().toLowerCase() + "@bb.com.br"; // colocar chave funcionario resp para cópia
        boolean valid = EmailValidator.getInstance().isValid(email);
        if (valid) {
            String textoProtocolos = "45455454";
//                                    pstmt2 = conn.prepareStatement("select * from tabela_servicos where os_num='" + jTable1.getModel().getValueAt(i, 0).toString() + "' and isnull(data_conclusao)");
//                                    rsProtocolos = pstmt2.executeQuery();
//                                    while (rsProtocolos.next()) {
//                                        textoProtocolos += "Protocolo: " + rsProtocolos.getString("Protocolo") + " | Cliente: " + rsProtocolos.getString("Cliente") + " | Localidade: " + rsProtocolos.getString("Localidade") + "\n";
//                                    }
            Date today = new Date();
            today = formatter.parse(formatter.format(today));
            Date dataFormatada = (Date) notificacao.getDtVenc();
            dataFormatada = formatter.parse(formatter.format(dataFormatada));

            boolean atrasado = dataFormatada.before(today);
            String textoEmail = WordUtils.capitalize(notificacao.getNpj().subSequence(0, 4) + "/" + notificacao.getNpj().subSequence(4, 11) + "-" + notificacao.getNpj().subSequence(11, notificacao.getNpj().length()).toString()) + ",\n"
                    + "\n"
                    + "Informamos que existe pedido de subsídios pendente de atendimento por sua dependência junto ao Portal Jurídico, vinculado ao NPJ em referência.\n"
                    + "\n"
                    + "Ressaltamos que cabe à agência fornecer subsídios relativos a fatos e documentos assinados/entregues pelos clientes, conforme IN 296-1 item 2.2.3.\n"
                    + "\n"
                    + "Solicitamos encaminhar as informações e documentos solicitados até " + util.Utils.doisDiasPrazo() + " para subsidiar a defesa do Banco na demanda judicial. \n"
                    + "\n"
                    + "Orientar-se pelos procedimentos contidos na IN 296-2 item 3.1.\n"
                    + "\n"
                    + "\n"
                    + "CENOP SERVIÇOS CURITIBA - PR    \n"
                    + "Equipes Subsídios Proativos \n"
                    + "Fones: (41) 3259-0205 / 3259-0216  \n"
                    + "\n\n" +
                    "\n\n";
            driver.switchTo().parentFrame();
            espera.until(ExpectedConditions.titleIs("Caixa de entrada"));
            espera.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
            driver.switchTo().frame("s_MainFrame");
            driver.findElement(By.id("e-dropdown-new-mailview-text")).click();
            espera.until(ExpectedConditions.titleIs("Nova mensagem"));
            driver.findElement(By.id("e-$new-" + indice + "-sendto")).clear();
            driver.findElement(By.id("e-$new-" + indice + "-sendto")).sendKeys(email);
            driver.findElement(By.id("e-$new-" + indice + "-copyto")).clear();
            driver.findElement(By.id("e-$new-"+indice+"-copyto")).sendKeys(copia);
            driver.findElement(By.id("e-$new-" + indice + "-subject")).clear();
            driver.findElement(By.id("e-$new-" + indice + "-subject")).sendKeys("Diligência Npj " + notificacao.getNpj());
            driver.switchTo().frame("e-$new-" + indice + "-bodyrich-editorframe");
            espera.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
            driver.findElement(By.id("e-$new-" + indice + "-bodyrich-editor")).click();
            driver.findElement(By.id("e-$new-" + indice + "-bodyrich-editor")).sendKeys(Keys.CONTROL, Keys.HOME);
            driver.findElement(By.id("e-$new-" + indice + "-bodyrich-editor")).sendKeys(textoEmail);
            driver.switchTo().parentFrame();
            driver.findElement(By.id("e-actions-mailedit-send")).click();
            espera.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
            Thread.sleep(1500);
            indice++;
            
            
            notificacao.setDataLimRespAg(util.Utils.formataDataToMysql(util.Utils.doisDiasPrazo()));
            notificacao.setObs("Correio enviado");
            notificacaoDAO.salvar(notificacao);
        }

    }

    public void enviarTeste(Notificacao notificacao) throws ParseException, InterruptedException {

        String textoEmail = WordUtils.capitalize(notificacao.getNpj().subSequence(0, 4) + "/" + notificacao.getNpj().subSequence(4, 11) + "-" + notificacao.getNpj().subSequence(11, notificacao.getNpj().length()).toString()) + ",\n"
                + "\n"
                + "Informamos que existe pedido de subsídios pendente de atendimento por sua dependência junto ao Portal Jurídico, vinculado ao NPJ em referência.\n"
                + "\n"
                + "Ressaltamos que cabe à agência fornecer subsídios relativos a fatos e documentos assinados/entregues pelos clientes, conforme IN 296-1 item 2.2.3.\n"
                + "\n"
                + "Solicitamos encaminhar as informações e documentos solicitados até "  +  util.Utils.doisDiasPrazo()  +   " para subsidiar a defesa do Banco na demanda judicial. \n"
                + "\n"
                + "Orientar-se pelos procedimentos contidos na IN 296-2 item 3.1.\n"
                + "\n"
                + "\n"
                + "CENOP SERVIÇOS CURITIBA - PR    \n"
                + "Equipes Subsídios Proativos \n"
                + "Fones: (41) 3259-0205 / 3259-0216  \n"
                + "\n\n";
        
        System.out.println(textoEmail);
        
        
    }

}
