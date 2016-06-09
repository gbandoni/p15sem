package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexModdespacho'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexModdespacho implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : codigo_modalidade TINYINT 
    private Integer codigo_modalidade;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------    
    // DB : nome_modalidade VARCHAR 
    private String nome_modalidade;



    //----------------------------------------------------------------------
    // Getter e Setter da chave primaria
    //----------------------------------------------------------------------
    public void setCodigo_modalidade( Integer codigo_modalidade )
    {
        this.codigo_modalidade = codigo_modalidade ;
    }

    public Integer getCodigo_modalidade()
    {
        return this.codigo_modalidade;
    }


    //----------------------------------------------------------------------
    // Getter e Setter dos outros campos
    //----------------------------------------------------------------------
    public void setNome_modalidade( String nome_modalidade ) {
        this.nome_modalidade = nome_modalidade;
    }
    public String getNome_modalidade() {
        return this.nome_modalidade;
    }


    //----------------------------------------------------------------------
    // Metodo toString
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(codigo_modalidade);
        sb.append("|");
        sb.append(nome_modalidade);
        return sb.toString(); 
    } 


}
