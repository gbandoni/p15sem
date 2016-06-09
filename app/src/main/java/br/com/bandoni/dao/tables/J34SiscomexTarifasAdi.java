package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexTarifasAdi'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexTarifasAdi implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : numerodocumentocarga CHAR 
    private String numerodocumentocarga;
    // DB : numeroadicao CHAR 
    private String numeroadicao;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------    
    // DB : codigoassuntovinculado CHAR 
    private String codigoassuntovinculado;

    // DB : dataanoatovinculado CHAR 
    private String dataanoatovinculado;

    // DB : numeroatovinculado VARCHAR 
    private String numeroatovinculado;

    // DB : numeroexatovinculado VARCHAR 
    private String numeroexatovinculado;

    // DB : siglaorgaoatovinculado VARCHAR 
    private String siglaorgaoatovinculado;

    // DB : siglatipoatovinculado VARCHAR 
    private String siglatipoatovinculado;



    //----------------------------------------------------------------------
    // Getter e Setter da chave primaria
    //----------------------------------------------------------------------
    public void setNumerodocumentocarga( String numerodocumentocarga ) {
        this.numerodocumentocarga = numerodocumentocarga ;
    }

    public String getNumerodocumentocarga() {
        return this.numerodocumentocarga;
    }

    public void setNumeroadicao( String numeroadicao ) {
        this.numeroadicao = numeroadicao ;
    }

    public String getNumeroadicao() {
        return this.numeroadicao;
    }


    //----------------------------------------------------------------------
    // Getter e Setter dos outros campos
    //----------------------------------------------------------------------
    public void setCodigoassuntovinculado( String codigoassuntovinculado ) {
        this.codigoassuntovinculado = codigoassuntovinculado;
    }
    public String getCodigoassuntovinculado() {
        return this.codigoassuntovinculado;
    }

    public void setDataanoatovinculado( String dataanoatovinculado ) {
        this.dataanoatovinculado = dataanoatovinculado;
    }
    public String getDataanoatovinculado() {
        return this.dataanoatovinculado;
    }

    public void setNumeroatovinculado( String numeroatovinculado ) {
        this.numeroatovinculado = numeroatovinculado;
    }
    public String getNumeroatovinculado() {
        return this.numeroatovinculado;
    }

    public void setNumeroexatovinculado( String numeroexatovinculado ) {
        this.numeroexatovinculado = numeroexatovinculado;
    }
    public String getNumeroexatovinculado() {
        return this.numeroexatovinculado;
    }

    public void setSiglaorgaoatovinculado( String siglaorgaoatovinculado ) {
        this.siglaorgaoatovinculado = siglaorgaoatovinculado;
    }
    public String getSiglaorgaoatovinculado() {
        return this.siglaorgaoatovinculado;
    }

    public void setSiglatipoatovinculado( String siglatipoatovinculado ) {
        this.siglatipoatovinculado = siglatipoatovinculado;
    }
    public String getSiglatipoatovinculado() {
        return this.siglatipoatovinculado;
    }


    //----------------------------------------------------------------------
    // Metodo toString
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(numerodocumentocarga);
        sb.append("|");
        sb.append(numeroadicao);
        sb.append("|");
        sb.append(codigoassuntovinculado);
        sb.append("|");
        sb.append(dataanoatovinculado);
        sb.append("|");
        sb.append(numeroatovinculado);
        sb.append("|");
        sb.append(numeroexatovinculado);
        sb.append("|");
        sb.append(siglaorgaoatovinculado);
        sb.append("|");
        sb.append(siglatipoatovinculado);
        return sb.toString(); 
    } 


}
