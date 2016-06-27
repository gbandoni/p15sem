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
    private TextView edtNumerodocumentocarga;
    private TextView edtNumeroadicao;
    private TextView edtNomeunidademedidacomercializada;
    private TextView edtQuantidademercadoriaunidadecomercializada;
    private TextView edtTextodetalhamentomercadoria;
    private TextView edtValorunidadelocalembarque;
    private TextView edtValorunidademedidacondicaovenda;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mercadoria_adi);
        //campos do formulario;
        edtNumerodocumentocarga = (TextView)findViewById(R.id.edtNumerodocumentocarga);
        edtNumeroadicao = (TextView)findViewById(R.id.edtNumeroadicao);
        edtNomeunidademedidacomercializada = (TextView)findViewById(R.id.edtNomeunidademedidacomercializada);
        edtQuantidademercadoriaunidadecomercializada = (TextView)findViewById(R.id.edtQuantidademercadoriaunidadecomercializada);
        edtTextodetalhamentomercadoria = (TextView)findViewById(R.id.edtTextodetalhamentomercadoria);
        edtValorunidadelocalembarque = (TextView)findViewById(R.id.edtValorunidadelocalembarque);
        edtValorunidademedidacondicaovenda = (TextView)findViewById(R.id.edtValorunidademedidacondicaovenda);
        dao = new MercadoriaAdiDAOImpl(this);
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
            edtNomeunidademedidacomercializada.setText(table.getNomeunidademedidacomercializada());
            edtQuantidademercadoriaunidadecomercializada.setText(table.getQuantidademercadoriaunidadecomercializada().toString());
            edtTextodetalhamentomercadoria.setText(table.getTextodetalhamentomercadoria().toString());
            edtValorunidadelocalembarque.setText(table.getValorunidadelocalembarque().toString());
            edtValorunidademedidacondicaovenda.setText(table.getValorunidademedidacondicaovenda().toString());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtNumerodocumentocarga.setEnabled(false);
                  edtNumeroadicao.setEnabled(false);
                  edtNomeunidademedidacomercializada.setEnabled(false);
                  edtQuantidademercadoriaunidadecomercializada.setEnabled(false);
                  edtTextodetalhamentomercadoria.setEnabled(false);
                  edtValorunidadelocalembarque.setEnabled(false);
                  edtValorunidademedidacondicaovenda.setEnabled(false);
                }
                else
                {
                  edtNumerodocumentocarga.setEnabled(false);
                  edtNumeroadicao.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMmercadoria_adi.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexMercadoriaAdi();
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
                                table.setNumerodocumentocarga(edtNumerodocumentocarga.getText().toString());
                                table.setNumeroadicao(edtNumeroadicao.getText().toString());
                                table.setNomeunidademedidacomercializada(edtNomeunidademedidacomercializada.getText().toString());
                                table.setQuantidademercadoriaunidadecomercializada(Float.parseFloat(edtQuantidademercadoriaunidadecomercializada.getText().toString()));
                                table.setTextodetalhamentomercadoria(edtTextodetalhamentomercadoria.getText().toString());
                                table.setValorunidadelocalembarque(Float.parseFloat(edtValorunidadelocalembarque.getText().toString()));
                                table.setValorunidademedidacondicaovenda(Float.parseFloat(edtValorunidademedidacondicaovenda.getText().toString()));
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
