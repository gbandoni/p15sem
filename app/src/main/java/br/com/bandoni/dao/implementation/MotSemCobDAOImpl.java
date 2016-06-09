package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.MotSemCobDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexMotSemCob;

/**
 * J34SiscomexMotSemCob: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class MotSemCobDAOImpl extends GenericDAO<J34SiscomexMotSemCob> implements MotSemCobDAO {

        private final static String SQL_SELECT = 
                "select codigo, descricao from j34_siscomex_mot_sem_cob where codigo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_mot_sem_cob ( codigo, descricao ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_mot_sem_cob set descricao = ? where codigo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_mot_sem_cob where codigo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_mot_sem_cob";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_mot_sem_cob where codigo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public MotSemCobDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @return A nova inst�ncia
         */
        private J34SiscomexMotSemCob newInstanceWithPrimaryKey( String codigo ) {
                J34SiscomexMotSemCob j34SiscomexMotSemCob = new J34SiscomexMotSemCob();
                j34SiscomexMotSemCob.setCodigo( codigo );
                return j34SiscomexMotSemCob ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexMotSemCob find( String codigo ) {
                J34SiscomexMotSemCob j34SiscomexMotSemCob = newInstanceWithPrimaryKey( codigo ) ;
                if ( super.doSelect(j34SiscomexMotSemCob) ) {
                        return j34SiscomexMotSemCob ;
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
         * @param j34SiscomexMotSemCob
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexMotSemCob j34SiscomexMotSemCob ) {
                return super.doSelect(j34SiscomexMotSemCob) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexMotSemCob
         */
        @Override
        public void insert(J34SiscomexMotSemCob j34SiscomexMotSemCob) {
                super.doInsert(j34SiscomexMotSemCob);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexMotSemCob
         * @return
         */
        @Override
        public int update(J34SiscomexMotSemCob j34SiscomexMotSemCob) {
                return super.doUpdate(j34SiscomexMotSemCob);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @return
         */
        @Override
        public int delete( String codigo ) {
                J34SiscomexMotSemCob j34SiscomexMotSemCob = newInstanceWithPrimaryKey( codigo ) ;
                return super.doDelete(j34SiscomexMotSemCob);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexMotSemCob
         * @return
         */
        @Override
        public int delete( J34SiscomexMotSemCob j34SiscomexMotSemCob ) {
                return super.doDelete(j34SiscomexMotSemCob);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @return
         */
        @Override
        public boolean exists( String codigo ) {
                J34SiscomexMotSemCob j34SiscomexMotSemCob = newInstanceWithPrimaryKey( codigo ) ;
                return super.doExists(j34SiscomexMotSemCob);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexMotSemCob
         * @return
         */
        @Override
        public boolean exists( J34SiscomexMotSemCob j34SiscomexMotSemCob ) {
                return super.doExists(j34SiscomexMotSemCob);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexMotSemCob j34SiscomexMotSemCob) throws SQLException {
                
setRawParameter(list, j34SiscomexMotSemCob.getCodigo() ) ; // "codigo" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexMotSemCob populateBean(Cursor c, J34SiscomexMotSemCob j34SiscomexMotSemCob) throws SQLException {

               
                j34SiscomexMotSemCob.setCodigo(c.getString(c.getColumnIndex("codigo"))); // java.lang.String
                j34SiscomexMotSemCob.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexMotSemCob ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexMotSemCob j34SiscomexMotSemCob) throws SQLException {

                
                setValue(ps, i++, j34SiscomexMotSemCob.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexMotSemCob.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexMotSemCob j34SiscomexMotSemCob) throws SQLException {

                
                setValue(ps, i++, j34SiscomexMotSemCob.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexMotSemCob.getCodigo() ) ; // "codigo" : java.lang.String
        }

}
