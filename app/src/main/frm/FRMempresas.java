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
import br.com.bandoni.dao.implementation.EmpresasDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexEmpresas;
import br.com.bandoni.siscomexhelper.R;

public class FRMempresas extends AppCompatActivity 
{
    private J34SiscomexEmpresas table = new J34SiscomexEmpresas();
    private EmpresasDAOImpl dao = new EmpresasDAOImpl(this);
    private int action;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_empresas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            table = dao.find(it.getIntExtra("CODIGO",0));
            ((TextView) findViewById(R.id.edtCodigo)).setText(table.getCodigo().toString());
            ((TextView) findViewById(R.id.edtTipopesssoa)).setText(table.getTipopesssoa());
            ((TextView) findViewById(R.id.edtRazaosocial)).setText(table.getRazaosocial());
            ((TextView) findViewById(R.id.edtTelefone)).setText(table.getTelefone());
            ((TextView) findViewById(R.id.edtEndereco)).setText(table.getEndereco());
            ((TextView) findViewById(R.id.edtNumero)).setText(table.getNumero());
            ((TextView) findViewById(R.id.edtComplemento)).setText(table.getComplemento());
            ((TextView) findViewById(R.id.edtBairro)).setText(table.getBairro());
            ((TextView) findViewById(R.id.edtMunicipio)).setText(table.getMunicipio());
            ((TextView) findViewById(R.id.edtEstado)).setText(table.getEstado());
            ((TextView) findViewById(R.id.edtCep)).setText(table.getCep());
            ((TextView) findViewById(R.id.edtPais)).setText(table.getPais());
            ((TextView) findViewById(R.id.edtEmail)).setText(table.getEmail());
            ((TextView) findViewById(R.id.edtMunicipioex)).setText(table.getMunicipioex());
            ((TextView) findViewById(R.id.edtEstadoex)).setText(table.getEstadoex());
            ((TextView) findViewById(R.id.edtCnpj)).setText(table.getCnpj());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_empresas, menu);
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
