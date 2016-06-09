package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.PaisesDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexPaises;

/**
 * J34SiscomexPaises: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class PaisesDAOImpl extends GenericDAO<J34SiscomexPaises> implements PaisesDAO {

        private final static String SQL_SELECT = 
                "select codigo_pais, nome_pais from j34_siscomex_paises where codigo_pais = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_paises ( codigo_pais, nome_pais ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_paises set nome_pais = ? where codigo_pais = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_paises where codigo_pais = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_paises";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_paises where codigo_pais = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public PaisesDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo_pais;
         * @return A nova inst�ncia
         */
        private J34SiscomexPaises newInstanceWithPrimaryKey( String codigo_pais ) {
                J34SiscomexPaises j34SiscomexPaises = new J34SiscomexPaises();
                j34SiscomexPaises.setCodigo_pais( codigo_pais );
                return j34SiscomexPaises ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo_pais;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexPaises find( String codigo_pais ) {
                J34SiscomexPaises j34SiscomexPaises = newInstanceWithPrimaryKey( codigo_pais ) ;
                if ( super.doSelect(j34SiscomexPaises) ) {
                        return j34SiscomexPaises ;
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
         * @param j34SiscomexPaises
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexPaises j34SiscomexPaises ) {
                return super.doSelect(j34SiscomexPaises) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexPaises
         */
        @Override
        public void insert(J34SiscomexPaises j34SiscomexPaises) {
                super.doInsert(j34SiscomexPaises);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexPaises
         * @return
         */
        @Override
        public int update(J34SiscomexPaises j34SiscomexPaises) {
                return super.doUpdate(j34SiscomexPaises);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo_pais;
         * @return
         */
        @Override
        public int delete( String codigo_pais ) {
                J34SiscomexPaises j34SiscomexPaises = newInstanceWithPrimaryKey( codigo_pais ) ;
                return super.doDelete(j34SiscomexPaises);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexPaises
         * @return
         */
        @Override
        public int delete( J34SiscomexPaises j34SiscomexPaises ) {
                return super.doDelete(j34SiscomexPaises);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo_pais;
         * @return
         */
        @Override
        public boolean exists( String codigo_pais ) {
                J34SiscomexPaises j34SiscomexPaises = newInstanceWithPrimaryKey( codigo_pais ) ;
                return super.doExists(j34SiscomexPaises);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexPaises
         * @return
         */
        @Override
        public boolean exists( J34SiscomexPaises j34SiscomexPaises ) {
                return super.doExists(j34SiscomexPaises);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexPaises j34SiscomexPaises) throws SQLException {
                
                setRawParameter(list, j34SiscomexPaises.getCodigo_pais() ) ; // "codigo_pais" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexPaises populateBean(Cursor c, J34SiscomexPaises j34SiscomexPaises) throws SQLException {

               
                j34SiscomexPaises.setCodigo_pais(c.getString(c.getColumnIndex("codigo_pais"))); // java.lang.String
                j34SiscomexPaises.setNome_pais(c.getString(c.getColumnIndex("nome_pais"))); // java.lang.String
                return j34SiscomexPaises ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexPaises j34SiscomexPaises) throws SQLException {

                
                setValue(ps, i++, j34SiscomexPaises.getCodigo_pais()) ; // "codigo_pais" : java.lang.String
                setValue(ps, i++, j34SiscomexPaises.getNome_pais() ) ; // "nome_pais" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexPaises j34SiscomexPaises) throws SQLException {

                
                setValue(ps, i++, j34SiscomexPaises.getNome_pais() ) ; // "nome_pais" : java.lang.String
                
                setValue(ps, i++, j34SiscomexPaises.getCodigo_pais()) ; // "codigo_pais" : java.lang.String
        }

}
