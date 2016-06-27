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
import br.com.bandoni.dao.implementation.DiDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexDi;

import br.com.bandoni.dao.commons.SQLiteDriver;
import java.util.ArrayList;
import java.util.List;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import br.com.bandoni.siscomexhelper.R;

public class FRMdi extends AppCompatActivity 
{
    private J34SiscomexDi table;
    private DiDAOImpl dao;
    private int action;
    private TextView edtNumerodocumentocarga;
    private AutoCompleteTextView edtCodigotipodocumentocarga;
    private AutoCompleteTextView edtCodigomoedaseguro;
    private AutoCompleteTextView edtCodigomoedafrete;
    private AutoCompleteTextView edtCodigomotivotransmissao;
    private TextView edtCargapesobruto;
    private TextView edtCargapesoliquido;
    private TextView edtCodigobandeiratranspote;
    private AutoCompleteTextView edtCodigomodalidadedespacho;
    private AutoCompleteTextView edtCodigoorigemdi;
    private AutoCompleteTextView edtCodigopaisprocedenciacarga;
    private AutoCompleteTextView edtCodigopaisimportador;
    private AutoCompleteTextView edtCodigorecintoalfandegado;
    private TextView edtCodigosetorarmazenamento;
    private AutoCompleteTextView edtCodigotipoagentecarga;
    private AutoCompleteTextView edtCodigotipoconsignatario;
    private AutoCompleteTextView edtCodigotipodeclaracao;
    private AutoCompleteTextView edtCodigotipoimportador;
    private AutoCompleteTextView edtCodigotipomanifesto;
    private AutoCompleteTextView edtCodigotipopagamentotributario;
    private AutoCompleteTextView edtCodigourfcargaentrada;
    private AutoCompleteTextView edtCodigourfdespacho;
    private AutoCompleteTextView edtCodigoutilizacaodocumentocarga;
    private AutoCompleteTextView edtCodigoviatransporte;
    private TextView edtDatachegadacarga;
    private TextView edtDataembarque;
    private TextView edtIdentificacaodeclaracaoimportacao;
    private AutoCompleteTextView edtCodigoimportador;
    private AutoCompleteTextView edtIndicadormultimodalviatransporte;
    private TextView edtIndicadoroperacaofundap;
    private TextView edtInformacoescomplementares;
    private AutoCompleteTextView edtCodigoconsignatorio;
    private AutoCompleteTextView edtCodigolocalembarque;
    private TextView edtNomelocalembarque;
    private AutoCompleteTextView edtCodigotransportador;
    private AutoCompleteTextView edtCodigoveiculo;
    private TextView edtNumeroagentecarga;
    private TextView edtNumeroconsignatario;
    private TextView edtNumerocontapagamentotributario;
    private TextView edtNumerocpfrepresentantelegal;
    private TextView edtNumerodocumentocargamaster;
    private TextView edtNumeroimportador;
    private TextView edtNumeromanifesto;
    private TextView edtTotaladicoes;
    private TextView edtValorfreteterritorionacionalmoedanegociada;
    private TextView edtValortotalfretecollect;
    private TextView edtValortotalfretemoedanacional;
    private TextView edtValortotalfreteprepaid;
    private TextView edtValortotalmlemoedanacional;
    private AutoCompleteTextView edtTerminalrecintoalfandegario;
    private TextView edtValortotalseguromoedanacional;
    private TextView edtValortotalseguromoedanegociada;
    private TextView edtId;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_di);
        //campos do formulario;
        edtNumerodocumentocarga = (TextView)findViewById(R.id.edtNumerodocumentocarga);
        edtCodigotipodocumentocarga = (AutoCompleteTextView)findViewById(R.id.edtCodigotipodocumentocarga);
        edtCodigomoedaseguro = (AutoCompleteTextView)findViewById(R.id.edtCodigomoedaseguro);
        edtCodigomoedafrete = (AutoCompleteTextView)findViewById(R.id.edtCodigomoedafrete);
        edtCodigomotivotransmissao = (AutoCompleteTextView)findViewById(R.id.edtCodigomotivotransmissao);
        edtCargapesobruto = (TextView)findViewById(R.id.edtCargapesobruto);
        edtCargapesoliquido = (TextView)findViewById(R.id.edtCargapesoliquido);
        edtCodigobandeiratranspote = (TextView)findViewById(R.id.edtCodigobandeiratranspote);
        edtCodigomodalidadedespacho = (AutoCompleteTextView)findViewById(R.id.edtCodigomodalidadedespacho);
        edtCodigoorigemdi = (AutoCompleteTextView)findViewById(R.id.edtCodigoorigemdi);
        edtCodigopaisprocedenciacarga = (AutoCompleteTextView)findViewById(R.id.edtCodigopaisprocedenciacarga);
        edtCodigopaisimportador = (AutoCompleteTextView)findViewById(R.id.edtCodigopaisimportador);
        edtCodigorecintoalfandegado = (AutoCompleteTextView)findViewById(R.id.edtCodigorecintoalfandegado);
        edtCodigosetorarmazenamento = (TextView)findViewById(R.id.edtCodigosetorarmazenamento);
        edtCodigotipoagentecarga = (AutoCompleteTextView)findViewById(R.id.edtCodigotipoagentecarga);
        edtCodigotipoconsignatario = (AutoCompleteTextView)findViewById(R.id.edtCodigotipoconsignatario);
        edtCodigotipodeclaracao = (AutoCompleteTextView)findViewById(R.id.edtCodigotipodeclaracao);
        edtCodigotipoimportador = (AutoCompleteTextView)findViewById(R.id.edtCodigotipoimportador);
        edtCodigotipomanifesto = (AutoCompleteTextView)findViewById(R.id.edtCodigotipomanifesto);
        edtCodigotipopagamentotributario = (AutoCompleteTextView)findViewById(R.id.edtCodigotipopagamentotributario);
        edtCodigourfcargaentrada = (AutoCompleteTextView)findViewById(R.id.edtCodigourfcargaentrada);
        edtCodigourfdespacho = (AutoCompleteTextView)findViewById(R.id.edtCodigourfdespacho);
        edtCodigoutilizacaodocumentocarga = (AutoCompleteTextView)findViewById(R.id.edtCodigoutilizacaodocumentocarga);
        edtCodigoviatransporte = (AutoCompleteTextView)findViewById(R.id.edtCodigoviatransporte);
        edtDatachegadacarga = (TextView)findViewById(R.id.edtDatachegadacarga);
        edtDataembarque = (TextView)findViewById(R.id.edtDataembarque);
        edtIdentificacaodeclaracaoimportacao = (TextView)findViewById(R.id.edtIdentificacaodeclaracaoimportacao);
        edtCodigoimportador = (AutoCompleteTextView)findViewById(R.id.edtCodigoimportador);
        edtIndicadormultimodalviatransporte = (AutoCompleteTextView)findViewById(R.id.edtIndicadormultimodalviatransporte);
        edtIndicadoroperacaofundap = (TextView)findViewById(R.id.edtIndicadoroperacaofundap);
        edtInformacoescomplementares = (TextView)findViewById(R.id.edtInformacoescomplementares);
        edtCodigoconsignatorio = (AutoCompleteTextView)findViewById(R.id.edtCodigoconsignatorio);
        edtCodigolocalembarque = (AutoCompleteTextView)findViewById(R.id.edtCodigolocalembarque);
        edtNomelocalembarque = (TextView)findViewById(R.id.edtNomelocalembarque);
        edtCodigotransportador = (AutoCompleteTextView)findViewById(R.id.edtCodigotransportador);
        edtCodigoveiculo = (AutoCompleteTextView)findViewById(R.id.edtCodigoveiculo);
        edtNumeroagentecarga = (TextView)findViewById(R.id.edtNumeroagentecarga);
        edtNumeroconsignatario = (TextView)findViewById(R.id.edtNumeroconsignatario);
        edtNumerocontapagamentotributario = (TextView)findViewById(R.id.edtNumerocontapagamentotributario);
        edtNumerocpfrepresentantelegal = (TextView)findViewById(R.id.edtNumerocpfrepresentantelegal);
        edtNumerodocumentocargamaster = (TextView)findViewById(R.id.edtNumerodocumentocargamaster);
        edtNumeroimportador = (TextView)findViewById(R.id.edtNumeroimportador);
        edtNumeromanifesto = (TextView)findViewById(R.id.edtNumeromanifesto);
        edtTotaladicoes = (TextView)findViewById(R.id.edtTotaladicoes);
        edtValorfreteterritorionacionalmoedanegociada = (TextView)findViewById(R.id.edtValorfreteterritorionacionalmoedanegociada);
        edtValortotalfretecollect = (TextView)findViewById(R.id.edtValortotalfretecollect);
        edtValortotalfretemoedanacional = (TextView)findViewById(R.id.edtValortotalfretemoedanacional);
        edtValortotalfreteprepaid = (TextView)findViewById(R.id.edtValortotalfreteprepaid);
        edtValortotalmlemoedanacional = (TextView)findViewById(R.id.edtValortotalmlemoedanacional);
        edtTerminalrecintoalfandegario = (AutoCompleteTextView)findViewById(R.id.edtTerminalrecintoalfandegario);
        edtValortotalseguromoedanacional = (TextView)findViewById(R.id.edtValortotalseguromoedanacional);
        edtValortotalseguromoedanegociada = (TextView)findViewById(R.id.edtValortotalseguromoedanegociada);
        edtId = (TextView)findViewById(R.id.edtId);
         List<String> lstTipo_documento = getTipo_documento();
         ArrayAdapter<String> adpCodigotipodocumentocarga = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstTipo_documento);
        edtCodigotipodocumentocarga.setAdapter(adpCodigotipodocumentocarga);
         List<String> lstMoedas = getMoedas();
         ArrayAdapter<String> adpCodigomoedaseguro = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstMoedas);
        edtCodigomoedaseguro.setAdapter(adpCodigomoedaseguro);
         ArrayAdapter<String> adpCodigomoedafrete = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstMoedas);
        edtCodigomoedafrete.setAdapter(adpCodigomoedafrete);
         List<String> lstMotivotransmissao = getMotivotransmissao();
         ArrayAdapter<String> adpCodigomotivotransmissao = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstMotivotransmissao);
        edtCodigomotivotransmissao.setAdapter(adpCodigomotivotransmissao);
         List<String> lstModdespacho = getModdespacho();
         ArrayAdapter<String> adpCodigomodalidadedespacho = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstModdespacho);
        edtCodigomodalidadedespacho.setAdapter(adpCodigomodalidadedespacho);
         List<String> lstOrigem_di = getOrigem_di();
         ArrayAdapter<String> adpCodigoorigemdi = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstOrigem_di);
        edtCodigoorigemdi.setAdapter(adpCodigoorigemdi);
         List<String> lstPaises = getPaises();
         ArrayAdapter<String> adpCodigopaisprocedenciacarga = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstPaises);
        edtCodigopaisprocedenciacarga.setAdapter(adpCodigopaisprocedenciacarga);
         ArrayAdapter<String> adpCodigopaisimportador = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstPaises);
        edtCodigopaisimportador.setAdapter(adpCodigopaisimportador);
         List<String> lstRecintoalfandegado = getRecintoalfandegado();
         ArrayAdapter<String> adpCodigorecintoalfandegado = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstRecintoalfandegado);
        edtCodigorecintoalfandegado.setAdapter(adpCodigorecintoalfandegado);
         List<String> lstTipo_declaracao = getTipo_declaracao();
         ArrayAdapter<String> adpCodigotipodeclaracao = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstTipo_declaracao);
        edtCodigotipodeclaracao.setAdapter(adpCodigotipodeclaracao);
         List<String> lstTipo_importador = getTipo_importador();
         ArrayAdapter<String> adpCodigotipoimportador = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstTipo_importador);
        edtCodigotipoimportador.setAdapter(adpCodigotipoimportador);
         List<String> lstTipomanifesto = getTipomanifesto();
         ArrayAdapter<String> adpCodigotipomanifesto = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstTipomanifesto);
        edtCodigotipomanifesto.setAdapter(adpCodigotipomanifesto);
         List<String> lstOrgaosurf = getOrgaosurf();
         ArrayAdapter<String> adpCodigourfcargaentrada = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstOrgaosurf);
        edtCodigourfcargaentrada.setAdapter(adpCodigourfcargaentrada);
         ArrayAdapter<String> adpCodigourfdespacho = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstOrgaosurf);
        edtCodigourfdespacho.setAdapter(adpCodigourfdespacho);
         List<String> lstViatransporte = getViatransporte();
         ArrayAdapter<String> adpCodigoviatransporte = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstViatransporte);
        edtCodigoviatransporte.setAdapter(adpCodigoviatransporte);
         List<String> lstEmpresas = getEmpresas();
         ArrayAdapter<String> adpCodigoimportador = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstEmpresas);
        edtCodigoimportador.setAdapter(adpCodigoimportador);
         ArrayAdapter<String> adpCodigoconsignatorio = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstEmpresas);
        edtCodigoconsignatorio.setAdapter(adpCodigoconsignatorio);
         List<String> lstLocalidadeembarque = getLocalidadeembarque();
         ArrayAdapter<String> adpCodigolocalembarque = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstLocalidadeembarque);
        edtCodigolocalembarque.setAdapter(adpCodigolocalembarque);
         List<String> lstTransportador = getTransportador();
         ArrayAdapter<String> adpCodigotransportador = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstTransportador);
        edtCodigotransportador.setAdapter(adpCodigotransportador);
         List<String> lstVeiculos = getVeiculos();
         ArrayAdapter<String> adpCodigoveiculo = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstVeiculos);
        edtCodigoveiculo.setAdapter(adpCodigoveiculo);
         ArrayAdapter<String> adpTerminalrecintoalfandegario = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstRecintoalfandegado);
        edtTerminalrecintoalfandegario.setAdapter(adpTerminalrecintoalfandegario);
         List<String> lstcodigoTipoAgenteCarga = getcodigoTipoAgenteCarga();
         ArrayAdapter<String> adpCodigotipoagentecarga = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstcodigoTipoAgenteCarga);
        edtCodigotipoagentecarga.setAdapter(adpCodigotipoagentecarga);
         List<String> lstcodigoTipoConsignatario = getcodigoTipoConsignatario();
         ArrayAdapter<String> adpCodigotipoconsignatario = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstcodigoTipoConsignatario);
        edtCodigotipoconsignatario.setAdapter(adpCodigotipoconsignatario);
         List<String> lstcodigoTipoPagamentoTributario = getcodigoTipoPagamentoTributario();
         ArrayAdapter<String> adpCodigotipopagamentotributario = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstcodigoTipoPagamentoTributario);
        edtCodigotipopagamentotributario.setAdapter(adpCodigotipopagamentotributario);
         List<String> lstcodigoUtilizacaoDocumentoCarga = getcodigoUtilizacaoDocumentoCarga();
         ArrayAdapter<String> adpCodigoutilizacaodocumentocarga = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstcodigoUtilizacaoDocumentoCarga);
        edtCodigoutilizacaodocumentocarga.setAdapter(adpCodigoutilizacaodocumentocarga);
         List<String> lstindicadorMultimodalViaTransporte = getindicadorMultimodalViaTransporte();
         ArrayAdapter<String> adpIndicadormultimodalviatransporte = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstindicadorMultimodalViaTransporte);
        edtIndicadormultimodalviatransporte.setAdapter(adpIndicadormultimodalviatransporte);
        dao = new DiDAOImpl(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            try
            {
              table = dao.find(it.getStringExtra("NUMERODOCUMENTOCARGA"));
            edtNumerodocumentocarga.setText(table.getNumerodocumentocarga());
            edtCodigotipodocumentocarga.setText(table.getCodigotipodocumentocarga());
            edtCodigomoedaseguro.setText(table.getCodigomoedaseguro().toString());
            edtCodigomoedafrete.setText(table.getCodigomoedafrete().toString());
            edtCodigomotivotransmissao.setText(table.getCodigomotivotransmissao().toString());
            edtCargapesobruto.setText(table.getCargapesobruto().toString());
            edtCargapesoliquido.setText(table.getCargapesoliquido().toString());
            edtCodigobandeiratranspote.setText(table.getCodigobandeiratranspote());
            edtCodigomodalidadedespacho.setText(table.getCodigomodalidadedespacho().toString());
            edtCodigoorigemdi.setText(table.getCodigoorigemdi());
            edtCodigopaisprocedenciacarga.setText(table.getCodigopaisprocedenciacarga());
            edtCodigopaisimportador.setText(table.getCodigopaisimportador());
            edtCodigorecintoalfandegado.setText(table.getCodigorecintoalfandegado());
            edtCodigosetorarmazenamento.setText(table.getCodigosetorarmazenamento());
            edtCodigotipoagentecarga.setText(table.getCodigotipoagentecarga());
            edtCodigotipoconsignatario.setText(table.getCodigotipoconsignatario());
            edtCodigotipodeclaracao.setText(table.getCodigotipodeclaracao().toString());
            edtCodigotipoimportador.setText(table.getCodigotipoimportador().toString());
            edtCodigotipomanifesto.setText(table.getCodigotipomanifesto().toString());
            edtCodigotipopagamentotributario.setText(table.getCodigotipopagamentotributario());
            edtCodigourfcargaentrada.setText(table.getCodigourfcargaentrada());
            edtCodigourfdespacho.setText(table.getCodigourfdespacho());
            edtCodigoutilizacaodocumentocarga.setText(table.getCodigoutilizacaodocumentocarga());
            edtCodigoviatransporte.setText(table.getCodigoviatransporte());
            edtDatachegadacarga.setText(table.getDatachegadacarga().toString());
            edtDataembarque.setText(table.getDataembarque().toString());
            edtIdentificacaodeclaracaoimportacao.setText(table.getIdentificacaodeclaracaoimportacao());
            edtCodigoimportador.setText(table.getCodigoimportador().toString());
            edtIndicadormultimodalviatransporte.setText(table.getIndicadormultimodalviatransporte());
            edtIndicadoroperacaofundap.setText(table.getIndicadoroperacaofundap());
            edtInformacoescomplementares.setText(table.getInformacoescomplementares().toString());
            edtCodigoconsignatorio.setText(table.getCodigoconsignatorio().toString());
            edtCodigolocalembarque.setText(table.getCodigolocalembarque());
            edtNomelocalembarque.setText(table.getNomelocalembarque().toString());
            edtCodigotransportador.setText(table.getCodigotransportador().toString());
            edtCodigoveiculo.setText(table.getCodigoveiculo().toString());
            edtNumeroagentecarga.setText(table.getNumeroagentecarga());
            edtNumeroconsignatario.setText(table.getNumeroconsignatario());
            edtNumerocontapagamentotributario.setText(table.getNumerocontapagamentotributario());
            edtNumerocpfrepresentantelegal.setText(table.getNumerocpfrepresentantelegal());
            edtNumerodocumentocargamaster.setText(table.getNumerodocumentocargamaster());
            edtNumeroimportador.setText(table.getNumeroimportador());
            edtNumeromanifesto.setText(table.getNumeromanifesto());
            edtTotaladicoes.setText(table.getTotaladicoes().toString());
            edtValorfreteterritorionacionalmoedanegociada.setText(table.getValorfreteterritorionacionalmoedanegociada().toString());
            edtValortotalfretecollect.setText(table.getValortotalfretecollect().toString());
            edtValortotalfretemoedanacional.setText(table.getValortotalfretemoedanacional().toString());
            edtValortotalfreteprepaid.setText(table.getValortotalfreteprepaid().toString());
            edtValortotalmlemoedanacional.setText(table.getValortotalmlemoedanacional().toString());
            edtTerminalrecintoalfandegario.setText(table.getTerminalrecintoalfandegario());
            edtValortotalseguromoedanacional.setText(table.getValortotalseguromoedanacional().toString());
            edtValortotalseguromoedanegociada.setText(table.getValortotalseguromoedanegociada().toString());
            edtId.setText(table.getId());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtNumerodocumentocarga.setEnabled(false);
                  edtCodigotipodocumentocarga.setEnabled(false);
                  edtCodigomoedaseguro.setEnabled(false);
                  edtCodigomoedafrete.setEnabled(false);
                  edtCodigomotivotransmissao.setEnabled(false);
                  edtCargapesobruto.setEnabled(false);
                  edtCargapesoliquido.setEnabled(false);
                  edtCodigobandeiratranspote.setEnabled(false);
                  edtCodigomodalidadedespacho.setEnabled(false);
                  edtCodigoorigemdi.setEnabled(false);
                  edtCodigopaisprocedenciacarga.setEnabled(false);
                  edtCodigopaisimportador.setEnabled(false);
                  edtCodigorecintoalfandegado.setEnabled(false);
                  edtCodigosetorarmazenamento.setEnabled(false);
                  edtCodigotipoagentecarga.setEnabled(false);
                  edtCodigotipoconsignatario.setEnabled(false);
                  edtCodigotipodeclaracao.setEnabled(false);
                  edtCodigotipoimportador.setEnabled(false);
                  edtCodigotipomanifesto.setEnabled(false);
                  edtCodigotipopagamentotributario.setEnabled(false);
                  edtCodigourfcargaentrada.setEnabled(false);
                  edtCodigourfdespacho.setEnabled(false);
                  edtCodigoutilizacaodocumentocarga.setEnabled(false);
                  edtCodigoviatransporte.setEnabled(false);
                  edtDatachegadacarga.setEnabled(false);
                  edtDataembarque.setEnabled(false);
                  edtIdentificacaodeclaracaoimportacao.setEnabled(false);
                  edtCodigoimportador.setEnabled(false);
                  edtIndicadormultimodalviatransporte.setEnabled(false);
                  edtIndicadoroperacaofundap.setEnabled(false);
                  edtInformacoescomplementares.setEnabled(false);
                  edtCodigoconsignatorio.setEnabled(false);
                  edtCodigolocalembarque.setEnabled(false);
                  edtNomelocalembarque.setEnabled(false);
                  edtCodigotransportador.setEnabled(false);
                  edtCodigoveiculo.setEnabled(false);
                  edtNumeroagentecarga.setEnabled(false);
                  edtNumeroconsignatario.setEnabled(false);
                  edtNumerocontapagamentotributario.setEnabled(false);
                  edtNumerocpfrepresentantelegal.setEnabled(false);
                  edtNumerodocumentocargamaster.setEnabled(false);
                  edtNumeroimportador.setEnabled(false);
                  edtNumeromanifesto.setEnabled(false);
                  edtTotaladicoes.setEnabled(false);
                  edtValorfreteterritorionacionalmoedanegociada.setEnabled(false);
                  edtValortotalfretecollect.setEnabled(false);
                  edtValortotalfretemoedanacional.setEnabled(false);
                  edtValortotalfreteprepaid.setEnabled(false);
                  edtValortotalmlemoedanacional.setEnabled(false);
                  edtTerminalrecintoalfandegario.setEnabled(false);
                  edtValortotalseguromoedanacional.setEnabled(false);
                  edtValortotalseguromoedanegociada.setEnabled(false);
                  edtId.setEnabled(false);
                }
                else
                {
                  edtNumerodocumentocarga.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMdi.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexDi();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_di, menu);
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
                                table.setCodigotipodocumentocarga(edtCodigotipodocumentocarga.getText().toString());
                                table.setCodigomoedaseguro(Integer.parseInt(edtCodigomoedaseguro.getText().toString()));
                                table.setCodigomoedafrete(Integer.parseInt(edtCodigomoedafrete.getText().toString()));
                                table.setCodigomotivotransmissao(Integer.parseInt(edtCodigomotivotransmissao.getText().toString()));
                                table.setCargapesobruto(Float.parseFloat(edtCargapesobruto.getText().toString()));
                                table.setCargapesoliquido(Float.parseFloat(edtCargapesoliquido.getText().toString()));
                                table.setCodigobandeiratranspote(edtCodigobandeiratranspote.getText().toString());
                                table.setCodigomodalidadedespacho(Integer.parseInt(edtCodigomodalidadedespacho.getText().toString()));
                                table.setCodigoorigemdi(edtCodigoorigemdi.getText().toString());
                                table.setCodigopaisprocedenciacarga(edtCodigopaisprocedenciacarga.getText().toString());
                                table.setCodigopaisimportador(edtCodigopaisimportador.getText().toString());
                                table.setCodigorecintoalfandegado(edtCodigorecintoalfandegado.getText().toString());
                                table.setCodigosetorarmazenamento(edtCodigosetorarmazenamento.getText().toString());
                                table.setCodigotipoagentecarga(edtCodigotipoagentecarga.getText().toString());
                                table.setCodigotipoconsignatario(edtCodigotipoconsignatario.getText().toString());
                                table.setCodigotipodeclaracao(Integer.parseInt(edtCodigotipodeclaracao.getText().toString()));
                                table.setCodigotipoimportador(Integer.parseInt(edtCodigotipoimportador.getText().toString()));
                                table.setCodigotipomanifesto(Integer.parseInt(edtCodigotipomanifesto.getText().toString()));
                                table.setCodigotipopagamentotributario(edtCodigotipopagamentotributario.getText().toString());
                                table.setCodigourfcargaentrada(edtCodigourfcargaentrada.getText().toString());
                                table.setCodigourfdespacho(edtCodigourfdespacho.getText().toString());
                                table.setCodigoutilizacaodocumentocarga(edtCodigoutilizacaodocumentocarga.getText().toString());
                                table.setCodigoviatransporte(edtCodigoviatransporte.getText().toString());
                                table.setDatachegadacarga(edtDatachegadacarga.getText().toString());
                                table.setDataembarque(edtDataembarque.getText().toString());
                                table.setIdentificacaodeclaracaoimportacao(edtIdentificacaodeclaracaoimportacao.getText().toString());
                                table.setCodigoimportador(Integer.parseInt(edtCodigoimportador.getText().toString()));
                                table.setIndicadormultimodalviatransporte(edtIndicadormultimodalviatransporte.getText().toString());
                                table.setIndicadoroperacaofundap(edtIndicadoroperacaofundap.getText().toString());
                                table.setInformacoescomplementares(edtInformacoescomplementares.getText().toString());
                                table.setCodigoconsignatorio(Integer.parseInt(edtCodigoconsignatorio.getText().toString()));
                                table.setCodigolocalembarque(edtCodigolocalembarque.getText().toString());
                                table.setNomelocalembarque(Integer.parseInt(edtNomelocalembarque.getText().toString()));
                                table.setCodigotransportador(Integer.parseInt(edtCodigotransportador.getText().toString()));
                                table.setCodigoveiculo(Integer.parseInt(edtCodigoveiculo.getText().toString()));
                                table.setNumeroagentecarga(edtNumeroagentecarga.getText().toString());
                                table.setNumeroconsignatario(edtNumeroconsignatario.getText().toString());
                                table.setNumerocontapagamentotributario(edtNumerocontapagamentotributario.getText().toString());
                                table.setNumerocpfrepresentantelegal(edtNumerocpfrepresentantelegal.getText().toString());
                                table.setNumerodocumentocargamaster(edtNumerodocumentocargamaster.getText().toString());
                                table.setNumeroimportador(edtNumeroimportador.getText().toString());
                                table.setNumeromanifesto(edtNumeromanifesto.getText().toString());
                                table.setTotaladicoes(Float.parseFloat(edtTotaladicoes.getText().toString()));
                                table.setValorfreteterritorionacionalmoedanegociada(Float.parseFloat(edtValorfreteterritorionacionalmoedanegociada.getText().toString()));
                                table.setValortotalfretecollect(Float.parseFloat(edtValortotalfretecollect.getText().toString()));
                                table.setValortotalfretemoedanacional(Float.parseFloat(edtValortotalfretemoedanacional.getText().toString()));
                                table.setValortotalfreteprepaid(Float.parseFloat(edtValortotalfreteprepaid.getText().toString()));
                                table.setValortotalmlemoedanacional(Float.parseFloat(edtValortotalmlemoedanacional.getText().toString()));
                                table.setTerminalrecintoalfandegario(edtTerminalrecintoalfandegario.getText().toString());
                                table.setValortotalseguromoedanacional(Float.parseFloat(edtValortotalseguromoedanacional.getText().toString()));
                                table.setValortotalseguromoedanegociada(Float.parseFloat(edtValortotalseguromoedanegociada.getText().toString()));
                                table.setId(edtId.getText().toString());
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMdi.this);
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

    private List<String> getTipo_documento()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_tipo_documento");
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
    private List<String> getMotivotransmissao()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_motivotransmissao");
      driver.close();
      return lista;
    }
    private List<String> getModdespacho()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_moddespacho");
      driver.close();
      return lista;
    }
    private List<String> getOrigem_di()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_origem_di");
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
    private List<String> getRecintoalfandegado()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_recintoalfandegado");
      driver.close();
      return lista;
    }
    private List<String> getTipo_declaracao()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_tipo_declaracao");
      driver.close();
      return lista;
    }
    private List<String> getTipo_importador()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_tipo_importador");
      driver.close();
      return lista;
    }
    private List<String> getTipomanifesto()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_tipomanifesto");
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
    private List<String> getEmpresas()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_empresas");
      driver.close();
      return lista;
    }
    private List<String> getLocalidadeembarque()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_localidadeembarque");
      driver.close();
      return lista;
    }
    private List<String> getTransportador()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_transportador");
      driver.close();
      return lista;
    }
    private List<String> getVeiculos()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_veiculos");
      driver.close();
      return lista;
    }
    private List<String> getcodigoTipoAgenteCarga()
    {
      List<String> lista = new ArrayList<String>();
      lista.add("1-Pessoa Jurídica");
      lista.add("2-Pessoa Física");
      return lista;
    }
    private List<String> getcodigoTipoConsignatario()
    {
      List<String> lista = new ArrayList<String>();
      lista.add("1-Importação Própria");
      lista.add("2-Importação por Conta e Ordem");
      return lista;
    }
    private List<String> getcodigoTipoPagamentoTributario()
    {
      List<String> lista = new ArrayList<String>();
      lista.add("1-Débito em Conta");
      lista.add("2-DARF");
      return lista;
    }
    private List<String> getcodigoUtilizacaoDocumentoCarga()
    {
      List<String> lista = new ArrayList<String>();
      lista.add("1-Total");
      lista.add("2-Parcial");
      lista.add("3-Mais de um conhecimento");
      return lista;
    }
    private List<String> getindicadorMultimodalViaTransporte()
    {
      List<String> lista = new ArrayList<String>();
      lista.add("S-Houve Transporte Intermodal");
      lista.add("N-Não houve transporte Intermodal ou nas internações de ZFM e ALC");
      return lista;
    }

}
