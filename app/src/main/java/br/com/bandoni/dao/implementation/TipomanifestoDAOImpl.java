package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.TipomanifestoDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexTipomanifesto;

/**
 * J34SiscomexTipomanifesto: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class TipomanifestoDAOImpl extends GenericDAO<J34SiscomexTipomanifesto> implements TipomanifestoDAO {

        private final static String SQL_SELECT = 
                "select codigo, descricao from j34_siscomex_tipomanifesto where codigo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_tipomanifesto ( codigo, descricao ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_tipomanifesto set descricao = ? where codigo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_tipomanifesto where codigo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_tipomanifesto";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_tipomanifesto where codigo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public TipomanifestoDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @return A nova inst�ncia
         */
        private J34SiscomexTipomanifesto newInstanceWithPrimaryKey( Integer codigo ) {
                J34SiscomexTipomanifesto j34SiscomexTipomanifesto = new J34SiscomexTipomanifesto();
                j34SiscomexTipomanifesto.setCodigo( codigo );
                return j34SiscomexTipomanifesto ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexTipomanifesto find( Integer codigo ) {
                J34SiscomexTipomanifesto j34SiscomexTipomanifesto = newInstanceWithPrimaryKey( codigo ) ;
                if ( super.doSelect(j34SiscomexTipomanifesto) ) {
                        return j34SiscomexTipomanifesto ;
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
         * @param j34SiscomexTipomanifesto
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexTipomanifesto j34SiscomexTipomanifesto ) {
                return super.doSelect(j34SiscomexTipomanifesto) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexTipomanifesto
         */
        @Override
        public void insert(J34SiscomexTipomanifesto j34SiscomexTipomanifesto) {
                super.doInsert(j34SiscomexTipomanifesto);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexTipomanifesto
         * @return
         */
        @Override
        public int update(J34SiscomexTipomanifesto j34SiscomexTipomanifesto) {
                return super.doUpdate(j34SiscomexTipomanifesto);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @return
         */
        @Override
        public int delete( Integer codigo ) {
                J34SiscomexTipomanifesto j34SiscomexTipomanifesto = newInstanceWithPrimaryKey( codigo ) ;
                return super.doDelete(j34SiscomexTipomanifesto);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexTipomanifesto
         * @return
         */
        @Override
        public int delete( J34SiscomexTipomanifesto j34SiscomexTipomanifesto ) {
                return super.doDelete(j34SiscomexTipomanifesto);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @return
         */
        @Override
        public boolean exists( Integer codigo ) {
                J34SiscomexTipomanifesto j34SiscomexTipomanifesto = newInstanceWithPrimaryKey( codigo ) ;
                return super.doExists(j34SiscomexTipomanifesto);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexTipomanifesto
         * @return
         */
        @Override
        public boolean exists( J34SiscomexTipomanifesto j34SiscomexTipomanifesto ) {
                return super.doExists(j34SiscomexTipomanifesto);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexTipomanifesto j34SiscomexTipomanifesto) throws SQLException {
                
                setRawParameter(list,j34SiscomexTipomanifesto.getCodigo() ) ; // "codigo" : java.lang.Integer
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexTipomanifesto populateBean(Cursor c, J34SiscomexTipomanifesto j34SiscomexTipomanifesto) throws SQLException {

               
                j34SiscomexTipomanifesto.setCodigo(c.getInt(c.getColumnIndex("codigo"))); // java.lang.Integer
                j34SiscomexTipomanifesto.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexTipomanifesto ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexTipomanifesto j34SiscomexTipomanifesto) throws SQLException {

                
                setValue(ps, i++, j34SiscomexTipomanifesto.getCodigo() ) ; // "codigo" : java.lang.Integer
                setValue(ps, i++, j34SiscomexTipomanifesto.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexTipomanifesto j34SiscomexTipomanifesto) throws SQLException {

                
                setValue(ps, i++, j34SiscomexTipomanifesto.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexTipomanifesto.getCodigo() ) ; // "codigo" : java.lang.Integer
        }

}
