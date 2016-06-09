package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.DocumentosDiDAO;
import br.com.bandoni.dao.tables.J34SiscomexDocumentosDi;

/**
 * J34SiscomexDocumentosDi: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class DocumentosDiDAOImpl extends GenericDAO<J34SiscomexDocumentosDi> implements DocumentosDiDAO {

        private final static String SQL_SELECT = 
                "select numerodocumentocarga, ordem, codigotipodocumentoinstrucaodespacho, numerodocumentoinstrucaodespacho from j34_siscomex_documentos_di where numerodocumentocarga = ? and ordem = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_documentos_di ( numerodocumentocarga, ordem, codigotipodocumentoinstrucaodespacho, numerodocumentoinstrucaodespacho ) values ( ?, ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_documentos_di set codigotipodocumentoinstrucaodespacho = ?, numerodocumentoinstrucaodespacho = ? where numerodocumentocarga = ? and ordem = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_documentos_di where numerodocumentocarga = ? and ordem = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_documentos_di";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_documentos_di where numerodocumentocarga = ? and ordem = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public DocumentosDiDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param numerodocumentocarga;
         * @param ordem;
         * @return A nova inst�ncia
         */
        private J34SiscomexDocumentosDi newInstanceWithPrimaryKey( String numerodocumentocarga, Integer ordem ) {
                J34SiscomexDocumentosDi j34SiscomexDocumentosDi = new J34SiscomexDocumentosDi();
                j34SiscomexDocumentosDi.setNumerodocumentocarga( numerodocumentocarga );
                j34SiscomexDocumentosDi.setOrdem( ordem );
                return j34SiscomexDocumentosDi ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga;
         * @param ordem;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexDocumentosDi find( String numerodocumentocarga, Integer ordem ) {
                J34SiscomexDocumentosDi j34SiscomexDocumentosDi = newInstanceWithPrimaryKey( numerodocumentocarga, ordem ) ;
                if ( super.doSelect(j34SiscomexDocumentosDi) ) {
                        return j34SiscomexDocumentosDi ;
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
         * @param j34SiscomexDocumentosDi
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexDocumentosDi j34SiscomexDocumentosDi ) {
                return super.doSelect(j34SiscomexDocumentosDi) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexDocumentosDi
         */
        @Override
        public void insert(J34SiscomexDocumentosDi j34SiscomexDocumentosDi) {
                super.doInsert(j34SiscomexDocumentosDi);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexDocumentosDi
         * @return
         */
        @Override
        public int update(J34SiscomexDocumentosDi j34SiscomexDocumentosDi) {
                return super.doUpdate(j34SiscomexDocumentosDi);
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
                J34SiscomexDocumentosDi j34SiscomexDocumentosDi = newInstanceWithPrimaryKey( numerodocumentocarga, ordem ) ;
                return super.doDelete(j34SiscomexDocumentosDi);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexDocumentosDi
         * @return
         */
        @Override
        public int delete( J34SiscomexDocumentosDi j34SiscomexDocumentosDi ) {
                return super.doDelete(j34SiscomexDocumentosDi);
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
                J34SiscomexDocumentosDi j34SiscomexDocumentosDi = newInstanceWithPrimaryKey( numerodocumentocarga, ordem ) ;
                return super.doExists(j34SiscomexDocumentosDi);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexDocumentosDi
         * @return
         */
        @Override
        public boolean exists( J34SiscomexDocumentosDi j34SiscomexDocumentosDi ) {
                return super.doExists(j34SiscomexDocumentosDi);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexDocumentosDi j34SiscomexDocumentosDi) throws SQLException {
                
                setRawParameter(list,j34SiscomexDocumentosDi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setRawParameter(list,j34SiscomexDocumentosDi.getOrdem()) ; // "ordem" : java.lang.Integer
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexDocumentosDi populateBean(Cursor c, J34SiscomexDocumentosDi j34SiscomexDocumentosDi) throws SQLException {

               
                j34SiscomexDocumentosDi.setNumerodocumentocarga(c.getString(c.getColumnIndex("numerodocumentocarga"))); // java.lang.String
                j34SiscomexDocumentosDi.setOrdem(c.getInt(c.getColumnIndex("ordem"))); // java.lang.Integer
                j34SiscomexDocumentosDi.setCodigotipodocumentoinstrucaodespacho(c.getInt(c.getColumnIndex("codigotipodocumentoinstrucaodespacho"))); // java.lang.Integer
                j34SiscomexDocumentosDi.setNumerodocumentoinstrucaodespacho(c.getString(c.getColumnIndex("numerodocumentoinstrucaodespacho"))); // java.lang.String
                return j34SiscomexDocumentosDi ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexDocumentosDi j34SiscomexDocumentosDi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexDocumentosDi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexDocumentosDi.getOrdem() ) ; // "ordem" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDocumentosDi.getCodigotipodocumentoinstrucaodespacho() ) ; // "codigotipodocumentoinstrucaodespacho" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDocumentosDi.getNumerodocumentoinstrucaodespacho() ) ; // "numerodocumentoinstrucaodespacho" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexDocumentosDi j34SiscomexDocumentosDi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexDocumentosDi.getCodigotipodocumentoinstrucaodespacho() ) ; // "codigotipodocumentoinstrucaodespacho" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDocumentosDi.getNumerodocumentoinstrucaodespacho() ) ; // "numerodocumentoinstrucaodespacho" : java.lang.String
                
                setValue(ps, i++, j34SiscomexDocumentosDi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexDocumentosDi.getOrdem() ) ; // "ordem" : java.lang.Integer
        }

}
