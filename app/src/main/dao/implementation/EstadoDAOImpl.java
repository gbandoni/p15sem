package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.EstadoDAO;
import br.com.bandoni.dao.tables.J34SiscomexEstado;

/**
 * J34SiscomexEstado: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class EstadoDAOImpl extends GenericDAO<J34SiscomexEstado> implements EstadoDAO {

        private final static String SQL_SELECT = 
                "select estado_id, sigla, nome from j34_siscomex_estado where estado_id = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_estado ( estado_id, sigla, nome ) values ( ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_estado set sigla = ?, nome = ? where estado_id = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_estado where estado_id = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_estado";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_estado where estado_id = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public EstadoDAOImpl(Context context)
        {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param estado_id
         * @return A nova inst�ncia
         */
        private J34SiscomexEstado newInstanceWithPrimaryKey( String estado_id )
        {
                J34SiscomexEstado j34SiscomexEstado = new J34SiscomexEstado();
                j34SiscomexEstado.setEstado_id(estado_id );
                return j34SiscomexEstado ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param estado_id;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexEstado find( String estado_id )
        {
                J34SiscomexEstado j34SiscomexEstado = newInstanceWithPrimaryKey( estado_id ) ;
                if ( super.doSelect(j34SiscomexEstado) )
                {
                        return j34SiscomexEstado ;
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
         * @param j34SiscomexEstado
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexEstado j34SiscomexEstado )
        {
                return super.doSelect(j34SiscomexEstado) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexEstado
         */
        @Override
        public void insert(J34SiscomexEstado j34SiscomexEstado)
        {
                super.doInsert(j34SiscomexEstado);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexEstado
         * @return
         */
        @Override
        public int update(J34SiscomexEstado j34SiscomexEstado)
        {
                return super.doUpdate(j34SiscomexEstado);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param estado_id;
         * @return
         */
        @Override
        public int delete( String estado_id )
        {
                J34SiscomexEstado j34SiscomexEstado = newInstanceWithPrimaryKey( estado_id ) ;
                return super.doDelete(j34SiscomexEstado);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexEstado
         * @return
         */
        @Override
        public int delete( J34SiscomexEstado j34SiscomexEstado )
        {
                return super.doDelete(j34SiscomexEstado);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param estado_id;
         * @return
         */
        @Override
        public boolean exists( String estado_id )
        {
                J34SiscomexEstado j34SiscomexEstado = newInstanceWithPrimaryKey( estado_id) ;
                return super.doExists(j34SiscomexEstado);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexEstado
         * @return
         */
        @Override
        public boolean exists( J34SiscomexEstado j34SiscomexEstado )
        {
                return super.doExists(j34SiscomexEstado);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexEstado j34SiscomexEstado) throws SQLException {
                
                setRawParameter(list,  j34SiscomexEstado.getEstado_id()) ; // "estado_id" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexEstado populateBean(Cursor c, J34SiscomexEstado j34SiscomexEstado) throws SQLException {

               
                j34SiscomexEstado.setEstado_id(c.getString(c.getColumnIndex("estado_id"))); // java.lang.String
                j34SiscomexEstado.setSigla(c.getString(c.getColumnIndex("sigla"))); // java.lang.String
                j34SiscomexEstado.setNome(c.getString(c.getColumnIndex("nome"))); // java.lang.String
                return j34SiscomexEstado ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexEstado j34SiscomexEstado) throws SQLException {

                
                setValue(ps, i++, j34SiscomexEstado.getEstado_id() ) ; // "estado_id" : java.lang.String
                setValue(ps, i++, j34SiscomexEstado.getSigla() ) ; // "sigla" : java.lang.String
                setValue(ps, i++, j34SiscomexEstado.getNome() ) ; // "nome" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexEstado j34SiscomexEstado) throws SQLException {

                
                setValue(ps, i++, j34SiscomexEstado.getSigla() ) ; // "sigla" : java.lang.String
                setValue(ps, i++, j34SiscomexEstado.getNome() ) ; // "nome" : java.lang.String
                
                setValue(ps, i++, j34SiscomexEstado.getEstado_id() ) ; // "estado_id" : java.lang.String
        }

}
