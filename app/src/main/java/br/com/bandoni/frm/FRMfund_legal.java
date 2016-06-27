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
import br.com.bandoni.dao.implementation.FundLegalDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexFundLegal;

import br.com.bandoni.siscomexhelper.R;

public class FRMfund_legal extends AppCompatActivity 
{
    private J34SiscomexFundLegal table;
    private FundLegalDAOImpl dao;
    private int action;
    private TextView edtCodigo;
    private TextView edtDescricao;
    private TextView edtReg_tribut_1;
    private TextView edtReg_tribut_2;
    private TextView edtReg_tribut_3;
    private TextView edtReg_tribut_4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_fund_legal);
        //campos do formulario;
        edtCodigo = (TextView)findViewById(R.id.edtCodigo);
        edtDescricao = (TextView)findViewById(R.id.edtDescricao);
        edtReg_tribut_1 = (TextView)findViewById(R.id.edtReg_tribut_1);
        edtReg_tribut_2 = (TextView)findViewById(R.id.edtReg_tribut_2);
        edtReg_tribut_3 = (TextView)findViewById(R.id.edtReg_tribut_3);
        edtReg_tribut_4 = (TextView)findViewById(R.id.edtReg_tribut_4);
        dao = new FundLegalDAOImpl(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            try
            {
              table = dao.find(it.getStringExtra("CODIGO"));
            edtCodigo.setText(table.getCodigo());
            edtDescricao.setText(table.getDescricao());
            edtReg_tribut_1.setText(table.getReg_tribut_1().toString());
            edtReg_tribut_2.setText(table.getReg_tribut_2().toString());
            edtReg_tribut_3.setText(table.getReg_tribut_3().toString());
            edtReg_tribut_4.setText(table.getReg_tribut_4().toString());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtCodigo.setEnabled(false);
                  edtDescricao.setEnabled(false);
                  edtReg_tribut_1.setEnabled(false);
                  edtReg_tribut_2.setEnabled(false);
                  edtReg_tribut_3.setEnabled(false);
                  edtReg_tribut_4.setEnabled(false);
                }
                else
                {
                  edtCodigo.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMfund_legal.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexFundLegal();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_fund_legal, menu);
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
                                table.setCodigo(edtCodigo.getText().toString());
                                table.setDescricao(edtDescricao.getText().toString());
                                table.setReg_tribut_1(Integer.parseInt(edtReg_tribut_1.getText().toString()));
                                table.setReg_tribut_2(Integer.parseInt(edtReg_tribut_2.getText().toString()));
                                table.setReg_tribut_3(Integer.parseInt(edtReg_tribut_3.getText().toString()));
                                table.setReg_tribut_4(Integer.parseInt(edtReg_tribut_4.getText().toString()));
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMfund_legal.this);
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


}
