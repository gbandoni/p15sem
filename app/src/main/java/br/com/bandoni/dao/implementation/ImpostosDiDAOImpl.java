package br.com.bandoni.dao.implementation;

import android.content.Context;

import java.util.Date;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.ImpostosDiDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexImpostosDi;

/**
 * J34SiscomexImpostosDi: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class ImpostosDiDAOImpl extends GenericDAO<J34SiscomexImpostosDi> implements ImpostosDiDAO {

        private final static String SQL_SELECT = 
                "select numerodocumentocarga, ordem, codigobancopagamentotributo, codigoreceitapagamento, datapagamentotributo, numeroagenciapagamentotributo, valorjurospagamentotributo, valormultapagamentotributo, valortributopago from j34_siscomex_impostos_di where numerodocumentocarga = ? and ordem = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_impostos_di ( numerodocumentocarga, ordem, codigobancopagamentotributo, codigoreceitapagamento, datapagamentotributo, numeroagenciapagamentotributo, valorjurospagamentotributo, valormultapagamentotributo, valortributopago ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_impostos_di set codigobancopagamentotributo = ?, codigoreceitapagamento = ?, datapagamentotributo = ?, numeroagenciapagamentotributo = ?, valorjurospagamentotributo = ?, valormultapagamentotributo = ?, valortributopago = ? where numerodocumentocarga = ? and ordem = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_impostos_di where numerodocumentocarga = ? and ordem = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_impostos_di";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_impostos_di where numerodocumentocarga = ? and ordem = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public ImpostosDiDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param numerodocumentocarga;
         * @param ordem;
         * @return A nova inst�ncia
         */
        private J34SiscomexImpostosDi newInstanceWithPrimaryKey( String numerodocumentocarga, Integer ordem ) {
                J34SiscomexImpostosDi j34SiscomexImpostosDi = new J34SiscomexImpostosDi();
                j34SiscomexImpostosDi.setNumerodocumentocarga( numerodocumentocarga );
                j34SiscomexImpostosDi.setOrdem( ordem );
                return j34SiscomexImpostosDi ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga;
         * @param ordem;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexImpostosDi find( String numerodocumentocarga, Integer ordem ) {
                J34SiscomexImpostosDi j34SiscomexImpostosDi = newInstanceWithPrimaryKey( numerodocumentocarga, ordem ) ;
                if ( super.doSelect(j34SiscomexImpostosDi) ) {
                        return j34SiscomexImpostosDi ;
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
         * @param j34SiscomexImpostosDi
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexImpostosDi j34SiscomexImpostosDi ) {
                return super.doSelect(j34SiscomexImpostosDi) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexImpostosDi
         */
        @Override
        public void insert(J34SiscomexImpostosDi j34SiscomexImpostosDi) {
                super.doInsert(j34SiscomexImpostosDi);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexImpostosDi
         * @return
         */
        @Override
        public int update(J34SiscomexImpostosDi j34SiscomexImpostosDi) {
                return super.doUpdate(j34SiscomexImpostosDi);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param numerodocumentocarga;
         * @param ordem;
         * @return
         */
        @Override
        public int delete( String numerodocumentocarga, Integer ordem ) {
                J34SiscomexImpostosDi j34SiscomexImpostosDi = newInstanceWithPrimaryKey( numerodocumentocarga, ordem ) ;
                return super.doDelete(j34SiscomexImpostosDi);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexImpostosDi
         * @return
         */
        @Override
        public int delete( J34SiscomexImpostosDi j34SiscomexImpostosDi ) {
                return super.doDelete(j34SiscomexImpostosDi);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param numerodocumentocarga;
         * @param ordem;
         * @return
         */
        @Override
        public boolean exists( String numerodocumentocarga, Integer ordem ) {
                J34SiscomexImpostosDi j34SiscomexImpostosDi = newInstanceWithPrimaryKey( numerodocumentocarga, ordem ) ;
                return super.doExists(j34SiscomexImpostosDi);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexImpostosDi
         * @return
         */
        @Override
        public boolean exists( J34SiscomexImpostosDi j34SiscomexImpostosDi ) {
                return super.doExists(j34SiscomexImpostosDi);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexImpostosDi j34SiscomexImpostosDi) throws SQLException {
                
                setRawParameter(list, j34SiscomexImpostosDi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setRawParameter(list, j34SiscomexImpostosDi.getOrdem() ) ; // "ordem" : java.lang.Integer
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexImpostosDi populateBean(Cursor c, J34SiscomexImpostosDi j34SiscomexImpostosDi) throws SQLException {

               
                j34SiscomexImpostosDi.setNumerodocumentocarga(c.getString(c.getColumnIndex("numerodocumentocarga"))); // java.lang.String
                j34SiscomexImpostosDi.setOrdem(c.getInt(c.getColumnIndex("ordem"))); // java.lang.Integer
                j34SiscomexImpostosDi.setCodigobancopagamentotributo(c.getString(c.getColumnIndex("codigobancopagamentotributo"))); // java.lang.String
                j34SiscomexImpostosDi.setCodigoreceitapagamento(c.getString(c.getColumnIndex("codigoreceitapagamento"))); // java.lang.String
                j34SiscomexImpostosDi.setDatapagamentotributo(new Date(c.getLong(c.getColumnIndex("datapagamentotributo")))); // java.util.Date
                j34SiscomexImpostosDi.setNumeroagenciapagamentotributo(c.getString(c.getColumnIndex("numeroagenciapagamentotributo"))); // java.lang.String
                j34SiscomexImpostosDi.setValorjurospagamentotributo(c.getFloat(c.getColumnIndex("valorjurospagamentotributo"))); // java.math.BigDecimal
                j34SiscomexImpostosDi.setValormultapagamentotributo(c.getFloat(c.getColumnIndex("valormultapagamentotributo"))); // java.math.BigDecimal
                j34SiscomexImpostosDi.setValortributopago(c.getFloat(c.getColumnIndex("valortributopago"))); // java.math.BigDecimal
                return j34SiscomexImpostosDi ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexImpostosDi j34SiscomexImpostosDi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexImpostosDi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexImpostosDi.getOrdem() ) ; // "ordem" : java.lang.Integer
                setValue(ps, i++, j34SiscomexImpostosDi.getCodigobancopagamentotributo() ) ; // "codigobancopagamentotributo" : java.lang.String
                setValue(ps, i++, j34SiscomexImpostosDi.getCodigoreceitapagamento() ) ; // "codigoreceitapagamento" : java.lang.String
                setValue(ps, i++, j34SiscomexImpostosDi.getDatapagamentotributo() ) ; // "datapagamentotributo" : java.util.Date
                setValue(ps, i++, j34SiscomexImpostosDi.getNumeroagenciapagamentotributo() ) ; // "numeroagenciapagamentotributo" : java.lang.String
                setValue(ps, i++, j34SiscomexImpostosDi.getValorjurospagamentotributo() ) ; // "valorjurospagamentotributo" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexImpostosDi.getValormultapagamentotributo() ) ; // "valormultapagamentotributo" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexImpostosDi.getValortributopago() ) ; // "valortributopago" : java.math.BigDecimal
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexImpostosDi j34SiscomexImpostosDi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexImpostosDi.getCodigobancopagamentotributo() ) ; // "codigobancopagamentotributo" : java.lang.String
                setValue(ps, i++, j34SiscomexImpostosDi.getCodigoreceitapagamento() ) ; // "codigoreceitapagamento" : java.lang.String
                setValue(ps, i++, j34SiscomexImpostosDi.getDatapagamentotributo() ) ; // "datapagamentotributo" : java.util.Date
                setValue(ps, i++, j34SiscomexImpostosDi.getNumeroagenciapagamentotributo() ) ; // "numeroagenciapagamentotributo" : java.lang.String
                setValue(ps, i++, j34SiscomexImpostosDi.getValorjurospagamentotributo() ) ; // "valorjurospagamentotributo" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexImpostosDi.getValormultapagamentotributo() ) ; // "valormultapagamentotributo" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexImpostosDi.getValortributopago() ) ; // "valortributopago" : java.math.BigDecimal
                
                setValue(ps, i++, j34SiscomexImpostosDi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexImpostosDi.getOrdem() ) ; // "ordem" : java.lang.Integer
        }

}
