package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.AcrescimosDAO;
import br.com.bandoni.dao.tables.J34SiscomexAcrescimos;

/**
 * J34SiscomexAcrescimos: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class AcrescimosDAOImpl extends GenericDAO<J34SiscomexAcrescimos> implements AcrescimosDAO {

        private final static String SQL_SELECT = 
                "select codigo, descricao from j34_siscomex_acrescimos where codigo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_acrescimos ( codigo, descricao ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_acrescimos set descricao = ? where codigo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_acrescimos where codigo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_acrescimos";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_acrescimos where codigo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public AcrescimosDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @return A nova inst�ncia
         */
        private J34SiscomexAcrescimos newInstanceWithPrimaryKey( String codigo ) {
                J34SiscomexAcrescimos j34SiscomexAcrescimos = new J34SiscomexAcrescimos();
                j34SiscomexAcrescimos.setCodigo( codigo );
                return j34SiscomexAcrescimos ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexAcrescimos find( String codigo ) {
                J34SiscomexAcrescimos j34SiscomexAcrescimos = newInstanceWithPrimaryKey( codigo ) ;
                if ( super.doSelect(j34SiscomexAcrescimos) ) {
                        return j34SiscomexAcrescimos ;
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
         * @param j34SiscomexAcrescimos
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexAcrescimos j34SiscomexAcrescimos ) {
                return super.doSelect(j34SiscomexAcrescimos) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexAcrescimos
         */
        @Override
        public void insert(J34SiscomexAcrescimos j34SiscomexAcrescimos) {
                super.doInsert(j34SiscomexAcrescimos);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexAcrescimos
         * @return
         */
        @Override
        public int update(J34SiscomexAcrescimos j34SiscomexAcrescimos) {
                return super.doUpdate(j34SiscomexAcrescimos);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @return
         */
        @Override
        public int delete( String codigo ) {
                J34SiscomexAcrescimos j34SiscomexAcrescimos = newInstanceWithPrimaryKey( codigo ) ;
                return super.doDelete(j34SiscomexAcrescimos);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexAcrescimos
         * @return
         */
        @Override
        public int delete( J34SiscomexAcrescimos j34SiscomexAcrescimos ) {
                return super.doDelete(j34SiscomexAcrescimos);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @return
         */
        @Override
        public boolean exists( String codigo ) {
                J34SiscomexAcrescimos j34SiscomexAcrescimos = newInstanceWithPrimaryKey( codigo ) ;
                return super.doExists(j34SiscomexAcrescimos);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexAcrescimos
         * @return
         */
        @Override
        public boolean exists( J34SiscomexAcrescimos j34SiscomexAcrescimos ) {
                return super.doExists(j34SiscomexAcrescimos);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexAcrescimos j34SiscomexAcrescimos) throws SQLException {
                
                setRawParameter(list,j34SiscomexAcrescimos.getCodigo() ) ; // "codigo" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexAcrescimos populateBean(Cursor c, J34SiscomexAcrescimos j34SiscomexAcrescimos) throws SQLException {

               
                j34SiscomexAcrescimos.setCodigo(c.getString(c.getColumnIndex("codigo"))); // java.lang.String
                j34SiscomexAcrescimos.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexAcrescimos ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexAcrescimos j34SiscomexAcrescimos) throws SQLException {

                
                setValue(ps, i++, j34SiscomexAcrescimos.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexAcrescimos.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexAcrescimos j34SiscomexAcrescimos) throws SQLException {

                
                setValue(ps, i++, j34SiscomexAcrescimos.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexAcrescimos.getCodigo() ) ; // "codigo" : java.lang.String
        }

}
