package br.com.cenopserv.model;

import br.com.cenopserv.model.entity.Notificacao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class NotificacaoAgenciaTableModel extends AbstractTableModel {

    private final List<Notificacao> dados = new ArrayList<>();
    private final String[] colunas = {"CODIGO", "AOF", "NPJ", "Pref_Agencia", "E_mail", "GSV", "Status", "Dt_Venc", "Etapa", "Dt_Etp_Atual", "Ocorrencia",
        "Atividade", "Equipe", "Gerente", "FUNCI_RESP_GSV", "OBS", "DATA_LIM_RESP_AG", "CHAVE_FUNCI_RESP_GSV", "DATA_ENVIO_CORREIO",
        "FUNCIONARIO_RESP_ENVIO", "AGE_DESTINO_SUBSIDIO","SITUACAO_SUBSIDIO", "CHAVE_GERENTE_DESTINO",
        "Responsavel Solicitação"};

    @Override
    public String getColumnName(int colunm) {
        return colunas[colunm];
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {

            case 0:
                return dados.get(linha).getCodigo();
            case 1:
                return dados.get(linha).getAof();

            case 2:
                return dados.get(linha).getNpj();

            case 3:
                return dados.get(linha).getPrefAgencia();

            case 4:
                return dados.get(linha).getEmail();

            case 5:
                return dados.get(linha).getGsv();

            case 6:
                return dados.get(linha).getStatus();

            case 7:
                return util.Utils.forrmatarDateToString( dados.get(linha).getDtVenc());

            case 8:
                return dados.get(linha).getEtapa();

            case 9:
                return util.Utils.forrmatarDateToString(dados.get(linha).getDtEtpAtual());
            case 10:
                return dados.get(linha).getOcorrencia();
            case 11:
                return dados.get(linha).getAtividade();
            case 12:
                return dados.get(linha).getEquipe();
            case 13:
                return dados.get(linha).getGerente();
            case 14:
                return dados.get(linha).getFunciRespGsv();
            case 15:
                return dados.get(linha).getObs();
            case 16:
                return  util.Utils.forrmatarDateToString(dados.get(linha).getDataLimRespAg());
            case 17:
                return dados.get(linha).getChaveFunciRespGsv();
            case 18:
                return util.Utils.forrmatarDateToString(dados.get(linha).getDataEnvioCorreio());
            case 19:
                return dados.get(linha).getFuncionarioRespEnvio();
            case 20:
                return dados.get(linha).getAgeDestinoSubsidio();
            case 21:
                return dados.get(linha).getSituacaoSubsidio();
            case 22:
                return dados.get(linha).getChaveGerenteDestino();

        }
        return null;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void addRow(Notificacao s) {

        dados.add(s);
        fireTableDataChanged();

    }

    public void removeRow(int linha) {
        dados.remove(linha);
        fireTableRowsDeleted(linha, linha);

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

        return true;

    }

     @Override
    public void setValueAt(Object valor, int linha, int coluna) {

        switch (coluna) {

            case 15:
                dados.get(linha).setObs((String) valor);
                break;

        }

        fireTableRowsUpdated(linha, linha);

    }

}
