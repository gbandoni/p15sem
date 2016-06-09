package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.DocVinculadoAdiDAO;
import br.com.bandoni.dao.tables.J34SiscomexDocVinculadoAdi;

/**
 * J34SiscomexDocVinculadoAdi: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class DocVinculadoAdiDAOImpl extends GenericDAO<J34SiscomexDocVinculadoAdi> implements DocVinculadoAdiDAO {

        private final static String SQL_SELECT = 
                "select numerodocumentocarga, numeroadicao, codigotipodocumentovinculado, numerodocumentovinculado from j34_siscomex_doc_vinculado_adi where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_doc_vinculado_adi ( numerodocumentocarga, numeroadicao, codigotipodocumentovinculado, numerodocumentovinculado ) values ( ?, ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_doc_vinculado_adi set codigotipodocumentovinculado = ?, numerodocumentovinculado = ? where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_doc_vinculado_adi where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_doc_vinculado_adi";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_doc_vinculado_adi where numerodocumentocarga = ? and numeroadicao = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public DocVinculadoAdiDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @return A nova inst�ncia
         */
        private J34SiscomexDocVinculadoAdi newInstanceWithPrimaryKey( String numerodocumentocarga, String numeroadicao ) {
                J34SiscomexDocVinculadoAdi j34SiscomexDocVinculadoAdi = new J34SiscomexDocVinculadoAdi();
                j34SiscomexDocVinculadoAdi.setNumerodocumentocarga( numerodocumentocarga );
                j34SiscomexDocVinculadoAdi.setNumeroadicao( numeroadicao );
                return j34SiscomexDocVinculadoAdi ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexDocVinculadoAdi find( String numerodocumentocarga, String numeroadicao ) {
                J34SiscomexDocVinculadoAdi j34SiscomexDocVinculadoAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                if ( super.doSelect(j34SiscomexDocVinculadoAdi) ) {
                        return j34SiscomexDocVinculadoAdi ;
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
         * @param j34SiscomexDocVinculadoAdi
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexDocVinculadoAdi j34SiscomexDocVinculadoAdi ) {
                return super.doSelect(j34SiscomexDocVinculadoAdi) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexDocVinculadoAdi
         */
        @Override
        public void insert(J34SiscomexDocVinculadoAdi j34SiscomexDocVinculadoAdi) {
                super.doInsert(j34SiscomexDocVinculadoAdi);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexDocVinculadoAdi
         * @return
         */
        @Override
        public int update(J34SiscomexDocVinculadoAdi j34SiscomexDocVinculadoAdi) {
                return super.doUpdate(j34SiscomexDocVinculadoAdi);
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
                J34SiscomexDocVinculadoAdi j34SiscomexDocVinculadoAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                return super.doDelete(j34SiscomexDocVinculadoAdi);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexDocVinculadoAdi
         * @return
         */
        @Override
        public int delete( J34SiscomexDocVinculadoAdi j34SiscomexDocVinculadoAdi ) {
                return super.doDelete(j34SiscomexDocVinculadoAdi);
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
                J34SiscomexDocVinculadoAdi j34SiscomexDocVinculadoAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                return super.doExists(j34SiscomexDocVinculadoAdi);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexDocVinculadoAdi
         * @return
         */
        @Override
        public boolean exists( J34SiscomexDocVinculadoAdi j34SiscomexDocVinculadoAdi ) {
                return super.doExists(j34SiscomexDocVinculadoAdi);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexDocVinculadoAdi j34SiscomexDocVinculadoAdi) throws SQLException {
                
                setRawParameter(list, j34SiscomexDocVinculadoAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setRawParameter(list, j34SiscomexDocVinculadoAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexDocVinculadoAdi populateBean(Cursor c, J34SiscomexDocVinculadoAdi j34SiscomexDocVinculadoAdi) throws SQLException {

               
                j34SiscomexDocVinculadoAdi.setNumerodocumentocarga(c.getString(c.getColumnIndex("numerodocumentocarga"))); // java.lang.String
                j34SiscomexDocVinculadoAdi.setNumeroadicao(c.getString(c.getColumnIndex("numeroadicao"))); // java.lang.String
                j34SiscomexDocVinculadoAdi.setCodigotipodocumentovinculado(c.getString(c.getColumnIndex("codigotipodocumentovinculado"))); // java.lang.String
                j34SiscomexDocVinculadoAdi.setNumerodocumentovinculado(c.getString(c.getColumnIndex("numerodocumentovinculado"))); // java.lang.String
                return j34SiscomexDocVinculadoAdi ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexDocVinculadoAdi j34SiscomexDocVinculadoAdi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexDocVinculadoAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexDocVinculadoAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
                setValue(ps, i++, j34SiscomexDocVinculadoAdi.getCodigotipodocumentovinculado() ) ; // "codigotipodocumentovinculado" : java.lang.String
                setValue(ps, i++, j34SiscomexDocVinculadoAdi.getNumerodocumentovinculado() ) ; // "numerodocumentovinculado" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexDocVinculadoAdi j34SiscomexDocVinculadoAdi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexDocVinculadoAdi.getCodigotipodocumentovinculado() ) ; // "codigotipodocumentovinculado" : java.lang.String
                setValue(ps, i++, j34SiscomexDocVinculadoAdi.getNumerodocumentovinculado() ) ; // "numerodocumentovinculado" : java.lang.String
                
                setValue(ps, i++, j34SiscomexDocVinculadoAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexDocVinculadoAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
        }

}
