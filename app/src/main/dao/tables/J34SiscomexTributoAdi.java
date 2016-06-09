package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexTributoAdi'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexTributoAdi implements Serializable {

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
    // DB : codigoreceitaimposto CHAR 
    private String codigoreceitaimposto;

    // DB : codigotipoaliquotaipt CHAR 
    private String codigotipoaliquotaipt;

    // DB : codigotipobeneficioipi CHAR 
    private String codigotipobeneficioipi;

    // DB : codigotipodireito CHAR 
    private String codigotipodireito;

    // DB : codigotiporecipiente CHAR 
    private String codigotiporecipiente;

    // DB : nomeunidadeespecificaaliquotaipt VARCHAR 
    private String nomeunidadeespecificaaliquotaipt;

    // DB : numeronotacomplementartipi DECIMAL 
    private Float numeronotacomplementartipi;

    // DB : percentualaliquotaacordotarifario DECIMAL 
    private Float percentualaliquotaacordotarifario;

    // DB : percentualaliquotanormaladval DECIMAL 
    private Float percentualaliquotanormaladval;

    // DB : percentualaliquotareduzida DECIMAL 
    private Float percentualaliquotareduzida;

    // DB : percentualreducaoipt DECIMAL 
    private Float percentualreducaoipt;

    // DB : quantidademlrecipiente DECIMAL 
    private Float quantidademlrecipiente;

    // DB : quantidademercadoriaunidadealiquotaespecifica DECIMAL 
    private Float quantidademercadoriaunidadealiquotaespecifica;

    // DB : valoraliquotaespecificaipt DECIMAL 
    private Float valoraliquotaespecificaipt;

    // DB : valorbasecalculoadval DECIMAL 
    private Float valorbasecalculoadval;

    // DB : valorcalculadoiiactarifario DECIMAL 
    private Float valorcalculadoiiactarifario;

    // DB : valorcalculoiptespecifica DECIMAL 
    private Float valorcalculoiptespecifica;

    // DB : valorcalculoiptadval DECIMAL 
    private Float valorcalculoiptadval;

    // DB : valoriptarecolher DECIMAL 
    private Float valoriptarecolher;

    // DB : valorimpostodevido DECIMAL 
    private Float valorimpostodevido;



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
    public void setCodigoreceitaimposto( String codigoreceitaimposto ) {
        this.codigoreceitaimposto = codigoreceitaimposto;
    }
    public String getCodigoreceitaimposto() {
        return this.codigoreceitaimposto;
    }

    public void setCodigotipoaliquotaipt( String codigotipoaliquotaipt ) {
        this.codigotipoaliquotaipt = codigotipoaliquotaipt;
    }
    public String getCodigotipoaliquotaipt() {
        return this.codigotipoaliquotaipt;
    }

    public void setCodigotipobeneficioipi( String codigotipobeneficioipi ) {
        this.codigotipobeneficioipi = codigotipobeneficioipi;
    }
    public String getCodigotipobeneficioipi() {
        return this.codigotipobeneficioipi;
    }

    public void setCodigotipodireito( String codigotipodireito ) {
        this.codigotipodireito = codigotipodireito;
    }
    public String getCodigotipodireito() {
        return this.codigotipodireito;
    }

    public void setCodigotiporecipiente( String codigotiporecipiente ) {
        this.codigotiporecipiente = codigotiporecipiente;
    }
    public String getCodigotiporecipiente() {
        return this.codigotiporecipiente;
    }

    public void setNomeunidadeespecificaaliquotaipt( String nomeunidadeespecificaaliquotaipt ) {
        this.nomeunidadeespecificaaliquotaipt = nomeunidadeespecificaaliquotaipt;
    }
    public String getNomeunidadeespecificaaliquotaipt() {
        return this.nomeunidadeespecificaaliquotaipt;
    }

    public void setNumeronotacomplementartipi( Float numeronotacomplementartipi ) {
        this.numeronotacomplementartipi = numeronotacomplementartipi;
    }
    public Float getNumeronotacomplementartipi() {
        return this.numeronotacomplementartipi;
    }

    public void setPercentualaliquotaacordotarifario( Float percentualaliquotaacordotarifario ) {
        this.percentualaliquotaacordotarifario = percentualaliquotaacordotarifario;
    }
    public Float getPercentualaliquotaacordotarifario() {
        return this.percentualaliquotaacordotarifario;
    }

    public void setPercentualaliquotanormaladval( Float percentualaliquotanormaladval ) {
        this.percentualaliquotanormaladval = percentualaliquotanormaladval;
    }
    public Float getPercentualaliquotanormaladval() {
        return this.percentualaliquotanormaladval;
    }

    public void setPercentualaliquotareduzida( Float percentualaliquotareduzida ) {
        this.percentualaliquotareduzida = percentualaliquotareduzida;
    }
    public Float getPercentualaliquotareduzida() {
        return this.percentualaliquotareduzida;
    }

    public void setPercentualreducaoipt( Float percentualreducaoipt ) {
        this.percentualreducaoipt = percentualreducaoipt;
    }
    public Float getPercentualreducaoipt() {
        return this.percentualreducaoipt;
    }

    public void setQuantidademlrecipiente( Float quantidademlrecipiente ) {
        this.quantidademlrecipiente = quantidademlrecipiente;
    }
    public Float getQuantidademlrecipiente() {
        return this.quantidademlrecipiente;
    }

    public void setQuantidademercadoriaunidadealiquotaespecifica( Float quantidademercadoriaunidadealiquotaespecifica ) {
        this.quantidademercadoriaunidadealiquotaespecifica = quantidademercadoriaunidadealiquotaespecifica;
    }
    public Float getQuantidademercadoriaunidadealiquotaespecifica() {
        return this.quantidademercadoriaunidadealiquotaespecifica;
    }

    public void setValoraliquotaespecificaipt( Float valoraliquotaespecificaipt ) {
        this.valoraliquotaespecificaipt = valoraliquotaespecificaipt;
    }
    public Float getValoraliquotaespecificaipt() {
        return this.valoraliquotaespecificaipt;
    }

    public void setValorbasecalculoadval( Float valorbasecalculoadval ) {
        this.valorbasecalculoadval = valorbasecalculoadval;
    }
    public Float getValorbasecalculoadval() {
        return this.valorbasecalculoadval;
    }

    public void setValorcalculadoiiactarifario( Float valorcalculadoiiactarifario ) {
        this.valorcalculadoiiactarifario = valorcalculadoiiactarifario;
    }
    public Float getValorcalculadoiiactarifario() {
        return this.valorcalculadoiiactarifario;
    }

    public void setValorcalculoiptespecifica( Float valorcalculoiptespecifica ) {
        this.valorcalculoiptespecifica = valorcalculoiptespecifica;
    }
    public Float getValorcalculoiptespecifica() {
        return this.valorcalculoiptespecifica;
    }

    public void setValorcalculoiptadval( Float valorcalculoiptadval ) {
        this.valorcalculoiptadval = valorcalculoiptadval;
    }
    public Float getValorcalculoiptadval() {
        return this.valorcalculoiptadval;
    }

    public void setValoriptarecolher( Float valoriptarecolher ) {
        this.valoriptarecolher = valoriptarecolher;
    }
    public Float getValoriptarecolher() {
        return this.valoriptarecolher;
    }

    public void setValorimpostodevido( Float valorimpostodevido ) {
        this.valorimpostodevido = valorimpostodevido;
    }
    public Float getValorimpostodevido() {
        return this.valorimpostodevido;
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
        sb.append(codigoreceitaimposto);
        sb.append("|");
        sb.append(codigotipoaliquotaipt);
        sb.append("|");
        sb.append(codigotipobeneficioipi);
        sb.append("|");
        sb.append(codigotipodireito);
        sb.append("|");
        sb.append(codigotiporecipiente);
        sb.append("|");
        sb.append(nomeunidadeespecificaaliquotaipt);
        sb.append("|");
        sb.append(numeronotacomplementartipi);
        sb.append("|");
        sb.append(percentualaliquotaacordotarifario);
        sb.append("|");
        sb.append(percentualaliquotanormaladval);
        sb.append("|");
        sb.append(percentualaliquotareduzida);
        sb.append("|");
        sb.append(percentualreducaoipt);
        sb.append("|");
        sb.append(quantidademlrecipiente);
        sb.append("|");
        sb.append(quantidademercadoriaunidadealiquotaespecifica);
        sb.append("|");
        sb.append(valoraliquotaespecificaipt);
        sb.append("|");
        sb.append(valorbasecalculoadval);
        sb.append("|");
        sb.append(valorcalculadoiiactarifario);
        sb.append("|");
        sb.append(valorcalculoiptespecifica);
        sb.append("|");
        sb.append(valorcalculoiptadval);
        sb.append("|");
        sb.append(valoriptarecolher);
        sb.append("|");
        sb.append(valorimpostodevido);
        return sb.toString(); 
    } 


}
