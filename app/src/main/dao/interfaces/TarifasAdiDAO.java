package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexTarifasAdi;

/**
 * J34SiscomexTarifasAdi: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface TarifasAdiDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga
         * @param numeroadicao
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexTarifasAdi find(String numerodocumentocarga, String numeroadicao) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexTarifasAdi
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexTarifasAdi j34SiscomexTarifasAdi) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexTarifasAdi
         */
        public void insert(J34SiscomexTarifasAdi j34SiscomexTarifasAdi) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexTarifasAdi
         * @return
         */
        public int update(J34SiscomexTarifasAdi j34SiscomexTarifasAdi) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param numerodocumentocarga
         * @param numeroadicao
         * @return
         */
        public int delete(String numerodocumentocarga, String numeroadicao) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexTarifasAdi
         * @return
         */
        public int delete(J34SiscomexTarifasAdi j34SiscomexTarifasAdi) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param numerodocumentocarga
         * @param numeroadicao
         * @return
         */
        public boolean exists(String numerodocumentocarga, String numeroadicao) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexTarifasAdi
         * @return
         */
        public boolean exists(J34SiscomexTarifasAdi j34SiscomexTarifasAdi) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
