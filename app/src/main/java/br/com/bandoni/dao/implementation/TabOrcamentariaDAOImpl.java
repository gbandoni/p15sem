package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.TabOrcamentariaDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexTabOrcamentaria;

/**
 * J34SiscomexTabOrcamentaria: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class TabOrcamentariaDAOImpl extends GenericDAO<J34SiscomexTabOrcamentaria> implements TabOrcamentariaDAO {

        private final static String SQL_SELECT = 
                "select codigo, descricao from j34_siscomex_tab_orcamentaria where codigo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_tab_orcamentaria ( codigo, descricao ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_tab_orcamentaria set descricao = ? where codigo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_tab_orcamentaria where codigo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_tab_orcamentaria";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_tab_orcamentaria where codigo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public TabOrcamentariaDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @return A nova inst�ncia
         */
        private J34SiscomexTabOrcamentaria newInstanceWithPrimaryKey( String codigo ) {
                J34SiscomexTabOrcamentaria j34SiscomexTabOrcamentaria = new J34SiscomexTabOrcamentaria();
                j34SiscomexTabOrcamentaria.setCodigo( codigo );
                return j34SiscomexTabOrcamentaria ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexTabOrcamentaria find( String codigo ) {
                J34SiscomexTabOrcamentaria j34SiscomexTabOrcamentaria = newInstanceWithPrimaryKey( codigo ) ;
                if ( super.doSelect(j34SiscomexTabOrcamentaria) ) {
                        return j34SiscomexTabOrcamentaria ;
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
         * @param j34SiscomexTabOrcamentaria
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexTabOrcamentaria j34SiscomexTabOrcamentaria ) {
                return super.doSelect(j34SiscomexTabOrcamentaria) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexTabOrcamentaria
         */
        @Override
        public void insert(J34SiscomexTabOrcamentaria j34SiscomexTabOrcamentaria) {
                super.doInsert(j34SiscomexTabOrcamentaria);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexTabOrcamentaria
         * @return
         */
        @Override
        public int update(J34SiscomexTabOrcamentaria j34SiscomexTabOrcamentaria) {
                return super.doUpdate(j34SiscomexTabOrcamentaria);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @return
         */
        @Override
        public int delete( String codigo ) {
                J34SiscomexTabOrcamentaria j34SiscomexTabOrcamentaria = newInstanceWithPrimaryKey( codigo ) ;
                return super.doDelete(j34SiscomexTabOrcamentaria);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexTabOrcamentaria
         * @return
         */
        @Override
        public int delete( J34SiscomexTabOrcamentaria j34SiscomexTabOrcamentaria ) {
                return super.doDelete(j34SiscomexTabOrcamentaria);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @return
         */
        @Override
        public boolean exists( String codigo ) {
                J34SiscomexTabOrcamentaria j34SiscomexTabOrcamentaria = newInstanceWithPrimaryKey( codigo ) ;
                return super.doExists(j34SiscomexTabOrcamentaria);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexTabOrcamentaria
         * @return
         */
        @Override
        public boolean exists( J34SiscomexTabOrcamentaria j34SiscomexTabOrcamentaria ) {
                return super.doExists(j34SiscomexTabOrcamentaria);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexTabOrcamentaria j34SiscomexTabOrcamentaria) throws SQLException {
                
                setRawParameter(list,j34SiscomexTabOrcamentaria.getCodigo() ) ; // "codigo" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexTabOrcamentaria populateBean(Cursor c, J34SiscomexTabOrcamentaria j34SiscomexTabOrcamentaria) throws SQLException {

               
                j34SiscomexTabOrcamentaria.setCodigo(c.getString(c.getColumnIndex("codigo"))); // java.lang.String
                j34SiscomexTabOrcamentaria.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexTabOrcamentaria ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexTabOrcamentaria j34SiscomexTabOrcamentaria) throws SQLException {

                
                setValue(ps, i++, j34SiscomexTabOrcamentaria.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexTabOrcamentaria.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexTabOrcamentaria j34SiscomexTabOrcamentaria) throws SQLException {

                
                setValue(ps, i++, j34SiscomexTabOrcamentaria.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexTabOrcamentaria.getCodigo() ) ; // "codigo" : java.lang.String
        }

}
