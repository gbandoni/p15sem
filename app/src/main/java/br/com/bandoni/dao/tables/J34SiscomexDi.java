package br.com.bandoni.dao.tables;

import java.io.Serializable;


import java.util.Date;

/**
 * Java bean para a entidade 'J34SiscomexDi'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexDi implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : numerodocumentocarga CHAR 
    private String numerodocumentocarga;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------    
    // DB : codigotipodocumentocarga CHAR 
    private String codigotipodocumentocarga;

    // DB : codigomoedaseguro INT 
    private Integer codigomoedaseguro;

    // DB : codigomoedafrete INT 
    private Integer codigomoedafrete;

    // DB : codigomotivotransmissao INT 
    private Integer codigomotivotransmissao;

    // DB : cargapesobruto DECIMAL 
    private Float cargapesobruto;

    // DB : cargapesoliquido DECIMAL 
    private Float cargapesoliquido;

    // DB : codigobandeiratranspote CHAR 
    private String codigobandeiratranspote;

    // DB : codigomodalidadedespacho TINYINT 
    private Integer codigomodalidadedespacho;

    // DB : codigoorigemdi CHAR 
    private String codigoorigemdi;

    // DB : codigopaisprocedenciacarga CHAR 
    private String codigopaisprocedenciacarga;

    // DB : codigopaisimportador CHAR 
    private String codigopaisimportador;

    // DB : codigorecintoalfandegado CHAR 
    private String codigorecintoalfandegado;

    // DB : codigosetorarmazenamento CHAR 
    private String codigosetorarmazenamento;

    // DB : codigotipoagentecarga CHAR 
    private String codigotipoagentecarga;

    // DB : codigotipoconsignatario CHAR 
    private String codigotipoconsignatario;

    // DB : codigotipodeclaracao INT 
    private Integer codigotipodeclaracao;

    // DB : codigotipoimportador INT 
    private Integer codigotipoimportador;

    // DB : codigotipomanifesto INT 
    private Integer codigotipomanifesto;

    // DB : codigotipopagamentotributario CHAR 
    private String codigotipopagamentotributario;

    // DB : codigourfcargaentrada CHAR 
    private String codigourfcargaentrada;

    // DB : codigourfdespacho CHAR 
    private String codigourfdespacho;

    // DB : codigoutilizacaodocumentocarga CHAR 
    private String codigoutilizacaodocumentocarga;

    // DB : codigoviatransporte CHAR 
    private String codigoviatransporte;

    // DB : datachegadacarga DATETIME 
    private Date datachegadacarga;

    // DB : dataembarque DATETIME 
    private Date dataembarque;

    // DB : identificacaodeclaracaoimportacao CHAR 
    private String identificacaodeclaracaoimportacao;

    // DB : codigoimportador INT 
    private Integer codigoimportador;

    // DB : indicadormultimodalviatransporte CHAR 
    private String indicadormultimodalviatransporte;

    // DB : indicadoroperacaofundap CHAR 
    private String indicadoroperacaofundap;

    // DB : informacoescomplementares TEXT 
    private String informacoescomplementares;

    // DB : codigoconsignatorio INT 
    private Integer codigoconsignatorio;

    // DB : codigolocalembarque CHAR 
    private String codigolocalembarque;

    // DB : nomelocalembarque INT 
    private Integer nomelocalembarque;

    // DB : codigotransportador INT 
    private Integer codigotransportador;

    // DB : codigoveiculo INT 
    private Integer codigoveiculo;

    // DB : numeroagentecarga VARCHAR 
    private String numeroagentecarga;

    // DB : numeroconsignatario VARCHAR 
    private String numeroconsignatario;

    // DB : numerocontapagamentotributario VARCHAR 
    private String numerocontapagamentotributario;

    // DB : numerocpfrepresentantelegal VARCHAR 
    private String numerocpfrepresentantelegal;

    // DB : numerodocumentocargamaster CHAR 
    private String numerodocumentocargamaster;

    // DB : numeroimportador VARCHAR 
    private String numeroimportador;

    // DB : numeromanifesto VARCHAR 
    private String numeromanifesto;

    // DB : totaladicoes DECIMAL 
    private Float totaladicoes;

    // DB : valorfreteterritorionacionalmoedanegociada DECIMAL 
    private Float valorfreteterritorionacionalmoedanegociada;

    // DB : valortotalfretecollect DECIMAL 
    private Float valortotalfretecollect;

    // DB : valortotalfretemoedanacional DECIMAL 
    private Float valortotalfretemoedanacional;

    // DB : valortotalfreteprepaid DECIMAL 
    private Float valortotalfreteprepaid;

    // DB : valortotalmlemoedanacional DECIMAL 
    private Float valortotalmlemoedanacional;

    // DB : terminalrecintoalfandegario VARCHAR 
    private String terminalrecintoalfandegario;

    // DB : valortotalseguromoedanacional DECIMAL 
    private Float valortotalseguromoedanacional;

    // DB : valortotalseguromoedanegociada DECIMAL 
    private Float valortotalseguromoedanegociada;

    // DB : id CHAR 
    private String id;



    //----------------------------------------------------------------------
    // Getter e Setter da chave primaria
    //----------------------------------------------------------------------
    public void setNumerodocumentocarga( String numerodocumentocarga ) {
        this.numerodocumentocarga = numerodocumentocarga ;
    }

    public String getNumerodocumentocarga() {
        return this.numerodocumentocarga;
    }


    //----------------------------------------------------------------------
    // Getter e Setter dos outros campos
    //----------------------------------------------------------------------
    public void setCodigotipodocumentocarga( String codigotipodocumentocarga ) {
        this.codigotipodocumentocarga = codigotipodocumentocarga;
    }
    public String getCodigotipodocumentocarga() {
        return this.codigotipodocumentocarga;
    }

    public void setCodigomoedaseguro( Integer codigomoedaseguro ) {
        this.codigomoedaseguro = codigomoedaseguro;
    }
    public Integer getCodigomoedaseguro() {
        return this.codigomoedaseguro;
    }

    public void setCodigomoedafrete( Integer codigomoedafrete ) {
        this.codigomoedafrete = codigomoedafrete;
    }
    public Integer getCodigomoedafrete() {
        return this.codigomoedafrete;
    }

    public void setCodigomotivotransmissao( Integer codigomotivotransmissao ) {
        this.codigomotivotransmissao = codigomotivotransmissao;
    }
    public Integer getCodigomotivotransmissao() {
        return this.codigomotivotransmissao;
    }

    public void setCargapesobruto( Float cargapesobruto ) {
        this.cargapesobruto = cargapesobruto;
    }
    public Float getCargapesobruto() {
        return this.cargapesobruto;
    }

    public void setCargapesoliquido( Float cargapesoliquido ) {
        this.cargapesoliquido = cargapesoliquido;
    }
    public Float getCargapesoliquido() {
        return this.cargapesoliquido;
    }

    public void setCodigobandeiratranspote( String codigobandeiratranspote ) {
        this.codigobandeiratranspote = codigobandeiratranspote;
    }
    public String getCodigobandeiratranspote() {
        return this.codigobandeiratranspote;
    }

    public void setCodigomodalidadedespacho( Integer codigomodalidadedespacho ) {
        this.codigomodalidadedespacho = codigomodalidadedespacho;
    }
    public Integer getCodigomodalidadedespacho() {
        return this.codigomodalidadedespacho;
    }

    public void setCodigoorigemdi( String codigoorigemdi ) {
        this.codigoorigemdi = codigoorigemdi;
    }
    public String getCodigoorigemdi() {
        return this.codigoorigemdi;
    }

    public void setCodigopaisprocedenciacarga( String codigopaisprocedenciacarga ) {
        this.codigopaisprocedenciacarga = codigopaisprocedenciacarga;
    }
    public String getCodigopaisprocedenciacarga() {
        return this.codigopaisprocedenciacarga;
    }

    public void setCodigopaisimportador( String codigopaisimportador ) {
        this.codigopaisimportador = codigopaisimportador;
    }
    public String getCodigopaisimportador() {
        return this.codigopaisimportador;
    }

    public void setCodigorecintoalfandegado( String codigorecintoalfandegado ) {
        this.codigorecintoalfandegado = codigorecintoalfandegado;
    }
    public String getCodigorecintoalfandegado() {
        return this.codigorecintoalfandegado;
    }

    public void setCodigosetorarmazenamento( String codigosetorarmazenamento ) {
        this.codigosetorarmazenamento = codigosetorarmazenamento;
    }
    public String getCodigosetorarmazenamento() {
        return this.codigosetorarmazenamento;
    }

    public void setCodigotipoagentecarga( String codigotipoagentecarga ) {
        this.codigotipoagentecarga = codigotipoagentecarga;
    }
    public String getCodigotipoagentecarga() {
        return this.codigotipoagentecarga;
    }

    public void setCodigotipoconsignatario( String codigotipoconsignatario ) {
        this.codigotipoconsignatario = codigotipoconsignatario;
    }
    public String getCodigotipoconsignatario() {
        return this.codigotipoconsignatario;
    }

    public void setCodigotipodeclaracao( Integer codigotipodeclaracao ) {
        this.codigotipodeclaracao = codigotipodeclaracao;
    }
    public Integer getCodigotipodeclaracao() {
        return this.codigotipodeclaracao;
    }

    public void setCodigotipoimportador( Integer codigotipoimportador ) {
        this.codigotipoimportador = codigotipoimportador;
    }
    public Integer getCodigotipoimportador() {
        return this.codigotipoimportador;
    }

    public void setCodigotipomanifesto( Integer codigotipomanifesto ) {
        this.codigotipomanifesto = codigotipomanifesto;
    }
    public Integer getCodigotipomanifesto() {
        return this.codigotipomanifesto;
    }

    public void setCodigotipopagamentotributario( String codigotipopagamentotributario ) {
        this.codigotipopagamentotributario = codigotipopagamentotributario;
    }
    public String getCodigotipopagamentotributario() {
        return this.codigotipopagamentotributario;
    }

    public void setCodigourfcargaentrada( String codigourfcargaentrada ) {
        this.codigourfcargaentrada = codigourfcargaentrada;
    }
    public String getCodigourfcargaentrada() {
        return this.codigourfcargaentrada;
    }

    public void setCodigourfdespacho( String codigourfdespacho ) {
        this.codigourfdespacho = codigourfdespacho;
    }
    public String getCodigourfdespacho() {
        return this.codigourfdespacho;
    }

    public void setCodigoutilizacaodocumentocarga( String codigoutilizacaodocumentocarga ) {
        this.codigoutilizacaodocumentocarga = codigoutilizacaodocumentocarga;
    }
    public String getCodigoutilizacaodocumentocarga() {
        return this.codigoutilizacaodocumentocarga;
    }

    public void setCodigoviatransporte( String codigoviatransporte ) {
        this.codigoviatransporte = codigoviatransporte;
    }
    public String getCodigoviatransporte() {
        return this.codigoviatransporte;
    }

    public void setDatachegadacarga( Date datachegadacarga ) {
        this.datachegadacarga = datachegadacarga;
    }
    public Date getDatachegadacarga() {
        return this.datachegadacarga;
    }

    public void setDataembarque( Date dataembarque ) {
        this.dataembarque = dataembarque;
    }
    public Date getDataembarque() {
        return this.dataembarque;
    }

    public void setIdentificacaodeclaracaoimportacao( String identificacaodeclaracaoimportacao ) {
        this.identificacaodeclaracaoimportacao = identificacaodeclaracaoimportacao;
    }
    public String getIdentificacaodeclaracaoimportacao() {
        return this.identificacaodeclaracaoimportacao;
    }

    public void setCodigoimportador( Integer codigoimportador ) {
        this.codigoimportador = codigoimportador;
    }
    public Integer getCodigoimportador() {
        return this.codigoimportador;
    }

    public void setIndicadormultimodalviatransporte( String indicadormultimodalviatransporte ) {
        this.indicadormultimodalviatransporte = indicadormultimodalviatransporte;
    }
    public String getIndicadormultimodalviatransporte() {
        return this.indicadormultimodalviatransporte;
    }

    public void setIndicadoroperacaofundap( String indicadoroperacaofundap ) {
        this.indicadoroperacaofundap = indicadoroperacaofundap;
    }
    public String getIndicadoroperacaofundap() {
        return this.indicadoroperacaofundap;
    }

    public void setInformacoescomplementares( String informacoescomplementares ) {
        this.informacoescomplementares = informacoescomplementares;
    }
    public String getInformacoescomplementares() {
        return this.informacoescomplementares;
    }

    public void setCodigoconsignatorio( Integer codigoconsignatorio ) {
        this.codigoconsignatorio = codigoconsignatorio;
    }
    public Integer getCodigoconsignatorio() {
        return this.codigoconsignatorio;
    }

    public void setCodigolocalembarque( String codigolocalembarque ) {
        this.codigolocalembarque = codigolocalembarque;
    }
    public String getCodigolocalembarque() {
        return this.codigolocalembarque;
    }

    public void setNomelocalembarque( Integer nomelocalembarque ) {
        this.nomelocalembarque = nomelocalembarque;
    }
    public Integer getNomelocalembarque() {
        return this.nomelocalembarque;
    }

    public void setCodigotransportador( Integer codigotransportador ) {
        this.codigotransportador = codigotransportador;
    }
    public Integer getCodigotransportador() {
        return this.codigotransportador;
    }

    public void setCodigoveiculo( Integer codigoveiculo ) {
        this.codigoveiculo = codigoveiculo;
    }
    public Integer getCodigoveiculo() {
        return this.codigoveiculo;
    }

    public void setNumeroagentecarga( String numeroagentecarga ) {
        this.numeroagentecarga = numeroagentecarga;
    }
    public String getNumeroagentecarga() {
        return this.numeroagentecarga;
    }

    public void setNumeroconsignatario( String numeroconsignatario ) {
        this.numeroconsignatario = numeroconsignatario;
    }
    public String getNumeroconsignatario() {
        return this.numeroconsignatario;
    }

    public void setNumerocontapagamentotributario( String numerocontapagamentotributario ) {
        this.numerocontapagamentotributario = numerocontapagamentotributario;
    }
    public String getNumerocontapagamentotributario() {
        return this.numerocontapagamentotributario;
    }

    public void setNumerocpfrepresentantelegal( String numerocpfrepresentantelegal ) {
        this.numerocpfrepresentantelegal = numerocpfrepresentantelegal;
    }
    public String getNumerocpfrepresentantelegal() {
        return this.numerocpfrepresentantelegal;
    }

    public void setNumerodocumentocargamaster( String numerodocumentocargamaster ) {
        this.numerodocumentocargamaster = numerodocumentocargamaster;
    }
    public String getNumerodocumentocargamaster() {
        return this.numerodocumentocargamaster;
    }

    public void setNumeroimportador( String numeroimportador ) {
        this.numeroimportador = numeroimportador;
    }
    public String getNumeroimportador() {
        return this.numeroimportador;
    }

    public void setNumeromanifesto( String numeromanifesto ) {
        this.numeromanifesto = numeromanifesto;
    }
    public String getNumeromanifesto() {
        return this.numeromanifesto;
    }

    public void setTotaladicoes( Float totaladicoes ) {
        this.totaladicoes = totaladicoes;
    }
    public Float getTotaladicoes() {
        return this.totaladicoes;
    }

    public void setValorfreteterritorionacionalmoedanegociada( Float valorfreteterritorionacionalmoedanegociada ) {
        this.valorfreteterritorionacionalmoedanegociada = valorfreteterritorionacionalmoedanegociada;
    }
    public Float getValorfreteterritorionacionalmoedanegociada() {
        return this.valorfreteterritorionacionalmoedanegociada;
    }

    public void setValortotalfretecollect( Float valortotalfretecollect ) {
        this.valortotalfretecollect = valortotalfretecollect;
    }
    public Float getValortotalfretecollect() {
        return this.valortotalfretecollect;
    }

    public void setValortotalfretemoedanacional( Float valortotalfretemoedanacional ) {
        this.valortotalfretemoedanacional = valortotalfretemoedanacional;
    }
    public Float getValortotalfretemoedanacional() {
        return this.valortotalfretemoedanacional;
    }

    public void setValortotalfreteprepaid( Float valortotalfreteprepaid ) {
        this.valortotalfreteprepaid = valortotalfreteprepaid;
    }
    public Float getValortotalfreteprepaid() {
        return this.valortotalfreteprepaid;
    }

    public void setValortotalmlemoedanacional( Float valortotalmlemoedanacional ) {
        this.valortotalmlemoedanacional = valortotalmlemoedanacional;
    }
    public Float getValortotalmlemoedanacional() {
        return this.valortotalmlemoedanacional;
    }

    public void setTerminalrecintoalfandegario( String terminalrecintoalfandegario ) {
        this.terminalrecintoalfandegario = terminalrecintoalfandegario;
    }
    public String getTerminalrecintoalfandegario() {
        return this.terminalrecintoalfandegario;
    }

    public void setValortotalseguromoedanacional( Float valortotalseguromoedanacional ) {
        this.valortotalseguromoedanacional = valortotalseguromoedanacional;
    }
    public Float getValortotalseguromoedanacional() {
        return this.valortotalseguromoedanacional;
    }

    public void setValortotalseguromoedanegociada( Float valortotalseguromoedanegociada ) {
        this.valortotalseguromoedanegociada = valortotalseguromoedanegociada;
    }
    public Float getValortotalseguromoedanegociada() {
        return this.valortotalseguromoedanegociada;
    }

    public void setId( String id ) {
        this.id = id;
    }
    public String getId() {
        return this.id;
    }


    //----------------------------------------------------------------------
    // Metodo toString
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(numerodocumentocarga);
        sb.append("|");
        sb.append(codigotipodocumentocarga);
        sb.append("|");
        sb.append(codigomoedaseguro);
        sb.append("|");
        sb.append(codigomoedafrete);
        sb.append("|");
        sb.append(codigomotivotransmissao);
        sb.append("|");
        sb.append(cargapesobruto);
        sb.append("|");
        sb.append(cargapesoliquido);
        sb.append("|");
        sb.append(codigobandeiratranspote);
        sb.append("|");
        sb.append(codigomodalidadedespacho);
        sb.append("|");
        sb.append(codigoorigemdi);
        sb.append("|");
        sb.append(codigopaisprocedenciacarga);
        sb.append("|");
        sb.append(codigopaisimportador);
        sb.append("|");
        sb.append(codigorecintoalfandegado);
        sb.append("|");
        sb.append(codigosetorarmazenamento);
        sb.append("|");
        sb.append(codigotipoagentecarga);
        sb.append("|");
        sb.append(codigotipoconsignatario);
        sb.append("|");
        sb.append(codigotipodeclaracao);
        sb.append("|");
        sb.append(codigotipoimportador);
        sb.append("|");
        sb.append(codigotipomanifesto);
        sb.append("|");
        sb.append(codigotipopagamentotributario);
        sb.append("|");
        sb.append(codigourfcargaentrada);
        sb.append("|");
        sb.append(codigourfdespacho);
        sb.append("|");
        sb.append(codigoutilizacaodocumentocarga);
        sb.append("|");
        sb.append(codigoviatransporte);
        sb.append("|");
        sb.append(datachegadacarga);
        sb.append("|");
        sb.append(dataembarque);
        sb.append("|");
        sb.append(identificacaodeclaracaoimportacao);
        sb.append("|");
        sb.append(codigoimportador);
        sb.append("|");
        sb.append(indicadormultimodalviatransporte);
        sb.append("|");
        sb.append(indicadoroperacaofundap);
        // attribute 'informacoescomplementares' not usable (type = String Long Text)
        sb.append("|");
        sb.append(codigoconsignatorio);
        sb.append("|");
        sb.append(codigolocalembarque);
        sb.append("|");
        sb.append(nomelocalembarque);
        sb.append("|");
        sb.append(codigotransportador);
        sb.append("|");
        sb.append(codigoveiculo);
        sb.append("|");
        sb.append(numeroagentecarga);
        sb.append("|");
        sb.append(numeroconsignatario);
        sb.append("|");
        sb.append(numerocontapagamentotributario);
        sb.append("|");
        sb.append(numerocpfrepresentantelegal);
        sb.append("|");
        sb.append(numerodocumentocargamaster);
        sb.append("|");
        sb.append(numeroimportador);
        sb.append("|");
        sb.append(numeromanifesto);
        sb.append("|");
        sb.append(totaladicoes);
        sb.append("|");
        sb.append(valorfreteterritorionacionalmoedanegociada);
        sb.append("|");
        sb.append(valortotalfretecollect);
        sb.append("|");
        sb.append(valortotalfretemoedanacional);
        sb.append("|");
        sb.append(valortotalfreteprepaid);
        sb.append("|");
        sb.append(valortotalmlemoedanacional);
        sb.append("|");
        sb.append(terminalrecintoalfandegario);
        sb.append("|");
        sb.append(valortotalseguromoedanacional);
        sb.append("|");
        sb.append(valortotalseguromoedanegociada);
        sb.append("|");
        sb.append(id);
        return sb.toString(); 
    } 


}
