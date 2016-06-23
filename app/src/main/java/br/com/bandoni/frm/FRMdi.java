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
import java.util.List;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import br.com.bandoni.siscomexhelper.R;

public class FRMdi extends AppCompatActivity 
{
    private J34SiscomexDi table;
    private DiDAOImpl dao;
    private int action;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
         List<String> lstTipo_documento = getTipo_documento();
         ArrayAdapter<String> adpcodigoTipoDocumentoCarga = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstTipo_documento);
         AutoCompleteTextView edtcodigoTipoDocumentoCarga = (AutoCompleteTextView)findViewById(R.id.edtCodigotipodocumentocarga);
        edtcodigoTipoDocumentoCarga.setAdapter(adpcodigoTipoDocumentoCarga);
         List<String> lstMoedas = getMoedas();
         ArrayAdapter<String> adpcodigoMoedaSeguro = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstMoedas);
         AutoCompleteTextView edtcodigoMoedaSeguro = (AutoCompleteTextView)findViewById(R.id.edtCodigomoedaseguro);
        edtcodigoMoedaSeguro.setAdapter(adpcodigoMoedaSeguro);
         ArrayAdapter<String> adpcodigoMoedaFrete = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstMoedas);
         AutoCompleteTextView edtcodigoMoedaFrete = (AutoCompleteTextView)findViewById(R.id.edtCodigomoedafrete);
        edtcodigoMoedaFrete.setAdapter(adpcodigoMoedaFrete);
         List<String> lstMotivotransmissao = getMotivotransmissao();
         ArrayAdapter<String> adpcodigoMotivoTransmissao = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstMotivotransmissao);
         AutoCompleteTextView edtcodigoMotivoTransmissao = (AutoCompleteTextView)findViewById(R.id.edtCodigomotivotransmissao);
        edtcodigoMotivoTransmissao.setAdapter(adpcodigoMotivoTransmissao);
         List<String> lstModdespacho = getModdespacho();
         ArrayAdapter<String> adpcodigoModalidadeDespacho = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstModdespacho);
         AutoCompleteTextView edtcodigoModalidadeDespacho = (AutoCompleteTextView)findViewById(R.id.edtCodigomodalidadedespacho);
        edtcodigoModalidadeDespacho.setAdapter(adpcodigoModalidadeDespacho);
         List<String> lstOrigem_di = getOrigem_di();
         ArrayAdapter<String> adpcodigoOrigemDI = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstOrigem_di);
         AutoCompleteTextView edtcodigoOrigemDI = (AutoCompleteTextView)findViewById(R.id.edtCodigoorigemdi);
        edtcodigoOrigemDI.setAdapter(adpcodigoOrigemDI);
         List<String> lstPaises = getPaises();
         ArrayAdapter<String> adpcodigoPaisProcedenciaCarga = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstPaises);
         AutoCompleteTextView edtcodigoPaisProcedenciaCarga = (AutoCompleteTextView)findViewById(R.id.edtCodigopaisprocedenciacarga);
        edtcodigoPaisProcedenciaCarga.setAdapter(adpcodigoPaisProcedenciaCarga);
         ArrayAdapter<String> adpcodigoPaisImportador = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstPaises);
         AutoCompleteTextView edtcodigoPaisImportador = (AutoCompleteTextView)findViewById(R.id.edtCodigopaisimportador);
        edtcodigoPaisImportador.setAdapter(adpcodigoPaisImportador);
         List<String> lstRecintoalfandegado = getRecintoalfandegado();
         ArrayAdapter<String> adpcodigoRecintoAlfandegado = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstRecintoalfandegado);
         AutoCompleteTextView edtcodigoRecintoAlfandegado = (AutoCompleteTextView)findViewById(R.id.edtCodigorecintoalfandegado);
        edtcodigoRecintoAlfandegado.setAdapter(adpcodigoRecintoAlfandegado);
         List<String> lstTipo_declaracao = getTipo_declaracao();
         ArrayAdapter<String> adpcodigoTipoDeclaracao = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstTipo_declaracao);
         AutoCompleteTextView edtcodigoTipoDeclaracao = (AutoCompleteTextView)findViewById(R.id.edtCodigotipodeclaracao);
        edtcodigoTipoDeclaracao.setAdapter(adpcodigoTipoDeclaracao);
         List<String> lstTipo_importador = getTipo_importador();
         ArrayAdapter<String> adpcodigoTipoImportador = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstTipo_importador);
         AutoCompleteTextView edtcodigoTipoImportador = (AutoCompleteTextView)findViewById(R.id.edtCodigotipoimportador);
        edtcodigoTipoImportador.setAdapter(adpcodigoTipoImportador);
         List<String> lstTipomanifesto = getTipomanifesto();
         ArrayAdapter<String> adpcodigoTipoManifesto = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstTipomanifesto);
         AutoCompleteTextView edtcodigoTipoManifesto = (AutoCompleteTextView)findViewById(R.id.edtCodigotipomanifesto);
        edtcodigoTipoManifesto.setAdapter(adpcodigoTipoManifesto);
         List<String> lstOrgaosurf = getOrgaosurf();
         ArrayAdapter<String> adpcodigoUrfCargaEntrada = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstOrgaosurf);
         AutoCompleteTextView edtcodigoUrfCargaEntrada = (AutoCompleteTextView)findViewById(R.id.edtCodigourfcargaentrada);
        edtcodigoUrfCargaEntrada.setAdapter(adpcodigoUrfCargaEntrada);
         ArrayAdapter<String> adpcodigoUrfDespacho = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstOrgaosurf);
         AutoCompleteTextView edtcodigoUrfDespacho = (AutoCompleteTextView)findViewById(R.id.edtCodigourfdespacho);
        edtcodigoUrfDespacho.setAdapter(adpcodigoUrfDespacho);
         List<String> lstViatransporte = getViatransporte();
         ArrayAdapter<String> adpcodigoViaTransporte = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstViatransporte);
         AutoCompleteTextView edtcodigoViaTransporte = (AutoCompleteTextView)findViewById(R.id.edtCodigoviatransporte);
        edtcodigoViaTransporte.setAdapter(adpcodigoViaTransporte);
         List<String> lstEmpresas = getEmpresas();
         ArrayAdapter<String> adpcodigoimportador = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstEmpresas);
         AutoCompleteTextView edtcodigoimportador = (AutoCompleteTextView)findViewById(R.id.edtCodigoimportador);
        edtcodigoimportador.setAdapter(adpcodigoimportador);
         ArrayAdapter<String> adpcodigoconsignatorio = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstEmpresas);
         AutoCompleteTextView edtcodigoconsignatorio = (AutoCompleteTextView)findViewById(R.id.edtCodigoconsignatorio);
        edtcodigoconsignatorio.setAdapter(adpcodigoconsignatorio);
         List<String> lstLocalidadeembarque = getLocalidadeembarque();
         ArrayAdapter<String> adpcodigolocalembarque = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstLocalidadeembarque);
         AutoCompleteTextView edtcodigolocalembarque = (AutoCompleteTextView)findViewById(R.id.edtCodigolocalembarque);
        edtcodigolocalembarque.setAdapter(adpcodigolocalembarque);
         List<String> lstTransportador = getTransportador();
         ArrayAdapter<String> adpcodigotransportador = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstTransportador);
         AutoCompleteTextView edtcodigotransportador = (AutoCompleteTextView)findViewById(R.id.edtCodigotransportador);
        edtcodigotransportador.setAdapter(adpcodigotransportador);
         List<String> lstVeiculos = getVeiculos();
         ArrayAdapter<String> adpcodigoveiculo = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstVeiculos);
         AutoCompleteTextView edtcodigoveiculo = (AutoCompleteTextView)findViewById(R.id.edtCodigoveiculo);
        edtcodigoveiculo.setAdapter(adpcodigoveiculo);
         ArrayAdapter<String> adpterminalrecintoalfandegario = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstRecintoalfandegado);
         AutoCompleteTextView edtterminalrecintoalfandegario = (AutoCompleteTextView)findViewById(R.id.edtTerminalrecintoalfandegario);
        edtterminalrecintoalfandegario.setAdapter(adpterminalrecintoalfandegario);
        table = new J34SiscomexDi();
        dao = new DiDAOImpl(this);
        setContentView(R.layout.activity_detail_di);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            table = dao.find(it.getStringExtra("NUMERODOCUMENTOCARGA"));
            ((TextView) findViewById(R.id.edtNumerodocumentocarga)).setText(table.getNumerodocumentocarga());
            ((TextView) findViewById(R.id.edtCodigotipodocumentocarga)).setText(table.getCodigotipodocumentocarga());
            ((TextView) findViewById(R.id.edtCodigomoedaseguro)).setText(table.getCodigomoedaseguro().toString());
            ((TextView) findViewById(R.id.edtCodigomoedafrete)).setText(table.getCodigomoedafrete().toString());
            ((TextView) findViewById(R.id.edtCodigomotivotransmissao)).setText(table.getCodigomotivotransmissao().toString());
            ((TextView) findViewById(R.id.edtCargapesobruto)).setText(table.getCargapesobruto().toString());
            ((TextView) findViewById(R.id.edtCargapesoliquido)).setText(table.getCargapesoliquido().toString());
            ((TextView) findViewById(R.id.edtCodigobandeiratranspote)).setText(table.getCodigobandeiratranspote());
            ((TextView) findViewById(R.id.edtCodigomodalidadedespacho)).setText(table.getCodigomodalidadedespacho().toString());
            ((TextView) findViewById(R.id.edtCodigoorigemdi)).setText(table.getCodigoorigemdi());
            ((TextView) findViewById(R.id.edtCodigopaisprocedenciacarga)).setText(table.getCodigopaisprocedenciacarga());
            ((TextView) findViewById(R.id.edtCodigopaisimportador)).setText(table.getCodigopaisimportador());
            ((TextView) findViewById(R.id.edtCodigorecintoalfandegado)).setText(table.getCodigorecintoalfandegado());
            ((TextView) findViewById(R.id.edtCodigosetorarmazenamento)).setText(table.getCodigosetorarmazenamento());
            ((TextView) findViewById(R.id.edtCodigotipoagentecarga)).setText(table.getCodigotipoagentecarga());
            ((TextView) findViewById(R.id.edtCodigotipoconsignatario)).setText(table.getCodigotipoconsignatario());
            ((TextView) findViewById(R.id.edtCodigotipodeclaracao)).setText(table.getCodigotipodeclaracao().toString());
            ((TextView) findViewById(R.id.edtCodigotipoimportador)).setText(table.getCodigotipoimportador().toString());
            ((TextView) findViewById(R.id.edtCodigotipomanifesto)).setText(table.getCodigotipomanifesto().toString());
            ((TextView) findViewById(R.id.edtCodigotipopagamentotributario)).setText(table.getCodigotipopagamentotributario());
            ((TextView) findViewById(R.id.edtCodigourfcargaentrada)).setText(table.getCodigourfcargaentrada());
            ((TextView) findViewById(R.id.edtCodigourfdespacho)).setText(table.getCodigourfdespacho());
            ((TextView) findViewById(R.id.edtCodigoutilizacaodocumentocarga)).setText(table.getCodigoutilizacaodocumentocarga());
            ((TextView) findViewById(R.id.edtCodigoviatransporte)).setText(table.getCodigoviatransporte());
            ((TextView) findViewById(R.id.edtDatachegadacarga)).setText(table.getDatachegadacarga().toString());
            ((TextView) findViewById(R.id.edtDataembarque)).setText(table.getDataembarque().toString());
            ((TextView) findViewById(R.id.edtIdentificacaodeclaracaoimportacao)).setText(table.getIdentificacaodeclaracaoimportacao());
            ((TextView) findViewById(R.id.edtCodigoimportador)).setText(table.getCodigoimportador().toString());
            ((TextView) findViewById(R.id.edtIndicadormultimodalviatransporte)).setText(table.getIndicadormultimodalviatransporte());
            ((TextView) findViewById(R.id.edtIndicadoroperacaofundap)).setText(table.getIndicadoroperacaofundap());
            ((TextView) findViewById(R.id.edtInformacoescomplementares)).setText(table.getInformacoescomplementares().toString());
            ((TextView) findViewById(R.id.edtCodigoconsignatorio)).setText(table.getCodigoconsignatorio().toString());
            ((TextView) findViewById(R.id.edtCodigolocalembarque)).setText(table.getCodigolocalembarque());
            ((TextView) findViewById(R.id.edtNomelocalembarque)).setText(table.getNomelocalembarque().toString());
            ((TextView) findViewById(R.id.edtCodigotransportador)).setText(table.getCodigotransportador().toString());
            ((TextView) findViewById(R.id.edtCodigoveiculo)).setText(table.getCodigoveiculo().toString());
            ((TextView) findViewById(R.id.edtNumeroagentecarga)).setText(table.getNumeroagentecarga());
            ((TextView) findViewById(R.id.edtNumeroconsignatario)).setText(table.getNumeroconsignatario());
            ((TextView) findViewById(R.id.edtNumerocontapagamentotributario)).setText(table.getNumerocontapagamentotributario());
            ((TextView) findViewById(R.id.edtNumerocpfrepresentantelegal)).setText(table.getNumerocpfrepresentantelegal());
            ((TextView) findViewById(R.id.edtNumerodocumentocargamaster)).setText(table.getNumerodocumentocargamaster());
            ((TextView) findViewById(R.id.edtNumeroimportador)).setText(table.getNumeroimportador());
            ((TextView) findViewById(R.id.edtNumeromanifesto)).setText(table.getNumeromanifesto());
            ((TextView) findViewById(R.id.edtTotaladicoes)).setText(table.getTotaladicoes().toString());
            ((TextView) findViewById(R.id.edtValorfreteterritorionacionalmoedanegociada)).setText(table.getValorfreteterritorionacionalmoedanegociada().toString());
            ((TextView) findViewById(R.id.edtValortotalfretecollect)).setText(table.getValortotalfretecollect().toString());
            ((TextView) findViewById(R.id.edtValortotalfretemoedanacional)).setText(table.getValortotalfretemoedanacional().toString());
            ((TextView) findViewById(R.id.edtValortotalfreteprepaid)).setText(table.getValortotalfreteprepaid().toString());
            ((TextView) findViewById(R.id.edtValortotalmlemoedanacional)).setText(table.getValortotalmlemoedanacional().toString());
            ((TextView) findViewById(R.id.edtTerminalrecintoalfandegario)).setText(table.getTerminalrecintoalfandegario());
            ((TextView) findViewById(R.id.edtValortotalseguromoedanacional)).setText(table.getValortotalseguromoedanacional().toString());
            ((TextView) findViewById(R.id.edtValortotalseguromoedanegociada)).setText(table.getValortotalseguromoedanegociada().toString());
            ((TextView) findViewById(R.id.edtId)).setText(table.getId());
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
                                table.setNumerodocumentocarga(((TextView) findViewById(R.id.edtNumerodocumentocarga)).getText().toString());
                                table.setCodigotipodocumentocarga(((AutoCompleteTextView) findViewById(R.id.edtCodigotipodocumentocarga)).getText().toString());
                                table.setCodigomoedaseguro(Integer.parseInt(((AutoCompleteTextView) findViewById(R.id.edtCodigomoedaseguro)).getText().toString()));
                                table.setCodigomoedafrete(Integer.parseInt(((AutoCompleteTextView) findViewById(R.id.edtCodigomoedafrete)).getText().toString()));
                                table.setCodigomotivotransmissao(Integer.parseInt(((AutoCompleteTextView) findViewById(R.id.edtCodigomotivotransmissao)).getText().toString()));
                                table.setCargapesobruto(Float.parseFloat(((TextView) findViewById(R.id.edtCargapesobruto)).getText().toString()));
                                table.setCargapesoliquido(Float.parseFloat(((TextView) findViewById(R.id.edtCargapesoliquido)).getText().toString()));
                                table.setCodigobandeiratranspote(((TextView) findViewById(R.id.edtCodigobandeiratranspote)).getText().toString());
                                table.setCodigomodalidadedespacho(Integer.parseInt(((AutoCompleteTextView) findViewById(R.id.edtCodigomodalidadedespacho)).getText().toString()));
                                table.setCodigoorigemdi(((AutoCompleteTextView) findViewById(R.id.edtCodigoorigemdi)).getText().toString());
                                table.setCodigopaisprocedenciacarga(((AutoCompleteTextView) findViewById(R.id.edtCodigopaisprocedenciacarga)).getText().toString());
                                table.setCodigopaisimportador(((AutoCompleteTextView) findViewById(R.id.edtCodigopaisimportador)).getText().toString());
                                table.setCodigorecintoalfandegado(((AutoCompleteTextView) findViewById(R.id.edtCodigorecintoalfandegado)).getText().toString());
                                table.setCodigosetorarmazenamento(((TextView) findViewById(R.id.edtCodigosetorarmazenamento)).getText().toString());
                                table.setCodigotipoagentecarga(((TextView) findViewById(R.id.edtCodigotipoagentecarga)).getText().toString());
                                table.setCodigotipoconsignatario(((TextView) findViewById(R.id.edtCodigotipoconsignatario)).getText().toString());
                                table.setCodigotipodeclaracao(Integer.parseInt(((AutoCompleteTextView) findViewById(R.id.edtCodigotipodeclaracao)).getText().toString()));
                                table.setCodigotipoimportador(Integer.parseInt(((AutoCompleteTextView) findViewById(R.id.edtCodigotipoimportador)).getText().toString()));
                                table.setCodigotipomanifesto(Integer.parseInt(((AutoCompleteTextView) findViewById(R.id.edtCodigotipomanifesto)).getText().toString()));
                                table.setCodigotipopagamentotributario(((TextView) findViewById(R.id.edtCodigotipopagamentotributario)).getText().toString());
                                table.setCodigourfcargaentrada(((AutoCompleteTextView) findViewById(R.id.edtCodigourfcargaentrada)).getText().toString());
                                table.setCodigourfdespacho(((AutoCompleteTextView) findViewById(R.id.edtCodigourfdespacho)).getText().toString());
                                table.setCodigoutilizacaodocumentocarga(((TextView) findViewById(R.id.edtCodigoutilizacaodocumentocarga)).getText().toString());
                                table.setCodigoviatransporte(((AutoCompleteTextView) findViewById(R.id.edtCodigoviatransporte)).getText().toString());
                                table.setDatachegadacarga( ((TextView) findViewById(R.id.edtDatachegadacarga)).getText().toString());
                                table.setDataembarque( ((TextView) findViewById(R.id.edtDataembarque)).getText().toString());
                                table.setIdentificacaodeclaracaoimportacao(((TextView) findViewById(R.id.edtIdentificacaodeclaracaoimportacao)).getText().toString());
                                table.setCodigoimportador(Integer.parseInt(((AutoCompleteTextView) findViewById(R.id.edtCodigoimportador)).getText().toString()));
                                table.setIndicadormultimodalviatransporte(((TextView) findViewById(R.id.edtIndicadormultimodalviatransporte)).getText().toString());
                                table.setIndicadoroperacaofundap(((TextView) findViewById(R.id.edtIndicadoroperacaofundap)).getText().toString());
                                table.setInformacoescomplementares(((TextView) findViewById(R.id.edtInformacoescomplementares)).getText().toString());
                                table.setCodigoconsignatorio(Integer.parseInt(((AutoCompleteTextView) findViewById(R.id.edtCodigoconsignatorio)).getText().toString()));
                                table.setCodigolocalembarque(((AutoCompleteTextView) findViewById(R.id.edtCodigolocalembarque)).getText().toString());
                                table.setNomelocalembarque(Integer.parseInt(((TextView) findViewById(R.id.edtNomelocalembarque)).getText().toString()));
                                table.setCodigotransportador(Integer.parseInt(((AutoCompleteTextView) findViewById(R.id.edtCodigotransportador)).getText().toString()));
                                table.setCodigoveiculo(Integer.parseInt(((AutoCompleteTextView) findViewById(R.id.edtCodigoveiculo)).getText().toString()));
                                table.setNumeroagentecarga(((TextView) findViewById(R.id.edtNumeroagentecarga)).getText().toString());
                                table.setNumeroconsignatario(((TextView) findViewById(R.id.edtNumeroconsignatario)).getText().toString());
                                table.setNumerocontapagamentotributario(((TextView) findViewById(R.id.edtNumerocontapagamentotributario)).getText().toString());
                                table.setNumerocpfrepresentantelegal(((TextView) findViewById(R.id.edtNumerocpfrepresentantelegal)).getText().toString());
                                table.setNumerodocumentocargamaster(((TextView) findViewById(R.id.edtNumerodocumentocargamaster)).getText().toString());
                                table.setNumeroimportador(((TextView) findViewById(R.id.edtNumeroimportador)).getText().toString());
                                table.setNumeromanifesto(((TextView) findViewById(R.id.edtNumeromanifesto)).getText().toString());
                                table.setTotaladicoes(Float.parseFloat(((TextView) findViewById(R.id.edtTotaladicoes)).getText().toString()));
                                table.setValorfreteterritorionacionalmoedanegociada(Float.parseFloat(((TextView) findViewById(R.id.edtValorfreteterritorionacionalmoedanegociada)).getText().toString()));
                                table.setValortotalfretecollect(Float.parseFloat(((TextView) findViewById(R.id.edtValortotalfretecollect)).getText().toString()));
                                table.setValortotalfretemoedanacional(Float.parseFloat(((TextView) findViewById(R.id.edtValortotalfretemoedanacional)).getText().toString()));
                                table.setValortotalfreteprepaid(Float.parseFloat(((TextView) findViewById(R.id.edtValortotalfreteprepaid)).getText().toString()));
                                table.setValortotalmlemoedanacional(Float.parseFloat(((TextView) findViewById(R.id.edtValortotalmlemoedanacional)).getText().toString()));
                                table.setTerminalrecintoalfandegario(((AutoCompleteTextView) findViewById(R.id.edtTerminalrecintoalfandegario)).getText().toString());
                                table.setValortotalseguromoedanacional(Float.parseFloat(((TextView) findViewById(R.id.edtValortotalseguromoedanacional)).getText().toString()));
                                table.setValortotalseguromoedanegociada(Float.parseFloat(((TextView) findViewById(R.id.edtValortotalseguromoedanegociada)).getText().toString()));
                                table.setId(((TextView) findViewById(R.id.edtId)).getText().toString());
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

}
