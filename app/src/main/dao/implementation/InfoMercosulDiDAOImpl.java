package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.InfoMercosulDiDAO;
import br.com.bandoni.dao.tables.J34SiscomexInfoMercosulDi;

/**
 * J34SiscomexInfoMercosulDi: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class InfoMercosulDiDAOImpl extends GenericDAO<J34SiscomexInfoMercosulDi> implements InfoMercosulDiDAO {

        private final static String SQL_SELECT = 
                "select numerodocumentocarga, ordem, numerodemercosul, numerorefinal, numeroreinicial from j34_siscomex_info_mercosul_di where numerodocumentocarga = ? and ordem = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_info_mercosul_di ( numerodocumentocarga, ordem, numerodemercosul, numerorefinal, numeroreinicial ) values ( ?, ?, ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_info_mercosul_di set numerodemercosul = ?, numerorefinal = ?, numeroreinicial = ? where numerodocumentocarga = ? and ordem = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_info_mercosul_di where numerodocumentocarga = ? and ordem = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_info_mercosul_di";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_info_mercosul_di where numerodocumentocarga = ? and ordem = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public InfoMercosulDiDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param numerodocumentocarga;
         * @param ordem;
         * @return A nova inst�ncia
         */
        private J34SiscomexInfoMercosulDi newInstanceWithPrimaryKey( String numerodocumentocarga, Integer ordem ) {
                J34SiscomexInfoMercosulDi j34SiscomexInfoMercosulDi = new J34SiscomexInfoMercosulDi();
                j34SiscomexInfoMercosulDi.setNumerodocumentocarga( numerodocumentocarga );
                j34SiscomexInfoMercosulDi.setOrdem( ordem );
                return j34SiscomexInfoMercosulDi ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga;
         * @param ordem;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexInfoMercosulDi find( String numerodocumentocarga, Integer ordem ) {
                J34SiscomexInfoMercosulDi j34SiscomexInfoMercosulDi = newInstanceWithPrimaryKey( numerodocumentocarga, ordem ) ;
                if ( super.doSelect(j34SiscomexInfoMercosulDi) ) {
                        return j34SiscomexInfoMercosulDi ;
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
         * @param j34SiscomexInfoMercosulDi
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexInfoMercosulDi j34SiscomexInfoMercosulDi ) {
                return super.doSelect(j34SiscomexInfoMercosulDi) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexInfoMercosulDi
         */
        @Override
        public void insert(J34SiscomexInfoMercosulDi j34SiscomexInfoMercosulDi) {
                super.doInsert(j34SiscomexInfoMercosulDi);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexInfoMercosulDi
         * @return
         */
        @Override
        public int update(J34SiscomexInfoMercosulDi j34SiscomexInfoMercosulDi) {
                return super.doUpdate(j34SiscomexInfoMercosulDi);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param numerodocumentocarga;
         * @param ordem;
         * @return
         */
        @Override
        public int delete( String numerodocumentocarga, Integer ordem ) {
                J34SiscomexInfoMercosulDi j34SiscomexInfoMercosulDi = newInstanceWithPrimaryKey( numerodocumentocarga, ordem ) ;
                return super.doDelete(j34SiscomexInfoMercosulDi);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexInfoMercosulDi
         * @return
         */
        @Override
        public int delete( J34SiscomexInfoMercosulDi j34SiscomexInfoMercosulDi ) {
                return super.doDelete(j34SiscomexInfoMercosulDi);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param numerodocumentocarga;
         * @param ordem;
         * @return
         */
        @Override
        public boolean exists( String numerodocumentocarga, Integer ordem ) {
                J34SiscomexInfoMercosulDi j34SiscomexInfoMercosulDi = newInstanceWithPrimaryKey( numerodocumentocarga, ordem ) ;
                return super.doExists(j34SiscomexInfoMercosulDi);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexInfoMercosulDi
         * @return
         */
        @Override
        public boolean exists( J34SiscomexInfoMercosulDi j34SiscomexInfoMercosulDi ) {
                return super.doExists(j34SiscomexInfoMercosulDi);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexInfoMercosulDi j34SiscomexInfoMercosulDi) throws SQLException {
                
                setRawParameter(list,  j34SiscomexInfoMercosulDi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setRawParameter(list,  j34SiscomexInfoMercosulDi.getOrdem() ) ; // "ordem" : java.lang.Integer
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexInfoMercosulDi populateBean(Cursor c, J34SiscomexInfoMercosulDi j34SiscomexInfoMercosulDi) throws SQLException {

               
                j34SiscomexInfoMercosulDi.setNumerodocumentocarga(c.getString(c.getColumnIndex("numerodocumentocarga"))); // java.lang.String
                j34SiscomexInfoMercosulDi.setOrdem(c.getInt(c.getColumnIndex("ordem"))); // java.lang.Integer
                j34SiscomexInfoMercosulDi.setNumerodemercosul(c.getString(c.getColumnIndex("numerodemercosul"))); // java.lang.String
                j34SiscomexInfoMercosulDi.setNumerorefinal(c.getString(c.getColumnIndex("numerorefinal"))); // java.lang.String
                j34SiscomexInfoMercosulDi.setNumeroreinicial(c.getString(c.getColumnIndex("numeroreinicial"))); // java.lang.String
                return j34SiscomexInfoMercosulDi ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexInfoMercosulDi j34SiscomexInfoMercosulDi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexInfoMercosulDi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexInfoMercosulDi.getOrdem() ) ; // "ordem" : java.lang.Integer
                setValue(ps, i++, j34SiscomexInfoMercosulDi.getNumerodemercosul() ) ; // "numerodemercosul" : java.lang.String
                setValue(ps, i++, j34SiscomexInfoMercosulDi.getNumerorefinal() ) ; // "numerorefinal" : java.lang.String
                setValue(ps, i++, j34SiscomexInfoMercosulDi.getNumeroreinicial() ) ; // "numeroreinicial" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexInfoMercosulDi j34SiscomexInfoMercosulDi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexInfoMercosulDi.getNumerodemercosul() ) ; // "numerodemercosul" : java.lang.String
                setValue(ps, i++, j34SiscomexInfoMercosulDi.getNumerorefinal() ) ; // "numerorefinal" : java.lang.String
                setValue(ps, i++, j34SiscomexInfoMercosulDi.getNumeroreinicial() ) ; // "numeroreinicial" : java.lang.String
                
                setValue(ps, i++, j34SiscomexInfoMercosulDi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexInfoMercosulDi.getOrdem() ) ; // "ordem" : java.lang.Integer
        }

}
