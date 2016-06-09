package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.TipoDocumentoDesDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexTipoDocumentoDes;

/**
 * J34SiscomexTipoDocumentoDes: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class TipoDocumentoDesDAOImpl extends GenericDAO<J34SiscomexTipoDocumentoDes> implements TipoDocumentoDesDAO {

        private final static String SQL_SELECT = 
                "select codigo, descricao from j34_siscomex_tipo_documento_des where codigo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_tipo_documento_des ( codigo, descricao ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_tipo_documento_des set descricao = ? where codigo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_tipo_documento_des where codigo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_tipo_documento_des";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_tipo_documento_des where codigo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public TipoDocumentoDesDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @return A nova inst�ncia
         */
        private J34SiscomexTipoDocumentoDes newInstanceWithPrimaryKey( Integer codigo ) {
                J34SiscomexTipoDocumentoDes j34SiscomexTipoDocumentoDes = new J34SiscomexTipoDocumentoDes();
                j34SiscomexTipoDocumentoDes.setCodigo( codigo );
                return j34SiscomexTipoDocumentoDes ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexTipoDocumentoDes find( Integer codigo ) {
                J34SiscomexTipoDocumentoDes j34SiscomexTipoDocumentoDes = newInstanceWithPrimaryKey( codigo ) ;
                if ( super.doSelect(j34SiscomexTipoDocumentoDes) ) {
                        return j34SiscomexTipoDocumentoDes ;
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
         * @param j34SiscomexTipoDocumentoDes
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexTipoDocumentoDes j34SiscomexTipoDocumentoDes ) {
                return super.doSelect(j34SiscomexTipoDocumentoDes) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexTipoDocumentoDes
         */
        @Override
        public void insert(J34SiscomexTipoDocumentoDes j34SiscomexTipoDocumentoDes) {
                super.doInsert(j34SiscomexTipoDocumentoDes);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexTipoDocumentoDes
         * @return
         */
        @Override
        public int update(J34SiscomexTipoDocumentoDes j34SiscomexTipoDocumentoDes) {
                return super.doUpdate(j34SiscomexTipoDocumentoDes);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @return
         */
        @Override
        public int delete( Integer codigo ) {
                J34SiscomexTipoDocumentoDes j34SiscomexTipoDocumentoDes = newInstanceWithPrimaryKey( codigo ) ;
                return super.doDelete(j34SiscomexTipoDocumentoDes);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexTipoDocumentoDes
         * @return
         */
        @Override
        public int delete( J34SiscomexTipoDocumentoDes j34SiscomexTipoDocumentoDes ) {
                return super.doDelete(j34SiscomexTipoDocumentoDes);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @return
         */
        @Override
        public boolean exists( Integer codigo ) {
                J34SiscomexTipoDocumentoDes j34SiscomexTipoDocumentoDes = newInstanceWithPrimaryKey( codigo ) ;
                return super.doExists(j34SiscomexTipoDocumentoDes);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexTipoDocumentoDes
         * @return
         */
        @Override
        public boolean exists( J34SiscomexTipoDocumentoDes j34SiscomexTipoDocumentoDes ) {
                return super.doExists(j34SiscomexTipoDocumentoDes);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexTipoDocumentoDes j34SiscomexTipoDocumentoDes) throws SQLException {
                
                setRawParameter(list,j34SiscomexTipoDocumentoDes.getCodigo()) ; // "codigo" : java.lang.Integer
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexTipoDocumentoDes populateBean(Cursor c, J34SiscomexTipoDocumentoDes j34SiscomexTipoDocumentoDes) throws SQLException {

               
                j34SiscomexTipoDocumentoDes.setCodigo(c.getInt(c.getColumnIndex("codigo"))); // java.lang.Integer
                j34SiscomexTipoDocumentoDes.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexTipoDocumentoDes ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexTipoDocumentoDes j34SiscomexTipoDocumentoDes) throws SQLException {

                
                setValue(ps, i++, j34SiscomexTipoDocumentoDes.getCodigo() ) ; // "codigo" : java.lang.Integer
                setValue(ps, i++, j34SiscomexTipoDocumentoDes.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexTipoDocumentoDes j34SiscomexTipoDocumentoDes) throws SQLException {

                
                setValue(ps, i++, j34SiscomexTipoDocumentoDes.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexTipoDocumentoDes.getCodigo() ) ; // "codigo" : java.lang.Integer
        }

}
