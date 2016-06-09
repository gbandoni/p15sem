package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.DocCargaDiDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexDocCargaDi;

/**
 * J34SiscomexDocCargaDi: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class DocCargaDiDAOImpl extends GenericDAO<J34SiscomexDocCargaDi> implements DocCargaDiDAO {

        private final static String SQL_SELECT = 
                "select numerodocumentocarga, ordem, codigotipoembalagemcarga, quantidadevolumecarga from j34_siscomex_doc_carga_di where numerodocumentocarga = ? and ordem = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_doc_carga_di ( numerodocumentocarga, ordem, codigotipoembalagemcarga, quantidadevolumecarga ) values ( ?, ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_doc_carga_di set codigotipoembalagemcarga = ?, quantidadevolumecarga = ? where numerodocumentocarga = ? and ordem = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_doc_carga_di where numerodocumentocarga = ? and ordem = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_doc_carga_di";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_doc_carga_di where numerodocumentocarga = ? and ordem = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public DocCargaDiDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param numerodocumentocarga;
         * @param ordem;
         * @return A nova inst�ncia
         */
        private J34SiscomexDocCargaDi newInstanceWithPrimaryKey( String numerodocumentocarga, Integer ordem ) {
                J34SiscomexDocCargaDi j34SiscomexDocCargaDi = new J34SiscomexDocCargaDi();
                j34SiscomexDocCargaDi.setNumerodocumentocarga( numerodocumentocarga );
                j34SiscomexDocCargaDi.setOrdem( ordem );
                return j34SiscomexDocCargaDi ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga;
         * @param ordem;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexDocCargaDi find( String numerodocumentocarga, Integer ordem ) {
                J34SiscomexDocCargaDi j34SiscomexDocCargaDi = newInstanceWithPrimaryKey( numerodocumentocarga, ordem ) ;
                if ( super.doSelect(j34SiscomexDocCargaDi) ) {
                        return j34SiscomexDocCargaDi ;
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
         * @param j34SiscomexDocCargaDi
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexDocCargaDi j34SiscomexDocCargaDi ) {
                return super.doSelect(j34SiscomexDocCargaDi) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexDocCargaDi
         */
        @Override
        public void insert(J34SiscomexDocCargaDi j34SiscomexDocCargaDi) {
                super.doInsert(j34SiscomexDocCargaDi);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexDocCargaDi
         * @return
         */
        @Override
        public int update(J34SiscomexDocCargaDi j34SiscomexDocCargaDi) {
                return super.doUpdate(j34SiscomexDocCargaDi);
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
                J34SiscomexDocCargaDi j34SiscomexDocCargaDi = newInstanceWithPrimaryKey( numerodocumentocarga, ordem ) ;
                return super.doDelete(j34SiscomexDocCargaDi);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexDocCargaDi
         * @return
         */
        @Override
        public int delete( J34SiscomexDocCargaDi j34SiscomexDocCargaDi ) {
                return super.doDelete(j34SiscomexDocCargaDi);
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
                J34SiscomexDocCargaDi j34SiscomexDocCargaDi = newInstanceWithPrimaryKey( numerodocumentocarga, ordem ) ;
                return super.doExists(j34SiscomexDocCargaDi);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexDocCargaDi
         * @return
         */
        @Override
        public boolean exists( J34SiscomexDocCargaDi j34SiscomexDocCargaDi ) {
                return super.doExists(j34SiscomexDocCargaDi);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexDocCargaDi j34SiscomexDocCargaDi) throws SQLException {
                
                setRawParameter(list,j34SiscomexDocCargaDi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setRawParameter(list,j34SiscomexDocCargaDi.getOrdem()) ; // "ordem" : java.lang.Integer
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexDocCargaDi populateBean(Cursor c, J34SiscomexDocCargaDi j34SiscomexDocCargaDi) throws SQLException {

               
                j34SiscomexDocCargaDi.setNumerodocumentocarga(c.getString(c.getColumnIndex("numerodocumentocarga"))); // java.lang.String
                j34SiscomexDocCargaDi.setOrdem(c.getInt(c.getColumnIndex("ordem"))); // java.lang.Integer
                j34SiscomexDocCargaDi.setCodigotipoembalagemcarga(c.getInt(c.getColumnIndex("codigotipoembalagemcarga"))); // java.lang.Integer
                j34SiscomexDocCargaDi.setQuantidadevolumecarga(c.getInt(c.getColumnIndex("quantidadevolumecarga"))); // java.lang.Integer
                return j34SiscomexDocCargaDi ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexDocCargaDi j34SiscomexDocCargaDi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexDocCargaDi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexDocCargaDi.getOrdem() ) ; // "ordem" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDocCargaDi.getCodigotipoembalagemcarga() ) ; // "codigotipoembalagemcarga" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDocCargaDi.getQuantidadevolumecarga() ) ; // "quantidadevolumecarga" : java.lang.Integer
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexDocCargaDi j34SiscomexDocCargaDi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexDocCargaDi.getCodigotipoembalagemcarga() ) ; // "codigotipoembalagemcarga" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDocCargaDi.getQuantidadevolumecarga() ) ; // "quantidadevolumecarga" : java.lang.Integer
                
                setValue(ps, i++, j34SiscomexDocCargaDi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexDocCargaDi.getOrdem() ) ; // "ordem" : java.lang.Integer
        }

}
