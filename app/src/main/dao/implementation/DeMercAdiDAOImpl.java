package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.DeMercAdiDAO;
import br.com.bandoni.dao.tables.J34SiscomexDeMercAdi;

/**
 * J34SiscomexDeMercAdi: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class DeMercAdiDAOImpl extends GenericDAO<J34SiscomexDeMercAdi> implements DeMercAdiDAO {

        private final static String SQL_SELECT = 
                "select numerodocumentocarga, numeroadicao, codigopaiscertificado, numerodeadmercosul, numerodicertificado, numeroitemcertificado, numeroreadfinal, numeroreadinicial, quantidadeunidademercosul from j34_siscomex_de_merc_adi where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_de_merc_adi ( numerodocumentocarga, numeroadicao, codigopaiscertificado, numerodeadmercosul, numerodicertificado, numeroitemcertificado, numeroreadfinal, numeroreadinicial, quantidadeunidademercosul ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_de_merc_adi set codigopaiscertificado = ?, numerodeadmercosul = ?, numerodicertificado = ?, numeroitemcertificado = ?, numeroreadfinal = ?, numeroreadinicial = ?, quantidadeunidademercosul = ? where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_de_merc_adi where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_de_merc_adi";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_de_merc_adi where numerodocumentocarga = ? and numeroadicao = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public DeMercAdiDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @return A nova inst�ncia
         */
        private J34SiscomexDeMercAdi newInstanceWithPrimaryKey( String numerodocumentocarga, String numeroadicao ) {
                J34SiscomexDeMercAdi j34SiscomexDeMercAdi = new J34SiscomexDeMercAdi();
                j34SiscomexDeMercAdi.setNumerodocumentocarga( numerodocumentocarga );
                j34SiscomexDeMercAdi.setNumeroadicao( numeroadicao );
                return j34SiscomexDeMercAdi ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexDeMercAdi find( String numerodocumentocarga, String numeroadicao ) {
                J34SiscomexDeMercAdi j34SiscomexDeMercAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                if ( super.doSelect(j34SiscomexDeMercAdi) ) {
                        return j34SiscomexDeMercAdi ;
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
         * @param j34SiscomexDeMercAdi
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexDeMercAdi j34SiscomexDeMercAdi ) {
                return super.doSelect(j34SiscomexDeMercAdi) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexDeMercAdi
         */
        @Override
        public void insert(J34SiscomexDeMercAdi j34SiscomexDeMercAdi) {
                super.doInsert(j34SiscomexDeMercAdi);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexDeMercAdi
         * @return
         */
        @Override
        public int update(J34SiscomexDeMercAdi j34SiscomexDeMercAdi) {
                return super.doUpdate(j34SiscomexDeMercAdi);
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
                J34SiscomexDeMercAdi j34SiscomexDeMercAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                return super.doDelete(j34SiscomexDeMercAdi);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexDeMercAdi
         * @return
         */
        @Override
        public int delete( J34SiscomexDeMercAdi j34SiscomexDeMercAdi ) {
                return super.doDelete(j34SiscomexDeMercAdi);
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
                J34SiscomexDeMercAdi j34SiscomexDeMercAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                return super.doExists(j34SiscomexDeMercAdi);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexDeMercAdi
         * @return
         */
        @Override
        public boolean exists( J34SiscomexDeMercAdi j34SiscomexDeMercAdi ) {
                return super.doExists(j34SiscomexDeMercAdi);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexDeMercAdi j34SiscomexDeMercAdi) throws SQLException {
                
                setRawParameter(list,j34SiscomexDeMercAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setRawParameter(list,j34SiscomexDeMercAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexDeMercAdi populateBean(Cursor c, J34SiscomexDeMercAdi j34SiscomexDeMercAdi) throws SQLException {

               
                j34SiscomexDeMercAdi.setNumerodocumentocarga(c.getString(c.getColumnIndex("numerodocumentocarga"))); // java.lang.String
                j34SiscomexDeMercAdi.setNumeroadicao(c.getString(c.getColumnIndex("numeroadicao"))); // java.lang.String
                j34SiscomexDeMercAdi.setCodigopaiscertificado(c.getString(c.getColumnIndex("codigopaiscertificado"))); // java.lang.String
                j34SiscomexDeMercAdi.setNumerodeadmercosul(c.getString(c.getColumnIndex("numerodeadmercosul"))); // java.lang.String
                j34SiscomexDeMercAdi.setNumerodicertificado(c.getString(c.getColumnIndex("numerodicertificado"))); // java.lang.String
                j34SiscomexDeMercAdi.setNumeroitemcertificado(c.getString(c.getColumnIndex("numeroitemcertificado"))); // java.lang.String
                j34SiscomexDeMercAdi.setNumeroreadfinal(c.getString(c.getColumnIndex("numeroreadfinal"))); // java.lang.String
                j34SiscomexDeMercAdi.setNumeroreadinicial(c.getString(c.getColumnIndex("numeroreadinicial"))); // java.lang.String
                j34SiscomexDeMercAdi.setQuantidadeunidademercosul(c.getFloat(c.getColumnIndex("quantidadeunidademercosul"))); // java.math.BigDecimal
                return j34SiscomexDeMercAdi ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexDeMercAdi j34SiscomexDeMercAdi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexDeMercAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexDeMercAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
                setValue(ps, i++, j34SiscomexDeMercAdi.getCodigopaiscertificado() ) ; // "codigopaiscertificado" : java.lang.String
                setValue(ps, i++, j34SiscomexDeMercAdi.getNumerodeadmercosul() ) ; // "numerodeadmercosul" : java.lang.String
                setValue(ps, i++, j34SiscomexDeMercAdi.getNumerodicertificado() ) ; // "numerodicertificado" : java.lang.String
                setValue(ps, i++, j34SiscomexDeMercAdi.getNumeroitemcertificado() ) ; // "numeroitemcertificado" : java.lang.String
                setValue(ps, i++, j34SiscomexDeMercAdi.getNumeroreadfinal() ) ; // "numeroreadfinal" : java.lang.String
                setValue(ps, i++, j34SiscomexDeMercAdi.getNumeroreadinicial() ) ; // "numeroreadinicial" : java.lang.String
                setValue(ps, i++, j34SiscomexDeMercAdi.getQuantidadeunidademercosul() ) ; // "quantidadeunidademercosul" : java.math.BigDecimal
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexDeMercAdi j34SiscomexDeMercAdi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexDeMercAdi.getCodigopaiscertificado() ) ; // "codigopaiscertificado" : java.lang.String
                setValue(ps, i++, j34SiscomexDeMercAdi.getNumerodeadmercosul() ) ; // "numerodeadmercosul" : java.lang.String
                setValue(ps, i++, j34SiscomexDeMercAdi.getNumerodicertificado() ) ; // "numerodicertificado" : java.lang.String
                setValue(ps, i++, j34SiscomexDeMercAdi.getNumeroitemcertificado() ) ; // "numeroitemcertificado" : java.lang.String
                setValue(ps, i++, j34SiscomexDeMercAdi.getNumeroreadfinal() ) ; // "numeroreadfinal" : java.lang.String
                setValue(ps, i++, j34SiscomexDeMercAdi.getNumeroreadinicial() ) ; // "numeroreadinicial" : java.lang.String
                setValue(ps, i++, j34SiscomexDeMercAdi.getQuantidadeunidademercosul() ) ; // "quantidadeunidademercosul" : java.math.BigDecimal
                
                setValue(ps, i++, j34SiscomexDeMercAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexDeMercAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
        }

}
