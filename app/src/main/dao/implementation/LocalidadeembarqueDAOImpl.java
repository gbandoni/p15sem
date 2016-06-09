package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.LocalidadeembarqueDAO;
import br.com.bandoni.dao.tables.J34SiscomexLocalidadeembarque;

/**
 * J34SiscomexLocalidadeembarque: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class LocalidadeembarqueDAOImpl extends GenericDAO<J34SiscomexLocalidadeembarque> implements LocalidadeembarqueDAO {

        private final static String SQL_SELECT = 
                "select ID, codpais, localidade from j34_siscomex_localidadeembarque where ID = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_localidadeembarque ( codpais, localidade ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_localidadeembarque set codpais = ?, localidade = ? where ID = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_localidadeembarque where ID = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_localidadeembarque";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_localidadeembarque where ID = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public LocalidadeembarqueDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param id;
         * @return A nova inst�ncia
         */
        private J34SiscomexLocalidadeembarque newInstanceWithPrimaryKey( String id )
        {
                J34SiscomexLocalidadeembarque j34SiscomexLocalidadeembarque = new J34SiscomexLocalidadeembarque();
                j34SiscomexLocalidadeembarque.setId( id );
                return j34SiscomexLocalidadeembarque ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param id;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexLocalidadeembarque find( String id )
        {
                J34SiscomexLocalidadeembarque j34SiscomexLocalidadeembarque = newInstanceWithPrimaryKey( id ) ;
                if ( super.doSelect(j34SiscomexLocalidadeembarque) )
                {
                        return j34SiscomexLocalidadeembarque ;
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
         * @param j34SiscomexLocalidadeembarque
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexLocalidadeembarque j34SiscomexLocalidadeembarque )
        {
                return super.doSelect(j34SiscomexLocalidadeembarque) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexLocalidadeembarque
         */
        @Override
        public Integer insert(J34SiscomexLocalidadeembarque j34SiscomexLocalidadeembarque)
        {
                Long key = super.doInsertAutoIncr(j34SiscomexLocalidadeembarque);
                return key.intValue();
        }

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexLocalidadeembarque
         * @return
         */
        @Override
        public int update(J34SiscomexLocalidadeembarque j34SiscomexLocalidadeembarque)
        {
                return super.doUpdate(j34SiscomexLocalidadeembarque);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param id;
         * @return
         */
        @Override
        public int delete( String id )
        {
                J34SiscomexLocalidadeembarque j34SiscomexLocalidadeembarque = newInstanceWithPrimaryKey( id ) ;
                return super.doDelete(j34SiscomexLocalidadeembarque);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexLocalidadeembarque
         * @return
         */
        @Override
        public int delete( J34SiscomexLocalidadeembarque j34SiscomexLocalidadeembarque )
        {
                return super.doDelete(j34SiscomexLocalidadeembarque);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param id;
         * @return
         */
        @Override
        public boolean exists( String id )
        {
                J34SiscomexLocalidadeembarque j34SiscomexLocalidadeembarque = newInstanceWithPrimaryKey( id ) ;
                return super.doExists(j34SiscomexLocalidadeembarque);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexLocalidadeembarque
         * @return
         */
        @Override
        public boolean exists( J34SiscomexLocalidadeembarque j34SiscomexLocalidadeembarque )
        {
                return super.doExists(j34SiscomexLocalidadeembarque);
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
         protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexLocalidadeembarque j34SiscomexLocalidadeembarque) throws SQLException {
                
                setRawParameter(list, j34SiscomexLocalidadeembarque.getId()) ; // "ID" : java.lang.String'
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexLocalidadeembarque populateBean(Cursor c, J34SiscomexLocalidadeembarque j34SiscomexLocalidadeembarque) throws SQLException {

               
                j34SiscomexLocalidadeembarque.setId(c.getString(c.getColumnIndex("ID"))); // java.lang.Integer
                j34SiscomexLocalidadeembarque.setCodpais(c.getString(c.getColumnIndex("codpais"))); // java.lang.String
                j34SiscomexLocalidadeembarque.setLocalidade(c.getString(c.getColumnIndex("localidade"))); // java.lang.String
                return j34SiscomexLocalidadeembarque ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexLocalidadeembarque j34SiscomexLocalidadeembarque) throws SQLException {

                
                // "ID" is auto-incremented => no set in insert         
                setValue(ps, i++, j34SiscomexLocalidadeembarque.getCodpais() ) ; // "codpais" : java.lang.String
                setValue(ps, i++, j34SiscomexLocalidadeembarque.getLocalidade() ) ; // "localidade" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexLocalidadeembarque j34SiscomexLocalidadeembarque) throws SQLException {

                
                setValue(ps, i++, j34SiscomexLocalidadeembarque.getCodpais() ) ; // "codpais" : java.lang.String
                setValue(ps, i++, j34SiscomexLocalidadeembarque.getLocalidade() ) ; // "localidade" : java.lang.String
                
                setValue(ps, i++, j34SiscomexLocalidadeembarque.getId() ) ; // "ID" : java.lang.Integer
        }

}
