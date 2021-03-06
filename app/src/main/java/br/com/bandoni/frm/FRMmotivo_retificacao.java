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
import br.com.bandoni.dao.implementation.MotivoRetificacaoDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexMotivoRetificacao;

import br.com.bandoni.siscomexhelper.R;

public class FRMmotivo_retificacao extends AppCompatActivity 
{
    private J34SiscomexMotivoRetificacao table;
    private MotivoRetificacaoDAOImpl dao;
    private int action;
    private TextView edtCodigo_motivo;
    private TextView edtDescricao_motivo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_motivo_retificacao);
        //campos do formulario;
        edtCodigo_motivo = (TextView)findViewById(R.id.edtCodigo_motivo);
        edtDescricao_motivo = (TextView)findViewById(R.id.edtDescricao_motivo);
        dao = new MotivoRetificacaoDAOImpl(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            try
            {
              table = dao.find(it.getIntExtra("CODIGO_MOTIVO",0));
            edtCodigo_motivo.setText(table.getCodigo_motivo().toString());
            edtDescricao_motivo.setText(table.getDescricao_motivo());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtCodigo_motivo.setEnabled(false);
                  edtDescricao_motivo.setEnabled(false);
                }
                else
                {
                  edtCodigo_motivo.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMmotivo_retificacao.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexMotivoRetificacao();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_motivo_retificacao, menu);
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
                                table.setCodigo_motivo(Integer.parseInt(edtCodigo_motivo.getText().toString()));
                                table.setDescricao_motivo(edtDescricao_motivo.getText().toString());
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMmotivo_retificacao.this);
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
