package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.MoedasDAO;
import br.com.bandoni.dao.tables.J34SiscomexMoedas;

/**
 * J34SiscomexMoedas: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class MoedasDAOImpl extends GenericDAO<J34SiscomexMoedas> implements MoedasDAO {

        private final static String SQL_SELECT = 
                "select idmoeda, codigo, nome, simbolo, pais, tipo, dataexclusao from j34_siscomex_moedas where idmoeda = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_moedas ( codigo, nome, simbolo, pais, tipo, dataexclusao ) values ( ?, ?, ?, ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_moedas set codigo = ?, nome = ?, simbolo = ?, pais = ?, tipo = ?, dataexclusao = ? where idmoeda = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_moedas where idmoeda = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_moedas";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_moedas where idmoeda = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public MoedasDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param idmoeda;
         * @return A nova inst�ncia
         */
        private J34SiscomexMoedas newInstanceWithPrimaryKey( Integer idmoeda ) {
                J34SiscomexMoedas j34SiscomexMoedas = new J34SiscomexMoedas();
                j34SiscomexMoedas.setIdmoeda( idmoeda );
                return j34SiscomexMoedas ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param idmoeda;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexMoedas find( Integer idmoeda ) {
                J34SiscomexMoedas j34SiscomexMoedas = newInstanceWithPrimaryKey( idmoeda ) ;
                if ( super.doSelect(j34SiscomexMoedas) ) {
                        return j34SiscomexMoedas ;
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
         * @param j34SiscomexMoedas
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexMoedas j34SiscomexMoedas ) {
                return super.doSelect(j34SiscomexMoedas) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexMoedas
         */
        @Override
        public Integer insert(J34SiscomexMoedas j34SiscomexMoedas) {
                Long key = super.doInsertAutoIncr(j34SiscomexMoedas);
                return key.intValue();
        }

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexMoedas
         * @return
         */
        @Override
        public int update(J34SiscomexMoedas j34SiscomexMoedas) {
                return super.doUpdate(j34SiscomexMoedas);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param idmoeda;
         * @return
         */
        @Override
        public int delete( Integer idmoeda ) {
                J34SiscomexMoedas j34SiscomexMoedas = newInstanceWithPrimaryKey( idmoeda ) ;
                return super.doDelete(j34SiscomexMoedas);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexMoedas
         * @return
         */
        @Override
        public int delete( J34SiscomexMoedas j34SiscomexMoedas ) {
                return super.doDelete(j34SiscomexMoedas);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param idmoeda;
         * @return
         */
        @Override
        public boolean exists( Integer idmoeda ) {
                J34SiscomexMoedas j34SiscomexMoedas = newInstanceWithPrimaryKey( idmoeda ) ;
                return super.doExists(j34SiscomexMoedas);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexMoedas
         * @return
         */
        @Override
        public boolean exists( J34SiscomexMoedas j34SiscomexMoedas ) {
                return super.doExists(j34SiscomexMoedas);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexMoedas j34SiscomexMoedas) throws SQLException {
                
                setRawParameter(list,  j34SiscomexMoedas.getIdmoeda() ) ; // "idmoeda" : java.lang.Integer
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexMoedas populateBean(Cursor c, J34SiscomexMoedas j34SiscomexMoedas) throws SQLException {

               
                j34SiscomexMoedas.setIdmoeda(c.getInt(c.getColumnIndex("idmoeda"))); // java.lang.Integer
                j34SiscomexMoedas.setCodigo(c.getInt(c.getColumnIndex("codigo"))); // java.lang.Integer
                j34SiscomexMoedas.setNome(c.getString(c.getColumnIndex("nome"))); // java.lang.String
                j34SiscomexMoedas.setSimbolo(c.getString(c.getColumnIndex("simbolo"))); // java.lang.String
                j34SiscomexMoedas.setPais(c.getString(c.getColumnIndex("pais"))); // java.lang.String
                j34SiscomexMoedas.setTipo(c.getString(c.getColumnIndex("tipo"))); // java.lang.String
                j34SiscomexMoedas.setDataexclusao(new Date(c.getLong(c.getColumnIndex("dataexclusao")))); // java.util.Date
                return j34SiscomexMoedas ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexMoedas j34SiscomexMoedas) throws SQLException {

                
                // "idmoeda" is auto-incremented => no set in insert            
                setValue(ps, i++, j34SiscomexMoedas.getCodigo() ) ; // "codigo" : java.lang.Integer
                setValue(ps, i++, j34SiscomexMoedas.getNome() ) ; // "nome" : java.lang.String
                setValue(ps, i++, j34SiscomexMoedas.getSimbolo() ) ; // "simbolo" : java.lang.String
                setValue(ps, i++, j34SiscomexMoedas.getPais() ) ; // "pais" : java.lang.String
                setValue(ps, i++, j34SiscomexMoedas.getTipo() ) ; // "tipo" : java.lang.String
                setValue(ps, i++, j34SiscomexMoedas.getDataexclusao() ) ; // "dataexclusao" : java.util.Date
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexMoedas j34SiscomexMoedas) throws SQLException {

                
                setValue(ps, i++, j34SiscomexMoedas.getCodigo() ) ; // "codigo" : java.lang.Integer
                setValue(ps, i++, j34SiscomexMoedas.getNome() ) ; // "nome" : java.lang.String
                setValue(ps, i++, j34SiscomexMoedas.getSimbolo() ) ; // "simbolo" : java.lang.String
                setValue(ps, i++, j34SiscomexMoedas.getPais() ) ; // "pais" : java.lang.String
                setValue(ps, i++, j34SiscomexMoedas.getTipo() ) ; // "tipo" : java.lang.String
                setValue(ps, i++, j34SiscomexMoedas.getDataexclusao() ) ; // "dataexclusao" : java.util.Date
                
                setValue(ps, i++, j34SiscomexMoedas.getIdmoeda() ) ; // "idmoeda" : java.lang.Integer
        }

}
