package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexFundLegal'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexFundLegal implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : codigo CHAR 
    private String codigo;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------    
    // DB : descricao VARCHAR 
    private String descricao;

    // DB : reg_tribut_1 INT 
    private Integer reg_tribut_1;

    // DB : reg_tribut_2 INT 
    private Integer reg_tribut_2;

    // DB : reg_tribut_3 INT 
    private Integer reg_tribut_3;

    // DB : reg_tribut_4 INT 
    private Integer reg_tribut_4;



    //----------------------------------------------------------------------
    // Getter e Setter da chave primaria
    //----------------------------------------------------------------------
    public void setCodigo( String codigo ) {
        this.codigo = codigo ;
    }

    public String getCodigo() {
        return this.codigo;
    }


    //----------------------------------------------------------------------
    // Getter e Setter dos outros campos
    //----------------------------------------------------------------------
    public void setDescricao( String descricao )
    {
        this.descricao = descricao;
    }
    public String getDescricao()
    {
        return this.descricao;
    }

    public void setReg_tribut_1( Integer reg_tribut_1 )
    {
        this.reg_tribut_1 = reg_tribut_1;
    }
    public Integer getReg_tribut_1()
    {
        return this.reg_tribut_1;
    }

    public void setReg_tribut_2( Integer reg_tribut_2 )
    {
        this.reg_tribut_2 = reg_tribut_2;
    }
    public Integer getReg_tribut_2()
    {
        return this.reg_tribut_2;
    }

    public void setReg_tribut_3( Integer reg_tribut_3 )
    {
        this.reg_tribut_3 = reg_tribut_3;
    }

    public Integer getReg_tribut_3()
    {
        return this.reg_tribut_3;
    }

    public void setReg_tribut_4( Integer reg_tribut_4 )
    {
        this.reg_tribut_4 = reg_tribut_4;
    }

    public Integer getReg_tribut_4()
    {
        return this.reg_tribut_4;
    }


    //----------------------------------------------------------------------
    // Metodo toString
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(codigo);
        sb.append("|");
        sb.append(descricao);
        sb.append("|");
        sb.append(reg_tribut_1);
        sb.append("|");
        sb.append(reg_tribut_2);
        sb.append("|");
        sb.append(reg_tribut_3);
        sb.append("|");
        sb.append(reg_tribut_4);
        return sb.toString(); 
    } 


}
