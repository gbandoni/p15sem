package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexDocCargaDi'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexDocCargaDi implements Serializable {

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
    // DB : codigotipoembalagemcarga INT 
    private Integer codigotipoembalagemcarga;

    // DB : quantidadevolumecarga INT 
    private Integer quantidadevolumecarga;



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

    public void setOrdem( String ordem )
    {
        this.ordem = Integer.parseInt(ordem) ;
    }

    public Integer getOrdem() {
        return this.ordem;
    }


    //----------------------------------------------------------------------
    // Getter e Setter dos outros campos
    //----------------------------------------------------------------------
    public void setCodigotipoembalagemcarga( Integer codigotipoembalagemcarga ) {
        this.codigotipoembalagemcarga = codigotipoembalagemcarga;
    }
    public Integer getCodigotipoembalagemcarga() {
        return this.codigotipoembalagemcarga;
    }

    public void setQuantidadevolumecarga( Integer quantidadevolumecarga ) {
        this.quantidadevolumecarga = quantidadevolumecarga;
    }
    public Integer getQuantidadevolumecarga() {
        return this.quantidadevolumecarga;
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
        sb.append(codigotipoembalagemcarga);
        sb.append("|");
        sb.append(quantidadevolumecarga);
        return sb.toString(); 
    } 


}
