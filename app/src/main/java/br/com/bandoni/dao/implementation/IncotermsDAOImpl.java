package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.IncotermsDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexIncoterms;

/**
 * J34SiscomexIncoterms: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class IncotermsDAOImpl extends GenericDAO<J34SiscomexIncoterms> implements IncotermsDAO {

        private final static String SQL_SELECT = 
                "select codigo, descricao from j34_siscomex_incoterms where codigo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_incoterms ( codigo, descricao ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_incoterms set descricao = ? where codigo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_incoterms where codigo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_incoterms";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_incoterms where codigo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public IncotermsDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @return A nova inst�ncia
         */
        private J34SiscomexIncoterms newInstanceWithPrimaryKey( String codigo ) {
                J34SiscomexIncoterms j34SiscomexIncoterms = new J34SiscomexIncoterms();
                j34SiscomexIncoterms.setCodigo( codigo );
                return j34SiscomexIncoterms ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexIncoterms find( String codigo ) {
                J34SiscomexIncoterms j34SiscomexIncoterms = newInstanceWithPrimaryKey( codigo ) ;
                if ( super.doSelect(j34SiscomexIncoterms) ) {
                        return j34SiscomexIncoterms ;
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
         * @param j34SiscomexIncoterms
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexIncoterms j34SiscomexIncoterms ) {
                return super.doSelect(j34SiscomexIncoterms) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexIncoterms
         */
        @Override
        public void insert(J34SiscomexIncoterms j34SiscomexIncoterms) {
                super.doInsert(j34SiscomexIncoterms);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexIncoterms
         * @return
         */
        @Override
        public int update(J34SiscomexIncoterms j34SiscomexIncoterms) {
                return super.doUpdate(j34SiscomexIncoterms);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @return
         */
        @Override
        public int delete( String codigo ) {
                J34SiscomexIncoterms j34SiscomexIncoterms = newInstanceWithPrimaryKey( codigo ) ;
                return super.doDelete(j34SiscomexIncoterms);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexIncoterms
         * @return
         */
        @Override
        public int delete( J34SiscomexIncoterms j34SiscomexIncoterms ) {
                return super.doDelete(j34SiscomexIncoterms);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @return
         */
        @Override
        public boolean exists( String codigo ) {
                J34SiscomexIncoterms j34SiscomexIncoterms = newInstanceWithPrimaryKey( codigo ) ;
                return super.doExists(j34SiscomexIncoterms);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexIncoterms
         * @return
         */
        @Override
        public boolean exists( J34SiscomexIncoterms j34SiscomexIncoterms ) {
                return super.doExists(j34SiscomexIncoterms);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexIncoterms j34SiscomexIncoterms) throws SQLException {
                
                setRawParameter(list,  j34SiscomexIncoterms.getCodigo() ) ; // "codigo" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexIncoterms populateBean(Cursor c, J34SiscomexIncoterms j34SiscomexIncoterms) throws SQLException {

               
                j34SiscomexIncoterms.setCodigo(c.getString(c.getColumnIndex("codigo"))); // java.lang.String
                j34SiscomexIncoterms.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexIncoterms ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexIncoterms j34SiscomexIncoterms) throws SQLException {

                
                setValue(ps, i++, j34SiscomexIncoterms.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexIncoterms.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexIncoterms j34SiscomexIncoterms) throws SQLException {

                
                setValue(ps, i++, j34SiscomexIncoterms.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexIncoterms.getCodigo() ) ; // "codigo" : java.lang.String
        }

}
