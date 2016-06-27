package br.com.bandoni.frm;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import br.com.bandoni.dao.commons.ActionReference;
import br.com.bandoni.dao.implementation.AdicaoDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexAdicao;

import br.com.bandoni.dao.commons.SQLiteDriver;
import java.util.ArrayList;
import java.util.List;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import br.com.bandoni.siscomexhelper.R;

public class FRMadicao extends AppCompatActivity 
{
    private J34SiscomexAdicao table;
    private AdicaoDAOImpl dao;
    private int action;
    private TextView edtNumerodocumentocarga;
    private TextView edtNumeroadicao;
    private AutoCompleteTextView edtCodigoacordoaladi;
    private AutoCompleteTextView edtCodigoaplicacaomercadoria;
    private AutoCompleteTextView edtCodigoausenciafabricante;
    private TextView edtCodigocoberturacambial;
    private AutoCompleteTextView edtCodigofundamentolegalreduzido;
    private AutoCompleteTextView edtCodigofundamentolegalregime;
    private AutoCompleteTextView edtCodigofundamentolegalregimepiscofins;
    private AutoCompleteTextView edtCodigoincotermsvenda;
    private AutoCompleteTextView edtCodigomercadorianbmsh;
    private AutoCompleteTextView edtCodigomercadoriancm;
    private AutoCompleteTextView edtCodigomercadorianaladincc;
    private AutoCompleteTextView edtCodigoordemmercadorianaladincc;
    private AutoCompleteTextView edtCodigomercadorianaladish;
    private AutoCompleteTextView edtCodigoordemmercadorianaladish;
    private AutoCompleteTextView edtCodigometodovaloracao;
    private AutoCompleteTextView edtCodigomotivoadmissaotemporaria;
    private AutoCompleteTextView edtCodigourfentradamercadoria;
    private AutoCompleteTextView edtCodigoviatransporte;
    private AutoCompleteTextView edtCodigomoedafretemercadoria;
    private AutoCompleteTextView edtCodigomoedaseguromercadoria;
    private TextView edtCodigomoedanegociada;
    private AutoCompleteTextView edtCodigomotivosemcobertura;
    private AutoCompleteTextView edtCodigoorgaofinanciamentointernacional;
    private AutoCompleteTextView edtCodigopaisorigemmercadoria;
    private AutoCompleteTextView edtCodigopaisaquisicaomercadoria;
    private AutoCompleteTextView edtCodigopaisprocedenciamercadoria;
    private AutoCompleteTextView edtCodigoregimetriburariopiscofins;
    private AutoCompleteTextView edtCodigoregimetributacao;
    private AutoCompleteTextView edtCodigotipoacordotarifario;
    private AutoCompleteTextView edtCodigovinculoimportadorexportador;
    private AutoCompleteTextView edtCodigofabricante;
    private AutoCompleteTextView edtCodigofornecedorestrangeiro;
    private AutoCompleteTextView edtIndicadorbemencomenda;
    private TextView edtIndicadormaterialusado;
    private AutoCompleteTextView edtIndicadormultimodal;
    private AutoCompleteTextView edtIndicadortipocertificado;
    private TextView edtNomelocalcondicaovenda;
    private TextView edtNumerodocumentoreducao;
    private TextView edtNumeroidentificacaoli;
    private TextView edtNumerorof;
    private TextView edtPercentualcoeficientereducaoii;
    private TextView edtPesoliquidomercadoria;
    private TextView edtQuantidadeunidadeestatistica;
    private TextView edtTextocomplementovaloraduaneiro;
    private TextView edtValoraliquotaicms;
    private TextView edtValorcalculodcrdolar;
    private TextView edtValorfinanciadosuperior360;
    private TextView edtValorfretemercadoriamoedanacional;
    private TextView edtValorfretemercadoriamoedanegociada;
    private TextView edtValoriicalculadodcrmoedanacional;
    private TextView edtValoriidevidozfm;
    private TextView edtValoriiareceberzfm;
    private TextView edtValormercadoriacondicaovenda;
    private TextView edtValormercadoriaembarquemoedanacional;
    private TextView edtValormercadoriavendamoedanacional;
    private TextView edtValorseguromercadoriamoedanacional;
    private TextView edtValorseguromercadoriamoedanegociada;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_adicao);
        //campos do formulario;
        edtNumerodocumentocarga = (TextView)findViewById(R.id.edtNumerodocumentocarga);
        edtNumeroadicao = (TextView)findViewById(R.id.edtNumeroadicao);
        edtCodigoacordoaladi = (AutoCompleteTextView)findViewById(R.id.edtCodigoacordoaladi);
        edtCodigoaplicacaomercadoria = (AutoCompleteTextView)findViewById(R.id.edtCodigoaplicacaomercadoria);
        edtCodigoausenciafabricante = (AutoCompleteTextView)findViewById(R.id.edtCodigoausenciafabricante);
        edtCodigocoberturacambial = (TextView)findViewById(R.id.edtCodigocoberturacambial);
        edtCodigofundamentolegalreduzido = (AutoCompleteTextView)findViewById(R.id.edtCodigofundamentolegalreduzido);
        edtCodigofundamentolegalregime = (AutoCompleteTextView)findViewById(R.id.edtCodigofundamentolegalregime);
        edtCodigofundamentolegalregimepiscofins = (AutoCompleteTextView)findViewById(R.id.edtCodigofundamentolegalregimepiscofins);
        edtCodigoincotermsvenda = (AutoCompleteTextView)findViewById(R.id.edtCodigoincotermsvenda);
        edtCodigomercadorianbmsh = (AutoCompleteTextView)findViewById(R.id.edtCodigomercadorianbmsh);
        edtCodigomercadoriancm = (AutoCompleteTextView)findViewById(R.id.edtCodigomercadoriancm);
        edtCodigomercadorianaladincc = (AutoCompleteTextView)findViewById(R.id.edtCodigomercadorianaladincc);
        edtCodigoordemmercadorianaladincc = (AutoCompleteTextView)findViewById(R.id.edtCodigoordemmercadorianaladincc);
        edtCodigomercadorianaladish = (AutoCompleteTextView)findViewById(R.id.edtCodigomercadorianaladish);
        edtCodigoordemmercadorianaladish = (AutoCompleteTextView)findViewById(R.id.edtCodigoordemmercadorianaladish);
        edtCodigometodovaloracao = (AutoCompleteTextView)findViewById(R.id.edtCodigometodovaloracao);
        edtCodigomotivoadmissaotemporaria = (AutoCompleteTextView)findViewById(R.id.edtCodigomotivoadmissaotemporaria);
        edtCodigourfentradamercadoria = (AutoCompleteTextView)findViewById(R.id.edtCodigourfentradamercadoria);
        edtCodigoviatransporte = (AutoCompleteTextView)findViewById(R.id.edtCodigoviatransporte);
        edtCodigomoedafretemercadoria = (AutoCompleteTextView)findViewById(R.id.edtCodigomoedafretemercadoria);
        edtCodigomoedaseguromercadoria = (AutoCompleteTextView)findViewById(R.id.edtCodigomoedaseguromercadoria);
        edtCodigomoedanegociada = (TextView)findViewById(R.id.edtCodigomoedanegociada);
        edtCodigomotivosemcobertura = (AutoCompleteTextView)findViewById(R.id.edtCodigomotivosemcobertura);
        edtCodigoorgaofinanciamentointernacional = (AutoCompleteTextView)findViewById(R.id.edtCodigoorgaofinanciamentointernacional);
        edtCodigopaisorigemmercadoria = (AutoCompleteTextView)findViewById(R.id.edtCodigopaisorigemmercadoria);
        edtCodigopaisaquisicaomercadoria = (AutoCompleteTextView)findViewById(R.id.edtCodigopaisaquisicaomercadoria);
        edtCodigopaisprocedenciamercadoria = (AutoCompleteTextView)findViewById(R.id.edtCodigopaisprocedenciamercadoria);
        edtCodigoregimetriburariopiscofins = (AutoCompleteTextView)findViewById(R.id.edtCodigoregimetriburariopiscofins);
        edtCodigoregimetributacao = (AutoCompleteTextView)findViewById(R.id.edtCodigoregimetributacao);
        edtCodigotipoacordotarifario = (AutoCompleteTextView)findViewById(R.id.edtCodigotipoacordotarifario);
        edtCodigovinculoimportadorexportador = (AutoCompleteTextView)findViewById(R.id.edtCodigovinculoimportadorexportador);
        edtCodigofabricante = (AutoCompleteTextView)findViewById(R.id.edtCodigofabricante);
        edtCodigofornecedorestrangeiro = (AutoCompleteTextView)findViewById(R.id.edtCodigofornecedorestrangeiro);
        edtIndicadorbemencomenda = (AutoCompleteTextView)findViewById(R.id.edtIndicadorbemencomenda);
        edtIndicadormaterialusado = (TextView)findViewById(R.id.edtIndicadormaterialusado);
        edtIndicadormultimodal = (AutoCompleteTextView)findViewById(R.id.edtIndicadormultimodal);
        edtIndicadortipocertificado = (AutoCompleteTextView)findViewById(R.id.edtIndicadortipocertificado);
        edtNomelocalcondicaovenda = (TextView)findViewById(R.id.edtNomelocalcondicaovenda);
        edtNumerodocumentoreducao = (TextView)findViewById(R.id.edtNumerodocumentoreducao);
        edtNumeroidentificacaoli = (TextView)findViewById(R.id.edtNumeroidentificacaoli);
        edtNumerorof = (TextView)findViewById(R.id.edtNumerorof);
        edtPercentualcoeficientereducaoii = (TextView)findViewById(R.id.edtPercentualcoeficientereducaoii);
        edtPesoliquidomercadoria = (TextView)findViewById(R.id.edtPesoliquidomercadoria);
        edtQuantidadeunidadeestatistica = (TextView)findViewById(R.id.edtQuantidadeunidadeestatistica);
        edtTextocomplementovaloraduaneiro = (TextView)findViewById(R.id.edtTextocomplementovaloraduaneiro);
        edtValoraliquotaicms = (TextView)findViewById(R.id.edtValoraliquotaicms);
        edtValorcalculodcrdolar = (TextView)findViewById(R.id.edtValorcalculodcrdolar);
        edtValorfinanciadosuperior360 = (TextView)findViewById(R.id.edtValorfinanciadosuperior360);
        edtValorfretemercadoriamoedanacional = (TextView)findViewById(R.id.edtValorfretemercadoriamoedanacional);
        edtValorfretemercadoriamoedanegociada = (TextView)findViewById(R.id.edtValorfretemercadoriamoedanegociada);
        edtValoriicalculadodcrmoedanacional = (TextView)findViewById(R.id.edtValoriicalculadodcrmoedanacional);
        edtValoriidevidozfm = (TextView)findViewById(R.id.edtValoriidevidozfm);
        edtValoriiareceberzfm = (TextView)findViewById(R.id.edtValoriiareceberzfm);
        edtValormercadoriacondicaovenda = (TextView)findViewById(R.id.edtValormercadoriacondicaovenda);
        edtValormercadoriaembarquemoedanacional = (TextView)findViewById(R.id.edtValormercadoriaembarquemoedanacional);
        edtValormercadoriavendamoedanacional = (TextView)findViewById(R.id.edtValormercadoriavendamoedanacional);
        edtValorseguromercadoriamoedanacional = (TextView)findViewById(R.id.edtValorseguromercadoriamoedanacional);
        edtValorseguromercadoriamoedanegociada = (TextView)findViewById(R.id.edtValorseguromercadoriamoedanegociada);
         List<String> lstAcordo_aladi = getAcordo_aladi();
         ArrayAdapter<String> adpCodigoacordoaladi = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstAcordo_aladi);
        edtCodigoacordoaladi.setAdapter(adpCodigoacordoaladi);
         List<String> lstFund_legal = getFund_legal();
         ArrayAdapter<String> adpCodigofundamentolegalreduzido = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstFund_legal);
        edtCodigofundamentolegalreduzido.setAdapter(adpCodigofundamentolegalreduzido);
         ArrayAdapter<String> adpCodigofundamentolegalregime = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstFund_legal);
        edtCodigofundamentolegalregime.setAdapter(adpCodigofundamentolegalregime);
         ArrayAdapter<String> adpCodigofundamentolegalregimepiscofins = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstFund_legal);
        edtCodigofundamentolegalregimepiscofins.setAdapter(adpCodigofundamentolegalregimepiscofins);
         List<String> lstIncoterms = getIncoterms();
         ArrayAdapter<String> adpCodigoincotermsvenda = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstIncoterms);
        edtCodigoincotermsvenda.setAdapter(adpCodigoincotermsvenda);
         List<String> lstNbm = getNbm();
         ArrayAdapter<String> adpCodigomercadorianbmsh = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstNbm);
        edtCodigomercadorianbmsh.setAdapter(adpCodigomercadorianbmsh);
         List<String> lstNcm = getNcm();
         ArrayAdapter<String> adpCodigomercadoriancm = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstNcm);
        edtCodigomercadoriancm.setAdapter(adpCodigomercadoriancm);
         List<String> lstNaladi_ncca = getNaladi_ncca();
         ArrayAdapter<String> adpCodigomercadorianaladincc = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstNaladi_ncca);
        edtCodigomercadorianaladincc.setAdapter(adpCodigomercadorianaladincc);
         ArrayAdapter<String> adpCodigoordemmercadorianaladincc = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstNaladi_ncca);
        edtCodigoordemmercadorianaladincc.setAdapter(adpCodigoordemmercadorianaladincc);
         List<String> lstNaladi_sh = getNaladi_sh();
         ArrayAdapter<String> adpCodigomercadorianaladish = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstNaladi_sh);
        edtCodigomercadorianaladish.setAdapter(adpCodigomercadorianaladish);
         ArrayAdapter<String> adpCodigoordemmercadorianaladish = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstNaladi_sh);
        edtCodigoordemmercadorianaladish.setAdapter(adpCodigoordemmercadorianaladish);
         List<String> lstValor_aduaneira = getValor_aduaneira();
         ArrayAdapter<String> adpCodigometodovaloracao = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstValor_aduaneira);
        edtCodigometodovaloracao.setAdapter(adpCodigometodovaloracao);
         List<String> lstMot_adm_temp = getMot_adm_temp();
         ArrayAdapter<String> adpCodigomotivoadmissaotemporaria = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstMot_adm_temp);
        edtCodigomotivoadmissaotemporaria.setAdapter(adpCodigomotivoadmissaotemporaria);
         List<String> lstOrgaosurf = getOrgaosurf();
         ArrayAdapter<String> adpCodigourfentradamercadoria = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstOrgaosurf);
        edtCodigourfentradamercadoria.setAdapter(adpCodigourfentradamercadoria);
         List<String> lstViatransporte = getViatransporte();
         ArrayAdapter<String> adpCodigoviatransporte = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstViatransporte);
        edtCodigoviatransporte.setAdapter(adpCodigoviatransporte);
         List<String> lstMoedas = getMoedas();
         ArrayAdapter<String> adpCodigomoedafretemercadoria = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstMoedas);
        edtCodigomoedafretemercadoria.setAdapter(adpCodigomoedafretemercadoria);
         ArrayAdapter<String> adpCodigomoedaseguromercadoria = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstMoedas);
        edtCodigomoedaseguromercadoria.setAdapter(adpCodigomoedaseguromercadoria);
         List<String> lstMot_sem_cob = getMot_sem_cob();
         ArrayAdapter<String> adpCodigomotivosemcobertura = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstMot_sem_cob);
        edtCodigomotivosemcobertura.setAdapter(adpCodigomotivosemcobertura);
         List<String> lstInst_financeira = getInst_financeira();
         ArrayAdapter<String> adpCodigoorgaofinanciamentointernacional = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstInst_financeira);
        edtCodigoorgaofinanciamentointernacional.setAdapter(adpCodigoorgaofinanciamentointernacional);
         List<String> lstPaises = getPaises();
         ArrayAdapter<String> adpCodigopaisorigemmercadoria = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstPaises);
        edtCodigopaisorigemmercadoria.setAdapter(adpCodigopaisorigemmercadoria);
         ArrayAdapter<String> adpCodigopaisaquisicaomercadoria = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstPaises);
        edtCodigopaisaquisicaomercadoria.setAdapter(adpCodigopaisaquisicaomercadoria);
         ArrayAdapter<String> adpCodigopaisprocedenciamercadoria = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstPaises);
        edtCodigopaisprocedenciamercadoria.setAdapter(adpCodigopaisprocedenciamercadoria);
         List<String> lstRegime_tribut = getRegime_tribut();
         ArrayAdapter<String> adpCodigoregimetriburariopiscofins = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstRegime_tribut);
        edtCodigoregimetriburariopiscofins.setAdapter(adpCodigoregimetriburariopiscofins);
         ArrayAdapter<String> adpCodigoregimetributacao = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstRegime_tribut);
        edtCodigoregimetributacao.setAdapter(adpCodigoregimetributacao);
         List<String> lstEmpresas = getEmpresas();
         ArrayAdapter<String> adpCodigofabricante = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstEmpresas);
        edtCodigofabricante.setAdapter(adpCodigofabricante);
         ArrayAdapter<String> adpCodigofornecedorestrangeiro = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstEmpresas);
        edtCodigofornecedorestrangeiro.setAdapter(adpCodigofornecedorestrangeiro);
         List<String> lstcodigoAplicacaoMercadoria = getcodigoAplicacaoMercadoria();
         ArrayAdapter<String> adpCodigoaplicacaomercadoria = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstcodigoAplicacaoMercadoria);
        edtCodigoaplicacaomercadoria.setAdapter(adpCodigoaplicacaomercadoria);
         List<String> lstcodigoAusenciaFabricante = getcodigoAusenciaFabricante();
         ArrayAdapter<String> adpCodigoausenciafabricante = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstcodigoAusenciaFabricante);
        edtCodigoausenciafabricante.setAdapter(adpCodigoausenciafabricante);
         List<String> lstcodigoTipoAcordoTarifario = getcodigoTipoAcordoTarifario();
         ArrayAdapter<String> adpCodigotipoacordotarifario = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstcodigoTipoAcordoTarifario);
        edtCodigotipoacordotarifario.setAdapter(adpCodigotipoacordotarifario);
         List<String> lstcodigoVinculoImportadorExportador = getcodigoVinculoImportadorExportador();
         ArrayAdapter<String> adpCodigovinculoimportadorexportador = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstcodigoVinculoImportadorExportador);
        edtCodigovinculoimportadorexportador.setAdapter(adpCodigovinculoimportadorexportador);
         List<String> lstindicadorBemEncomenda = getindicadorBemEncomenda();
         ArrayAdapter<String> adpIndicadorbemencomenda = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstindicadorBemEncomenda);
        edtIndicadorbemencomenda.setAdapter(adpIndicadorbemencomenda);
         List<String> lstindicadorMultimodal = getindicadorMultimodal();
         ArrayAdapter<String> adpIndicadormultimodal = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstindicadorMultimodal);
        edtIndicadormultimodal.setAdapter(adpIndicadormultimodal);
         List<String> lstindicadorTipoCertificado = getindicadorTipoCertificado();
         ArrayAdapter<String> adpIndicadortipocertificado = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstindicadorTipoCertificado);
        edtIndicadortipocertificado.setAdapter(adpIndicadortipocertificado);
        dao = new AdicaoDAOImpl(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            try
            {
              table = dao.find(it.getStringExtra("NUMERODOCUMENTOCARGA"),it.getStringExtra("NUMEROADICAO"));
            edtNumerodocumentocarga.setText(table.getNumerodocumentocarga());
            edtNumeroadicao.setText(table.getNumeroadicao());
            edtCodigoacordoaladi.setText(table.getCodigoacordoaladi());
            edtCodigoaplicacaomercadoria.setText(table.getCodigoaplicacaomercadoria());
            edtCodigoausenciafabricante.setText(table.getCodigoausenciafabricante());
            edtCodigocoberturacambial.setText(table.getCodigocoberturacambial());
            edtCodigofundamentolegalreduzido.setText(table.getCodigofundamentolegalreduzido());
            edtCodigofundamentolegalregime.setText(table.getCodigofundamentolegalregime());
            edtCodigofundamentolegalregimepiscofins.setText(table.getCodigofundamentolegalregimepiscofins());
            edtCodigoincotermsvenda.setText(table.getCodigoincotermsvenda());
            edtCodigomercadorianbmsh.setText(table.getCodigomercadorianbmsh());
            edtCodigomercadoriancm.setText(table.getCodigomercadoriancm());
            edtCodigomercadorianaladincc.setText(table.getCodigomercadorianaladincc());
            edtCodigoordemmercadorianaladincc.setText(table.getCodigoordemmercadorianaladincc());
            edtCodigomercadorianaladish.setText(table.getCodigomercadorianaladish());
            edtCodigoordemmercadorianaladish.setText(table.getCodigoordemmercadorianaladish());
            edtCodigometodovaloracao.setText(table.getCodigometodovaloracao());
            edtCodigomotivoadmissaotemporaria.setText(table.getCodigomotivoadmissaotemporaria());
            edtCodigourfentradamercadoria.setText(table.getCodigourfentradamercadoria());
            edtCodigoviatransporte.setText(table.getCodigoviatransporte());
            edtCodigomoedafretemercadoria.setText(table.getCodigomoedafretemercadoria().toString());
            edtCodigomoedaseguromercadoria.setText(table.getCodigomoedaseguromercadoria().toString());
            edtCodigomoedanegociada.setText(table.getCodigomoedanegociada());
            edtCodigomotivosemcobertura.setText(table.getCodigomotivosemcobertura());
            edtCodigoorgaofinanciamentointernacional.setText(table.getCodigoorgaofinanciamentointernacional());
            edtCodigopaisorigemmercadoria.setText(table.getCodigopaisorigemmercadoria());
            edtCodigopaisaquisicaomercadoria.setText(table.getCodigopaisaquisicaomercadoria());
            edtCodigopaisprocedenciamercadoria.setText(table.getCodigopaisprocedenciamercadoria());
            edtCodigoregimetriburariopiscofins.setText(table.getCodigoregimetriburariopiscofins());
            edtCodigoregimetributacao.setText(table.getCodigoregimetributacao());
            edtCodigotipoacordotarifario.setText(table.getCodigotipoacordotarifario());
            edtCodigovinculoimportadorexportador.setText(table.getCodigovinculoimportadorexportador());
            edtCodigofabricante.setText(table.getCodigofabricante().toString());
            edtCodigofornecedorestrangeiro.setText(table.getCodigofornecedorestrangeiro().toString());
            edtIndicadorbemencomenda.setText(table.getIndicadorbemencomenda());
            edtIndicadormaterialusado.setText(table.getIndicadormaterialusado());
            edtIndicadormultimodal.setText(table.getIndicadormultimodal());
            edtIndicadortipocertificado.setText(table.getIndicadortipocertificado());
            edtNomelocalcondicaovenda.setText(table.getNomelocalcondicaovenda());
            edtNumerodocumentoreducao.setText(table.getNumerodocumentoreducao());
            edtNumeroidentificacaoli.setText(table.getNumeroidentificacaoli());
            edtNumerorof.setText(table.getNumerorof());
            edtPercentualcoeficientereducaoii.setText(table.getPercentualcoeficientereducaoii().toString());
            edtPesoliquidomercadoria.setText(table.getPesoliquidomercadoria().toString());
            edtQuantidadeunidadeestatistica.setText(table.getQuantidadeunidadeestatistica().toString());
            edtTextocomplementovaloraduaneiro.setText(table.getTextocomplementovaloraduaneiro());
            edtValoraliquotaicms.setText(table.getValoraliquotaicms().toString());
            edtValorcalculodcrdolar.setText(table.getValorcalculodcrdolar().toString());
            edtValorfinanciadosuperior360.setText(table.getValorfinanciadosuperior360().toString());
            edtValorfretemercadoriamoedanacional.setText(table.getValorfretemercadoriamoedanacional().toString());
            edtValorfretemercadoriamoedanegociada.setText(table.getValorfretemercadoriamoedanegociada().toString());
            edtValoriicalculadodcrmoedanacional.setText(table.getValoriicalculadodcrmoedanacional().toString());
            edtValoriidevidozfm.setText(table.getValoriidevidozfm().toString());
            edtValoriiareceberzfm.setText(table.getValoriiareceberzfm().toString());
            edtValormercadoriacondicaovenda.setText(table.getValormercadoriacondicaovenda().toString());
            edtValormercadoriaembarquemoedanacional.setText(table.getValormercadoriaembarquemoedanacional().toString());
            edtValormercadoriavendamoedanacional.setText(table.getValormercadoriavendamoedanacional().toString());
            edtValorseguromercadoriamoedanacional.setText(table.getValorseguromercadoriamoedanacional().toString());
            edtValorseguromercadoriamoedanegociada.setText(table.getValorseguromercadoriamoedanegociada().toString());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtNumerodocumentocarga.setEnabled(false);
                  edtNumeroadicao.setEnabled(false);
                  edtCodigoacordoaladi.setEnabled(false);
                  edtCodigoaplicacaomercadoria.setEnabled(false);
                  edtCodigoausenciafabricante.setEnabled(false);
                  edtCodigocoberturacambial.setEnabled(false);
                  edtCodigofundamentolegalreduzido.setEnabled(false);
                  edtCodigofundamentolegalregime.setEnabled(false);
                  edtCodigofundamentolegalregimepiscofins.setEnabled(false);
                  edtCodigoincotermsvenda.setEnabled(false);
                  edtCodigomercadorianbmsh.setEnabled(false);
                  edtCodigomercadoriancm.setEnabled(false);
                  edtCodigomercadorianaladincc.setEnabled(false);
                  edtCodigoordemmercadorianaladincc.setEnabled(false);
                  edtCodigomercadorianaladish.setEnabled(false);
                  edtCodigoordemmercadorianaladish.setEnabled(false);
                  edtCodigometodovaloracao.setEnabled(false);
                  edtCodigomotivoadmissaotemporaria.setEnabled(false);
                  edtCodigourfentradamercadoria.setEnabled(false);
                  edtCodigoviatransporte.setEnabled(false);
                  edtCodigomoedafretemercadoria.setEnabled(false);
                  edtCodigomoedaseguromercadoria.setEnabled(false);
                  edtCodigomoedanegociada.setEnabled(false);
                  edtCodigomotivosemcobertura.setEnabled(false);
                  edtCodigoorgaofinanciamentointernacional.setEnabled(false);
                  edtCodigopaisorigemmercadoria.setEnabled(false);
                  edtCodigopaisaquisicaomercadoria.setEnabled(false);
                  edtCodigopaisprocedenciamercadoria.setEnabled(false);
                  edtCodigoregimetriburariopiscofins.setEnabled(false);
                  edtCodigoregimetributacao.setEnabled(false);
                  edtCodigotipoacordotarifario.setEnabled(false);
                  edtCodigovinculoimportadorexportador.setEnabled(false);
                  edtCodigofabricante.setEnabled(false);
                  edtCodigofornecedorestrangeiro.setEnabled(false);
                  edtIndicadorbemencomenda.setEnabled(false);
                  edtIndicadormaterialusado.setEnabled(false);
                  edtIndicadormultimodal.setEnabled(false);
                  edtIndicadortipocertificado.setEnabled(false);
                  edtNomelocalcondicaovenda.setEnabled(false);
                  edtNumerodocumentoreducao.setEnabled(false);
                  edtNumeroidentificacaoli.setEnabled(false);
                  edtNumerorof.setEnabled(false);
                  edtPercentualcoeficientereducaoii.setEnabled(false);
                  edtPesoliquidomercadoria.setEnabled(false);
                  edtQuantidadeunidadeestatistica.setEnabled(false);
                  edtTextocomplementovaloraduaneiro.setEnabled(false);
                  edtValoraliquotaicms.setEnabled(false);
                  edtValorcalculodcrdolar.setEnabled(false);
                  edtValorfinanciadosuperior360.setEnabled(false);
                  edtValorfretemercadoriamoedanacional.setEnabled(false);
                  edtValorfretemercadoriamoedanegociada.setEnabled(false);
                  edtValoriicalculadodcrmoedanacional.setEnabled(false);
                  edtValoriidevidozfm.setEnabled(false);
                  edtValoriiareceberzfm.setEnabled(false);
                  edtValormercadoriacondicaovenda.setEnabled(false);
                  edtValormercadoriaembarquemoedanacional.setEnabled(false);
                  edtValormercadoriavendamoedanacional.setEnabled(false);
                  edtValorseguromercadoriamoedanacional.setEnabled(false);
                  edtValorseguromercadoriamoedanegociada.setEnabled(false);
                }
                else
                {
                  edtNumerodocumentocarga.setEnabled(false);
                  edtNumeroadicao.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMadicao.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexAdicao();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_adicao, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Processa os itens que foram clicados no menu
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save)
        {
            if (action != ActionReference.ACTION_VIEW)
            {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        switch (which)
                        {
                            case DialogInterface.BUTTON_POSITIVE:
                                table.setNumerodocumentocarga(edtNumerodocumentocarga.getText().toString());
                                table.setNumeroadicao(edtNumeroadicao.getText().toString());
                                table.setCodigoacordoaladi(edtCodigoacordoaladi.getText().toString());
                                table.setCodigoaplicacaomercadoria(edtCodigoaplicacaomercadoria.getText().toString());
                                table.setCodigoausenciafabricante(edtCodigoausenciafabricante.getText().toString());
                                table.setCodigocoberturacambial(edtCodigocoberturacambial.getText().toString());
                                table.setCodigofundamentolegalreduzido(edtCodigofundamentolegalreduzido.getText().toString());
                                table.setCodigofundamentolegalregime(edtCodigofundamentolegalregime.getText().toString());
                                table.setCodigofundamentolegalregimepiscofins(edtCodigofundamentolegalregimepiscofins.getText().toString());
                                table.setCodigoincotermsvenda(edtCodigoincotermsvenda.getText().toString());
                                table.setCodigomercadorianbmsh(edtCodigomercadorianbmsh.getText().toString());
                                table.setCodigomercadoriancm(edtCodigomercadoriancm.getText().toString());
                                table.setCodigomercadorianaladincc(edtCodigomercadorianaladincc.getText().toString());
                                table.setCodigoordemmercadorianaladincc(edtCodigoordemmercadorianaladincc.getText().toString());
                                table.setCodigomercadorianaladish(edtCodigomercadorianaladish.getText().toString());
                                table.setCodigoordemmercadorianaladish(edtCodigoordemmercadorianaladish.getText().toString());
                                table.setCodigometodovaloracao(edtCodigometodovaloracao.getText().toString());
                                table.setCodigomotivoadmissaotemporaria(edtCodigomotivoadmissaotemporaria.getText().toString());
                                table.setCodigourfentradamercadoria(edtCodigourfentradamercadoria.getText().toString());
                                table.setCodigoviatransporte(edtCodigoviatransporte.getText().toString());
                                table.setCodigomoedafretemercadoria(Integer.parseInt(edtCodigomoedafretemercadoria.getText().toString()));
                                table.setCodigomoedaseguromercadoria(Integer.parseInt(edtCodigomoedaseguromercadoria.getText().toString()));
                                table.setCodigomoedanegociada(edtCodigomoedanegociada.getText().toString());
                                table.setCodigomotivosemcobertura(edtCodigomotivosemcobertura.getText().toString());
                                table.setCodigoorgaofinanciamentointernacional(edtCodigoorgaofinanciamentointernacional.getText().toString());
                                table.setCodigopaisorigemmercadoria(edtCodigopaisorigemmercadoria.getText().toString());
                                table.setCodigopaisaquisicaomercadoria(edtCodigopaisaquisicaomercadoria.getText().toString());
                                table.setCodigopaisprocedenciamercadoria(edtCodigopaisprocedenciamercadoria.getText().toString());
                                table.setCodigoregimetriburariopiscofins(edtCodigoregimetriburariopiscofins.getText().toString());
                                table.setCodigoregimetributacao(edtCodigoregimetributacao.getText().toString());
                                table.setCodigotipoacordotarifario(edtCodigotipoacordotarifario.getText().toString());
                                table.setCodigovinculoimportadorexportador(edtCodigovinculoimportadorexportador.getText().toString());
                                table.setCodigofabricante(Integer.parseInt(edtCodigofabricante.getText().toString()));
                                table.setCodigofornecedorestrangeiro(Integer.parseInt(edtCodigofornecedorestrangeiro.getText().toString()));
                                table.setIndicadorbemencomenda(edtIndicadorbemencomenda.getText().toString());
                                table.setIndicadormaterialusado(edtIndicadormaterialusado.getText().toString());
                                table.setIndicadormultimodal(edtIndicadormultimodal.getText().toString());
                                table.setIndicadortipocertificado(edtIndicadortipocertificado.getText().toString());
                                table.setNomelocalcondicaovenda(edtNomelocalcondicaovenda.getText().toString());
                                table.setNumerodocumentoreducao(edtNumerodocumentoreducao.getText().toString());
                                table.setNumeroidentificacaoli(edtNumeroidentificacaoli.getText().toString());
                                table.setNumerorof(edtNumerorof.getText().toString());
                                table.setPercentualcoeficientereducaoii(Float.parseFloat(edtPercentualcoeficientereducaoii.getText().toString()));
                                table.setPesoliquidomercadoria(Float.parseFloat(edtPesoliquidomercadoria.getText().toString()));
                                table.setQuantidadeunidadeestatistica(Float.parseFloat(edtQuantidadeunidadeestatistica.getText().toString()));
                                table.setTextocomplementovaloraduaneiro(edtTextocomplementovaloraduaneiro.getText().toString());
                                table.setValoraliquotaicms(Float.parseFloat(edtValoraliquotaicms.getText().toString()));
                                table.setValorcalculodcrdolar(Float.parseFloat(edtValorcalculodcrdolar.getText().toString()));
                                table.setValorfinanciadosuperior360(Float.parseFloat(edtValorfinanciadosuperior360.getText().toString()));
                                table.setValorfretemercadoriamoedanacional(Float.parseFloat(edtValorfretemercadoriamoedanacional.getText().toString()));
                                table.setValorfretemercadoriamoedanegociada(Float.parseFloat(edtValorfretemercadoriamoedanegociada.getText().toString()));
                                table.setValoriicalculadodcrmoedanacional(Float.parseFloat(edtValoriicalculadodcrmoedanacional.getText().toString()));
                                table.setValoriidevidozfm(Float.parseFloat(edtValoriidevidozfm.getText().toString()));
                                table.setValoriiareceberzfm(Float.parseFloat(edtValoriiareceberzfm.getText().toString()));
                                table.setValormercadoriacondicaovenda(Float.parseFloat(edtValormercadoriacondicaovenda.getText().toString()));
                                table.setValormercadoriaembarquemoedanacional(Float.parseFloat(edtValormercadoriaembarquemoedanacional.getText().toString()));
                                table.setValormercadoriavendamoedanacional(Float.parseFloat(edtValormercadoriavendamoedanacional.getText().toString()));
                                table.setValorseguromercadoriamoedanacional(Float.parseFloat(edtValorseguromercadoriamoedanacional.getText().toString()));
                                table.setValorseguromercadoriamoedanegociada(Float.parseFloat(edtValorseguromercadoriamoedanegociada.getText().toString()));
                                switch (action)
                                {
                                    case ActionReference.ACTION_INCLUDE:
                                        dao.insert(table);
                                        break;
                                    case ActionReference.ACTION_UPDATE:
                                        dao.update(table);
                                        break;
                                    case ActionReference.ACTION_DELETE:
                                        dao.delete(table);
                                        break;
                                }
                                Toast.makeText(getBaseContext(), "Operação concluída com sucesso", Toast.LENGTH_LONG).show();
                                finish();;
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                // Nao preciso fazer nada
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMadicao.this);
                builder.setMessage("Confirma a operação ?").setPositiveButton("Sim", dialogClickListener)
                        .setNegativeButton("Não", dialogClickListener).show();
            }
            return true;
        }

        if (id == R.id.action_cancel)
        {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private List<String> getAcordo_aladi()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_acordo_aladi");
      driver.close();
      return lista;
    }
    private List<String> getFund_legal()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_fund_legal");
      driver.close();
      return lista;
    }
    private List<String> getIncoterms()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_incoterms");
      driver.close();
      return lista;
    }
    private List<String> getNbm()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_nbm");
      driver.close();
      return lista;
    }
    private List<String> getNcm()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_ncm");
      driver.close();
      return lista;
    }
    private List<String> getNaladi_ncca()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_naladi_ncca");
      driver.close();
      return lista;
    }
    private List<String> getNaladi_sh()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_naladi_sh");
      driver.close();
      return lista;
    }
    private List<String> getValor_aduaneira()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_valor_aduaneira");
      driver.close();
      return lista;
    }
    private List<String> getMot_adm_temp()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_mot_adm_temp");
      driver.close();
      return lista;
    }
    private List<String> getOrgaosurf()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_orgaosurf");
      driver.close();
      return lista;
    }
    private List<String> getViatransporte()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_viatransporte");
      driver.close();
      return lista;
    }
    private List<String> getMoedas()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_moedas");
      driver.close();
      return lista;
    }
    private List<String> getMot_sem_cob()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_mot_sem_cob");
      driver.close();
      return lista;
    }
    private List<String> getInst_financeira()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_inst_financeira");
      driver.close();
      return lista;
    }
    private List<String> getPaises()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_paises");
      driver.close();
      return lista;
    }
    private List<String> getRegime_tribut()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_regime_tribut");
      driver.close();
      return lista;
    }
    private List<String> getEmpresas()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_empresas");
      driver.close();
      return lista;
    }
    private List<String> getcodigoAplicacaoMercadoria()
    {
      List<String> lista = new ArrayList<String>();
      lista.add("1-Consumo");
      lista.add("2-Revenda");
      return lista;
    }
    private List<String> getcodigoAusenciaFabricante()
    {
      List<String> lista = new ArrayList<String>();
      lista.add("1-O fabricante/produtor é o exportador");
      lista.add("2-O fabricante/produtor não é o exportador");
      lista.add("3-O fabricante/produtor é desconhecido");
      return lista;
    }
    private List<String> getcodigoTipoAcordoTarifario()
    {
      List<String> lista = new ArrayList<String>();
      lista.add("1-nenhum");
      lista.add("2-ALADI (Associação Latino-Americana de Integração)");
      lista.add("3-OMC / GATT - Organização Mundial de Comércio");
      lista.add("4-SGPC - Sistema Global de Preferências Comerciais");
      return lista;
    }
    private List<String> getcodigoVinculoImportadorExportador()
    {
      List<String> lista = new ArrayList<String>();
      lista.add("1-Não há vinculação entre o comprador e o vendedor.");
      lista.add("2-Há vinculação entre o comprador e o vendedor, mas esta não teve influência no preço da mercadoria.");
      lista.add("3-Há vinculação entre o comprador e o vendedor, e esta vinculação influenciou o preço da mercadoria.");
      return lista;
    }
    private List<String> getindicadorBemEncomenda()
    {
      List<String> lista = new ArrayList<String>();
      lista.add("S-Sim");
      lista.add("N-Não");
      return lista;
    }
    private List<String> getindicadorMultimodal()
    {
      List<String> lista = new ArrayList<String>();
      lista.add("S-Sim");
      lista.add("N-Não");
      return lista;
    }
    private List<String> getindicadorTipoCertificado()
    {
      List<String> lista = new ArrayList<String>();
      lista.add("1-Sem Certificado");
      lista.add("2-CCPTC");
      lista.add("3-CCROM ");
      return lista;
    }

}
