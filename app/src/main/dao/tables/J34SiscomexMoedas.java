package br.com.bandoni.dao.tables;

import java.io.Serializable;
import java.util.Date;

/**
 * Java bean para a entidade 'J34SiscomexMoedas'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexMoedas implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : idmoeda INT 
    private Integer idmoeda;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------    
    // DB : codigo INT UNSIGNED 
    private Integer codigo;

    // DB : nome VARCHAR 
    private String nome;

    // DB : simbolo VARCHAR 
    private String simbolo;

    // DB : pais CHAR 
    private String pais;

    // DB : tipo CHAR 
    private String tipo;

    // DB : dataexclusao DATE 
    private Date dataexclusao;



    //----------------------------------------------------------------------
    // Getter e Setter da chave primaria
    //----------------------------------------------------------------------
    public void setIdmoeda( Integer idmoeda ) {
        this.idmoeda = idmoeda ;
    }

    public Integer getIdmoeda() {
        return this.idmoeda;
    }


    //----------------------------------------------------------------------
    // Getter e Setter dos outros campos
    //----------------------------------------------------------------------
    public void setCodigo( Integer codigo ) {
        this.codigo = codigo;
    }
    public Integer getCodigo() {
        return this.codigo;
    }

    public void setNome( String nome ) {
        this.nome = nome;
    }
    public String getNome() {
        return this.nome;
    }

    public void setSimbolo( String simbolo ) {
        this.simbolo = simbolo;
    }
    public String getSimbolo() {
        return this.simbolo;
    }

    public void setPais( String pais ) {
        this.pais = pais;
    }
    public String getPais() {
        return this.pais;
    }

    public void setTipo( String tipo ) {
        this.tipo = tipo;
    }
    public String getTipo() {
        return this.tipo;
    }

    public void setDataexclusao( Date dataexclusao ) {
        this.dataexclusao = dataexclusao;
    }
    public Date getDataexclusao() {
        return this.dataexclusao;
    }


    //----------------------------------------------------------------------
    // Metodo toString
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(idmoeda);
        sb.append("|");
        sb.append(codigo);
        sb.append("|");
        sb.append(nome);
        sb.append("|");
        sb.append(simbolo);
        sb.append("|");
        sb.append(pais);
        sb.append("|");
        sb.append(tipo);
        sb.append("|");
        sb.append(dataexclusao);
        return sb.toString(); 
    } 


}
