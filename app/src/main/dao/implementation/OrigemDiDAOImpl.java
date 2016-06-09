package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.OrigemDiDAO;
import br.com.bandoni.dao.tables.J34SiscomexOrigemDi;

/**
 * J34SiscomexOrigemDi: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class OrigemDiDAOImpl extends GenericDAO<J34SiscomexOrigemDi> implements OrigemDiDAO {

        private final static String SQL_SELECT = 
                "select ID, descricao from j34_siscomex_origem_di where ID = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_origem_di ( ID, descricao ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_origem_di set descricao = ? where ID = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_origem_di where ID = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_origem_di";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_origem_di where ID = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public OrigemDiDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param id;
         * @return A nova inst�ncia
         */
        private J34SiscomexOrigemDi newInstanceWithPrimaryKey( String id ) {
                J34SiscomexOrigemDi j34SiscomexOrigemDi = new J34SiscomexOrigemDi();
                j34SiscomexOrigemDi.setId( id );
                return j34SiscomexOrigemDi ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param id;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexOrigemDi find( String id ) {
                J34SiscomexOrigemDi j34SiscomexOrigemDi = newInstanceWithPrimaryKey( id ) ;
                if ( super.doSelect(j34SiscomexOrigemDi) ) {
                        return j34SiscomexOrigemDi ;
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
         * @param j34SiscomexOrigemDi
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexOrigemDi j34SiscomexOrigemDi ) {
                return super.doSelect(j34SiscomexOrigemDi) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexOrigemDi
         */
        @Override
        public void insert(J34SiscomexOrigemDi j34SiscomexOrigemDi) {
                super.doInsert(j34SiscomexOrigemDi);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexOrigemDi
         * @return
         */
        @Override
        public int update(J34SiscomexOrigemDi j34SiscomexOrigemDi) {
                return super.doUpdate(j34SiscomexOrigemDi);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param id;
         * @return
         */
        @Override
        public int delete( String id ) {
                J34SiscomexOrigemDi j34SiscomexOrigemDi = newInstanceWithPrimaryKey( id ) ;
                return super.doDelete(j34SiscomexOrigemDi);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexOrigemDi
         * @return
         */
        @Override
        public int delete( J34SiscomexOrigemDi j34SiscomexOrigemDi ) {
                return super.doDelete(j34SiscomexOrigemDi);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param id;
         * @return
         */
        @Override
        public boolean exists( String id ) {
                J34SiscomexOrigemDi j34SiscomexOrigemDi = newInstanceWithPrimaryKey( id ) ;
                return super.doExists(j34SiscomexOrigemDi);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexOrigemDi
         * @return
         */
        @Override
        public boolean exists( J34SiscomexOrigemDi j34SiscomexOrigemDi ) {
                return super.doExists(j34SiscomexOrigemDi);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexOrigemDi j34SiscomexOrigemDi) throws SQLException {
                
                setRawParameter(list, j34SiscomexOrigemDi.getId() ) ; // "ID" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexOrigemDi populateBean(Cursor c, J34SiscomexOrigemDi j34SiscomexOrigemDi) throws SQLException {

               
                j34SiscomexOrigemDi.setId(c.getString(c.getColumnIndex("ID"))); // java.lang.String
                j34SiscomexOrigemDi.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexOrigemDi ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexOrigemDi j34SiscomexOrigemDi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexOrigemDi.getId() ) ; // "ID" : java.lang.String
                setValue(ps, i++, j34SiscomexOrigemDi.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexOrigemDi j34SiscomexOrigemDi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexOrigemDi.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexOrigemDi.getId() ) ; // "ID" : java.lang.String
        }

}
