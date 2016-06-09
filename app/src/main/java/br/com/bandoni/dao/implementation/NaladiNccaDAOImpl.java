package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.NaladiNccaDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexNaladiNcca;

/**
 * J34SiscomexNaladiNcca: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class NaladiNccaDAOImpl extends GenericDAO<J34SiscomexNaladiNcca> implements NaladiNccaDAO {

        private final static String SQL_SELECT = 
                "select codigo, ordem, descricao from j34_siscomex_naladi_ncca where codigo = ? and ordem = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_naladi_ncca ( codigo, ordem, descricao ) values ( ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_naladi_ncca set descricao = ? where codigo = ? and ordem = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_naladi_ncca where codigo = ? and ordem = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_naladi_ncca";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_naladi_ncca where codigo = ? and ordem = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public NaladiNccaDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @param ordem;
         * @return A nova inst�ncia
         */
        private J34SiscomexNaladiNcca newInstanceWithPrimaryKey( String codigo, String ordem ) {
                J34SiscomexNaladiNcca j34SiscomexNaladiNcca = new J34SiscomexNaladiNcca();
                j34SiscomexNaladiNcca.setCodigo( codigo );
                j34SiscomexNaladiNcca.setOrdem( ordem );
                return j34SiscomexNaladiNcca ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @param ordem;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexNaladiNcca find( String codigo, String ordem ) {
                J34SiscomexNaladiNcca j34SiscomexNaladiNcca = newInstanceWithPrimaryKey( codigo, ordem ) ;
                if ( super.doSelect(j34SiscomexNaladiNcca) ) {
                        return j34SiscomexNaladiNcca ;
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
         * @param j34SiscomexNaladiNcca
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexNaladiNcca j34SiscomexNaladiNcca ) {
                return super.doSelect(j34SiscomexNaladiNcca) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexNaladiNcca
         */
        @Override
        public void insert(J34SiscomexNaladiNcca j34SiscomexNaladiNcca) {
                super.doInsert(j34SiscomexNaladiNcca);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexNaladiNcca
         * @return
         */
        @Override
        public int update(J34SiscomexNaladiNcca j34SiscomexNaladiNcca) {
                return super.doUpdate(j34SiscomexNaladiNcca);
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
                J34SiscomexNaladiNcca j34SiscomexNaladiNcca = newInstanceWithPrimaryKey( codigo, ordem ) ;
                return super.doDelete(j34SiscomexNaladiNcca);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexNaladiNcca
         * @return
         */
        @Override
        public int delete( J34SiscomexNaladiNcca j34SiscomexNaladiNcca ) {
                return super.doDelete(j34SiscomexNaladiNcca);
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
                J34SiscomexNaladiNcca j34SiscomexNaladiNcca = newInstanceWithPrimaryKey( codigo, ordem ) ;
                return super.doExists(j34SiscomexNaladiNcca);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexNaladiNcca
         * @return
         */
        @Override
        public boolean exists( J34SiscomexNaladiNcca j34SiscomexNaladiNcca ) {
                return super.doExists(j34SiscomexNaladiNcca);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexNaladiNcca j34SiscomexNaladiNcca) throws SQLException {
                
                setRawParameter(list,j34SiscomexNaladiNcca.getCodigo() ) ; // "codigo" : java.lang.String
                setRawParameter(list,j34SiscomexNaladiNcca.getOrdem() ) ; // "ordem" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexNaladiNcca populateBean(Cursor c, J34SiscomexNaladiNcca j34SiscomexNaladiNcca) throws SQLException {

               
                j34SiscomexNaladiNcca.setCodigo(c.getString(c.getColumnIndex("codigo"))); // java.lang.String
                j34SiscomexNaladiNcca.setOrdem(c.getString(c.getColumnIndex("ordem"))); // java.lang.String
                j34SiscomexNaladiNcca.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexNaladiNcca ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexNaladiNcca j34SiscomexNaladiNcca) throws SQLException {

                
                setValue(ps, i++, j34SiscomexNaladiNcca.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexNaladiNcca.getOrdem() ) ; // "ordem" : java.lang.String
                setValue(ps, i++, j34SiscomexNaladiNcca.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexNaladiNcca j34SiscomexNaladiNcca) throws SQLException {

                
                setValue(ps, i++, j34SiscomexNaladiNcca.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexNaladiNcca.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexNaladiNcca.getOrdem() ) ; // "ordem" : java.lang.String
        }

}
