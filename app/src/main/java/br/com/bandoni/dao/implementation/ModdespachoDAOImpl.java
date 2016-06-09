package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.ModdespachoDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexModdespacho;

/**
 * J34SiscomexModdespacho: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class ModdespachoDAOImpl extends GenericDAO<J34SiscomexModdespacho> implements ModdespachoDAO {

        private final static String SQL_SELECT = 
                "select codigo_modalidade, nome_modalidade from j34_siscomex_moddespacho where codigo_modalidade = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_moddespacho ( codigo_modalidade, nome_modalidade ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_moddespacho set nome_modalidade = ? where codigo_modalidade = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_moddespacho where codigo_modalidade = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_moddespacho";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_moddespacho where codigo_modalidade = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public ModdespachoDAOImpl(Context context)
        {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo_modalidade;
         * @return A nova inst�ncia
         */
        private J34SiscomexModdespacho newInstanceWithPrimaryKey( int codigo_modalidade )
        {
                J34SiscomexModdespacho j34SiscomexModdespacho = new J34SiscomexModdespacho();
                j34SiscomexModdespacho.setCodigo_modalidade( codigo_modalidade );
                return j34SiscomexModdespacho ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo_modalidade;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexModdespacho find( Integer codigo_modalidade )
        {
                J34SiscomexModdespacho j34SiscomexModdespacho = newInstanceWithPrimaryKey( codigo_modalidade ) ;
                if ( super.doSelect(j34SiscomexModdespacho) )
                {
                        return j34SiscomexModdespacho ;
                }
                else
                {
                        return null ; // Not found
                }
        }
        //----------------------------------------------------------------------


    /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexModdespacho
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexModdespacho j34SiscomexModdespacho )
        {
                return super.doSelect(j34SiscomexModdespacho) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexModdespacho
         */
        @Override
        public void insert(J34SiscomexModdespacho j34SiscomexModdespacho)
        {
                super.doInsert(j34SiscomexModdespacho);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexModdespacho
         * @return
         */
        @Override
        public int update(J34SiscomexModdespacho j34SiscomexModdespacho)
        {
                return super.doUpdate(j34SiscomexModdespacho);
        }


    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo_modalidade;
         * @return
         */
        @Override
        public int delete( Integer codigo_modalidade )
        {
                J34SiscomexModdespacho j34SiscomexModdespacho = newInstanceWithPrimaryKey( codigo_modalidade ) ;
                return super.doDelete(j34SiscomexModdespacho);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexModdespacho
         * @return
         */
        @Override
        public int delete( J34SiscomexModdespacho j34SiscomexModdespacho )
        {
                return super.doDelete(j34SiscomexModdespacho);
        }

    /**
     * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
     *
     * @param codigoModalidade
     * @return
     */

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo_modalidade;
         * @return
         */
        @Override
        public boolean exists( Integer codigo_modalidade )
        {
                J34SiscomexModdespacho j34SiscomexModdespacho = newInstanceWithPrimaryKey( codigo_modalidade ) ;
                return super.doExists(j34SiscomexModdespacho);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexModdespacho
         * @return
         */
        @Override
        public boolean exists( J34SiscomexModdespacho j34SiscomexModdespacho )
        {
                return super.doExists(j34SiscomexModdespacho);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexModdespacho j34SiscomexModdespacho) throws SQLException {
                
                setRawParameter(list,  j34SiscomexModdespacho.getCodigo_modalidade()) ; // "codigo_modalidade" : java.lang.int
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexModdespacho populateBean(Cursor c, J34SiscomexModdespacho j34SiscomexModdespacho) throws SQLException {

               
                j34SiscomexModdespacho.setCodigo_modalidade(c.getInt(c.getColumnIndex("codigo_modalidade"))); // java.lang.int
                j34SiscomexModdespacho.setNome_modalidade(c.getString(c.getColumnIndex("nome_modalidade"))); // java.lang.String
                return j34SiscomexModdespacho ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexModdespacho j34SiscomexModdespacho) throws SQLException {

                
                setValue(ps, i++, j34SiscomexModdespacho.getCodigo_modalidade() ) ; // "codigo_modalidade" : java.lang.int
                setValue(ps, i++, j34SiscomexModdespacho.getNome_modalidade() ) ; // "nome_modalidade" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexModdespacho j34SiscomexModdespacho) throws SQLException {

                
                setValue(ps, i++, j34SiscomexModdespacho.getNome_modalidade() ) ; // "nome_modalidade" : java.lang.String
                
                setValue(ps, i++, j34SiscomexModdespacho.getCodigo_modalidade() ) ; // "codigo_modalidade" : java.lang.int
        }

}
