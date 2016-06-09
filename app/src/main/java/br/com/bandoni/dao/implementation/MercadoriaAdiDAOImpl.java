package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.MercadoriaAdiDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexMercadoriaAdi;

/**
 * J34SiscomexMercadoriaAdi: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class MercadoriaAdiDAOImpl extends GenericDAO<J34SiscomexMercadoriaAdi> implements MercadoriaAdiDAO {

        private final static String SQL_SELECT = 
                "select numerodocumentocarga, numeroadicao, nomeunidademedidacomercializada, quantidademercadoriaunidadecomercializada, textodetalhamentomercadoria, valorunidadelocalembarque, valorunidademedidacondicaovenda from j34_siscomex_mercadoria_adi where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_mercadoria_adi ( numerodocumentocarga, numeroadicao, nomeunidademedidacomercializada, quantidademercadoriaunidadecomercializada, textodetalhamentomercadoria, valorunidadelocalembarque, valorunidademedidacondicaovenda ) values ( ?, ?, ?, ?, ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_mercadoria_adi set nomeunidademedidacomercializada = ?, quantidademercadoriaunidadecomercializada = ?, textodetalhamentomercadoria = ?, valorunidadelocalembarque = ?, valorunidademedidacondicaovenda = ? where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_mercadoria_adi where numerodocumentocarga = ? and numeroadicao = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_mercadoria_adi";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_mercadoria_adi where numerodocumentocarga = ? and numeroadicao = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public MercadoriaAdiDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @return A nova inst�ncia
         */
        private J34SiscomexMercadoriaAdi newInstanceWithPrimaryKey( String numerodocumentocarga, String numeroadicao ) {
                J34SiscomexMercadoriaAdi j34SiscomexMercadoriaAdi = new J34SiscomexMercadoriaAdi();
                j34SiscomexMercadoriaAdi.setNumerodocumentocarga( numerodocumentocarga );
                j34SiscomexMercadoriaAdi.setNumeroadicao( numeroadicao );
                return j34SiscomexMercadoriaAdi ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga;
         * @param numeroadicao;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexMercadoriaAdi find( String numerodocumentocarga, String numeroadicao ) {
                J34SiscomexMercadoriaAdi j34SiscomexMercadoriaAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                if ( super.doSelect(j34SiscomexMercadoriaAdi) ) {
                        return j34SiscomexMercadoriaAdi ;
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
         * @param j34SiscomexMercadoriaAdi
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexMercadoriaAdi j34SiscomexMercadoriaAdi ) {
                return super.doSelect(j34SiscomexMercadoriaAdi) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexMercadoriaAdi
         */
        @Override
        public void insert(J34SiscomexMercadoriaAdi j34SiscomexMercadoriaAdi) {
                super.doInsert(j34SiscomexMercadoriaAdi);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexMercadoriaAdi
         * @return
         */
        @Override
        public int update(J34SiscomexMercadoriaAdi j34SiscomexMercadoriaAdi) {
                return super.doUpdate(j34SiscomexMercadoriaAdi);
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
                J34SiscomexMercadoriaAdi j34SiscomexMercadoriaAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                return super.doDelete(j34SiscomexMercadoriaAdi);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexMercadoriaAdi
         * @return
         */
        @Override
        public int delete( J34SiscomexMercadoriaAdi j34SiscomexMercadoriaAdi ) {
                return super.doDelete(j34SiscomexMercadoriaAdi);
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
                J34SiscomexMercadoriaAdi j34SiscomexMercadoriaAdi = newInstanceWithPrimaryKey( numerodocumentocarga, numeroadicao ) ;
                return super.doExists(j34SiscomexMercadoriaAdi);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexMercadoriaAdi
         * @return
         */
        @Override
        public boolean exists( J34SiscomexMercadoriaAdi j34SiscomexMercadoriaAdi ) {
                return super.doExists(j34SiscomexMercadoriaAdi);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexMercadoriaAdi j34SiscomexMercadoriaAdi) throws SQLException {
                
                setRawParameter(list, j34SiscomexMercadoriaAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setRawParameter(list, j34SiscomexMercadoriaAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexMercadoriaAdi populateBean(Cursor c, J34SiscomexMercadoriaAdi j34SiscomexMercadoriaAdi) throws SQLException {

               
                j34SiscomexMercadoriaAdi.setNumerodocumentocarga(c.getString(c.getColumnIndex("numerodocumentocarga"))); // java.lang.String
                j34SiscomexMercadoriaAdi.setNumeroadicao(c.getString(c.getColumnIndex("numeroadicao"))); // java.lang.String
                j34SiscomexMercadoriaAdi.setNomeunidademedidacomercializada(c.getString(c.getColumnIndex("nomeunidademedidacomercializada"))); // java.lang.String
                j34SiscomexMercadoriaAdi.setQuantidademercadoriaunidadecomercializada(c.getFloat(c.getColumnIndex("quantidademercadoriaunidadecomercializada"))); // java.math.BigDecimal
                j34SiscomexMercadoriaAdi.setTextodetalhamentomercadoria(c.getString(c.getColumnIndex("textodetalhamentomercadoria"))); // java.lang.String
                j34SiscomexMercadoriaAdi.setValorunidadelocalembarque(c.getFloat(c.getColumnIndex("valorunidadelocalembarque"))); // java.math.BigDecimal
                j34SiscomexMercadoriaAdi.setValorunidademedidacondicaovenda(c.getFloat(c.getColumnIndex("valorunidademedidacondicaovenda"))); // java.math.BigDecimal
                return j34SiscomexMercadoriaAdi ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexMercadoriaAdi j34SiscomexMercadoriaAdi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexMercadoriaAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexMercadoriaAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
                setValue(ps, i++, j34SiscomexMercadoriaAdi.getNomeunidademedidacomercializada() ) ; // "nomeunidademedidacomercializada" : java.lang.String
                setValue(ps, i++, j34SiscomexMercadoriaAdi.getQuantidademercadoriaunidadecomercializada() ) ; // "quantidademercadoriaunidadecomercializada" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexMercadoriaAdi.getTextodetalhamentomercadoria() ) ; // "textodetalhamentomercadoria" : java.lang.String
                setValue(ps, i++, j34SiscomexMercadoriaAdi.getValorunidadelocalembarque() ) ; // "valorunidadelocalembarque" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexMercadoriaAdi.getValorunidademedidacondicaovenda() ) ; // "valorunidademedidacondicaovenda" : java.math.BigDecimal
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexMercadoriaAdi j34SiscomexMercadoriaAdi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexMercadoriaAdi.getNomeunidademedidacomercializada() ) ; // "nomeunidademedidacomercializada" : java.lang.String
                setValue(ps, i++, j34SiscomexMercadoriaAdi.getQuantidademercadoriaunidadecomercializada() ) ; // "quantidademercadoriaunidadecomercializada" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexMercadoriaAdi.getTextodetalhamentomercadoria() ) ; // "textodetalhamentomercadoria" : java.lang.String
                setValue(ps, i++, j34SiscomexMercadoriaAdi.getValorunidadelocalembarque() ) ; // "valorunidadelocalembarque" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexMercadoriaAdi.getValorunidademedidacondicaovenda() ) ; // "valorunidademedidacondicaovenda" : java.math.BigDecimal
                
                setValue(ps, i++, j34SiscomexMercadoriaAdi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexMercadoriaAdi.getNumeroadicao() ) ; // "numeroadicao" : java.lang.String
        }

}
