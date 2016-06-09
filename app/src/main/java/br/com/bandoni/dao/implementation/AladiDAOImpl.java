package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.AladiDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexAladi;

/**
 * J34SiscomexAladi: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class AladiDAOImpl extends GenericDAO<J34SiscomexAladi> implements AladiDAO {

        private final static String SQL_SELECT = 
                "select codigo, descricao from j34_siscomex_aladi where codigo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_aladi ( codigo, descricao ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_aladi set descricao = ? where codigo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_aladi where codigo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_aladi";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_aladi where codigo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public AladiDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @return A nova inst�ncia
         */
        private J34SiscomexAladi newInstanceWithPrimaryKey( Integer codigo ) {
                J34SiscomexAladi j34SiscomexAladi = new J34SiscomexAladi();
                j34SiscomexAladi.setCodigo( codigo );
                return j34SiscomexAladi ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexAladi find( Integer codigo )
        {
                J34SiscomexAladi j34SiscomexAladi = newInstanceWithPrimaryKey( codigo ) ;
                if ( super.doSelect(j34SiscomexAladi) ) {
                        return j34SiscomexAladi ;
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
         * @param j34SiscomexAladi
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexAladi j34SiscomexAladi ) {
                return super.doSelect(j34SiscomexAladi) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexAladi
         */
        @Override
        public void insert(J34SiscomexAladi j34SiscomexAladi) {
                super.doInsert(j34SiscomexAladi);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexAladi
         * @return
         */
        @Override
        public int update(J34SiscomexAladi j34SiscomexAladi) {
                return super.doUpdate(j34SiscomexAladi);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @return
         */
        @Override
        public int delete( Integer codigo ) {
                J34SiscomexAladi j34SiscomexAladi = newInstanceWithPrimaryKey( codigo ) ;
                return super.doDelete(j34SiscomexAladi);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexAladi
         * @return
         */
        @Override
        public int delete( J34SiscomexAladi j34SiscomexAladi ) {
                return super.doDelete(j34SiscomexAladi);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @return
         */
        @Override
        public boolean exists( Integer codigo ) {
                J34SiscomexAladi j34SiscomexAladi = newInstanceWithPrimaryKey( codigo ) ;
                return super.doExists(j34SiscomexAladi);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexAladi
         * @return
         */
        @Override
        public boolean exists( J34SiscomexAladi j34SiscomexAladi ) {
                return super.doExists(j34SiscomexAladi);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexAladi j34SiscomexAladi) throws SQLException {
                
                setRawParameter(list,j34SiscomexAladi.getCodigo()) ; // "codigo" : java.lang.Integer
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexAladi populateBean(Cursor c, J34SiscomexAladi j34SiscomexAladi) throws SQLException {

               
                j34SiscomexAladi.setCodigo(c.getInt(c.getColumnIndex("codigo"))); // java.lang.Integer
                j34SiscomexAladi.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexAladi ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexAladi j34SiscomexAladi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexAladi.getCodigo() ) ; // "codigo" : java.lang.Integer
                setValue(ps, i++, j34SiscomexAladi.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexAladi j34SiscomexAladi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexAladi.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexAladi.getCodigo() ) ; // "codigo" : java.lang.Integer
        }

}
