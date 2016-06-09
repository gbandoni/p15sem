package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexVeiculos'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : id Integer
    private Integer usu_codigo;// Integer(11)
    private String usu_nome;//  varchar(100)
    private String usu_login;//  varchar(6)
    private String usu_senha;//  varchar(15)
    private Integer usu_adm;//  tinyInteger(1)



    //----------------------------------------------------------------------
    // Getter e Setter da chave primaria
    //----------------------------------------------------------------------

    public Integer getUsu_codigo()
    {
        return usu_codigo;
    }

    public void setUsu_codigo(Integer usu_codigo)
    {
        this.usu_codigo = usu_codigo;
    }

    public String getUsu_nome()
    {
        return usu_nome;
    }

    //----------------------------------------------------------------------
    // Getter e Setter dos outros campos
    //----------------------------------------------------------------------
    public void setUsu_nome(String usu_nome)
    {
        this.usu_nome = usu_nome;
    }

    public String getUsu_login()
    {
        return usu_login;
    }

    public void setUsu_login(String usu_login)
    {
        this.usu_login = usu_login;
    }

    public String getUsu_senha()
    {
        return usu_senha;
    }

    public void setUsu_senha(String usu_senha)
    {
        this.usu_senha = usu_senha;
    }

    public Integer getUsu_adm()
    {
        return usu_adm;
    }

    public void setUsu_adm(Integer usu_adm)
    {
        this.usu_adm = usu_adm;
    }

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    @Override
    public String toString()
    {
        return "J34SiscomexUsuarios{" +
                "usu_codigo=" + usu_codigo +
                ", usu_nome='" + usu_nome + '\'' +
                ", usu_login='" + usu_login + '\'' +
                ", usu_senha='" + usu_senha + '\'' +
                ", usu_adm=" + usu_adm +
                '}';
    }
}
