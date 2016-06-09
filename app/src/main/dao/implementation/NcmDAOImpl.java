package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.NcmDAO;
import br.com.bandoni.dao.tables.J34SiscomexNcm;

/**
 * J34SiscomexNcm: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class NcmDAOImpl extends GenericDAO<J34SiscomexNcm> implements NcmDAO {

        private final static String SQL_SELECT = 
                "select codigoncm, descricao, um from j34_siscomex_ncm where codigoncm = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_ncm ( codigoncm, descricao, um ) values ( ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_ncm set descricao = ?, um = ? where codigoncm = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_ncm where codigoncm = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_ncm";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_ncm where codigoncm = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public NcmDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigoncm;
         * @return A nova inst�ncia
         */
        private J34SiscomexNcm newInstanceWithPrimaryKey( String codigoncm ) {
                J34SiscomexNcm j34SiscomexNcm = new J34SiscomexNcm();
                j34SiscomexNcm.setCodigoncm( codigoncm );
                return j34SiscomexNcm ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigoncm;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexNcm find( String codigoncm ) {
                J34SiscomexNcm j34SiscomexNcm = newInstanceWithPrimaryKey( codigoncm ) ;
                if ( super.doSelect(j34SiscomexNcm) ) {
                        return j34SiscomexNcm ;
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
         * @param j34SiscomexNcm
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexNcm j34SiscomexNcm ) {
                return super.doSelect(j34SiscomexNcm) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexNcm
         */
        @Override
        public void insert(J34SiscomexNcm j34SiscomexNcm) {
                super.doInsert(j34SiscomexNcm);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexNcm
         * @return
         */
        @Override
        public int update(J34SiscomexNcm j34SiscomexNcm) {
                return super.doUpdate(j34SiscomexNcm);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigoncm;
         * @return
         */
        @Override
        public int delete( String codigoncm ) {
                J34SiscomexNcm j34SiscomexNcm = newInstanceWithPrimaryKey( codigoncm ) ;
                return super.doDelete(j34SiscomexNcm);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexNcm
         * @return
         */
        @Override
        public int delete( J34SiscomexNcm j34SiscomexNcm ) {
                return super.doDelete(j34SiscomexNcm);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigoncm;
         * @return
         */
        @Override
        public boolean exists( String codigoncm ) {
                J34SiscomexNcm j34SiscomexNcm = newInstanceWithPrimaryKey( codigoncm ) ;
                return super.doExists(j34SiscomexNcm);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexNcm
         * @return
         */
        @Override
        public boolean exists( J34SiscomexNcm j34SiscomexNcm ) {
                return super.doExists(j34SiscomexNcm);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexNcm j34SiscomexNcm) throws SQLException {
                
                setRawParameter(list, j34SiscomexNcm.getCodigoncm() ) ; // "codigoncm" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexNcm populateBean(Cursor c, J34SiscomexNcm j34SiscomexNcm) throws SQLException {

               
                j34SiscomexNcm.setCodigoncm(c.getString(c.getColumnIndex("codigoncm"))); // java.lang.String
                j34SiscomexNcm.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                j34SiscomexNcm.setUm(c.getString(c.getColumnIndex("um"))); // java.lang.String
                return j34SiscomexNcm ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexNcm j34SiscomexNcm) throws SQLException {

                
                setValue(ps, i++, j34SiscomexNcm.getCodigoncm() ) ; // "codigoncm" : java.lang.String
                setValue(ps, i++, j34SiscomexNcm.getDescricao() ) ; // "descricao" : java.lang.String
                setValue(ps, i++, j34SiscomexNcm.getUm() ) ; // "um" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexNcm j34SiscomexNcm) throws SQLException {

                
                setValue(ps, i++, j34SiscomexNcm.getDescricao() ) ; // "descricao" : java.lang.String
                setValue(ps, i++, j34SiscomexNcm.getUm() ) ; // "um" : java.lang.String
                
                setValue(ps, i++, j34SiscomexNcm.getCodigoncm() ) ; // "codigoncm" : java.lang.String
        }

}
