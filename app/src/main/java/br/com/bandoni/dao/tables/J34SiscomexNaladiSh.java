package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexNaladiSh'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexNaladiSh implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : codigo CHAR 
    private String codigo;
    // DB : ordem CHAR 
    private String ordem;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------    
    // DB : descricao VARCHAR 
    private String descricao;



    //----------------------------------------------------------------------
    // Getter e Setter da chave primaria
    //----------------------------------------------------------------------
    public void setCodigo( String codigo ) {
        this.codigo = codigo ;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setOrdem( String ordem ) {
        this.ordem = ordem ;
    }

    public String getOrdem() {
        return this.ordem;
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
        sb.append(codigo);
        sb.append("|");
        sb.append(ordem);
        sb.append("|");
        sb.append(descricao);
        return sb.toString(); 
    } 


}
