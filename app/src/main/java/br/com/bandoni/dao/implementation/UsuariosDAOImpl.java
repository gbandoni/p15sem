package br.com.bandoni.dao.implementation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.sql.SQLException;
import java.util.List;

import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.interfaces.UsuariosDAO;
import br.com.bandoni.dao.tables.J34SiscomexUsuarios;

/**
 * J34SiscomexUsuarios: implementa��o do DAO
 *
 * @author Gustavo Bandoni da Silva
 */
public class UsuariosDAOImpl extends GenericDAO<J34SiscomexUsuarios> implements UsuariosDAO
{

    private final static String SQL_SELECT =
            "select usu_codigo, descricao from j34_siscomex_usuarios where usu_codigo = ?";

    private final static String SQL_INSERT =
            "insert into j34_siscomex_usuarios (usu_codigo,usu_nome,usu_login,usu_senha,usu_adm) values ( ?, ?, ?, ? ,?)";

    private final static String SQL_UPDATE =
            "update j34_siscomex_usuarios set usu_nome= ?,usu_login= ?,usu_senha= ?,usu_adm = ? where usu_codigo = ?";

    private final static String SQL_DELETE =
            "delete from j34_siscomex_usuarios where usu_codigo = ?";

    private final static String SQL_COUNT_ALL =
            "select count(*) from j34_siscomex_valor_aduaneira";

    private final static String SQL_COUNT =
            "select count(*) from j34_siscomex_valor_aduaneira where usu_codigo = ?";

    //----------------------------------------------------------------------

    /**
     * Construtor do DAO
     */
    public UsuariosDAOImpl(Context context)
    {
        super(context);
    }

    //----------------------------------------------------------------------

    /**
     * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
     *
     * @param usu_codigo;
     * @return A nova inst�ncia
     */
    private J34SiscomexUsuarios newInstanceWithPrimaryKey(Integer usu_codigo)
    {
        J34SiscomexUsuarios j34SiscomexValorAduaneira = new J34SiscomexUsuarios();
        j34SiscomexValorAduaneira.setUsu_codigo(usu_codigo);
        return j34SiscomexValorAduaneira;
    }

    //----------------------------------------------------------------------


    /**
     * Acha um registro pela chave prim�ria
     *
     * @param usu_codigo;
     * @return O registro procurado ou NULL caso n�o seja
     */
    @Override
    public J34SiscomexUsuarios find(Integer usu_codigo)
    {
        J34SiscomexUsuarios j34SiscomexValorAduaneira = newInstanceWithPrimaryKey(usu_codigo);
        if (super.doSelect(j34SiscomexValorAduaneira))
        {
            return j34SiscomexValorAduaneira;
        }
        else
        {
            return null; // Not found
        }
    }
    //----------------------------------------------------------------------

    /**
     * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
     * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
     * Caso n�o ache fica como est�
     *
     * @param j34SiscomexValorAduaneira
     * @return True se encontrado , false caso nao seja encontrado
     */
    @Override
    public boolean load(J34SiscomexUsuarios j34SiscomexValorAduaneira)
    {
        return super.doSelect(j34SiscomexValorAduaneira);
    }
    //----------------------------------------------------------------------

    /**
     * Insere o objeto no banco de dados
     *
     * @param j34SiscomexValorAduaneira
     */
    @Override
    public void insert(J34SiscomexUsuarios j34SiscomexValorAduaneira)
    {
        super.doInsert(j34SiscomexValorAduaneira);
    }

    //----------------------------------------------------------------------

    /**
     * Atualiza o objeto no banco de dados
     *
     * @param j34SiscomexValorAduaneira
     * @return
     */
    @Override
    public int update(J34SiscomexUsuarios j34SiscomexValorAduaneira)
    {
        return super.doUpdate(j34SiscomexValorAduaneira);
    }

    //----------------------------------------------------------------------

    /**
     * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria
     *
     * @param usu_codigo;
     * @return
     */
    @Override
    public int delete(Integer usu_codigo)
    {
        J34SiscomexUsuarios j34SiscomexValorAduaneira = newInstanceWithPrimaryKey(usu_codigo);
        return super.doDelete(j34SiscomexValorAduaneira);
    }

    //----------------------------------------------------------------------

    /**
     * Remove o objeto fornecido do banco de dados
     *
     * @param j34SiscomexValorAduaneira
     * @return
     */
    @Override
    public int delete(J34SiscomexUsuarios j34SiscomexValorAduaneira)
    {
        return super.doDelete(j34SiscomexValorAduaneira);
    }

    //----------------------------------------------------------------------

    /**
     * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
     *
     * @param usu_codigo;
     * @return
     */
    @Override
    public boolean exists(Integer usu_codigo)
    {
        J34SiscomexUsuarios j34SiscomexValorAduaneira = newInstanceWithPrimaryKey(usu_codigo);
        return super.doExists(j34SiscomexValorAduaneira);
    }
    //----------------------------------------------------------------------

    /**
     * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
     *
     * @param j34SiscomexValorAduaneira
     * @return
     */
    @Override
    public boolean exists(J34SiscomexUsuarios j34SiscomexValorAduaneira)
    {
        return super.doExists(j34SiscomexValorAduaneira);
    }

    //----------------------------------------------------------------------

    /**
     * retorna o total de registros na tabela
     *
     * @return
     */
    @Override
    public long count()
    {
        return super.doCountAll();
    }

    //----------------------------------------------------------------------
    @Override
    protected String getSqlSelect()
    {
        return SQL_SELECT;
    }

    //----------------------------------------------------------------------
    @Override
    protected String getSqlInsert()
    {
        return SQL_INSERT;
    }

    //----------------------------------------------------------------------
    @Override
    protected String getSqlUpdate()
    {
        return SQL_UPDATE;
    }

    //----------------------------------------------------------------------
    @Override
    protected String getSqlDelete()
    {
        return SQL_DELETE;
    }

    //----------------------------------------------------------------------
    @Override
    protected String getSqlCount()
    {
        return SQL_COUNT;
    }

    //----------------------------------------------------------------------
    @Override
    protected String getSqlCountAll()
    {
        return SQL_COUNT_ALL;
    }

    //----------------------------------------------------------------------
    @Override
    protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexUsuarios j34SiscomexValorAduaneira) throws SQLException
    {

        setRawParameter(list, j34SiscomexValorAduaneira.getUsu_codigo()); // "usu_codigo" : java.lang.String
    }

    //----------------------------------------------------------------------
    @Override
    protected J34SiscomexUsuarios populateBean(Cursor c, J34SiscomexUsuarios j34SiscomexValorAduaneira) throws SQLException
    {

        j34SiscomexValorAduaneira.setUsu_codigo(c.getInt(c.getColumnIndex("usu_codigo"))); // java.lang.int
        j34SiscomexValorAduaneira.setUsu_nome(c.getString(c.getColumnIndex("usu_nome"))); // java.lang.String
        j34SiscomexValorAduaneira.setUsu_login(c.getString(c.getColumnIndex("usu_login"))); // java.lang.String
        j34SiscomexValorAduaneira.setUsu_senha(c.getString(c.getColumnIndex("usu_senha"))); // java.lang.String
        j34SiscomexValorAduaneira.setUsu_adm(c.getInt(c.getColumnIndex("usu_adm"))); // java.lang.int
        return j34SiscomexValorAduaneira;
    }

    //----------------------------------------------------------------------
    @Override
    protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexUsuarios j34SiscomexValorAduaneira) throws SQLException
    {
        setValue(ps, i++, j34SiscomexValorAduaneira.getUsu_codigo()); // java.lang.int
        setValue(ps, i++, j34SiscomexValorAduaneira.getUsu_nome()); // java.lang.String
        setValue(ps, i++, j34SiscomexValorAduaneira.getUsu_login()); // java.lang.String
        setValue(ps, i++, j34SiscomexValorAduaneira.getUsu_senha()); // java.lang.String
        setValue(ps, i++, j34SiscomexValorAduaneira.getUsu_adm()); // java.lang.int
    }

    //----------------------------------------------------------------------
    @Override
    protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexUsuarios j34SiscomexValorAduaneira) throws SQLException
    {
        setValue(ps, i++, j34SiscomexValorAduaneira.getUsu_nome()); // java.lang.String
        setValue(ps, i++, j34SiscomexValorAduaneira.getUsu_login()); // java.lang.String
        setValue(ps, i++, j34SiscomexValorAduaneira.getUsu_senha()); // java.lang.String
        setValue(ps, i++, j34SiscomexValorAduaneira.getUsu_adm()); // java.lang.int
        setValue(ps, i++, j34SiscomexValorAduaneira.getUsu_codigo()); // java.lang.int
    }

}
