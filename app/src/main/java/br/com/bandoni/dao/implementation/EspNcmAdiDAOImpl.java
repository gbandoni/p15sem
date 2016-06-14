package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.EspNcmAdiDAO;
import br.com.bandoni.dao.tables.J34SiscomexEspNcmAdi;

/**
 * J34SiscomexEspNcmAdi: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class EspNcmAdiDAOImpl extends GenericDAO<J34SiscomexEspNcmAdi> implements EspNcmAdiDAO {

        private final static String SQL_SELECT = 
                "select numerodocumentocarga, numeroadicao, codigoabrangenciancm, ncm, codigoatributoncm, codigoespecificacao, atributo from j34_siscomex_esp_ncm_adi where numerodocumentocarga = ? and numeroadicao = ? and codigoabrangenciancm = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_esp_ncm_adi ( numerodocumentocarga, numeroadicao, codigoabrangenciancm, ncm, codigoatributoncm, codigoespecificacao, atributo ) values ( ?, ?, ?, ?, ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_esp_ncm_adi set ncm = ?, codigoatributoncm = ?, codigoespecificacao = ?, atributo = ? where numerodocumentocarga = ? and numeroadicao = ? and codigoabrangenciancm = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_esp_ncm_adi where numerodocumentocarga = ? and numeroadicao = ? and codigoabrangenciancm = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_esp_ncm_adi";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_esp_ncm_adi where numerodocumentocarga = ? and numeroadicao = ? and codigoabrangenciancm = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public EspNcmAdiDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @param codigoabrangenciancm;
         * @return A nova inst�ncia
         */
        private J34SiscomexEspNcmAdi newInstanceWithPrimaryKey( String numerodocumentocarga, String numeroadicao, String codigoabrangenciancm ) {
                J34SiscomexEspNcmAdi j34SiscomexEspNcmAdi = new J34SiscomexEspNcmAdi();
                j34SiscomexEspNcmAdi.setNumerodocumentocarga( numerodocumentocarga );
                j34SiscomexEspNcmAdi.setNumeroadicao( numeroadicao );
                j34SiscomexEspNcmAdi.setCodigoabrangenciancm( codigoabrangenciancm );
                return j34SiscomexEspNcmAdi ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @param codigoabrangenciancm;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexEspNcmAdi find( String numerodocumentocarga, String numeroadicao, String codigoabrangenciancm ) {
                J34SiscomexEspNcmAdi j34SiscomexEspNcmAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao, codigoabrangenciancm ) ;
                if ( super.doSelect(j34SiscomexEspNcmAdi) ) {
                        return j34SiscomexEspNcmAdi ;
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
         * @param j34SiscomexEspNcmAdi
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexEspNcmAdi j34SiscomexEspNcmAdi ) {
                return super.doSelect(j34SiscomexEspNcmAdi) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexEspNcmAdi
         */
        @Override
        public void insert(J34SiscomexEspNcmAdi j34SiscomexEspNcmAdi) {
                super.doInsert(j34SiscomexEspNcmAdi);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexEspNcmAdi
         * @return
         */
        @Override
        public int update(J34SiscomexEspNcmAdi j34SiscomexEspNcmAdi) {
                return super.doUpdate(j34SiscomexEspNcmAdi);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @param codigoabrangenciancm;
         * @return
         */
        @Override
        public int delete( String numerodocumentocarga, String numeroadicao, String codigoabrangenciancm ) {
                J34SiscomexEspNcmAdi j34SiscomexEspNcmAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao, codigoabrangenciancm ) ;
                return super.doDelete(j34SiscomexEspNcmAdi);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexEspNcmAdi
         * @return
         */
        @Override
        public int delete( J34SiscomexEspNcmAdi j34SiscomexEspNcmAdi ) {
                return super.doDelete(j34SiscomexEspNcmAdi);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @param codigoabrangenciancm;
         * @return
         */
        @Override
        public boolean exists( String numerodocumentocarga, String numeroadicao, String codigoabrangenciancm ) {
                J34SiscomexEspNcmAdi j34SiscomexEspNcmAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao, codigoabrangenciancm ) ;
                return super.doExists(j34SiscomexEspNcmAdi);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexEspNcmAdi
         * @return
         */
        @Override
        public boolean exists( J34SiscomexEspNcmAdi j34SiscomexEspNcmAdi ) {
                return super.doExists(j34SiscomexEspNcmAdi);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexEspNcmAdi j34SiscomexEspNcmAdi) throws SQLException {
                
                setRawParameter(list, j34SiscomexEspNcmAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setRawParameter(list, j34SiscomexEspNcmAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
                setRawParameter(list, j34SiscomexEspNcmAdi.getCodigoabrangenciancm() ) ; // "codigoabrangenciancm" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexEspNcmAdi populateBean(Cursor c, J34SiscomexEspNcmAdi j34SiscomexEspNcmAdi) throws SQLException {

               
                j34SiscomexEspNcmAdi.setNumerodocumentocarga(c.getString(c.getColumnIndex("numerodocumentocarga"))); // java.lang.String
                j34SiscomexEspNcmAdi.setNumeroadicao(c.getString(c.getColumnIndex("numeroadicao"))); // java.lang.String
                j34SiscomexEspNcmAdi.setCodigoabrangenciancm(c.getString(c.getColumnIndex("codigoabrangenciancm"))); // java.lang.String
                j34SiscomexEspNcmAdi.setNcm(c.getString(c.getColumnIndex("ncm"))); // java.lang.String
                j34SiscomexEspNcmAdi.setCodigoatributoncm(c.getString(c.getColumnIndex("codigoatributoncm"))); // java.lang.String
                j34SiscomexEspNcmAdi.setCodigoespecificacao(c.getInt(c.getColumnIndex("codigoespecificacao"))); // java.lang.String
                j34SiscomexEspNcmAdi.setAtributo(c.getString(c.getColumnIndex("atributo"))); // java.lang.String
                return j34SiscomexEspNcmAdi ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexEspNcmAdi j34SiscomexEspNcmAdi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexEspNcmAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexEspNcmAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
                setValue(ps, i++, j34SiscomexEspNcmAdi.getCodigoabrangenciancm() ) ; // "codigoabrangenciancm" : java.lang.String
                setValue(ps, i++, j34SiscomexEspNcmAdi.getNcm() ) ; // "ncm" : java.lang.String
                setValue(ps, i++, j34SiscomexEspNcmAdi.getCodigoatributoncm() ) ; // "codigoatributoncm" : java.lang.String
                setValue(ps, i++, j34SiscomexEspNcmAdi.getCodigoespecificacao() ) ; // "codigoespecificacaoncm" : java.lang.String
                setValue(ps, i++, j34SiscomexEspNcmAdi.getAtributo() ) ; // "atributo" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexEspNcmAdi j34SiscomexEspNcmAdi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexEspNcmAdi.getNcm() ) ; // "ncm" : java.lang.String
                setValue(ps, i++, j34SiscomexEspNcmAdi.getCodigoatributoncm() ) ; // "codigoatributoncm" : java.lang.String
                setValue(ps, i++, j34SiscomexEspNcmAdi.getCodigoespecificacao() ) ; // "codigoespecificacaoncm" : java.lang.String
                setValue(ps, i++, j34SiscomexEspNcmAdi.getAtributo() ) ; // "atributo" : java.lang.String
                
                setValue(ps, i++, j34SiscomexEspNcmAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexEspNcmAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
                setValue(ps, i++, j34SiscomexEspNcmAdi.getCodigoabrangenciancm() ) ; // "codigoabrangenciancm" : java.lang.String
        }

}
