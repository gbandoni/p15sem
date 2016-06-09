package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexTipoEmbalagem'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexTipoEmbalagem implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : codigo INT 
    private Integer codigo;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------    
    // DB : descricao VARCHAR 
    private String descricao;



    //----------------------------------------------------------------------
    // Getter e Setter da chave primaria
    //----------------------------------------------------------------------
    public void setCodigo( Integer codigo ) {
        this.codigo = codigo ;
    }

    public Integer getCodigo() {
        return this.codigo;
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
        sb.append(descricao);
        return sb.toString(); 
    } 


}
