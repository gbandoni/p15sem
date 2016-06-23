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
import br.com.bandoni.dao.implementation.RecintoalfandegadoDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexRecintoalfandegado;

import br.com.bandoni.siscomexhelper.R;

public class FRMrecintoalfandegado extends AppCompatActivity 
{
    private J34SiscomexRecintoalfandegado table;
    private RecintoalfandegadoDAOImpl dao;
    private int action;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        table = new J34SiscomexRecintoalfandegado();
        dao = new RecintoalfandegadoDAOImpl(this);
        setContentView(R.layout.activity_detail_recintoalfandegado);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            table = dao.find(it.getStringExtra("CODIGO"),it.getStringExtra("TERMINAL"));
            ((TextView) findViewById(R.id.edtCodigo)).setText(table.getCodigo());
            ((TextView) findViewById(R.id.edtTerminal)).setText(table.getTerminal());
            ((TextView) findViewById(R.id.edtRegiao)).setText(table.getRegiao());
            ((TextView) findViewById(R.id.edtNomeporto)).setText(table.getNomeporto());
            ((TextView) findViewById(R.id.edtEstado)).setText(table.getEstado());
            ((TextView) findViewById(R.id.edtDescricao)).setText(table.getDescricao());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_recintoalfandegado, menu);
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
                                table.setCodigo(((TextView) findViewById(R.id.edtCodigo)).getText().toString());
                                table.setTerminal(((TextView) findViewById(R.id.edtTerminal)).getText().toString());
                                table.setRegiao(((TextView) findViewById(R.id.edtRegiao)).getText().toString());
                                table.setNomeporto(((TextView) findViewById(R.id.edtNomeporto)).getText().toString());
                                table.setEstado(((TextView) findViewById(R.id.edtEstado)).getText().toString());
                                table.setDescricao(((TextView) findViewById(R.id.edtDescricao)).getText().toString());
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMrecintoalfandegado.this);
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
