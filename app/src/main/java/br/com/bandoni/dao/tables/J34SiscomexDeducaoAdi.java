package br.com.bandoni.dao.tables;

import java.io.Serializable;



/**
 * Java bean para a entidade 'J34SiscomexDeducaoAdi'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexDeducaoAdi implements Serializable {

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
    // DB : codigometododeducaovalor CHAR 
    private String codigometododeducaovalor;

    // DB : codigomoedanegociadadeducao INT 
    private Integer codigomoedanegociadadeducao;

    // DB : valordeducaomoedanacional DECIMAL 
    private Float valordeducaomoedanacional;

    // DB : valordeducaomoedanegociada DECIMAL 
    private Float valordeducaomoedanegociada;



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
    public void setCodigometododeducaovalor( String codigometododeducaovalor ) {
        this.codigometododeducaovalor = codigometododeducaovalor;
    }
    public String getCodigometododeducaovalor() {
        return this.codigometododeducaovalor;
    }

    public void setCodigomoedanegociadadeducao( Integer codigomoedanegociadadeducao ) {
        this.codigomoedanegociadadeducao = codigomoedanegociadadeducao;
    }
    public Integer getCodigomoedanegociadadeducao() {
        return this.codigomoedanegociadadeducao;
    }

    public void setValordeducaomoedanacional( Float valordeducaomoedanacional ) {
        this.valordeducaomoedanacional = valordeducaomoedanacional;
    }
    public Float getValordeducaomoedanacional() {
        return this.valordeducaomoedanacional;
    }

    public void setValordeducaomoedanegociada( Float valordeducaomoedanegociada ) {
        this.valordeducaomoedanegociada = valordeducaomoedanegociada;
    }
    public Float getValordeducaomoedanegociada() {
        return this.valordeducaomoedanegociada;
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
        sb.append(codigometododeducaovalor);
        sb.append("|");
        sb.append(codigomoedanegociadadeducao);
        sb.append("|");
        sb.append(valordeducaomoedanacional);
        sb.append("|");
        sb.append(valordeducaomoedanegociada);
        return sb.toString(); 
    } 


}
