package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.ArmazemDiDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexArmazemDi;

/**
 * J34SiscomexArmazemDi: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class ArmazemDiDAOImpl extends GenericDAO<J34SiscomexArmazemDi> implements ArmazemDiDAO {

        private final static String SQL_SELECT = 
                "select numerodocumentocarga, ordem, nomearmazemcarga from j34_siscomex_armazem_di where numerodocumentocarga = ? and ordem = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_armazem_di ( numerodocumentocarga, ordem, nomearmazemcarga ) values ( ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_armazem_di set nomearmazemcarga = ? where numerodocumentocarga = ? and ordem = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_armazem_di where numerodocumentocarga = ? and ordem = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_armazem_di";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_armazem_di where numerodocumentocarga = ? and ordem = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public ArmazemDiDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param numerodocumentocarga;
         * @param ordem;
         * @return A nova inst�ncia
         */
        private J34SiscomexArmazemDi newInstanceWithPrimaryKey( String numerodocumentocarga, Integer ordem ) {
                J34SiscomexArmazemDi j34SiscomexArmazemDi = new J34SiscomexArmazemDi();
                j34SiscomexArmazemDi.setNumerodocumentocarga( numerodocumentocarga );
                j34SiscomexArmazemDi.setOrdem( ordem );
                return j34SiscomexArmazemDi ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga;
         * @param ordem;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexArmazemDi find( String numerodocumentocarga, Integer ordem ) {
                J34SiscomexArmazemDi j34SiscomexArmazemDi = newInstanceWithPrimaryKey( numerodocumentocarga, ordem ) ;
                if ( super.doSelect(j34SiscomexArmazemDi) ) {
                        return j34SiscomexArmazemDi ;
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
         * @param j34SiscomexArmazemDi
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexArmazemDi j34SiscomexArmazemDi ) {
                return super.doSelect(j34SiscomexArmazemDi) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexArmazemDi
         */
        @Override
        public void insert(J34SiscomexArmazemDi j34SiscomexArmazemDi) {
                super.doInsert(j34SiscomexArmazemDi);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexArmazemDi
         * @return
         */
        @Override
        public int update(J34SiscomexArmazemDi j34SiscomexArmazemDi) {
                return super.doUpdate(j34SiscomexArmazemDi);
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
                J34SiscomexArmazemDi j34SiscomexArmazemDi = newInstanceWithPrimaryKey( numerodocumentocarga, ordem ) ;
                return super.doDelete(j34SiscomexArmazemDi);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexArmazemDi
         * @return
         */
        @Override
        public int delete( J34SiscomexArmazemDi j34SiscomexArmazemDi ) {
                return super.doDelete(j34SiscomexArmazemDi);
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
                J34SiscomexArmazemDi j34SiscomexArmazemDi = newInstanceWithPrimaryKey( numerodocumentocarga, ordem ) ;
                return super.doExists(j34SiscomexArmazemDi);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexArmazemDi
         * @return
         */
        @Override
        public boolean exists( J34SiscomexArmazemDi j34SiscomexArmazemDi ) {
                return super.doExists(j34SiscomexArmazemDi);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexArmazemDi j34SiscomexArmazemDi) throws SQLException {
                
                setRawParameter(list,j34SiscomexArmazemDi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setRawParameter(list,j34SiscomexArmazemDi.getOrdem()) ; // "ordem" : java.lang.Integer
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexArmazemDi populateBean(Cursor c, J34SiscomexArmazemDi j34SiscomexArmazemDi) throws SQLException {

               
                j34SiscomexArmazemDi.setNumerodocumentocarga(c.getString(c.getColumnIndex("numerodocumentocarga"))); // java.lang.String
                j34SiscomexArmazemDi.setOrdem(c.getInt(c.getColumnIndex("ordem"))); // java.lang.Integer
                j34SiscomexArmazemDi.setNomearmazemcarga(c.getString(c.getColumnIndex("nomearmazemcarga"))); // java.lang.String
                return j34SiscomexArmazemDi ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexArmazemDi j34SiscomexArmazemDi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexArmazemDi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexArmazemDi.getOrdem() ) ; // "ordem" : java.lang.Integer
                setValue(ps, i++, j34SiscomexArmazemDi.getNomearmazemcarga() ) ; // "nomearmazemcarga" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexArmazemDi j34SiscomexArmazemDi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexArmazemDi.getNomearmazemcarga() ) ; // "nomearmazemcarga" : java.lang.String
                
                setValue(ps, i++, j34SiscomexArmazemDi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexArmazemDi.getOrdem() ) ; // "ordem" : java.lang.Integer
        }

}
