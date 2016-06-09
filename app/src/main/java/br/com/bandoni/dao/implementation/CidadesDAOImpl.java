package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.CidadesDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexCidades;

/**
 * J34SiscomexCidades: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class CidadesDAOImpl extends GenericDAO<J34SiscomexCidades> implements CidadesDAO {

        private final static String SQL_SELECT = 
                "select estado, codmun, nome,estado_id from j34_siscomex_cidades where estado = ? and codmun = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_cidades ( estado, codmun, nome,estado_id ) values ( ?, ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_cidades set estado = ?, nome = ?,estado_id = ? where estado = ? and codmun = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_cidades where estado = ? and codmun = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_cidades";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_cidades where codmun = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public CidadesDAOImpl(Context context)
        {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codmun;
         * @return A nova inst�ncia
         */
        private J34SiscomexCidades newInstanceWithPrimaryKey(String estado, String codmun )
        {
                J34SiscomexCidades j34SiscomexCidades = new J34SiscomexCidades();
                j34SiscomexCidades.setEstado( estado );
                j34SiscomexCidades.setCodmun( codmun );
                return j34SiscomexCidades ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codmun;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexCidades find(String estado, String codmun )
        {
                J34SiscomexCidades j34SiscomexCidades = newInstanceWithPrimaryKey(estado,codmun ) ;
                if ( super.doSelect(j34SiscomexCidades) )
                {
                        return j34SiscomexCidades ;
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
         * @param j34SiscomexCidades
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexCidades j34SiscomexCidades )
        {
                return super.doSelect(j34SiscomexCidades) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexCidades
         */
        @Override
        public void insert(J34SiscomexCidades j34SiscomexCidades)
        {
                super.doInsert(j34SiscomexCidades);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexCidades
         * @return
         */
        @Override
        public int update(J34SiscomexCidades j34SiscomexCidades)
        {
                return super.doUpdate(j34SiscomexCidades);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codmun;
         * @return
         */
        @Override
        public int delete(String estado, String codmun )
        {
                J34SiscomexCidades j34SiscomexCidades = newInstanceWithPrimaryKey(estado, codmun ) ;
                return super.doDelete(j34SiscomexCidades);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexCidades
         * @return
         */
        @Override
        public int delete( J34SiscomexCidades j34SiscomexCidades )
        {
                return super.doDelete(j34SiscomexCidades);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codmun;
         * @return
         */
        @Override
        public boolean exists(String estado, String codmun )
        {
                J34SiscomexCidades j34SiscomexCidades = newInstanceWithPrimaryKey(estado, codmun ) ;
                return super.doExists(j34SiscomexCidades);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexCidades
         * @return
         */
        @Override
        public boolean exists( J34SiscomexCidades j34SiscomexCidades )
        {
                return super.doExists(j34SiscomexCidades);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexCidades j34SiscomexCidades) throws SQLException {
                
                setRawParameter(list,j34SiscomexCidades.getCodmun() ) ; // "codmun" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexCidades populateBean(Cursor c, J34SiscomexCidades j34SiscomexCidades) throws SQLException {

               
                j34SiscomexCidades.setEstado(c.getString(c.getColumnIndex("estado"))); // java.lang.String
                j34SiscomexCidades.setCodmun(c.getString(c.getColumnIndex("codmun"))); // java.lang.String
                j34SiscomexCidades.setNome(c.getString(c.getColumnIndex("nome"))); // java.lang.String
                j34SiscomexCidades.setEstado_id(c.getString(c.getColumnIndex("estado_id"))); // java.lang.String
                return j34SiscomexCidades ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexCidades j34SiscomexCidades) throws SQLException {

                
                setValue(ps, i++, j34SiscomexCidades.getEstado() ) ; // "estado" : java.lang.String
                setValue(ps, i++, j34SiscomexCidades.getCodmun() ) ; // "codmun" : java.lang.String
                setValue(ps, i++, j34SiscomexCidades.getNome() ) ; // "nome" : java.lang.String
                setValue(ps, i++, j34SiscomexCidades.getEstado_id() ) ; // "estado_id" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexCidades j34SiscomexCidades) throws SQLException {

                
                setValue(ps, i++, j34SiscomexCidades.getEstado() ) ; // "estado" : java.lang.String
                setValue(ps, i++, j34SiscomexCidades.getNome() ) ; // "nome" : java.lang.String
                setValue(ps, i++, j34SiscomexCidades.getEstado_id() ) ; // "estado_id" : java.lang.String

                setValue(ps, i++, j34SiscomexCidades.getCodmun() ) ; // "codmun" : java.lang.String
        }

}
