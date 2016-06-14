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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        table = new J34SiscomexFundLegal();
        dao = new FundLegalDAOImpl(this);
        setContentView(R.layout.activity_detail_fund_legal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            table = dao.find(it.getStringExtra("CODIGO"));
            ((TextView) findViewById(R.id.edtCodigo)).setText(table.getCodigo());
            ((TextView) findViewById(R.id.edtDescricao)).setText(table.getDescricao());
            ((TextView) findViewById(R.id.edtReg_tribut_1)).setText(table.getReg_tribut_1().toString());
            ((TextView) findViewById(R.id.edtReg_tribut_2)).setText(table.getReg_tribut_2().toString());
            ((TextView) findViewById(R.id.edtReg_tribut_3)).setText(table.getReg_tribut_3().toString());
            ((TextView) findViewById(R.id.edtReg_tribut_4)).setText(table.getReg_tribut_4().toString());
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
                                table.setCodigo(((TextView) findViewById(R.id.edtCodigo)).getText().toString());
                                table.setDescricao(((TextView) findViewById(R.id.edtDescricao)).getText().toString());
                                table.setReg_tribut_1(Integer.parseInt(((TextView) findViewById(R.id.edtReg_tribut_1)).getText().toString()));
                                table.setReg_tribut_2(Integer.parseInt(((TextView) findViewById(R.id.edtReg_tribut_2)).getText().toString()));
                                table.setReg_tribut_3(Integer.parseInt(((TextView) findViewById(R.id.edtReg_tribut_3)).getText().toString()));
                                table.setReg_tribut_4(Integer.parseInt(((TextView) findViewById(R.id.edtReg_tribut_4)).getText().toString()));
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


}
