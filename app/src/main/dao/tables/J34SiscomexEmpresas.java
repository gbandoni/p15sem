package br.com.bandoni.dao.tables;

import java.io.Serializable;


/**
 * Java bean para a entidade 'J34SiscomexEmpresas'
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class J34SiscomexEmpresas implements Serializable {

	private static final long serialVersionUID = 1L;

	//----------------------------------------------------------------------
	// Chave primaria da entidade (campo unico)
	//----------------------------------------------------------------------
	// DB : codigo INT 
	private Integer codigo;

	//----------------------------------------------------------------------
	//  campos de dados da entidade 
	//----------------------------------------------------------------------    
	// DB : tipopesssoa CHAR 
	private String tipopesssoa;

	// DB : razaosocial VARCHAR 
	private String razaosocial;

	// DB : telefone VARCHAR 
	private String telefone;

	// DB : endereco VARCHAR 
	private String endereco;

	// DB : numero VARCHAR 
	private String numero;

	// DB : complemento VARCHAR 
	private String complemento;

	// DB : bairro VARCHAR 
	private String bairro;

	// DB : municipio CHAR 
	private String municipio;

	// DB : estado CHAR 
	private String estado;

	// DB : cep CHAR 
	private String cep;

	// DB : pais CHAR 
	private String pais;

	// DB : email VARCHAR 
	private String email;

	// DB : municipioex VARCHAR 
	private String municipioex;
	
	// DB : estadoEX VARCHAR 
	private String estadoex;
	
	// DB : cnpj VARCHAR 
	private String cnpj;	

	public J34SiscomexEmpresas()
	{
		codigo= 0; //codigo INT 
		tipopesssoa= "2"; //tipopesssoa CHAR 
		razaosocial= ""; //razaosocial VARCHAR 
		telefone= ""; //telefone VARCHAR 
		endereco= ""; //endereco VARCHAR 
		numero= ""; //numero VARCHAR 
		complemento= ""; //complemento VARCHAR 
		bairro= ""; //bairro VARCHAR 
		municipio= ""; //municipio CHAR 
		estado= ""; //estado CHAR 
		cep= ""; //cep CHAR 
		pais= ""; //pais CHAR 
		email= ""; //email VARCHAR
		municipioex = ""; // municipioex VARCHAR
		estadoex = "";// estadoEX VARCHAR
		cnpj = "";// cnpj VARCHAR				
	}

	//----------------------------------------------------------------------
	// Getter e Setter da chave primaria
	//----------------------------------------------------------------------
	public void setCodigo( Integer codigo ) {
		this.codigo = codigo ;
	}

	public Integer getCodigo() {
		return this.codigo;
	}


	//----------------------------------------------------------------------
	// Getter e Setter dos outros campos
	//----------------------------------------------------------------------
	public void setTipopesssoa( String tipopesssoa ) {
		this.tipopesssoa = tipopesssoa;
	}
	public String getTipopesssoa() {
		return this.tipopesssoa;
	}

	public void setRazaosocial( String razaosocial ) {
		this.razaosocial = razaosocial;
	}
	public String getRazaosocial() {
		return this.razaosocial;
	}

	public void setTelefone( String telefone ) {
		this.telefone = telefone;
	}
	public String getTelefone() {
		return this.telefone;
	}

	public void setEndereco( String endereco ) {
		this.endereco = endereco;
	}
	public String getEndereco() {
		return this.endereco;
	}

	public void setNumero( String numero ) {
		this.numero = numero;
	}
	public String getNumero() {
		return this.numero;
	}

	public void setComplemento( String complemento ) {
		this.complemento = complemento;
	}
	public String getComplemento() {
		return this.complemento;
	}

	public void setBairro( String bairro ) {
		this.bairro = bairro;
	}
	public String getBairro() {
		return this.bairro;
	}

	public void setMunicipio( String municipio ) {
		this.municipio = municipio;
	}
	public String getMunicipio() {
		return this.municipio;
	}

	public void setEstado( String estado ) {
		this.estado = estado;
	}
	public String getEstado() {
		return this.estado;
	}

	public void setCep( String cep ) {
		this.cep = cep;
	}
	public String getCep() {
		return this.cep;
	}

	public void setPais( String pais ) {
		this.pais = pais;
	}
	public String getPais() {
		return this.pais;
	}

	public void setEmail( String email ) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}
	
	public String getMunicipioex() {
		return municipioex;
	}

	public void setMunicipioex(String municipioex) {
		this.municipioex = municipioex;
	}

	public String getEstadoex() {
		return estadoex;
	}

	public void setEstadoex(String estadoex) {
		this.estadoex = estadoex;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	//----------------------------------------------------------------------
	// Metodo toString
	//----------------------------------------------------------------------
	public String toString() { 
		StringBuffer sb = new StringBuffer(); 
		sb.append(codigo);
		sb.append("|");
		sb.append(tipopesssoa);
		sb.append("|");
		sb.append(razaosocial);
		sb.append("|");
		sb.append(telefone);
		sb.append("|");
		sb.append(endereco);
		sb.append("|");
		sb.append(numero);
		sb.append("|");
		sb.append(complemento);
		sb.append("|");
		sb.append(bairro);
		sb.append("|");
		sb.append(municipio);
		sb.append("|");
		sb.append(estado);
		sb.append("|");
		sb.append(cep);
		sb.append("|");
		sb.append(pais);
		sb.append("|");
		sb.append(email);
		sb.append("|");
		sb.append(municipioex);
		sb.append("|");
		sb.append(estadoex);
		sb.append("|");
		sb.append(cnpj);		
		return sb.toString(); 
	} 


}
