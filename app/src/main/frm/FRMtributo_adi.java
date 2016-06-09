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
import br.com.bandoni.dao.implementation.TributoAdiDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexTributoAdi;
import br.com.bandoni.siscomexhelper.R;

public class FRMtributo_adi extends AppCompatActivity 
{
    private J34SiscomexTributoAdi table = new J34SiscomexTributoAdi();
    private TributoAdiDAOImpl dao = new TributoAdiDAOImpl(this);
    private int action;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tributo_adi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            table = dao.find(it.getStringExtra("NUMERODOCUMENTOCARGA"),it.getStringExtra("NUMEROADICAO"));
            ((TextView) findViewById(R.id.edtNumerodocumentocarga)).setText(table.getNumerodocumentocarga());
            ((TextView) findViewById(R.id.edtNumeroadicao)).setText(table.getNumeroadicao());
            ((TextView) findViewById(R.id.edtCodigoreceitaimposto)).setText(table.getCodigoreceitaimposto());
            ((TextView) findViewById(R.id.edtCodigotipoaliquotaipt)).setText(table.getCodigotipoaliquotaipt());
            ((TextView) findViewById(R.id.edtCodigotipobeneficioipi)).setText(table.getCodigotipobeneficioipi());
            ((TextView) findViewById(R.id.edtCodigotipodireito)).setText(table.getCodigotipodireito());
            ((TextView) findViewById(R.id.edtCodigotiporecipiente)).setText(table.getCodigotiporecipiente());
            ((TextView) findViewById(R.id.edtNomeunidadeespecificaaliquotaipt)).setText(table.getNomeunidadeespecificaaliquotaipt());
            ((TextView) findViewById(R.id.edtNumeronotacomplementartipi)).setText(table.getNumeronotacomplementartipi().toString());
            ((TextView) findViewById(R.id.edtPercentualaliquotaacordotarifario)).setText(table.getPercentualaliquotaacordotarifario().toString());
            ((TextView) findViewById(R.id.edtPercentualaliquotanormaladval)).setText(table.getPercentualaliquotanormaladval().toString());
            ((TextView) findViewById(R.id.edtPercentualaliquotareduzida)).setText(table.getPercentualaliquotareduzida().toString());
            ((TextView) findViewById(R.id.edtPercentualreducaoipt)).setText(table.getPercentualreducaoipt().toString());
            ((TextView) findViewById(R.id.edtQuantidademlrecipiente)).setText(table.getQuantidademlrecipiente().toString());
            ((TextView) findViewById(R.id.edtQuantidademercadoriaunidadealiquotaespecifica)).setText(table.getQuantidademercadoriaunidadealiquotaespecifica().toString());
            ((TextView) findViewById(R.id.edtValoraliquotaespecificaipt)).setText(table.getValoraliquotaespecificaipt().toString());
            ((TextView) findViewById(R.id.edtValorbasecalculoadval)).setText(table.getValorbasecalculoadval().toString());
            ((TextView) findViewById(R.id.edtValorcalculadoiiactarifario)).setText(table.getValorcalculadoiiactarifario().toString());
            ((TextView) findViewById(R.id.edtValorcalculoiptespecifica)).setText(table.getValorcalculoiptespecifica().toString());
            ((TextView) findViewById(R.id.edtValorcalculoiptadval)).setText(table.getValorcalculoiptadval().toString());
            ((TextView) findViewById(R.id.edtValoriptarecolher)).setText(table.getValoriptarecolher().toString());
            ((TextView) findViewById(R.id.edtValorimpostodevido)).setText(table.getValorimpostodevido().toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_tributo_adi, menu);
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
