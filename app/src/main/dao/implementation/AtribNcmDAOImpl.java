package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.AtribNcmDAO;
import br.com.bandoni.dao.tables.J34SiscomexAtribNcm;

/**
 * J34SiscomexAtribNcm: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class AtribNcmDAOImpl extends GenericDAO<J34SiscomexAtribNcm> implements AtribNcmDAO {

        private final static String SQL_SELECT = 
                "select ncm, atributoncm, multiplo, nivel, atributo from j34_siscomex_atrib_ncm where ncm = ? and atributoncm = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_atrib_ncm ( ncm, atributoncm, multiplo, nivel, atributo ) values ( ?, ?, ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_atrib_ncm set multiplo = ?, nivel = ?, atributo = ? where ncm = ? and atributoncm = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_atrib_ncm where ncm = ? and atributoncm = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_atrib_ncm";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_atrib_ncm where ncm = ? and atributoncm = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public AtribNcmDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param ncm;
         * @param atributoncm;
         * @return A nova inst�ncia
         */
        private J34SiscomexAtribNcm newInstanceWithPrimaryKey( String ncm, String atributoncm ) {
                J34SiscomexAtribNcm j34SiscomexAtribNcm = new J34SiscomexAtribNcm();
                j34SiscomexAtribNcm.setNcm( ncm );
                j34SiscomexAtribNcm.setAtributoncm( atributoncm );
                return j34SiscomexAtribNcm ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param ncm;
         * @param atributoncm;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexAtribNcm find( String ncm, String atributoncm ) {
                J34SiscomexAtribNcm j34SiscomexAtribNcm = newInstanceWithPrimaryKey( ncm, atributoncm ) ;
                if ( super.doSelect(j34SiscomexAtribNcm) ) {
                        return j34SiscomexAtribNcm ;
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
         * @param j34SiscomexAtribNcm
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexAtribNcm j34SiscomexAtribNcm ) {
                return super.doSelect(j34SiscomexAtribNcm) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexAtribNcm
         */
        @Override
        public void insert(J34SiscomexAtribNcm j34SiscomexAtribNcm) {
                super.doInsert(j34SiscomexAtribNcm);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexAtribNcm
         * @return
         */
        @Override
        public int update(J34SiscomexAtribNcm j34SiscomexAtribNcm) {
                return super.doUpdate(j34SiscomexAtribNcm);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param ncm;
         * @param atributoncm;
         * @return
         */
        @Override
        public int delete( String ncm, String atributoncm ) {
                J34SiscomexAtribNcm j34SiscomexAtribNcm = newInstanceWithPrimaryKey( ncm, atributoncm ) ;
                return super.doDelete(j34SiscomexAtribNcm);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexAtribNcm
         * @return
         */
        @Override
        public int delete( J34SiscomexAtribNcm j34SiscomexAtribNcm ) {
                return super.doDelete(j34SiscomexAtribNcm);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param ncm;
         * @param atributoncm;
         * @return
         */
        @Override
        public boolean exists( String ncm, String atributoncm ) {
                J34SiscomexAtribNcm j34SiscomexAtribNcm = newInstanceWithPrimaryKey( ncm, atributoncm ) ;
                return super.doExists(j34SiscomexAtribNcm);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexAtribNcm
         * @return
         */
        @Override
        public boolean exists( J34SiscomexAtribNcm j34SiscomexAtribNcm ) {
                return super.doExists(j34SiscomexAtribNcm);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexAtribNcm j34SiscomexAtribNcm) throws SQLException {
                
                setRawParameter(list,j34SiscomexAtribNcm.getNcm() ) ; // "ncm" : java.lang.String
                setRawParameter(list,j34SiscomexAtribNcm.getAtributoncm() ) ; // "atributoncm" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexAtribNcm populateBean(Cursor c, J34SiscomexAtribNcm j34SiscomexAtribNcm) throws SQLException {

               
                j34SiscomexAtribNcm.setNcm(c.getString(c.getColumnIndex("ncm"))); // java.lang.String
                j34SiscomexAtribNcm.setAtributoncm(c.getString(c.getColumnIndex("atributoncm"))); // java.lang.String
                j34SiscomexAtribNcm.setMultiplo(c.getString(c.getColumnIndex("multiplo"))); // java.lang.String
                j34SiscomexAtribNcm.setNivel(c.getString(c.getColumnIndex("nivel"))); // java.lang.String
                j34SiscomexAtribNcm.setAtributo(c.getString(c.getColumnIndex("atributo"))); // java.lang.String
                return j34SiscomexAtribNcm ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexAtribNcm j34SiscomexAtribNcm) throws SQLException {

                
                setValue(ps, i++, j34SiscomexAtribNcm.getNcm() ) ; // "ncm" : java.lang.String
                setValue(ps, i++, j34SiscomexAtribNcm.getAtributoncm() ) ; // "atributoncm" : java.lang.String
                setValue(ps, i++, j34SiscomexAtribNcm.getMultiplo() ) ; // "multiplo" : java.lang.String
                setValue(ps, i++, j34SiscomexAtribNcm.getNivel() ) ; // "nivel" : java.lang.String
                setValue(ps, i++, j34SiscomexAtribNcm.getAtributo() ) ; // "atributo" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexAtribNcm j34SiscomexAtribNcm) throws SQLException {

                
                setValue(ps, i++, j34SiscomexAtribNcm.getMultiplo() ) ; // "multiplo" : java.lang.String
                setValue(ps, i++, j34SiscomexAtribNcm.getNivel() ) ; // "nivel" : java.lang.String
                setValue(ps, i++, j34SiscomexAtribNcm.getAtributo() ) ; // "atributo" : java.lang.String
                
                setValue(ps, i++, j34SiscomexAtribNcm.getNcm() ) ; // "ncm" : java.lang.String
                setValue(ps, i++, j34SiscomexAtribNcm.getAtributoncm() ) ; // "atributoncm" : java.lang.String
        }

}
