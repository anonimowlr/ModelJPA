/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calculopoupanca.model.model;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author PC_LENOVO
 */
public class HttpClient {
    
    
    private static  String  URLBase = "http://api.postmon.com.br/v1/cep//";
   private static String token = "3de5ce998806e0c0750b1434e17454b6490ccf0a595f3884795da34460a7e7b3";
    private static HttpClient instance;
    
    private CloseableHttpClient clienteHTTP;
    
    
    
    private HttpClient (){
        this.clienteHTTP = HttpClients.createDefault();
        
    }
        
    
    public static HttpClient getInstance(){
        
        if(instance == null){
            
            instance = new HttpClient();
            
        }
         
        return instance;
    }
    
    
    
    public void doLogin (){
         try {
            
             HttpPost httpPost = new HttpPost(HttpClient.URLBase + "/Login/Autenticar?token=" + HttpClient.token);
             ResponseHandler<String>  responseHandler =  new ResponseHandler<String>() {
                 @Override
                 public String handleResponse(final HttpResponse response) throws  ClientProtocolException,IOException{
                     int status = response.getStatusLine().getStatusCode();
                            if(status>=200 && status<300){
                                
                                HttpEntity entity = response.getEntity();
                                return entity != null ? EntityUtils.toString(entity) : null;
                                
                            } else{
                                throw  new  ClientProtocolException("Inesperado status de responsta:" + status);
                            }
                     
                

                 }
             };
             
             String responseBody = this.clienteHTTP.execute(httpPost, responseHandler);
             System.out.println("---------------------------------------------------------------------------");
             System.out.println(responseBody);
             
        } catch (Exception e) {
            Logger.getLogger(HttpClient.class.getName()).log(Level.SEVERE, null,e);
        }
        
    }
    
    
    
    public String doRequest(String path){
        String responseBody = null;
        
        try {
            
            HttpGet httpGet =  new  HttpGet(HttpClient.URLBase+path);
             ResponseHandler<String>  responseHandler =  new ResponseHandler<String>() {
                 @Override
                 public String handleResponse(final HttpResponse response) throws  ClientProtocolException,IOException{
                     int status = response.getStatusLine().getStatusCode();
                            if(status>=200 && status<300){
                                
                                HttpEntity entity = response.getEntity();
                                return entity !=null ? EntityUtils.toString(entity) : null;
                                
                            } else{
                                throw  new  ClientProtocolException("Inesperado status de responsta:" + status);
                            }
                     
                

                 }
             };
             
             responseBody = this.clienteHTTP.execute(httpGet, responseHandler);
             System.out.println("----------------------------------------------------------------------");
            
        } catch (Exception e) {
            
        }
        return responseBody;
        
    }
    
    
    
}
