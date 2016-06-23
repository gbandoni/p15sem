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
import br.com.bandoni.dao.implementation.DocumentosDiDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexDocumentosDi;

import br.com.bandoni.dao.commons.SQLiteDriver;
import java.util.List;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import br.com.bandoni.siscomexhelper.R;

public class FRMdocumentos_di extends AppCompatActivity 
{
    private J34SiscomexDocumentosDi table;
    private DocumentosDiDAOImpl dao;
    private int action;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
         List<String> lstTipo_documento_des = getTipo_documento_des();
         ArrayAdapter<String> adpcodigoTipoDocumentoInstrucaoDespacho = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstTipo_documento_des);
         AutoCompleteTextView edtcodigoTipoDocumentoInstrucaoDespacho = (AutoCompleteTextView)findViewById(R.id.edtCodigotipodocumentoinstrucaodespacho);
        edtcodigoTipoDocumentoInstrucaoDespacho.setAdapter(adpcodigoTipoDocumentoInstrucaoDespacho);
        table = new J34SiscomexDocumentosDi();
        dao = new DocumentosDiDAOImpl(this);
        setContentView(R.layout.activity_detail_documentos_di);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            table = dao.find(it.getStringExtra("NUMERODOCUMENTOCARGA"),it.getIntExtra("ORDEM",0));
            ((TextView) findViewById(R.id.edtNumerodocumentocarga)).setText(table.getNumerodocumentocarga());
            ((TextView) findViewById(R.id.edtOrdem)).setText(table.getOrdem().toString());
            ((TextView) findViewById(R.id.edtCodigotipodocumentoinstrucaodespacho)).setText(table.getCodigotipodocumentoinstrucaodespacho().toString());
            ((TextView) findViewById(R.id.edtNumerodocumentoinstrucaodespacho)).setText(table.getNumerodocumentoinstrucaodespacho());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_documentos_di, menu);
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
                                table.setCodigotipodocumentoinstrucaodespacho(Integer.parseInt(((AutoCompleteTextView) findViewById(R.id.edtCodigotipodocumentoinstrucaodespacho)).getText().toString()));
                                table.setNumerodocumentoinstrucaodespacho(((TextView) findViewById(R.id.edtNumerodocumentoinstrucaodespacho)).getText().toString());
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMdocumentos_di.this);
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

    private List<String> getTipo_documento_des()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_tipo_documento_des");
      driver.close();
      return lista;
    }

}
