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
import br.com.bandoni.dao.implementation.EstadoDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexEstado;

import br.com.bandoni.siscomexhelper.R;

public class FRMestado extends AppCompatActivity 
{
    private J34SiscomexEstado table;
    private EstadoDAOImpl dao;
    private int action;
    private TextView edtEstado_id;
    private TextView edtSigla;
    private TextView edtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_estado);
        //campos do formulario;
        edtEstado_id = (TextView)findViewById(R.id.edtEstado_id);
        edtSigla = (TextView)findViewById(R.id.edtSigla);
        edtNome = (TextView)findViewById(R.id.edtNome);
        dao = new EstadoDAOImpl(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            try
            {
              table = dao.find(it.getStringExtra("ESTADO_ID"));
            edtEstado_id.setText(table.getEstado_id());
            edtSigla.setText(table.getSigla());
            edtNome.setText(table.getNome());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtEstado_id.setEnabled(false);
                  edtSigla.setEnabled(false);
                  edtNome.setEnabled(false);
                }
                else
                {
                  edtEstado_id.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMestado.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexEstado();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_estado, menu);
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
                                table.setEstado_id(edtEstado_id.getText().toString());
                                table.setSigla(edtSigla.getText().toString());
                                table.setNome(edtNome.getText().toString());
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMestado.this);
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
