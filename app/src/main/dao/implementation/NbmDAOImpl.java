package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.NbmDAO;
import br.com.bandoni.dao.tables.J34SiscomexNbm;

/**
 * J34SiscomexNbm: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class NbmDAOImpl extends GenericDAO<J34SiscomexNbm> implements NbmDAO {

        private final static String SQL_SELECT = 
                "select codigo, descricao from j34_siscomex_nbm where codigo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_nbm ( codigo, descricao ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_nbm set descricao = ? where codigo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_nbm where codigo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_nbm";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_nbm where codigo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public NbmDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @return A nova inst�ncia
         */
        private J34SiscomexNbm newInstanceWithPrimaryKey( String codigo ) {
                J34SiscomexNbm j34SiscomexNbm = new J34SiscomexNbm();
                j34SiscomexNbm.setCodigo( codigo );
                return j34SiscomexNbm ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexNbm find( String codigo ) {
                J34SiscomexNbm j34SiscomexNbm = newInstanceWithPrimaryKey( codigo ) ;
                if ( super.doSelect(j34SiscomexNbm) ) {
                        return j34SiscomexNbm ;
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
         * @param j34SiscomexNbm
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexNbm j34SiscomexNbm ) {
                return super.doSelect(j34SiscomexNbm) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexNbm
         */
        @Override
        public void insert(J34SiscomexNbm j34SiscomexNbm) {
                super.doInsert(j34SiscomexNbm);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexNbm
         * @return
         */
        @Override
        public int update(J34SiscomexNbm j34SiscomexNbm) {
                return super.doUpdate(j34SiscomexNbm);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @return
         */
        @Override
        public int delete( String codigo ) {
                J34SiscomexNbm j34SiscomexNbm = newInstanceWithPrimaryKey( codigo ) ;
                return super.doDelete(j34SiscomexNbm);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexNbm
         * @return
         */
        @Override
        public int delete( J34SiscomexNbm j34SiscomexNbm ) {
                return super.doDelete(j34SiscomexNbm);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @return
         */
        @Override
        public boolean exists( String codigo ) {
                J34SiscomexNbm j34SiscomexNbm = newInstanceWithPrimaryKey( codigo ) ;
                return super.doExists(j34SiscomexNbm);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexNbm
         * @return
         */
        @Override
        public boolean exists( J34SiscomexNbm j34SiscomexNbm ) {
                return super.doExists(j34SiscomexNbm);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexNbm j34SiscomexNbm) throws SQLException {
                
                setRawParameter(list,  j34SiscomexNbm.getCodigo() ) ; // "codigo" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexNbm populateBean(Cursor c, J34SiscomexNbm j34SiscomexNbm) throws SQLException {

               
                j34SiscomexNbm.setCodigo(c.getString(c.getColumnIndex("codigo"))); // java.lang.String
                j34SiscomexNbm.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexNbm ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexNbm j34SiscomexNbm) throws SQLException {

                
                setValue(ps, i++, j34SiscomexNbm.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexNbm.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexNbm j34SiscomexNbm) throws SQLException {

                
                setValue(ps, i++, j34SiscomexNbm.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexNbm.getCodigo() ) ; // "codigo" : java.lang.String
        }

}
