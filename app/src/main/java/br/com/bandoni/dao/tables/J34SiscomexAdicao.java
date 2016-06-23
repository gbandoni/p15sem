package br.com.bandoni.dao.tables;

import java.io.Serializable;



/**
 * Java bean para a entidade 'J34SiscomexAdicao'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexAdicao implements Serializable {

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
    // DB : codigoacordoaladi CHAR 
    private String codigoacordoaladi;

    // DB : codigoaplicacaomercadoria CHAR 
    private String codigoaplicacaomercadoria;

    // DB : codigoausenciafabricante CHAR 
    private String codigoausenciafabricante;

    // DB : codigocoberturacambial CHAR 
    private String codigocoberturacambial;

    // DB : codigofundamentolegalreduzido CHAR 
    private String codigofundamentolegalreduzido;

    // DB : codigofundamentolegalregime CHAR 
    private String codigofundamentolegalregime;

    // DB : codigofundamentolegalregimepiscofins CHAR 
    private String codigofundamentolegalregimepiscofins;

    // DB : codigoincotermsvenda CHAR 
    private String codigoincotermsvenda;

    // DB : codigomercadorianbmsh CHAR 
    private String codigomercadorianbmsh;

    // DB : codigomercadoriancm CHAR 
    private String codigomercadoriancm;

    // DB : codigomercadorianaladincc CHAR 
    private String codigomercadorianaladincc;

    // DB : codigoordemmercadorianaladincc CHAR 
    private String codigoordemmercadorianaladincc;

    // DB : codigomercadorianaladish CHAR 
    private String codigomercadorianaladish;

    // DB : codigoordemmercadorianaladish CHAR 
    private String codigoordemmercadorianaladish;

    // DB : codigometodovaloracao CHAR 
    private String codigometodovaloracao;

    // DB : codigomoedafretemercadoria INT 
    private Integer codigomoedafretemercadoria;

    // DB : codigomoedaseguromercadoria INT 
    private Integer codigomoedaseguromercadoria;

    // DB : codigomoedanegociada VARCHAR 
    private Integer codigomoedanegociada;

    // DB : codigomotivoadmissaotemporaria CHAR 
    private String codigomotivoadmissaotemporaria;

    // DB : codigomotivosemcobertura CHAR 
    private String codigomotivosemcobertura;

    // DB : codigoorgaofinanciamentointernacional CHAR 
    private String codigoorgaofinanciamentointernacional;

    // DB : codigopaisorigemmercadoria CHAR 
    private String codigopaisorigemmercadoria;

    // DB : codigopaisaquisicaomercadoria CHAR 
    private String codigopaisaquisicaomercadoria;

    // DB : codigopaisprocedenciamercadoria CHAR 
    private String codigopaisprocedenciamercadoria;

    // DB : codigoregimetriburariopiscofins CHAR 
    private String codigoregimetriburariopiscofins;

    // DB : codigoregimetributacao CHAR 
    private String codigoregimetributacao;

    // DB : codigotipoacordotarifario VARCHAR 
    private String codigotipoacordotarifario;

    // DB : codigourfentradamercadoria CHAR 
    private String codigourfentradamercadoria;

    // DB : codigoviatransporte CHAR 
    private String codigoviatransporte;

    // DB : codigovinculoimportadorexportador CHAR 
    private String codigovinculoimportadorexportador;

    // DB : codigofabricante INT 
    private Integer codigofabricante;

    // DB : codigofornecedorestrangeiro INT 
    private Integer codigofornecedorestrangeiro;

    // DB : indicadorbemencomenda CHAR 
    private String indicadorbemencomenda;

    // DB : indicadormaterialusado CHAR 
    private String indicadormaterialusado;

    // DB : indicadormultimodal CHAR 
    private String indicadormultimodal;

    // DB : indicadortipocertificado CHAR 
    private String indicadortipocertificado;

    // DB : nomelocalcondicaovenda VARCHAR 
    private String nomelocalcondicaovenda;

    // DB : numerodocumentoreducao VARCHAR 
    private String numerodocumentoreducao;

    // DB : numeroidentificacaoli VARCHAR 
    private String numeroidentificacaoli;

    // DB : numerorof VARCHAR 
    private String numerorof;

    // DB : percentualcoeficientereducaoii DECIMAL 
    private Float percentualcoeficientereducaoii;

    // DB : pesoliquidomercadoria DECIMAL 
    private Float pesoliquidomercadoria;

    // DB : quantidadeunidadeestatistica DECIMAL 
    private Float quantidadeunidadeestatistica;

    // DB : textocomplementovaloraduaneiro VARCHAR 
    private String textocomplementovaloraduaneiro;

    // DB : valoraliquotaicms DECIMAL 
    private Float valoraliquotaicms;

    // DB : valorcalculodcrdolar DECIMAL 
    private Float valorcalculodcrdolar;

    // DB : valorfinanciadosuperior360 DECIMAL 
    private Float valorfinanciadosuperior360;

    // DB : valorfretemercadoriamoedanacional DECIMAL 
    private Float valorfretemercadoriamoedanacional;

    // DB : valorfretemercadoriamoedanegociada DECIMAL 
    private Float valorfretemercadoriamoedanegociada;

    // DB : valoriicalculadodcrmoedanacional DECIMAL 
    private Float valoriicalculadodcrmoedanacional;

    // DB : valoriidevidozfm DECIMAL 
    private Float valoriidevidozfm;

    // DB : valoriiareceberzfm DECIMAL 
    private Float valoriiareceberzfm;

    // DB : valormercadoriacondicaovenda DECIMAL 
    private Float valormercadoriacondicaovenda;

    // DB : valormercadoriaembarquemoedanacional DECIMAL 
    private Float valormercadoriaembarquemoedanacional;

    // DB : valormercadoriavendamoedanacional DECIMAL 
    private Float valormercadoriavendamoedanacional;

    // DB : valorseguromercadoriamoedanacional DECIMAL 
    private Float valorseguromercadoriamoedanacional;

    // DB : valorseguromercadoriamoedanegociada DECIMAL 
    private Float valorseguromercadoriamoedanegociada;



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
    public void setCodigoacordoaladi( String codigoacordoaladi ) {
        this.codigoacordoaladi = codigoacordoaladi;
    }
    public String getCodigoacordoaladi() {
        return this.codigoacordoaladi;
    }

    public void setCodigoaplicacaomercadoria( String codigoaplicacaomercadoria ) {
        this.codigoaplicacaomercadoria = codigoaplicacaomercadoria;
    }
    public String getCodigoaplicacaomercadoria() {
        return this.codigoaplicacaomercadoria;
    }

    public void setCodigoausenciafabricante( String codigoausenciafabricante ) {
        this.codigoausenciafabricante = codigoausenciafabricante;
    }
    public String getCodigoausenciafabricante() {
        return this.codigoausenciafabricante;
    }

    public void setCodigocoberturacambial( String codigocoberturacambial ) {
        this.codigocoberturacambial = codigocoberturacambial;
    }
    public String getCodigocoberturacambial() {
        return this.codigocoberturacambial;
    }

    public void setCodigofundamentolegalreduzido( String codigofundamentolegalreduzido ) {
        this.codigofundamentolegalreduzido = codigofundamentolegalreduzido;
    }
    public String getCodigofundamentolegalreduzido() {
        return this.codigofundamentolegalreduzido;
    }

    public void setCodigofundamentolegalregime( String codigofundamentolegalregime ) {
        this.codigofundamentolegalregime = codigofundamentolegalregime;
    }
    public String getCodigofundamentolegalregime() {
        return this.codigofundamentolegalregime;
    }

    public void setCodigofundamentolegalregimepiscofins( String codigofundamentolegalregimepiscofins ) {
        this.codigofundamentolegalregimepiscofins = codigofundamentolegalregimepiscofins;
    }
    public String getCodigofundamentolegalregimepiscofins() {
        return this.codigofundamentolegalregimepiscofins;
    }

    public void setCodigoincotermsvenda( String codigoincotermsvenda ) {
        this.codigoincotermsvenda = codigoincotermsvenda;
    }
    public String getCodigoincotermsvenda() {
        return this.codigoincotermsvenda;
    }

    public void setCodigomercadorianbmsh( String codigomercadorianbmsh ) {
        this.codigomercadorianbmsh = codigomercadorianbmsh;
    }
    public String getCodigomercadorianbmsh() {
        return this.codigomercadorianbmsh;
    }

    public void setCodigomercadoriancm( String codigomercadoriancm ) {
        this.codigomercadoriancm = codigomercadoriancm;
    }
    public String getCodigomercadoriancm() {
        return this.codigomercadoriancm;
    }

    public void setCodigomercadorianaladincc( String codigomercadorianaladincc ) {
        this.codigomercadorianaladincc = codigomercadorianaladincc;
    }
    public String getCodigomercadorianaladincc() {
        return this.codigomercadorianaladincc;
    }

    public void setCodigoordemmercadorianaladincc( String codigoordemmercadorianaladincc ) {
        this.codigoordemmercadorianaladincc = codigoordemmercadorianaladincc;
    }
    public String getCodigoordemmercadorianaladincc() {
        return this.codigoordemmercadorianaladincc;
    }

    public void setCodigomercadorianaladish( String codigomercadorianaladish ) {
        this.codigomercadorianaladish = codigomercadorianaladish;
    }
    public String getCodigomercadorianaladish() {
        return this.codigomercadorianaladish;
    }

    public void setCodigoordemmercadorianaladish( String codigoordemmercadorianaladish ) {
        this.codigoordemmercadorianaladish = codigoordemmercadorianaladish;
    }
    public String getCodigoordemmercadorianaladish() {
        return this.codigoordemmercadorianaladish;
    }

    public void setCodigometodovaloracao( String codigometodovaloracao ) {
        this.codigometodovaloracao = codigometodovaloracao;
    }
    public String getCodigometodovaloracao() {
        return this.codigometodovaloracao;
    }

    public void setCodigomoedafretemercadoria( Integer codigomoedafretemercadoria ) {
        this.codigomoedafretemercadoria = codigomoedafretemercadoria;
    }
    public Integer getCodigomoedafretemercadoria() {
        return this.codigomoedafretemercadoria;
    }

    public void setCodigomoedaseguromercadoria( Integer codigomoedaseguromercadoria ) {
        this.codigomoedaseguromercadoria = codigomoedaseguromercadoria;
    }
    public Integer getCodigomoedaseguromercadoria() {
        return this.codigomoedaseguromercadoria;
    }

    public void setCodigomoedanegociada( Integer codigomoedanegociada ) {
        this.codigomoedanegociada = codigomoedanegociada;
    }
    public Integer getCodigomoedanegociada() {
        return this.codigomoedanegociada;
    }

    public void setCodigomotivoadmissaotemporaria( String codigomotivoadmissaotemporaria ) {
        this.codigomotivoadmissaotemporaria = codigomotivoadmissaotemporaria;
    }
    public String getCodigomotivoadmissaotemporaria() {
        return this.codigomotivoadmissaotemporaria;
    }

    public void setCodigomotivosemcobertura( String codigomotivosemcobertura ) {
        this.codigomotivosemcobertura = codigomotivosemcobertura;
    }
    public String getCodigomotivosemcobertura() {
        return this.codigomotivosemcobertura;
    }

    public void setCodigoorgaofinanciamentointernacional( String codigoorgaofinanciamentointernacional ) {
        this.codigoorgaofinanciamentointernacional = codigoorgaofinanciamentointernacional;
    }
    public String getCodigoorgaofinanciamentointernacional() {
        return this.codigoorgaofinanciamentointernacional;
    }

    public void setCodigopaisorigemmercadoria( String codigopaisorigemmercadoria ) {
        this.codigopaisorigemmercadoria = codigopaisorigemmercadoria;
    }
    public String getCodigopaisorigemmercadoria() {
        return this.codigopaisorigemmercadoria;
    }

    public void setCodigopaisaquisicaomercadoria( String codigopaisaquisicaomercadoria ) {
        this.codigopaisaquisicaomercadoria = codigopaisaquisicaomercadoria;
    }
    public String getCodigopaisaquisicaomercadoria() {
        return this.codigopaisaquisicaomercadoria;
    }

    public void setCodigopaisprocedenciamercadoria( String codigopaisprocedenciamercadoria ) {
        this.codigopaisprocedenciamercadoria = codigopaisprocedenciamercadoria;
    }
    public String getCodigopaisprocedenciamercadoria() {
        return this.codigopaisprocedenciamercadoria;
    }

    public void setCodigoregimetriburariopiscofins( String codigoregimetriburariopiscofins ) {
        this.codigoregimetriburariopiscofins = codigoregimetriburariopiscofins;
    }
    public String getCodigoregimetriburariopiscofins() {
        return this.codigoregimetriburariopiscofins;
    }

    public void setCodigoregimetributacao( String codigoregimetributacao ) {
        this.codigoregimetributacao = codigoregimetributacao;
    }
    public String getCodigoregimetributacao() {
        return this.codigoregimetributacao;
    }

    public void setCodigotipoacordotarifario( String codigotipoacordotarifario ) {
        this.codigotipoacordotarifario = codigotipoacordotarifario;
    }
    public String getCodigotipoacordotarifario() {
        return this.codigotipoacordotarifario;
    }

    public void setCodigourfentradamercadoria( String codigourfentradamercadoria ) {
        this.codigourfentradamercadoria = codigourfentradamercadoria;
    }
    public String getCodigourfentradamercadoria() {
        return this.codigourfentradamercadoria;
    }

    public void setCodigoviatransporte( String codigoviatransporte ) {
        this.codigoviatransporte = codigoviatransporte;
    }
    public String getCodigoviatransporte() {
        return this.codigoviatransporte;
    }

    public void setCodigovinculoimportadorexportador( String codigovinculoimportadorexportador ) {
        this.codigovinculoimportadorexportador = codigovinculoimportadorexportador;
    }
    public String getCodigovinculoimportadorexportador() {
        return this.codigovinculoimportadorexportador;
    }

    public void setCodigofabricante( Integer codigofabricante ) {
        this.codigofabricante = codigofabricante;
    }
    public Integer getCodigofabricante() {
        return this.codigofabricante;
    }

    public void setCodigofornecedorestrangeiro( Integer codigofornecedorestrangeiro ) {
        this.codigofornecedorestrangeiro = codigofornecedorestrangeiro;
    }
    public Integer getCodigofornecedorestrangeiro() {
        return this.codigofornecedorestrangeiro;
    }

    public void setIndicadorbemencomenda( String indicadorbemencomenda ) {
        this.indicadorbemencomenda = indicadorbemencomenda;
    }
    public String getIndicadorbemencomenda() {
        return this.indicadorbemencomenda;
    }

    public void setIndicadormaterialusado( String indicadormaterialusado ) {
        this.indicadormaterialusado = indicadormaterialusado;
    }
    public String getIndicadormaterialusado() {
        return this.indicadormaterialusado;
    }

    public void setIndicadormultimodal( String indicadormultimodal ) {
        this.indicadormultimodal = indicadormultimodal;
    }
    public String getIndicadormultimodal() {
        return this.indicadormultimodal;
    }

    public void setIndicadortipocertificado( String indicadortipocertificado ) {
        this.indicadortipocertificado = indicadortipocertificado;
    }
    public String getIndicadortipocertificado() {
        return this.indicadortipocertificado;
    }

    public void setNomelocalcondicaovenda( String nomelocalcondicaovenda ) {
        this.nomelocalcondicaovenda = nomelocalcondicaovenda;
    }
    public String getNomelocalcondicaovenda() {
        return this.nomelocalcondicaovenda;
    }

    public void setNumerodocumentoreducao( String numerodocumentoreducao ) {
        this.numerodocumentoreducao = numerodocumentoreducao;
    }
    public String getNumerodocumentoreducao() {
        return this.numerodocumentoreducao;
    }

    public void setNumeroidentificacaoli( String numeroidentificacaoli ) {
        this.numeroidentificacaoli = numeroidentificacaoli;
    }
    public String getNumeroidentificacaoli() {
        return this.numeroidentificacaoli;
    }

    public void setNumerorof( String numerorof ) {
        this.numerorof = numerorof;
    }
    public String getNumerorof() {
        return this.numerorof;
    }

    public void setPercentualcoeficientereducaoii( Float percentualcoeficientereducaoii ) {
        this.percentualcoeficientereducaoii = percentualcoeficientereducaoii;
    }
    public Float getPercentualcoeficientereducaoii() {
        return this.percentualcoeficientereducaoii;
    }

    public void setPesoliquidomercadoria( Float pesoliquidomercadoria ) {
        this.pesoliquidomercadoria = pesoliquidomercadoria;
    }
    public Float getPesoliquidomercadoria() {
        return this.pesoliquidomercadoria;
    }

    public void setQuantidadeunidadeestatistica( Float quantidadeunidadeestatistica ) {
        this.quantidadeunidadeestatistica = quantidadeunidadeestatistica;
    }
    public Float getQuantidadeunidadeestatistica() {
        return this.quantidadeunidadeestatistica;
    }

    public void setTextocomplementovaloraduaneiro( String textocomplementovaloraduaneiro ) {
        this.textocomplementovaloraduaneiro = textocomplementovaloraduaneiro;
    }
    public String getTextocomplementovaloraduaneiro() {
        return this.textocomplementovaloraduaneiro;
    }

    public void setValoraliquotaicms( Float valoraliquotaicms ) {
        this.valoraliquotaicms = valoraliquotaicms;
    }
    public Float getValoraliquotaicms() {
        return this.valoraliquotaicms;
    }

    public void setValorcalculodcrdolar( Float valorcalculodcrdolar ) {
        this.valorcalculodcrdolar = valorcalculodcrdolar;
    }
    public Float getValorcalculodcrdolar() {
        return this.valorcalculodcrdolar;
    }

    public void setValorfinanciadosuperior360( Float valorfinanciadosuperior360 ) {
        this.valorfinanciadosuperior360 = valorfinanciadosuperior360;
    }
    public Float getValorfinanciadosuperior360() {
        return this.valorfinanciadosuperior360;
    }

    public void setValorfretemercadoriamoedanacional( Float valorfretemercadoriamoedanacional ) {
        this.valorfretemercadoriamoedanacional = valorfretemercadoriamoedanacional;
    }
    public Float getValorfretemercadoriamoedanacional() {
        return this.valorfretemercadoriamoedanacional;
    }

    public void setValorfretemercadoriamoedanegociada( Float valorfretemercadoriamoedanegociada ) {
        this.valorfretemercadoriamoedanegociada = valorfretemercadoriamoedanegociada;
    }
    public Float getValorfretemercadoriamoedanegociada() {
        return this.valorfretemercadoriamoedanegociada;
    }

    public void setValoriicalculadodcrmoedanacional( Float valoriicalculadodcrmoedanacional ) {
        this.valoriicalculadodcrmoedanacional = valoriicalculadodcrmoedanacional;
    }
    public Float getValoriicalculadodcrmoedanacional() {
        return this.valoriicalculadodcrmoedanacional;
    }

    public void setValoriidevidozfm( Float valoriidevidozfm ) {
        this.valoriidevidozfm = valoriidevidozfm;
    }
    public Float getValoriidevidozfm() {
        return this.valoriidevidozfm;
    }

    public void setValoriiareceberzfm( Float valoriiareceberzfm ) {
        this.valoriiareceberzfm = valoriiareceberzfm;
    }
    public Float getValoriiareceberzfm() {
        return this.valoriiareceberzfm;
    }

    public void setValormercadoriacondicaovenda( Float valormercadoriacondicaovenda ) {
        this.valormercadoriacondicaovenda = valormercadoriacondicaovenda;
    }
    public Float getValormercadoriacondicaovenda() {
        return this.valormercadoriacondicaovenda;
    }

    public void setValormercadoriaembarquemoedanacional( Float valormercadoriaembarquemoedanacional ) {
        this.valormercadoriaembarquemoedanacional = valormercadoriaembarquemoedanacional;
    }
    public Float getValormercadoriaembarquemoedanacional() {
        return this.valormercadoriaembarquemoedanacional;
    }

    public void setValormercadoriavendamoedanacional( Float valormercadoriavendamoedanacional ) {
        this.valormercadoriavendamoedanacional = valormercadoriavendamoedanacional;
    }
    public Float getValormercadoriavendamoedanacional() {
        return this.valormercadoriavendamoedanacional;
    }

    public void setValorseguromercadoriamoedanacional( Float valorseguromercadoriamoedanacional ) {
        this.valorseguromercadoriamoedanacional = valorseguromercadoriamoedanacional;
    }
    public Float getValorseguromercadoriamoedanacional() {
        return this.valorseguromercadoriamoedanacional;
    }

    public void setValorseguromercadoriamoedanegociada( Float valorseguromercadoriamoedanegociada ) {
        this.valorseguromercadoriamoedanegociada = valorseguromercadoriamoedanegociada;
    }
    public Float getValorseguromercadoriamoedanegociada() {
        return this.valorseguromercadoriamoedanegociada;
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
        sb.append(codigoacordoaladi);
        sb.append("|");
        sb.append(codigoaplicacaomercadoria);
        sb.append("|");
        sb.append(codigoausenciafabricante);
        sb.append("|");
        sb.append(codigocoberturacambial);
        sb.append("|");
        sb.append(codigofundamentolegalreduzido);
        sb.append("|");
        sb.append(codigofundamentolegalregime);
        sb.append("|");
        sb.append(codigofundamentolegalregimepiscofins);
        sb.append("|");
        sb.append(codigoincotermsvenda);
        sb.append("|");
        sb.append(codigomercadorianbmsh);
        sb.append("|");
        sb.append(codigomercadoriancm);
        sb.append("|");
        sb.append(codigomercadorianaladincc);
        sb.append("|");
        sb.append(codigoordemmercadorianaladincc);
        sb.append("|");
        sb.append(codigomercadorianaladish);
        sb.append("|");
        sb.append(codigoordemmercadorianaladish);
        sb.append("|");
        sb.append(codigometodovaloracao);
        sb.append("|");
        sb.append(codigomoedafretemercadoria);
        sb.append("|");
        sb.append(codigomoedaseguromercadoria);
        sb.append("|");
        sb.append(codigomoedanegociada);
        sb.append("|");
        sb.append(codigomotivoadmissaotemporaria);
        sb.append("|");
        sb.append(codigomotivosemcobertura);
        sb.append("|");
        sb.append(codigoorgaofinanciamentointernacional);
        sb.append("|");
        sb.append(codigopaisorigemmercadoria);
        sb.append("|");
        sb.append(codigopaisaquisicaomercadoria);
        sb.append("|");
        sb.append(codigopaisprocedenciamercadoria);
        sb.append("|");
        sb.append(codigoregimetriburariopiscofins);
        sb.append("|");
        sb.append(codigoregimetributacao);
        sb.append("|");
        sb.append(codigotipoacordotarifario);
        sb.append("|");
        sb.append(codigourfentradamercadoria);
        sb.append("|");
        sb.append(codigoviatransporte);
        sb.append("|");
        sb.append(codigovinculoimportadorexportador);
        sb.append("|");
        sb.append(codigofabricante);
        sb.append("|");
        sb.append(codigofornecedorestrangeiro);
        sb.append("|");
        sb.append(indicadorbemencomenda);
        sb.append("|");
        sb.append(indicadormaterialusado);
        sb.append("|");
        sb.append(indicadormultimodal);
        sb.append("|");
        sb.append(indicadortipocertificado);
        sb.append("|");
        sb.append(nomelocalcondicaovenda);
        sb.append("|");
        sb.append(numerodocumentoreducao);
        sb.append("|");
        sb.append(numeroidentificacaoli);
        sb.append("|");
        sb.append(numerorof);
        sb.append("|");
        sb.append(percentualcoeficientereducaoii);
        sb.append("|");
        sb.append(pesoliquidomercadoria);
        sb.append("|");
        sb.append(quantidadeunidadeestatistica);
        sb.append("|");
        sb.append(textocomplementovaloraduaneiro);
        sb.append("|");
        sb.append(valoraliquotaicms);
        sb.append("|");
        sb.append(valorcalculodcrdolar);
        sb.append("|");
        sb.append(valorfinanciadosuperior360);
        sb.append("|");
        sb.append(valorfretemercadoriamoedanacional);
        sb.append("|");
        sb.append(valorfretemercadoriamoedanegociada);
        sb.append("|");
        sb.append(valoriicalculadodcrmoedanacional);
        sb.append("|");
        sb.append(valoriidevidozfm);
        sb.append("|");
        sb.append(valoriiareceberzfm);
        sb.append("|");
        sb.append(valormercadoriacondicaovenda);
        sb.append("|");
        sb.append(valormercadoriaembarquemoedanacional);
        sb.append("|");
        sb.append(valormercadoriavendamoedanacional);
        sb.append("|");
        sb.append(valorseguromercadoriamoedanacional);
        sb.append("|");
        sb.append(valorseguromercadoriamoedanegociada);
        return sb.toString(); 
    } 


}
