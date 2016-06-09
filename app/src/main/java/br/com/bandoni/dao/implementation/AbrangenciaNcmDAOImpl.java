package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import java.sql.SQLException;
import java.util.List;import java.util.List;
import android.database.sqlite.SQLiteStatement;
import br.com.bandoni.dao.interfaces.AbrangenciaNcmDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexAbrangenciaNcm;

/**
 * J34SiscomexAbrangenciaNcm: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class AbrangenciaNcmDAOImpl extends GenericDAO<J34SiscomexAbrangenciaNcm> implements AbrangenciaNcmDAO {

        private final static String SQL_SELECT = 
                "select codigo, descricao from j34_siscomex_abrangencia_ncm where codigo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_abrangencia_ncm ( codigo, descricao ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_abrangencia_ncm set descricao = ? where codigo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_abrangencia_ncm where codigo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_abrangencia_ncm";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_abrangencia_ncm where codigo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public AbrangenciaNcmDAOImpl(Context context)
        {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @return A nova inst�ncia
         */
        private J34SiscomexAbrangenciaNcm newInstanceWithPrimaryKey( String codigo ) {
                J34SiscomexAbrangenciaNcm j34SiscomexAbrangenciaNcm = new J34SiscomexAbrangenciaNcm();
                j34SiscomexAbrangenciaNcm.setCodigo( codigo );
                return j34SiscomexAbrangenciaNcm ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexAbrangenciaNcm find( String codigo ) {
                J34SiscomexAbrangenciaNcm j34SiscomexAbrangenciaNcm = newInstanceWithPrimaryKey( codigo ) ;
                if ( super.doSelect(j34SiscomexAbrangenciaNcm) ) {
                        return j34SiscomexAbrangenciaNcm ;
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
         * @param j34SiscomexAbrangenciaNcm
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexAbrangenciaNcm j34SiscomexAbrangenciaNcm ) {
                return super.doSelect(j34SiscomexAbrangenciaNcm) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexAbrangenciaNcm
         */
        @Override
        public void insert(J34SiscomexAbrangenciaNcm j34SiscomexAbrangenciaNcm) {
                super.doInsert(j34SiscomexAbrangenciaNcm);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexAbrangenciaNcm
         * @return Numero de linhas afetadas
         */
        @Override
        public int update(J34SiscomexAbrangenciaNcm j34SiscomexAbrangenciaNcm) {
                return super.doUpdate(j34SiscomexAbrangenciaNcm);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @return
         */
        @Override
        public int delete( String codigo ) {
                J34SiscomexAbrangenciaNcm j34SiscomexAbrangenciaNcm = newInstanceWithPrimaryKey( codigo ) ;
                return super.doDelete(j34SiscomexAbrangenciaNcm);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexAbrangenciaNcm
         * @return
         */
        @Override
        public int delete( J34SiscomexAbrangenciaNcm j34SiscomexAbrangenciaNcm ) {
                return super.doDelete(j34SiscomexAbrangenciaNcm);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @return
         */
        @Override
        public boolean exists( String codigo ) {
                J34SiscomexAbrangenciaNcm j34SiscomexAbrangenciaNcm = newInstanceWithPrimaryKey( codigo ) ;
                return super.doExists(j34SiscomexAbrangenciaNcm);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexAbrangenciaNcm
         * @return  boolean
         */
        @Override
        public boolean exists( J34SiscomexAbrangenciaNcm j34SiscomexAbrangenciaNcm ) {
                return super.doExists(j34SiscomexAbrangenciaNcm);
        }

    //----------------------------------------------------------------------
        /**
         * retorna o total de registros na tabela
         * @return long
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexAbrangenciaNcm j34SiscomexAbrangenciaNcm) throws SQLException {
                
                setRawParameter(list,j34SiscomexAbrangenciaNcm.getCodigo()) ; // "codigo" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexAbrangenciaNcm populateBean(Cursor c, J34SiscomexAbrangenciaNcm j34SiscomexAbrangenciaNcm) throws SQLException {

               
                j34SiscomexAbrangenciaNcm.setCodigo(c.getString(c.getColumnIndex("codigo"))); // java.lang.String
                j34SiscomexAbrangenciaNcm.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexAbrangenciaNcm ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexAbrangenciaNcm j34SiscomexAbrangenciaNcm) throws SQLException {

                
                setValue(ps, i++, j34SiscomexAbrangenciaNcm.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexAbrangenciaNcm.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexAbrangenciaNcm j34SiscomexAbrangenciaNcm) throws SQLException {

                
                setValue(ps, i++, j34SiscomexAbrangenciaNcm.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexAbrangenciaNcm.getCodigo() ) ; // "codigo" : java.lang.String
        }

}
