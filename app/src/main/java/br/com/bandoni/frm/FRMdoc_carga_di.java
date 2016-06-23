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
import br.com.bandoni.dao.implementation.DocCargaDiDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexDocCargaDi;

import br.com.bandoni.dao.commons.SQLiteDriver;
import java.util.List;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import br.com.bandoni.siscomexhelper.R;

public class FRMdoc_carga_di extends AppCompatActivity 
{
    private J34SiscomexDocCargaDi table;
    private DocCargaDiDAOImpl dao;
    private int action;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
         List<String> lstTipo_embalagem = getTipo_embalagem();
         ArrayAdapter<String> adpcodigoTipoEmbalagemCarga = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstTipo_embalagem);
         AutoCompleteTextView edtcodigoTipoEmbalagemCarga = (AutoCompleteTextView)findViewById(R.id.edtCodigotipoembalagemcarga);
        edtcodigoTipoEmbalagemCarga.setAdapter(adpcodigoTipoEmbalagemCarga);
        table = new J34SiscomexDocCargaDi();
        dao = new DocCargaDiDAOImpl(this);
        setContentView(R.layout.activity_detail_doc_carga_di);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            table = dao.find(it.getStringExtra("NUMERODOCUMENTOCARGA"),it.getIntExtra("ORDEM",0));
            ((TextView) findViewById(R.id.edtNumerodocumentocarga)).setText(table.getNumerodocumentocarga());
            ((TextView) findViewById(R.id.edtOrdem)).setText(table.getOrdem().toString());
            ((TextView) findViewById(R.id.edtCodigotipoembalagemcarga)).setText(table.getCodigotipoembalagemcarga().toString());
            ((TextView) findViewById(R.id.edtQuantidadevolumecarga)).setText(table.getQuantidadevolumecarga().toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_doc_carga_di, menu);
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
                                table.setNumerodocumentocarga(((TextView) findViewById(R.id.edtNumerodocumentocarga)).getText().toString());
                                table.setOrdem(Integer.parseInt(((TextView) findViewById(R.id.edtOrdem)).getText().toString()));
                                table.setCodigotipoembalagemcarga(Integer.parseInt(((AutoCompleteTextView) findViewById(R.id.edtCodigotipoembalagemcarga)).getText().toString()));
                                table.setQuantidadevolumecarga(Integer.parseInt(((TextView) findViewById(R.id.edtQuantidadevolumecarga)).getText().toString()));
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMdoc_carga_di.this);
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

    private List<String> getTipo_embalagem()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_tipo_embalagem");
      driver.close();
      return lista;
    }

}
