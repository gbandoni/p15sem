package br.com.bandoni.dao.tables;

import java.io.Serializable;
/**
 * Java bean para a entidade 'J34SiscomexAcrescimoAdi'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexAcrescimoAdi implements Serializable {

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
    // DB : codigometodoacrescimovalor CHAR 
    private String codigometodoacrescimovalor;

    // DB : codigomoedanegociadaacrescimo INT 
    private Integer codigomoedanegociadaacrescimo;

    // DB : valoracrescimomoedanacional DECIMAL 
    private Float valoracrescimomoedanacional;

    // DB : valoracrescimomoedanegociada DECIMAL 
    private Float valoracrescimomoedanegociada;



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
    public void setCodigometodoacrescimovalor( String codigometodoacrescimovalor ) {
        this.codigometodoacrescimovalor = codigometodoacrescimovalor;
    }
    public String getCodigometodoacrescimovalor() {
        return this.codigometodoacrescimovalor;
    }

    public void setCodigomoedanegociadaacrescimo( Integer codigomoedanegociadaacrescimo ) {
        this.codigomoedanegociadaacrescimo = codigomoedanegociadaacrescimo;
    }
    public Integer getCodigomoedanegociadaacrescimo() {
        return this.codigomoedanegociadaacrescimo;
    }

    public void setValoracrescimomoedanacional( Float valoracrescimomoedanacional ) {
        this.valoracrescimomoedanacional = valoracrescimomoedanacional;
    }
    public Float getValoracrescimomoedanacional() {
        return this.valoracrescimomoedanacional;
    }

    public void setValoracrescimomoedanegociada( Float valoracrescimomoedanegociada ) {
        this.valoracrescimomoedanegociada = valoracrescimomoedanegociada;
    }
    public Float getValoracrescimomoedanegociada() {
        return this.valoracrescimomoedanegociada;
    }


    //----------------------------------------------------------------------
    // M�todo toString
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(numerodocumentocarga);
        sb.append("|");
        sb.append(numeroadicao);
        sb.append("|");
        sb.append(codigometodoacrescimovalor);
        sb.append("|");
        sb.append(codigomoedanegociadaacrescimo);
        sb.append("|");
        sb.append(valoracrescimomoedanacional);
        sb.append("|");
        sb.append(valoracrescimomoedanegociada);
        return sb.toString(); 
    } 


}
