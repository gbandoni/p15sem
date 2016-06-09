package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.DeducoesDAO;
import br.com.bandoni.dao.tables.J34SiscomexDeducoes;

/**
 * J34SiscomexDeducoes: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class DeducoesDAOImpl extends GenericDAO<J34SiscomexDeducoes> implements DeducoesDAO {

        private final static String SQL_SELECT = 
                "select codigo, descricao from j34_siscomex_deducoes where codigo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_deducoes ( codigo, descricao ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_deducoes set descricao = ? where codigo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_deducoes where codigo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_deducoes";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_deducoes where codigo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public DeducoesDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @return A nova inst�ncia
         */
        private J34SiscomexDeducoes newInstanceWithPrimaryKey( String codigo ) {
                J34SiscomexDeducoes j34SiscomexDeducoes = new J34SiscomexDeducoes();
                j34SiscomexDeducoes.setCodigo( codigo );
                return j34SiscomexDeducoes ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexDeducoes find( String codigo ) {
                J34SiscomexDeducoes j34SiscomexDeducoes = newInstanceWithPrimaryKey( codigo ) ;
                if ( super.doSelect(j34SiscomexDeducoes) ) {
                        return j34SiscomexDeducoes ;
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
         * @param j34SiscomexDeducoes
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexDeducoes j34SiscomexDeducoes ) {
                return super.doSelect(j34SiscomexDeducoes) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexDeducoes
         */
        @Override
        public void insert(J34SiscomexDeducoes j34SiscomexDeducoes) {
                super.doInsert(j34SiscomexDeducoes);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexDeducoes
         * @return
         */
        @Override
        public int update(J34SiscomexDeducoes j34SiscomexDeducoes) {
                return super.doUpdate(j34SiscomexDeducoes);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @return
         */
        @Override
        public int delete( String codigo ) {
                J34SiscomexDeducoes j34SiscomexDeducoes = newInstanceWithPrimaryKey( codigo ) ;
                return super.doDelete(j34SiscomexDeducoes);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexDeducoes
         * @return
         */
        @Override
        public int delete( J34SiscomexDeducoes j34SiscomexDeducoes ) {
                return super.doDelete(j34SiscomexDeducoes);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @return
         */
        @Override
        public boolean exists( String codigo ) {
                J34SiscomexDeducoes j34SiscomexDeducoes = newInstanceWithPrimaryKey( codigo ) ;
                return super.doExists(j34SiscomexDeducoes);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexDeducoes
         * @return
         */
        @Override
        public boolean exists( J34SiscomexDeducoes j34SiscomexDeducoes ) {
                return super.doExists(j34SiscomexDeducoes);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexDeducoes j34SiscomexDeducoes) throws SQLException {
                
                setRawParameter(list,j34SiscomexDeducoes.getCodigo() ) ; // "codigo" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexDeducoes populateBean(Cursor c, J34SiscomexDeducoes j34SiscomexDeducoes) throws SQLException {

               
                j34SiscomexDeducoes.setCodigo(c.getString(c.getColumnIndex("codigo"))); // java.lang.String
                j34SiscomexDeducoes.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexDeducoes ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexDeducoes j34SiscomexDeducoes) throws SQLException {

                
                setValue(ps, i++, j34SiscomexDeducoes.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexDeducoes.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexDeducoes j34SiscomexDeducoes) throws SQLException {

                
                setValue(ps, i++, j34SiscomexDeducoes.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexDeducoes.getCodigo() ) ; // "codigo" : java.lang.String
        }

}
