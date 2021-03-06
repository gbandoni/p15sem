package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.RegimeTributDAO;
import br.com.bandoni.dao.tables.J34SiscomexRegimeTribut;

/**
 * J34SiscomexRegimeTribut: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class RegimeTributDAOImpl extends GenericDAO<J34SiscomexRegimeTribut> implements RegimeTributDAO {

        private final static String SQL_SELECT = 
                "select codigo, descricao from j34_siscomex_regime_tribut where codigo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_regime_tribut ( codigo, descricao ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_regime_tribut set descricao = ? where codigo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_regime_tribut where codigo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_regime_tribut";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_regime_tribut where codigo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public RegimeTributDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @return A nova inst�ncia
         */
        private J34SiscomexRegimeTribut newInstanceWithPrimaryKey( String codigo ) {
                J34SiscomexRegimeTribut j34SiscomexRegimeTribut = new J34SiscomexRegimeTribut();
                j34SiscomexRegimeTribut.setCodigo( codigo );
                return j34SiscomexRegimeTribut ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexRegimeTribut find( String codigo ) {
                J34SiscomexRegimeTribut j34SiscomexRegimeTribut = newInstanceWithPrimaryKey( codigo ) ;
                if ( super.doSelect(j34SiscomexRegimeTribut) ) {
                        return j34SiscomexRegimeTribut ;
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
         * @param j34SiscomexRegimeTribut
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexRegimeTribut j34SiscomexRegimeTribut ) {
                return super.doSelect(j34SiscomexRegimeTribut) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexRegimeTribut
         */
        @Override
        public void insert(J34SiscomexRegimeTribut j34SiscomexRegimeTribut) {
                super.doInsert(j34SiscomexRegimeTribut);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexRegimeTribut
         * @return
         */
        @Override
        public int update(J34SiscomexRegimeTribut j34SiscomexRegimeTribut) {
                return super.doUpdate(j34SiscomexRegimeTribut);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @return
         */
        @Override
        public int delete( String codigo ) {
                J34SiscomexRegimeTribut j34SiscomexRegimeTribut = newInstanceWithPrimaryKey( codigo ) ;
                return super.doDelete(j34SiscomexRegimeTribut);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexRegimeTribut
         * @return
         */
        @Override
        public int delete( J34SiscomexRegimeTribut j34SiscomexRegimeTribut ) {
                return super.doDelete(j34SiscomexRegimeTribut);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @return
         */
        @Override
        public boolean exists( String codigo ) {
                J34SiscomexRegimeTribut j34SiscomexRegimeTribut = newInstanceWithPrimaryKey( codigo ) ;
                return super.doExists(j34SiscomexRegimeTribut);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexRegimeTribut
         * @return
         */
        @Override
        public boolean exists( J34SiscomexRegimeTribut j34SiscomexRegimeTribut ) {
                return super.doExists(j34SiscomexRegimeTribut);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexRegimeTribut j34SiscomexRegimeTribut) throws SQLException {
                
                setRawParameter(list, j34SiscomexRegimeTribut.getCodigo() ) ; // "codigo" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexRegimeTribut populateBean(Cursor c, J34SiscomexRegimeTribut j34SiscomexRegimeTribut) throws SQLException {

               
                j34SiscomexRegimeTribut.setCodigo(c.getString(c.getColumnIndex("codigo"))); // java.lang.String
                j34SiscomexRegimeTribut.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexRegimeTribut ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexRegimeTribut j34SiscomexRegimeTribut) throws SQLException {

                
                setValue(ps, i++, j34SiscomexRegimeTribut.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexRegimeTribut.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexRegimeTribut j34SiscomexRegimeTribut) throws SQLException {

                
                setValue(ps, i++, j34SiscomexRegimeTribut.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexRegimeTribut.getCodigo() ) ; // "codigo" : java.lang.String
        }

}
