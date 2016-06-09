package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.TarifasAdiDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexTarifasAdi;

/**
 * J34SiscomexTarifasAdi: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class TarifasAdiDAOImpl extends GenericDAO<J34SiscomexTarifasAdi> implements TarifasAdiDAO {

        private final static String SQL_SELECT = 
                "select numerodocumentocarga, numeroadicao, codigoassuntovinculado, dataanoatovinculado, numeroatovinculado, numeroexatovinculado, siglaorgaoatovinculado, siglatipoatovinculado from j34_siscomex_tarifas_adi where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_tarifas_adi ( numerodocumentocarga, numeroadicao, codigoassuntovinculado, dataanoatovinculado, numeroatovinculado, numeroexatovinculado, siglaorgaoatovinculado, siglatipoatovinculado ) values ( ?, ?, ?, ?, ?, ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_tarifas_adi set codigoassuntovinculado = ?, dataanoatovinculado = ?, numeroatovinculado = ?, numeroexatovinculado = ?, siglaorgaoatovinculado = ?, siglatipoatovinculado = ? where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_tarifas_adi where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_tarifas_adi";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_tarifas_adi where numerodocumentocarga = ? and numeroadicao = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public TarifasAdiDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @return A nova inst�ncia
         */
        private J34SiscomexTarifasAdi newInstanceWithPrimaryKey( String numerodocumentocarga, String numeroadicao ) {
                J34SiscomexTarifasAdi j34SiscomexTarifasAdi = new J34SiscomexTarifasAdi();
                j34SiscomexTarifasAdi.setNumerodocumentocarga( numerodocumentocarga );
                j34SiscomexTarifasAdi.setNumeroadicao( numeroadicao );
                return j34SiscomexTarifasAdi ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexTarifasAdi find( String numerodocumentocarga, String numeroadicao ) {
                J34SiscomexTarifasAdi j34SiscomexTarifasAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                if ( super.doSelect(j34SiscomexTarifasAdi) ) {
                        return j34SiscomexTarifasAdi ;
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
         * @param j34SiscomexTarifasAdi
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexTarifasAdi j34SiscomexTarifasAdi ) {
                return super.doSelect(j34SiscomexTarifasAdi) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexTarifasAdi
         */
        @Override
        public void insert(J34SiscomexTarifasAdi j34SiscomexTarifasAdi) {
                super.doInsert(j34SiscomexTarifasAdi);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexTarifasAdi
         * @return
         */
        @Override
        public int update(J34SiscomexTarifasAdi j34SiscomexTarifasAdi) {
                return super.doUpdate(j34SiscomexTarifasAdi);
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
                J34SiscomexTarifasAdi j34SiscomexTarifasAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                return super.doDelete(j34SiscomexTarifasAdi);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexTarifasAdi
         * @return
         */
        @Override
        public int delete( J34SiscomexTarifasAdi j34SiscomexTarifasAdi ) {
                return super.doDelete(j34SiscomexTarifasAdi);
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
                J34SiscomexTarifasAdi j34SiscomexTarifasAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                return super.doExists(j34SiscomexTarifasAdi);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexTarifasAdi
         * @return
         */
        @Override
        public boolean exists( J34SiscomexTarifasAdi j34SiscomexTarifasAdi ) {
                return super.doExists(j34SiscomexTarifasAdi);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexTarifasAdi j34SiscomexTarifasAdi) throws SQLException {
                
                setRawParameter(list,j34SiscomexTarifasAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setRawParameter(list,j34SiscomexTarifasAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexTarifasAdi populateBean(Cursor c, J34SiscomexTarifasAdi j34SiscomexTarifasAdi) throws SQLException {

               
                j34SiscomexTarifasAdi.setNumerodocumentocarga(c.getString(c.getColumnIndex("numerodocumentocarga"))); // java.lang.String
                j34SiscomexTarifasAdi.setNumeroadicao(c.getString(c.getColumnIndex("numeroadicao"))); // java.lang.String
                j34SiscomexTarifasAdi.setCodigoassuntovinculado(c.getString(c.getColumnIndex("codigoassuntovinculado"))); // java.lang.String
                j34SiscomexTarifasAdi.setDataanoatovinculado(c.getString(c.getColumnIndex("dataanoatovinculado"))); // java.lang.String
                j34SiscomexTarifasAdi.setNumeroatovinculado(c.getString(c.getColumnIndex("numeroatovinculado"))); // java.lang.String
                j34SiscomexTarifasAdi.setNumeroexatovinculado(c.getString(c.getColumnIndex("numeroexatovinculado"))); // java.lang.String
                j34SiscomexTarifasAdi.setSiglaorgaoatovinculado(c.getString(c.getColumnIndex("siglaorgaoatovinculado"))); // java.lang.String
                j34SiscomexTarifasAdi.setSiglatipoatovinculado(c.getString(c.getColumnIndex("siglatipoatovinculado"))); // java.lang.String
                return j34SiscomexTarifasAdi ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexTarifasAdi j34SiscomexTarifasAdi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexTarifasAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexTarifasAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
                setValue(ps, i++, j34SiscomexTarifasAdi.getCodigoassuntovinculado() ) ; // "codigoassuntovinculado" : java.lang.String
                setValue(ps, i++, j34SiscomexTarifasAdi.getDataanoatovinculado() ) ; // "dataanoatovinculado" : java.lang.String
                setValue(ps, i++, j34SiscomexTarifasAdi.getNumeroatovinculado() ) ; // "numeroatovinculado" : java.lang.String
                setValue(ps, i++, j34SiscomexTarifasAdi.getNumeroexatovinculado() ) ; // "numeroexatovinculado" : java.lang.String
                setValue(ps, i++, j34SiscomexTarifasAdi.getSiglaorgaoatovinculado() ) ; // "siglaorgaoatovinculado" : java.lang.String
                setValue(ps, i++, j34SiscomexTarifasAdi.getSiglatipoatovinculado() ) ; // "siglatipoatovinculado" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexTarifasAdi j34SiscomexTarifasAdi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexTarifasAdi.getCodigoassuntovinculado() ) ; // "codigoassuntovinculado" : java.lang.String
                setValue(ps, i++, j34SiscomexTarifasAdi.getDataanoatovinculado() ) ; // "dataanoatovinculado" : java.lang.String
                setValue(ps, i++, j34SiscomexTarifasAdi.getNumeroatovinculado() ) ; // "numeroatovinculado" : java.lang.String
                setValue(ps, i++, j34SiscomexTarifasAdi.getNumeroexatovinculado() ) ; // "numeroexatovinculado" : java.lang.String
                setValue(ps, i++, j34SiscomexTarifasAdi.getSiglaorgaoatovinculado() ) ; // "siglaorgaoatovinculado" : java.lang.String
                setValue(ps, i++, j34SiscomexTarifasAdi.getSiglatipoatovinculado() ) ; // "siglatipoatovinculado" : java.lang.String
                
                setValue(ps, i++, j34SiscomexTarifasAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexTarifasAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
        }

}
