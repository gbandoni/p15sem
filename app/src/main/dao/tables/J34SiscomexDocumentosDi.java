package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexDocumentosDi'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexDocumentosDi implements Serializable {

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
    // DB : codigotipodocumentoinstrucaodespacho INT 
    private Integer codigotipodocumentoinstrucaodespacho;

    // DB : numerodocumentoinstrucaodespacho VARCHAR 
    private String numerodocumentoinstrucaodespacho;



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
    public void setCodigotipodocumentoinstrucaodespacho( Integer codigotipodocumentoinstrucaodespacho ) {
        this.codigotipodocumentoinstrucaodespacho = codigotipodocumentoinstrucaodespacho;
    }
    public Integer getCodigotipodocumentoinstrucaodespacho() {
        return this.codigotipodocumentoinstrucaodespacho;
    }

    public void setNumerodocumentoinstrucaodespacho( String numerodocumentoinstrucaodespacho ) {
        this.numerodocumentoinstrucaodespacho = numerodocumentoinstrucaodespacho;
    }
    public String getNumerodocumentoinstrucaodespacho() {
        return this.numerodocumentoinstrucaodespacho;
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
        sb.append(codigotipodocumentoinstrucaodespacho);
        sb.append("|");
        sb.append(numerodocumentoinstrucaodespacho);
        return sb.toString(); 
    } 


}
