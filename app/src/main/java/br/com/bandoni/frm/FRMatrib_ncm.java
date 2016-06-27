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
import br.com.bandoni.dao.implementation.AtribNcmDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexAtribNcm;

import br.com.bandoni.siscomexhelper.R;

public class FRMatrib_ncm extends AppCompatActivity 
{
    private J34SiscomexAtribNcm table;
    private AtribNcmDAOImpl dao;
    private int action;
    private TextView edtNcm;
    private TextView edtAtributoncm;
    private TextView edtMultiplo;
    private TextView edtNivel;
    private TextView edtAtributo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_atrib_ncm);
        //campos do formulario;
        edtNcm = (TextView)findViewById(R.id.edtNcm);
        edtAtributoncm = (TextView)findViewById(R.id.edtAtributoncm);
        edtMultiplo = (TextView)findViewById(R.id.edtMultiplo);
        edtNivel = (TextView)findViewById(R.id.edtNivel);
        edtAtributo = (TextView)findViewById(R.id.edtAtributo);
        dao = new AtribNcmDAOImpl(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            try
            {
              table = dao.find(it.getStringExtra("NCM"),it.getStringExtra("ATRIBUTONCM"));
            edtNcm.setText(table.getNcm());
            edtAtributoncm.setText(table.getAtributoncm());
            edtMultiplo.setText(table.getMultiplo());
            edtNivel.setText(table.getNivel());
            edtAtributo.setText(table.getAtributo());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtNcm.setEnabled(false);
                  edtAtributoncm.setEnabled(false);
                  edtMultiplo.setEnabled(false);
                  edtNivel.setEnabled(false);
                  edtAtributo.setEnabled(false);
                }
                else
                {
                  edtNcm.setEnabled(false);
                  edtAtributoncm.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMatrib_ncm.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexAtribNcm();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_atrib_ncm, menu);
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
                                table.setNcm(edtNcm.getText().toString());
                                table.setAtributoncm(edtAtributoncm.getText().toString());
                                table.setMultiplo(edtMultiplo.getText().toString());
                                table.setNivel(edtNivel.getText().toString());
                                table.setAtributo(edtAtributo.getText().toString());
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMatrib_ncm.this);
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
