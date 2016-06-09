package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.BancosDAO;
import br.com.bandoni.dao.tables.J34SiscomexBancos;

/**
 * J34SiscomexBancos: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class BancosDAOImpl extends GenericDAO<J34SiscomexBancos> implements BancosDAO {

        private final static String SQL_SELECT = 
                "select codigo, descricao from j34_siscomex_bancos where codigo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_bancos ( codigo, descricao ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_bancos set descricao = ? where codigo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_bancos where codigo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_bancos";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_bancos where codigo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public BancosDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @return A nova inst�ncia
         */
        private J34SiscomexBancos newInstanceWithPrimaryKey( String codigo ) {
                J34SiscomexBancos j34SiscomexBancos = new J34SiscomexBancos();
                j34SiscomexBancos.setCodigo( codigo );
                return j34SiscomexBancos ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexBancos find( String codigo ) {
                J34SiscomexBancos j34SiscomexBancos = newInstanceWithPrimaryKey( codigo ) ;
                if ( super.doSelect(j34SiscomexBancos) ) {
                        return j34SiscomexBancos ;
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
         * @param j34SiscomexBancos
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexBancos j34SiscomexBancos ) {
                return super.doSelect(j34SiscomexBancos) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexBancos
         */
        @Override
        public void insert(J34SiscomexBancos j34SiscomexBancos) {
                super.doInsert(j34SiscomexBancos);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexBancos
         * @return
         */
        @Override
        public int update(J34SiscomexBancos j34SiscomexBancos) {
                return super.doUpdate(j34SiscomexBancos);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @return
         */
        @Override
        public int delete( String codigo ) {
                J34SiscomexBancos j34SiscomexBancos = newInstanceWithPrimaryKey( codigo ) ;
                return super.doDelete(j34SiscomexBancos);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexBancos
         * @return
         */
        @Override
        public int delete( J34SiscomexBancos j34SiscomexBancos ) {
                return super.doDelete(j34SiscomexBancos);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @return
         */
        @Override
        public boolean exists( String codigo ) {
                J34SiscomexBancos j34SiscomexBancos = newInstanceWithPrimaryKey( codigo ) ;
                return super.doExists(j34SiscomexBancos);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexBancos
         * @return
         */
        @Override
        public boolean exists( J34SiscomexBancos j34SiscomexBancos ) {
                return super.doExists(j34SiscomexBancos);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexBancos j34SiscomexBancos) throws SQLException {
                
                setRawParameter(list,j34SiscomexBancos.getCodigo() ) ; // "codigo" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexBancos populateBean(Cursor c, J34SiscomexBancos j34SiscomexBancos) throws SQLException {

               
                j34SiscomexBancos.setCodigo(c.getString(c.getColumnIndex("codigo"))); // java.lang.String
                j34SiscomexBancos.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexBancos ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexBancos j34SiscomexBancos) throws SQLException {

                
                setValue(ps, i++, j34SiscomexBancos.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexBancos.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexBancos j34SiscomexBancos) throws SQLException {

                
                setValue(ps, i++, j34SiscomexBancos.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexBancos.getCodigo() ) ; // "codigo" : java.lang.String
        }

}
