package br.com.bandoni.dao.tables;

import java.io.Serializable;


import java.util.Date;

/**
 * Java bean para a entidade 'J34SiscomexImpostosDi'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexImpostosDi implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : numerodocumentocarga CHAR 
    private String numerodocumentocarga;
    // DB : ordem INT 
    private Integer ordem;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------    
    // DB : codigobancopagamentotributo CHAR 
    private String codigobancopagamentotributo;

    // DB : codigoreceitapagamento CHAR 
    private String codigoreceitapagamento;

    // DB : datapagamentotributo DATETIME 
    private Date datapagamentotributo;

    // DB : numeroagenciapagamentotributo CHAR 
    private String numeroagenciapagamentotributo;

    // DB : valorjurospagamentotributo DECIMAL 
    private Float valorjurospagamentotributo;

    // DB : valormultapagamentotributo DECIMAL 
    private Float valormultapagamentotributo;

    // DB : valortributopago DECIMAL 
    private Float valortributopago;



    //----------------------------------------------------------------------
    // Getter e Setter da chave primaria
    //----------------------------------------------------------------------
    public void setNumerodocumentocarga( String numerodocumentocarga ) {
        this.numerodocumentocarga = numerodocumentocarga ;
    }

    public String getNumerodocumentocarga() {
        return this.numerodocumentocarga;
    }

    public void setOrdem( Integer ordem ) {
        this.ordem = ordem ;
    }

    public Integer getOrdem() {
        return this.ordem;
    }


    //----------------------------------------------------------------------
    // Getter e Setter dos outros campos
    //----------------------------------------------------------------------
    public void setCodigobancopagamentotributo( String codigobancopagamentotributo ) {
        this.codigobancopagamentotributo = codigobancopagamentotributo;
    }
    public String getCodigobancopagamentotributo() {
        return this.codigobancopagamentotributo;
    }

    public void setCodigoreceitapagamento( String codigoreceitapagamento ) {
        this.codigoreceitapagamento = codigoreceitapagamento;
    }
    public String getCodigoreceitapagamento() {
        return this.codigoreceitapagamento;
    }

    public void setDatapagamentotributo( Date datapagamentotributo ) {
        this.datapagamentotributo = datapagamentotributo;
    }
    public Date getDatapagamentotributo() {
        return this.datapagamentotributo;
    }

    public void setNumeroagenciapagamentotributo( String numeroagenciapagamentotributo ) {
        this.numeroagenciapagamentotributo = numeroagenciapagamentotributo;
    }
    public String getNumeroagenciapagamentotributo() {
        return this.numeroagenciapagamentotributo;
    }

    public void setValorjurospagamentotributo( Float valorjurospagamentotributo ) {
        this.valorjurospagamentotributo = valorjurospagamentotributo;
    }
    public Float getValorjurospagamentotributo() {
        return this.valorjurospagamentotributo;
    }

    public void setValormultapagamentotributo( Float valormultapagamentotributo ) {
        this.valormultapagamentotributo = valormultapagamentotributo;
    }
    public Float getValormultapagamentotributo() {
        return this.valormultapagamentotributo;
    }

    public void setValortributopago( Float valortributopago ) {
        this.valortributopago = valortributopago;
    }
    public Float getValortributopago() {
        return this.valortributopago;
    }


    //----------------------------------------------------------------------
    // Metodo toString
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(numerodocumentocarga);
        sb.append("|");
        sb.append(ordem);
        sb.append("|");
        sb.append(codigobancopagamentotributo);
        sb.append("|");
        sb.append(codigoreceitapagamento);
        sb.append("|");
        sb.append(datapagamentotributo);
        sb.append("|");
        sb.append(numeroagenciapagamentotributo);
        sb.append("|");
        sb.append(valorjurospagamentotributo);
        sb.append("|");
        sb.append(valormultapagamentotributo);
        sb.append("|");
        sb.append(valortributopago);
        return sb.toString(); 
    } 


}
