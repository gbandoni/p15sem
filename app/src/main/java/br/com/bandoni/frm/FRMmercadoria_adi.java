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
import br.com.bandoni.dao.implementation.MercadoriaAdiDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexMercadoriaAdi;

import br.com.bandoni.siscomexhelper.R;

public class FRMmercadoria_adi extends AppCompatActivity 
{
    private J34SiscomexMercadoriaAdi table;
    private MercadoriaAdiDAOImpl dao;
    private int action;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        table = new J34SiscomexMercadoriaAdi();
        dao = new MercadoriaAdiDAOImpl(this);
        setContentView(R.layout.activity_detail_mercadoria_adi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            table = dao.find(it.getStringExtra("NUMERODOCUMENTOCARGA"),it.getStringExtra("NUMEROADICAO"));
            ((TextView) findViewById(R.id.edtNumerodocumentocarga)).setText(table.getNumerodocumentocarga());
            ((TextView) findViewById(R.id.edtNumeroadicao)).setText(table.getNumeroadicao());
            ((TextView) findViewById(R.id.edtNomeunidademedidacomercializada)).setText(table.getNomeunidademedidacomercializada());
            ((TextView) findViewById(R.id.edtQuantidademercadoriaunidadecomercializada)).setText(table.getQuantidademercadoriaunidadecomercializada().toString());
            ((TextView) findViewById(R.id.edtTextodetalhamentomercadoria)).setText(table.getTextodetalhamentomercadoria().toString());
            ((TextView) findViewById(R.id.edtValorunidadelocalembarque)).setText(table.getValorunidadelocalembarque().toString());
            ((TextView) findViewById(R.id.edtValorunidademedidacondicaovenda)).setText(table.getValorunidademedidacondicaovenda().toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_mercadoria_adi, menu);
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
                                table.setNumeroadicao(((TextView) findViewById(R.id.edtNumeroadicao)).getText().toString());
                                table.setNomeunidademedidacomercializada(((TextView) findViewById(R.id.edtNomeunidademedidacomercializada)).getText().toString());
                                table.setQuantidademercadoriaunidadecomercializada(Float.parseFloat(((TextView) findViewById(R.id.edtQuantidademercadoriaunidadecomercializada)).getText().toString()));
                                table.setTextodetalhamentomercadoria(((TextView) findViewById(R.id.edtTextodetalhamentomercadoria)).getText().toString());
                                table.setValorunidadelocalembarque(Float.parseFloat(((TextView) findViewById(R.id.edtValorunidadelocalembarque)).getText().toString()));
                                table.setValorunidademedidacondicaovenda(Float.parseFloat(((TextView) findViewById(R.id.edtValorunidademedidacondicaovenda)).getText().toString()));
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMmercadoria_adi.this);
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
