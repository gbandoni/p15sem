package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexMoedas;

/**
 * J34SiscomexMoedas: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface MoedasDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param idmoeda
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexMoedas find(Integer idmoeda) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexMoedas
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexMoedas j34SiscomexMoedas) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexMoedas
         * @return the generated value for the auto-incremented column
         */
        public Integer insert(J34SiscomexMoedas j34SiscomexMoedas) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexMoedas
         * @return
         */
        public int update(J34SiscomexMoedas j34SiscomexMoedas) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param idmoeda
         * @return
         */
        public int delete(Integer idmoeda) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexMoedas
         * @return
         */
        public int delete(J34SiscomexMoedas j34SiscomexMoedas) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param idmoeda
         * @return
         */
        public boolean exists(Integer idmoeda) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexMoedas
         * @return
         */
        public boolean exists(J34SiscomexMoedas j34SiscomexMoedas) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
