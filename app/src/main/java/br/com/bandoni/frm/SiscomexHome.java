package br.com.bandoni.frm;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.bandoni.lib.ExpandableListAdapter;
import br.com.bandoni.siscomexhelper.R;

public class SiscomexHome extends AppCompatActivity
{

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.siscomex_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener()
        {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id)
            {
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener()
        {
            @Override
            public void onGroupExpand(int groupPosition)
            {
                //fecha todos os grupos exceto o atual
                for (int i = 0; i < listDataHeader.size(); i++)
                {
                    if (groupPosition != i)
                    {
                        expListView.collapseGroup(i);
                    }
                }

                //   Toast.makeText(getApplicationContext(), listDataHeader.get(groupPosition) + " Expanded",
                //           Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener()
        {
            @Override
            public void onGroupCollapse(int groupPosition)
            {
                // Toast.makeText(getApplicationContext(), listDataHeader.get(groupPosition) + " Collapsed",
                //         Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener()
        {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id)
            {
                if ((groupPosition == 0) && (childPosition == 0))
                {
                    openBRWempresas();      // Cadastro de empresas
                }
                if ((groupPosition == 1) && (childPosition == 0))
                {
                    openBRWabrangencia_ncm();      // Código da Abrangência NCM
                }
                if ((groupPosition == 1) && (childPosition == 1))
                {
                    openBRWatrib_ncm();      // Atributos do NCM
                }
                if ((groupPosition == 1) && (childPosition == 2))
                {
                    openBRWespec_ncm();      // Cadastros de Especificações de NCM
                }
                if ((groupPosition == 1) && (childPosition == 3))
                {
                    openBRWesp_ncm_adi();      // Especificação da NCM da Adição
                }
                if ((groupPosition == 1) && (childPosition == 4))
                {
                    openBRWnbm();      // Nomenclatura Brasileira de Mercadorias
                }
                if ((groupPosition == 1) && (childPosition == 5))
                {
                    openBRWncm();      // Nomenclatura Comum do MERCOSUL
                }
                if ((groupPosition == 2) && (childPosition == 0))
                {
                    openBRWacordo_aladi();      // Acordo ALADI
                }
                if ((groupPosition == 2) && (childPosition == 1))
                {
                    openBRWde_merc_adi();      // IDentificação do Certificado MERCOSUL
                }
                if ((groupPosition == 2) && (childPosition == 2))
                {
                    openBRWinfo_mercosul_di();      // Declaração de Exportação para o MERCOSUL
                }
                if ((groupPosition == 2) && (childPosition == 3))
                {
                    openBRWnaladi_ncca();      // Acordo NALADI NCCA
                }
                if ((groupPosition == 2) && (childPosition == 4))
                {
                    openBRWnaladi_sh();      // Cadastro NALADI SH
                }
                if ((groupPosition == 3) && (childPosition == 0))
                {
                    openBRWdi();      // Declaração de Importação
                }
                if ((groupPosition == 3) && (childPosition == 1))
                {
                    openBRWimpostos_di();      // Impostos do Documento de Importação
                }
                if ((groupPosition == 3) && (childPosition == 2))
                {
                    openBRWorigem_di();      // Código da Origem DI
                }
                if ((groupPosition == 3) && (childPosition == 3))
                {
                    openBRWprocesso_di();      // Processos DI
                }
                if ((groupPosition == 4) && (childPosition == 0))
                {
                    openBRWadicao();      // Adições (itens) da Declaração de Importação
                }
                if ((groupPosition == 4) && (childPosition == 1))
                {
                    openBRWarmazem_di();      // Locais do Armazenamento da adição
                }
                if ((groupPosition == 4) && (childPosition == 2))
                {
                    openBRWdeducao_adi();      // Deduções de Impostos da Adição
                }
                if ((groupPosition == 4) && (childPosition == 3))
                {
                    openBRWdestaquencm_adi();      // Destaque das NCMs da adição
                }
                if ((groupPosition == 4) && (childPosition == 4))
                {
                    openBRWdoc_carga_di();      // Volumes da Adição
                }
                if ((groupPosition == 4) && (childPosition == 5))
                {
                    openBRWdoc_vinculado_adi();      // Documentos Vinculados a Adição
                }
                if ((groupPosition == 4) && (childPosition == 6))
                {
                    openBRWmercadoria_adi();      // Mercadorias da Adiçâo
                }
                if ((groupPosition == 4) && (childPosition == 7))
                {
                    openBRWtarifas_adi();      // Tarifas da Adiçao
                }
                if ((groupPosition == 4) && (childPosition == 8))
                {
                    openBRWtributo_adi();      // Tributos de Adição
                }
                if ((groupPosition == 5) && (childPosition == 0))
                {
                    openBRWmoedas();      // Moedas
                }
                if ((groupPosition == 5) && (childPosition == 1))
                {
                    openBRWbancos();      // Bancos da FEBRABAN
                }
                if ((groupPosition == 5) && (childPosition == 2))
                {
                    openBRWacrescimos();      // Tipos de Acréscimos
                }
                if ((groupPosition == 5) && (childPosition == 3))
                {
                    openBRWcompensacao_di();      // Valores de Restituições de Impostos
                }
                if ((groupPosition == 5) && (childPosition == 4))
                {
                    openBRWdeducoes();      // Tipos de Dedução
                }
                if ((groupPosition == 5) && (childPosition == 5))
                {
                    openBRWfund_legal();      // Fundamentação Legal de Tributos
                }
                if ((groupPosition == 5) && (childPosition == 6))
                {
                    openBRWinst_financeira();      // Instituições Financeiras Internacionais
                }
                if ((groupPosition == 5) && (childPosition == 7))
                {
                    openBRWregime_tribut();      // Regimes de Tributação
                }
                if ((groupPosition == 5) && (childPosition == 8))
                {
                    openBRWtab_orcamentaria();      // Tipos de Impostos a pagar
                }
                if ((groupPosition == 6) && (childPosition == 0))
                {
                    openBRWestado();      // Unidades da Federação
                }
                if ((groupPosition == 6) && (childPosition == 1))
                {
                    openBRWcidades();      // Municípios Brasileiros
                }
                if ((groupPosition == 6) && (childPosition == 2))
                {
                    openBRWpaises();      // Cadastro Países
                }
                if ((groupPosition == 7) && (childPosition == 0))
                {
                    openBRWlocalidadeembarque();      // Cadastro das Localidades de Embarque
                }
                if ((groupPosition == 7) && (childPosition == 1))
                {
                    openBRWacrescimo_adi();      // Descrição da Localização da Adição
                }
                if ((groupPosition == 7) && (childPosition == 2))
                {
                    openBRWorgaosurf();      // Cadastro de Órgãos da Receita Federal
                }
                if ((groupPosition == 7) && (childPosition == 3))
                {
                    openBRWrecintoalfandegado();      // Recintos Alfandegários
                }
                if ((groupPosition == 7) && (childPosition == 4))
                {
                    openBRWvalor_aduaneira();      // Tipos de Valores de Aduaneira
                }
                if ((groupPosition == 8) && (childPosition == 0))
                {
                    openBRWincoterms();      // Cadastro de INCOTERMS
                }
                if ((groupPosition == 8) && (childPosition == 1))
                {
                    openBRWtipo_embalagem();      // Tipos de Embalagens
                }
                if ((groupPosition == 8) && (childPosition == 2))
                {
                    openBRWtipo_recipiente();      // Embalagens de Mercadorias
                }
                if ((groupPosition == 8) && (childPosition == 3))
                {
                    openBRWtransportador();      // Transportadoras
                }
                if ((groupPosition == 8) && (childPosition == 4))
                {
                    openBRWveiculos();      // Veiculos
                }
                if ((groupPosition == 8) && (childPosition == 5))
                {
                    openBRWviatransporte();      // Vias de Transporte
                }
                if ((groupPosition == 9) && (childPosition == 0))
                {
                    openBRWdocumentos_di();      // Instruções de Despacho
                }
                if ((groupPosition == 9) && (childPosition == 1))
                {
                    openBRWmoddespacho();      // Modalidades de Despacho
                }
                if ((groupPosition == 9) && (childPosition == 2))
                {
                    openBRWmot_adm_temp();      // Motivos de Admissão Temporária
                }
                if ((groupPosition == 9) && (childPosition == 3))
                {
                    openBRWmot_sem_cob();      // Motivos de Isenção de Cobrança
                }
                if ((groupPosition == 9) && (childPosition == 4))
                {
                    openBRWmotivo_retificacao();      // Motivos para Retificação
                }
                if ((groupPosition == 9) && (childPosition == 5))
                {
                    openBRWmotivotransmissao();      // Motivos para Transmissao de DI
                }
                if ((groupPosition == 9) && (childPosition == 6))
                {
                    openBRWtipo_declaracao();      // Tipos de Declaração
                }
                if ((groupPosition == 9) && (childPosition == 7))
                {
                    openBRWtipo_documento();      // Tipos de Documentos
                }
                if ((groupPosition == 9) && (childPosition == 8))
                {
                    openBRWtipo_documento_des();      // Descrição de Tipos de Documento
                }
                if ((groupPosition == 9) && (childPosition == 9))
                {
                    openBRWtipomanifesto();      // Tipos de Manifesto
                }
                if ((groupPosition == 9) && (childPosition == 10))
                {
                    openBRWtipo_importador();      // Tipos de Importadores
                }
                if ((groupPosition == 10) && (childPosition == 0))
                {
                    openBRWusuarios();      // Usuarios
                }
                if ((groupPosition == 10) && (childPosition == 1))
                {
                    doLogoff();      // Fazer logoff
                }
                if ((groupPosition == 10) && (childPosition == 2))
                {
                    doTerminate();      // Sair do programa
                }

                return false;
            }
        });
    }

    private void doLogoff()
    {
    }

    private void doTerminate()
    {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                switch (which)
                {
                    case DialogInterface.BUTTON_POSITIVE:
                        finish();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        // Nao preciso fazer nada
                        break;
                }
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(SiscomexHome.this);
        builder.setMessage("Desaja sair do sistema ?").setPositiveButton("Sim", dialogClickListener)
                .setNegativeButton("Não", dialogClickListener).show();
    }

    /*
     * Preparing the list data
     */
    private void prepareListData()
    {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Empresas");
        listDataHeader.add("NBM/NCM");
        listDataHeader.add("Acordos Aduaneiros");
        listDataHeader.add("Declaração de Importação");
        listDataHeader.add("Adições de Documento de Importação");
        listDataHeader.add("Cadastros Financeiros");
        listDataHeader.add("Dados logísticos");
        listDataHeader.add("Localização Portuária");
        listDataHeader.add("Estruturas Físicas e Transporte");
        listDataHeader.add("Cadastros Diversos");
        listDataHeader.add("Usuários/Sair");

        // Adding child data
        List<String> secao01 = new ArrayList<String>();
        secao01.add("Cadastro de empresas");


        List<String> secao02 = new ArrayList<String>();
        secao02.add("Código da Abrangência NCM");
        secao02.add("Atributos do NCM");
        secao02.add("Cadastros de Especificações de NCM");
        secao02.add("Especificação da NCM da Adição");
        secao02.add("Nomenclatura Brasileira de Mercadorias");
        secao02.add("Nomenclatura Comum do MERCOSUL");

        List<String> secao03 = new ArrayList<String>();
        secao03.add("Acordo ALADI");
        secao03.add("IDentificação do Certificado MERCOSUL");
        secao03.add("Declaração de Exportação para o MERCOSUL");
        secao03.add("Acordo NALADI NCCA");
        secao03.add("Cadastro NALADI SH");

        List<String> secao04 = new ArrayList<String>();
        secao04.add("Declaração de Importação");
        secao04.add("Impostos do Documento de Importação");
        secao04.add("Código da Origem DI");
        secao04.add("Processos DI");

        List<String> secao05 = new ArrayList<String>();
        secao05.add("Adições (itens) da Declaração de Importação");
        secao05.add("Locais do Armazenamento da adição");
        secao05.add("Deduções de Impostos da Adição");
        secao05.add("Destaque das NCMs da adição");
        secao05.add("Volumes da Adição");
        secao05.add("Documentos Vinculados a Adição");
        secao05.add("Mercadorias da Adiçâo");
        secao05.add("Tarifas da Adiçao");
        secao05.add("Tributos de Adição");

        List<String> secao06 = new ArrayList<String>();
        secao06.add("Moedas");
        secao06.add("Bancos da FEBRABAN");
        secao06.add("Tipos de Acréscimos");
        secao06.add("Valores de Restituições de Impostos");
        secao06.add("Tipos de Dedução");
        secao06.add("Fundamentação Legal de Tributos");
        secao06.add("Instituições Financeiras Internacionais");
        secao06.add("Regimes de Tributação");
        secao06.add("Tipos de Impostos a pagar");


        List<String> secao07 = new ArrayList<String>();
        secao07.add("Unidades da Federação");
        secao07.add("Municípios Brasileiros");
        secao07.add("Cadastro Países");

        List<String> secao08 = new ArrayList<String>();
        secao08.add("Cadastro das Localidades de Embarque");
        secao08.add("Descrição da Localização da Adição");
        secao08.add("Cadastro de Órgãos da Receita Federal");
        secao08.add("Recintos Alfandegários");
        secao08.add("Tipos de Valores de Aduaneira");

        List<String> secao09 = new ArrayList<String>();
        secao09.add("Cadastro de INCOTERMS");
        secao09.add("Tipos de Embalagens");
        secao09.add("Embalagens de Mercadorias");
        secao09.add("Transportadoras");
        secao09.add("Veiculos");
        secao09.add("Vias de Transporte");

        List<String> secao10 = new ArrayList<String>();
        secao10.add("Instruções de Despacho");
        secao10.add("Modalidades de Despacho");
        secao10.add("Motivos de Admissão Temporária");
        secao10.add("Motivos de Isenção de Cobrança");
        secao10.add("Motivos para Retificação");
        secao10.add("Motivos para Transmissao de DI");
        secao10.add("Tipos de Declaração");
        secao10.add("Tipos de Documentos");
        secao10.add("Descrição de Tipos de Documento");
        secao10.add("Tipos de Manifesto");
        secao10.add("Tipos de Importadores");

        List<String> secao11 = new ArrayList<String>();
        secao11.add("Usuários");
        secao11.add("Fazer logoff");
        secao11.add("Sair do programa");

        listDataChild.put(listDataHeader.get(0), secao01); // Header, Child data
        listDataChild.put(listDataHeader.get(1), secao02); // Header, Child data
        listDataChild.put(listDataHeader.get(2), secao03); // Header, Child data
        listDataChild.put(listDataHeader.get(3), secao04); // Header, Child data
        listDataChild.put(listDataHeader.get(4), secao05); // Header, Child data
        listDataChild.put(listDataHeader.get(5), secao06); // Header, Child data
        listDataChild.put(listDataHeader.get(6), secao07); // Header, Child data
        listDataChild.put(listDataHeader.get(7), secao08); // Header, Child data
        listDataChild.put(listDataHeader.get(8), secao09); // Header, Child data
        listDataChild.put(listDataHeader.get(9), secao10); // Header, Child data
        listDataChild.put(listDataHeader.get(10), secao11); // Header, Child data

    }

    public void openBRWabrangencia_ncm()
    {
        Intent i = new Intent(this, BRWabrangencia_ncm.class);
        startActivity(i);
    }

    public void openBRWacordo_aladi()
    {
        Intent i = new Intent(this, BRWacordo_aladi.class);
        startActivity(i);
    }

    public void openBRWacrescimos()
    {
        Intent i = new Intent(this, BRWacrescimos.class);
        startActivity(i);
    }

    public void openBRWacrescimo_adi()
    {
        Intent i = new Intent(this, BRWacrescimo_adi.class);
        startActivity(i);
    }

    public void openBRWadicao()
    {
        Intent i = new Intent(this, BRWadicao.class);
        startActivity(i);
    }

    public void openBRWaladi()
    {
        Intent i = new Intent(this, BRWaladi.class);
        startActivity(i);
    }

    public void openBRWarmazem_di()
    {
        Intent i = new Intent(this, BRWarmazem_di.class);
        startActivity(i);
    }

    public void openBRWatrib_ncm()
    {
        Intent i = new Intent(this, BRWatrib_ncm.class);
        startActivity(i);
    }

    public void openBRWbancos()
    {
        Intent i = new Intent(this, BRWbancos.class);
        startActivity(i);
    }

    public void openBRWcidades()
    {
        Intent i = new Intent(this, BRWcidades.class);
        startActivity(i);
    }

    public void openBRWcompensacao_di()
    {
        Intent i = new Intent(this, BRWcompensacao_di.class);
        startActivity(i);
    }

    public void openBRWdeducao_adi()
    {
        Intent i = new Intent(this, BRWdeducao_adi.class);
        startActivity(i);
    }

    public void openBRWdeducoes()
    {
        Intent i = new Intent(this, BRWdeducoes.class);
        startActivity(i);
    }

    public void openBRWdestaquencm_adi()
    {
        Intent i = new Intent(this, BRWdestaquencm_adi.class);
        startActivity(i);
    }

    public void openBRWde_merc_adi()
    {
        Intent i = new Intent(this, BRWde_merc_adi.class);
        startActivity(i);
    }

    public void openBRWdi()
    {
        Intent i = new Intent(this, BRWdi.class);
        startActivity(i);
    }

    public void openBRWdocumentos_di()
    {
        Intent i = new Intent(this, BRWdocumentos_di.class);
        startActivity(i);
    }

    public void openBRWdoc_carga_di()
    {
        Intent i = new Intent(this, BRWdoc_carga_di.class);
        startActivity(i);
    }

    public void openBRWdoc_vinculado_adi()
    {
        Intent i = new Intent(this, BRWdoc_vinculado_adi.class);
        startActivity(i);
    }

    public void openBRWempresas()
    {
        Intent i = new Intent(this, BRWempresas.class);
        startActivity(i);
    }

    public void openBRWespec_ncm()
    {
        Intent i = new Intent(this, BRWespec_ncm.class);
        startActivity(i);
    }

    public void openBRWesp_ncm_adi()
    {
        Intent i = new Intent(this, BRWesp_ncm_adi.class);
        startActivity(i);
    }

    public void openBRWestado()
    {
        Intent i = new Intent(this, BRWestado.class);
        startActivity(i);
    }

    public void openBRWfund_legal()
    {
        Intent i = new Intent(this, BRWfund_legal.class);
        startActivity(i);
    }

    public void openBRWimpostos_di()
    {
        Intent i = new Intent(this, BRWimpostos_di.class);
        startActivity(i);
    }

    public void openBRWincoterms()
    {
        Intent i = new Intent(this, BRWincoterms.class);
        startActivity(i);
    }

    public void openBRWinfo_mercosul_di()
    {
        Intent i = new Intent(this, BRWinfo_mercosul_di.class);
        startActivity(i);
    }

    public void openBRWinst_financeira()
    {
        Intent i = new Intent(this, BRWinst_financeira.class);
        startActivity(i);
    }

    public void openBRWlocalidadeembarque()
    {
        Intent i = new Intent(this, BRWlocalidadeembarque.class);
        startActivity(i);
    }

    public void openBRWmercadoria_adi()
    {
        Intent i = new Intent(this, BRWmercadoria_adi.class);
        startActivity(i);
    }

    public void openBRWmoddespacho()
    {
        Intent i = new Intent(this, BRWmoddespacho.class);
        startActivity(i);
    }

    public void openBRWmoedas()
    {
        Intent i = new Intent(this, BRWmoedas.class);
        startActivity(i);
    }

    public void openBRWmotivotransmissao()
    {
        Intent i = new Intent(this, BRWmotivotransmissao.class);
        startActivity(i);
    }

    public void openBRWmotivo_retificacao()
    {
        Intent i = new Intent(this, BRWmotivo_retificacao.class);
        startActivity(i);
    }

    public void openBRWmot_adm_temp()
    {
        Intent i = new Intent(this, BRWmot_adm_temp.class);
        startActivity(i);
    }

    public void openBRWmot_sem_cob()
    {
        Intent i = new Intent(this, BRWmot_sem_cob.class);
        startActivity(i);
    }

    public void openBRWnaladi_ncca()
    {
        Intent i = new Intent(this, BRWnaladi_ncca.class);
        startActivity(i);
    }

    public void openBRWnaladi_sh()
    {
        Intent i = new Intent(this, BRWnaladi_sh.class);
        startActivity(i);
    }

    public void openBRWnbm()
    {
        Intent i = new Intent(this, BRWnbm.class);
        startActivity(i);
    }

    public void openBRWncm()
    {
        Intent i = new Intent(this, BRWncm.class);
        startActivity(i);
    }

    public void openBRWorgaosurf()
    {
        Intent i = new Intent(this, BRWorgaosurf.class);
        startActivity(i);
    }

    public void openBRWorigem_di()
    {
        Intent i = new Intent(this, BRWorigem_di.class);
        startActivity(i);
    }

    public void openBRWpaises()
    {
        Intent i = new Intent(this, BRWpaises.class);
        startActivity(i);
    }

    public void openBRWprocesso_di()
    {
        Intent i = new Intent(this, BRWprocesso_di.class);
        startActivity(i);
    }

    public void openBRWrecintoalfandegado()
    {
        Intent i = new Intent(this, BRWrecintoalfandegado.class);
        startActivity(i);
    }

    public void openBRWregime_tribut()
    {
        Intent i = new Intent(this, BRWregime_tribut.class);
        startActivity(i);
    }

    public void openBRWtab_orcamentaria()
    {
        Intent i = new Intent(this, BRWtab_orcamentaria.class);
        startActivity(i);
    }

    public void openBRWtarifas_adi()
    {
        Intent i = new Intent(this, BRWtarifas_adi.class);
        startActivity(i);
    }

    public void openBRWtipomanifesto()
    {
        Intent i = new Intent(this, BRWtipomanifesto.class);
        startActivity(i);
    }

    public void openBRWtipo_declaracao()
    {
        Intent i = new Intent(this, BRWtipo_declaracao.class);
        startActivity(i);
    }

    public void openBRWtipo_documento()
    {
        Intent i = new Intent(this, BRWtipo_documento.class);
        startActivity(i);
    }

    public void openBRWtipo_documento_des()
    {
        Intent i = new Intent(this, BRWtipo_documento_des.class);
        startActivity(i);
    }

    public void openBRWtipo_embalagem()
    {
        Intent i = new Intent(this, BRWtipo_embalagem.class);
        startActivity(i);
    }

    public void openBRWtipo_importador()
    {
        Intent i = new Intent(this, BRWtipo_importador.class);
        startActivity(i);
    }

    public void openBRWtipo_recipiente()
    {
        Intent i = new Intent(this, BRWtipo_recipiente.class);
        startActivity(i);
    }

    public void openBRWtransportador()
    {
        Intent i = new Intent(this, BRWtransportador.class);
        startActivity(i);
    }

    public void openBRWtributo_adi()
    {
        Intent i = new Intent(this, BRWtributo_adi.class);
        startActivity(i);
    }

    public void openBRWusuarios()
    {
        Intent i = new Intent(this, BRWusuarios.class);
        startActivity(i);
    }

    public void openBRWvalor_aduaneira()
    {
        Intent i = new Intent(this, BRWvalor_aduaneira.class);
        startActivity(i);
    }

    public void openBRWveiculos()
    {
        Intent i = new Intent(this, BRWveiculos.class);
        startActivity(i);
    }

    public void openBRWviatransporte()
    {
        Intent i = new Intent(this, BRWviatransporte.class);
        startActivity(i);
    }

}