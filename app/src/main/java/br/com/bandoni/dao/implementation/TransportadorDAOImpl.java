package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.TransportadorDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexTransportador;

/**
 * J34SiscomexTransportador: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class TransportadorDAOImpl extends GenericDAO<J34SiscomexTransportador> implements TransportadorDAO {

        private final static String SQL_SELECT = 
                "select id, nome from j34_siscomex_transportador where id = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_transportador ( nome ) values ( ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_transportador set nome = ? where id = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_transportador where id = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_transportador";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_transportador where id = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public TransportadorDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param id;
         * @return A nova inst�ncia
         */
        private J34SiscomexTransportador newInstanceWithPrimaryKey( Integer id ) {
                J34SiscomexTransportador j34SiscomexTransportador = new J34SiscomexTransportador();
                j34SiscomexTransportador.setId( id );
                return j34SiscomexTransportador ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param id;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexTransportador find( Integer id ) {
                J34SiscomexTransportador j34SiscomexTransportador = newInstanceWithPrimaryKey( id ) ;
                if ( super.doSelect(j34SiscomexTransportador) ) {
                        return j34SiscomexTransportador ;
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
         * @param j34SiscomexTransportador
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexTransportador j34SiscomexTransportador ) {
                return super.doSelect(j34SiscomexTransportador) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexTransportador
         */
        @Override
        public Integer insert(J34SiscomexTransportador j34SiscomexTransportador) {
                Long key = super.doInsertAutoIncr(j34SiscomexTransportador);
                return key.intValue();
        }

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexTransportador
         * @return
         */
        @Override
        public int update(J34SiscomexTransportador j34SiscomexTransportador) {
                return super.doUpdate(j34SiscomexTransportador);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param id;
         * @return
         */
        @Override
        public int delete( Integer id ) {
                J34SiscomexTransportador j34SiscomexTransportador = newInstanceWithPrimaryKey( id ) ;
                return super.doDelete(j34SiscomexTransportador);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexTransportador
         * @return
         */
        @Override
        public int delete( J34SiscomexTransportador j34SiscomexTransportador ) {
                return super.doDelete(j34SiscomexTransportador);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param id;
         * @return
         */
        @Override
        public boolean exists( Integer id ) {
                J34SiscomexTransportador j34SiscomexTransportador = newInstanceWithPrimaryKey( id ) ;
                return super.doExists(j34SiscomexTransportador);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexTransportador
         * @return
         */
        @Override
        public boolean exists( J34SiscomexTransportador j34SiscomexTransportador ) {
                return super.doExists(j34SiscomexTransportador);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexTransportador j34SiscomexTransportador) throws SQLException {
                
                setRawParameter(list,j34SiscomexTransportador.getId() ) ; // "id" : java.lang.Integer
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexTransportador populateBean(Cursor c, J34SiscomexTransportador j34SiscomexTransportador) throws SQLException {

               
                j34SiscomexTransportador.setId(c.getInt(c.getColumnIndex("id"))); // java.lang.Integer
                j34SiscomexTransportador.setNome(c.getString(c.getColumnIndex("nome"))); // java.lang.String
                return j34SiscomexTransportador ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexTransportador j34SiscomexTransportador) throws SQLException {

                
                // "id" is auto-incremented => no set in insert         
                setValue(ps, i++, j34SiscomexTransportador.getNome() ) ; // "nome" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexTransportador j34SiscomexTransportador) throws SQLException {

                
                setValue(ps, i++, j34SiscomexTransportador.getNome() ) ; // "nome" : java.lang.String
                
                setValue(ps, i++, j34SiscomexTransportador.getId() ) ; // "id" : java.lang.Integer
        }

}
