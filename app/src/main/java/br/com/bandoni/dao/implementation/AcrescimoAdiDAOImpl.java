package br.com.bandoni.dao.implementation;

import android.content.Context;

import java.util.List;

import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;

import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.AcrescimoAdiDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexAcrescimoAdi;

/**
 * J34SiscomexAcrescimoAdi: implementa��o do DAO
 *
 * @author Gustavo Bandoni da Silva
 */
public class AcrescimoAdiDAOImpl extends GenericDAO<J34SiscomexAcrescimoAdi> implements AcrescimoAdiDAO
{

    private final static String SQL_SELECT =
            "select numerodocumentocarga, numeroadicao, codigometodoacrescimovalor, codigomoedanegociadaacrescimo, valoracrescimomoedanacional, valoracrescimomoedanegociada from j34_siscomex_acrescimo_adi where numerodocumentocarga = ? and numeroadicao = ?";

    private final static String SQL_INSERT =
            "insert into j34_siscomex_acrescimo_adi ( numerodocumentocarga, numeroadicao, codigometodoacrescimovalor, codigomoedanegociadaacrescimo, valoracrescimomoedanacional, valoracrescimomoedanegociada ) values ( ?, ?, ?, ?, ?, ? )";

    private final static String SQL_UPDATE =
            "update j34_siscomex_acrescimo_adi set codigometodoacrescimovalor = ?, codigomoedanegociadaacrescimo = ?, valoracrescimomoedanacional = ?, valoracrescimomoedanegociada = ? where numerodocumentocarga = ? and numeroadicao = ?";

    private final static String SQL_DELETE =
            "delete from j34_siscomex_acrescimo_adi where numerodocumentocarga = ? and numeroadicao = ?";

    private final static String SQL_COUNT_ALL =
            "select count(*) from j34_siscomex_acrescimo_adi";

    private final static String SQL_COUNT =
            "select count(*) from j34_siscomex_acrescimo_adi where numerodocumentocarga = ? and numeroadicao = ?";

    //----------------------------------------------------------------------

    /**
     * Construtor do DAO
     */
    public AcrescimoAdiDAOImpl(Context context)
    {
        super(context);
    }

    //----------------------------------------------------------------------

    /**
     * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
     *
     * @param numerodocumentocarga;
     * @param numeroadicao;
     * @return A nova inst�ncia
     */
    private J34SiscomexAcrescimoAdi newInstanceWithPrimaryKey(String numerodocumentocarga, String numeroadicao)
    {
        J34SiscomexAcrescimoAdi j34SiscomexAcrescimoAdi = new J34SiscomexAcrescimoAdi();
        j34SiscomexAcrescimoAdi.setNumerodocumentocarga(numerodocumentocarga);
        j34SiscomexAcrescimoAdi.setNumeroadicao(numeroadicao);
        return j34SiscomexAcrescimoAdi;
    }

    //----------------------------------------------------------------------

    /**
     * Acha um registro pela chave prim�ria
     *
     * @param numerodocumentocarga;
     * @param numeroadicao;
     * @return O registro procurado ou NULL caso n�o seja
     */
    @Override
    public J34SiscomexAcrescimoAdi find(String numerodocumentocarga, String numeroadicao)
    {
        J34SiscomexAcrescimoAdi j34SiscomexAcrescimoAdi = newInstanceWithPrimaryKey(numerodocumentocarga, numeroadicao);
        if (super.doSelect(j34SiscomexAcrescimoAdi))
        {
            return j34SiscomexAcrescimoAdi;
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
     * @param j34SiscomexAcrescimoAdi
     * @return True se encontrado , false caso nao seja encontrado
     */
    @Override
    public boolean load(J34SiscomexAcrescimoAdi j34SiscomexAcrescimoAdi)
    {
        return super.doSelect(j34SiscomexAcrescimoAdi);
    }
    //----------------------------------------------------------------------

    /**
     * Insere o objeto no banco de dados
     *
     * @param j34SiscomexAcrescimoAdi
     */
    @Override
    public void insert(J34SiscomexAcrescimoAdi j34SiscomexAcrescimoAdi)
    {
        super.doInsert(j34SiscomexAcrescimoAdi);
    }

    //----------------------------------------------------------------------

    /**
     * Atualiza o objeto no banco de dados
     *
     * @param j34SiscomexAcrescimoAdi
     * @return
     */
    @Override
    public int update(J34SiscomexAcrescimoAdi j34SiscomexAcrescimoAdi)
    {
        return super.doUpdate(j34SiscomexAcrescimoAdi);
    }

    //----------------------------------------------------------------------

    /**
     * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria
     *
     * @param numerodocumentocarga;
     * @param numeroadicao;
     * @return
     */
    @Override
    public int delete(String numerodocumentocarga, String numeroadicao)
    {
        J34SiscomexAcrescimoAdi j34SiscomexAcrescimoAdi = newInstanceWithPrimaryKey(numerodocumentocarga, numeroadicao);
        return super.doDelete(j34SiscomexAcrescimoAdi);
    }

    //----------------------------------------------------------------------

    /**
     * Remove o objeto fornecido do banco de dados
     *
     * @param j34SiscomexAcrescimoAdi
     * @return
     */
    @Override
    public int delete(J34SiscomexAcrescimoAdi j34SiscomexAcrescimoAdi)
    {
        return super.doDelete(j34SiscomexAcrescimoAdi);
    }

    //----------------------------------------------------------------------

    /**
     * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
     *
     * @param numerodocumentocarga;
     * @param numeroadicao;
     * @return
     */
    @Override
    public boolean exists(String numerodocumentocarga, String numeroadicao)
    {
        J34SiscomexAcrescimoAdi j34SiscomexAcrescimoAdi = newInstanceWithPrimaryKey(numerodocumentocarga, numeroadicao);
        return super.doExists(j34SiscomexAcrescimoAdi);
    }
    //----------------------------------------------------------------------

    /**
     * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
     *
     * @param j34SiscomexAcrescimoAdi
     * @return
     */
    @Override
    public boolean exists(J34SiscomexAcrescimoAdi j34SiscomexAcrescimoAdi)
    {
        return super.doExists(j34SiscomexAcrescimoAdi);
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
    protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexAcrescimoAdi j34SiscomexAcrescimoAdi) throws SQLException
    {

        setRawParameter(list,j34SiscomexAcrescimoAdi.getNumerodocumentocarga()); // "numerodocumentocarga" : java.lang.String
        setRawParameter(list,j34SiscomexAcrescimoAdi.getNumeroadicao()); // "numeroadicao" : java.lang.String
    }

    //----------------------------------------------------------------------
    @Override
    protected J34SiscomexAcrescimoAdi populateBean(Cursor c, J34SiscomexAcrescimoAdi j34SiscomexAcrescimoAdi) throws SQLException
    {


        j34SiscomexAcrescimoAdi.setNumerodocumentocarga(c.getString(c.getColumnIndex("numerodocumentocarga"))); // java.lang.String
        j34SiscomexAcrescimoAdi.setNumeroadicao(c.getString(c.getColumnIndex("numeroadicao"))); // java.lang.String
        j34SiscomexAcrescimoAdi.setCodigometodoacrescimovalor(c.getString(c.getColumnIndex("codigometodoacrescimovalor"))); // java.lang.String
        j34SiscomexAcrescimoAdi.setCodigomoedanegociadaacrescimo(c.getInt(c.getColumnIndex("codigomoedanegociadaacrescimo"))); // java.lang.Integer
        // not primitive number => keep null value if any
        j34SiscomexAcrescimoAdi.setValoracrescimomoedanacional(c.getFloat(c.getColumnIndex("valoracrescimomoedanacional")));// java.math.BigDecimal
        j34SiscomexAcrescimoAdi.setValoracrescimomoedanegociada(c.getFloat(c.getColumnIndex("valoracrescimomoedanegociada")));
        // java.math.BigDecimal
        return j34SiscomexAcrescimoAdi;
    }

    //----------------------------------------------------------------------
    @Override
    protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexAcrescimoAdi j34SiscomexAcrescimoAdi) throws SQLException
    {


        setValue(ps, i++, j34SiscomexAcrescimoAdi.getNumerodocumentocarga()); // "numerodocumentocarga" : java.lang.String
        setValue(ps, i++, j34SiscomexAcrescimoAdi.getNumeroadicao()); // "numeroadicao" : java.lang.String
        setValue(ps, i++, j34SiscomexAcrescimoAdi.getCodigometodoacrescimovalor()); // "codigometodoacrescimovalor" : java.lang.String
        setValue(ps, i++, j34SiscomexAcrescimoAdi.getCodigomoedanegociadaacrescimo()); // "codigomoedanegociadaacrescimo" : java.lang.Integer
        setValue(ps, i++, j34SiscomexAcrescimoAdi.getValoracrescimomoedanacional()); // "valoracrescimomoedanacional" : java.math.BigDecimal
        setValue(ps, i++, j34SiscomexAcrescimoAdi.getValoracrescimomoedanegociada()); // "valoracrescimomoedanegociada" : java.math.BigDecimal
    }

    //----------------------------------------------------------------------
    @Override
    protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexAcrescimoAdi j34SiscomexAcrescimoAdi) throws SQLException
    {


        setValue(ps, i++, j34SiscomexAcrescimoAdi.getCodigometodoacrescimovalor()); // "codigometodoacrescimovalor" : java.lang.String
        setValue(ps, i++, j34SiscomexAcrescimoAdi.getCodigomoedanegociadaacrescimo()); // "codigomoedanegociadaacrescimo" : java.lang.Integer
        setValue(ps, i++, j34SiscomexAcrescimoAdi.getValoracrescimomoedanacional()); // "valoracrescimomoedanacional" : java.math.BigDecimal
        setValue(ps, i++, j34SiscomexAcrescimoAdi.getValoracrescimomoedanegociada()); // "valoracrescimomoedanegociada" : java.math.BigDecimal

        setValue(ps, i++, j34SiscomexAcrescimoAdi.getNumerodocumentocarga()); // "numerodocumentocarga" : java.lang.String
        setValue(ps, i++, j34SiscomexAcrescimoAdi.getNumeroadicao()); // "numeroadicao" : java.lang.String
    }

}
