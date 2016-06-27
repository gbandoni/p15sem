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
import br.com.bandoni.dao.implementation.EspecNcmDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexEspecNcm;

import br.com.bandoni.siscomexhelper.R;

public class FRMespec_ncm extends AppCompatActivity 
{
    private J34SiscomexEspecNcm table;
    private EspecNcmDAOImpl dao;
    private int action;
    private TextView edtId;
    private TextView edtNcm;
    private TextView edtAtributo;
    private TextView edtEspecificacao;
    private TextView edtNivel;
    private TextView edtDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_espec_ncm);
        //campos do formulario;
        edtId = (TextView)findViewById(R.id.edtId);
        edtNcm = (TextView)findViewById(R.id.edtNcm);
        edtAtributo = (TextView)findViewById(R.id.edtAtributo);
        edtEspecificacao = (TextView)findViewById(R.id.edtEspecificacao);
        edtNivel = (TextView)findViewById(R.id.edtNivel);
        edtDescricao = (TextView)findViewById(R.id.edtDescricao);
        dao = new EspecNcmDAOImpl(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            try
            {
              table = dao.find(it.getIntExtra("ID",0));
            edtId.setText(table.getId().toString());
            edtNcm.setText(table.getNcm());
            edtAtributo.setText(table.getAtributo());
            edtEspecificacao.setText(table.getEspecificacao());
            edtNivel.setText(table.getNivel());
            edtDescricao.setText(table.getDescricao());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtId.setEnabled(false);
                  edtNcm.setEnabled(false);
                  edtAtributo.setEnabled(false);
                  edtEspecificacao.setEnabled(false);
                  edtNivel.setEnabled(false);
                  edtDescricao.setEnabled(false);
                }
                else
                {
                  edtId.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMespec_ncm.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexEspecNcm();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_espec_ncm, menu);
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
                                table.setId(Integer.parseInt(edtId.getText().toString()));
                                table.setNcm(edtNcm.getText().toString());
                                table.setAtributo(edtAtributo.getText().toString());
                                table.setEspecificacao(edtEspecificacao.getText().toString());
                                table.setNivel(edtNivel.getText().toString());
                                table.setDescricao(edtDescricao.getText().toString());
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMespec_ncm.this);
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
