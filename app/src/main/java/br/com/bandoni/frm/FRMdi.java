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

import br.com.bandoni.siscomexhelper.R;

public class FRMdi extends AppCompatActivity 
{
    private J34SiscomexDi table = new J34SiscomexDi();
    private DiDAOImpl dao = new DiDAOImpl(this);
    private int action;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
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
            ((TextView) findViewById(R.id.edtCodigomodalidadedespacho)).setText(table.getCodigomodalidadedespacho());
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
                AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext());
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

}
