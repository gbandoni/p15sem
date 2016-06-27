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
import br.com.bandoni.dao.implementation.MoedasDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexMoedas;

import br.com.bandoni.siscomexhelper.R;

public class FRMmoedas extends AppCompatActivity 
{
    private J34SiscomexMoedas table;
    private MoedasDAOImpl dao;
    private int action;
    private TextView edtIdmoeda;
    private TextView edtPais;
    private TextView edtCodigo;
    private TextView edtDataexclusao;
    private TextView edtNome;
    private TextView edtSimbolo;
    private TextView edtTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_moedas);
        //campos do formulario;
        edtIdmoeda = (TextView)findViewById(R.id.edtIdmoeda);
        edtPais = (TextView)findViewById(R.id.edtPais);
        edtCodigo = (TextView)findViewById(R.id.edtCodigo);
        edtDataexclusao = (TextView)findViewById(R.id.edtDataexclusao);
        edtNome = (TextView)findViewById(R.id.edtNome);
        edtSimbolo = (TextView)findViewById(R.id.edtSimbolo);
        edtTipo = (TextView)findViewById(R.id.edtTipo);
        dao = new MoedasDAOImpl(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            try
            {
              table = dao.find(it.getIntExtra("IDMOEDA",0));
            edtIdmoeda.setText(table.getIdmoeda().toString());
            edtPais.setText(table.getPais());
            edtCodigo.setText(table.getCodigo().toString());
            edtDataexclusao.setText(table.getDataexclusao().toString());
            edtNome.setText(table.getNome());
            edtSimbolo.setText(table.getSimbolo());
            edtTipo.setText(table.getTipo());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtIdmoeda.setEnabled(false);
                  edtPais.setEnabled(false);
                  edtCodigo.setEnabled(false);
                  edtDataexclusao.setEnabled(false);
                  edtNome.setEnabled(false);
                  edtSimbolo.setEnabled(false);
                  edtTipo.setEnabled(false);
                }
                else
                {
                  edtIdmoeda.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMmoedas.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexMoedas();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_moedas, menu);
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
                                table.setIdmoeda(Integer.parseInt(edtIdmoeda.getText().toString()));
                                table.setPais(edtPais.getText().toString());
                                table.setCodigo(Integer.parseInt(edtCodigo.getText().toString()));
                                table.setDataexclusao(edtDataexclusao.getText().toString());
                                table.setNome(edtNome.getText().toString());
                                table.setSimbolo(edtSimbolo.getText().toString());
                                table.setTipo(edtTipo.getText().toString());
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMmoedas.this);
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
