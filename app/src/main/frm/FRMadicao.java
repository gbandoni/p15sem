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
import br.com.bandoni.siscomexhelper.R;

public class FRMadicao extends AppCompatActivity 
{
    private J34SiscomexAdicao table = new J34SiscomexAdicao();
    private AdicaoDAOImpl dao = new AdicaoDAOImpl(this);
    private int action;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
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
            ((TextView) findViewById(R.id.edtCodigomoedanegociada)).setText(table.getCodigomoedanegociada());
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
