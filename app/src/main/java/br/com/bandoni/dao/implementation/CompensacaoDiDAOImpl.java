package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.CompensacaoDiDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexCompensacaoDi;

/**
 * J34SiscomexCompensacaoDi: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class CompensacaoDiDAOImpl extends GenericDAO<J34SiscomexCompensacaoDi> implements CompensacaoDiDAO {

        private final static String SQL_SELECT = 
                "select numerodocumentocarga, ordem, codigoreceitacredito, numerodocumentogeradorcredito, valorcompensarcredito from j34_siscomex_compensacao_di where numerodocumentocarga = ? and ordem = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_compensacao_di ( numerodocumentocarga, ordem, codigoreceitacredito, numerodocumentogeradorcredito, valorcompensarcredito ) values ( ?, ?, ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_compensacao_di set codigoreceitacredito = ?, numerodocumentogeradorcredito = ?, valorcompensarcredito = ? where numerodocumentocarga = ? and ordem = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_compensacao_di where numerodocumentocarga = ? and ordem = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_compensacao_di";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_compensacao_di where numerodocumentocarga = ? and ordem = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public CompensacaoDiDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param numerodocumentocarga;
         * @param ordem;
         * @return A nova inst�ncia
         */
        private J34SiscomexCompensacaoDi newInstanceWithPrimaryKey( String numerodocumentocarga, Integer ordem ) {
                J34SiscomexCompensacaoDi j34SiscomexCompensacaoDi = new J34SiscomexCompensacaoDi();
                j34SiscomexCompensacaoDi.setNumerodocumentocarga( numerodocumentocarga );
                j34SiscomexCompensacaoDi.setOrdem( ordem );
                return j34SiscomexCompensacaoDi ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga;
         * @param ordem;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexCompensacaoDi find( String numerodocumentocarga, Integer ordem )
        {
                J34SiscomexCompensacaoDi j34SiscomexCompensacaoDi = newInstanceWithPrimaryKey( numerodocumentocarga, ordem ) ;
                if ( super.doSelect(j34SiscomexCompensacaoDi) )
                {
                        return j34SiscomexCompensacaoDi ;
                }
                else
                {
                        return null ; // Not found
                }
        }
        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexCompensacaoDi
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexCompensacaoDi j34SiscomexCompensacaoDi ) {
                return super.doSelect(j34SiscomexCompensacaoDi) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexCompensacaoDi
         */
        @Override
        public void insert(J34SiscomexCompensacaoDi j34SiscomexCompensacaoDi) {
                super.doInsert(j34SiscomexCompensacaoDi);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexCompensacaoDi
         * @return
         */
        @Override
        public int update(J34SiscomexCompensacaoDi j34SiscomexCompensacaoDi) {
                return super.doUpdate(j34SiscomexCompensacaoDi);
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
                J34SiscomexCompensacaoDi j34SiscomexCompensacaoDi = newInstanceWithPrimaryKey( numerodocumentocarga, ordem ) ;
                return super.doDelete(j34SiscomexCompensacaoDi);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexCompensacaoDi
         * @return
         */
        @Override
        public int delete( J34SiscomexCompensacaoDi j34SiscomexCompensacaoDi ) {
                return super.doDelete(j34SiscomexCompensacaoDi);
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
                J34SiscomexCompensacaoDi j34SiscomexCompensacaoDi = newInstanceWithPrimaryKey( numerodocumentocarga, ordem ) ;
                return super.doExists(j34SiscomexCompensacaoDi);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexCompensacaoDi
         * @return
         */
        @Override
        public boolean exists( J34SiscomexCompensacaoDi j34SiscomexCompensacaoDi ) {
                return super.doExists(j34SiscomexCompensacaoDi);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexCompensacaoDi j34SiscomexCompensacaoDi) throws SQLException {
                
                setRawParameter(list,j34SiscomexCompensacaoDi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setRawParameter(list,j34SiscomexCompensacaoDi.getOrdem()) ; // "ordem" : java.lang.Integer
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexCompensacaoDi populateBean(Cursor c, J34SiscomexCompensacaoDi j34SiscomexCompensacaoDi) throws SQLException {

               
                j34SiscomexCompensacaoDi.setNumerodocumentocarga(c.getString(c.getColumnIndex("numerodocumentocarga"))); // java.lang.String
                j34SiscomexCompensacaoDi.setOrdem(c.getInt(c.getColumnIndex("ordem"))); // java.lang.Integer
                j34SiscomexCompensacaoDi.setCodigoreceitacredito(c.getString(c.getColumnIndex("codigoreceitacredito"))); // java.lang.String
                j34SiscomexCompensacaoDi.setNumerodocumentogeradorcredito(c.getString(c.getColumnIndex("numerodocumentogeradorcredito"))); // java.lang.String
                j34SiscomexCompensacaoDi.setValorcompensarcredito(c.getFloat(c.getColumnIndex("valorcompensarcredito"))); // java.math.BigDecimal
                return j34SiscomexCompensacaoDi ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexCompensacaoDi j34SiscomexCompensacaoDi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexCompensacaoDi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexCompensacaoDi.getOrdem() ) ; // "ordem" : java.lang.Integer
                setValue(ps, i++, j34SiscomexCompensacaoDi.getCodigoreceitacredito() ) ; // "codigoreceitacredito" : java.lang.String
                setValue(ps, i++, j34SiscomexCompensacaoDi.getNumerodocumentogeradorcredito() ) ; // "numerodocumentogeradorcredito" : java.lang.String
                setValue(ps, i++, j34SiscomexCompensacaoDi.getValorcompensarcredito() ) ; // "valorcompensarcredito" : java.math.BigDecimal
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexCompensacaoDi j34SiscomexCompensacaoDi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexCompensacaoDi.getCodigoreceitacredito() ) ; // "codigoreceitacredito" : java.lang.String
                setValue(ps, i++, j34SiscomexCompensacaoDi.getNumerodocumentogeradorcredito() ) ; // "numerodocumentogeradorcredito" : java.lang.String
                setValue(ps, i++, j34SiscomexCompensacaoDi.getValorcompensarcredito() ) ; // "valorcompensarcredito" : java.math.BigDecimal
                
                setValue(ps, i++, j34SiscomexCompensacaoDi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexCompensacaoDi.getOrdem() ) ; // "ordem" : java.lang.Integer
        }

}
