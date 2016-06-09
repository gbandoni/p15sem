package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexVeiculos'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexVeiculos implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : id INT 
    private Integer id;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------    
    // DB : codtransportador INT 
    private Integer codtransportador;

    // DB : numeroveiculo VARCHAR 
    private String numeroveiculo;

    // DB : nomeveiculo VARCHAR 
    private String nomeveiculo;



    //----------------------------------------------------------------------
    // Getter e Setter da chave primaria
    //----------------------------------------------------------------------
    public void setId( Integer id ) {
        this.id = id ;
    }

    public Integer getId() {
        return this.id;
    }


    //----------------------------------------------------------------------
    // Getter e Setter dos outros campos
    //----------------------------------------------------------------------
    public void setCodtransportador( Integer codtransportador ) {
        this.codtransportador = codtransportador;
    }
    public Integer getCodtransportador() {
        return this.codtransportador;
    }

    public void setNumeroveiculo( String numeroveiculo ) {
        this.numeroveiculo = numeroveiculo;
    }
    public String getNumeroveiculo() {
        return this.numeroveiculo;
    }

    public void setNomeveiculo( String nomeveiculo ) {
        this.nomeveiculo = nomeveiculo;
    }
    public String getNomeveiculo() {
        return this.nomeveiculo;
    }


    //----------------------------------------------------------------------
    // Metodo toString
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(codtransportador);
        sb.append("|");
        sb.append(numeroveiculo);
        sb.append("|");
        sb.append(nomeveiculo);
        return sb.toString(); 
    } 


}
