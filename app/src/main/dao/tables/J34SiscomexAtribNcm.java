package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexAtribNcm'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexAtribNcm implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : ncm CHAR 
    private String ncm;
    // DB : atributoncm CHAR 
    private String atributoncm;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------    
    // DB : multiplo CHAR 
    private String multiplo;

    // DB : nivel CHAR 
    private String nivel;

    // DB : atributo VARCHAR 
    private String atributo;



    //----------------------------------------------------------------------
    // Getter e Setter da chave primaria
    //----------------------------------------------------------------------
    public void setNcm( String ncm ) {
        this.ncm = ncm ;
    }

    public String getNcm() {
        return this.ncm;
    }

    public void setAtributoncm( String atributoncm ) {
        this.atributoncm = atributoncm ;
    }

    public String getAtributoncm() {
        return this.atributoncm;
    }


    //----------------------------------------------------------------------
    // Getter e Setter dos outros campos
    //----------------------------------------------------------------------
    public void setMultiplo( String multiplo ) {
        this.multiplo = multiplo;
    }
    public String getMultiplo() {
        return this.multiplo;
    }

    public void setNivel( String nivel ) {
        this.nivel = nivel;
    }
    public String getNivel() {
        return this.nivel;
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
        sb.append(ncm);
        sb.append("|");
        sb.append(atributoncm);
        sb.append("|");
        sb.append(multiplo);
        sb.append("|");
        sb.append(nivel);
        sb.append("|");
        sb.append(atributo);
        return sb.toString(); 
    } 


}
