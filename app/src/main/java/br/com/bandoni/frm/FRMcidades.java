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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
         List<String> lstEstado = getEstado();
         ArrayAdapter<String> adpestado_id = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstEstado);
         AutoCompleteTextView edtestado_id = (AutoCompleteTextView)findViewById(R.id.edtEstado_id);
        edtestado_id.setAdapter(adpestado_id);
        table = new J34SiscomexCidades();
        dao = new CidadesDAOImpl(this);
        setContentView(R.layout.activity_detail_cidades);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            table = dao.find(it.getStringExtra("ESTADO"),it.getStringExtra("CODMUN"));
            ((TextView) findViewById(R.id.edtEstado)).setText(table.getEstado());
            ((TextView) findViewById(R.id.edtCodmun)).setText(table.getCodmun());
            ((TextView) findViewById(R.id.edtNome)).setText(table.getNome());
            ((TextView) findViewById(R.id.edtEstado_id)).setText(table.getEstado_id());
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
                                table.setEstado(((TextView) findViewById(R.id.edtEstado)).getText().toString());
                                table.setCodmun(((TextView) findViewById(R.id.edtCodmun)).getText().toString());
                                table.setNome(((TextView) findViewById(R.id.edtNome)).getText().toString());
                                table.setEstado_id(((AutoCompleteTextView) findViewById(R.id.edtEstado_id)).getText().toString());
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
