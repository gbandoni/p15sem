package br.com.bandoni.dao.commons;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DAOFieldGroups
{
    public static final String[][] tablePrimaryKeys =
            {
                    {"j34_siscomex_abrangencia_ncm","codigo"},
                    {"j34_siscomex_acordo_aladi","codigo"},
                    {"j34_siscomex_acrescimo_adi","numeroDocumentoCarga","numeroAdicao"},
                    {"j34_siscomex_acrescimos","codigo"},
                    {"j34_siscomex_adicao","numeroDocumentoCarga","numeroAdicao"},
                    {"j34_siscomex_aladi","codigo"},
                    {"j34_siscomex_armazem_di","numeroDocumentoCarga","Ordem"},
                    {"j34_siscomex_atrib_ncm","ncm","atributoncm"},
                    {"j34_siscomex_bancos","codigo"},
                    {"j34_siscomex_cidades","estado","codmun"},
                    {"j34_siscomex_compensacao_di","numeroDocumentoCarga","ordem"},
                    {"j34_siscomex_de_merc_adi","numeroDocumentoCarga","numeroAdicao"},
                    {"j34_siscomex_deducao_adi","numeroDocumentoCarga","numeroAdicao"},
                    {"j34_siscomex_deducoes","codigo"},
                    {"j34_siscomex_destaquencm_adi","numeroDocumentoCarga","numeroAdicao"},
                    {"j34_siscomex_di","numeroDocumentoCarga"},
                    {"j34_siscomex_doc_carga_di","numeroDocumentoCarga","ordem"},
                    {"j34_siscomex_doc_vinculado_adi","numeroDocumentoCarga","numeroAdicao"},
                    {"j34_siscomex_documentos_di","numeroDocumentoCarga","ordem"},
                    {"j34_siscomex_empresas","codigo"},
                    {"j34_siscomex_esp_ncm_adi","numeroDocumentoCarga","numeroAdicao","codigoAbrangenciaNCM"},
                    {"j34_siscomex_espec_ncm","id"},
                    {"j34_siscomex_estado","estado_id"},
                    {"j34_siscomex_fund_legal","codigo"},
                    {"j34_siscomex_impostos_di","numeroDocumentoCarga","ordem"},
                    {"j34_siscomex_incoterms","codigo"},
                    {"j34_siscomex_info_mercosul_di","numeroDocumentoCarga","ordem"},
                    {"j34_siscomex_inst_financeira","codigo"},
                    {"j34_siscomex_localidadeembarque","ID"},
                    {"j34_siscomex_mercadoria_adi","numeroDocumentoCarga","numeroAdicao"},
                    {"j34_siscomex_moddespacho","codigo_modalidade"},
                    {"j34_siscomex_moedas","idmoeda"},
                    {"j34_siscomex_mot_adm_temp","codigo"},
                    {"j34_siscomex_mot_sem_cob","codigo"},
                    {"j34_siscomex_motivo_retificacao","codigo_motivo"},
                    {"j34_siscomex_motivotransmissao","codigo"},
                    {"j34_siscomex_naladi_ncca","codigo","ordem"},
                    {"j34_siscomex_naladi_sh","codigo","ordem"},
                    {"j34_siscomex_nbm","codigo"},
                    {"j34_siscomex_ncm","codigoncm"},
                    {"j34_siscomex_orgaosurf","codigo"},
                    {"j34_siscomex_origem_di","ID"},
                    {"j34_siscomex_paises","codigo_pais"},
                    {"j34_siscomex_processo_di","numeroDocumentoCarga","ordem"},
                    {"j34_siscomex_recintoalfandegado","codigo","terminal"},
                    {"j34_siscomex_regime_tribut","codigo"},
                    {"j34_siscomex_tab_orcamentaria","codigo"},
                    {"j34_siscomex_tarifas_adi","numeroDocumentoCarga","numeroAdicao"},
                    {"j34_siscomex_tipo_declaracao","codigo_tipo"},
                    {"j34_siscomex_tipo_documento_des","codigo"},
                    {"j34_siscomex_tipo_documento","codigo"},
                    {"j34_siscomex_tipo_embalagem","codigo"},
                    {"j34_siscomex_tipo_importador","id"},
                    {"j34_siscomex_tipo_recipiente","codigo"},
                    {"j34_siscomex_tipomanifesto","codigo"},
                    {"j34_siscomex_transportador","id"},
                    {"j34_siscomex_tributo_adi","numeroDocumentoCarga","numeroAdicao"},
                    {"j34_siscomex_usuarios","usu_codigo"},
                    {"j34_siscomex_valor_aduaneira","codigo"},
                    {"j34_siscomex_veiculos","id"},
                    {"j34_siscomex_viatransporte","codigo"}
            };


    public static final String[][] tableBrowserColumns =
            {
                    {"j34_siscomex_abrangencia_ncm", "codigo", "descricao"}, //j34_siscomex_abrangencia_ncm
                    {"j34_siscomex_acordo_aladi", "codigo", "descricao"}, //j34_siscomex_acordo_aladi
                    {"j34_siscomex_acrescimo_adi", "numeroDocumentoCarga", "numeroAdicao", "codigoMetodoAcrescimoValor", "codigoMoedaNegociadaAcrescimo"}, //j34_siscomex_acrescimo_adi
                    {"j34_siscomex_acrescimos", "codigo", "descricao"}, //j34_siscomex_acrescimos
                    {"j34_siscomex_adicao", "numeroDocumentoCarga", "numeroAdicao", "codigoMercadoriaNCM"}, //j34_siscomex_adicao
                    {"j34_siscomex_aladi", "codigo", "descricao"}, //j34_siscomex_aladi
                    {"j34_siscomex_armazem_di", "numeroDocumentoCarga", "Ordem", "nomeArmazemCarga"}, //j34_siscomex_armazem_di
                    {"j34_siscomex_atrib_ncm", "ncm", "atributoncm"}, //j34_siscomex_atrib_ncm
                    {"j34_siscomex_bancos", "codigo", "descricao"}, //j34_siscomex_bancos
                    {"j34_siscomex_cidades", "codmun", "nome"}, //j34_siscomex_cidades
                    {"j34_siscomex_compensacao_di", "numeroDocumentoCarga", "ordem", "codigoReceitaCredito", "numeroDocumentoGeradorCredito"}, //j34_siscomex_compensacao_di
                    {"j34_siscomex_de_merc_adi", "numeroDocumentoCarga", "numeroAdicao", "codigoPaisCertificado", "numeroDICertificado"}, //j34_siscomex_de_merc_adi
                    {"j34_siscomex_deducao_adi", "numeroDocumentoCarga", "numeroAdicao", "codigoMetodoDeducaoValor", "codigoMoedaNegociadaDeducao"}, //j34_siscomex_deducao_adi
                    {"j34_siscomex_deducoes", "codigo", "descricao"}, //j34_siscomex_deducoes
                    {"j34_siscomex_destaquencm_adi", "numeroDocumentoCarga", "numeroAdicao", "numeroDestaqueNCM"}, //j34_siscomex_destaquencm_adi
                    {"j34_siscomex_di", "numeroDocumentoCarga", "codigoTipoDocumentoCarga", "dataEmbarque"}, //j34_siscomex_di
                    {"j34_siscomex_doc_carga_di", "numeroDocumentoCarga", "Ordem", "codigoTipoEmbalagemCarga"}, //j34_siscomex_doc_carga_di
                    {"j34_siscomex_doc_vinculado_adi", "numeroDocumentoCarga", "numeroAdicao", "codigoTipoDocumentoVinculado", "numeroDocumentoVinculado"}, //j34_siscomex_doc_vinculado_adi
                    {"j34_siscomex_documentos_di", "numeroDocumentoCarga", "Ordem", "codigoTipoDocumentoInstrucaoDespacho"}, //j34_siscomex_documentos_di
                    {"j34_siscomex_empresas", "codigo", "razaosocial"}, //j34_siscomex_empresas
                    {"j34_siscomex_esp_ncm_adi", "numeroDocumentoCarga", "numeroAdicao", "codigoAbrangenciaNCM", "codigoespecificacao"}, //j34_siscomex_esp_ncm_adi
                    {"j34_siscomex_espec_ncm", "ncm", "descricao"}, //j34_siscomex_espec_ncm
                    {"j34_siscomex_estado", "estado_id", "nome"}, //j34_siscomex_estado
                    {"j34_siscomex_fund_legal", "codigo", "descricao"}, //j34_siscomex_fund_legal
                    {"j34_siscomex_impostos_di", "numeroDocumentoCarga", "Ordem", "codigoBancoPagamentoTributo", "codigoReceitaPagamento", "dataPagamentoTributo"}, //j34_siscomex_impostos_di
                    {"j34_siscomex_incoterms", "codigo", "descricao"}, //j34_siscomex_incoterms
                    {"j34_siscomex_info_mercosul_di", "numeroDocumentoCarga", "Ordem", "numeroDEMercosul"}, //j34_siscomex_info_mercosul_di
                    {"j34_siscomex_inst_financeira", "codigo", "descricao"}, //j34_siscomex_inst_financeira
                    {"j34_siscomex_localidadeembarque", "ID", "localidade"}, //j34_siscomex_localidadeembarque
                    {"j34_siscomex_mercadoria_adi", "numeroDocumentoCarga", "numeroAdicao", "textoDetalhamentoMercadoria"}, //j34_siscomex_mercadoria_adi
                    {"j34_siscomex_moddespacho", "codigo_modalidade", "nome_modalidade"}, //j34_siscomex_moddespacho
                    {"j34_siscomex_moedas", "idmoeda", "nome"}, //j34_siscomex_moedas
                    {"j34_siscomex_mot_adm_temp", "codigo", "descricao"}, //j34_siscomex_mot_adm_temp
                    {"j34_siscomex_mot_sem_cob", "codigo", "descricao"}, //j34_siscomex_mot_sem_cob
                    {"j34_siscomex_motivo_retificacao", "codigo_motivo", "descricao_motivo"}, //j34_siscomex_motivo_retificacao
                    {"j34_siscomex_motivotransmissao", "codigo", "descricao"}, //j34_siscomex_motivotransmissao
                    {"j34_siscomex_naladi_ncca", "codigo", "descricao"}, //j34_siscomex_naladi_ncca
                    {"j34_siscomex_naladi_sh", "codigo", "descricao"}, //j34_siscomex_naladi_sh
                    {"j34_siscomex_nbm", "codigo", "descricao"}, //j34_siscomex_nbm
                    {"j34_siscomex_ncm", "codigoncm", "descricao"}, //j34_siscomex_ncm
                    {"j34_siscomex_orgaosurf", "codigo", "descricao"}, //j34_siscomex_orgaosurf
                    {"j34_siscomex_origem_di", "ID", "descricao"}, //j34_siscomex_origem_di
                    {"j34_siscomex_paises", "codigo_pais", "nome_pais"}, //j34_siscomex_paises
                    {"j34_siscomex_processo_di", "numeroDocumentoCarga", "Ordem", "codigoTipoProcesso", "numeroProcesso"}, //j34_siscomex_processo_di
                    {"j34_siscomex_recintoalfandegado", "codigo", "nomeporto"}, //j34_siscomex_recintoalfandegado
                    {"j34_siscomex_regime_tribut", "codigo", "descricao"}, //j34_siscomex_regime_tribut
                    {"j34_siscomex_tab_orcamentaria", "codigo", "descricao"}, //j34_siscomex_tab_orcamentaria
                    {"j34_siscomex_tarifas_adi", "numeroDocumentoCarga", "numeroAdicao", "codigoAssuntoVinculado"}, //j34_siscomex_tarifas_adi
                    {"j34_siscomex_tipo_declaracao", "codigo_tipo", "tipo_declaracao"}, //j34_siscomex_tipo_declaracao
                    {"j34_siscomex_tipo_documento", "codigo", "descricao"}, //j34_siscomex_tipo_documento
                    {"j34_siscomex_tipo_documento_des", "codigo", "descricao"}, //j34_siscomex_tipo_documento_des
                    {"j34_siscomex_tipo_embalagem", "codigo", "descricao"}, //j34_siscomex_tipo_embalagem
                    {"j34_siscomex_tipo_importador", "id", "descricao"}, //j34_siscomex_tipo_importador
                    {"j34_siscomex_tipo_recipiente", "codigo", "descricao"}, //j34_siscomex_tipo_recipiente
                    {"j34_siscomex_tipomanifesto", "codigo", "descricao"}, //j34_siscomex_tipomanifesto
                    {"j34_siscomex_transportador", "id", "nome"}, //j34_siscomex_transportador
                    {"j34_siscomex_tributo_adi", "numeroDocumentoCarga", "numeroAdicao", "codigoReceitaImposto", "codigoTipoAliquotaIPT"}, //j34_siscomex_tributo_adi
                    {"j34_siscomex_usuarios", "usu_codigo", "usu_login", "usu_nome", "usu_adm"}, //j34_siscomex_usuarios
                    {"j34_siscomex_valor_aduaneira", "codigo", "descricao"}, //j34_siscomex_valor_aduaneira
                    {"j34_siscomex_veiculos", "id", "nomeveiculo"}, //j34_siscomex_veiculos
                    {"j34_siscomex_viatransporte", "codigo", "descricao"} //j34_siscomex_viatransporte
            };

    public static List<String> getTablePrimaryKeyColumns(String tableName)
    {
        int tamanho = tablePrimaryKeys.length;
        List<String> resposta = new ArrayList<String>();
        int i = 0;
        while (i < tamanho)
        {
            if (tableName.equalsIgnoreCase(tablePrimaryKeys[i][0]))
            {
                resposta = new ArrayList<String>(Arrays.asList(tablePrimaryKeys[i]));
                resposta.remove(0);// para remover o nome da tabela no comeco
            }
            i++;
        }
        return resposta;
    }

    /**
     *
     * @param tableName - Nome da tabela
     * @return List<String>
     */
    public static List<String> getTableBrowserColumns(String tableName)
    {
        int tamanho = tableBrowserColumns.length;
        List<String> resposta = new ArrayList<String>();
        int i = 0;
        while (i < tamanho)
        {
            if (tableName.equalsIgnoreCase(tableBrowserColumns[i][0]))
            {
                resposta = new ArrayList<String>(Arrays.asList(tableBrowserColumns[i]));
                resposta.remove(0);// para remover o nome da tabela no comeco
            }
            i++;
        }
        return resposta;
    }

    public static String[] getArrBrowserColumns(String tableName)
    {
        int tamanho = tableBrowserColumns.length;
        int pos = 0;
        while (pos < tamanho)
        {
            if (tableName.equalsIgnoreCase(tableBrowserColumns[pos][0]))
            {
                String[] resposta = new String[tableBrowserColumns[pos].length-1];
                for (int i=1;i<tableBrowserColumns[pos].length;i++)
                    resposta[i-1] = tableBrowserColumns[pos][i];
                return resposta;
            }
            pos++;
        }
        return new String[]{};
    }

    }
