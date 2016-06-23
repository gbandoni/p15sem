package br.com.bandoni.frm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.*;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import br.com.bandoni.dao.commons.ActionReference;
import br.com.bandoni.dao.commons.DAOFieldGroups;
import br.com.bandoni.dao.commons.SQLiteDriver;
import br.com.bandoni.siscomexhelper.R;

public class BRWdoc_carga_di extends AppCompatActivity
{

    private final String tablename = "j34_siscomex_doc_carga_di";
    private ListView listView;
    private List<String> primarykeys = DAOFieldGroups.getTableBrowserColumns(tablename);
    private ArrayList<ArrayList<String>> itens;
    private int selectedItem;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_doc_carga_di);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.listBrowser);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        fillData();

        SearchView searchView = (SearchView) findViewById(R.id.edtsearch);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String query)
            {
                callSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                callSearch(newText);
                return true;
            }

            public void callSearch(String query)
            {
                for (int i=0;i< itens.size();i++)
                {
                    if (itens.get(i).get(0).startsWith(query))
                    {
                        selectedItem = i;
                        for(int j=0; j<listView.getAdapter().getCount();j++)
                        {
                            listView.setItemChecked(j,j==selectedItem);
                        }
                        return;
                    }
                }
            }
        });

    }

    private ArrayList<String> buildList(ArrayList<ArrayList<String>> list)
    {
        ArrayList<String> resposta = new ArrayList<String>();
        for (int i=0;i< list.size();i++)
        {
            String linha = "";
            for (int j=0;j< list.get(i).size();j++)
            {
                linha+="-"+list.get(i).get(j);
            }
            resposta.add(linha.substring(1));
        }
        return resposta;
    }

    private void fillData()
    {
        SQLiteDriver databaseAccess = SQLiteDriver.getInstance(this);
        databaseAccess.open(false);
        itens = databaseAccess.getMatrixDataFromTable(tablename);
        listView = (ListView) findViewById(R.id.listBrowser);
        databaseAccess.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getBaseContext(), android.R.layout.simple_list_item_single_choice,buildList(itens));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
		 selectedItem = position;
              for(int i=0; i<listView.getAdapter().getCount();i++)
                 {
                   listView.setItemChecked(i,i==selectedItem);
                 }
            }
        });

        selectedItem = -1;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_browse_doc_carga_di, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_create)
        {
            Intent i = new Intent(this,FRMdoc_carga_di.class);
            i.putExtra("ACTION",ActionReference.ACTION_INCLUDE);
            i.putExtra("READONLY",false);
            startActivity(i);
            fillData();
            return true;
        }
        else
        {
            if (selectedItem <= 0)
            {
                Toast.makeText(getBaseContext(),"Selecione um registro antes",Toast.LENGTH_LONG).show();
                return true;
            }
        }

        if (id == R.id.action_update)
        {
            Intent i = new Intent(this,FRMdoc_carga_di.class);
            int ipos = 0;
            i.putExtra("ACTION",ActionReference.ACTION_UPDATE);
            i.putExtra("READONLY",false);
            for (String campo:primarykeys)
            {
                i.putExtra(campo,itens.get(selectedItem).get(ipos).toUpperCase());
                ipos++;
            }
            startActivity(i);
            fillData();
            return true;
        }

        if (id == R.id.action_delete)
        {
            Intent i = new Intent(this,FRMdoc_carga_di.class);
            int ipos = 0;
            i.putExtra("ACTION",ActionReference.ACTION_DELETE);
            i.putExtra("READONLY",true);
            for (String campo:primarykeys)
            {
                i.putExtra(campo,itens.get(selectedItem).get(ipos));
                ipos++;
            }
            startActivity(i);
            fillData();
            return true;
        }

        if (id == R.id.action_view)
        {
            Intent i = new Intent(this,FRMdoc_carga_di.class);
            int ipos = 0;
            i.putExtra("ACTION",ActionReference.ACTION_VIEW);
            i.putExtra("READONLY",true);
            for (String campo:primarykeys)
            {
                i.putExtra(campo,itens.get(selectedItem).get(ipos));
                ipos++;
            }
            startActivity(i);
            fillData();
            return true;
        }

        if (id == R.id.action_back)
        {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
