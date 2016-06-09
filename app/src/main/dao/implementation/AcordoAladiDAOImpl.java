package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.AcordoAladiDAO;
import br.com.bandoni.dao.tables.J34SiscomexAcordoAladi;

/**
 * J34SiscomexAcordoAladi: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class AcordoAladiDAOImpl extends GenericDAO<J34SiscomexAcordoAladi> implements AcordoAladiDAO {

        private final static String SQL_SELECT = 
                "select codigo, descricao from j34_siscomex_acordo_aladi where codigo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_acordo_aladi ( codigo, descricao ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_acordo_aladi set descricao = ? where codigo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_acordo_aladi where codigo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_acordo_aladi";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_acordo_aladi where codigo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public AcordoAladiDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @return A nova inst�ncia
         */
        private J34SiscomexAcordoAladi newInstanceWithPrimaryKey( String codigo ) {
                J34SiscomexAcordoAladi j34SiscomexAcordoAladi = new J34SiscomexAcordoAladi();
                j34SiscomexAcordoAladi.setCodigo( codigo );
                return j34SiscomexAcordoAladi ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexAcordoAladi find( String codigo ) {
                J34SiscomexAcordoAladi j34SiscomexAcordoAladi = newInstanceWithPrimaryKey( codigo ) ;
                if ( super.doSelect(j34SiscomexAcordoAladi) ) {
                        return j34SiscomexAcordoAladi ;
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
         * @param j34SiscomexAcordoAladi
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexAcordoAladi j34SiscomexAcordoAladi ) {
                return super.doSelect(j34SiscomexAcordoAladi) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexAcordoAladi
         */
        @Override
        public void insert(J34SiscomexAcordoAladi j34SiscomexAcordoAladi) {
                super.doInsert(j34SiscomexAcordoAladi);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexAcordoAladi
         * @return
         */
        @Override
        public int update(J34SiscomexAcordoAladi j34SiscomexAcordoAladi) {
                return super.doUpdate(j34SiscomexAcordoAladi);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @return
         */
        @Override
        public int delete( String codigo ) {
                J34SiscomexAcordoAladi j34SiscomexAcordoAladi = newInstanceWithPrimaryKey( codigo ) ;
                return super.doDelete(j34SiscomexAcordoAladi);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexAcordoAladi
         * @return
         */
        @Override
        public int delete( J34SiscomexAcordoAladi j34SiscomexAcordoAladi ) {
                return super.doDelete(j34SiscomexAcordoAladi);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @return
         */
        @Override
        public boolean exists( String codigo ) {
                J34SiscomexAcordoAladi j34SiscomexAcordoAladi = newInstanceWithPrimaryKey( codigo ) ;
                return super.doExists(j34SiscomexAcordoAladi);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexAcordoAladi
         * @return
         */
        @Override
        public boolean exists( J34SiscomexAcordoAladi j34SiscomexAcordoAladi ) {
                return super.doExists(j34SiscomexAcordoAladi);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexAcordoAladi j34SiscomexAcordoAladi) throws SQLException {
                
                setRawParameter(list, j34SiscomexAcordoAladi.getCodigo() ) ; // "codigo" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexAcordoAladi populateBean(Cursor c, J34SiscomexAcordoAladi j34SiscomexAcordoAladi) throws SQLException {

               
                j34SiscomexAcordoAladi.setCodigo(c.getString(c.getColumnIndex("codigo"))); // java.lang.String
                j34SiscomexAcordoAladi.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexAcordoAladi ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexAcordoAladi j34SiscomexAcordoAladi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexAcordoAladi.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexAcordoAladi.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexAcordoAladi j34SiscomexAcordoAladi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexAcordoAladi.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexAcordoAladi.getCodigo() ) ; // "codigo" : java.lang.String
        }

}
