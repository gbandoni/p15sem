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
import br.com.bandoni.dao.implementation.UsuariosDAOImpl;
import br.com.bandoni.dao.tables.J34SiscomexUsuarios;

import br.com.bandoni.siscomexhelper.R;

public class FRMusuarios extends AppCompatActivity 
{
    private J34SiscomexUsuarios table;
    private UsuariosDAOImpl dao;
    private int action;
    private TextView edtUsu_codigo;
    private TextView edtUsu_nome;
    private TextView edtUsu_login;
    private TextView edtUsu_senha;
    private TextView edtUsu_adm;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_usuarios);
        //campos do formulario;
        edtUsu_codigo = (TextView)findViewById(R.id.edtUsu_codigo);
        edtUsu_nome = (TextView)findViewById(R.id.edtUsu_nome);
        edtUsu_login = (TextView)findViewById(R.id.edtUsu_login);
        edtUsu_senha = (TextView)findViewById(R.id.edtUsu_senha);
        edtUsu_adm = (TextView)findViewById(R.id.edtUsu_adm);
        dao = new UsuariosDAOImpl(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent it = getIntent();
        action = it.getIntExtra("ACTION", ActionReference.ACTION_NONE);
        if (action != ActionReference.ACTION_INCLUDE)
        {
            try
            {
              table = dao.find(it.getIntExtra("USU_CODIGO",0));
            edtUsu_codigo.setText(table.getUsu_codigo().toString());
            edtUsu_nome.setText(table.getUsu_nome());
            edtUsu_login.setText(table.getUsu_login());
            edtUsu_senha.setText(table.getUsu_senha());
            edtUsu_adm.setText(table.getUsu_adm().toString());
                if (action != ActionReference.ACTION_UPDATE)
                {
                  edtUsu_codigo.setEnabled(false);
                  edtUsu_nome.setEnabled(false);
                  edtUsu_login.setEnabled(false);
                  edtUsu_senha.setEnabled(false);
                  edtUsu_adm.setEnabled(false);
                }
                else
                {
                  edtUsu_codigo.setEnabled(false);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(FRMusuarios.this, "Exceção: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
          table = new J34SiscomexUsuarios();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // associa a atividade a um menu.
        getMenuInflater().inflate(R.menu.menu_detail_usuarios, menu);
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
                                table.setUsu_codigo(Integer.parseInt(edtUsu_codigo.getText().toString()));
                                table.setUsu_nome(edtUsu_nome.getText().toString());
                                table.setUsu_login(edtUsu_login.getText().toString());
                                table.setUsu_senha(edtUsu_senha.getText().toString());
                                table.setUsu_adm(Integer.parseInt(edtUsu_adm.getText().toString()));
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
                AlertDialog.Builder builder = new AlertDialog.Builder(FRMusuarios.this);
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
