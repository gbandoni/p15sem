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
import br.com.bandoni.dao.implementation.TipoDeclaracaoDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexTipoDeclaracao;

import br.com.bandoni.siscomexhelper.R;

public class FRMtipo_declaracao extends AppCompatActivity 
{
    private J34SiscomexTipoDeclaracao table;
    private TipoDeclaracaoDAOImpl dao;
    private int action;
    private TextView edtCodigo_tipo;
    private TextView edtTipo_declaracao;
    private TextView edtDescricao_tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tipo_declaracao);
        //campos do formulario;
        edtCodigo_tipo = (TextView)findViewById(R.id.edtCodigo_tipo);
        edtTipo_declaracao = (TextView)findViewById(R.id.edtTipo_declaracao);
        edtDescricao_tipo = (TextView)findViewById(R.id.edtDescricao_tipo);
        dao = new TipoDeclaracaoDAOImpl(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            try
            {
              table = dao.find(it.getIntExtra("CODIGO_TIPO",0));
            edtCodigo_tipo.setText(table.getCodigo_tipo().toString());
            edtTipo_declaracao.setText(table.getTipo_declaracao());
            edtDescricao_tipo.setText(table.getDescricao_tipo());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtCodigo_tipo.setEnabled(false);
                  edtTipo_declaracao.setEnabled(false);
                  edtDescricao_tipo.setEnabled(false);
                }
                else
                {
                  edtCodigo_tipo.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMtipo_declaracao.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexTipoDeclaracao();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_tipo_declaracao, menu);
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
                                table.setCodigo_tipo(Integer.parseInt(edtCodigo_tipo.getText().toString()));
                                table.setTipo_declaracao(edtTipo_declaracao.getText().toString());
                                table.setDescricao_tipo(edtDescricao_tipo.getText().toString());
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMtipo_declaracao.this);
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
