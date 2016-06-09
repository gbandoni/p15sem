package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexLocalidadeembarque'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexLocalidadeembarque implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : ID INT 
    private String id;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------    
    // DB : codpais CHAR 
    private String codpais;

    // DB : localidade VARCHAR 
    private String localidade;



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
    public void setCodpais( String codpais ) {
        this.codpais = codpais;
    }
    public String getCodpais() {
        return this.codpais;
    }

    public void setLocalidade( String localidade ) {
        this.localidade = localidade;
    }
    public String getLocalidade() {
        return this.localidade;
    }


    //----------------------------------------------------------------------
    // Metodo toString
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(codpais);
        sb.append("|");
        sb.append(localidade);
        return sb.toString(); 
    } 


}
