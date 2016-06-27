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
    private TextView edtNumerodocumentocarga;
    private TextView edtNumeroadicao;
    private AutoCompleteTextView edtCodigometodoacrescimovalor;
    private AutoCompleteTextView edtCodigomoedanegociadaacrescimo;
    private TextView edtValoracrescimomoedanacional;
    private TextView edtValoracrescimomoedanegociada;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_acrescimo_adi);
        //campos do formulario;
        edtNumerodocumentocarga = (TextView)findViewById(R.id.edtNumerodocumentocarga);
        edtNumeroadicao = (TextView)findViewById(R.id.edtNumeroadicao);
        edtCodigometodoacrescimovalor = (AutoCompleteTextView)findViewById(R.id.edtCodigometodoacrescimovalor);
        edtCodigomoedanegociadaacrescimo = (AutoCompleteTextView)findViewById(R.id.edtCodigomoedanegociadaacrescimo);
        edtValoracrescimomoedanacional = (TextView)findViewById(R.id.edtValoracrescimomoedanacional);
        edtValoracrescimomoedanegociada = (TextView)findViewById(R.id.edtValoracrescimomoedanegociada);
         List<String> lstAcrescimos = getAcrescimos();
         ArrayAdapter<String> adpCodigometodoacrescimovalor = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstAcrescimos);
        edtCodigometodoacrescimovalor.setAdapter(adpCodigometodoacrescimovalor);
         List<String> lstMoedas = getMoedas();
         ArrayAdapter<String> adpCodigomoedanegociadaacrescimo = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstMoedas);
        edtCodigomoedanegociadaacrescimo.setAdapter(adpCodigomoedanegociadaacrescimo);
        dao = new AcrescimoAdiDAOImpl(this);
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
            edtCodigometodoacrescimovalor.setText(table.getCodigometodoacrescimovalor());
            edtCodigomoedanegociadaacrescimo.setText(table.getCodigomoedanegociadaacrescimo().toString());
            edtValoracrescimomoedanacional.setText(table.getValoracrescimomoedanacional().toString());
            edtValoracrescimomoedanegociada.setText(table.getValoracrescimomoedanegociada().toString());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtNumerodocumentocarga.setEnabled(false);
                  edtNumeroadicao.setEnabled(false);
                  edtCodigometodoacrescimovalor.setEnabled(false);
                  edtCodigomoedanegociadaacrescimo.setEnabled(false);
                  edtValoracrescimomoedanacional.setEnabled(false);
                  edtValoracrescimomoedanegociada.setEnabled(false);
                }
                else
                {
                  edtNumerodocumentocarga.setEnabled(false);
                  edtNumeroadicao.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMacrescimo_adi.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexAcrescimoAdi();
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
                                table.setNumerodocumentocarga(edtNumerodocumentocarga.getText().toString());
                                table.setNumeroadicao(edtNumeroadicao.getText().toString());
                                table.setCodigometodoacrescimovalor(edtCodigometodoacrescimovalor.getText().toString());
                                table.setCodigomoedanegociadaacrescimo(Integer.parseInt(edtCodigomoedanegociadaacrescimo.getText().toString()));
                                table.setValoracrescimomoedanacional(Float.parseFloat(edtValoracrescimomoedanacional.getText().toString()));
                                table.setValoracrescimomoedanegociada(Float.parseFloat(edtValoracrescimomoedanegociada.getText().toString()));
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
