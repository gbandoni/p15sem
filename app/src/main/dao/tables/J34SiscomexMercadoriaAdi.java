package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexMercadoriaAdi'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexMercadoriaAdi implements Serializable {

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
    // DB : nomeunidademedidacomercializada VARCHAR 
    private String nomeunidademedidacomercializada;

    // DB : quantidademercadoriaunidadecomercializada DECIMAL 
    private Float quantidademercadoriaunidadecomercializada;

    // DB : textodetalhamentomercadoria TEXT 
    private String textodetalhamentomercadoria;

    // DB : valorunidadelocalembarque DECIMAL 
    private Float valorunidadelocalembarque;

    // DB : valorunidademedidacondicaovenda DECIMAL 
    private Float valorunidademedidacondicaovenda;



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
    public void setNomeunidademedidacomercializada( String nomeunidademedidacomercializada ) {
        this.nomeunidademedidacomercializada = nomeunidademedidacomercializada;
    }
    public String getNomeunidademedidacomercializada() {
        return this.nomeunidademedidacomercializada;
    }

    public void setQuantidademercadoriaunidadecomercializada( Float quantidademercadoriaunidadecomercializada ) {
        this.quantidademercadoriaunidadecomercializada = quantidademercadoriaunidadecomercializada;
    }
    public Float getQuantidademercadoriaunidadecomercializada() {
        return this.quantidademercadoriaunidadecomercializada;
    }

    public void setTextodetalhamentomercadoria( String textodetalhamentomercadoria ) {
        this.textodetalhamentomercadoria = textodetalhamentomercadoria;
    }
    public String getTextodetalhamentomercadoria() {
        return this.textodetalhamentomercadoria;
    }

    public void setValorunidadelocalembarque( Float valorunidadelocalembarque ) {
        this.valorunidadelocalembarque = valorunidadelocalembarque;
    }
    public Float getValorunidadelocalembarque() {
        return this.valorunidadelocalembarque;
    }

    public void setValorunidademedidacondicaovenda( Float valorunidademedidacondicaovenda ) {
        this.valorunidademedidacondicaovenda = valorunidademedidacondicaovenda;
    }
    public Float getValorunidademedidacondicaovenda() {
        return this.valorunidademedidacondicaovenda;
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
        sb.append(nomeunidademedidacomercializada);
        sb.append("|");
        sb.append(quantidademercadoriaunidadecomercializada);
        // attribute 'textodetalhamentomercadoria' not usable (type = String Long Text)
        sb.append("|");
        sb.append(valorunidadelocalembarque);
        sb.append("|");
        sb.append(valorunidademedidacondicaovenda);
        return sb.toString(); 
    } 


}
