package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.InstFinanceiraDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexInstFinanceira;

/**
 * J34SiscomexInstFinanceira: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class InstFinanceiraDAOImpl extends GenericDAO<J34SiscomexInstFinanceira> implements InstFinanceiraDAO {

        private final static String SQL_SELECT = 
                "select codigo, descricao from j34_siscomex_inst_financeira where codigo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_inst_financeira ( codigo, descricao ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_inst_financeira set descricao = ? where codigo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_inst_financeira where codigo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_inst_financeira";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_inst_financeira where codigo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public InstFinanceiraDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @return A nova inst�ncia
         */
        private J34SiscomexInstFinanceira newInstanceWithPrimaryKey( String codigo ) {
                J34SiscomexInstFinanceira j34SiscomexInstFinanceira = new J34SiscomexInstFinanceira();
                j34SiscomexInstFinanceira.setCodigo( codigo );
                return j34SiscomexInstFinanceira ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexInstFinanceira find( String codigo ) {
                J34SiscomexInstFinanceira j34SiscomexInstFinanceira = newInstanceWithPrimaryKey( codigo ) ;
                if ( super.doSelect(j34SiscomexInstFinanceira) ) {
                        return j34SiscomexInstFinanceira ;
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
         * @param j34SiscomexInstFinanceira
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexInstFinanceira j34SiscomexInstFinanceira ) {
                return super.doSelect(j34SiscomexInstFinanceira) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexInstFinanceira
         */
        @Override
        public void insert(J34SiscomexInstFinanceira j34SiscomexInstFinanceira) {
                super.doInsert(j34SiscomexInstFinanceira);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexInstFinanceira
         * @return
         */
        @Override
        public int update(J34SiscomexInstFinanceira j34SiscomexInstFinanceira) {
                return super.doUpdate(j34SiscomexInstFinanceira);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @return
         */
        @Override
        public int delete( String codigo ) {
                J34SiscomexInstFinanceira j34SiscomexInstFinanceira = newInstanceWithPrimaryKey( codigo ) ;
                return super.doDelete(j34SiscomexInstFinanceira);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexInstFinanceira
         * @return
         */
        @Override
        public int delete( J34SiscomexInstFinanceira j34SiscomexInstFinanceira ) {
                return super.doDelete(j34SiscomexInstFinanceira);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @return
         */
        @Override
        public boolean exists( String codigo ) {
                J34SiscomexInstFinanceira j34SiscomexInstFinanceira = newInstanceWithPrimaryKey( codigo ) ;
                return super.doExists(j34SiscomexInstFinanceira);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexInstFinanceira
         * @return
         */
        @Override
        public boolean exists( J34SiscomexInstFinanceira j34SiscomexInstFinanceira ) {
                return super.doExists(j34SiscomexInstFinanceira);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexInstFinanceira j34SiscomexInstFinanceira) throws SQLException {
                
                setRawParameter(list,  j34SiscomexInstFinanceira.getCodigo() ) ; // "codigo" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexInstFinanceira populateBean(Cursor c, J34SiscomexInstFinanceira j34SiscomexInstFinanceira) throws SQLException {

               
                j34SiscomexInstFinanceira.setCodigo(c.getString(c.getColumnIndex("codigo"))); // java.lang.String
                j34SiscomexInstFinanceira.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexInstFinanceira ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexInstFinanceira j34SiscomexInstFinanceira) throws SQLException {

                
                setValue(ps, i++, j34SiscomexInstFinanceira.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexInstFinanceira.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexInstFinanceira j34SiscomexInstFinanceira) throws SQLException {

                
                setValue(ps, i++, j34SiscomexInstFinanceira.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexInstFinanceira.getCodigo() ) ; // "codigo" : java.lang.String
        }

}
