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
import br.com.bandoni.dao.implementation.EmpresasDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexEmpresas;

import br.com.bandoni.dao.commons.SQLiteDriver;
import java.util.List;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import br.com.bandoni.siscomexhelper.R;

public class FRMempresas extends AppCompatActivity 
{
    private J34SiscomexEmpresas table;
    private EmpresasDAOImpl dao;
    private int action;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
         List<String> lstCidades = getCidades();
         ArrayAdapter<String> adpmunicipio = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstCidades);
         AutoCompleteTextView edtmunicipio = (AutoCompleteTextView)findViewById(R.id.edtMunicipio);
        edtmunicipio.setAdapter(adpmunicipio);
         ArrayAdapter<String> adpestado = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstCidades);
         AutoCompleteTextView edtestado = (AutoCompleteTextView)findViewById(R.id.edtEstado);
        edtestado.setAdapter(adpestado);
         List<String> lstPaises = getPaises();
         ArrayAdapter<String> adppais = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstPaises);
         AutoCompleteTextView edtpais = (AutoCompleteTextView)findViewById(R.id.edtPais);
        edtpais.setAdapter(adppais);
        table = new J34SiscomexEmpresas();
        dao = new EmpresasDAOImpl(this);
        setContentView(R.layout.activity_detail_empresas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            table = dao.find(it.getIntExtra("CODIGO",0));
            ((TextView) findViewById(R.id.edtCodigo)).setText(table.getCodigo().toString());
            ((TextView) findViewById(R.id.edtTipopesssoa)).setText(table.getTipopesssoa());
            ((TextView) findViewById(R.id.edtRazaosocial)).setText(table.getRazaosocial());
            ((TextView) findViewById(R.id.edtTelefone)).setText(table.getTelefone());
            ((TextView) findViewById(R.id.edtEndereco)).setText(table.getEndereco());
            ((TextView) findViewById(R.id.edtNumero)).setText(table.getNumero());
            ((TextView) findViewById(R.id.edtComplemento)).setText(table.getComplemento());
            ((TextView) findViewById(R.id.edtBairro)).setText(table.getBairro());
            ((TextView) findViewById(R.id.edtMunicipio)).setText(table.getMunicipio());
            ((TextView) findViewById(R.id.edtEstado)).setText(table.getEstado());
            ((TextView) findViewById(R.id.edtCep)).setText(table.getCep());
            ((TextView) findViewById(R.id.edtPais)).setText(table.getPais());
            ((TextView) findViewById(R.id.edtEmail)).setText(table.getEmail());
            ((TextView) findViewById(R.id.edtMunicipioex)).setText(table.getMunicipioex());
            ((TextView) findViewById(R.id.edtEstadoex)).setText(table.getEstadoex());
            ((TextView) findViewById(R.id.edtCnpj)).setText(table.getCnpj());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_empresas, menu);
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
                                table.setCodigo(Integer.parseInt(((TextView) findViewById(R.id.edtCodigo)).getText().toString()));
                                table.setTipopesssoa(((TextView) findViewById(R.id.edtTipopesssoa)).getText().toString());
                                table.setRazaosocial(((TextView) findViewById(R.id.edtRazaosocial)).getText().toString());
                                table.setTelefone(((TextView) findViewById(R.id.edtTelefone)).getText().toString());
                                table.setEndereco(((TextView) findViewById(R.id.edtEndereco)).getText().toString());
                                table.setNumero(((TextView) findViewById(R.id.edtNumero)).getText().toString());
                                table.setComplemento(((TextView) findViewById(R.id.edtComplemento)).getText().toString());
                                table.setBairro(((TextView) findViewById(R.id.edtBairro)).getText().toString());
                                table.setMunicipio(((AutoCompleteTextView) findViewById(R.id.edtMunicipio)).getText().toString());
                                table.setEstado(((AutoCompleteTextView) findViewById(R.id.edtEstado)).getText().toString());
                                table.setCep(((TextView) findViewById(R.id.edtCep)).getText().toString());
                                table.setPais(((AutoCompleteTextView) findViewById(R.id.edtPais)).getText().toString());
                                table.setEmail(((TextView) findViewById(R.id.edtEmail)).getText().toString());
                                table.setMunicipioex(((TextView) findViewById(R.id.edtMunicipioex)).getText().toString());
                                table.setEstadoex(((TextView) findViewById(R.id.edtEstadoex)).getText().toString());
                                table.setCnpj(((TextView) findViewById(R.id.edtCnpj)).getText().toString());
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

    private List<String> getCidades()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_cidades");
      driver.close();
      return lista;
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
