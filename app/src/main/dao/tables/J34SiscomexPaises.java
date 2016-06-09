package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexPaises'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexPaises implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : codigo_pais CHAR 
    private String codigo_pais;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------    
    // DB : nome_pais VARCHAR 
    private String nome_pais;



    //----------------------------------------------------------------------
    // Getter e Setter da chave primaria
    //----------------------------------------------------------------------
    public void setCodigo_pais( String codigo_pais ) {
        this.codigo_pais = codigo_pais ;
    }

    public String getCodigo_pais() {
        return this.codigo_pais;
    }


    //----------------------------------------------------------------------
    // Getter e Setter dos outros campos
    //----------------------------------------------------------------------
    public void setNome_pais( String nome_pais ) {
        this.nome_pais = nome_pais;
    }
    public String getNome_pais() {
        return this.nome_pais;
    }


    //----------------------------------------------------------------------
    // Metodo toString
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(codigo_pais);
        sb.append("|");
        sb.append(nome_pais);
        return sb.toString(); 
    } 


}
