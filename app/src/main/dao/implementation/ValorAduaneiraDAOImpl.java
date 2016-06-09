package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.ValorAduaneiraDAO;
import br.com.bandoni.dao.tables.J34SiscomexValorAduaneira;

/**
 * J34SiscomexValorAduaneira: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class ValorAduaneiraDAOImpl extends GenericDAO<J34SiscomexValorAduaneira> implements ValorAduaneiraDAO {

        private final static String SQL_SELECT = 
                "select codigo, descricao from j34_siscomex_valor_aduaneira where codigo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_valor_aduaneira ( codigo, descricao ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_valor_aduaneira set descricao = ? where codigo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_valor_aduaneira where codigo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_valor_aduaneira";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_valor_aduaneira where codigo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public ValorAduaneiraDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @return A nova inst�ncia
         */
        private J34SiscomexValorAduaneira newInstanceWithPrimaryKey( String codigo ) {
                J34SiscomexValorAduaneira j34SiscomexValorAduaneira = new J34SiscomexValorAduaneira();
                j34SiscomexValorAduaneira.setCodigo( codigo );
                return j34SiscomexValorAduaneira ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexValorAduaneira find( String codigo ) {
                J34SiscomexValorAduaneira j34SiscomexValorAduaneira = newInstanceWithPrimaryKey( codigo ) ;
                if ( super.doSelect(j34SiscomexValorAduaneira) ) {
                        return j34SiscomexValorAduaneira ;
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
         * @param j34SiscomexValorAduaneira
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexValorAduaneira j34SiscomexValorAduaneira ) {
                return super.doSelect(j34SiscomexValorAduaneira) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexValorAduaneira
         */
        @Override
        public void insert(J34SiscomexValorAduaneira j34SiscomexValorAduaneira) {
                super.doInsert(j34SiscomexValorAduaneira);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexValorAduaneira
         * @return
         */
        @Override
        public int update(J34SiscomexValorAduaneira j34SiscomexValorAduaneira) {
                return super.doUpdate(j34SiscomexValorAduaneira);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @return
         */
        @Override
        public int delete( String codigo ) {
                J34SiscomexValorAduaneira j34SiscomexValorAduaneira = newInstanceWithPrimaryKey( codigo ) ;
                return super.doDelete(j34SiscomexValorAduaneira);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexValorAduaneira
         * @return
         */
        @Override
        public int delete( J34SiscomexValorAduaneira j34SiscomexValorAduaneira ) {
                return super.doDelete(j34SiscomexValorAduaneira);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @return
         */
        @Override
        public boolean exists( String codigo ) {
                J34SiscomexValorAduaneira j34SiscomexValorAduaneira = newInstanceWithPrimaryKey( codigo ) ;
                return super.doExists(j34SiscomexValorAduaneira);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexValorAduaneira
         * @return
         */
        @Override
        public boolean exists( J34SiscomexValorAduaneira j34SiscomexValorAduaneira ) {
                return super.doExists(j34SiscomexValorAduaneira);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexValorAduaneira j34SiscomexValorAduaneira) throws SQLException {
                
                setRawParameter(list, j34SiscomexValorAduaneira.getCodigo() ) ; // "codigo" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexValorAduaneira populateBean(Cursor c, J34SiscomexValorAduaneira j34SiscomexValorAduaneira) throws SQLException {

               
                j34SiscomexValorAduaneira.setCodigo(c.getString(c.getColumnIndex("codigo"))); // java.lang.String
                j34SiscomexValorAduaneira.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexValorAduaneira ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexValorAduaneira j34SiscomexValorAduaneira) throws SQLException {

                
                setValue(ps, i++, j34SiscomexValorAduaneira.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexValorAduaneira.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexValorAduaneira j34SiscomexValorAduaneira) throws SQLException {

                
                setValue(ps, i++, j34SiscomexValorAduaneira.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexValorAduaneira.getCodigo() ) ; // "codigo" : java.lang.String
        }

}
