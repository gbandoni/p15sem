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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        table = new J34SiscomexTipoDocumento();
        dao = new TipoDocumentoDAOImpl(this);
        setContentView(R.layout.activity_detail_tipo_documento);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            table = dao.find(it.getStringExtra("CODIGO"));
            ((TextView) findViewById(R.id.edtCodigo)).setText(table.getCodigo());
            ((TextView) findViewById(R.id.edtSigla)).setText(table.getSigla());
            ((TextView) findViewById(R.id.edtDescricao)).setText(table.getDescricao());
            ((TextView) findViewById(R.id.edtMaritima)).setText(table.getMaritima());
            ((TextView) findViewById(R.id.edtFluvia)).setText(table.getFluvia());
            ((TextView) findViewById(R.id.edtAerea)).setText(table.getAerea());
            ((TextView) findViewById(R.id.edtRodoviaria)).setText(table.getRodoviaria());
            ((TextView) findViewById(R.id.edtFerroviaria)).setText(table.getFerroviaria());
            ((TextView) findViewById(R.id.edtPostal)).setText(table.getPostal());
            ((TextView) findViewById(R.id.edtLacustre)).setText(table.getLacustre());
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
                                table.setCodigo(((TextView) findViewById(R.id.edtCodigo)).getText().toString());
                                table.setSigla(((TextView) findViewById(R.id.edtSigla)).getText().toString());
                                table.setDescricao(((TextView) findViewById(R.id.edtDescricao)).getText().toString());
                                table.setMaritima(((TextView) findViewById(R.id.edtMaritima)).getText().toString());
                                table.setFluvia(((TextView) findViewById(R.id.edtFluvia)).getText().toString());
                                table.setAerea(((TextView) findViewById(R.id.edtAerea)).getText().toString());
                                table.setRodoviaria(((TextView) findViewById(R.id.edtRodoviaria)).getText().toString());
                                table.setFerroviaria(((TextView) findViewById(R.id.edtFerroviaria)).getText().toString());
                                table.setPostal(((TextView) findViewById(R.id.edtPostal)).getText().toString());
                                table.setLacustre(((TextView) findViewById(R.id.edtLacustre)).getText().toString());
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
                AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext());
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
