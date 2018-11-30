/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calculopoupanca.model;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PC_LENOVO
 */
public class DataEHora {

    public String getDataAtual() {

        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
        return (formatarDate.format(data));

    }

    public String getIpReal() {

        try {
            InetAddress myself = InetAddress.getLocalHost();
            String host = myself.getHostName();
            String endereco = myself.getHostAddress();
            return "HostName: "+host+" IP: "+endereco;
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }

}
