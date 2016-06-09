package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.ViatransporteDAO;
import br.com.bandoni.dao.tables.J34SiscomexViatransporte;

/**
 * J34SiscomexViatransporte: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class ViatransporteDAOImpl extends GenericDAO<J34SiscomexViatransporte> implements ViatransporteDAO {

        private final static String SQL_SELECT = 
                "select codigo, descricao from j34_siscomex_viatransporte where codigo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_viatransporte ( codigo, descricao ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_viatransporte set descricao = ? where codigo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_viatransporte where codigo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_viatransporte";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_viatransporte where codigo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public ViatransporteDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @return A nova inst�ncia
         */
        private J34SiscomexViatransporte newInstanceWithPrimaryKey( String codigo ) {
                J34SiscomexViatransporte j34SiscomexViatransporte = new J34SiscomexViatransporte();
                j34SiscomexViatransporte.setCodigo( codigo );
                return j34SiscomexViatransporte ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexViatransporte find( String codigo ) {
                J34SiscomexViatransporte j34SiscomexViatransporte = newInstanceWithPrimaryKey( codigo ) ;
                if ( super.doSelect(j34SiscomexViatransporte) ) {
                        return j34SiscomexViatransporte ;
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
         * @param j34SiscomexViatransporte
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexViatransporte j34SiscomexViatransporte ) {
                return super.doSelect(j34SiscomexViatransporte) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexViatransporte
         */
        @Override
        public void insert(J34SiscomexViatransporte j34SiscomexViatransporte) {
                super.doInsert(j34SiscomexViatransporte);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexViatransporte
         * @return
         */
        @Override
        public int update(J34SiscomexViatransporte j34SiscomexViatransporte) {
                return super.doUpdate(j34SiscomexViatransporte);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @return
         */
        @Override
        public int delete( String codigo ) {
                J34SiscomexViatransporte j34SiscomexViatransporte = newInstanceWithPrimaryKey( codigo ) ;
                return super.doDelete(j34SiscomexViatransporte);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexViatransporte
         * @return
         */
        @Override
        public int delete( J34SiscomexViatransporte j34SiscomexViatransporte ) {
                return super.doDelete(j34SiscomexViatransporte);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @return
         */
        @Override
        public boolean exists( String codigo ) {
                J34SiscomexViatransporte j34SiscomexViatransporte = newInstanceWithPrimaryKey( codigo ) ;
                return super.doExists(j34SiscomexViatransporte);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexViatransporte
         * @return
         */
        @Override
        public boolean exists( J34SiscomexViatransporte j34SiscomexViatransporte ) {
                return super.doExists(j34SiscomexViatransporte);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexViatransporte j34SiscomexViatransporte) throws SQLException {
                
                setRawParameter(list, j34SiscomexViatransporte.getCodigo() ) ; // "codigo" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexViatransporte populateBean(Cursor c, J34SiscomexViatransporte j34SiscomexViatransporte) throws SQLException {

               
                j34SiscomexViatransporte.setCodigo(c.getString(c.getColumnIndex("codigo"))); // java.lang.String
                j34SiscomexViatransporte.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexViatransporte ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexViatransporte j34SiscomexViatransporte) throws SQLException {

                
                setValue(ps, i++, j34SiscomexViatransporte.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexViatransporte.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexViatransporte j34SiscomexViatransporte) throws SQLException {

                
                setValue(ps, i++, j34SiscomexViatransporte.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexViatransporte.getCodigo() ) ; // "codigo" : java.lang.String
        }

}
