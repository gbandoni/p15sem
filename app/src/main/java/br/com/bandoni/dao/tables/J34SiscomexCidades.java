package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexCidades'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexCidades implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : codmun CHAR 
    private String codmun;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------    
    // DB : estado CHAR 
    private String estado;

    // DB : nome VARCHAR 
    private String nome;

    public String getEstado_id()
    {
        return estado_id;
    }

    public void setEstado_id(String estado_id)
    {
        this.estado_id = estado_id;
    }

    private String estado_id;


    //----------------------------------------------------------------------
    // Getter e Setter da chave primaria
    //----------------------------------------------------------------------
    public void setCodmun( String codmun ) {
        this.codmun = codmun ;
    }

    public String getCodmun() {
        return this.codmun;
    }


    //----------------------------------------------------------------------
    // Getter e Setter dos outros campos
    //----------------------------------------------------------------------
    public void setEstado( String estado ) {
        this.estado = estado;
    }
    public String getEstado() {
        return this.estado;
    }

    public void setNome( String nome ) {
        this.nome = nome;
    }
    public String getNome() {
        return this.nome;
    }


    //----------------------------------------------------------------------
    // Metodo toString
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(estado);
        sb.append("|");
        sb.append(codmun);
        sb.append("|");
        sb.append(nome);
        return sb.toString(); 
    } 


}
