package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexImpostosDi;

/**
 * J34SiscomexImpostosDi: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface ImpostosDiDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga
         * @param ordem
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexImpostosDi find(String numerodocumentocarga, Integer ordem) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexImpostosDi
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexImpostosDi j34SiscomexImpostosDi) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexImpostosDi
         */
        public void insert(J34SiscomexImpostosDi j34SiscomexImpostosDi) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexImpostosDi
         * @return
         */
        public int update(J34SiscomexImpostosDi j34SiscomexImpostosDi) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param numerodocumentocarga
         * @param ordem
         * @return
         */
        public int delete(String numerodocumentocarga, Integer ordem) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexImpostosDi
         * @return
         */
        public int delete(J34SiscomexImpostosDi j34SiscomexImpostosDi) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param numerodocumentocarga
         * @param ordem
         * @return
         */
        public boolean exists(String numerodocumentocarga, Integer ordem) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexImpostosDi
         * @return
         */
        public boolean exists(J34SiscomexImpostosDi j34SiscomexImpostosDi) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
