
import java.math.BigDecimal;
import java.math.MathContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC_LENOVO
 */
public class TesteValoresMonetarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        BigDecimal v1 = new BigDecimal("204.63");
        BigDecimal v2 = new BigDecimal("18.35390");
        BigDecimal indice = v2.divide(new BigDecimal(100));
        
        BigDecimal valorCorrecao = v1.divide(indice).round(MathContext.DECIMAL128);
        
        System.out.println(v1.multiply(indice));
        
        
        
        
        
        
    }
    
}
