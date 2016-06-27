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
import br.com.bandoni.dao.implementation.TributoAdiDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexTributoAdi;

import br.com.bandoni.dao.commons.SQLiteDriver;
import java.util.List;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import br.com.bandoni.siscomexhelper.R;

public class FRMtributo_adi extends AppCompatActivity 
{
    private J34SiscomexTributoAdi table;
    private TributoAdiDAOImpl dao;
    private int action;
    private TextView edtNumerodocumentocarga;
    private TextView edtNumeroadicao;
    private TextView edtCodigoreceitaimposto;
    private TextView edtCodigotipoaliquotaipt;
    private TextView edtCodigotipobeneficioipi;
    private TextView edtCodigotipodireito;
    private AutoCompleteTextView edtCodigotiporecipiente;
    private TextView edtNomeunidadeespecificaaliquotaipt;
    private TextView edtNumeronotacomplementartipi;
    private TextView edtPercentualaliquotaacordotarifario;
    private TextView edtPercentualaliquotanormaladval;
    private TextView edtPercentualaliquotareduzida;
    private TextView edtPercentualreducaoipt;
    private TextView edtQuantidademlrecipiente;
    private TextView edtQuantidademercadoriaunidadealiquotaespecifica;
    private TextView edtValoraliquotaespecificaipt;
    private TextView edtValorbasecalculoadval;
    private TextView edtValorcalculadoiiactarifario;
    private TextView edtValorcalculoiptespecifica;
    private TextView edtValorcalculoiptadval;
    private TextView edtValoriptarecolher;
    private TextView edtValorimpostodevido;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tributo_adi);
        //campos do formulario;
        edtNumerodocumentocarga = (TextView)findViewById(R.id.edtNumerodocumentocarga);
        edtNumeroadicao = (TextView)findViewById(R.id.edtNumeroadicao);
        edtCodigoreceitaimposto = (TextView)findViewById(R.id.edtCodigoreceitaimposto);
        edtCodigotipoaliquotaipt = (TextView)findViewById(R.id.edtCodigotipoaliquotaipt);
        edtCodigotipobeneficioipi = (TextView)findViewById(R.id.edtCodigotipobeneficioipi);
        edtCodigotipodireito = (TextView)findViewById(R.id.edtCodigotipodireito);
        edtCodigotiporecipiente = (AutoCompleteTextView)findViewById(R.id.edtCodigotiporecipiente);
        edtNomeunidadeespecificaaliquotaipt = (TextView)findViewById(R.id.edtNomeunidadeespecificaaliquotaipt);
        edtNumeronotacomplementartipi = (TextView)findViewById(R.id.edtNumeronotacomplementartipi);
        edtPercentualaliquotaacordotarifario = (TextView)findViewById(R.id.edtPercentualaliquotaacordotarifario);
        edtPercentualaliquotanormaladval = (TextView)findViewById(R.id.edtPercentualaliquotanormaladval);
        edtPercentualaliquotareduzida = (TextView)findViewById(R.id.edtPercentualaliquotareduzida);
        edtPercentualreducaoipt = (TextView)findViewById(R.id.edtPercentualreducaoipt);
        edtQuantidademlrecipiente = (TextView)findViewById(R.id.edtQuantidademlrecipiente);
        edtQuantidademercadoriaunidadealiquotaespecifica = (TextView)findViewById(R.id.edtQuantidademercadoriaunidadealiquotaespecifica);
        edtValoraliquotaespecificaipt = (TextView)findViewById(R.id.edtValoraliquotaespecificaipt);
        edtValorbasecalculoadval = (TextView)findViewById(R.id.edtValorbasecalculoadval);
        edtValorcalculadoiiactarifario = (TextView)findViewById(R.id.edtValorcalculadoiiactarifario);
        edtValorcalculoiptespecifica = (TextView)findViewById(R.id.edtValorcalculoiptespecifica);
        edtValorcalculoiptadval = (TextView)findViewById(R.id.edtValorcalculoiptadval);
        edtValoriptarecolher = (TextView)findViewById(R.id.edtValoriptarecolher);
        edtValorimpostodevido = (TextView)findViewById(R.id.edtValorimpostodevido);
         List<String> lstTipo_recipiente = getTipo_recipiente();
         ArrayAdapter<String> adpCodigotiporecipiente = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, lstTipo_recipiente);
        edtCodigotiporecipiente.setAdapter(adpCodigotiporecipiente);
        dao = new TributoAdiDAOImpl(this);
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
            edtCodigoreceitaimposto.setText(table.getCodigoreceitaimposto());
            edtCodigotipoaliquotaipt.setText(table.getCodigotipoaliquotaipt());
            edtCodigotipobeneficioipi.setText(table.getCodigotipobeneficioipi());
            edtCodigotipodireito.setText(table.getCodigotipodireito());
            edtCodigotiporecipiente.setText(table.getCodigotiporecipiente());
            edtNomeunidadeespecificaaliquotaipt.setText(table.getNomeunidadeespecificaaliquotaipt());
            edtNumeronotacomplementartipi.setText(table.getNumeronotacomplementartipi().toString());
            edtPercentualaliquotaacordotarifario.setText(table.getPercentualaliquotaacordotarifario().toString());
            edtPercentualaliquotanormaladval.setText(table.getPercentualaliquotanormaladval().toString());
            edtPercentualaliquotareduzida.setText(table.getPercentualaliquotareduzida().toString());
            edtPercentualreducaoipt.setText(table.getPercentualreducaoipt().toString());
            edtQuantidademlrecipiente.setText(table.getQuantidademlrecipiente().toString());
            edtQuantidademercadoriaunidadealiquotaespecifica.setText(table.getQuantidademercadoriaunidadealiquotaespecifica().toString());
            edtValoraliquotaespecificaipt.setText(table.getValoraliquotaespecificaipt().toString());
            edtValorbasecalculoadval.setText(table.getValorbasecalculoadval().toString());
            edtValorcalculadoiiactarifario.setText(table.getValorcalculadoiiactarifario().toString());
            edtValorcalculoiptespecifica.setText(table.getValorcalculoiptespecifica().toString());
            edtValorcalculoiptadval.setText(table.getValorcalculoiptadval().toString());
            edtValoriptarecolher.setText(table.getValoriptarecolher().toString());
            edtValorimpostodevido.setText(table.getValorimpostodevido().toString());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtNumerodocumentocarga.setEnabled(false);
                  edtNumeroadicao.setEnabled(false);
                  edtCodigoreceitaimposto.setEnabled(false);
                  edtCodigotipoaliquotaipt.setEnabled(false);
                  edtCodigotipobeneficioipi.setEnabled(false);
                  edtCodigotipodireito.setEnabled(false);
                  edtCodigotiporecipiente.setEnabled(false);
                  edtNomeunidadeespecificaaliquotaipt.setEnabled(false);
                  edtNumeronotacomplementartipi.setEnabled(false);
                  edtPercentualaliquotaacordotarifario.setEnabled(false);
                  edtPercentualaliquotanormaladval.setEnabled(false);
                  edtPercentualaliquotareduzida.setEnabled(false);
                  edtPercentualreducaoipt.setEnabled(false);
                  edtQuantidademlrecipiente.setEnabled(false);
                  edtQuantidademercadoriaunidadealiquotaespecifica.setEnabled(false);
                  edtValoraliquotaespecificaipt.setEnabled(false);
                  edtValorbasecalculoadval.setEnabled(false);
                  edtValorcalculadoiiactarifario.setEnabled(false);
                  edtValorcalculoiptespecifica.setEnabled(false);
                  edtValorcalculoiptadval.setEnabled(false);
                  edtValoriptarecolher.setEnabled(false);
                  edtValorimpostodevido.setEnabled(false);
                }
                else
                {
                  edtNumerodocumentocarga.setEnabled(false);
                  edtNumeroadicao.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMtributo_adi.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexTributoAdi();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_tributo_adi, menu);
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
                                table.setCodigoreceitaimposto(edtCodigoreceitaimposto.getText().toString());
                                table.setCodigotipoaliquotaipt(edtCodigotipoaliquotaipt.getText().toString());
                                table.setCodigotipobeneficioipi(edtCodigotipobeneficioipi.getText().toString());
                                table.setCodigotipodireito(edtCodigotipodireito.getText().toString());
                                table.setCodigotiporecipiente(edtCodigotiporecipiente.getText().toString());
                                table.setNomeunidadeespecificaaliquotaipt(edtNomeunidadeespecificaaliquotaipt.getText().toString());
                                table.setNumeronotacomplementartipi(Float.parseFloat(edtNumeronotacomplementartipi.getText().toString()));
                                table.setPercentualaliquotaacordotarifario(Float.parseFloat(edtPercentualaliquotaacordotarifario.getText().toString()));
                                table.setPercentualaliquotanormaladval(Float.parseFloat(edtPercentualaliquotanormaladval.getText().toString()));
                                table.setPercentualaliquotareduzida(Float.parseFloat(edtPercentualaliquotareduzida.getText().toString()));
                                table.setPercentualreducaoipt(Float.parseFloat(edtPercentualreducaoipt.getText().toString()));
                                table.setQuantidademlrecipiente(Float.parseFloat(edtQuantidademlrecipiente.getText().toString()));
                                table.setQuantidademercadoriaunidadealiquotaespecifica(Float.parseFloat(edtQuantidademercadoriaunidadealiquotaespecifica.getText().toString()));
                                table.setValoraliquotaespecificaipt(Float.parseFloat(edtValoraliquotaespecificaipt.getText().toString()));
                                table.setValorbasecalculoadval(Float.parseFloat(edtValorbasecalculoadval.getText().toString()));
                                table.setValorcalculadoiiactarifario(Float.parseFloat(edtValorcalculadoiiactarifario.getText().toString()));
                                table.setValorcalculoiptespecifica(Float.parseFloat(edtValorcalculoiptespecifica.getText().toString()));
                                table.setValorcalculoiptadval(Float.parseFloat(edtValorcalculoiptadval.getText().toString()));
                                table.setValoriptarecolher(Float.parseFloat(edtValoriptarecolher.getText().toString()));
                                table.setValorimpostodevido(Float.parseFloat(edtValorimpostodevido.getText().toString()));
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMtributo_adi.this);
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

    private List<String> getTipo_recipiente()
    {
      SQLiteDriver driver = SQLiteDriver.getInstance(getApplicationContext());
      driver.open(false);
      List<String> lista = driver.getBrowserFromTable("j34_siscomex_tipo_recipiente");
      driver.close();
      return lista;
    }

}
