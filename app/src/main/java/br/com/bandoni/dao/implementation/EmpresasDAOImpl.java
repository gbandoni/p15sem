package br.com.bandoni.dao.implementation;

import android.content.Context;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.EmpresasDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexEmpresas;

/**
 * J34SiscomexEmpresas: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class EmpresasDAOImpl extends GenericDAO<J34SiscomexEmpresas> implements EmpresasDAO {

        private final static String SQL_SELECT = 
                "select codigo, tipopesssoa, razaosocial, telefone, endereco, numero, complemento, bairro, municipio, estado, cep, pais, email,municipioex,estadoex,cnpj from j34_siscomex_empresas where codigo = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_empresas ( codigo, tipopesssoa, razaosocial, telefone, endereco, numero, complemento, bairro, municipio, estado, cep, pais, email,municipioex,estadoex,cnpj) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_empresas set tipopesssoa = ?, razaosocial = ?, telefone = ?, endereco = ?, numero = ?, complemento = ?, bairro = ?, municipio = ?, estado = ?, cep = ?, pais = ?, email = ?, municipioex = ?,estadoex = ?,cnpj = ? where codigo = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_empresas where codigo = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_empresas";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_empresas where codigo = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public EmpresasDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param codigo;
         * @return A nova inst�ncia
         */
        private J34SiscomexEmpresas newInstanceWithPrimaryKey( Integer codigo ) {
                J34SiscomexEmpresas j34SiscomexEmpresas = new J34SiscomexEmpresas();
                j34SiscomexEmpresas.setCodigo( codigo );
                return j34SiscomexEmpresas ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexEmpresas find( Integer codigo ) {
                J34SiscomexEmpresas j34SiscomexEmpresas = newInstanceWithPrimaryKey( codigo ) ;
                if ( super.doSelect(j34SiscomexEmpresas) ) {
                        return j34SiscomexEmpresas ;
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
         * @param j34SiscomexEmpresas
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexEmpresas j34SiscomexEmpresas ) {
                return super.doSelect(j34SiscomexEmpresas) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexEmpresas
         */
        @Override
        public void insert(J34SiscomexEmpresas j34SiscomexEmpresas) {
                super.doInsert(j34SiscomexEmpresas);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexEmpresas
         * @return
         */
        @Override
        public int update(J34SiscomexEmpresas j34SiscomexEmpresas) {
                return super.doUpdate(j34SiscomexEmpresas);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo;
         * @return
         */
        @Override
        public int delete( Integer codigo ) {
                J34SiscomexEmpresas j34SiscomexEmpresas = newInstanceWithPrimaryKey( codigo ) ;
                return super.doDelete(j34SiscomexEmpresas);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexEmpresas
         * @return
         */
        @Override
        public int delete( J34SiscomexEmpresas j34SiscomexEmpresas ) {
                return super.doDelete(j34SiscomexEmpresas);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo;
         * @return
         */
        @Override
        public boolean exists( Integer codigo ) {
                J34SiscomexEmpresas j34SiscomexEmpresas = newInstanceWithPrimaryKey( codigo ) ;
                return super.doExists(j34SiscomexEmpresas);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexEmpresas
         * @return
         */
        @Override
        public boolean exists( J34SiscomexEmpresas j34SiscomexEmpresas ) {
                return super.doExists(j34SiscomexEmpresas);
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
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexEmpresas j34SiscomexEmpresas) throws SQLException {
                
                setRawParameter(list, j34SiscomexEmpresas.getCodigo()) ; // "codigo" : java.lang.Integer
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexEmpresas populateBean(Cursor c, J34SiscomexEmpresas j34SiscomexEmpresas) throws SQLException {

               
                j34SiscomexEmpresas.setCodigo(c.getInt(c.getColumnIndex("codigo"))); // java.lang.Integer
                j34SiscomexEmpresas.setTipopesssoa(c.getString(c.getColumnIndex("tipopesssoa"))); // java.lang.String
                j34SiscomexEmpresas.setRazaosocial(c.getString(c.getColumnIndex("razaosocial"))); // java.lang.String
                j34SiscomexEmpresas.setTelefone(c.getString(c.getColumnIndex("telefone"))); // java.lang.String
                j34SiscomexEmpresas.setEndereco(c.getString(c.getColumnIndex("endereco"))); // java.lang.String
                j34SiscomexEmpresas.setNumero(c.getString(c.getColumnIndex("numero"))); // java.lang.String
                j34SiscomexEmpresas.setComplemento(c.getString(c.getColumnIndex("complemento"))); // java.lang.String
                j34SiscomexEmpresas.setBairro(c.getString(c.getColumnIndex("bairro"))); // java.lang.String
                j34SiscomexEmpresas.setMunicipio(c.getString(c.getColumnIndex("municipio"))); // java.lang.String
                j34SiscomexEmpresas.setEstado(c.getString(c.getColumnIndex("estado"))); // java.lang.String
                j34SiscomexEmpresas.setCep(c.getString(c.getColumnIndex("cep"))); // java.lang.String
                j34SiscomexEmpresas.setPais(c.getString(c.getColumnIndex("pais"))); // java.lang.String
                j34SiscomexEmpresas.setMunicipioex(c.getString(c.getColumnIndex("municipioex"))); // java.lang.String
                j34SiscomexEmpresas.setEstadoex(c.getString(c.getColumnIndex("estadoex"))); // java.lang.String
                j34SiscomexEmpresas.setCnpj(c.getString(c.getColumnIndex("cnpj"))); // java.lang.String
                return j34SiscomexEmpresas ;
        }
    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexEmpresas j34SiscomexEmpresas) throws SQLException {

                
                setValue(ps, i++, j34SiscomexEmpresas.getCodigo() ) ; // "codigo" : java.lang.Integer
                setValue(ps, i++, j34SiscomexEmpresas.getTipopesssoa() ) ; // "tipopesssoa" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getRazaosocial() ) ; // "razaosocial" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getTelefone() ) ; // "telefone" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getEndereco() ) ; // "endereco" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getNumero() ) ; // "numero" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getComplemento() ) ; // "complemento" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getBairro() ) ; // "bairro" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getMunicipio() ) ; // "municipio" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getEstado() ) ; // "estado" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getCep() ) ; // "cep" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getPais() ) ; // "pais" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getEmail() ) ; // "email" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getMunicipioex() ) ; // "municipioEX" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getEstadoex() ) ; // "estadoEx" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getCnpj()) ; // "cnpj" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexEmpresas j34SiscomexEmpresas) throws SQLException {

                
                setValue(ps, i++, j34SiscomexEmpresas.getTipopesssoa() ) ; // "tipopesssoa" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getRazaosocial() ) ; // "razaosocial" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getTelefone() ) ; // "telefone" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getEndereco() ) ; // "endereco" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getNumero() ) ; // "numero" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getComplemento() ) ; // "complemento" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getBairro() ) ; // "bairro" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getMunicipio() ) ; // "municipio" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getEstado() ) ; // "estado" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getCep() ) ; // "cep" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getPais() ) ; // "pais" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getEmail() ) ; // "email" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getMunicipioex() ) ; // "municipioEX" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getEstadoex() ) ; // "estadoEx" : java.lang.String
                setValue(ps, i++, j34SiscomexEmpresas.getCnpj()) ; // "cnpj" : java.lang.String                
                setValue(ps, i++, j34SiscomexEmpresas.getCodigo() ) ; // "codigo" : java.lang.Integer
        }

}
