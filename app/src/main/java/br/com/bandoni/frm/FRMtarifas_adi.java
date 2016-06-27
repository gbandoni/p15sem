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
    private TextView edtNumerodocumentocarga;
    private TextView edtNumeroadicao;
    private TextView edtCodigoassuntovinculado;
    private TextView edtDataanoatovinculado;
    private TextView edtNumeroatovinculado;
    private TextView edtNumeroexatovinculado;
    private TextView edtSiglaorgaoatovinculado;
    private TextView edtSiglatipoatovinculado;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tarifas_adi);
        //campos do formulario;
        edtNumerodocumentocarga = (TextView)findViewById(R.id.edtNumerodocumentocarga);
        edtNumeroadicao = (TextView)findViewById(R.id.edtNumeroadicao);
        edtCodigoassuntovinculado = (TextView)findViewById(R.id.edtCodigoassuntovinculado);
        edtDataanoatovinculado = (TextView)findViewById(R.id.edtDataanoatovinculado);
        edtNumeroatovinculado = (TextView)findViewById(R.id.edtNumeroatovinculado);
        edtNumeroexatovinculado = (TextView)findViewById(R.id.edtNumeroexatovinculado);
        edtSiglaorgaoatovinculado = (TextView)findViewById(R.id.edtSiglaorgaoatovinculado);
        edtSiglatipoatovinculado = (TextView)findViewById(R.id.edtSiglatipoatovinculado);
        dao = new TarifasAdiDAOImpl(this);
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
            edtCodigoassuntovinculado.setText(table.getCodigoassuntovinculado());
            edtDataanoatovinculado.setText(table.getDataanoatovinculado());
            edtNumeroatovinculado.setText(table.getNumeroatovinculado());
            edtNumeroexatovinculado.setText(table.getNumeroexatovinculado());
            edtSiglaorgaoatovinculado.setText(table.getSiglaorgaoatovinculado());
            edtSiglatipoatovinculado.setText(table.getSiglatipoatovinculado());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtNumerodocumentocarga.setEnabled(false);
                  edtNumeroadicao.setEnabled(false);
                  edtCodigoassuntovinculado.setEnabled(false);
                  edtDataanoatovinculado.setEnabled(false);
                  edtNumeroatovinculado.setEnabled(false);
                  edtNumeroexatovinculado.setEnabled(false);
                  edtSiglaorgaoatovinculado.setEnabled(false);
                  edtSiglatipoatovinculado.setEnabled(false);
                }
                else
                {
                  edtNumerodocumentocarga.setEnabled(false);
                  edtNumeroadicao.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMtarifas_adi.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexTarifasAdi();
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
                                table.setNumerodocumentocarga(edtNumerodocumentocarga.getText().toString());
                                table.setNumeroadicao(edtNumeroadicao.getText().toString());
                                table.setCodigoassuntovinculado(edtCodigoassuntovinculado.getText().toString());
                                table.setDataanoatovinculado(edtDataanoatovinculado.getText().toString());
                                table.setNumeroatovinculado(edtNumeroatovinculado.getText().toString());
                                table.setNumeroexatovinculado(edtNumeroexatovinculado.getText().toString());
                                table.setSiglaorgaoatovinculado(edtSiglaorgaoatovinculado.getText().toString());
                                table.setSiglatipoatovinculado(edtSiglatipoatovinculado.getText().toString());
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
