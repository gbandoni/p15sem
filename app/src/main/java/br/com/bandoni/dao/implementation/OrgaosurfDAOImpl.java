package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.OrgaosurfDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexOrgaosurf;

/**
 * J34SiscomexOrgaosurf: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class OrgaosurfDAOImpl extends GenericDAO<J34SiscomexOrgaosurf> implements OrgaosurfDAO
{

        private final static String SQL_SELECT = 
                "select codigo, descricao from j34_siscomex_orgaosurf where ";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_orgaosurf ( codigo, descricao ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_orgaosurf set codigo = ?, descricao = ? where ";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_orgaosurf where ";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_orgaosurf";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_orgaosurf where ";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public OrgaosurfDAOImpl(Context context)
        {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @return A nova inst�ncia
         */
        private J34SiscomexOrgaosurf newInstanceWithPrimaryKey(String codigo)
        {
           J34SiscomexOrgaosurf j34SiscomexOrgaosurf = new J34SiscomexOrgaosurf();
            j34SiscomexOrgaosurf.setCodigo(codigo);
                return j34SiscomexOrgaosurf ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexOrgaosurf find( String codigo )
        {
                J34SiscomexOrgaosurf j34SiscomexOrgaosurf = newInstanceWithPrimaryKey( codigo  ) ;
                if ( super.doSelect(j34SiscomexOrgaosurf) )
                {
                        return j34SiscomexOrgaosurf ;
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
         * @param j34SiscomexOrgaosurf
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexOrgaosurf j34SiscomexOrgaosurf )
        {
                return super.doSelect(j34SiscomexOrgaosurf) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexOrgaosurf
         */
        @Override
        public void insert(J34SiscomexOrgaosurf j34SiscomexOrgaosurf)
        {
                super.doInsert(j34SiscomexOrgaosurf);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexOrgaosurf
         * @return
         */
        @Override
        public int update(J34SiscomexOrgaosurf j34SiscomexOrgaosurf)
        {
                return super.doUpdate(j34SiscomexOrgaosurf);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @return
         */
        @Override
        public int delete(String codigo )
        {
                J34SiscomexOrgaosurf j34SiscomexOrgaosurf = newInstanceWithPrimaryKey(codigo) ;
                return super.doDelete(j34SiscomexOrgaosurf);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexOrgaosurf
         * @return
         */
        @Override
        public int delete( J34SiscomexOrgaosurf j34SiscomexOrgaosurf )
        {
                return super.doDelete(j34SiscomexOrgaosurf);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @return
         */
        @Override
        public boolean exists(String codigo)
        {
                J34SiscomexOrgaosurf j34SiscomexOrgaosurf = newInstanceWithPrimaryKey(codigo ) ;
                return super.doExists(j34SiscomexOrgaosurf);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexOrgaosurf
         * @return
         */
        @Override
        public boolean exists( J34SiscomexOrgaosurf j34SiscomexOrgaosurf )
        {
                return super.doExists(j34SiscomexOrgaosurf);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexOrgaosurf j34SiscomexOrgaosurf) throws SQLException 
		{
            setRawParameter(list,j34SiscomexOrgaosurf.getCodigo() ) ; // "codigo" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexOrgaosurf populateBean(Cursor c, J34SiscomexOrgaosurf j34SiscomexOrgaosurf) throws SQLException {

               
                j34SiscomexOrgaosurf.setCodigo(c.getString(c.getColumnIndex("codigo"))); // java.lang.String
                j34SiscomexOrgaosurf.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexOrgaosurf ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexOrgaosurf j34SiscomexOrgaosurf) throws SQLException {

                
                setValue(ps, i++, j34SiscomexOrgaosurf.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexOrgaosurf.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexOrgaosurf j34SiscomexOrgaosurf) throws SQLException {

                
                setValue(ps, i++, j34SiscomexOrgaosurf.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexOrgaosurf.getDescricao() ) ; // "descricao" : java.lang.String
                
        }

}
