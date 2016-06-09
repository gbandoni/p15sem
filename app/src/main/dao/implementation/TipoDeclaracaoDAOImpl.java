package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.TipoDeclaracaoDAO;
import br.com.bandoni.dao.tables.J34SiscomexTipoDeclaracao;

/**
 * J34SiscomexTipoDeclaracao: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class TipoDeclaracaoDAOImpl extends GenericDAO<J34SiscomexTipoDeclaracao> implements TipoDeclaracaoDAO {

        private final static String SQL_SELECT = 
                "select codigo_tipo, tipo_declaracao, descricao_tipo from j34_siscomex_tipo_declaracao where codigo_tipo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_tipo_declaracao ( codigo_tipo, tipo_declaracao, descricao_tipo ) values ( ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_tipo_declaracao set tipo_declaracao = ?, descricao_tipo = ? where codigo_tipo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_tipo_declaracao where codigo_tipo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_tipo_declaracao";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_tipo_declaracao where codigo_tipo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public TipoDeclaracaoDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo_tipo;
         * @return A nova inst�ncia
         */
        private J34SiscomexTipoDeclaracao newInstanceWithPrimaryKey( Integer codigo_tipo ) {
                J34SiscomexTipoDeclaracao j34SiscomexTipoDeclaracao = new J34SiscomexTipoDeclaracao();
                j34SiscomexTipoDeclaracao.setCodigo_tipo( codigo_tipo );
                return j34SiscomexTipoDeclaracao ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo_tipo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexTipoDeclaracao find( Integer codigo_tipo ) {
                J34SiscomexTipoDeclaracao j34SiscomexTipoDeclaracao = newInstanceWithPrimaryKey( codigo_tipo ) ;
                if ( super.doSelect(j34SiscomexTipoDeclaracao) ) {
                        return j34SiscomexTipoDeclaracao ;
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
         * @param j34SiscomexTipoDeclaracao
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexTipoDeclaracao j34SiscomexTipoDeclaracao ) {
                return super.doSelect(j34SiscomexTipoDeclaracao) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexTipoDeclaracao
         */
        @Override
        public void insert(J34SiscomexTipoDeclaracao j34SiscomexTipoDeclaracao) {
                super.doInsert(j34SiscomexTipoDeclaracao);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexTipoDeclaracao
         * @return
         */
        @Override
        public int update(J34SiscomexTipoDeclaracao j34SiscomexTipoDeclaracao) {
                return super.doUpdate(j34SiscomexTipoDeclaracao);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo_tipo;
         * @return
         */
        @Override
        public int delete( Integer codigo_tipo ) {
                J34SiscomexTipoDeclaracao j34SiscomexTipoDeclaracao = newInstanceWithPrimaryKey( codigo_tipo ) ;
                return super.doDelete(j34SiscomexTipoDeclaracao);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexTipoDeclaracao
         * @return
         */
        @Override
        public int delete( J34SiscomexTipoDeclaracao j34SiscomexTipoDeclaracao ) {
                return super.doDelete(j34SiscomexTipoDeclaracao);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo_tipo;
         * @return
         */
        @Override
        public boolean exists( Integer codigo_tipo ) {
                J34SiscomexTipoDeclaracao j34SiscomexTipoDeclaracao = newInstanceWithPrimaryKey( codigo_tipo ) ;
                return super.doExists(j34SiscomexTipoDeclaracao);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexTipoDeclaracao
         * @return
         */
        @Override
        public boolean exists( J34SiscomexTipoDeclaracao j34SiscomexTipoDeclaracao ) {
                return super.doExists(j34SiscomexTipoDeclaracao);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexTipoDeclaracao j34SiscomexTipoDeclaracao) throws SQLException {
                
                setRawParameter(list,j34SiscomexTipoDeclaracao.getCodigo_tipo()) ; // "codigo_tipo" : java.lang.Integer
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexTipoDeclaracao populateBean(Cursor c, J34SiscomexTipoDeclaracao j34SiscomexTipoDeclaracao) throws SQLException {

               
                j34SiscomexTipoDeclaracao.setCodigo_tipo(c.getInt(c.getColumnIndex("codigo_tipo"))); // java.lang.Integer
                j34SiscomexTipoDeclaracao.setTipo_declaracao(c.getString(c.getColumnIndex("tipo_declaracao"))); // java.lang.String
                j34SiscomexTipoDeclaracao.setDescricao_tipo(c.getString(c.getColumnIndex("descricao_tipo"))); // java.lang.String
                return j34SiscomexTipoDeclaracao ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexTipoDeclaracao j34SiscomexTipoDeclaracao) throws SQLException {

                
                setValue(ps, i++, j34SiscomexTipoDeclaracao.getCodigo_tipo() ) ; // "codigo_tipo" : java.lang.Integer
                setValue(ps, i++, j34SiscomexTipoDeclaracao.getTipo_declaracao() ) ; // "tipo_declaracao" : java.lang.String
                setValue(ps, i++, j34SiscomexTipoDeclaracao.getDescricao_tipo() ) ; // "descricao_tipo" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexTipoDeclaracao j34SiscomexTipoDeclaracao) throws SQLException {

                
                setValue(ps, i++, j34SiscomexTipoDeclaracao.getTipo_declaracao() ) ; // "tipo_declaracao" : java.lang.String
                setValue(ps, i++, j34SiscomexTipoDeclaracao.getDescricao_tipo() ) ; // "descricao_tipo" : java.lang.String
                
                setValue(ps, i++, j34SiscomexTipoDeclaracao.getCodigo_tipo() ) ; // "codigo_tipo" : java.lang.Integer
        }

}
