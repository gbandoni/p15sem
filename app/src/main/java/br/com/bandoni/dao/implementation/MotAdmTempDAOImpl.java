package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.MotAdmTempDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexMotAdmTemp;

/**
 * J34SiscomexMotAdmTemp: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class MotAdmTempDAOImpl extends GenericDAO<J34SiscomexMotAdmTemp> implements MotAdmTempDAO {

        private final static String SQL_SELECT = 
                "select codigo, descricao from j34_siscomex_mot_adm_temp where codigo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_mot_adm_temp ( codigo, descricao ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_mot_adm_temp set descricao = ? where codigo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_mot_adm_temp where codigo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_mot_adm_temp";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_mot_adm_temp where codigo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public MotAdmTempDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @return A nova inst�ncia
         */
        private J34SiscomexMotAdmTemp newInstanceWithPrimaryKey( String codigo ) {
                J34SiscomexMotAdmTemp j34SiscomexMotAdmTemp = new J34SiscomexMotAdmTemp();
                j34SiscomexMotAdmTemp.setCodigo( codigo );
                return j34SiscomexMotAdmTemp ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexMotAdmTemp find( String codigo ) {
                J34SiscomexMotAdmTemp j34SiscomexMotAdmTemp = newInstanceWithPrimaryKey( codigo ) ;
                if ( super.doSelect(j34SiscomexMotAdmTemp) ) {
                        return j34SiscomexMotAdmTemp ;
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
         * @param j34SiscomexMotAdmTemp
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexMotAdmTemp j34SiscomexMotAdmTemp ) {
                return super.doSelect(j34SiscomexMotAdmTemp) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexMotAdmTemp
         */
        @Override
        public void insert(J34SiscomexMotAdmTemp j34SiscomexMotAdmTemp) {
                super.doInsert(j34SiscomexMotAdmTemp);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexMotAdmTemp
         * @return
         */
        @Override
        public int update(J34SiscomexMotAdmTemp j34SiscomexMotAdmTemp) {
                return super.doUpdate(j34SiscomexMotAdmTemp);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @return
         */
        @Override
        public int delete( String codigo ) {
                J34SiscomexMotAdmTemp j34SiscomexMotAdmTemp = newInstanceWithPrimaryKey( codigo ) ;
                return super.doDelete(j34SiscomexMotAdmTemp);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexMotAdmTemp
         * @return
         */
        @Override
        public int delete( J34SiscomexMotAdmTemp j34SiscomexMotAdmTemp ) {
                return super.doDelete(j34SiscomexMotAdmTemp);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @return
         */
        @Override
        public boolean exists( String codigo ) {
                J34SiscomexMotAdmTemp j34SiscomexMotAdmTemp = newInstanceWithPrimaryKey( codigo ) ;
                return super.doExists(j34SiscomexMotAdmTemp);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexMotAdmTemp
         * @return
         */
        @Override
        public boolean exists( J34SiscomexMotAdmTemp j34SiscomexMotAdmTemp ) {
                return super.doExists(j34SiscomexMotAdmTemp);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexMotAdmTemp j34SiscomexMotAdmTemp) throws SQLException {
                
                setRawParameter(list,  j34SiscomexMotAdmTemp.getCodigo() ) ; // "codigo" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexMotAdmTemp populateBean(Cursor c, J34SiscomexMotAdmTemp j34SiscomexMotAdmTemp) throws SQLException {

               
                j34SiscomexMotAdmTemp.setCodigo(c.getString(c.getColumnIndex("codigo"))); // java.lang.String
                j34SiscomexMotAdmTemp.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexMotAdmTemp ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexMotAdmTemp j34SiscomexMotAdmTemp) throws SQLException {

                
                setValue(ps, i++, j34SiscomexMotAdmTemp.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexMotAdmTemp.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexMotAdmTemp j34SiscomexMotAdmTemp) throws SQLException {

                
                setValue(ps, i++, j34SiscomexMotAdmTemp.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexMotAdmTemp.getCodigo() ) ; // "codigo" : java.lang.String
        }

}