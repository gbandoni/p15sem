package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.AdicaoDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexAdicao;

/**
 * J34SiscomexAdicao: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class AdicaoDAOImpl extends GenericDAO<J34SiscomexAdicao> implements AdicaoDAO {

        private final static String SQL_SELECT = 
                "select numerodocumentocarga, numeroadicao, codigoacordoaladi, codigoaplicacaomercadoria, codigoausenciafabricante, codigocoberturacambial, codigofundamentolegalreduzido, codigofundamentolegalregime, codigofundamentolegalregimepiscofins, codigoincotermsvenda, codigomercadorianbmsh, codigomercadoriancm, codigomercadorianaladincc, codigoordemmercadorianaladincc, codigomercadorianaladish, codigoordemmercadorianaladish, codigometodovaloracao, codigomoedafretemercadoria, codigomoedaseguromercadoria, codigomoedanegociada, codigomotivoadmissaotemporaria, codigomotivosemcobertura, codigoorgaofinanciamentointernacional, codigopaisorigemmercadoria, codigopaisaquisicaomercadoria, codigopaisprocedenciamercadoria, codigoregimetriburariopiscofins, codigoregimetributacao, codigotipoacordotarifario, codigourfentradamercadoria, codigoviatransporte, codigovinculoimportadorexportador, codigofabricante, codigofornecedorestrangeiro, indicadorbemencomenda, indicadormaterialusado, indicadormultimodal, indicadortipocertificado, nomelocalcondicaovenda, numerodocumentoreducao, numeroidentificacaoli, numerorof, percentualcoeficientereducaoii, pesoliquidomercadoria, quantidadeunidadeestatistica, textocomplementovaloraduaneiro, valoraliquotaicms, valorcalculodcrdolar, valorfinanciadosuperior360, valorfretemercadoriamoedanacional, valorfretemercadoriamoedanegociada, valoriicalculadodcrmoedanacional, valoriidevidozfm, valoriiareceberzfm, valormercadoriacondicaovenda, valormercadoriaembarquemoedanacional, valormercadoriavendamoedanacional, valorseguromercadoriamoedanacional, valorseguromercadoriamoedanegociada from j34_siscomex_adicao where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_adicao ( numerodocumentocarga, numeroadicao, codigoacordoaladi, codigoaplicacaomercadoria, codigoausenciafabricante, codigocoberturacambial, codigofundamentolegalreduzido, codigofundamentolegalregime, codigofundamentolegalregimepiscofins, codigoincotermsvenda, codigomercadorianbmsh, codigomercadoriancm, codigomercadorianaladincc, codigoordemmercadorianaladincc, codigomercadorianaladish, codigoordemmercadorianaladish, codigometodovaloracao, codigomoedafretemercadoria, codigomoedaseguromercadoria, codigomoedanegociada, codigomotivoadmissaotemporaria, codigomotivosemcobertura, codigoorgaofinanciamentointernacional, codigopaisorigemmercadoria, codigopaisaquisicaomercadoria, codigopaisprocedenciamercadoria, codigoregimetriburariopiscofins, codigoregimetributacao, codigotipoacordotarifario, codigourfentradamercadoria, codigoviatransporte, codigovinculoimportadorexportador, codigofabricante, codigofornecedorestrangeiro, indicadorbemencomenda, indicadormaterialusado, indicadormultimodal, indicadortipocertificado, nomelocalcondicaovenda, numerodocumentoreducao, numeroidentificacaoli, numerorof, percentualcoeficientereducaoii, pesoliquidomercadoria, quantidadeunidadeestatistica, textocomplementovaloraduaneiro, valoraliquotaicms, valorcalculodcrdolar, valorfinanciadosuperior360, valorfretemercadoriamoedanacional, valorfretemercadoriamoedanegociada, valoriicalculadodcrmoedanacional, valoriidevidozfm, valoriiareceberzfm, valormercadoriacondicaovenda, valormercadoriaembarquemoedanacional, valormercadoriavendamoedanacional, valorseguromercadoriamoedanacional, valorseguromercadoriamoedanegociada ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_adicao set codigoacordoaladi = ?, codigoaplicacaomercadoria = ?, codigoausenciafabricante = ?, codigocoberturacambial = ?, codigofundamentolegalreduzido = ?, codigofundamentolegalregime = ?, codigofundamentolegalregimepiscofins = ?, codigoincotermsvenda = ?, codigomercadorianbmsh = ?, codigomercadoriancm = ?, codigomercadorianaladincc = ?, codigoordemmercadorianaladincc = ?, codigomercadorianaladish = ?, codigoordemmercadorianaladish = ?, codigometodovaloracao = ?, codigomoedafretemercadoria = ?, codigomoedaseguromercadoria = ?, codigomoedanegociada = ?, codigomotivoadmissaotemporaria = ?, codigomotivosemcobertura = ?, codigoorgaofinanciamentointernacional = ?, codigopaisorigemmercadoria = ?, codigopaisaquisicaomercadoria = ?, codigopaisprocedenciamercadoria = ?, codigoregimetriburariopiscofins = ?, codigoregimetributacao = ?, codigotipoacordotarifario = ?, codigourfentradamercadoria = ?, codigoviatransporte = ?, codigovinculoimportadorexportador = ?, codigofabricante = ?, codigofornecedorestrangeiro = ?, indicadorbemencomenda = ?, indicadormaterialusado = ?, indicadormultimodal = ?, indicadortipocertificado = ?, nomelocalcondicaovenda = ?, numerodocumentoreducao = ?, numeroidentificacaoli = ?, numerorof = ?, percentualcoeficientereducaoii = ?, pesoliquidomercadoria = ?, quantidadeunidadeestatistica = ?, textocomplementovaloraduaneiro = ?, valoraliquotaicms = ?, valorcalculodcrdolar = ?, valorfinanciadosuperior360 = ?, valorfretemercadoriamoedanacional = ?, valorfretemercadoriamoedanegociada = ?, valoriicalculadodcrmoedanacional = ?, valoriidevidozfm = ?, valoriiareceberzfm = ?, valormercadoriacondicaovenda = ?, valormercadoriaembarquemoedanacional = ?, valormercadoriavendamoedanacional = ?, valorseguromercadoriamoedanacional = ?, valorseguromercadoriamoedanegociada = ? where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_adicao where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_adicao";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_adicao where numerodocumentocarga = ? and numeroadicao = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public AdicaoDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @return A nova inst�ncia
         */
        private J34SiscomexAdicao newInstanceWithPrimaryKey( String numerodocumentocarga, String numeroadicao ) {
                J34SiscomexAdicao j34SiscomexAdicao = new J34SiscomexAdicao();
                j34SiscomexAdicao.setNumerodocumentocarga( numerodocumentocarga );
                j34SiscomexAdicao.setNumeroadicao( numeroadicao );
                return j34SiscomexAdicao ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexAdicao find( String numerodocumentocarga, String numeroadicao ) {
                J34SiscomexAdicao j34SiscomexAdicao = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                if ( super.doSelect(j34SiscomexAdicao) ) {
                        return j34SiscomexAdicao ;
                }
                else {
                        return null ; // Not found
                }
        }
        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexAdicao
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexAdicao j34SiscomexAdicao ) {
                return super.doSelect(j34SiscomexAdicao) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexAdicao
         */
        @Override
        public void insert(J34SiscomexAdicao j34SiscomexAdicao) {
                super.doInsert(j34SiscomexAdicao);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexAdicao
         * @return
         */
        @Override
        public int update(J34SiscomexAdicao j34SiscomexAdicao) {
                return super.doUpdate(j34SiscomexAdicao);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @return
         */
        @Override
        public int delete( String numerodocumentocarga, String numeroadicao ) {
                J34SiscomexAdicao j34SiscomexAdicao = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                return super.doDelete(j34SiscomexAdicao);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexAdicao
         * @return
         */
        @Override
        public int delete( J34SiscomexAdicao j34SiscomexAdicao ) {
                return super.doDelete(j34SiscomexAdicao);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @return
         */
        @Override
        public boolean exists( String numerodocumentocarga, String numeroadicao ) {
                J34SiscomexAdicao j34SiscomexAdicao = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                return super.doExists(j34SiscomexAdicao);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexAdicao
         * @return
         */
        @Override
        public boolean exists( J34SiscomexAdicao j34SiscomexAdicao ) {
                return super.doExists(j34SiscomexAdicao);
        }

    //----------------------------------------------------------------------
        /**
         * retorna o total de registros na tabela
         * @return
         */
        @Override
        public long count() {
                return super.doCountAll();
        }

    //----------------------------------------------------------------------
        @Override
        protected String getSqlSelect() {
                return SQL_SELECT ;
        }
    //----------------------------------------------------------------------
        @Override
        protected String getSqlInsert() {
                return SQL_INSERT ;
        }
    //----------------------------------------------------------------------
        @Override
        protected String getSqlUpdate() {
                return SQL_UPDATE ;
        }
    //----------------------------------------------------------------------
        @Override
        protected String getSqlDelete() {
                return SQL_DELETE ;
        }
    //----------------------------------------------------------------------
        @Override
        protected String getSqlCount() {
                return SQL_COUNT ;
        }
    //----------------------------------------------------------------------
        @Override
        protected String getSqlCountAll() {
                return SQL_COUNT_ALL ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexAdicao j34SiscomexAdicao) throws SQLException {
                
                setRawParameter(list,j34SiscomexAdicao.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setRawParameter(list,j34SiscomexAdicao.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexAdicao populateBean(Cursor c, J34SiscomexAdicao j34SiscomexAdicao) throws SQLException {

               
                j34SiscomexAdicao.setNumerodocumentocarga(c.getString(c.getColumnIndex("numerodocumentocarga"))); // java.lang.String
                j34SiscomexAdicao.setNumeroadicao(c.getString(c.getColumnIndex("numeroadicao"))); // java.lang.String
                j34SiscomexAdicao.setCodigoacordoaladi(c.getString(c.getColumnIndex("codigoacordoaladi"))); // java.lang.String
                j34SiscomexAdicao.setCodigoaplicacaomercadoria(c.getString(c.getColumnIndex("codigoaplicacaomercadoria"))); // java.lang.String
                j34SiscomexAdicao.setCodigoausenciafabricante(c.getString(c.getColumnIndex("codigoausenciafabricante"))); // java.lang.String
                j34SiscomexAdicao.setCodigocoberturacambial(c.getString(c.getColumnIndex("codigocoberturacambial"))); // java.lang.String
                j34SiscomexAdicao.setCodigofundamentolegalreduzido(c.getString(c.getColumnIndex("codigofundamentolegalreduzido"))); // java.lang.String
                j34SiscomexAdicao.setCodigofundamentolegalregime(c.getString(c.getColumnIndex("codigofundamentolegalregime"))); // java.lang.String
                j34SiscomexAdicao.setCodigofundamentolegalregimepiscofins(c.getString(c.getColumnIndex("codigofundamentolegalregimepiscofins"))); // java.lang.String
                j34SiscomexAdicao.setCodigoincotermsvenda(c.getString(c.getColumnIndex("codigoincotermsvenda"))); // java.lang.String
                j34SiscomexAdicao.setCodigomercadorianbmsh(c.getString(c.getColumnIndex("codigomercadorianbmsh"))); // java.lang.String
                j34SiscomexAdicao.setCodigomercadoriancm(c.getString(c.getColumnIndex("codigomercadoriancm"))); // java.lang.String
                j34SiscomexAdicao.setCodigomercadorianaladincc(c.getString(c.getColumnIndex("codigomercadorianaladincc"))); // java.lang.String
                j34SiscomexAdicao.setCodigoordemmercadorianaladincc(c.getString(c.getColumnIndex("codigoordemmercadorianaladincc"))); // java.lang.String
                j34SiscomexAdicao.setCodigomercadorianaladish(c.getString(c.getColumnIndex("codigomercadorianaladish"))); // java.lang.String
                j34SiscomexAdicao.setCodigoordemmercadorianaladish(c.getString(c.getColumnIndex("codigoordemmercadorianaladish"))); // java.lang.String
                j34SiscomexAdicao.setCodigometodovaloracao(c.getString(c.getColumnIndex("codigometodovaloracao"))); // java.lang.String
                j34SiscomexAdicao.setCodigomoedafretemercadoria(c.getInt(c.getColumnIndex("codigomoedafretemercadoria"))); // java.lang.Integer
                j34SiscomexAdicao.setCodigomoedaseguromercadoria(c.getInt(c.getColumnIndex("codigomoedaseguromercadoria"))); // java.lang.Integer
                j34SiscomexAdicao.setCodigomoedanegociada(c.getInt(c.getColumnIndex("codigomoedanegociada"))); // java.lang.String
                j34SiscomexAdicao.setCodigomotivoadmissaotemporaria(c.getString(c.getColumnIndex("codigomotivoadmissaotemporaria"))); // java.lang.String
                j34SiscomexAdicao.setCodigomotivosemcobertura(c.getString(c.getColumnIndex("codigomotivosemcobertura"))); // java.lang.String
                j34SiscomexAdicao.setCodigoorgaofinanciamentointernacional(c.getString(c.getColumnIndex("codigoorgaofinanciamentointernacional"))); // java.lang.String
                j34SiscomexAdicao.setCodigopaisorigemmercadoria(c.getString(c.getColumnIndex("codigopaisorigemmercadoria"))); // java.lang.String
                j34SiscomexAdicao.setCodigopaisaquisicaomercadoria(c.getString(c.getColumnIndex("codigopaisaquisicaomercadoria"))); // java.lang.String
                j34SiscomexAdicao.setCodigopaisprocedenciamercadoria(c.getString(c.getColumnIndex("codigopaisprocedenciamercadoria"))); // java.lang.String
                j34SiscomexAdicao.setCodigoregimetriburariopiscofins(c.getString(c.getColumnIndex("codigoregimetriburariopiscofins"))); // java.lang.String
                j34SiscomexAdicao.setCodigoregimetributacao(c.getString(c.getColumnIndex("codigoregimetributacao"))); // java.lang.String
                j34SiscomexAdicao.setCodigotipoacordotarifario(c.getString(c.getColumnIndex("codigotipoacordotarifario"))); // java.lang.String
                j34SiscomexAdicao.setCodigourfentradamercadoria(c.getString(c.getColumnIndex("codigourfentradamercadoria"))); // java.lang.String
                j34SiscomexAdicao.setCodigoviatransporte(c.getString(c.getColumnIndex("codigoviatransporte"))); // java.lang.String
                j34SiscomexAdicao.setCodigovinculoimportadorexportador(c.getString(c.getColumnIndex("codigovinculoimportadorexportador"))); // java.lang.String
                j34SiscomexAdicao.setCodigofabricante(c.getInt(c.getColumnIndex("codigofabricante"))); // java.lang.Integer
                j34SiscomexAdicao.setCodigofornecedorestrangeiro(c.getInt(c.getColumnIndex("codigofornecedorestrangeiro"))); // java.lang.Integer
                j34SiscomexAdicao.setIndicadorbemencomenda(c.getString(c.getColumnIndex("indicadorbemencomenda"))); // java.lang.String
                j34SiscomexAdicao.setIndicadormaterialusado(c.getString(c.getColumnIndex("indicadormaterialusado"))); // java.lang.String
                j34SiscomexAdicao.setIndicadormultimodal(c.getString(c.getColumnIndex("indicadormultimodal"))); // java.lang.String
                j34SiscomexAdicao.setIndicadortipocertificado(c.getString(c.getColumnIndex("indicadortipocertificado"))); // java.lang.String
                j34SiscomexAdicao.setNomelocalcondicaovenda(c.getString(c.getColumnIndex("nomelocalcondicaovenda"))); // java.lang.String
                j34SiscomexAdicao.setNumerodocumentoreducao(c.getString(c.getColumnIndex("numerodocumentoreducao"))); // java.lang.String
                j34SiscomexAdicao.setNumeroidentificacaoli(c.getString(c.getColumnIndex("numeroidentificacaoli"))); // java.lang.String
                j34SiscomexAdicao.setNumerorof(c.getString(c.getColumnIndex("numerorof"))); // java.lang.String
                j34SiscomexAdicao.setPercentualcoeficientereducaoii(c.getFloat(c.getColumnIndex("percentualcoeficientereducaoii"))); // java.math.BigDecimal
                j34SiscomexAdicao.setPesoliquidomercadoria(c.getFloat(c.getColumnIndex("pesoliquidomercadoria"))); // java.math.BigDecimal
                j34SiscomexAdicao.setQuantidadeunidadeestatistica(c.getFloat(c.getColumnIndex("quantidadeunidadeestatistica"))); // java.math.BigDecimal
                j34SiscomexAdicao.setTextocomplementovaloraduaneiro(c.getString(c.getColumnIndex("textocomplementovaloraduaneiro"))); // java.lang.String
                j34SiscomexAdicao.setValoraliquotaicms(c.getFloat(c.getColumnIndex("valoraliquotaicms"))); // java.math.BigDecimal
                j34SiscomexAdicao.setValorcalculodcrdolar(c.getFloat(c.getColumnIndex("valorcalculodcrdolar"))); // java.math.BigDecimal
                j34SiscomexAdicao.setValorfinanciadosuperior360(c.getFloat(c.getColumnIndex("valorfinanciadosuperior360"))); // java.math.BigDecimal
                j34SiscomexAdicao.setValorfretemercadoriamoedanacional(c.getFloat(c.getColumnIndex("valorfretemercadoriamoedanacional"))); // java.math.BigDecimal
                j34SiscomexAdicao.setValorfretemercadoriamoedanegociada(c.getFloat(c.getColumnIndex("valorfretemercadoriamoedanegociada"))); // java.math.BigDecimal
                j34SiscomexAdicao.setValoriicalculadodcrmoedanacional(c.getFloat(c.getColumnIndex("valoriicalculadodcrmoedanacional"))); // java.math.BigDecimal
                j34SiscomexAdicao.setValoriidevidozfm(c.getFloat(c.getColumnIndex("valoriidevidozfm"))); // java.math.BigDecimal
                j34SiscomexAdicao.setValoriiareceberzfm(c.getFloat(c.getColumnIndex("valoriiareceberzfm"))); // java.math.BigDecimal
                j34SiscomexAdicao.setValormercadoriacondicaovenda(c.getFloat(c.getColumnIndex("valormercadoriacondicaovenda"))); // java.math.BigDecimal
                j34SiscomexAdicao.setValormercadoriaembarquemoedanacional(c.getFloat(c.getColumnIndex("valormercadoriaembarquemoedanacional"))); // java.math.BigDecimal
                j34SiscomexAdicao.setValormercadoriavendamoedanacional(c.getFloat(c.getColumnIndex("valormercadoriavendamoedanacional"))); // java.math.BigDecimal
                j34SiscomexAdicao.setValorseguromercadoriamoedanacional(c.getFloat(c.getColumnIndex("valorseguromercadoriamoedanacional"))); // java.math.BigDecimal
                j34SiscomexAdicao.setValorseguromercadoriamoedanegociada(c.getFloat(c.getColumnIndex("valorseguromercadoriamoedanegociada"))); // java.math.BigDecimal
                return j34SiscomexAdicao ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexAdicao j34SiscomexAdicao) throws SQLException {

                
                setValue(ps, i++, j34SiscomexAdicao.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigoacordoaladi() ) ; // "codigoacordoaladi" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigoaplicacaomercadoria() ) ; // "codigoaplicacaomercadoria" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigoausenciafabricante() ) ; // "codigoausenciafabricante" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigocoberturacambial() ) ; // "codigocoberturacambial" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigofundamentolegalreduzido() ) ; // "codigofundamentolegalreduzido" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigofundamentolegalregime() ) ; // "codigofundamentolegalregime" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigofundamentolegalregimepiscofins() ) ; // "codigofundamentolegalregimepiscofins" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigoincotermsvenda() ) ; // "codigoincotermsvenda" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigomercadorianbmsh() ) ; // "codigomercadorianbmsh" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigomercadoriancm() ) ; // "codigomercadoriancm" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigomercadorianaladincc() ) ; // "codigomercadorianaladincc" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigoordemmercadorianaladincc() ) ; // "codigoordemmercadorianaladincc" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigomercadorianaladish() ) ; // "codigomercadorianaladish" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigoordemmercadorianaladish() ) ; // "codigoordemmercadorianaladish" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigometodovaloracao() ) ; // "codigometodovaloracao" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigomoedafretemercadoria() ) ; // "codigomoedafretemercadoria" : java.lang.Integer
                setValue(ps, i++, j34SiscomexAdicao.getCodigomoedaseguromercadoria() ) ; // "codigomoedaseguromercadoria" : java.lang.Integer
                setValue(ps, i++, j34SiscomexAdicao.getCodigomoedanegociada() ) ; // "codigomoedanegociada" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigomotivoadmissaotemporaria() ) ; // "codigomotivoadmissaotemporaria" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigomotivosemcobertura() ) ; // "codigomotivosemcobertura" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigoorgaofinanciamentointernacional() ) ; // "codigoorgaofinanciamentointernacional" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigopaisorigemmercadoria() ) ; // "codigopaisorigemmercadoria" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigopaisaquisicaomercadoria() ) ; // "codigopaisaquisicaomercadoria" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigopaisprocedenciamercadoria() ) ; // "codigopaisprocedenciamercadoria" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigoregimetriburariopiscofins() ) ; // "codigoregimetriburariopiscofins" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigoregimetributacao() ) ; // "codigoregimetributacao" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigotipoacordotarifario() ) ; // "codigotipoacordotarifario" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigourfentradamercadoria() ) ; // "codigourfentradamercadoria" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigoviatransporte() ) ; // "codigoviatransporte" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigovinculoimportadorexportador() ) ; // "codigovinculoimportadorexportador" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigofabricante() ) ; // "codigofabricante" : java.lang.Integer
                setValue(ps, i++, j34SiscomexAdicao.getCodigofornecedorestrangeiro() ) ; // "codigofornecedorestrangeiro" : java.lang.Integer
                setValue(ps, i++, j34SiscomexAdicao.getIndicadorbemencomenda() ) ; // "indicadorbemencomenda" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getIndicadormaterialusado() ) ; // "indicadormaterialusado" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getIndicadormultimodal() ) ; // "indicadormultimodal" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getIndicadortipocertificado() ) ; // "indicadortipocertificado" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getNomelocalcondicaovenda() ) ; // "nomelocalcondicaovenda" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getNumerodocumentoreducao() ) ; // "numerodocumentoreducao" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getNumeroidentificacaoli() ) ; // "numeroidentificacaoli" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getNumerorof() ) ; // "numerorof" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getPercentualcoeficientereducaoii() ) ; // "percentualcoeficientereducaoii" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getPesoliquidomercadoria() ) ; // "pesoliquidomercadoria" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getQuantidadeunidadeestatistica() ) ; // "quantidadeunidadeestatistica" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getTextocomplementovaloraduaneiro() ) ; // "textocomplementovaloraduaneiro" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getValoraliquotaicms() ) ; // "valoraliquotaicms" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValorcalculodcrdolar() ) ; // "valorcalculodcrdolar" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValorfinanciadosuperior360() ) ; // "valorfinanciadosuperior360" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValorfretemercadoriamoedanacional() ) ; // "valorfretemercadoriamoedanacional" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValorfretemercadoriamoedanegociada() ) ; // "valorfretemercadoriamoedanegociada" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValoriicalculadodcrmoedanacional() ) ; // "valoriicalculadodcrmoedanacional" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValoriidevidozfm() ) ; // "valoriidevidozfm" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValoriiareceberzfm() ) ; // "valoriiareceberzfm" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValormercadoriacondicaovenda() ) ; // "valormercadoriacondicaovenda" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValormercadoriaembarquemoedanacional() ) ; // "valormercadoriaembarquemoedanacional" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValormercadoriavendamoedanacional() ) ; // "valormercadoriavendamoedanacional" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValorseguromercadoriamoedanacional() ) ; // "valorseguromercadoriamoedanacional" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValorseguromercadoriamoedanegociada() ) ; // "valorseguromercadoriamoedanegociada" : java.math.BigDecimal
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexAdicao j34SiscomexAdicao) throws SQLException {

                
                setValue(ps, i++, j34SiscomexAdicao.getCodigoacordoaladi() ) ; // "codigoacordoaladi" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigoaplicacaomercadoria() ) ; // "codigoaplicacaomercadoria" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigoausenciafabricante() ) ; // "codigoausenciafabricante" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigocoberturacambial() ) ; // "codigocoberturacambial" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigofundamentolegalreduzido() ) ; // "codigofundamentolegalreduzido" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigofundamentolegalregime() ) ; // "codigofundamentolegalregime" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigofundamentolegalregimepiscofins() ) ; // "codigofundamentolegalregimepiscofins" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigoincotermsvenda() ) ; // "codigoincotermsvenda" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigomercadorianbmsh() ) ; // "codigomercadorianbmsh" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigomercadoriancm() ) ; // "codigomercadoriancm" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigomercadorianaladincc() ) ; // "codigomercadorianaladincc" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigoordemmercadorianaladincc() ) ; // "codigoordemmercadorianaladincc" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigomercadorianaladish() ) ; // "codigomercadorianaladish" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigoordemmercadorianaladish() ) ; // "codigoordemmercadorianaladish" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigometodovaloracao() ) ; // "codigometodovaloracao" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigomoedafretemercadoria() ) ; // "codigomoedafretemercadoria" : java.lang.Integer
                setValue(ps, i++, j34SiscomexAdicao.getCodigomoedaseguromercadoria() ) ; // "codigomoedaseguromercadoria" : java.lang.Integer
                setValue(ps, i++, j34SiscomexAdicao.getCodigomoedanegociada() ) ; // "codigomoedanegociada" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigomotivoadmissaotemporaria() ) ; // "codigomotivoadmissaotemporaria" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigomotivosemcobertura() ) ; // "codigomotivosemcobertura" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigoorgaofinanciamentointernacional() ) ; // "codigoorgaofinanciamentointernacional" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigopaisorigemmercadoria() ) ; // "codigopaisorigemmercadoria" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigopaisaquisicaomercadoria() ) ; // "codigopaisaquisicaomercadoria" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigopaisprocedenciamercadoria() ) ; // "codigopaisprocedenciamercadoria" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigoregimetriburariopiscofins() ) ; // "codigoregimetriburariopiscofins" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigoregimetributacao() ) ; // "codigoregimetributacao" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigotipoacordotarifario() ) ; // "codigotipoacordotarifario" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigourfentradamercadoria() ) ; // "codigourfentradamercadoria" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigoviatransporte() ) ; // "codigoviatransporte" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigovinculoimportadorexportador() ) ; // "codigovinculoimportadorexportador" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getCodigofabricante() ) ; // "codigofabricante" : java.lang.Integer
                setValue(ps, i++, j34SiscomexAdicao.getCodigofornecedorestrangeiro() ) ; // "codigofornecedorestrangeiro" : java.lang.Integer
                setValue(ps, i++, j34SiscomexAdicao.getIndicadorbemencomenda() ) ; // "indicadorbemencomenda" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getIndicadormaterialusado() ) ; // "indicadormaterialusado" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getIndicadormultimodal() ) ; // "indicadormultimodal" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getIndicadortipocertificado() ) ; // "indicadortipocertificado" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getNomelocalcondicaovenda() ) ; // "nomelocalcondicaovenda" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getNumerodocumentoreducao() ) ; // "numerodocumentoreducao" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getNumeroidentificacaoli() ) ; // "numeroidentificacaoli" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getNumerorof() ) ; // "numerorof" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getPercentualcoeficientereducaoii() ) ; // "percentualcoeficientereducaoii" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getPesoliquidomercadoria() ) ; // "pesoliquidomercadoria" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getQuantidadeunidadeestatistica() ) ; // "quantidadeunidadeestatistica" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getTextocomplementovaloraduaneiro() ) ; // "textocomplementovaloraduaneiro" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getValoraliquotaicms() ) ; // "valoraliquotaicms" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValorcalculodcrdolar() ) ; // "valorcalculodcrdolar" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValorfinanciadosuperior360() ) ; // "valorfinanciadosuperior360" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValorfretemercadoriamoedanacional() ) ; // "valorfretemercadoriamoedanacional" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValorfretemercadoriamoedanegociada() ) ; // "valorfretemercadoriamoedanegociada" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValoriicalculadodcrmoedanacional() ) ; // "valoriicalculadodcrmoedanacional" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValoriidevidozfm() ) ; // "valoriidevidozfm" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValoriiareceberzfm() ) ; // "valoriiareceberzfm" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValormercadoriacondicaovenda() ) ; // "valormercadoriacondicaovenda" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValormercadoriaembarquemoedanacional() ) ; // "valormercadoriaembarquemoedanacional" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValormercadoriavendamoedanacional() ) ; // "valormercadoriavendamoedanacional" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValorseguromercadoriamoedanacional() ) ; // "valorseguromercadoriamoedanacional" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexAdicao.getValorseguromercadoriamoedanegociada() ) ; // "valorseguromercadoriamoedanegociada" : java.math.BigDecimal
                
                setValue(ps, i++, j34SiscomexAdicao.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexAdicao.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
        }

}
