package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexEstado'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexEstado implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : estado_id CHAR 
    private String estado_id;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------    
    // DB : sigla CHAR 
    private String sigla;

    // DB : nome VARCHAR 
    private String nome;



    //----------------------------------------------------------------------
    // Getter e Setter da chave primaria
    //----------------------------------------------------------------------
    public void setEstado_id( String estado_id ) {
        this.estado_id = estado_id ;
    }

    public String getEstado_id() {
        return this.estado_id;
    }


    //----------------------------------------------------------------------
    // Getter e Setter dos outros campos
    //----------------------------------------------------------------------
    public void setSigla( String sigla ) {
        this.sigla = sigla;
    }
    public String getSigla() {
        return this.sigla;
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
        sb.append(estado_id);
        sb.append("|");
        sb.append(sigla);
        sb.append("|");
        sb.append(nome);
        return sb.toString(); 
    } 


}
