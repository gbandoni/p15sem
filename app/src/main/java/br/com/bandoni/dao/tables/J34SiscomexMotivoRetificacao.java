package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexMotivoRetificacao'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexMotivoRetificacao implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : codigo_motivo TINYINT 
    private Integer codigo_motivo;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------    
    // DB : descricao_motivo VARCHAR 
    private String descricao_motivo;



    //----------------------------------------------------------------------
    // Getter e Setter da chave primaria
    //----------------------------------------------------------------------
    public void setCodigo_motivo( Integer codigo_motivo )
    {
        this.codigo_motivo = codigo_motivo ;
    }

    public Integer getCodigo_motivo()
    {
        return this.codigo_motivo;
    }


    //----------------------------------------------------------------------
    // Getter e Setter dos outros campos
    //----------------------------------------------------------------------
    public void setDescricao_motivo( String descricao_motivo )
    {
        this.descricao_motivo = descricao_motivo;
    }

    public String getDescricao_motivo()
    {
        return this.descricao_motivo;
    }


    //----------------------------------------------------------------------
    // Metodo toString
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(codigo_motivo);
        sb.append("|");
        sb.append(descricao_motivo);
        return sb.toString(); 
    } 


}
