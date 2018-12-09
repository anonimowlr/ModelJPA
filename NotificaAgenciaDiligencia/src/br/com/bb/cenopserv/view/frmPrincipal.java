package br.com.bb.cenopserv.view;

import br.com.bb.cenopserv.model.dao.FuncionarioDAO;
import br.com.bb.cenopserv.model.dao.NotificacaoDAO;
import br.com.cenopserv.model.NotificacaoAgenciaTableModel;
import br.com.cenopserv.model.entity.Funcionario;
import br.com.cenopserv.model.entity.Notificacao;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import sisbbgeneric.Janela3270;
import sisbbgeneric.PropriedadesPadraoSISBB;
import util.ErroSistema;
import util.rotinasportal.ColetaAgenciaSubsidio;
import util.rotinasportal.EnviaColab;
/**
 *
 * @author f3565932
 */
public class frmPrincipal extends javax.swing.JFrame {

   
    
    NotificacaoDAO notificacaoDAO = new NotificacaoDAO();

    NotificacaoAgenciaTableModel tableModel = new NotificacaoAgenciaTableModel();

   
   
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public frmPrincipal() throws UnsupportedLookAndFeelException {
//              try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//         }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            System.out.println(ex);
//        }
        
      
        initComponents();
        URL caminhoIcone =getClass().getResource("/imagens/banco do brasil.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
         this.setIconImage(iconeTitulo);


        
          jTable1.setModel(tableModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        lblFunci = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        icone5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        label7 = new java.awt.Label();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtProtocolo = new javax.swing.JTextField();
        btnEnviarCorreio = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lblQtd = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Notifica Agências - CENOP Serviços Curitiba");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblFunci.setText("Inf Funcionário:");

        jPanel14.setBackground(new java.awt.Color(24, 42, 69));

        icone5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icone5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/bb/cenopserv/view/bb.jpg"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(248, 209, 23));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Cenop Serviços Curitiba");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        label7.setAlignment(java.awt.Label.RIGHT);
        label7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label7.setForeground(new java.awt.Color(248, 209, 23));
        label7.setText("#interna");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Jucicial-Subsídio - Notifica Agência");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Versão 1.0");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(icone5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel8))
                        .addComponent(icone5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 23, Short.MAX_VALUE))
        );

        jLabel2.setText("Consultar um protocolo");

        txtProtocolo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProtocoloKeyPressed(evt);
            }
        });

        btnEnviarCorreio.setText("Enviar correio");
        btnEnviarCorreio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarCorreioActionPerformed(evt);
            }
        });

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel3.setText("Quantidade de registros selecionados:");

        lblQtd.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblQtd.setForeground(new java.awt.Color(51, 51, 255));

        jButton2.setText("Coletar agencia subsídio");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(btnEnviarCorreio)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblFunci, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviarCorreio)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(lblQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFunci, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
     
    }//GEN-LAST:event_formWindowClosing

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
     
        
        
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        String usuario_sessao = System.getProperty("user.name");
         Funcionario funci = null;
        try {
             funci = new FuncionarioDAO().getFuncionario(usuario_sessao);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ErroSistema ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
 
        
        
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);     //codigo
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);    //npj
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);     //var
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);    //valor solicitacao
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(200);     //saldo
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(200);    //oficio
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(200);    //data oficio
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(220);    //resultado inclusao
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(300);    //resultado contab
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(200);     //obs despacho
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(250);   //result inclusao benef
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(200);   //end doc1
        jTable1.getColumnModel().getColumn(12).setPreferredWidth(200);   //end doc2
        jTable1.getColumnModel().getColumn(13).setPreferredWidth(300);   //beneficiario
        jTable1.getColumnModel().getColumn(14).setPreferredWidth(150);   //cpf benef
        jTable1.getColumnModel().getColumn(15).setPreferredWidth(150);   //data solic
        jTable1.getColumnModel().getColumn(16).setPreferredWidth(100);   //data inclusao
        jTable1.getColumnModel().getColumn(17).setPreferredWidth(100);   //responsavel
        jTable1.getColumnModel().getColumn(18).setPreferredWidth(100);   //tipo levant
        jTable1.getColumnModel().getColumn(19).setPreferredWidth(100);   //levantador
        jTable1.getColumnModel().getColumn(20).setPreferredWidth(150);   //finalidade
        jTable1.getColumnModel().getColumn(21).setPreferredWidth(300);   //esp
        jTable1.getColumnModel().getColumn(23).setPreferredWidth(200);   //situacao
        List<Notificacao> lista = notificacaoDAO.buscarParaEnviarCorreio();
       
        
        
        
        for (Notificacao s : lista) {
            
            tableModel.addRow(s);
            
        }
 
        
        
       lblQtd.setText(Integer.toString(lista.size()));


lblFunci.setText(funci.getChave() + "-" +funci.getNome());


    }//GEN-LAST:event_formWindowOpened

    private void btnEnviarCorreioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarCorreioActionPerformed
       
         EnviaColab enviaColab = new EnviaColab();
         enviaColab.start();
        
        
        
    }//GEN-LAST:event_btnEnviarCorreioActionPerformed

    private void txtProtocoloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProtocoloKeyPressed
     
    }//GEN-LAST:event_txtProtocoloKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);

        jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(12).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(13).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(14).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(15).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(16).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(17).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(18).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(19).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(20).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(21).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(22).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(23).setPreferredWidth(300);

        if(txtProtocolo.getText().equals("")){
            int qtdLinha = tableModel.getRowCount();

        while (qtdLinha > 0) {
            tableModel.removeRow(0);
            qtdLinha = tableModel.getRowCount();
        }

        List<Notificacao> lista = notificacaoDAO.buscarTudo();
        for (Notificacao s : lista) {
            
            tableModel.addRow(s);
            
        }
        lblQtd.setText(Integer.toString(lista.size()));
        return;
        }
        
        
        int protocolo =Integer.parseInt(txtProtocolo.getText());
        int qtdLinha = tableModel.getRowCount();

        while (qtdLinha > 0) {
            tableModel.removeRow(0);
            qtdLinha = tableModel.getRowCount();
        }

        List<Notificacao> lista = notificacaoDAO.consultaPorProtocolo(protocolo);
        
        for (Notificacao s : lista) {
            
            tableModel.addRow(s);
            
        }
        
        lblQtd.setText(Integer.toString(lista.size()));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     Thread thread = new Thread() {

            public void run() {//double a, String b, int c, Date k
                try {
                      
                        ColetaAgenciaSubsidio coleta = new ColetaAgenciaSubsidio();
                        coleta.inicio();
                    
                    
                    
                      Janela3270 sisbb = new Janela3270();
                       sisbb.setTamanho(700, 500);
//                    ColetaSaldoDjoBaseWeb t = new ColetaSaldoDjoBaseWeb();
//                    PropriedadesPadraoSISBB sis = new PropriedadesPadraoSISBB();
//                    t.inicioRotinaSisbb(sisbb, "DJO");//, a, b, c, k
//                    sisbb.rotinaEncerramento();

                    JOptionPane.showMessageDialog(null, "Captura Finalizada com Sucesso!");
                } catch (Throwable ex) {
                    Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    
                }

            }

        };
        thread.start();

        
        
        
        
        
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println(ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            try {
                new frmPrincipal().setVisible(true);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviarCorreio;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel icone5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private java.awt.Label label7;
    private javax.swing.JLabel lblFunci;
    private javax.swing.JLabel lblQtd;
    private javax.swing.JTextField txtProtocolo;
    // End of variables declaration//GEN-END:variables
}