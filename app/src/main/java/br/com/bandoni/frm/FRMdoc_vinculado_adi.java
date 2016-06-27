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
import br.com.bandoni.dao.implementation.DocVinculadoAdiDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexDocVinculadoAdi;

import java.util.ArrayList;
import java.util.List;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import br.com.bandoni.siscomexhelper.R;

public class FRMdoc_vinculado_adi extends AppCompatActivity 
{
    private J34SiscomexDocVinculadoAdi table;
    private DocVinculadoAdiDAOImpl dao;
    private int action;
    private TextView edtNumerodocumentocarga;
    private TextView edtNumeroadicao;
    private AutoCompleteTextView edtCodigotipodocumentovinculado;
    private TextView edtNumerodocumentovinculado;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_doc_vinculado_adi);
        //campos do formulario;
        edtNumerodocumentocarga = (TextView)findViewById(R.id.edtNumerodocumentocarga);
        edtNumeroadicao = (TextView)findViewById(R.id.edtNumeroadicao);
        edtCodigotipodocumentovinculado = (AutoCompleteTextView)findViewById(R.id.edtCodigotipodocumentovinculado);
        edtNumerodocumentovinculado = (TextView)findViewById(R.id.edtNumerodocumentovinculado);
         List<String> lstcodigoTipoDocumentoVinculado = getcodigoTipoDocumentoVinculado();
         ArrayAdapter<String> adpCodigotipodocumentovinculado = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstcodigoTipoDocumentoVinculado);
        edtCodigotipodocumentovinculado.setAdapter(adpCodigotipodocumentovinculado);
        dao = new DocVinculadoAdiDAOImpl(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            try
            {
              table = dao.find(it.getStringExtra("NUMERODOCUMENTOCARGA"),it.getStringExtra("NUMEROADICAO"));
            edtNumerodocumentocarga.setText(table.getNumerodocumentocarga());
            edtNumeroadicao.setText(table.getNumeroadicao());
            edtCodigotipodocumentovinculado.setText(table.getCodigotipodocumentovinculado());
            edtNumerodocumentovinculado.setText(table.getNumerodocumentovinculado());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtNumerodocumentocarga.setEnabled(false);
                  edtNumeroadicao.setEnabled(false);
                  edtCodigotipodocumentovinculado.setEnabled(false);
                  edtNumerodocumentovinculado.setEnabled(false);
                }
                else
                {
                  edtNumerodocumentocarga.setEnabled(false);
                  edtNumeroadicao.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMdoc_vinculado_adi.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexDocVinculadoAdi();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_doc_vinculado_adi, menu);
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
                                table.setNumerodocumentocarga(edtNumerodocumentocarga.getText().toString());
                                table.setNumeroadicao(edtNumeroadicao.getText().toString());
                                table.setCodigotipodocumentovinculado(edtCodigotipodocumentovinculado.getText().toString());
                                table.setNumerodocumentovinculado(edtNumerodocumentovinculado.getText().toString());
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMdoc_vinculado_adi.this);
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

    private List<String> getcodigoTipoDocumentoVinculado()
    {
      List<String> lista = new ArrayList<String>();
      lista.add("2-Declaração de Importação");
      lista.add("3-Registro de Exportação");
      return lista;
    }

}
