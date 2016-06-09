package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexOrigemDi'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexOrigemDi implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : ID CHAR 
    private String id;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------    
    // DB : descricao VARCHAR 
    private String descricao;



    //----------------------------------------------------------------------
    // Getter e Setter da chave primaria
    //----------------------------------------------------------------------
    public void setId( String id ) {
        this.id = id ;
    }

    public String getId() {
        return this.id;
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


    //----------------------------------------------------------------------
    // Metodo toString
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(descricao);
        return sb.toString(); 
    } 


}
