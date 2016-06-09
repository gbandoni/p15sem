package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.DestaquencmAdiDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexDestaquencmAdi;

/**
 * J34SiscomexDestaquencmAdi: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class DestaquencmAdiDAOImpl extends GenericDAO<J34SiscomexDestaquencmAdi> implements DestaquencmAdiDAO {

        private final static String SQL_SELECT = 
                "select numerodocumentocarga, numeroadicao, numerodestaquencm from j34_siscomex_destaquencm_adi where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_destaquencm_adi ( numerodocumentocarga, numeroadicao, numerodestaquencm ) values ( ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_destaquencm_adi set numerodestaquencm = ? where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_destaquencm_adi where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_destaquencm_adi";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_destaquencm_adi where numerodocumentocarga = ? and numeroadicao = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public DestaquencmAdiDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @return A nova inst�ncia
         */
        private J34SiscomexDestaquencmAdi newInstanceWithPrimaryKey( String numerodocumentocarga, String numeroadicao ) {
                J34SiscomexDestaquencmAdi j34SiscomexDestaquencmAdi = new J34SiscomexDestaquencmAdi();
                j34SiscomexDestaquencmAdi.setNumerodocumentocarga( numerodocumentocarga );
                j34SiscomexDestaquencmAdi.setNumeroadicao( numeroadicao );
                return j34SiscomexDestaquencmAdi ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexDestaquencmAdi find( String numerodocumentocarga, String numeroadicao ) {
                J34SiscomexDestaquencmAdi j34SiscomexDestaquencmAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                if ( super.doSelect(j34SiscomexDestaquencmAdi) ) {
                        return j34SiscomexDestaquencmAdi ;
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
         * @param j34SiscomexDestaquencmAdi
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexDestaquencmAdi j34SiscomexDestaquencmAdi ) {
                return super.doSelect(j34SiscomexDestaquencmAdi) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexDestaquencmAdi
         */
        @Override
        public void insert(J34SiscomexDestaquencmAdi j34SiscomexDestaquencmAdi) {
                super.doInsert(j34SiscomexDestaquencmAdi);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexDestaquencmAdi
         * @return
         */
        @Override
        public int update(J34SiscomexDestaquencmAdi j34SiscomexDestaquencmAdi) {
                return super.doUpdate(j34SiscomexDestaquencmAdi);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @return
         */
        @Override
        public int delete( String numerodocumentocarga, String numeroadicao ) {
                J34SiscomexDestaquencmAdi j34SiscomexDestaquencmAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                return super.doDelete(j34SiscomexDestaquencmAdi);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexDestaquencmAdi
         * @return
         */
        @Override
        public int delete( J34SiscomexDestaquencmAdi j34SiscomexDestaquencmAdi ) {
                return super.doDelete(j34SiscomexDestaquencmAdi);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @return
         */
        @Override
        public boolean exists( String numerodocumentocarga, String numeroadicao ) {
                J34SiscomexDestaquencmAdi j34SiscomexDestaquencmAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                return super.doExists(j34SiscomexDestaquencmAdi);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexDestaquencmAdi
         * @return
         */
        @Override
        public boolean exists( J34SiscomexDestaquencmAdi j34SiscomexDestaquencmAdi ) {
                return super.doExists(j34SiscomexDestaquencmAdi);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexDestaquencmAdi j34SiscomexDestaquencmAdi) throws SQLException {
                
                setRawParameter(list,j34SiscomexDestaquencmAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setRawParameter(list,j34SiscomexDestaquencmAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexDestaquencmAdi populateBean(Cursor c, J34SiscomexDestaquencmAdi j34SiscomexDestaquencmAdi) throws SQLException {

               
                j34SiscomexDestaquencmAdi.setNumerodocumentocarga(c.getString(c.getColumnIndex("numerodocumentocarga"))); // java.lang.String
                j34SiscomexDestaquencmAdi.setNumeroadicao(c.getString(c.getColumnIndex("numeroadicao"))); // java.lang.String
                j34SiscomexDestaquencmAdi.setNumerodestaquencm(c.getString(c.getColumnIndex("numerodestaquencm"))); // java.lang.String
                return j34SiscomexDestaquencmAdi ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexDestaquencmAdi j34SiscomexDestaquencmAdi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexDestaquencmAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexDestaquencmAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
                setValue(ps, i++, j34SiscomexDestaquencmAdi.getNumerodestaquencm() ) ; // "numerodestaquencm" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexDestaquencmAdi j34SiscomexDestaquencmAdi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexDestaquencmAdi.getNumerodestaquencm() ) ; // "numerodestaquencm" : java.lang.String
                
                setValue(ps, i++, j34SiscomexDestaquencmAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexDestaquencmAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
        }

}
