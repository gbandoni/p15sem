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
import br.com.bandoni.dao.implementation.CidadesDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexCidades;

import br.com.bandoni.dao.commons.SQLiteDriver;
import java.util.List;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import br.com.bandoni.siscomexhelper.R;

public class FRMcidades extends AppCompatActivity 
{
    private J34SiscomexCidades table;
    private CidadesDAOImpl dao;
    private int action;
    private TextView edtEstado;
    private TextView edtCodmun;
    private TextView edtNome;
    private AutoCompleteTextView edtEstado_id;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cidades);
        //campos do formulario;
        edtEstado = (TextView)findViewById(R.id.edtEstado);
        edtCodmun = (TextView)findViewById(R.id.edtCodmun);
        edtNome = (TextView)findViewById(R.id.edtNome);
        edtEstado_id = (AutoCompleteTextView)findViewById(R.id.edtEstado_id);
         List<String> lstEstado = getEstado();
         ArrayAdapter<String> adpEstado_id = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstEstado);
        edtEstado_id.setAdapter(adpEstado_id);
        dao = new CidadesDAOImpl(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            try
            {
              table = dao.find(it.getStringExtra("ESTADO"),it.getStringExtra("CODMUN"));
            edtEstado.setText(table.getEstado());
            edtCodmun.setText(table.getCodmun());
            edtNome.setText(table.getNome());
            edtEstado_id.setText(table.getEstado_id());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtEstado.setEnabled(false);
                  edtCodmun.setEnabled(false);
                  edtNome.setEnabled(false);
                  edtEstado_id.setEnabled(false);
                }
                else
                {
                  edtEstado.setEnabled(false);
                  edtCodmun.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMcidades.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexCidades();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_cidades, menu);
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
                                table.setEstado(edtEstado.getText().toString());
                                table.setCodmun(edtCodmun.getText().toString());
                                table.setNome(edtNome.getText().toString());
                                table.setEstado_id(edtEstado_id.getText().toString());
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMcidades.this);
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

    private List<String> getEstado()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_estado");
      driver.close();
      return lista;
    }

}
