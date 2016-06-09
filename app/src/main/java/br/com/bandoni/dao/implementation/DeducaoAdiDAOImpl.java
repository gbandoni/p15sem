package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.DeducaoAdiDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexDeducaoAdi;

/**
 * J34SiscomexDeducaoAdi: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class DeducaoAdiDAOImpl extends GenericDAO<J34SiscomexDeducaoAdi> implements DeducaoAdiDAO {

        private final static String SQL_SELECT = 
                "select numerodocumentocarga, numeroadicao, codigometododeducaovalor, codigomoedanegociadadeducao, valordeducaomoedanacional, valordeducaomoedanegociada from j34_siscomex_deducao_adi where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_deducao_adi ( numerodocumentocarga, numeroadicao, codigometododeducaovalor, codigomoedanegociadadeducao, valordeducaomoedanacional, valordeducaomoedanegociada ) values ( ?, ?, ?, ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_deducao_adi set codigometododeducaovalor = ?, codigomoedanegociadadeducao = ?, valordeducaomoedanacional = ?, valordeducaomoedanegociada = ? where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_deducao_adi where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_deducao_adi";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_deducao_adi where numerodocumentocarga = ? and numeroadicao = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public DeducaoAdiDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @return A nova inst�ncia
         */
        private J34SiscomexDeducaoAdi newInstanceWithPrimaryKey( String numerodocumentocarga, String numeroadicao ) {
                J34SiscomexDeducaoAdi j34SiscomexDeducaoAdi = new J34SiscomexDeducaoAdi();
                j34SiscomexDeducaoAdi.setNumerodocumentocarga( numerodocumentocarga );
                j34SiscomexDeducaoAdi.setNumeroadicao( numeroadicao );
                return j34SiscomexDeducaoAdi ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexDeducaoAdi find( String numerodocumentocarga, String numeroadicao ) {
                J34SiscomexDeducaoAdi j34SiscomexDeducaoAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                if ( super.doSelect(j34SiscomexDeducaoAdi) ) {
                        return j34SiscomexDeducaoAdi ;
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
         * @param j34SiscomexDeducaoAdi
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexDeducaoAdi j34SiscomexDeducaoAdi ) {
                return super.doSelect(j34SiscomexDeducaoAdi) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexDeducaoAdi
         */
        @Override
        public void insert(J34SiscomexDeducaoAdi j34SiscomexDeducaoAdi) {
                super.doInsert(j34SiscomexDeducaoAdi);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexDeducaoAdi
         * @return
         */
        @Override
        public int update(J34SiscomexDeducaoAdi j34SiscomexDeducaoAdi) {
                return super.doUpdate(j34SiscomexDeducaoAdi);
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
                J34SiscomexDeducaoAdi j34SiscomexDeducaoAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                return super.doDelete(j34SiscomexDeducaoAdi);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexDeducaoAdi
         * @return
         */
        @Override
        public int delete( J34SiscomexDeducaoAdi j34SiscomexDeducaoAdi ) {
                return super.doDelete(j34SiscomexDeducaoAdi);
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
                J34SiscomexDeducaoAdi j34SiscomexDeducaoAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                return super.doExists(j34SiscomexDeducaoAdi);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexDeducaoAdi
         * @return
         */
        @Override
        public boolean exists( J34SiscomexDeducaoAdi j34SiscomexDeducaoAdi ) {
                return super.doExists(j34SiscomexDeducaoAdi);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexDeducaoAdi j34SiscomexDeducaoAdi) throws SQLException {
                
                setRawParameter(list,j34SiscomexDeducaoAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setRawParameter(list,j34SiscomexDeducaoAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexDeducaoAdi populateBean(Cursor c, J34SiscomexDeducaoAdi j34SiscomexDeducaoAdi) throws SQLException {

               
                j34SiscomexDeducaoAdi.setNumerodocumentocarga(c.getString(c.getColumnIndex("numerodocumentocarga"))); // java.lang.String
                j34SiscomexDeducaoAdi.setNumeroadicao(c.getString(c.getColumnIndex("numeroadicao"))); // java.lang.String
                j34SiscomexDeducaoAdi.setCodigometododeducaovalor(c.getString(c.getColumnIndex("codigometododeducaovalor"))); // java.lang.String
                j34SiscomexDeducaoAdi.setCodigomoedanegociadadeducao(c.getInt(c.getColumnIndex("codigomoedanegociadadeducao"))); // java.lang.Integer
                j34SiscomexDeducaoAdi.setValordeducaomoedanacional(c.getFloat(c.getColumnIndex("valordeducaomoedanacional"))); // java.math.BigDecimal
                j34SiscomexDeducaoAdi.setValordeducaomoedanegociada(c.getFloat(c.getColumnIndex("valordeducaomoedanegociada"))); // java.math.BigDecimal
                return j34SiscomexDeducaoAdi ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexDeducaoAdi j34SiscomexDeducaoAdi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexDeducaoAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexDeducaoAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
                setValue(ps, i++, j34SiscomexDeducaoAdi.getCodigometododeducaovalor() ) ; // "codigometododeducaovalor" : java.lang.String
                setValue(ps, i++, j34SiscomexDeducaoAdi.getCodigomoedanegociadadeducao() ) ; // "codigomoedanegociadadeducao" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDeducaoAdi.getValordeducaomoedanacional() ) ; // "valordeducaomoedanacional" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexDeducaoAdi.getValordeducaomoedanegociada() ) ; // "valordeducaomoedanegociada" : java.math.BigDecimal
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexDeducaoAdi j34SiscomexDeducaoAdi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexDeducaoAdi.getCodigometododeducaovalor() ) ; // "codigometododeducaovalor" : java.lang.String
                setValue(ps, i++, j34SiscomexDeducaoAdi.getCodigomoedanegociadadeducao() ) ; // "codigomoedanegociadadeducao" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDeducaoAdi.getValordeducaomoedanacional() ) ; // "valordeducaomoedanacional" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexDeducaoAdi.getValordeducaomoedanegociada() ) ; // "valordeducaomoedanegociada" : java.math.BigDecimal
                
                setValue(ps, i++, j34SiscomexDeducaoAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexDeducaoAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
        }

}
