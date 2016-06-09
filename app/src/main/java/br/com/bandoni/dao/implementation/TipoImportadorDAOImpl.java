package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.TipoImportadorDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexTipoImportador;

/**
 * J34SiscomexTipoImportador: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class TipoImportadorDAOImpl extends GenericDAO<J34SiscomexTipoImportador> implements TipoImportadorDAO {

        private final static String SQL_SELECT = 
                "select id, descricao from j34_siscomex_tipo_importador where id = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_tipo_importador ( id, descricao ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_tipo_importador set descricao = ? where id = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_tipo_importador where id = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_tipo_importador";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_tipo_importador where id = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public TipoImportadorDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param id;
         * @return A nova inst�ncia
         */
        private J34SiscomexTipoImportador newInstanceWithPrimaryKey( Integer id ) {
                J34SiscomexTipoImportador j34SiscomexTipoImportador = new J34SiscomexTipoImportador();
                j34SiscomexTipoImportador.setId( id );
                return j34SiscomexTipoImportador ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param id;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexTipoImportador find( Integer id ) {
                J34SiscomexTipoImportador j34SiscomexTipoImportador = newInstanceWithPrimaryKey( id ) ;
                if ( super.doSelect(j34SiscomexTipoImportador) ) {
                        return j34SiscomexTipoImportador ;
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
         * @param j34SiscomexTipoImportador
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexTipoImportador j34SiscomexTipoImportador ) {
                return super.doSelect(j34SiscomexTipoImportador) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexTipoImportador
         */
        @Override
        public void insert(J34SiscomexTipoImportador j34SiscomexTipoImportador) {
                super.doInsert(j34SiscomexTipoImportador);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexTipoImportador
         * @return
         */
        @Override
        public int update(J34SiscomexTipoImportador j34SiscomexTipoImportador) {
                return super.doUpdate(j34SiscomexTipoImportador);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param id;
         * @return
         */
        @Override
        public int delete( Integer id ) {
                J34SiscomexTipoImportador j34SiscomexTipoImportador = newInstanceWithPrimaryKey( id ) ;
                return super.doDelete(j34SiscomexTipoImportador);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexTipoImportador
         * @return
         */
        @Override
        public int delete( J34SiscomexTipoImportador j34SiscomexTipoImportador ) {
                return super.doDelete(j34SiscomexTipoImportador);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param id;
         * @return
         */
        @Override
        public boolean exists( Integer id ) {
                J34SiscomexTipoImportador j34SiscomexTipoImportador = newInstanceWithPrimaryKey( id ) ;
                return super.doExists(j34SiscomexTipoImportador);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexTipoImportador
         * @return
         */
        @Override
        public boolean exists( J34SiscomexTipoImportador j34SiscomexTipoImportador ) {
                return super.doExists(j34SiscomexTipoImportador);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexTipoImportador j34SiscomexTipoImportador) throws SQLException {
                
                setRawParameter(list, j34SiscomexTipoImportador.getId() ) ; // "id" : java.lang.Integer
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexTipoImportador populateBean(Cursor c, J34SiscomexTipoImportador j34SiscomexTipoImportador) throws SQLException {

               
                j34SiscomexTipoImportador.setId(c.getInt(c.getColumnIndex("id"))); // java.lang.Integer
                j34SiscomexTipoImportador.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexTipoImportador ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexTipoImportador j34SiscomexTipoImportador) throws SQLException {

                
                setValue(ps, i++, j34SiscomexTipoImportador.getId() ) ; // "id" : java.lang.Integer
                setValue(ps, i++, j34SiscomexTipoImportador.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexTipoImportador j34SiscomexTipoImportador) throws SQLException {

                
                setValue(ps, i++, j34SiscomexTipoImportador.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexTipoImportador.getId() ) ; // "id" : java.lang.Integer
        }

}
