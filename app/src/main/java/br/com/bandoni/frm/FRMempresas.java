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
    private TextView edtCodigo;
    private TextView edtTipopesssoa;
    private TextView edtRazaosocial;
    private TextView edtTelefone;
    private TextView edtEndereco;
    private TextView edtNumero;
    private TextView edtComplemento;
    private TextView edtBairro;
    private AutoCompleteTextView edtMunicipio;
    private AutoCompleteTextView edtEstado;
    private TextView edtCep;
    private AutoCompleteTextView edtPais;
    private TextView edtEmail;
    private TextView edtMunicipioex;
    private TextView edtEstadoex;
    private TextView edtCnpj;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_empresas);
        //campos do formulario;
        edtCodigo = (TextView)findViewById(R.id.edtCodigo);
        edtTipopesssoa = (TextView)findViewById(R.id.edtTipopesssoa);
        edtRazaosocial = (TextView)findViewById(R.id.edtRazaosocial);
        edtTelefone = (TextView)findViewById(R.id.edtTelefone);
        edtEndereco = (TextView)findViewById(R.id.edtEndereco);
        edtNumero = (TextView)findViewById(R.id.edtNumero);
        edtComplemento = (TextView)findViewById(R.id.edtComplemento);
        edtBairro = (TextView)findViewById(R.id.edtBairro);
        edtMunicipio = (AutoCompleteTextView)findViewById(R.id.edtMunicipio);
        edtEstado = (AutoCompleteTextView)findViewById(R.id.edtEstado);
        edtCep = (TextView)findViewById(R.id.edtCep);
        edtPais = (AutoCompleteTextView)findViewById(R.id.edtPais);
        edtEmail = (TextView)findViewById(R.id.edtEmail);
        edtMunicipioex = (TextView)findViewById(R.id.edtMunicipioex);
        edtEstadoex = (TextView)findViewById(R.id.edtEstadoex);
        edtCnpj = (TextView)findViewById(R.id.edtCnpj);
         List<String> lstCidades = getCidades();
         ArrayAdapter<String> adpMunicipio = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstCidades);
        edtMunicipio.setAdapter(adpMunicipio);
         ArrayAdapter<String> adpEstado = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstCidades);
        edtEstado.setAdapter(adpEstado);
         List<String> lstPaises = getPaises();
         ArrayAdapter<String> adpPais = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstPaises);
        edtPais.setAdapter(adpPais);
        dao = new EmpresasDAOImpl(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            try
            {
              table = dao.find(it.getIntExtra("CODIGO",0));
            edtCodigo.setText(table.getCodigo().toString());
            edtTipopesssoa.setText(table.getTipopesssoa());
            edtRazaosocial.setText(table.getRazaosocial());
            edtTelefone.setText(table.getTelefone());
            edtEndereco.setText(table.getEndereco());
            edtNumero.setText(table.getNumero());
            edtComplemento.setText(table.getComplemento());
            edtBairro.setText(table.getBairro());
            edtMunicipio.setText(table.getMunicipio());
            edtEstado.setText(table.getEstado());
            edtCep.setText(table.getCep());
            edtPais.setText(table.getPais());
            edtEmail.setText(table.getEmail());
            edtMunicipioex.setText(table.getMunicipioex());
            edtEstadoex.setText(table.getEstadoex());
            edtCnpj.setText(table.getCnpj());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtCodigo.setEnabled(false);
                  edtTipopesssoa.setEnabled(false);
                  edtRazaosocial.setEnabled(false);
                  edtTelefone.setEnabled(false);
                  edtEndereco.setEnabled(false);
                  edtNumero.setEnabled(false);
                  edtComplemento.setEnabled(false);
                  edtBairro.setEnabled(false);
                  edtMunicipio.setEnabled(false);
                  edtEstado.setEnabled(false);
                  edtCep.setEnabled(false);
                  edtPais.setEnabled(false);
                  edtEmail.setEnabled(false);
                  edtMunicipioex.setEnabled(false);
                  edtEstadoex.setEnabled(false);
                  edtCnpj.setEnabled(false);
                }
                else
                {
                  edtCodigo.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMempresas.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexEmpresas();
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
                                table.setCodigo(Integer.parseInt(edtCodigo.getText().toString()));
                                table.setTipopesssoa(edtTipopesssoa.getText().toString());
                                table.setRazaosocial(edtRazaosocial.getText().toString());
                                table.setTelefone(edtTelefone.getText().toString());
                                table.setEndereco(edtEndereco.getText().toString());
                                table.setNumero(edtNumero.getText().toString());
                                table.setComplemento(edtComplemento.getText().toString());
                                table.setBairro(edtBairro.getText().toString());
                                table.setMunicipio(edtMunicipio.getText().toString());
                                table.setEstado(edtEstado.getText().toString());
                                table.setCep(edtCep.getText().toString());
                                table.setPais(edtPais.getText().toString());
                                table.setEmail(edtEmail.getText().toString());
                                table.setMunicipioex(edtMunicipioex.getText().toString());
                                table.setEstadoex(edtEstadoex.getText().toString());
                                table.setCnpj(edtCnpj.getText().toString());
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMempresas.this);
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
