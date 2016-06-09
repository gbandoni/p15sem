package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.VeiculosDAO;
import br.com.bandoni.dao.tables.J34SiscomexVeiculos;

/**
 * J34SiscomexVeiculos: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class VeiculosDAOImpl extends GenericDAO<J34SiscomexVeiculos> implements VeiculosDAO {

        private final static String SQL_SELECT = 
                "select id, codtransportador, numeroveiculo, nomeveiculo from j34_siscomex_veiculos where id = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_veiculos ( id, codtransportador, numeroveiculo, nomeveiculo ) values ( ?, ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_veiculos set codtransportador = ?, numeroveiculo = ?, nomeveiculo = ? where id = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_veiculos where id = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_veiculos";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_veiculos where id = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public VeiculosDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param id;
         * @return A nova inst�ncia
         */
        private J34SiscomexVeiculos newInstanceWithPrimaryKey( Integer id ) {
                J34SiscomexVeiculos j34SiscomexVeiculos = new J34SiscomexVeiculos();
                j34SiscomexVeiculos.setId( id );
                return j34SiscomexVeiculos ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param id;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexVeiculos find( Integer id ) {
                J34SiscomexVeiculos j34SiscomexVeiculos = newInstanceWithPrimaryKey( id ) ;
                if ( super.doSelect(j34SiscomexVeiculos) ) {
                        return j34SiscomexVeiculos ;
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
         * @param j34SiscomexVeiculos
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexVeiculos j34SiscomexVeiculos ) {
                return super.doSelect(j34SiscomexVeiculos) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexVeiculos
         */
        @Override
        public void insert(J34SiscomexVeiculos j34SiscomexVeiculos) {
                super.doInsert(j34SiscomexVeiculos);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexVeiculos
         * @return
         */
        @Override
        public int update(J34SiscomexVeiculos j34SiscomexVeiculos) {
                return super.doUpdate(j34SiscomexVeiculos);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param id;
         * @return
         */
        @Override
        public int delete( Integer id ) {
                J34SiscomexVeiculos j34SiscomexVeiculos = newInstanceWithPrimaryKey( id ) ;
                return super.doDelete(j34SiscomexVeiculos);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexVeiculos
         * @return
         */
        @Override
        public int delete( J34SiscomexVeiculos j34SiscomexVeiculos ) {
                return super.doDelete(j34SiscomexVeiculos);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param id;
         * @return
         */
        @Override
        public boolean exists( Integer id ) {
                J34SiscomexVeiculos j34SiscomexVeiculos = newInstanceWithPrimaryKey( id ) ;
                return super.doExists(j34SiscomexVeiculos);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexVeiculos
         * @return
         */
        @Override
        public boolean exists( J34SiscomexVeiculos j34SiscomexVeiculos ) {
                return super.doExists(j34SiscomexVeiculos);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexVeiculos j34SiscomexVeiculos) throws SQLException {
                
                setRawParameter(list, j34SiscomexVeiculos.getId() ) ; // "id" : java.lang.Integer
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexVeiculos populateBean(Cursor c, J34SiscomexVeiculos j34SiscomexVeiculos) throws SQLException {

               
                j34SiscomexVeiculos.setId(c.getInt(c.getColumnIndex("id"))); // java.lang.Integer
                j34SiscomexVeiculos.setCodtransportador(c.getInt(c.getColumnIndex("codtransportador"))); // java.lang.Integer
                j34SiscomexVeiculos.setNumeroveiculo(c.getString(c.getColumnIndex("numeroveiculo"))); // java.lang.String
                j34SiscomexVeiculos.setNomeveiculo(c.getString(c.getColumnIndex("nomeveiculo"))); // java.lang.String
                return j34SiscomexVeiculos ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexVeiculos j34SiscomexVeiculos) throws SQLException {

                
                setValue(ps, i++, j34SiscomexVeiculos.getId() ) ; // "id" : java.lang.Integer
                setValue(ps, i++, j34SiscomexVeiculos.getCodtransportador() ) ; // "codtransportador" : java.lang.Integer
                setValue(ps, i++, j34SiscomexVeiculos.getNumeroveiculo() ) ; // "numeroveiculo" : java.lang.String
                setValue(ps, i++, j34SiscomexVeiculos.getNomeveiculo() ) ; // "nomeveiculo" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexVeiculos j34SiscomexVeiculos) throws SQLException {

                
                setValue(ps, i++, j34SiscomexVeiculos.getCodtransportador() ) ; // "codtransportador" : java.lang.Integer
                setValue(ps, i++, j34SiscomexVeiculos.getNumeroveiculo() ) ; // "numeroveiculo" : java.lang.String
                setValue(ps, i++, j34SiscomexVeiculos.getNomeveiculo() ) ; // "nomeveiculo" : java.lang.String
                
                setValue(ps, i++, j34SiscomexVeiculos.getId() ) ; // "id" : java.lang.Integer
        }

}
