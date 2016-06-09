package br.com.bandoni.dao.tables;

import java.io.Serializable;



/**
 * Java bean para a entidade 'J34SiscomexDeMercAdi'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexDeMercAdi implements Serializable {

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
    // DB : codigopaiscertificado CHAR 
    private String codigopaiscertificado;

    // DB : numerodeadmercosul VARCHAR 
    private String numerodeadmercosul;

    // DB : numerodicertificado VARCHAR 
    private String numerodicertificado;

    // DB : numeroitemcertificado VARCHAR 
    private String numeroitemcertificado;

    // DB : numeroreadfinal VARCHAR 
    private String numeroreadfinal;

    // DB : numeroreadinicial VARCHAR 
    private String numeroreadinicial;

    // DB : quantidadeunidademercosul DECIMAL 
    private Float quantidadeunidademercosul;



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
    public void setCodigopaiscertificado( String codigopaiscertificado ) {
        this.codigopaiscertificado = codigopaiscertificado;
    }
    public String getCodigopaiscertificado() {
        return this.codigopaiscertificado;
    }

    public void setNumerodeadmercosul( String numerodeadmercosul ) {
        this.numerodeadmercosul = numerodeadmercosul;
    }
    public String getNumerodeadmercosul() {
        return this.numerodeadmercosul;
    }

    public void setNumerodicertificado( String numerodicertificado ) {
        this.numerodicertificado = numerodicertificado;
    }
    public String getNumerodicertificado() {
        return this.numerodicertificado;
    }

    public void setNumeroitemcertificado( String numeroitemcertificado ) {
        this.numeroitemcertificado = numeroitemcertificado;
    }
    public String getNumeroitemcertificado() {
        return this.numeroitemcertificado;
    }

    public void setNumeroreadfinal( String numeroreadfinal ) {
        this.numeroreadfinal = numeroreadfinal;
    }
    public String getNumeroreadfinal() {
        return this.numeroreadfinal;
    }

    public void setNumeroreadinicial( String numeroreadinicial ) {
        this.numeroreadinicial = numeroreadinicial;
    }
    public String getNumeroreadinicial() {
        return this.numeroreadinicial;
    }

    public void setQuantidadeunidademercosul( Float quantidadeunidademercosul ) {
        this.quantidadeunidademercosul = quantidadeunidademercosul;
    }
    public Float getQuantidadeunidademercosul() {
        return this.quantidadeunidademercosul;
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
        sb.append(codigopaiscertificado);
        sb.append("|");
        sb.append(numerodeadmercosul);
        sb.append("|");
        sb.append(numerodicertificado);
        sb.append("|");
        sb.append(numeroitemcertificado);
        sb.append("|");
        sb.append(numeroreadfinal);
        sb.append("|");
        sb.append(numeroreadinicial);
        sb.append("|");
        sb.append(quantidadeunidademercosul);
        return sb.toString(); 
    } 


}
