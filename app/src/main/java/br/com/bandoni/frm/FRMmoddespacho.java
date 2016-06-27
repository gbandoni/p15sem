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
import br.com.bandoni.dao.implementation.ModdespachoDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexModdespacho;

import br.com.bandoni.siscomexhelper.R;

public class FRMmoddespacho extends AppCompatActivity 
{
    private J34SiscomexModdespacho table;
    private ModdespachoDAOImpl dao;
    private int action;
    private TextView edtCodigo_modalidade;
    private TextView edtNome_modalidade;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_moddespacho);
        //campos do formulario;
        edtCodigo_modalidade = (TextView)findViewById(R.id.edtCodigo_modalidade);
        edtNome_modalidade = (TextView)findViewById(R.id.edtNome_modalidade);
        dao = new ModdespachoDAOImpl(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            try
            {
              table = dao.find(it.getIntExtra("CODIGO_MODALIDADE",0));
            edtCodigo_modalidade.setText(table.getCodigo_modalidade().toString());
            edtNome_modalidade.setText(table.getNome_modalidade());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtCodigo_modalidade.setEnabled(false);
                  edtNome_modalidade.setEnabled(false);
                }
                else
                {
                  edtCodigo_modalidade.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMmoddespacho.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexModdespacho();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_moddespacho, menu);
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
                                table.setCodigo_modalidade(Integer.parseInt(edtCodigo_modalidade.getText().toString()));
                                table.setNome_modalidade(edtNome_modalidade.getText().toString());
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMmoddespacho.this);
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
