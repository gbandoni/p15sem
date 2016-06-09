package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.TipoRecipienteDAO;
import br.com.bandoni.dao.tables.J34SiscomexTipoRecipiente;

/**
 * J34SiscomexTipoRecipiente: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class TipoRecipienteDAOImpl extends GenericDAO<J34SiscomexTipoRecipiente> implements TipoRecipienteDAO {

        private final static String SQL_SELECT = 
                "select codigo, descricao from j34_siscomex_tipo_recipiente where codigo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_tipo_recipiente ( codigo, descricao ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_tipo_recipiente set descricao = ? where codigo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_tipo_recipiente where codigo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_tipo_recipiente";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_tipo_recipiente where codigo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public TipoRecipienteDAOImpl(Context context)
        {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @return A nova inst�ncia
         */
        private J34SiscomexTipoRecipiente newInstanceWithPrimaryKey( String codigo )
        {
                J34SiscomexTipoRecipiente j34SiscomexTipoRecipiente = new J34SiscomexTipoRecipiente();
                j34SiscomexTipoRecipiente.setCodigo( codigo );
                return j34SiscomexTipoRecipiente ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexTipoRecipiente find( String codigo )
        {
                J34SiscomexTipoRecipiente j34SiscomexTipoRecipiente = newInstanceWithPrimaryKey( codigo ) ;
                if ( super.doSelect(j34SiscomexTipoRecipiente) )
                {
                        return j34SiscomexTipoRecipiente ;
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
         * @param j34SiscomexTipoRecipiente
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexTipoRecipiente j34SiscomexTipoRecipiente )
        {
                return super.doSelect(j34SiscomexTipoRecipiente) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexTipoRecipiente
         */
        @Override
        public void insert(J34SiscomexTipoRecipiente j34SiscomexTipoRecipiente)
        {
                super.doInsert(j34SiscomexTipoRecipiente);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexTipoRecipiente
         * @return
         */
        @Override
        public int update(J34SiscomexTipoRecipiente j34SiscomexTipoRecipiente)
        {
                return super.doUpdate(j34SiscomexTipoRecipiente);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @return
         */
        @Override
        public int delete( String codigo )
        {
                J34SiscomexTipoRecipiente j34SiscomexTipoRecipiente = newInstanceWithPrimaryKey( codigo ) ;
                return super.doDelete(j34SiscomexTipoRecipiente);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexTipoRecipiente
         * @return
         */
        @Override
        public int delete( J34SiscomexTipoRecipiente j34SiscomexTipoRecipiente )
        {
                return super.doDelete(j34SiscomexTipoRecipiente);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @return
         */
        @Override
        public boolean exists( String codigo )
        {
                J34SiscomexTipoRecipiente j34SiscomexTipoRecipiente = newInstanceWithPrimaryKey( codigo ) ;
                return super.doExists(j34SiscomexTipoRecipiente);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexTipoRecipiente
         * @return
         */
        @Override
        public boolean exists( J34SiscomexTipoRecipiente j34SiscomexTipoRecipiente )
        {
                return super.doExists(j34SiscomexTipoRecipiente);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexTipoRecipiente j34SiscomexTipoRecipiente) throws SQLException
        {
                
                setRawParameter(list,j34SiscomexTipoRecipiente.getCodigo() ) ; // "codigo" : java.lang.Integer
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexTipoRecipiente populateBean(Cursor c, J34SiscomexTipoRecipiente j34SiscomexTipoRecipiente) throws SQLException
        {
                j34SiscomexTipoRecipiente.setCodigo(c.getString(c.getColumnIndex("codigo"))); // java.lang.Integer
                j34SiscomexTipoRecipiente.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexTipoRecipiente ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexTipoRecipiente j34SiscomexTipoRecipiente) throws SQLException
        {

                
                setValue(ps, i++, j34SiscomexTipoRecipiente.getCodigo() ) ; // "codigo" : java.lang.Integer
                setValue(ps, i++, j34SiscomexTipoRecipiente.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexTipoRecipiente j34SiscomexTipoRecipiente) throws SQLException
        {
                setValue(ps, i++, j34SiscomexTipoRecipiente.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexTipoRecipiente.getCodigo() ) ; // "codigo" : java.lang.Integer
        }

}
