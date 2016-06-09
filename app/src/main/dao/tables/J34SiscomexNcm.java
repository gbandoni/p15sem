package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexNcm'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexNcm implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : codigoncm VARCHAR 
    private String codigoncm;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------    
    // DB : descricao VARCHAR 
    private String descricao;

    // DB : um VARCHAR 
    private String um;



    //----------------------------------------------------------------------
    // Getter e Setter da chave primaria
    //----------------------------------------------------------------------
    public void setCodigoncm( String codigoncm ) {
        this.codigoncm = codigoncm ;
    }

    public String getCodigoncm() {
        return this.codigoncm;
    }


    //----------------------------------------------------------------------
    // Getter e Setter dos outros campos
    //----------------------------------------------------------------------
    public void setDescricao( String descricao ) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return this.descricao;
    }

    public void setUm( String um ) {
        this.um = um;
    }
    public String getUm() {
        return this.um;
    }


    //----------------------------------------------------------------------
    // Metodo toString
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(codigoncm);
        sb.append("|");
        sb.append(descricao);
        sb.append("|");
        sb.append(um);
        return sb.toString(); 
    } 


}
