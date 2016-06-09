package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.EspecNcmDAO;
import br.com.bandoni.dao.tables.J34SiscomexEspecNcm;

/**
 * J34SiscomexEspecNcm: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class EspecNcmDAOImpl extends GenericDAO<J34SiscomexEspecNcm> implements EspecNcmDAO {

        private final static String SQL_SELECT = 
                "select ncm, atributo, especificacao, nivel, descricao from j34_siscomex_espec_ncm where id = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_espec_ncm ( ncm, atributo, especificacao, nivel, descricao ) values ( ?, ?, ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_espec_ncm set nivel = ?, descricao = ? , ncm = ? and atributo = ? and especificacao = ? Where id = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_espec_ncm where id = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_espec_ncm";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_espec_ncm where id = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public EspecNcmDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param id
         * @return A nova inst�ncia
         */
        private J34SiscomexEspecNcm newInstanceWithPrimaryKey(Integer id ) {
                J34SiscomexEspecNcm j34SiscomexEspecNcm = new J34SiscomexEspecNcm();
                j34SiscomexEspecNcm.setId(id);
                return j34SiscomexEspecNcm ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param id
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexEspecNcm find(Integer id)
        {
                J34SiscomexEspecNcm j34SiscomexEspecNcm = newInstanceWithPrimaryKey(id) ;
                if ( super.doSelect(j34SiscomexEspecNcm) ) {
                        return j34SiscomexEspecNcm ;
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
         * @param j34SiscomexEspecNcm
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexEspecNcm j34SiscomexEspecNcm )
        {
                return super.doSelect(j34SiscomexEspecNcm) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexEspecNcm
         */
        @Override
        public void insert(J34SiscomexEspecNcm j34SiscomexEspecNcm)
        {
                super.doInsert(j34SiscomexEspecNcm);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexEspecNcm
         * @return
         */
        @Override
        public int update(J34SiscomexEspecNcm j34SiscomexEspecNcm)
        {
                return super.doUpdate(j34SiscomexEspecNcm);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param id
         * @return
         */
        @Override
        public int delete( Integer id )
        {
                J34SiscomexEspecNcm j34SiscomexEspecNcm = newInstanceWithPrimaryKey(id) ;
                return super.doDelete(j34SiscomexEspecNcm);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexEspecNcm
         * @return
         */
        @Override
        public int delete( J34SiscomexEspecNcm j34SiscomexEspecNcm )
        {
                return super.doDelete(j34SiscomexEspecNcm);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param id
         * @return
         */
        @Override
        public boolean exists( Integer id )
        {
                J34SiscomexEspecNcm j34SiscomexEspecNcm = newInstanceWithPrimaryKey(id) ;
                return super.doExists(j34SiscomexEspecNcm);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexEspecNcm
         * @return
         */
        @Override
        public boolean exists( J34SiscomexEspecNcm j34SiscomexEspecNcm )
        {
                return super.doExists(j34SiscomexEspecNcm);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexEspecNcm j34SiscomexEspecNcm) throws SQLException
        {
                
                setRawParameter(list,j34SiscomexEspecNcm.getId() ) ; // "ncm" : java.lang.Integer
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexEspecNcm populateBean(Cursor c, J34SiscomexEspecNcm j34SiscomexEspecNcm) throws SQLException
        {
                j34SiscomexEspecNcm.setId(c.getInt(c.getColumnIndex("id"))); // java.lang.Integer
                j34SiscomexEspecNcm.setNcm(c.getString(c.getColumnIndex("ncm"))); // java.lang.String
                j34SiscomexEspecNcm.setAtributo(c.getString(c.getColumnIndex("atributo"))); // java.lang.String
                j34SiscomexEspecNcm.setEspecificacao(c.getString(c.getColumnIndex("especificacao"))); // java.lang.String
                j34SiscomexEspecNcm.setNivel(c.getString(c.getColumnIndex("nivel"))); // java.lang.String
                j34SiscomexEspecNcm.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexEspecNcm ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexEspecNcm j34SiscomexEspecNcm) throws SQLException {

                
                setValue(ps, i++, j34SiscomexEspecNcm.getNcm() ) ; // "ncm" : java.lang.String
                setValue(ps, i++, j34SiscomexEspecNcm.getAtributo() ) ; // "atributo" : java.lang.String
                setValue(ps, i++, j34SiscomexEspecNcm.getEspecificacao() ) ; // "especificacao" : java.lang.String
                setValue(ps, i++, j34SiscomexEspecNcm.getNivel() ) ; // "nivel" : java.lang.String
                setValue(ps, i++, j34SiscomexEspecNcm.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexEspecNcm j34SiscomexEspecNcm) throws SQLException {

                
                setValue(ps, i++, j34SiscomexEspecNcm.getNivel() ) ; // "nivel" : java.lang.String
                setValue(ps, i++, j34SiscomexEspecNcm.getDescricao() ) ; // "descricao" : java.lang.String
                setValue(ps, i++, j34SiscomexEspecNcm.getNcm() ) ; // "ncm" : java.lang.String
                setValue(ps, i++, j34SiscomexEspecNcm.getAtributo() ) ; // "atributo" : java.lang.String
                setValue(ps, i++, j34SiscomexEspecNcm.getEspecificacao() ) ; // "especificacao" : java.lang.String

                setValue(ps, i++, j34SiscomexEspecNcm.getId() ) ; // "Id" : java.lang.Integer
        }

}
