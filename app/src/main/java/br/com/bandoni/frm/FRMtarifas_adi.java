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
import br.com.bandoni.dao.implementation.TarifasAdiDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexTarifasAdi;

import br.com.bandoni.siscomexhelper.R;

public class FRMtarifas_adi extends AppCompatActivity 
{
    private J34SiscomexTarifasAdi table;
    private TarifasAdiDAOImpl dao;
    private int action;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        table = new J34SiscomexTarifasAdi();
        dao = new TarifasAdiDAOImpl(this);
        setContentView(R.layout.activity_detail_tarifas_adi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            table = dao.find(it.getStringExtra("NUMERODOCUMENTOCARGA"),it.getStringExtra("NUMEROADICAO"));
            ((TextView) findViewById(R.id.edtNumerodocumentocarga)).setText(table.getNumerodocumentocarga());
            ((TextView) findViewById(R.id.edtNumeroadicao)).setText(table.getNumeroadicao());
            ((TextView) findViewById(R.id.edtCodigoassuntovinculado)).setText(table.getCodigoassuntovinculado());
            ((TextView) findViewById(R.id.edtDataanoatovinculado)).setText(table.getDataanoatovinculado());
            ((TextView) findViewById(R.id.edtNumeroatovinculado)).setText(table.getNumeroatovinculado());
            ((TextView) findViewById(R.id.edtNumeroexatovinculado)).setText(table.getNumeroexatovinculado());
            ((TextView) findViewById(R.id.edtSiglaorgaoatovinculado)).setText(table.getSiglaorgaoatovinculado());
            ((TextView) findViewById(R.id.edtSiglatipoatovinculado)).setText(table.getSiglatipoatovinculado());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_tarifas_adi, menu);
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
                                table.setCodigoassuntovinculado(((TextView) findViewById(R.id.edtCodigoassuntovinculado)).getText().toString());
                                table.setDataanoatovinculado(((TextView) findViewById(R.id.edtDataanoatovinculado)).getText().toString());
                                table.setNumeroatovinculado(((TextView) findViewById(R.id.edtNumeroatovinculado)).getText().toString());
                                table.setNumeroexatovinculado(((TextView) findViewById(R.id.edtNumeroexatovinculado)).getText().toString());
                                table.setSiglaorgaoatovinculado(((TextView) findViewById(R.id.edtSiglaorgaoatovinculado)).getText().toString());
                                table.setSiglatipoatovinculado(((TextView) findViewById(R.id.edtSiglatipoatovinculado)).getText().toString());
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMtarifas_adi.this);
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
