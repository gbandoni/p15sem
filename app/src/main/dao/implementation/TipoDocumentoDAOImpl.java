package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.TipoDocumentoDAO;
import br.com.bandoni.dao.tables.J34SiscomexTipoDocumento;

/**
 * J34SiscomexTipoDocumento: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class TipoDocumentoDAOImpl extends GenericDAO<J34SiscomexTipoDocumento> implements TipoDocumentoDAO {

        private final static String SQL_SELECT = 
                "select codigo, sigla, descricao, maritima, fluvia, aerea, rodoviaria, ferroviaria, postal, lacustre from j34_siscomex_tipo_documento where codigo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_tipo_documento ( codigo, sigla, descricao, maritima, fluvia, aerea, rodoviaria, ferroviaria, postal, lacustre ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_tipo_documento set sigla = ?, descricao = ?, maritima = ?, fluvia = ?, aerea = ?, rodoviaria = ?, ferroviaria = ?, postal = ?, lacustre = ? where codigo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_tipo_documento where codigo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_tipo_documento";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_tipo_documento where codigo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public TipoDocumentoDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @return A nova inst�ncia
         */
        private J34SiscomexTipoDocumento newInstanceWithPrimaryKey( String codigo ) {
                J34SiscomexTipoDocumento j34SiscomexTipoDocumento = new J34SiscomexTipoDocumento();
                j34SiscomexTipoDocumento.setCodigo( codigo );
                return j34SiscomexTipoDocumento ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexTipoDocumento find( String codigo ) {
                J34SiscomexTipoDocumento j34SiscomexTipoDocumento = newInstanceWithPrimaryKey( codigo ) ;
                if ( super.doSelect(j34SiscomexTipoDocumento) ) {
                        return j34SiscomexTipoDocumento ;
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
         * @param j34SiscomexTipoDocumento
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexTipoDocumento j34SiscomexTipoDocumento ) {
                return super.doSelect(j34SiscomexTipoDocumento) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexTipoDocumento
         */
        @Override
        public void insert(J34SiscomexTipoDocumento j34SiscomexTipoDocumento) {
                super.doInsert(j34SiscomexTipoDocumento);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexTipoDocumento
         * @return
         */
        @Override
        public int update(J34SiscomexTipoDocumento j34SiscomexTipoDocumento) {
                return super.doUpdate(j34SiscomexTipoDocumento);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @return
         */
        @Override
        public int delete( String codigo ) {
                J34SiscomexTipoDocumento j34SiscomexTipoDocumento = newInstanceWithPrimaryKey( codigo ) ;
                return super.doDelete(j34SiscomexTipoDocumento);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexTipoDocumento
         * @return
         */
        @Override
        public int delete( J34SiscomexTipoDocumento j34SiscomexTipoDocumento ) {
                return super.doDelete(j34SiscomexTipoDocumento);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @return
         */
        @Override
        public boolean exists( String codigo ) {
                J34SiscomexTipoDocumento j34SiscomexTipoDocumento = newInstanceWithPrimaryKey( codigo ) ;
                return super.doExists(j34SiscomexTipoDocumento);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexTipoDocumento
         * @return
         */
        @Override
        public boolean exists( J34SiscomexTipoDocumento j34SiscomexTipoDocumento ) {
                return super.doExists(j34SiscomexTipoDocumento);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexTipoDocumento j34SiscomexTipoDocumento) throws SQLException {
                
                setRawParameter(list,j34SiscomexTipoDocumento.getCodigo() ) ; // "codigo" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexTipoDocumento populateBean(Cursor c, J34SiscomexTipoDocumento j34SiscomexTipoDocumento) throws SQLException {

               
                j34SiscomexTipoDocumento.setCodigo(c.getString(c.getColumnIndex("codigo"))); // java.lang.String
                j34SiscomexTipoDocumento.setSigla(c.getString(c.getColumnIndex("sigla"))); // java.lang.String
                j34SiscomexTipoDocumento.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                j34SiscomexTipoDocumento.setMaritima(c.getString(c.getColumnIndex("maritima"))); // java.lang.String
                j34SiscomexTipoDocumento.setFluvia(c.getString(c.getColumnIndex("fluvia"))); // java.lang.String
                j34SiscomexTipoDocumento.setAerea(c.getString(c.getColumnIndex("aerea"))); // java.lang.String
                j34SiscomexTipoDocumento.setRodoviaria(c.getString(c.getColumnIndex("rodoviaria"))); // java.lang.String
                j34SiscomexTipoDocumento.setFerroviaria(c.getString(c.getColumnIndex("ferroviaria"))); // java.lang.String
                j34SiscomexTipoDocumento.setPostal(c.getString(c.getColumnIndex("postal"))); // java.lang.String
                j34SiscomexTipoDocumento.setLacustre(c.getString(c.getColumnIndex("lacustre"))); // java.lang.String
                return j34SiscomexTipoDocumento ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexTipoDocumento j34SiscomexTipoDocumento) throws SQLException {

                
                setValue(ps, i++, j34SiscomexTipoDocumento.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexTipoDocumento.getSigla() ) ; // "sigla" : java.lang.String
                setValue(ps, i++, j34SiscomexTipoDocumento.getDescricao() ) ; // "descricao" : java.lang.String
                setValue(ps, i++, j34SiscomexTipoDocumento.getMaritima() ) ; // "maritima" : java.lang.String
                setValue(ps, i++, j34SiscomexTipoDocumento.getFluvia() ) ; // "fluvia" : java.lang.String
                setValue(ps, i++, j34SiscomexTipoDocumento.getAerea() ) ; // "aerea" : java.lang.String
                setValue(ps, i++, j34SiscomexTipoDocumento.getRodoviaria() ) ; // "rodoviaria" : java.lang.String
                setValue(ps, i++, j34SiscomexTipoDocumento.getFerroviaria() ) ; // "ferroviaria" : java.lang.String
                setValue(ps, i++, j34SiscomexTipoDocumento.getPostal() ) ; // "postal" : java.lang.String
                setValue(ps, i++, j34SiscomexTipoDocumento.getLacustre() ) ; // "lacustre" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexTipoDocumento j34SiscomexTipoDocumento) throws SQLException {

                
                setValue(ps, i++, j34SiscomexTipoDocumento.getSigla() ) ; // "sigla" : java.lang.String
                setValue(ps, i++, j34SiscomexTipoDocumento.getDescricao() ) ; // "descricao" : java.lang.String
                setValue(ps, i++, j34SiscomexTipoDocumento.getMaritima() ) ; // "maritima" : java.lang.String
                setValue(ps, i++, j34SiscomexTipoDocumento.getFluvia() ) ; // "fluvia" : java.lang.String
                setValue(ps, i++, j34SiscomexTipoDocumento.getAerea() ) ; // "aerea" : java.lang.String
                setValue(ps, i++, j34SiscomexTipoDocumento.getRodoviaria() ) ; // "rodoviaria" : java.lang.String
                setValue(ps, i++, j34SiscomexTipoDocumento.getFerroviaria() ) ; // "ferroviaria" : java.lang.String
                setValue(ps, i++, j34SiscomexTipoDocumento.getPostal() ) ; // "postal" : java.lang.String
                setValue(ps, i++, j34SiscomexTipoDocumento.getLacustre() ) ; // "lacustre" : java.lang.String
                
                setValue(ps, i++, j34SiscomexTipoDocumento.getCodigo() ) ; // "codigo" : java.lang.String
        }

}
