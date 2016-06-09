package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexEspecNcm'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexEspecNcm implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    private Integer id;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------
    // DB : ncm CHAR
    private String ncm;


    // DB : atributo CHAR
    private String atributo;
    // DB : especificacao CHAR
    private String especificacao;

    // DB : nivel CHAR 
    private String nivel;

    // DB : descricao VARCHAR 
    private String descricao;



    //----------------------------------------------------------------------
    // Getter e Setter da chave primaria
    //----------------------------------------------------------------------
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    //----------------------------------------------------------------------
    // Getter e Setter dos outros campos
    //----------------------------------------------------------------------
    public void setNcm( String ncm ) {
        this.ncm = ncm ;
    }

    public String getNcm() {
        return this.ncm;
    }

    public void setAtributo( String atributo ) {
        this.atributo = atributo ;
    }

    public String getAtributo() {
        return this.atributo;
    }

    public void setEspecificacao( String especificacao ) {
        this.especificacao = especificacao ;
    }

    public String getEspecificacao() {
        return this.especificacao;
    }

    public void setNivel( String nivel ) {
        this.nivel = nivel;
    }
    public String getNivel() {
        return this.nivel;
    }

    public void setDescricao( String descricao ) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return this.descricao;
    }


    //----------------------------------------------------------------------
    // Metodo toString
    //----------------------------------------------------------------------


    @Override
    public String toString()
    {
        return "J34SiscomexEspecNcm{" +
                       "id=" + id +
                       ", ncm='" + ncm + '\'' +
                       ", atributo='" + atributo + '\'' +
                       ", especificacao='" + especificacao + '\'' +
                       ", nivel='" + nivel + '\'' +
                       ", descricao='" + descricao + '\'' +
                       '}';
    }
}
