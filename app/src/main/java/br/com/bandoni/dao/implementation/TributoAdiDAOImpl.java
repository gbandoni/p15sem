package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.TributoAdiDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexTributoAdi;

/**
 * J34SiscomexTributoAdi: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class TributoAdiDAOImpl extends GenericDAO<J34SiscomexTributoAdi> implements TributoAdiDAO {

        private final static String SQL_SELECT = 
                "select numerodocumentocarga, numeroadicao, codigoreceitaimposto, codigotipoaliquotaipt, codigotipobeneficioipi, codigotipodireito, codigotiporecipiente, nomeunidadeespecificaaliquotaipt, numeronotacomplementartipi, percentualaliquotaacordotarifario, percentualaliquotanormaladval, percentualaliquotareduzida, percentualreducaoipt, quantidademlrecipiente, quantidademercadoriaunidadealiquotaespecifica, valoraliquotaespecificaipt, valorbasecalculoadval, valorcalculadoiiactarifario, valorcalculoiptespecifica, valorcalculoiptadval, valoriptarecolher, valorimpostodevido from j34_siscomex_tributo_adi where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_tributo_adi ( numerodocumentocarga, numeroadicao, codigoreceitaimposto, codigotipoaliquotaipt, codigotipobeneficioipi, codigotipodireito, codigotiporecipiente, nomeunidadeespecificaaliquotaipt, numeronotacomplementartipi, percentualaliquotaacordotarifario, percentualaliquotanormaladval, percentualaliquotareduzida, percentualreducaoipt, quantidademlrecipiente, quantidademercadoriaunidadealiquotaespecifica, valoraliquotaespecificaipt, valorbasecalculoadval, valorcalculadoiiactarifario, valorcalculoiptespecifica, valorcalculoiptadval, valoriptarecolher, valorimpostodevido ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_tributo_adi set codigoreceitaimposto = ?, codigotipoaliquotaipt = ?, codigotipobeneficioipi = ?, codigotipodireito = ?, codigotiporecipiente = ?, nomeunidadeespecificaaliquotaipt = ?, numeronotacomplementartipi = ?, percentualaliquotaacordotarifario = ?, percentualaliquotanormaladval = ?, percentualaliquotareduzida = ?, percentualreducaoipt = ?, quantidademlrecipiente = ?, quantidademercadoriaunidadealiquotaespecifica = ?, valoraliquotaespecificaipt = ?, valorbasecalculoadval = ?, valorcalculadoiiactarifario = ?, valorcalculoiptespecifica = ?, valorcalculoiptadval = ?, valoriptarecolher = ?, valorimpostodevido = ? where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_tributo_adi where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_tributo_adi";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_tributo_adi where numerodocumentocarga = ? and numeroadicao = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public TributoAdiDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @return A nova inst�ncia
         */
        private J34SiscomexTributoAdi newInstanceWithPrimaryKey( String numerodocumentocarga, String numeroadicao ) {
                J34SiscomexTributoAdi j34SiscomexTributoAdi = new J34SiscomexTributoAdi();
                j34SiscomexTributoAdi.setNumerodocumentocarga( numerodocumentocarga );
                j34SiscomexTributoAdi.setNumeroadicao( numeroadicao );
                return j34SiscomexTributoAdi ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexTributoAdi find( String numerodocumentocarga, String numeroadicao ) {
                J34SiscomexTributoAdi j34SiscomexTributoAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                if ( super.doSelect(j34SiscomexTributoAdi) ) {
                        return j34SiscomexTributoAdi ;
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
         * @param j34SiscomexTributoAdi
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexTributoAdi j34SiscomexTributoAdi ) {
                return super.doSelect(j34SiscomexTributoAdi) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexTributoAdi
         */
        @Override
        public void insert(J34SiscomexTributoAdi j34SiscomexTributoAdi) {
                super.doInsert(j34SiscomexTributoAdi);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexTributoAdi
         * @return
         */
        @Override
        public int update(J34SiscomexTributoAdi j34SiscomexTributoAdi) {
                return super.doUpdate(j34SiscomexTributoAdi);
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
                J34SiscomexTributoAdi j34SiscomexTributoAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                return super.doDelete(j34SiscomexTributoAdi);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexTributoAdi
         * @return
         */
        @Override
        public int delete( J34SiscomexTributoAdi j34SiscomexTributoAdi ) {
                return super.doDelete(j34SiscomexTributoAdi);
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
                J34SiscomexTributoAdi j34SiscomexTributoAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                return super.doExists(j34SiscomexTributoAdi);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexTributoAdi
         * @return
         */
        @Override
        public boolean exists( J34SiscomexTributoAdi j34SiscomexTributoAdi ) {
                return super.doExists(j34SiscomexTributoAdi);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexTributoAdi j34SiscomexTributoAdi) throws SQLException {
                
                setRawParameter(list, j34SiscomexTributoAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setRawParameter(list, j34SiscomexTributoAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexTributoAdi populateBean(Cursor c, J34SiscomexTributoAdi j34SiscomexTributoAdi) throws SQLException {

               
                j34SiscomexTributoAdi.setNumerodocumentocarga(c.getString(c.getColumnIndex("numerodocumentocarga"))); // java.lang.String
                j34SiscomexTributoAdi.setNumeroadicao(c.getString(c.getColumnIndex("numeroadicao"))); // java.lang.String
                j34SiscomexTributoAdi.setCodigoreceitaimposto(c.getString(c.getColumnIndex("codigoreceitaimposto"))); // java.lang.String
                j34SiscomexTributoAdi.setCodigotipoaliquotaipt(c.getString(c.getColumnIndex("codigotipoaliquotaipt"))); // java.lang.String
                j34SiscomexTributoAdi.setCodigotipobeneficioipi(c.getString(c.getColumnIndex("codigotipobeneficioipi"))); // java.lang.String
                j34SiscomexTributoAdi.setCodigotipodireito(c.getString(c.getColumnIndex("codigotipodireito"))); // java.lang.String
                j34SiscomexTributoAdi.setCodigotiporecipiente(c.getString(c.getColumnIndex("codigotiporecipiente"))); // java.lang.String
                j34SiscomexTributoAdi.setNomeunidadeespecificaaliquotaipt(c.getString(c.getColumnIndex("nomeunidadeespecificaaliquotaipt"))); // java.lang.String
                j34SiscomexTributoAdi.setNumeronotacomplementartipi(c.getFloat(c.getColumnIndex("numeronotacomplementartipi"))); // java.math.BigDecimal
                j34SiscomexTributoAdi.setPercentualaliquotaacordotarifario(c.getFloat(c.getColumnIndex("percentualaliquotaacordotarifario"))); // java.math.BigDecimal
                j34SiscomexTributoAdi.setPercentualaliquotanormaladval(c.getFloat(c.getColumnIndex("percentualaliquotanormaladval"))); // java.math.BigDecimal
                j34SiscomexTributoAdi.setPercentualaliquotareduzida(c.getFloat(c.getColumnIndex("percentualaliquotareduzida"))); // java.math.BigDecimal
                j34SiscomexTributoAdi.setPercentualreducaoipt(c.getFloat(c.getColumnIndex("percentualreducaoipt"))); // java.math.BigDecimal
                j34SiscomexTributoAdi.setQuantidademlrecipiente(c.getFloat(c.getColumnIndex("quantidademlrecipiente"))); // java.math.BigDecimal
                j34SiscomexTributoAdi.setQuantidademercadoriaunidadealiquotaespecifica(c.getFloat(c.getColumnIndex("quantidademercadoriaunidadealiquotaespecifica"))); // java.math.BigDecimal
                j34SiscomexTributoAdi.setValoraliquotaespecificaipt(c.getFloat(c.getColumnIndex("valoraliquotaespecificaipt"))); // java.math.BigDecimal
                j34SiscomexTributoAdi.setValorbasecalculoadval(c.getFloat(c.getColumnIndex("valorbasecalculoadval"))); // java.math.BigDecimal
                j34SiscomexTributoAdi.setValorcalculadoiiactarifario(c.getFloat(c.getColumnIndex("valorcalculadoiiactarifario"))); // java.math.BigDecimal
                j34SiscomexTributoAdi.setValorcalculoiptespecifica(c.getFloat(c.getColumnIndex("valorcalculoiptespecifica"))); // java.math.BigDecimal
                j34SiscomexTributoAdi.setValorcalculoiptadval(c.getFloat(c.getColumnIndex("valorcalculoiptadval"))); // java.math.BigDecimal
                j34SiscomexTributoAdi.setValoriptarecolher(c.getFloat(c.getColumnIndex("valoriptarecolher"))); // java.math.BigDecimal
                j34SiscomexTributoAdi.setValorimpostodevido(c.getFloat(c.getColumnIndex("valorimpostodevido"))); // java.math.BigDecimal
                return j34SiscomexTributoAdi ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexTributoAdi j34SiscomexTributoAdi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexTributoAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexTributoAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
                setValue(ps, i++, j34SiscomexTributoAdi.getCodigoreceitaimposto() ) ; // "codigoreceitaimposto" : java.lang.String
                setValue(ps, i++, j34SiscomexTributoAdi.getCodigotipoaliquotaipt() ) ; // "codigotipoaliquotaipt" : java.lang.String
                setValue(ps, i++, j34SiscomexTributoAdi.getCodigotipobeneficioipi() ) ; // "codigotipobeneficioipi" : java.lang.String
                setValue(ps, i++, j34SiscomexTributoAdi.getCodigotipodireito() ) ; // "codigotipodireito" : java.lang.String
                setValue(ps, i++, j34SiscomexTributoAdi.getCodigotiporecipiente() ) ; // "codigotiporecipiente" : java.lang.String
                setValue(ps, i++, j34SiscomexTributoAdi.getNomeunidadeespecificaaliquotaipt() ) ; // "nomeunidadeespecificaaliquotaipt" : java.lang.String
                setValue(ps, i++, j34SiscomexTributoAdi.getNumeronotacomplementartipi() ) ; // "numeronotacomplementartipi" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getPercentualaliquotaacordotarifario() ) ; // "percentualaliquotaacordotarifario" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getPercentualaliquotanormaladval() ) ; // "percentualaliquotanormaladval" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getPercentualaliquotareduzida() ) ; // "percentualaliquotareduzida" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getPercentualreducaoipt() ) ; // "percentualreducaoipt" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getQuantidademlrecipiente() ) ; // "quantidademlrecipiente" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getQuantidademercadoriaunidadealiquotaespecifica() ) ; // "quantidademercadoriaunidadealiquotaespecifica" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getValoraliquotaespecificaipt() ) ; // "valoraliquotaespecificaipt" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getValorbasecalculoadval() ) ; // "valorbasecalculoadval" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getValorcalculadoiiactarifario() ) ; // "valorcalculadoiiactarifario" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getValorcalculoiptespecifica() ) ; // "valorcalculoiptespecifica" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getValorcalculoiptadval() ) ; // "valorcalculoiptadval" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getValoriptarecolher() ) ; // "valoriptarecolher" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getValorimpostodevido() ) ; // "valorimpostodevido" : java.math.BigDecimal
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexTributoAdi j34SiscomexTributoAdi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexTributoAdi.getCodigoreceitaimposto() ) ; // "codigoreceitaimposto" : java.lang.String
                setValue(ps, i++, j34SiscomexTributoAdi.getCodigotipoaliquotaipt() ) ; // "codigotipoaliquotaipt" : java.lang.String
                setValue(ps, i++, j34SiscomexTributoAdi.getCodigotipobeneficioipi() ) ; // "codigotipobeneficioipi" : java.lang.String
                setValue(ps, i++, j34SiscomexTributoAdi.getCodigotipodireito() ) ; // "codigotipodireito" : java.lang.String
                setValue(ps, i++, j34SiscomexTributoAdi.getCodigotiporecipiente() ) ; // "codigotiporecipiente" : java.lang.String
                setValue(ps, i++, j34SiscomexTributoAdi.getNomeunidadeespecificaaliquotaipt() ) ; // "nomeunidadeespecificaaliquotaipt" : java.lang.String
                setValue(ps, i++, j34SiscomexTributoAdi.getNumeronotacomplementartipi() ) ; // "numeronotacomplementartipi" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getPercentualaliquotaacordotarifario() ) ; // "percentualaliquotaacordotarifario" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getPercentualaliquotanormaladval() ) ; // "percentualaliquotanormaladval" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getPercentualaliquotareduzida() ) ; // "percentualaliquotareduzida" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getPercentualreducaoipt() ) ; // "percentualreducaoipt" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getQuantidademlrecipiente() ) ; // "quantidademlrecipiente" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getQuantidademercadoriaunidadealiquotaespecifica() ) ; // "quantidademercadoriaunidadealiquotaespecifica" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getValoraliquotaespecificaipt() ) ; // "valoraliquotaespecificaipt" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getValorbasecalculoadval() ) ; // "valorbasecalculoadval" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getValorcalculadoiiactarifario() ) ; // "valorcalculadoiiactarifario" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getValorcalculoiptespecifica() ) ; // "valorcalculoiptespecifica" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getValorcalculoiptadval() ) ; // "valorcalculoiptadval" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getValoriptarecolher() ) ; // "valoriptarecolher" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexTributoAdi.getValorimpostodevido() ) ; // "valorimpostodevido" : java.math.BigDecimal
                
                setValue(ps, i++, j34SiscomexTributoAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexTributoAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
        }

}
