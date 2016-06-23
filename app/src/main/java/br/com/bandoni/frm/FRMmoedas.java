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
import br.com.bandoni.dao.implementation.MoedasDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexMoedas;

import br.com.bandoni.siscomexhelper.R;

public class FRMmoedas extends AppCompatActivity 
{
    private J34SiscomexMoedas table;
    private MoedasDAOImpl dao;
    private int action;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        table = new J34SiscomexMoedas();
        dao = new MoedasDAOImpl(this);
        setContentView(R.layout.activity_detail_moedas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            table = dao.find(it.getIntExtra("IDMOEDA",0));
            ((TextView) findViewById(R.id.edtIdmoeda)).setText(table.getIdmoeda().toString());
            ((TextView) findViewById(R.id.edtPais)).setText(table.getPais());
            ((TextView) findViewById(R.id.edtCodigo)).setText(table.getCodigo().toString());
            ((TextView) findViewById(R.id.edtDataexclusao)).setText(table.getDataexclusao().toString());
            ((TextView) findViewById(R.id.edtNome)).setText(table.getNome());
            ((TextView) findViewById(R.id.edtSimbolo)).setText(table.getSimbolo());
            ((TextView) findViewById(R.id.edtTipo)).setText(table.getTipo());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_moedas, menu);
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
                                table.setIdmoeda(Integer.parseInt(((TextView) findViewById(R.id.edtIdmoeda)).getText().toString()));
                                table.setPais(((TextView) findViewById(R.id.edtPais)).getText().toString());
                                table.setCodigo(Integer.parseInt(((TextView) findViewById(R.id.edtCodigo)).getText().toString()));
                                table.setDataexclusao( ((TextView) findViewById(R.id.edtDataexclusao)).getText().toString());
                                table.setNome(((TextView) findViewById(R.id.edtNome)).getText().toString());
                                table.setSimbolo(((TextView) findViewById(R.id.edtSimbolo)).getText().toString());
                                table.setTipo(((TextView) findViewById(R.id.edtTipo)).getText().toString());
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMmoedas.this);
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
