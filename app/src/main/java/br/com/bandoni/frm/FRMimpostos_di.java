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
import br.com.bandoni.dao.implementation.ImpostosDiDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexImpostosDi;

import br.com.bandoni.dao.commons.SQLiteDriver;
import java.util.List;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import br.com.bandoni.siscomexhelper.R;

public class FRMimpostos_di extends AppCompatActivity 
{
    private J34SiscomexImpostosDi table;
    private ImpostosDiDAOImpl dao;
    private int action;
    private TextView edtNumerodocumentocarga;
    private TextView edtOrdem;
    private AutoCompleteTextView edtCodigobancopagamentotributo;
    private AutoCompleteTextView edtCodigoreceitapagamento;
    private TextView edtDatapagamentotributo;
    private TextView edtNumeroagenciapagamentotributo;
    private TextView edtValorjurospagamentotributo;
    private TextView edtValormultapagamentotributo;
    private TextView edtValortributopago;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_impostos_di);
        //campos do formulario;
        edtNumerodocumentocarga = (TextView)findViewById(R.id.edtNumerodocumentocarga);
        edtOrdem = (TextView)findViewById(R.id.edtOrdem);
        edtCodigobancopagamentotributo = (AutoCompleteTextView)findViewById(R.id.edtCodigobancopagamentotributo);
        edtCodigoreceitapagamento = (AutoCompleteTextView)findViewById(R.id.edtCodigoreceitapagamento);
        edtDatapagamentotributo = (TextView)findViewById(R.id.edtDatapagamentotributo);
        edtNumeroagenciapagamentotributo = (TextView)findViewById(R.id.edtNumeroagenciapagamentotributo);
        edtValorjurospagamentotributo = (TextView)findViewById(R.id.edtValorjurospagamentotributo);
        edtValormultapagamentotributo = (TextView)findViewById(R.id.edtValormultapagamentotributo);
        edtValortributopago = (TextView)findViewById(R.id.edtValortributopago);
         List<String> lstBancos = getBancos();
         ArrayAdapter<String> adpCodigobancopagamentotributo = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstBancos);
        edtCodigobancopagamentotributo.setAdapter(adpCodigobancopagamentotributo);
         List<String> lstTab_orcamentaria = getTab_orcamentaria();
         ArrayAdapter<String> adpCodigoreceitapagamento = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstTab_orcamentaria);
        edtCodigoreceitapagamento.setAdapter(adpCodigoreceitapagamento);
        dao = new ImpostosDiDAOImpl(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            try
            {
              table = dao.find(it.getStringExtra("NUMERODOCUMENTOCARGA"),it.getIntExtra("ORDEM",0));
            edtNumerodocumentocarga.setText(table.getNumerodocumentocarga());
            edtOrdem.setText(table.getOrdem().toString());
            edtCodigobancopagamentotributo.setText(table.getCodigobancopagamentotributo());
            edtCodigoreceitapagamento.setText(table.getCodigoreceitapagamento());
            edtDatapagamentotributo.setText(table.getDatapagamentotributo().toString());
            edtNumeroagenciapagamentotributo.setText(table.getNumeroagenciapagamentotributo());
            edtValorjurospagamentotributo.setText(table.getValorjurospagamentotributo().toString());
            edtValormultapagamentotributo.setText(table.getValormultapagamentotributo().toString());
            edtValortributopago.setText(table.getValortributopago().toString());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtNumerodocumentocarga.setEnabled(false);
                  edtOrdem.setEnabled(false);
                  edtCodigobancopagamentotributo.setEnabled(false);
                  edtCodigoreceitapagamento.setEnabled(false);
                  edtDatapagamentotributo.setEnabled(false);
                  edtNumeroagenciapagamentotributo.setEnabled(false);
                  edtValorjurospagamentotributo.setEnabled(false);
                  edtValormultapagamentotributo.setEnabled(false);
                  edtValortributopago.setEnabled(false);
                }
                else
                {
                  edtNumerodocumentocarga.setEnabled(false);
                  edtOrdem.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMimpostos_di.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexImpostosDi();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_impostos_di, menu);
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
                                table.setOrdem(Integer.parseInt(edtOrdem.getText().toString()));
                                table.setCodigobancopagamentotributo(edtCodigobancopagamentotributo.getText().toString());
                                table.setCodigoreceitapagamento(edtCodigoreceitapagamento.getText().toString());
                                table.setDatapagamentotributo(edtDatapagamentotributo.getText().toString());
                                table.setNumeroagenciapagamentotributo(edtNumeroagenciapagamentotributo.getText().toString());
                                table.setValorjurospagamentotributo(Float.parseFloat(edtValorjurospagamentotributo.getText().toString()));
                                table.setValormultapagamentotributo(Float.parseFloat(edtValormultapagamentotributo.getText().toString()));
                                table.setValortributopago(Float.parseFloat(edtValortributopago.getText().toString()));
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMimpostos_di.this);
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

    private List<String> getBancos()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_bancos");
      driver.close();
      return lista;
    }
    private List<String> getTab_orcamentaria()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_tab_orcamentaria");
      driver.close();
      return lista;
    }

}
