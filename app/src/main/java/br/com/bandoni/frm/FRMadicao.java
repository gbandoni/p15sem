package br.com.bandoni.frm;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.bandoni.dao.commons.ActionReference;
import br.com.bandoni.dao.commons.SQLiteDriver;
import br.com.bandoni.dao.implementation.AdicaoDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexAdicao;
import br.com.bandoni.siscomexhelper.R;

public class FRMadicao extends AppCompatActivity 
{
    private J34SiscomexAdicao table;
    private AdicaoDAOImpl dao;
    private int action;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
         List<String> lstAcordo_aladi = getAcordo_aladi();
         ArrayAdapter<String> adpcodigoAcordoAladi = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstAcordo_aladi);
         AutoCompleteTextView edtcodigoAcordoAladi = (AutoCompleteTextView)findViewById(R.id.edtCodigoacordoaladi);
        edtcodigoAcordoAladi.setAdapter(adpcodigoAcordoAladi);
         List<String> lstFund_legal = getFund_legal();
         ArrayAdapter<String> adpcodigoFundamentoLegalReduzido = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstFund_legal);
         AutoCompleteTextView edtcodigoFundamentoLegalReduzido = (AutoCompleteTextView)findViewById(R.id.edtCodigofundamentolegalreduzido);
        edtcodigoFundamentoLegalReduzido.setAdapter(adpcodigoFundamentoLegalReduzido);
         ArrayAdapter<String> adpcodigoFundamentoLegalRegime = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstFund_legal);
         AutoCompleteTextView edtcodigoFundamentoLegalRegime = (AutoCompleteTextView)findViewById(R.id.edtCodigofundamentolegalregime);
        edtcodigoFundamentoLegalRegime.setAdapter(adpcodigoFundamentoLegalRegime);
         ArrayAdapter<String> adpcodigoFundamentoLegalRegimePisCofins = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstFund_legal);
         AutoCompleteTextView edtcodigoFundamentoLegalRegimePisCofins = (AutoCompleteTextView)findViewById(R.id.edtCodigofundamentolegalregimepiscofins);
        edtcodigoFundamentoLegalRegimePisCofins.setAdapter(adpcodigoFundamentoLegalRegimePisCofins);
         List<String> lstIncoterms = getIncoterms();
         ArrayAdapter<String> adpcodigoIncotermsVenda = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstIncoterms);
         AutoCompleteTextView edtcodigoIncotermsVenda = (AutoCompleteTextView)findViewById(R.id.edtCodigoincotermsvenda);
        edtcodigoIncotermsVenda.setAdapter(adpcodigoIncotermsVenda);
         List<String> lstNbm = getNbm();
         ArrayAdapter<String> adpcodigoMercadoriaNBMSH = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstNbm);
         AutoCompleteTextView edtcodigoMercadoriaNBMSH = (AutoCompleteTextView)findViewById(R.id.edtCodigomercadorianbmsh);
        edtcodigoMercadoriaNBMSH.setAdapter(adpcodigoMercadoriaNBMSH);
         List<String> lstNcm = getNcm();
         ArrayAdapter<String> adpcodigoMercadoriaNCM = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstNcm);
         AutoCompleteTextView edtcodigoMercadoriaNCM = (AutoCompleteTextView)findViewById(R.id.edtCodigomercadoriancm);
        edtcodigoMercadoriaNCM.setAdapter(adpcodigoMercadoriaNCM);
         List<String> lstNaladi_ncca = getNaladi_ncca();
         ArrayAdapter<String> adpcodigoMercadoriaNaladiNCC = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstNaladi_ncca);
         AutoCompleteTextView edtcodigoMercadoriaNaladiNCC = (AutoCompleteTextView)findViewById(R.id.edtCodigomercadorianaladincc);
        edtcodigoMercadoriaNaladiNCC.setAdapter(adpcodigoMercadoriaNaladiNCC);
         ArrayAdapter<String> adpcodigoOrdemMercadoriaNaladiNCC = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstNaladi_ncca);
         AutoCompleteTextView edtcodigoOrdemMercadoriaNaladiNCC = (AutoCompleteTextView)findViewById(R.id.edtCodigoordemmercadorianaladincc);
        edtcodigoOrdemMercadoriaNaladiNCC.setAdapter(adpcodigoOrdemMercadoriaNaladiNCC);
         List<String> lstNaladi_sh = getNaladi_sh();
         ArrayAdapter<String> adpcodigoMercadoriaNaladiSH = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstNaladi_sh);
         AutoCompleteTextView edtcodigoMercadoriaNaladiSH = (AutoCompleteTextView)findViewById(R.id.edtCodigomercadorianaladish);
        edtcodigoMercadoriaNaladiSH.setAdapter(adpcodigoMercadoriaNaladiSH);
         ArrayAdapter<String> adpcodigoOrdemMercadoriaNaladiSH = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstNaladi_sh);
         AutoCompleteTextView edtcodigoOrdemMercadoriaNaladiSH = (AutoCompleteTextView)findViewById(R.id.edtCodigoordemmercadorianaladish);
        edtcodigoOrdemMercadoriaNaladiSH.setAdapter(adpcodigoOrdemMercadoriaNaladiSH);
         List<String> lstValor_aduaneira = getValor_aduaneira();
         ArrayAdapter<String> adpcodigoMetodoValoracao = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstValor_aduaneira);
         AutoCompleteTextView edtcodigoMetodoValoracao = (AutoCompleteTextView)findViewById(R.id.edtCodigometodovaloracao);
        edtcodigoMetodoValoracao.setAdapter(adpcodigoMetodoValoracao);
         List<String> lstMot_adm_temp = getMot_adm_temp();
         ArrayAdapter<String> adpcodigoMotivoAdmissaoTemporaria = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstMot_adm_temp);
         AutoCompleteTextView edtcodigoMotivoAdmissaoTemporaria = (AutoCompleteTextView)findViewById(R.id.edtCodigomotivoadmissaotemporaria);
        edtcodigoMotivoAdmissaoTemporaria.setAdapter(adpcodigoMotivoAdmissaoTemporaria);
         List<String> lstOrgaosurf = getOrgaosurf();
         ArrayAdapter<String> adpcodigoURFEntradaMercadoria = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstOrgaosurf);
         AutoCompleteTextView edtcodigoURFEntradaMercadoria = (AutoCompleteTextView)findViewById(R.id.edtCodigourfentradamercadoria);
        edtcodigoURFEntradaMercadoria.setAdapter(adpcodigoURFEntradaMercadoria);
         List<String> lstViatransporte = getViatransporte();
         ArrayAdapter<String> adpcodigoViaTransporte = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstViatransporte);
         AutoCompleteTextView edtcodigoViaTransporte = (AutoCompleteTextView)findViewById(R.id.edtCodigoviatransporte);
        edtcodigoViaTransporte.setAdapter(adpcodigoViaTransporte);
         List<String> lstMoedas = getMoedas();
         ArrayAdapter<String> adpcodigoMoedaFreteMercadoria = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstMoedas);
         AutoCompleteTextView edtcodigoMoedaFreteMercadoria = (AutoCompleteTextView)findViewById(R.id.edtCodigomoedafretemercadoria);
        edtcodigoMoedaFreteMercadoria.setAdapter(adpcodigoMoedaFreteMercadoria);
         ArrayAdapter<String> adpcodigoMoedaSeguroMercadoria = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstMoedas);
         AutoCompleteTextView edtcodigoMoedaSeguroMercadoria = (AutoCompleteTextView)findViewById(R.id.edtCodigomoedaseguromercadoria);
        edtcodigoMoedaSeguroMercadoria.setAdapter(adpcodigoMoedaSeguroMercadoria);
         List<String> lstMot_sem_cob = getMot_sem_cob();
         ArrayAdapter<String> adpcodigoMotivoSemCobertura = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstMot_sem_cob);
         AutoCompleteTextView edtcodigoMotivoSemCobertura = (AutoCompleteTextView)findViewById(R.id.edtCodigomotivosemcobertura);
        edtcodigoMotivoSemCobertura.setAdapter(adpcodigoMotivoSemCobertura);
         List<String> lstInst_financeira = getInst_financeira();
         ArrayAdapter<String> adpcodigoOrgaoFinanciamentoInternacional = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstInst_financeira);
         AutoCompleteTextView edtcodigoOrgaoFinanciamentoInternacional = (AutoCompleteTextView)findViewById(R.id.edtCodigoorgaofinanciamentointernacional);
        edtcodigoOrgaoFinanciamentoInternacional.setAdapter(adpcodigoOrgaoFinanciamentoInternacional);
         List<String> lstPaises = getPaises();
         ArrayAdapter<String> adpcodigoPaisOrigemMercadoria = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstPaises);
         AutoCompleteTextView edtcodigoPaisOrigemMercadoria = (AutoCompleteTextView)findViewById(R.id.edtCodigopaisorigemmercadoria);
        edtcodigoPaisOrigemMercadoria.setAdapter(adpcodigoPaisOrigemMercadoria);
         ArrayAdapter<String> adpcodigoPaisAquisicaoMercadoria = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstPaises);
         AutoCompleteTextView edtcodigoPaisAquisicaoMercadoria = (AutoCompleteTextView)findViewById(R.id.edtCodigopaisaquisicaomercadoria);
        edtcodigoPaisAquisicaoMercadoria.setAdapter(adpcodigoPaisAquisicaoMercadoria);
         ArrayAdapter<String> adpcodigoPaisProcedenciaMercadoria = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstPaises);
         AutoCompleteTextView edtcodigoPaisProcedenciaMercadoria = (AutoCompleteTextView)findViewById(R.id.edtCodigopaisprocedenciamercadoria);
        edtcodigoPaisProcedenciaMercadoria.setAdapter(adpcodigoPaisProcedenciaMercadoria);
         List<String> lstRegime_tribut = getRegime_tribut();
         ArrayAdapter<String> adpcodigoRegimeTriburarioPisCofins = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstRegime_tribut);
         AutoCompleteTextView edtcodigoRegimeTriburarioPisCofins = (AutoCompleteTextView)findViewById(R.id.edtCodigoregimetriburariopiscofins);
        edtcodigoRegimeTriburarioPisCofins.setAdapter(adpcodigoRegimeTriburarioPisCofins);
         ArrayAdapter<String> adpcodigoRegimeTributacao = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstRegime_tribut);
         AutoCompleteTextView edtcodigoRegimeTributacao = (AutoCompleteTextView)findViewById(R.id.edtCodigoregimetributacao);
        edtcodigoRegimeTributacao.setAdapter(adpcodigoRegimeTributacao);
         List<String> lstEmpresas = getEmpresas();
         ArrayAdapter<String> adpcodigoFabricante = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstEmpresas);
         AutoCompleteTextView edtcodigoFabricante = (AutoCompleteTextView)findViewById(R.id.edtCodigofabricante);
        edtcodigoFabricante.setAdapter(adpcodigoFabricante);
         ArrayAdapter<String> adpcodigoFornecedorEstrangeiro = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstEmpresas);
         AutoCompleteTextView edtcodigoFornecedorEstrangeiro = (AutoCompleteTextView)findViewById(R.id.edtCodigofornecedorestrangeiro);
        edtcodigoFornecedorEstrangeiro.setAdapter(adpcodigoFornecedorEstrangeiro);
        table = new J34SiscomexAdicao();
        dao = new AdicaoDAOImpl(this);
        setContentView(R.layout.activity_detail_adicao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            table = dao.find(it.getStringExtra("NUMERODOCUMENTOCARGA"),it.getStringExtra("NUMEROADICAO"));
            ((TextView) findViewById(R.id.edtNumerodocumentocarga)).setText(table.getNumerodocumentocarga());
            ((TextView) findViewById(R.id.edtNumeroadicao)).setText(table.getNumeroadicao());
            ((TextView) findViewById(R.id.edtCodigoacordoaladi)).setText(table.getCodigoacordoaladi());
            ((TextView) findViewById(R.id.edtCodigoaplicacaomercadoria)).setText(table.getCodigoaplicacaomercadoria());
            ((TextView) findViewById(R.id.edtCodigoausenciafabricante)).setText(table.getCodigoausenciafabricante());
            ((TextView) findViewById(R.id.edtCodigocoberturacambial)).setText(table.getCodigocoberturacambial());
            ((TextView) findViewById(R.id.edtCodigofundamentolegalreduzido)).setText(table.getCodigofundamentolegalreduzido());
            ((TextView) findViewById(R.id.edtCodigofundamentolegalregime)).setText(table.getCodigofundamentolegalregime());
            ((TextView) findViewById(R.id.edtCodigofundamentolegalregimepiscofins)).setText(table.getCodigofundamentolegalregimepiscofins());
            ((TextView) findViewById(R.id.edtCodigoincotermsvenda)).setText(table.getCodigoincotermsvenda());
            ((TextView) findViewById(R.id.edtCodigomercadorianbmsh)).setText(table.getCodigomercadorianbmsh());
            ((TextView) findViewById(R.id.edtCodigomercadoriancm)).setText(table.getCodigomercadoriancm());
            ((TextView) findViewById(R.id.edtCodigomercadorianaladincc)).setText(table.getCodigomercadorianaladincc());
            ((TextView) findViewById(R.id.edtCodigoordemmercadorianaladincc)).setText(table.getCodigoordemmercadorianaladincc());
            ((TextView) findViewById(R.id.edtCodigomercadorianaladish)).setText(table.getCodigomercadorianaladish());
            ((TextView) findViewById(R.id.edtCodigoordemmercadorianaladish)).setText(table.getCodigoordemmercadorianaladish());
            ((TextView) findViewById(R.id.edtCodigometodovaloracao)).setText(table.getCodigometodovaloracao());
            ((TextView) findViewById(R.id.edtCodigomotivoadmissaotemporaria)).setText(table.getCodigomotivoadmissaotemporaria());
            ((TextView) findViewById(R.id.edtCodigourfentradamercadoria)).setText(table.getCodigourfentradamercadoria());
            ((TextView) findViewById(R.id.edtCodigoviatransporte)).setText(table.getCodigoviatransporte());
            ((TextView) findViewById(R.id.edtCodigomoedafretemercadoria)).setText(table.getCodigomoedafretemercadoria().toString());
            ((TextView) findViewById(R.id.edtCodigomoedaseguromercadoria)).setText(table.getCodigomoedaseguromercadoria().toString());
            ((TextView) findViewById(R.id.edtCodigomoedanegociada)).setText(table.getCodigomoedanegociada().toString());
            ((TextView) findViewById(R.id.edtCodigomotivosemcobertura)).setText(table.getCodigomotivosemcobertura());
            ((TextView) findViewById(R.id.edtCodigoorgaofinanciamentointernacional)).setText(table.getCodigoorgaofinanciamentointernacional());
            ((TextView) findViewById(R.id.edtCodigopaisorigemmercadoria)).setText(table.getCodigopaisorigemmercadoria());
            ((TextView) findViewById(R.id.edtCodigopaisaquisicaomercadoria)).setText(table.getCodigopaisaquisicaomercadoria());
            ((TextView) findViewById(R.id.edtCodigopaisprocedenciamercadoria)).setText(table.getCodigopaisprocedenciamercadoria());
            ((TextView) findViewById(R.id.edtCodigoregimetriburariopiscofins)).setText(table.getCodigoregimetriburariopiscofins());
            ((TextView) findViewById(R.id.edtCodigoregimetributacao)).setText(table.getCodigoregimetributacao());
            ((TextView) findViewById(R.id.edtCodigotipoacordotarifario)).setText(table.getCodigotipoacordotarifario());
            ((TextView) findViewById(R.id.edtCodigovinculoimportadorexportador)).setText(table.getCodigovinculoimportadorexportador());
            ((TextView) findViewById(R.id.edtCodigofabricante)).setText(table.getCodigofabricante().toString());
            ((TextView) findViewById(R.id.edtCodigofornecedorestrangeiro)).setText(table.getCodigofornecedorestrangeiro().toString());
            ((TextView) findViewById(R.id.edtIndicadorbemencomenda)).setText(table.getIndicadorbemencomenda());
            ((TextView) findViewById(R.id.edtIndicadormaterialusado)).setText(table.getIndicadormaterialusado());
            ((TextView) findViewById(R.id.edtIndicadormultimodal)).setText(table.getIndicadormultimodal());
            ((TextView) findViewById(R.id.edtIndicadortipocertificado)).setText(table.getIndicadortipocertificado());
            ((TextView) findViewById(R.id.edtNomelocalcondicaovenda)).setText(table.getNomelocalcondicaovenda());
            ((TextView) findViewById(R.id.edtNumerodocumentoreducao)).setText(table.getNumerodocumentoreducao());
            ((TextView) findViewById(R.id.edtNumeroidentificacaoli)).setText(table.getNumeroidentificacaoli());
            ((TextView) findViewById(R.id.edtNumerorof)).setText(table.getNumerorof());
            ((TextView) findViewById(R.id.edtPercentualcoeficientereducaoii)).setText(table.getPercentualcoeficientereducaoii().toString());
            ((TextView) findViewById(R.id.edtPesoliquidomercadoria)).setText(table.getPesoliquidomercadoria().toString());
            ((TextView) findViewById(R.id.edtQuantidadeunidadeestatistica)).setText(table.getQuantidadeunidadeestatistica().toString());
            ((TextView) findViewById(R.id.edtTextocomplementovaloraduaneiro)).setText(table.getTextocomplementovaloraduaneiro());
            ((TextView) findViewById(R.id.edtValoraliquotaicms)).setText(table.getValoraliquotaicms().toString());
            ((TextView) findViewById(R.id.edtValorcalculodcrdolar)).setText(table.getValorcalculodcrdolar().toString());
            ((TextView) findViewById(R.id.edtValorfinanciadosuperior360)).setText(table.getValorfinanciadosuperior360().toString());
            ((TextView) findViewById(R.id.edtValorfretemercadoriamoedanacional)).setText(table.getValorfretemercadoriamoedanacional().toString());
            ((TextView) findViewById(R.id.edtValorfretemercadoriamoedanegociada)).setText(table.getValorfretemercadoriamoedanegociada().toString());
            ((TextView) findViewById(R.id.edtValoriicalculadodcrmoedanacional)).setText(table.getValoriicalculadodcrmoedanacional().toString());
            ((TextView) findViewById(R.id.edtValoriidevidozfm)).setText(table.getValoriidevidozfm().toString());
            ((TextView) findViewById(R.id.edtValoriiareceberzfm)).setText(table.getValoriiareceberzfm().toString());
            ((TextView) findViewById(R.id.edtValormercadoriacondicaovenda)).setText(table.getValormercadoriacondicaovenda().toString());
            ((TextView) findViewById(R.id.edtValormercadoriaembarquemoedanacional)).setText(table.getValormercadoriaembarquemoedanacional().toString());
            ((TextView) findViewById(R.id.edtValormercadoriavendamoedanacional)).setText(table.getValormercadoriavendamoedanacional().toString());
            ((TextView) findViewById(R.id.edtValorseguromercadoriamoedanacional)).setText(table.getValorseguromercadoriamoedanacional().toString());
            ((TextView) findViewById(R.id.edtValorseguromercadoriamoedanegociada)).setText(table.getValorseguromercadoriamoedanegociada().toString());
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
                                table.setNumerodocumentocarga(((TextView) findViewById(R.id.edtNumerodocumentocarga)).getText().toString());
                                table.setNumeroadicao(((TextView) findViewById(R.id.edtNumeroadicao)).getText().toString());
                                table.setCodigoacordoaladi(((AutoCompleteTextView) findViewById(R.id.edtCodigoacordoaladi)).getText().toString());
                                table.setCodigoaplicacaomercadoria(((TextView) findViewById(R.id.edtCodigoaplicacaomercadoria)).getText().toString());
                                table.setCodigoausenciafabricante(((TextView) findViewById(R.id.edtCodigoausenciafabricante)).getText().toString());
                                table.setCodigocoberturacambial(((TextView) findViewById(R.id.edtCodigocoberturacambial)).getText().toString());
                                table.setCodigofundamentolegalreduzido(((AutoCompleteTextView) findViewById(R.id.edtCodigofundamentolegalreduzido)).getText().toString());
                                table.setCodigofundamentolegalregime(((AutoCompleteTextView) findViewById(R.id.edtCodigofundamentolegalregime)).getText().toString());
                                table.setCodigofundamentolegalregimepiscofins(((AutoCompleteTextView) findViewById(R.id.edtCodigofundamentolegalregimepiscofins)).getText().toString());
                                table.setCodigoincotermsvenda(((AutoCompleteTextView) findViewById(R.id.edtCodigoincotermsvenda)).getText().toString());
                                table.setCodigomercadorianbmsh(((AutoCompleteTextView) findViewById(R.id.edtCodigomercadorianbmsh)).getText().toString());
                                table.setCodigomercadoriancm(((AutoCompleteTextView) findViewById(R.id.edtCodigomercadoriancm)).getText().toString());
                                table.setCodigomercadorianaladincc(((AutoCompleteTextView) findViewById(R.id.edtCodigomercadorianaladincc)).getText().toString());
                                table.setCodigoordemmercadorianaladincc(((AutoCompleteTextView) findViewById(R.id.edtCodigoordemmercadorianaladincc)).getText().toString());
                                table.setCodigomercadorianaladish(((AutoCompleteTextView) findViewById(R.id.edtCodigomercadorianaladish)).getText().toString());
                                table.setCodigoordemmercadorianaladish(((AutoCompleteTextView) findViewById(R.id.edtCodigoordemmercadorianaladish)).getText().toString());
                                table.setCodigometodovaloracao(((AutoCompleteTextView) findViewById(R.id.edtCodigometodovaloracao)).getText().toString());
                                table.setCodigomotivoadmissaotemporaria(((AutoCompleteTextView) findViewById(R.id.edtCodigomotivoadmissaotemporaria)).getText().toString());
                                table.setCodigourfentradamercadoria(((AutoCompleteTextView) findViewById(R.id.edtCodigourfentradamercadoria)).getText().toString());
                                table.setCodigoviatransporte(((AutoCompleteTextView) findViewById(R.id.edtCodigoviatransporte)).getText().toString());
                                table.setCodigomoedafretemercadoria(Integer.parseInt(((AutoCompleteTextView) findViewById(R.id.edtCodigomoedafretemercadoria)).getText().toString()));
                                table.setCodigomoedaseguromercadoria(Integer.parseInt(((AutoCompleteTextView) findViewById(R.id.edtCodigomoedaseguromercadoria)).getText().toString()));
                                table.setCodigomoedanegociada(Integer.parseInt(((TextView) findViewById(R.id.edtCodigomoedanegociada)).getText().toString()));
                                table.setCodigomotivosemcobertura(((AutoCompleteTextView) findViewById(R.id.edtCodigomotivosemcobertura)).getText().toString());
                                table.setCodigoorgaofinanciamentointernacional(((AutoCompleteTextView) findViewById(R.id.edtCodigoorgaofinanciamentointernacional)).getText().toString());
                                table.setCodigopaisorigemmercadoria(((AutoCompleteTextView) findViewById(R.id.edtCodigopaisorigemmercadoria)).getText().toString());
                                table.setCodigopaisaquisicaomercadoria(((AutoCompleteTextView) findViewById(R.id.edtCodigopaisaquisicaomercadoria)).getText().toString());
                                table.setCodigopaisprocedenciamercadoria(((AutoCompleteTextView) findViewById(R.id.edtCodigopaisprocedenciamercadoria)).getText().toString());
                                table.setCodigoregimetriburariopiscofins(((AutoCompleteTextView) findViewById(R.id.edtCodigoregimetriburariopiscofins)).getText().toString());
                                table.setCodigoregimetributacao(((AutoCompleteTextView) findViewById(R.id.edtCodigoregimetributacao)).getText().toString());
                                table.setCodigotipoacordotarifario(((TextView) findViewById(R.id.edtCodigotipoacordotarifario)).getText().toString());
                                table.setCodigovinculoimportadorexportador(((TextView) findViewById(R.id.edtCodigovinculoimportadorexportador)).getText().toString());
                                table.setCodigofabricante(Integer.parseInt(((AutoCompleteTextView) findViewById(R.id.edtCodigofabricante)).getText().toString()));
                                table.setCodigofornecedorestrangeiro(Integer.parseInt(((AutoCompleteTextView) findViewById(R.id.edtCodigofornecedorestrangeiro)).getText().toString()));
                                table.setIndicadorbemencomenda(((TextView) findViewById(R.id.edtIndicadorbemencomenda)).getText().toString());
                                table.setIndicadormaterialusado(((TextView) findViewById(R.id.edtIndicadormaterialusado)).getText().toString());
                                table.setIndicadormultimodal(((TextView) findViewById(R.id.edtIndicadormultimodal)).getText().toString());
                                table.setIndicadortipocertificado(((TextView) findViewById(R.id.edtIndicadortipocertificado)).getText().toString());
                                table.setNomelocalcondicaovenda(((TextView) findViewById(R.id.edtNomelocalcondicaovenda)).getText().toString());
                                table.setNumerodocumentoreducao(((TextView) findViewById(R.id.edtNumerodocumentoreducao)).getText().toString());
                                table.setNumeroidentificacaoli(((TextView) findViewById(R.id.edtNumeroidentificacaoli)).getText().toString());
                                table.setNumerorof(((TextView) findViewById(R.id.edtNumerorof)).getText().toString());
                                table.setPercentualcoeficientereducaoii(Float.parseFloat(((TextView) findViewById(R.id.edtPercentualcoeficientereducaoii)).getText().toString()));
                                table.setPesoliquidomercadoria(Float.parseFloat(((TextView) findViewById(R.id.edtPesoliquidomercadoria)).getText().toString()));
                                table.setQuantidadeunidadeestatistica(Float.parseFloat(((TextView) findViewById(R.id.edtQuantidadeunidadeestatistica)).getText().toString()));
                                table.setTextocomplementovaloraduaneiro(((TextView) findViewById(R.id.edtTextocomplementovaloraduaneiro)).getText().toString());
                                table.setValoraliquotaicms(Float.parseFloat(((TextView) findViewById(R.id.edtValoraliquotaicms)).getText().toString()));
                                table.setValorcalculodcrdolar(Float.parseFloat(((TextView) findViewById(R.id.edtValorcalculodcrdolar)).getText().toString()));
                                table.setValorfinanciadosuperior360(Float.parseFloat(((TextView) findViewById(R.id.edtValorfinanciadosuperior360)).getText().toString()));
                                table.setValorfretemercadoriamoedanacional(Float.parseFloat(((TextView) findViewById(R.id.edtValorfretemercadoriamoedanacional)).getText().toString()));
                                table.setValorfretemercadoriamoedanegociada(Float.parseFloat(((TextView) findViewById(R.id.edtValorfretemercadoriamoedanegociada)).getText().toString()));
                                table.setValoriicalculadodcrmoedanacional(Float.parseFloat(((TextView) findViewById(R.id.edtValoriicalculadodcrmoedanacional)).getText().toString()));
                                table.setValoriidevidozfm(Float.parseFloat(((TextView) findViewById(R.id.edtValoriidevidozfm)).getText().toString()));
                                table.setValoriiareceberzfm(Float.parseFloat(((TextView) findViewById(R.id.edtValoriiareceberzfm)).getText().toString()));
                                table.setValormercadoriacondicaovenda(Float.parseFloat(((TextView) findViewById(R.id.edtValormercadoriacondicaovenda)).getText().toString()));
                                table.setValormercadoriaembarquemoedanacional(Float.parseFloat(((TextView) findViewById(R.id.edtValormercadoriaembarquemoedanacional)).getText().toString()));
                                table.setValormercadoriavendamoedanacional(Float.parseFloat(((TextView) findViewById(R.id.edtValormercadoriavendamoedanacional)).getText().toString()));
                                table.setValorseguromercadoriamoedanacional(Float.parseFloat(((TextView) findViewById(R.id.edtValorseguromercadoriamoedanacional)).getText().toString()));
                                table.setValorseguromercadoriamoedanegociada(Float.parseFloat(((TextView) findViewById(R.id.edtValorseguromercadoriamoedanegociada)).getText().toString()));
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

}
