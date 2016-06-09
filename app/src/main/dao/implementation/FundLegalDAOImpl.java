package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.FundLegalDAO;
import br.com.bandoni.dao.tables.J34SiscomexFundLegal;

/**
 * J34SiscomexFundLegal: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class FundLegalDAOImpl extends GenericDAO<J34SiscomexFundLegal> implements FundLegalDAO {

        private final static String SQL_SELECT = 
                "select codigo, descricao, reg_tribut_1, reg_tribut_2, reg_tribut_3, reg_tribut_4 from j34_siscomex_fund_legal where codigo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_fund_legal ( codigo, descricao, reg_tribut_1, reg_tribut_2, reg_tribut_3, reg_tribut_4 ) values ( ?, ?, ?, ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_fund_legal set descricao = ?, reg_tribut_1 = ?, reg_tribut_2 = ?, reg_tribut_3 = ?, reg_tribut_4 = ? where codigo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_fund_legal where codigo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_fund_legal";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_fund_legal where codigo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public FundLegalDAOImpl(Context context)
        {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @return A nova inst�ncia
         */
        private J34SiscomexFundLegal newInstanceWithPrimaryKey( String codigo )
        {
                J34SiscomexFundLegal j34SiscomexFundLegal = new J34SiscomexFundLegal();
                j34SiscomexFundLegal.setCodigo( codigo );
                return j34SiscomexFundLegal ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexFundLegal find( String codigo )
        {
                J34SiscomexFundLegal j34SiscomexFundLegal = newInstanceWithPrimaryKey( codigo ) ;
                if ( super.doSelect(j34SiscomexFundLegal) )
                {
                        return j34SiscomexFundLegal ;
                }
                else
                {
                        return null ; // Not found
                }
        }
        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexFundLegal
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexFundLegal j34SiscomexFundLegal )
        {
                return super.doSelect(j34SiscomexFundLegal) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexFundLegal
         */
        @Override
        public void insert(J34SiscomexFundLegal j34SiscomexFundLegal)
        {
                super.doInsert(j34SiscomexFundLegal);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexFundLegal
         * @return
         */
        @Override
        public int update(J34SiscomexFundLegal j34SiscomexFundLegal)
        {
                return super.doUpdate(j34SiscomexFundLegal);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @return
         */
        @Override
        public int delete( String codigo )
        {
                J34SiscomexFundLegal j34SiscomexFundLegal = newInstanceWithPrimaryKey( codigo ) ;
                return super.doDelete(j34SiscomexFundLegal);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexFundLegal
         * @return
         */
        @Override
        public int delete( J34SiscomexFundLegal j34SiscomexFundLegal )
        {
                return super.doDelete(j34SiscomexFundLegal);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @return
         */
        @Override
        public boolean exists( String codigo )
        {
                J34SiscomexFundLegal j34SiscomexFundLegal = newInstanceWithPrimaryKey( codigo ) ;
                return super.doExists(j34SiscomexFundLegal);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexFundLegal
         * @return
         */
        @Override
        public boolean exists( J34SiscomexFundLegal j34SiscomexFundLegal )
        {
                return super.doExists(j34SiscomexFundLegal);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexFundLegal j34SiscomexFundLegal) throws SQLException {
                
                setRawParameter(list,  j34SiscomexFundLegal.getCodigo() ) ; // "codigo" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexFundLegal populateBean(Cursor c, J34SiscomexFundLegal j34SiscomexFundLegal) throws SQLException {

               
                j34SiscomexFundLegal.setCodigo(c.getString(c.getColumnIndex("codigo"))); // java.lang.String
                j34SiscomexFundLegal.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                j34SiscomexFundLegal.setReg_tribut_1(c.getInt(c.getColumnIndex("reg_tribut_1"))); // java.lang.Integer
                j34SiscomexFundLegal.setReg_tribut_2(c.getInt(c.getColumnIndex("reg_tribut_2"))); // java.lang.Integer
                j34SiscomexFundLegal.setReg_tribut_3(c.getInt(c.getColumnIndex("reg_tribut_3"))); // java.lang.Integer
                j34SiscomexFundLegal.setReg_tribut_4(c.getInt(c.getColumnIndex("reg_tribut_4"))); // java.lang.Integer
                return j34SiscomexFundLegal ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexFundLegal j34SiscomexFundLegal) throws SQLException {

                
                setValue(ps, i++, j34SiscomexFundLegal.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexFundLegal.getDescricao() ) ; // "descricao" : java.lang.String
                setValue(ps, i++, j34SiscomexFundLegal.getReg_tribut_1() ) ; // "reg_tribut_1" : java.lang.Integer
                setValue(ps, i++, j34SiscomexFundLegal.getReg_tribut_2() ) ; // "reg_tribut_2" : java.lang.Integer
                setValue(ps, i++, j34SiscomexFundLegal.getReg_tribut_3() ) ; // "reg_tribut_3" : java.lang.Integer
                setValue(ps, i++, j34SiscomexFundLegal.getReg_tribut_4() ) ; // "reg_tribut_4" : java.lang.Integer
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexFundLegal j34SiscomexFundLegal) throws SQLException {

                
                setValue(ps, i++, j34SiscomexFundLegal.getDescricao() ) ; // "descricao" : java.lang.String
                setValue(ps, i++, j34SiscomexFundLegal.getReg_tribut_1() ) ; // "reg_tribut_1" : java.lang.Integer
                setValue(ps, i++, j34SiscomexFundLegal.getReg_tribut_2() ) ; // "reg_tribut_2" : java.lang.Integer
                setValue(ps, i++, j34SiscomexFundLegal.getReg_tribut_3() ) ; // "reg_tribut_3" : java.lang.Integer
                setValue(ps, i++, j34SiscomexFundLegal.getReg_tribut_4() ) ; // "reg_tribut_4" : java.lang.Integer
                
                setValue(ps, i++, j34SiscomexFundLegal.getCodigo() ) ; // "codigo" : java.lang.String
        }

}
