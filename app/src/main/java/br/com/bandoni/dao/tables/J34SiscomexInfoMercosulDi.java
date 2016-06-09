package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexInfoMercosulDi'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexInfoMercosulDi implements Serializable {

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
    // DB : numerodemercosul VARCHAR 
    private String numerodemercosul;

    // DB : numerorefinal CHAR 
    private String numerorefinal;

    // DB : numeroreinicial CHAR 
    private String numeroreinicial;



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
    public void setNumerodemercosul( String numerodemercosul ) {
        this.numerodemercosul = numerodemercosul;
    }
    public String getNumerodemercosul() {
        return this.numerodemercosul;
    }

    public void setNumerorefinal( String numerorefinal ) {
        this.numerorefinal = numerorefinal;
    }
    public String getNumerorefinal() {
        return this.numerorefinal;
    }

    public void setNumeroreinicial( String numeroreinicial ) {
        this.numeroreinicial = numeroreinicial;
    }
    public String getNumeroreinicial() {
        return this.numeroreinicial;
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
        sb.append(numerodemercosul);
        sb.append("|");
        sb.append(numerorefinal);
        sb.append("|");
        sb.append(numeroreinicial);
        return sb.toString(); 
    } 


}
