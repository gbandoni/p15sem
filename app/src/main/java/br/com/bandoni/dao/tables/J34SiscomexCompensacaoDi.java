package br.com.bandoni.dao.tables;

import java.io.Serializable;



/**
 * Java bean para a entidade 'J34SiscomexCompensacaoDi'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexCompensacaoDi implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : numerodocumentocarga CHAR 
    private String numerodocumentocarga;
    // DB : ordem INT 
    private Integer ordem;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------    
    // DB : codigoreceitacredito CHAR 
    private String codigoreceitacredito;

    // DB : numerodocumentogeradorcredito VARCHAR 
    private String numerodocumentogeradorcredito;

    // DB : valorcompensarcredito DECIMAL 
    private Float valorcompensarcredito;



    //----------------------------------------------------------------------
    // Getter e Setter da chave primaria
    //----------------------------------------------------------------------
    public void setNumerodocumentocarga( String numerodocumentocarga ) {
        this.numerodocumentocarga = numerodocumentocarga ;
    }

    public String getNumerodocumentocarga() {
        return this.numerodocumentocarga;
    }

    public void setOrdem( Integer ordem ) {
        this.ordem = ordem ;
    }

    public Integer getOrdem() {
        return this.ordem;
    }


    //----------------------------------------------------------------------
    // Getter e Setter dos outros campos
    //----------------------------------------------------------------------
    public void setCodigoreceitacredito( String codigoreceitacredito ) {
        this.codigoreceitacredito = codigoreceitacredito;
    }
    public String getCodigoreceitacredito() {
        return this.codigoreceitacredito;
    }

    public void setNumerodocumentogeradorcredito( String numerodocumentogeradorcredito ) {
        this.numerodocumentogeradorcredito = numerodocumentogeradorcredito;
    }
    public String getNumerodocumentogeradorcredito() {
        return this.numerodocumentogeradorcredito;
    }

    public void setValorcompensarcredito( Float valorcompensarcredito ) {
        this.valorcompensarcredito = valorcompensarcredito;
    }
    public Float getValorcompensarcredito() {
        return this.valorcompensarcredito;
    }


    //----------------------------------------------------------------------
    // Metodo toString
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(numerodocumentocarga);
        sb.append("|");
        sb.append(ordem);
        sb.append("|");
        sb.append(codigoreceitacredito);
        sb.append("|");
        sb.append(numerodocumentogeradorcredito);
        sb.append("|");
        sb.append(valorcompensarcredito);
        return sb.toString(); 
    } 


}
