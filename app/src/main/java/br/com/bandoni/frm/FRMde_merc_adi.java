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
import br.com.bandoni.dao.implementation.DeMercAdiDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexDeMercAdi;

import br.com.bandoni.dao.commons.SQLiteDriver;
import java.util.List;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import br.com.bandoni.siscomexhelper.R;

public class FRMde_merc_adi extends AppCompatActivity 
{
    private J34SiscomexDeMercAdi table;
    private DeMercAdiDAOImpl dao;
    private int action;
    private TextView edtNumerodocumentocarga;
    private TextView edtNumeroadicao;
    private AutoCompleteTextView edtCodigopaiscertificado;
    private TextView edtNumerodeadmercosul;
    private TextView edtNumerodicertificado;
    private TextView edtNumeroitemcertificado;
    private TextView edtNumeroreadfinal;
    private TextView edtNumeroreadinicial;
    private TextView edtQuantidadeunidademercosul;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_de_merc_adi);
        //campos do formulario;
        edtNumerodocumentocarga = (TextView)findViewById(R.id.edtNumerodocumentocarga);
        edtNumeroadicao = (TextView)findViewById(R.id.edtNumeroadicao);
        edtCodigopaiscertificado = (AutoCompleteTextView)findViewById(R.id.edtCodigopaiscertificado);
        edtNumerodeadmercosul = (TextView)findViewById(R.id.edtNumerodeadmercosul);
        edtNumerodicertificado = (TextView)findViewById(R.id.edtNumerodicertificado);
        edtNumeroitemcertificado = (TextView)findViewById(R.id.edtNumeroitemcertificado);
        edtNumeroreadfinal = (TextView)findViewById(R.id.edtNumeroreadfinal);
        edtNumeroreadinicial = (TextView)findViewById(R.id.edtNumeroreadinicial);
        edtQuantidadeunidademercosul = (TextView)findViewById(R.id.edtQuantidadeunidademercosul);
         List<String> lstPaises = getPaises();
         ArrayAdapter<String> adpCodigopaiscertificado = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstPaises);
        edtCodigopaiscertificado.setAdapter(adpCodigopaiscertificado);
        dao = new DeMercAdiDAOImpl(this);
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
            edtCodigopaiscertificado.setText(table.getCodigopaiscertificado());
            edtNumerodeadmercosul.setText(table.getNumerodeadmercosul());
            edtNumerodicertificado.setText(table.getNumerodicertificado());
            edtNumeroitemcertificado.setText(table.getNumeroitemcertificado());
            edtNumeroreadfinal.setText(table.getNumeroreadfinal());
            edtNumeroreadinicial.setText(table.getNumeroreadinicial());
            edtQuantidadeunidademercosul.setText(table.getQuantidadeunidademercosul().toString());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtNumerodocumentocarga.setEnabled(false);
                  edtNumeroadicao.setEnabled(false);
                  edtCodigopaiscertificado.setEnabled(false);
                  edtNumerodeadmercosul.setEnabled(false);
                  edtNumerodicertificado.setEnabled(false);
                  edtNumeroitemcertificado.setEnabled(false);
                  edtNumeroreadfinal.setEnabled(false);
                  edtNumeroreadinicial.setEnabled(false);
                  edtQuantidadeunidademercosul.setEnabled(false);
                }
                else
                {
                  edtNumerodocumentocarga.setEnabled(false);
                  edtNumeroadicao.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMde_merc_adi.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexDeMercAdi();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_de_merc_adi, menu);
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
                                table.setCodigopaiscertificado(edtCodigopaiscertificado.getText().toString());
                                table.setNumerodeadmercosul(edtNumerodeadmercosul.getText().toString());
                                table.setNumerodicertificado(edtNumerodicertificado.getText().toString());
                                table.setNumeroitemcertificado(edtNumeroitemcertificado.getText().toString());
                                table.setNumeroreadfinal(edtNumeroreadfinal.getText().toString());
                                table.setNumeroreadinicial(edtNumeroreadinicial.getText().toString());
                                table.setQuantidadeunidademercosul(Float.parseFloat(edtQuantidadeunidademercosul.getText().toString()));
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMde_merc_adi.this);
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

    private List<String> getPaises()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_paises");
      driver.close();
      return lista;
    }

}
