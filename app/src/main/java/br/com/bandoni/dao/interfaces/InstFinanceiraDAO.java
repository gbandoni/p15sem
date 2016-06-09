package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexInstFinanceira;

/**
 * J34SiscomexInstFinanceira: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface InstFinanceiraDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexInstFinanceira find(String codigo) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexInstFinanceira
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexInstFinanceira j34SiscomexInstFinanceira) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexInstFinanceira
         */
        public void insert(J34SiscomexInstFinanceira j34SiscomexInstFinanceira) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexInstFinanceira
         * @return
         */
        public int update(J34SiscomexInstFinanceira j34SiscomexInstFinanceira) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo
         * @return
         */
        public int delete(String codigo) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexInstFinanceira
         * @return
         */
        public int delete(J34SiscomexInstFinanceira j34SiscomexInstFinanceira) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo
         * @return
         */
        public boolean exists(String codigo) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexInstFinanceira
         * @return
         */
        public boolean exists(J34SiscomexInstFinanceira j34SiscomexInstFinanceira) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
