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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
         List<String> lstBancos = getBancos();
         ArrayAdapter<String> adpcodigoBancoPagamentoTributo = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstBancos);
         AutoCompleteTextView edtcodigoBancoPagamentoTributo = (AutoCompleteTextView)findViewById(R.id.edtCodigobancopagamentotributo);
        edtcodigoBancoPagamentoTributo.setAdapter(adpcodigoBancoPagamentoTributo);
         List<String> lstTab_orcamentaria = getTab_orcamentaria();
         ArrayAdapter<String> adpcodigoReceitaPagamento = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstTab_orcamentaria);
         AutoCompleteTextView edtcodigoReceitaPagamento = (AutoCompleteTextView)findViewById(R.id.edtCodigoreceitapagamento);
        edtcodigoReceitaPagamento.setAdapter(adpcodigoReceitaPagamento);
        table = new J34SiscomexImpostosDi();
        dao = new ImpostosDiDAOImpl(this);
        setContentView(R.layout.activity_detail_impostos_di);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            table = dao.find(it.getStringExtra("NUMERODOCUMENTOCARGA"),it.getIntExtra("ORDEM",0));
            ((TextView) findViewById(R.id.edtNumerodocumentocarga)).setText(table.getNumerodocumentocarga());
            ((TextView) findViewById(R.id.edtOrdem)).setText(table.getOrdem().toString());
            ((TextView) findViewById(R.id.edtCodigobancopagamentotributo)).setText(table.getCodigobancopagamentotributo());
            ((TextView) findViewById(R.id.edtCodigoreceitapagamento)).setText(table.getCodigoreceitapagamento());
            ((TextView) findViewById(R.id.edtDatapagamentotributo)).setText(table.getDatapagamentotributo().toString());
            ((TextView) findViewById(R.id.edtNumeroagenciapagamentotributo)).setText(table.getNumeroagenciapagamentotributo());
            ((TextView) findViewById(R.id.edtValorjurospagamentotributo)).setText(table.getValorjurospagamentotributo().toString());
            ((TextView) findViewById(R.id.edtValormultapagamentotributo)).setText(table.getValormultapagamentotributo().toString());
            ((TextView) findViewById(R.id.edtValortributopago)).setText(table.getValortributopago().toString());
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
                                table.setNumerodocumentocarga(((TextView) findViewById(R.id.edtNumerodocumentocarga)).getText().toString());
                                table.setOrdem(Integer.parseInt(((TextView) findViewById(R.id.edtOrdem)).getText().toString()));
                                table.setCodigobancopagamentotributo(((AutoCompleteTextView) findViewById(R.id.edtCodigobancopagamentotributo)).getText().toString());
                                table.setCodigoreceitapagamento(((AutoCompleteTextView) findViewById(R.id.edtCodigoreceitapagamento)).getText().toString());
                                table.setDatapagamentotributo( ((TextView) findViewById(R.id.edtDatapagamentotributo)).getText().toString());
                                table.setNumeroagenciapagamentotributo(((TextView) findViewById(R.id.edtNumeroagenciapagamentotributo)).getText().toString());
                                table.setValorjurospagamentotributo(Float.parseFloat(((TextView) findViewById(R.id.edtValorjurospagamentotributo)).getText().toString()));
                                table.setValormultapagamentotributo(Float.parseFloat(((TextView) findViewById(R.id.edtValormultapagamentotributo)).getText().toString()));
                                table.setValortributopago(Float.parseFloat(((TextView) findViewById(R.id.edtValortributopago)).getText().toString()));
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
