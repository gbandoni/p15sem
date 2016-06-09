package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexAdicao;

/**
 * J34SiscomexAdicao: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface AdicaoDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga
         * @param numeroadicao
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexAdicao find(String numerodocumentocarga, String numeroadicao) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexAdicao
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexAdicao j34SiscomexAdicao) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexAdicao
         */
        public void insert(J34SiscomexAdicao j34SiscomexAdicao) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexAdicao
         * @return
         */
        public int update(J34SiscomexAdicao j34SiscomexAdicao) ;

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
         * @param j34SiscomexAdicao
         * @return
         */
        public int delete(J34SiscomexAdicao j34SiscomexAdicao) ;

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
         * @param j34SiscomexAdicao
         * @return
         */
        public boolean exists(J34SiscomexAdicao j34SiscomexAdicao) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
