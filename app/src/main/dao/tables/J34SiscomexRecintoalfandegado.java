package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexRecintoalfandegado'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexRecintoalfandegado implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : codigo CHAR 
    private String codigo;
    // DB : terminal VARCHAR 
    private String terminal;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------    
    // DB : regiao CHAR 
    private String regiao;

    // DB : nomeporto VARCHAR 
    private String nomeporto;

    // DB : estado CHAR 
    private String estado;

    // DB : descricao VARCHAR 
    private String descricao;



    //----------------------------------------------------------------------
    // Getter e Setter da chave primaria
    //----------------------------------------------------------------------
    public void setCodigo( String codigo ) {
        this.codigo = codigo ;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setTerminal( String terminal ) {
        this.terminal = terminal ;
    }

    public String getTerminal() {
        return this.terminal;
    }


    //----------------------------------------------------------------------
    // Getter e Setter dos outros campos
    //----------------------------------------------------------------------
    public void setRegiao( String regiao ) {
        this.regiao = regiao;
    }
    public String getRegiao() {
        return this.regiao;
    }

    public void setNomeporto( String nomeporto ) {
        this.nomeporto = nomeporto;
    }
    public String getNomeporto() {
        return this.nomeporto;
    }

    public void setEstado( String estado ) {
        this.estado = estado;
    }
    public String getEstado() {
        return this.estado;
    }

    public void setDescricao( String descricao ) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return this.descricao;
    }


    //----------------------------------------------------------------------
    // Metodo toString
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(codigo);
        sb.append("|");
        sb.append(regiao);
        sb.append("|");
        sb.append(nomeporto);
        sb.append("|");
        sb.append(estado);
        sb.append("|");
        sb.append(terminal);
        sb.append("|");
        sb.append(descricao);
        return sb.toString(); 
    } 


}
