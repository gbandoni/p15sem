package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexTipoDeclaracao'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexTipoDeclaracao implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : codigo_tipo INT 
    private Integer codigo_tipo;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------    
    // DB : tipo_declaracao CHAR 
    private String tipo_declaracao;

    // DB : descricao_tipo VARCHAR 
    private String descricao_tipo;



    //----------------------------------------------------------------------
    // Getter e Setter da chave primaria
    //----------------------------------------------------------------------
    public void setCodigo_tipo( Integer codigo_tipo ) {
        this.codigo_tipo = codigo_tipo ;
    }

    public Integer getCodigo_tipo() {
        return this.codigo_tipo;
    }


    //----------------------------------------------------------------------
    // Getter e Setter dos outros campos
    //----------------------------------------------------------------------
    public void setTipo_declaracao( String tipo_declaracao ) {
        this.tipo_declaracao = tipo_declaracao;
    }
    public String getTipo_declaracao() {
        return this.tipo_declaracao;
    }

    public void setDescricao_tipo( String descricao_tipo ) {
        this.descricao_tipo = descricao_tipo;
    }
    public String getDescricao_tipo() {
        return this.descricao_tipo;
    }


    //----------------------------------------------------------------------
    // Metodo toString
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(codigo_tipo);
        sb.append("|");
        sb.append(tipo_declaracao);
        sb.append("|");
        sb.append(descricao_tipo);
        return sb.toString(); 
    } 


}
