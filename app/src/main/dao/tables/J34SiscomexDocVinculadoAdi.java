package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexDocVinculadoAdi'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexDocVinculadoAdi implements Serializable {

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
    // DB : codigotipodocumentovinculado CHAR 
    private String codigotipodocumentovinculado;

    // DB : numerodocumentovinculado VARCHAR 
    private String numerodocumentovinculado;



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
    public void setCodigotipodocumentovinculado( String codigotipodocumentovinculado ) {
        this.codigotipodocumentovinculado = codigotipodocumentovinculado;
    }
    public String getCodigotipodocumentovinculado() {
        return this.codigotipodocumentovinculado;
    }

    public void setNumerodocumentovinculado( String numerodocumentovinculado ) {
        this.numerodocumentovinculado = numerodocumentovinculado;
    }
    public String getNumerodocumentovinculado() {
        return this.numerodocumentovinculado;
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
        sb.append(codigotipodocumentovinculado);
        sb.append("|");
        sb.append(numerodocumentovinculado);
        return sb.toString(); 
    } 


}
