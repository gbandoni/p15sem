package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexTransportador;

/**
 * J34SiscomexTransportador: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface TransportadorDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param id
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexTransportador find(Integer id) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexTransportador
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexTransportador j34SiscomexTransportador) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexTransportador
         * @return the generated value for the auto-incremented column
         */
        public Integer insert(J34SiscomexTransportador j34SiscomexTransportador) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexTransportador
         * @return
         */
        public int update(J34SiscomexTransportador j34SiscomexTransportador) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param id
         * @return
         */
        public int delete(Integer id) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexTransportador
         * @return
         */
        public int delete(J34SiscomexTransportador j34SiscomexTransportador) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param id
         * @return
         */
        public boolean exists(Integer id) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexTransportador
         * @return
         */
        public boolean exists(J34SiscomexTransportador j34SiscomexTransportador) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
