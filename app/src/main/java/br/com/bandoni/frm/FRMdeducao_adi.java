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
import br.com.bandoni.dao.implementation.DeducaoAdiDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexDeducaoAdi;

import br.com.bandoni.dao.commons.SQLiteDriver;
import java.util.List;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import br.com.bandoni.siscomexhelper.R;

public class FRMdeducao_adi extends AppCompatActivity 
{
    private J34SiscomexDeducaoAdi table;
    private DeducaoAdiDAOImpl dao;
    private int action;
    private TextView edtNumerodocumentocarga;
    private TextView edtNumeroadicao;
    private AutoCompleteTextView edtCodigometododeducaovalor;
    private AutoCompleteTextView edtCodigomoedanegociadadeducao;
    private TextView edtValordeducaomoedanacional;
    private TextView edtValordeducaomoedanegociada;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_deducao_adi);
        //campos do formulario;
        edtNumerodocumentocarga = (TextView)findViewById(R.id.edtNumerodocumentocarga);
        edtNumeroadicao = (TextView)findViewById(R.id.edtNumeroadicao);
        edtCodigometododeducaovalor = (AutoCompleteTextView)findViewById(R.id.edtCodigometododeducaovalor);
        edtCodigomoedanegociadadeducao = (AutoCompleteTextView)findViewById(R.id.edtCodigomoedanegociadadeducao);
        edtValordeducaomoedanacional = (TextView)findViewById(R.id.edtValordeducaomoedanacional);
        edtValordeducaomoedanegociada = (TextView)findViewById(R.id.edtValordeducaomoedanegociada);
         List<String> lstDeducoes = getDeducoes();
         ArrayAdapter<String> adpCodigometododeducaovalor = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstDeducoes);
        edtCodigometododeducaovalor.setAdapter(adpCodigometododeducaovalor);
         List<String> lstMoedas = getMoedas();
         ArrayAdapter<String> adpCodigomoedanegociadadeducao = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstMoedas);
        edtCodigomoedanegociadadeducao.setAdapter(adpCodigomoedanegociadadeducao);
        dao = new DeducaoAdiDAOImpl(this);
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
            edtCodigometododeducaovalor.setText(table.getCodigometododeducaovalor());
            edtCodigomoedanegociadadeducao.setText(table.getCodigomoedanegociadadeducao().toString());
            edtValordeducaomoedanacional.setText(table.getValordeducaomoedanacional().toString());
            edtValordeducaomoedanegociada.setText(table.getValordeducaomoedanegociada().toString());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtNumerodocumentocarga.setEnabled(false);
                  edtNumeroadicao.setEnabled(false);
                  edtCodigometododeducaovalor.setEnabled(false);
                  edtCodigomoedanegociadadeducao.setEnabled(false);
                  edtValordeducaomoedanacional.setEnabled(false);
                  edtValordeducaomoedanegociada.setEnabled(false);
                }
                else
                {
                  edtNumerodocumentocarga.setEnabled(false);
                  edtNumeroadicao.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMdeducao_adi.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexDeducaoAdi();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_deducao_adi, menu);
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
                                table.setCodigometododeducaovalor(edtCodigometododeducaovalor.getText().toString());
                                table.setCodigomoedanegociadadeducao(Integer.parseInt(edtCodigomoedanegociadadeducao.getText().toString()));
                                table.setValordeducaomoedanacional(Float.parseFloat(edtValordeducaomoedanacional.getText().toString()));
                                table.setValordeducaomoedanegociada(Float.parseFloat(edtValordeducaomoedanegociada.getText().toString()));
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMdeducao_adi.this);
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

    private List<String> getDeducoes()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_deducoes");
      driver.close();
      return lista;
    }
    private List<String> getMoedas()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_moedas");
      driver.close();
      return lista;
    }

}
