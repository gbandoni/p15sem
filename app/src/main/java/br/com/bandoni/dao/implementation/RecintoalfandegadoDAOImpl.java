package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.RecintoalfandegadoDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexRecintoalfandegado;

/**
 * J34SiscomexRecintoalfandegado: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class RecintoalfandegadoDAOImpl extends GenericDAO<J34SiscomexRecintoalfandegado> implements RecintoalfandegadoDAO {

        private final static String SQL_SELECT = 
                "select codigo, regiao, nomeporto, estado, terminal, descricao from j34_siscomex_recintoalfandegado where codigo = ? and terminal = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_recintoalfandegado ( codigo, regiao, nomeporto, estado, terminal, descricao ) values ( ?, ?, ?, ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_recintoalfandegado set regiao = ?, nomeporto = ?, estado = ?, descricao = ? where codigo = ? and terminal = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_recintoalfandegado where codigo = ? and terminal = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_recintoalfandegado";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_recintoalfandegado where codigo = ? and terminal = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public RecintoalfandegadoDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @param terminal;
         * @return A nova inst�ncia
         */
        private J34SiscomexRecintoalfandegado newInstanceWithPrimaryKey( String codigo, String terminal ) {
                J34SiscomexRecintoalfandegado j34SiscomexRecintoalfandegado = new J34SiscomexRecintoalfandegado();
                j34SiscomexRecintoalfandegado.setCodigo( codigo );
                j34SiscomexRecintoalfandegado.setTerminal( terminal );
                return j34SiscomexRecintoalfandegado ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @param terminal;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexRecintoalfandegado find( String codigo, String terminal ) {
                J34SiscomexRecintoalfandegado j34SiscomexRecintoalfandegado = newInstanceWithPrimaryKey( codigo, terminal ) ;
                if ( super.doSelect(j34SiscomexRecintoalfandegado) ) {
                        return j34SiscomexRecintoalfandegado ;
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
         * @param j34SiscomexRecintoalfandegado
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexRecintoalfandegado j34SiscomexRecintoalfandegado ) {
                return super.doSelect(j34SiscomexRecintoalfandegado) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexRecintoalfandegado
         */
        @Override
        public void insert(J34SiscomexRecintoalfandegado j34SiscomexRecintoalfandegado) {
                super.doInsert(j34SiscomexRecintoalfandegado);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexRecintoalfandegado
         * @return
         */
        @Override
        public int update(J34SiscomexRecintoalfandegado j34SiscomexRecintoalfandegado) {
                return super.doUpdate(j34SiscomexRecintoalfandegado);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @param terminal;
         * @return
         */
        @Override
        public int delete( String codigo, String terminal ) {
                J34SiscomexRecintoalfandegado j34SiscomexRecintoalfandegado = newInstanceWithPrimaryKey( codigo, terminal ) ;
                return super.doDelete(j34SiscomexRecintoalfandegado);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexRecintoalfandegado
         * @return
         */
        @Override
        public int delete( J34SiscomexRecintoalfandegado j34SiscomexRecintoalfandegado ) {
                return super.doDelete(j34SiscomexRecintoalfandegado);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @param terminal;
         * @return
         */
        @Override
        public boolean exists( String codigo, String terminal ) {
                J34SiscomexRecintoalfandegado j34SiscomexRecintoalfandegado = newInstanceWithPrimaryKey( codigo, terminal ) ;
                return super.doExists(j34SiscomexRecintoalfandegado);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexRecintoalfandegado
         * @return
         */
        @Override
        public boolean exists( J34SiscomexRecintoalfandegado j34SiscomexRecintoalfandegado ) {
                return super.doExists(j34SiscomexRecintoalfandegado);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexRecintoalfandegado j34SiscomexRecintoalfandegado) throws SQLException {
                
                setRawParameter(list, j34SiscomexRecintoalfandegado.getCodigo() ) ; // "codigo" : java.lang.String
                setRawParameter(list, j34SiscomexRecintoalfandegado.getTerminal() ) ; // "terminal" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexRecintoalfandegado populateBean(Cursor c, J34SiscomexRecintoalfandegado j34SiscomexRecintoalfandegado) throws SQLException {

               
                j34SiscomexRecintoalfandegado.setCodigo(c.getString(c.getColumnIndex("codigo"))); // java.lang.String
                j34SiscomexRecintoalfandegado.setRegiao(c.getString(c.getColumnIndex("regiao"))); // java.lang.String
                j34SiscomexRecintoalfandegado.setNomeporto(c.getString(c.getColumnIndex("nomeporto"))); // java.lang.String
                j34SiscomexRecintoalfandegado.setEstado(c.getString(c.getColumnIndex("estado"))); // java.lang.String
                j34SiscomexRecintoalfandegado.setTerminal(c.getString(c.getColumnIndex("terminal"))); // java.lang.String
                j34SiscomexRecintoalfandegado.setDescricao(c.getString(c.getColumnIndex("descricao"))); // java.lang.String
                return j34SiscomexRecintoalfandegado ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexRecintoalfandegado j34SiscomexRecintoalfandegado) throws SQLException {

                
                setValue(ps, i++, j34SiscomexRecintoalfandegado.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexRecintoalfandegado.getRegiao() ) ; // "regiao" : java.lang.String
                setValue(ps, i++, j34SiscomexRecintoalfandegado.getNomeporto() ) ; // "nomeporto" : java.lang.String
                setValue(ps, i++, j34SiscomexRecintoalfandegado.getEstado() ) ; // "estado" : java.lang.String
                setValue(ps, i++, j34SiscomexRecintoalfandegado.getTerminal() ) ; // "terminal" : java.lang.String
                setValue(ps, i++, j34SiscomexRecintoalfandegado.getDescricao() ) ; // "descricao" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexRecintoalfandegado j34SiscomexRecintoalfandegado) throws SQLException {

                
                setValue(ps, i++, j34SiscomexRecintoalfandegado.getRegiao() ) ; // "regiao" : java.lang.String
                setValue(ps, i++, j34SiscomexRecintoalfandegado.getNomeporto() ) ; // "nomeporto" : java.lang.String
                setValue(ps, i++, j34SiscomexRecintoalfandegado.getEstado() ) ; // "estado" : java.lang.String
                setValue(ps, i++, j34SiscomexRecintoalfandegado.getDescricao() ) ; // "descricao" : java.lang.String
                
                setValue(ps, i++, j34SiscomexRecintoalfandegado.getCodigo() ) ; // "codigo" : java.lang.String
                setValue(ps, i++, j34SiscomexRecintoalfandegado.getTerminal() ) ; // "terminal" : java.lang.String
        }

}
