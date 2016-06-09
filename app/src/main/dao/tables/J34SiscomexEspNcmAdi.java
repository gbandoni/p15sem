package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexEspNcmAdi'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexEspNcmAdi implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : numerodocumentocarga CHAR 
    private String numerodocumentocarga;
    // DB : numeroadicao CHAR 
    private String numeroadicao;
    // DB : codigoabrangenciancm CHAR 
    private String codigoabrangenciancm;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------    
    // DB : ncm CHAR 
    private String ncm;

    // DB : codigoatributoncm CHAR 
    private String codigoatributoncm;

    // DB : codigoespecificacaoncm CHAR 
    private String codigoespecificacao;

    // DB : atributo CHAR 
    private String atributo;



    //----------------------------------------------------------------------
    // Getter e Setter da chave primaria
    //----------------------------------------------------------------------
    public void setNumerodocumentocarga( String numerodocumentocarga )
    {
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

    public void setCodigoabrangenciancm( String codigoabrangenciancm ) {
        this.codigoabrangenciancm = codigoabrangenciancm ;
    }

    public String getCodigoabrangenciancm() {
        return this.codigoabrangenciancm;
    }


    //----------------------------------------------------------------------
    // Getter e Setter dos outros campos
    //----------------------------------------------------------------------
    public void setNcm( String ncm ) {
        this.ncm = ncm;
    }
    public String getNcm() {
        return this.ncm;
    }

    public void setCodigoatributoncm( String codigoatributoncm ) {
        this.codigoatributoncm = codigoatributoncm;
    }
    public String getCodigoatributoncm() {
        return this.codigoatributoncm;
    }

    public void setCodigoespecificacao( String codigoespecificacao ) {
        this.codigoespecificacao = codigoespecificacao;
    }
    public String getCodigoespecificacao() {
        return this.codigoespecificacao;
    }

    public void setAtributo( String atributo ) {
        this.atributo = atributo;
    }
    public String getAtributo() {
        return this.atributo;
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
        sb.append(codigoabrangenciancm);
        sb.append("|");
        sb.append(ncm);
        sb.append("|");
        sb.append(codigoatributoncm);
        sb.append("|");
        sb.append(codigoespecificacao);
        sb.append("|");
        sb.append(atributo);
        return sb.toString(); 
    } 


}
