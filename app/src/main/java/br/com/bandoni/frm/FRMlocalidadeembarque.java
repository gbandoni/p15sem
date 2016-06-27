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
import br.com.bandoni.dao.implementation.LocalidadeembarqueDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexLocalidadeembarque;

import br.com.bandoni.dao.commons.SQLiteDriver;
import java.util.List;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import br.com.bandoni.siscomexhelper.R;

public class FRMlocalidadeembarque extends AppCompatActivity 
{
    private J34SiscomexLocalidadeembarque table;
    private LocalidadeembarqueDAOImpl dao;
    private int action;
    private TextView edtId;
    private AutoCompleteTextView edtCodpais;
    private TextView edtLocalidade;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_localidadeembarque);
        //campos do formulario;
        edtId = (TextView)findViewById(R.id.edtId);
        edtCodpais = (AutoCompleteTextView)findViewById(R.id.edtCodpais);
        edtLocalidade = (TextView)findViewById(R.id.edtLocalidade);
         List<String> lstPaises = getPaises();
         ArrayAdapter<String> adpCodpais = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstPaises);
        edtCodpais.setAdapter(adpCodpais);
        dao = new LocalidadeembarqueDAOImpl(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            try
            {
              table = dao.find(it.getStringExtra("ID"));
            edtId.setText(table.getId());
            edtCodpais.setText(table.getCodpais());
            edtLocalidade.setText(table.getLocalidade());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtId.setEnabled(false);
                  edtCodpais.setEnabled(false);
                  edtLocalidade.setEnabled(false);
                }
                else
                {
                  edtId.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMlocalidadeembarque.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexLocalidadeembarque();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_localidadeembarque, menu);
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
                                table.setId(edtId.getText().toString());
                                table.setCodpais(edtCodpais.getText().toString());
                                table.setLocalidade(edtLocalidade.getText().toString());
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMlocalidadeembarque.this);
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

    private List<String> getPaises()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_paises");
      driver.close();
      return lista;
    }

}
