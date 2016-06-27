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
    private TextView edtCodigo;
    private TextView edtTerminal;
    private TextView edtRegiao;
    private TextView edtNomeporto;
    private TextView edtEstado;
    private TextView edtDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_recintoalfandegado);
        //campos do formulario;
        edtCodigo = (TextView)findViewById(R.id.edtCodigo);
        edtTerminal = (TextView)findViewById(R.id.edtTerminal);
        edtRegiao = (TextView)findViewById(R.id.edtRegiao);
        edtNomeporto = (TextView)findViewById(R.id.edtNomeporto);
        edtEstado = (TextView)findViewById(R.id.edtEstado);
        edtDescricao = (TextView)findViewById(R.id.edtDescricao);
        dao = new RecintoalfandegadoDAOImpl(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            try
            {
              table = dao.find(it.getStringExtra("CODIGO"),it.getStringExtra("TERMINAL"));
            edtCodigo.setText(table.getCodigo());
            edtTerminal.setText(table.getTerminal());
            edtRegiao.setText(table.getRegiao());
            edtNomeporto.setText(table.getNomeporto());
            edtEstado.setText(table.getEstado());
            edtDescricao.setText(table.getDescricao());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtCodigo.setEnabled(false);
                  edtTerminal.setEnabled(false);
                  edtRegiao.setEnabled(false);
                  edtNomeporto.setEnabled(false);
                  edtEstado.setEnabled(false);
                  edtDescricao.setEnabled(false);
                }
                else
                {
                  edtCodigo.setEnabled(false);
                  edtTerminal.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMrecintoalfandegado.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexRecintoalfandegado();
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
                                table.setCodigo(edtCodigo.getText().toString());
                                table.setTerminal(edtTerminal.getText().toString());
                                table.setRegiao(edtRegiao.getText().toString());
                                table.setNomeporto(edtNomeporto.getText().toString());
                                table.setEstado(edtEstado.getText().toString());
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
