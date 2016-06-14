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
import br.com.bandoni.dao.implementation.VeiculosDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexVeiculos;

import br.com.bandoni.siscomexhelper.R;

public class FRMveiculos extends AppCompatActivity 
{
    private J34SiscomexVeiculos table;
    private VeiculosDAOImpl dao;
    private int action;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        table = new J34SiscomexVeiculos();
        dao = new VeiculosDAOImpl(this);
        setContentView(R.layout.activity_detail_veiculos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            table = dao.find(it.getIntExtra("ID",0));
            ((TextView) findViewById(R.id.edtId)).setText(table.getId().toString());
            ((TextView) findViewById(R.id.edtCodtransportador)).setText(table.getCodtransportador().toString());
            ((TextView) findViewById(R.id.edtNumeroveiculo)).setText(table.getNumeroveiculo());
            ((TextView) findViewById(R.id.edtNomeveiculo)).setText(table.getNomeveiculo());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_veiculos, menu);
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
                                table.setId(Integer.parseInt(((TextView) findViewById(R.id.edtId)).getText().toString()));
                                table.setCodtransportador(Integer.parseInt(((TextView) findViewById(R.id.edtCodtransportador)).getText().toString()));
                                table.setNumeroveiculo(((TextView) findViewById(R.id.edtNumeroveiculo)).getText().toString());
                                table.setNomeveiculo(((TextView) findViewById(R.id.edtNomeveiculo)).getText().toString());
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
