package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.MotivoRetificacaoDAO;
import br.com.bandoni.dao.tables.J34SiscomexMotivoRetificacao;

/**
 * J34SiscomexMotivoRetificacao: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class MotivoRetificacaoDAOImpl extends GenericDAO<J34SiscomexMotivoRetificacao> implements MotivoRetificacaoDAO {

        private final static String SQL_SELECT = 
                "select codigo_motivo, descricao_motivo from j34_siscomex_motivo_retificacao where codigo_motivo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_motivo_retificacao ( codigo_motivo, descricao_motivo ) values ( ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_motivo_retificacao set descricao_motivo = ? where codigo_motivo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_motivo_retificacao where codigo_motivo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_motivo_retificacao";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_motivo_retificacao where codigo_motivo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public MotivoRetificacaoDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo_motivo;
         * @return A nova inst�ncia
         */
        private J34SiscomexMotivoRetificacao newInstanceWithPrimaryKey( Integer codigo_motivo )
        {
                J34SiscomexMotivoRetificacao j34SiscomexMotivoRetificacao = new J34SiscomexMotivoRetificacao();
                j34SiscomexMotivoRetificacao.setCodigo_motivo( codigo_motivo );
                return j34SiscomexMotivoRetificacao ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo_motivo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexMotivoRetificacao find( Integer codigo_motivo  )
        {
                J34SiscomexMotivoRetificacao j34SiscomexMotivoRetificacao = newInstanceWithPrimaryKey( codigo_motivo ) ;
                if ( super.doSelect(j34SiscomexMotivoRetificacao) )
                {
                        return j34SiscomexMotivoRetificacao ;
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
         * @param j34SiscomexMotivoRetificacao
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexMotivoRetificacao j34SiscomexMotivoRetificacao )
        {
                return super.doSelect(j34SiscomexMotivoRetificacao) ;
        }

    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexMotivoRetificacao
         */
        @Override
        public void insert(J34SiscomexMotivoRetificacao j34SiscomexMotivoRetificacao)
        {
                super.doInsert(j34SiscomexMotivoRetificacao);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexMotivoRetificacao
         * @return
         */
        @Override
        public int update(J34SiscomexMotivoRetificacao j34SiscomexMotivoRetificacao)
        {
                return super.doUpdate(j34SiscomexMotivoRetificacao);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo_motivo;
         * @return
         */
        @Override
        public int delete( Integer codigo_motivo )
        {
                J34SiscomexMotivoRetificacao j34SiscomexMotivoRetificacao = newInstanceWithPrimaryKey( codigo_motivo ) ;
                return super.doDelete(j34SiscomexMotivoRetificacao);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexMotivoRetificacao
         * @return
         */
        @Override
        public int delete( J34SiscomexMotivoRetificacao j34SiscomexMotivoRetificacao )
        {
                return super.doDelete(j34SiscomexMotivoRetificacao);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo_motivo;
         * @return
         */
        @Override
        public boolean exists( Integer codigo_motivo )
        {
                J34SiscomexMotivoRetificacao j34SiscomexMotivoRetificacao = newInstanceWithPrimaryKey( codigo_motivo ) ;
                return super.doExists(j34SiscomexMotivoRetificacao);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexMotivoRetificacao
         * @return
         */
        @Override
        public boolean exists( J34SiscomexMotivoRetificacao j34SiscomexMotivoRetificacao )
        {
                return super.doExists(j34SiscomexMotivoRetificacao);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexMotivoRetificacao j34SiscomexMotivoRetificacao) throws SQLException {
                
                setRawParameter(list,  j34SiscomexMotivoRetificacao.getCodigo_motivo()) ; // "codigo_motivo" : java.lang.int
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexMotivoRetificacao populateBean(Cursor c, J34SiscomexMotivoRetificacao j34SiscomexMotivoRetificacao) throws SQLException {

               
                j34SiscomexMotivoRetificacao.setCodigo_motivo(c.getInt(c.getColumnIndex("codigo_motivo"))); // java.lang.int
                j34SiscomexMotivoRetificacao.setDescricao_motivo(c.getString(c.getColumnIndex("descricao_motivo"))); // java.lang.String
                return j34SiscomexMotivoRetificacao ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexMotivoRetificacao j34SiscomexMotivoRetificacao) throws SQLException {

                
                setValue(ps, i++, j34SiscomexMotivoRetificacao.getCodigo_motivo() ) ; // "codigo_motivo" : java.lang.int
                setValue(ps, i++, j34SiscomexMotivoRetificacao.getDescricao_motivo() ) ; // "descricao_motivo" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexMotivoRetificacao j34SiscomexMotivoRetificacao) throws SQLException {

                
                setValue(ps, i++, j34SiscomexMotivoRetificacao.getDescricao_motivo() ) ; // "descricao_motivo" : java.lang.String
                
                setValue(ps, i++, j34SiscomexMotivoRetificacao.getCodigo_motivo() ) ; // "codigo_motivo" : java.lang.int
        }

}
