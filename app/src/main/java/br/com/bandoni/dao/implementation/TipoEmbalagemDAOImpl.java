package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.TipoEmbalagemDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexTipoEmbalagem;

/**
 * J34SiscomexTipoEmbalagem: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class TipoEmbalagemDAOImpl extends GenericDAO<J34SiscomexTipoEmbalagem> implements TipoEmbalagemDAO {

        private final static String SQL_SELECT = 
                "select codigo, descricao from j34_siscomex_tipo_embalagem where codigo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_tipo_embalagem ( codigo, descricao ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_tipo_embalagem set descricao = ? where codigo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_tipo_embalagem where codigo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_tipo_embalagem";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_tipo_embalagem where codigo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public TipoEmbalagemDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @return A nova inst�ncia
         */
        private J34SiscomexTipoEmbalagem newInstanceWithPrimaryKey( Integer codigo ) {
                J34SiscomexTipoEmbalagem j34SiscomexTipoEmbalagem = new J34SiscomexTipoEmbalagem();
                j34SiscomexTipoEmbalagem.setCodigo( codigo );
                return j34SiscomexTipoEmbalagem ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexTipoEmbalagem find( Integer codigo ) {
                J34SiscomexTipoEmbalagem j34SiscomexTipoEmbalagem = newInstanceWithPrimaryKey( codigo ) ;
                if ( super.doSelect(j34SiscomexTipoEmbalagem) ) {
                        return j34SiscomexTipoEmbalagem ;
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
         * @param j34SiscomexTipoEmbalagem
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexTipoEmbalagem j34SiscomexTipoEmbalagem ) {
                return super.doSelect(j34SiscomexTipoEmbalagem) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexTipoEmbalagem
         */
        @Override
        public void insert(J34SiscomexTipoEmbalagem j34SiscomexTipoEmbalagem) {
                super.doInsert(j34SiscomexTipoEmbalagem);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexTipoEmbalagem
         * @return
         */
        @Override
        public int update(J34SiscomexTipoEmbalagem j34SiscomexTipoEmbalagem) {
                return super.doUpdate(j34SiscomexTipoEmbalagem);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @return
         */
        @Override
        public int delete( Integer codigo ) {
                J34SiscomexTipoEmbalagem j34SiscomexTipoEmbalagem = newInstanceWithPrimaryKey( codigo ) ;
                return super.doDelete(j34SiscomexTipoEmbalagem);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexTipoEmbalagem
         * @return
         */
        @Override
        public int delete( J34SiscomexTipoEmbalagem j34SiscomexTipoEmbalagem ) {
                return super.doDelete(j34SiscomexTipoEmbalagem);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @return
         */
        @Override
        public boolean exists( Integer codigo ) {
                J34SiscomexTipoEmbalagem j34SiscomexTipoEmbalagem = newInstanceWithPrimaryKey( codigo ) ;
                return super.doExists(j34SiscomexTipoEmbalagem);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexTipoEmbalagem
         * @return
         */
        @Override
        public boolean exists( J34SiscomexTipoEmbalagem j34SiscomexTipoEmbalagem ) {
                return super.doExists(j34SiscomexTipoEmbalagem);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexTipoEmbalagem j34SiscomexTipoEmbalagem) throws SQLException {
                
                setRawParameter(list,j34SiscomexTipoEmbalagem.getCodigo() ) ; // "codigo" : java.lang.Integer
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexTipoEmbalagem populateBean(Cursor c, J34SiscomexTipoEmbalagem j34SiscomexTipoEmbalagem) throws SQLException {

               
                j34SiscomexTipoEmbalagem.setCodigo(c.getInt(c.getColumnIndex("codigo"))); // java.lang.Integer
                j34SiscomexTipoEmbalagem.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexTipoEmbalagem ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexTipoEmbalagem j34SiscomexTipoEmbalagem) throws SQLException {

                
                setValue(ps, i++, j34SiscomexTipoEmbalagem.getCodigo() ) ; // "codigo" : java.lang.Integer
                setValue(ps, i++, j34SiscomexTipoEmbalagem.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexTipoEmbalagem j34SiscomexTipoEmbalagem) throws SQLException {

                
                setValue(ps, i++, j34SiscomexTipoEmbalagem.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexTipoEmbalagem.getCodigo() ) ; // "codigo" : java.lang.Integer
        }

}
