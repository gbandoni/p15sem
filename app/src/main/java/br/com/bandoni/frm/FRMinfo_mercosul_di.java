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
import br.com.bandoni.dao.implementation.InfoMercosulDiDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexInfoMercosulDi;

import br.com.bandoni.siscomexhelper.R;

public class FRMinfo_mercosul_di extends AppCompatActivity 
{
    private J34SiscomexInfoMercosulDi table;
    private InfoMercosulDiDAOImpl dao;
    private int action;
    private TextView edtNumerodocumentocarga;
    private TextView edtOrdem;
    private TextView edtNumerodemercosul;
    private TextView edtNumerorefinal;
    private TextView edtNumeroreinicial;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_info_mercosul_di);
        //campos do formulario;
        edtNumerodocumentocarga = (TextView)findViewById(R.id.edtNumerodocumentocarga);
        edtOrdem = (TextView)findViewById(R.id.edtOrdem);
        edtNumerodemercosul = (TextView)findViewById(R.id.edtNumerodemercosul);
        edtNumerorefinal = (TextView)findViewById(R.id.edtNumerorefinal);
        edtNumeroreinicial = (TextView)findViewById(R.id.edtNumeroreinicial);
        dao = new InfoMercosulDiDAOImpl(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            try
            {
              table = dao.find(it.getStringExtra("NUMERODOCUMENTOCARGA"),it.getIntExtra("ORDEM",0));
            edtNumerodocumentocarga.setText(table.getNumerodocumentocarga());
            edtOrdem.setText(table.getOrdem().toString());
            edtNumerodemercosul.setText(table.getNumerodemercosul());
            edtNumerorefinal.setText(table.getNumerorefinal());
            edtNumeroreinicial.setText(table.getNumeroreinicial());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtNumerodocumentocarga.setEnabled(false);
                  edtOrdem.setEnabled(false);
                  edtNumerodemercosul.setEnabled(false);
                  edtNumerorefinal.setEnabled(false);
                  edtNumeroreinicial.setEnabled(false);
                }
                else
                {
                  edtNumerodocumentocarga.setEnabled(false);
                  edtOrdem.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMinfo_mercosul_di.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexInfoMercosulDi();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_info_mercosul_di, menu);
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
                                table.setOrdem(Integer.parseInt(edtOrdem.getText().toString()));
                                table.setNumerodemercosul(edtNumerodemercosul.getText().toString());
                                table.setNumerorefinal(edtNumerorefinal.getText().toString());
                                table.setNumeroreinicial(edtNumeroreinicial.getText().toString());
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMinfo_mercosul_di.this);
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
