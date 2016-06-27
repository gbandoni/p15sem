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
import br.com.bandoni.dao.implementation.TipoDocumentoDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexTipoDocumento;

import br.com.bandoni.siscomexhelper.R;

public class FRMtipo_documento extends AppCompatActivity 
{
    private J34SiscomexTipoDocumento table;
    private TipoDocumentoDAOImpl dao;
    private int action;
    private TextView edtCodigo;
    private TextView edtSigla;
    private TextView edtDescricao;
    private TextView edtMaritima;
    private TextView edtFluvia;
    private TextView edtAerea;
    private TextView edtRodoviaria;
    private TextView edtFerroviaria;
    private TextView edtPostal;
    private TextView edtLacustre;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tipo_documento);
        //campos do formulario;
        edtCodigo = (TextView)findViewById(R.id.edtCodigo);
        edtSigla = (TextView)findViewById(R.id.edtSigla);
        edtDescricao = (TextView)findViewById(R.id.edtDescricao);
        edtMaritima = (TextView)findViewById(R.id.edtMaritima);
        edtFluvia = (TextView)findViewById(R.id.edtFluvia);
        edtAerea = (TextView)findViewById(R.id.edtAerea);
        edtRodoviaria = (TextView)findViewById(R.id.edtRodoviaria);
        edtFerroviaria = (TextView)findViewById(R.id.edtFerroviaria);
        edtPostal = (TextView)findViewById(R.id.edtPostal);
        edtLacustre = (TextView)findViewById(R.id.edtLacustre);
        dao = new TipoDocumentoDAOImpl(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            try
            {
              table = dao.find(it.getStringExtra("CODIGO"));
            edtCodigo.setText(table.getCodigo());
            edtSigla.setText(table.getSigla());
            edtDescricao.setText(table.getDescricao());
            edtMaritima.setText(table.getMaritima());
            edtFluvia.setText(table.getFluvia());
            edtAerea.setText(table.getAerea());
            edtRodoviaria.setText(table.getRodoviaria());
            edtFerroviaria.setText(table.getFerroviaria());
            edtPostal.setText(table.getPostal());
            edtLacustre.setText(table.getLacustre());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtCodigo.setEnabled(false);
                  edtSigla.setEnabled(false);
                  edtDescricao.setEnabled(false);
                  edtMaritima.setEnabled(false);
                  edtFluvia.setEnabled(false);
                  edtAerea.setEnabled(false);
                  edtRodoviaria.setEnabled(false);
                  edtFerroviaria.setEnabled(false);
                  edtPostal.setEnabled(false);
                  edtLacustre.setEnabled(false);
                }
                else
                {
                  edtCodigo.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMtipo_documento.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexTipoDocumento();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_tipo_documento, menu);
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
                                table.setSigla(edtSigla.getText().toString());
                                table.setDescricao(edtDescricao.getText().toString());
                                table.setMaritima(edtMaritima.getText().toString());
                                table.setFluvia(edtFluvia.getText().toString());
                                table.setAerea(edtAerea.getText().toString());
                                table.setRodoviaria(edtRodoviaria.getText().toString());
                                table.setFerroviaria(edtFerroviaria.getText().toString());
                                table.setPostal(edtPostal.getText().toString());
                                table.setLacustre(edtLacustre.getText().toString());
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMtipo_documento.this);
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
