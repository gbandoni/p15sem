package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexDestaquencmAdi'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexDestaquencmAdi implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : numerodocumentocarga CHAR 
    private String numerodocumentocarga;
    // DB : numeroadicao CHAR 
    private String numeroadicao;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------    
    // DB : numerodestaquencm CHAR 
    private String numerodestaquencm;



    //----------------------------------------------------------------------
    // Getter e Setter da chave primaria
    //----------------------------------------------------------------------
    public void setNumerodocumentocarga( String numerodocumentocarga ) {
        this.numerodocumentocarga = numerodocumentocarga ;
    }

    public String getNumerodocumentocarga() {
        return this.numerodocumentocarga;
    }

    public void setNumeroadicao( String numeroadicao ) {
        this.numeroadicao = numeroadicao ;
    }

    public String getNumeroadicao() {
        return this.numeroadicao;
    }


    //----------------------------------------------------------------------
    // Getter e Setter dos outros campos
    //----------------------------------------------------------------------
    public void setNumerodestaquencm( String numerodestaquencm ) {
        this.numerodestaquencm = numerodestaquencm;
    }
    public String getNumerodestaquencm() {
        return this.numerodestaquencm;
    }


    //----------------------------------------------------------------------
    // Metodo toString
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(numerodocumentocarga);
        sb.append("|");
        sb.append(numeroadicao);
        sb.append("|");
        sb.append(numerodestaquencm);
        return sb.toString(); 
    } 


}
