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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
         List<String> lstPaises = getPaises();
         ArrayAdapter<String> adpcodigoPaisCertificado = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstPaises);
         AutoCompleteTextView edtcodigoPaisCertificado = (AutoCompleteTextView)findViewById(R.id.edtCodigopaiscertificado);
        edtcodigoPaisCertificado.setAdapter(adpcodigoPaisCertificado);
        table = new J34SiscomexDeMercAdi();
        dao = new DeMercAdiDAOImpl(this);
        setContentView(R.layout.activity_detail_de_merc_adi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            table = dao.find(it.getStringExtra("NUMERODOCUMENTOCARGA"),it.getStringExtra("NUMEROADICAO"));
            ((TextView) findViewById(R.id.edtNumerodocumentocarga)).setText(table.getNumerodocumentocarga());
            ((TextView) findViewById(R.id.edtNumeroadicao)).setText(table.getNumeroadicao());
            ((TextView) findViewById(R.id.edtCodigopaiscertificado)).setText(table.getCodigopaiscertificado());
            ((TextView) findViewById(R.id.edtNumerodeadmercosul)).setText(table.getNumerodeadmercosul());
            ((TextView) findViewById(R.id.edtNumerodicertificado)).setText(table.getNumerodicertificado());
            ((TextView) findViewById(R.id.edtNumeroitemcertificado)).setText(table.getNumeroitemcertificado());
            ((TextView) findViewById(R.id.edtNumeroreadfinal)).setText(table.getNumeroreadfinal());
            ((TextView) findViewById(R.id.edtNumeroreadinicial)).setText(table.getNumeroreadinicial());
            ((TextView) findViewById(R.id.edtQuantidadeunidademercosul)).setText(table.getQuantidadeunidademercosul().toString());
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
                                table.setNumerodocumentocarga(((TextView) findViewById(R.id.edtNumerodocumentocarga)).getText().toString());
                                table.setNumeroadicao(((TextView) findViewById(R.id.edtNumeroadicao)).getText().toString());
                                table.setCodigopaiscertificado(((AutoCompleteTextView) findViewById(R.id.edtCodigopaiscertificado)).getText().toString());
                                table.setNumerodeadmercosul(((TextView) findViewById(R.id.edtNumerodeadmercosul)).getText().toString());
                                table.setNumerodicertificado(((TextView) findViewById(R.id.edtNumerodicertificado)).getText().toString());
                                table.setNumeroitemcertificado(((TextView) findViewById(R.id.edtNumeroitemcertificado)).getText().toString());
                                table.setNumeroreadfinal(((TextView) findViewById(R.id.edtNumeroreadfinal)).getText().toString());
                                table.setNumeroreadinicial(((TextView) findViewById(R.id.edtNumeroreadinicial)).getText().toString());
                                table.setQuantidadeunidademercosul(Float.parseFloat(((TextView) findViewById(R.id.edtQuantidadeunidademercosul)).getText().toString()));
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
