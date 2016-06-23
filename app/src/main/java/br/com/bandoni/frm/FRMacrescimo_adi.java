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
import br.com.bandoni.dao.implementation.AcrescimoAdiDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexAcrescimoAdi;

import br.com.bandoni.dao.commons.SQLiteDriver;
import java.util.List;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import br.com.bandoni.siscomexhelper.R;

public class FRMacrescimo_adi extends AppCompatActivity 
{
    private J34SiscomexAcrescimoAdi table;
    private AcrescimoAdiDAOImpl dao;
    private int action;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
         List<String> lstAcrescimos = getAcrescimos();
         ArrayAdapter<String> adpcodigoMetodoAcrescimoValor = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstAcrescimos);
         AutoCompleteTextView edtcodigoMetodoAcrescimoValor = (AutoCompleteTextView)findViewById(R.id.edtCodigometodoacrescimovalor);
        edtcodigoMetodoAcrescimoValor.setAdapter(adpcodigoMetodoAcrescimoValor);
         List<String> lstMoedas = getMoedas();
         ArrayAdapter<String> adpcodigoMoedaNegociadaAcrescimo = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstMoedas);
         AutoCompleteTextView edtcodigoMoedaNegociadaAcrescimo = (AutoCompleteTextView)findViewById(R.id.edtCodigomoedanegociadaacrescimo);
        edtcodigoMoedaNegociadaAcrescimo.setAdapter(adpcodigoMoedaNegociadaAcrescimo);
        table = new J34SiscomexAcrescimoAdi();
        dao = new AcrescimoAdiDAOImpl(this);
        setContentView(R.layout.activity_detail_acrescimo_adi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            table = dao.find(it.getStringExtra("NUMERODOCUMENTOCARGA"),it.getStringExtra("NUMEROADICAO"));
            ((TextView) findViewById(R.id.edtNumerodocumentocarga)).setText(table.getNumerodocumentocarga());
            ((TextView) findViewById(R.id.edtNumeroadicao)).setText(table.getNumeroadicao());
            ((TextView) findViewById(R.id.edtCodigometodoacrescimovalor)).setText(table.getCodigometodoacrescimovalor());
            ((TextView) findViewById(R.id.edtCodigomoedanegociadaacrescimo)).setText(table.getCodigomoedanegociadaacrescimo().toString());
            ((TextView) findViewById(R.id.edtValoracrescimomoedanacional)).setText(table.getValoracrescimomoedanacional().toString());
            ((TextView) findViewById(R.id.edtValoracrescimomoedanegociada)).setText(table.getValoracrescimomoedanegociada().toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_acrescimo_adi, menu);
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
                                table.setCodigometodoacrescimovalor(((AutoCompleteTextView) findViewById(R.id.edtCodigometodoacrescimovalor)).getText().toString());
                                table.setCodigomoedanegociadaacrescimo(Integer.parseInt(((AutoCompleteTextView) findViewById(R.id.edtCodigomoedanegociadaacrescimo)).getText().toString()));
                                table.setValoracrescimomoedanacional(Float.parseFloat(((TextView) findViewById(R.id.edtValoracrescimomoedanacional)).getText().toString()));
                                table.setValoracrescimomoedanegociada(Float.parseFloat(((TextView) findViewById(R.id.edtValoracrescimomoedanegociada)).getText().toString()));
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMacrescimo_adi.this);
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

    private List<String> getAcrescimos()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_acrescimos");
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
