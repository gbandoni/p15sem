package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.NaladiShDAO;
import br.com.bandoni.dao.tables.J34SiscomexNaladiSh;

/**
 * J34SiscomexNaladiSh: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class NaladiShDAOImpl extends GenericDAO<J34SiscomexNaladiSh> implements NaladiShDAO {

        private final static String SQL_SELECT = 
                "select codigo, ordem, descricao from j34_siscomex_naladi_sh where codigo = ? and ordem = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_naladi_sh ( codigo, ordem, descricao ) values ( ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_naladi_sh set descricao = ? where codigo = ? and ordem = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_naladi_sh where codigo = ? and ordem = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_naladi_sh";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_naladi_sh where codigo = ? and ordem = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public NaladiShDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @param ordem;
         * @return A nova inst�ncia
         */
        private J34SiscomexNaladiSh newInstanceWithPrimaryKey( String codigo, String ordem ) {
                J34SiscomexNaladiSh j34SiscomexNaladiSh = new J34SiscomexNaladiSh();
                j34SiscomexNaladiSh.setCodigo( codigo );
                j34SiscomexNaladiSh.setOrdem( ordem );
                return j34SiscomexNaladiSh ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @param ordem;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexNaladiSh find( String codigo, String ordem ) {
                J34SiscomexNaladiSh j34SiscomexNaladiSh = newInstanceWithPrimaryKey( codigo, ordem ) ;
                if ( super.doSelect(j34SiscomexNaladiSh) ) {
                        return j34SiscomexNaladiSh ;
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
         * @param j34SiscomexNaladiSh
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexNaladiSh j34SiscomexNaladiSh ) {
                return super.doSelect(j34SiscomexNaladiSh) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexNaladiSh
         */
        @Override
        public void insert(J34SiscomexNaladiSh j34SiscomexNaladiSh) {
                super.doInsert(j34SiscomexNaladiSh);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexNaladiSh
         * @return
         */
        @Override
        public int update(J34SiscomexNaladiSh j34SiscomexNaladiSh) {
                return super.doUpdate(j34SiscomexNaladiSh);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @param ordem;
         * @return
         */
        @Override
        public int delete( String codigo, String ordem ) {
                J34SiscomexNaladiSh j34SiscomexNaladiSh = newInstanceWithPrimaryKey( codigo, ordem ) ;
                return super.doDelete(j34SiscomexNaladiSh);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexNaladiSh
         * @return
         */
        @Override
        public int delete( J34SiscomexNaladiSh j34SiscomexNaladiSh ) {
                return super.doDelete(j34SiscomexNaladiSh);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @param ordem;
         * @return
         */
        @Override
        public boolean exists( String codigo, String ordem ) {
                J34SiscomexNaladiSh j34SiscomexNaladiSh = newInstanceWithPrimaryKey( codigo, ordem ) ;
                return super.doExists(j34SiscomexNaladiSh);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexNaladiSh
         * @return
         */
        @Override
        public boolean exists( J34SiscomexNaladiSh j34SiscomexNaladiSh ) {
                return super.doExists(j34SiscomexNaladiSh);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexNaladiSh j34SiscomexNaladiSh) throws SQLException {
                
                setRawParameter(list, j34SiscomexNaladiSh.getCodigo() ) ; // "codigo" : java.lang.String
                setRawParameter(list, j34SiscomexNaladiSh.getOrdem() ) ; // "ordem" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexNaladiSh populateBean(Cursor c, J34SiscomexNaladiSh j34SiscomexNaladiSh) throws SQLException {

               
                j34SiscomexNaladiSh.setCodigo(c.getString(c.getColumnIndex("codigo"))); // java.lang.String
                j34SiscomexNaladiSh.setOrdem(c.getString(c.getColumnIndex("ordem"))); // java.lang.String
                j34SiscomexNaladiSh.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexNaladiSh ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexNaladiSh j34SiscomexNaladiSh) throws SQLException {

                
                setValue(ps, i++, j34SiscomexNaladiSh.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexNaladiSh.getOrdem() ) ; // "ordem" : java.lang.String
                setValue(ps, i++, j34SiscomexNaladiSh.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexNaladiSh j34SiscomexNaladiSh) throws SQLException {

                
                setValue(ps, i++, j34SiscomexNaladiSh.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexNaladiSh.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexNaladiSh.getOrdem() ) ; // "ordem" : java.lang.String
        }

}
