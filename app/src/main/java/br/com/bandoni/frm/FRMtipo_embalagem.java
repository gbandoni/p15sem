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
import br.com.bandoni.dao.implementation.TipoEmbalagemDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexTipoEmbalagem;

import br.com.bandoni.siscomexhelper.R;

public class FRMtipo_embalagem extends AppCompatActivity 
{
    private J34SiscomexTipoEmbalagem table;
    private TipoEmbalagemDAOImpl dao;
    private int action;
    private TextView edtCodigo;
    private TextView edtDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tipo_embalagem);
        //campos do formulario;
        edtCodigo = (TextView)findViewById(R.id.edtCodigo);
        edtDescricao = (TextView)findViewById(R.id.edtDescricao);
        dao = new TipoEmbalagemDAOImpl(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            try
            {
              table = dao.find(it.getIntExtra("CODIGO",0));
            edtCodigo.setText(table.getCodigo().toString());
            edtDescricao.setText(table.getDescricao());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtCodigo.setEnabled(false);
                  edtDescricao.setEnabled(false);
                }
                else
                {
                  edtCodigo.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMtipo_embalagem.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexTipoEmbalagem();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_tipo_embalagem, menu);
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
                                table.setCodigo(Integer.parseInt(edtCodigo.getText().toString()));
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMtipo_embalagem.this);
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
