package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexDi;

/**
 * J34SiscomexDi: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface DiDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexDi find(String numerodocumentocarga) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexDi
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexDi j34SiscomexDi) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexDi
         */
        public void insert(J34SiscomexDi j34SiscomexDi) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexDi
         * @return
         */
        public int update(J34SiscomexDi j34SiscomexDi) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param numerodocumentocarga
         * @return
         */
        public int delete(String numerodocumentocarga) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexDi
         * @return
         */
        public int delete(J34SiscomexDi j34SiscomexDi) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param numerodocumentocarga
         * @return
         */
        public boolean exists(String numerodocumentocarga) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexDi
         * @return
         */
        public boolean exists(J34SiscomexDi j34SiscomexDi) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
