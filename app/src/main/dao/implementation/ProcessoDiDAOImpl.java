package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.ProcessoDiDAO;
import br.com.bandoni.dao.tables.J34SiscomexProcessoDi;

/**
 * J34SiscomexProcessoDi: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class ProcessoDiDAOImpl extends GenericDAO<J34SiscomexProcessoDi> implements ProcessoDiDAO {

        private final static String SQL_SELECT = 
                "select numerodocumentocarga, ordem, codigotipoprocesso, numeroprocesso from j34_siscomex_processo_di where numerodocumentocarga = ? and ordem = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_processo_di ( numerodocumentocarga, ordem, codigotipoprocesso, numeroprocesso ) values ( ?, ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_processo_di set codigotipoprocesso = ?, numeroprocesso = ? where numerodocumentocarga = ? and ordem = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_processo_di where numerodocumentocarga = ? and ordem = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_processo_di";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_processo_di where numerodocumentocarga = ? and ordem = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public ProcessoDiDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param numerodocumentocarga;
         * @param ordem;
         * @return A nova inst�ncia
         */
        private J34SiscomexProcessoDi newInstanceWithPrimaryKey( String numerodocumentocarga, Integer ordem ) {
                J34SiscomexProcessoDi j34SiscomexProcessoDi = new J34SiscomexProcessoDi();
                j34SiscomexProcessoDi.setNumerodocumentocarga( numerodocumentocarga );
                j34SiscomexProcessoDi.setOrdem( ordem );
                return j34SiscomexProcessoDi ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga;
         * @param ordem;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexProcessoDi find( String numerodocumentocarga, Integer ordem ) {
                J34SiscomexProcessoDi j34SiscomexProcessoDi = newInstanceWithPrimaryKey( numerodocumentocarga, ordem ) ;
                if ( super.doSelect(j34SiscomexProcessoDi) ) {
                        return j34SiscomexProcessoDi ;
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
         * @param j34SiscomexProcessoDi
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexProcessoDi j34SiscomexProcessoDi ) {
                return super.doSelect(j34SiscomexProcessoDi) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexProcessoDi
         */
        @Override
        public void insert(J34SiscomexProcessoDi j34SiscomexProcessoDi) {
                super.doInsert(j34SiscomexProcessoDi);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexProcessoDi
         * @return
         */
        @Override
        public int update(J34SiscomexProcessoDi j34SiscomexProcessoDi) {
                return super.doUpdate(j34SiscomexProcessoDi);
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
                J34SiscomexProcessoDi j34SiscomexProcessoDi = newInstanceWithPrimaryKey( numerodocumentocarga, ordem ) ;
                return super.doDelete(j34SiscomexProcessoDi);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexProcessoDi
         * @return
         */
        @Override
        public int delete( J34SiscomexProcessoDi j34SiscomexProcessoDi ) {
                return super.doDelete(j34SiscomexProcessoDi);
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
                J34SiscomexProcessoDi j34SiscomexProcessoDi = newInstanceWithPrimaryKey( numerodocumentocarga, ordem ) ;
                return super.doExists(j34SiscomexProcessoDi);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexProcessoDi
         * @return
         */
        @Override
        public boolean exists( J34SiscomexProcessoDi j34SiscomexProcessoDi ) {
                return super.doExists(j34SiscomexProcessoDi);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexProcessoDi j34SiscomexProcessoDi) throws SQLException {
                
                setRawParameter(list, j34SiscomexProcessoDi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setRawParameter(list, j34SiscomexProcessoDi.getOrdem()) ; // "ordem" : java.lang.Integer
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexProcessoDi populateBean(Cursor c, J34SiscomexProcessoDi j34SiscomexProcessoDi) throws SQLException {

               
                j34SiscomexProcessoDi.setNumerodocumentocarga(c.getString(c.getColumnIndex("numerodocumentocarga"))); // java.lang.String
                j34SiscomexProcessoDi.setOrdem(c.getInt(c.getColumnIndex("ordem"))); // java.lang.Integer
                j34SiscomexProcessoDi.setCodigotipoprocesso(c.getInt(c.getColumnIndex("codigotipoprocesso"))); // java.lang.Integer
                j34SiscomexProcessoDi.setNumeroprocesso(c.getString(c.getColumnIndex("numeroprocesso"))); // java.lang.String
                return j34SiscomexProcessoDi ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexProcessoDi j34SiscomexProcessoDi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexProcessoDi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexProcessoDi.getOrdem() ) ; // "ordem" : java.lang.Integer
                setValue(ps, i++, j34SiscomexProcessoDi.getCodigotipoprocesso() ) ; // "codigotipoprocesso" : java.lang.Integer
                setValue(ps, i++, j34SiscomexProcessoDi.getNumeroprocesso() ) ; // "numeroprocesso" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexProcessoDi j34SiscomexProcessoDi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexProcessoDi.getCodigotipoprocesso() ) ; // "codigotipoprocesso" : java.lang.Integer
                setValue(ps, i++, j34SiscomexProcessoDi.getNumeroprocesso() ) ; // "numeroprocesso" : java.lang.String
                
                setValue(ps, i++, j34SiscomexProcessoDi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexProcessoDi.getOrdem() ) ; // "ordem" : java.lang.Integer
        }

}
