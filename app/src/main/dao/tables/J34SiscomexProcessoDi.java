package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexProcessoDi'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexProcessoDi implements Serializable {

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
    // DB : codigotipoprocesso INT 
    private Integer codigotipoprocesso;

    // DB : numeroprocesso VARCHAR 
    private String numeroprocesso;



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
    public void setCodigotipoprocesso( Integer codigotipoprocesso ) {
        this.codigotipoprocesso = codigotipoprocesso;
    }
    public Integer getCodigotipoprocesso() {
        return this.codigotipoprocesso;
    }

    public void setNumeroprocesso( String numeroprocesso ) {
        this.numeroprocesso = numeroprocesso;
    }
    public String getNumeroprocesso() {
        return this.numeroprocesso;
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
        sb.append(codigotipoprocesso);
        sb.append("|");
        sb.append(numeroprocesso);
        return sb.toString(); 
    } 


}
