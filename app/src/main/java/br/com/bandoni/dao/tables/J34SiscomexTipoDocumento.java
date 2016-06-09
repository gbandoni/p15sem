package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexTipoDocumento'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexTipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // Chave primaria da entidade (campo unico)
    //----------------------------------------------------------------------
    // DB : codigo CHAR 
    private String codigo;

    //----------------------------------------------------------------------
    //  campos de dados da entidade 
    //----------------------------------------------------------------------    
    // DB : sigla CHAR 
    private String sigla;

    // DB : descricao VARCHAR 
    private String descricao;

    // DB : maritima CHAR 
    private String maritima;

    // DB : fluvia CHAR 
    private String fluvia;

    // DB : aerea CHAR 
    private String aerea;

    // DB : rodoviaria CHAR 
    private String rodoviaria;

    // DB : ferroviaria CHAR 
    private String ferroviaria;

    // DB : postal CHAR 
    private String postal;

    // DB : lacustre CHAR 
    private String lacustre;



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
    public void setSigla( String sigla ) {
        this.sigla = sigla;
    }
    public String getSigla() {
        return this.sigla;
    }

    public void setDescricao( String descricao ) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return this.descricao;
    }

    public void setMaritima( String maritima ) {
        this.maritima = maritima;
    }
    public String getMaritima() {
        return this.maritima;
    }

    public void setFluvia( String fluvia ) {
        this.fluvia = fluvia;
    }
    public String getFluvia() {
        return this.fluvia;
    }

    public void setAerea( String aerea ) {
        this.aerea = aerea;
    }
    public String getAerea() {
        return this.aerea;
    }

    public void setRodoviaria( String rodoviaria ) {
        this.rodoviaria = rodoviaria;
    }
    public String getRodoviaria() {
        return this.rodoviaria;
    }

    public void setFerroviaria( String ferroviaria ) {
        this.ferroviaria = ferroviaria;
    }
    public String getFerroviaria() {
        return this.ferroviaria;
    }

    public void setPostal( String postal ) {
        this.postal = postal;
    }
    public String getPostal() {
        return this.postal;
    }

    public void setLacustre( String lacustre ) {
        this.lacustre = lacustre;
    }
    public String getLacustre() {
        return this.lacustre;
    }


    //----------------------------------------------------------------------
    // Metodo toString
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(codigo);
        sb.append("|");
        sb.append(sigla);
        sb.append("|");
        sb.append(descricao);
        sb.append("|");
        sb.append(maritima);
        sb.append("|");
        sb.append(fluvia);
        sb.append("|");
        sb.append(aerea);
        sb.append("|");
        sb.append(rodoviaria);
        sb.append("|");
        sb.append(ferroviaria);
        sb.append("|");
        sb.append(postal);
        sb.append("|");
        sb.append(lacustre);
        return sb.toString(); 
    } 


}
