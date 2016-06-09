package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexArmazemDi;

/**
 * J34SiscomexArmazemDi: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface ArmazemDiDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga
         * @param ordem
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexArmazemDi find(String numerodocumentocarga, Integer ordem) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexArmazemDi
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexArmazemDi j34SiscomexArmazemDi) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexArmazemDi
         */
        public void insert(J34SiscomexArmazemDi j34SiscomexArmazemDi) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexArmazemDi
         * @return
         */
        public int update(J34SiscomexArmazemDi j34SiscomexArmazemDi) ;

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
         * @param j34SiscomexArmazemDi
         * @return
         */
        public int delete(J34SiscomexArmazemDi j34SiscomexArmazemDi) ;

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
         * @param j34SiscomexArmazemDi
         * @return
         */
        public boolean exists(J34SiscomexArmazemDi j34SiscomexArmazemDi) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
