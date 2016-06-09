package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexDeducoes;

/**
 * J34SiscomexDeducoes: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface DeducoesDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexDeducoes find(String codigo) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexDeducoes
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexDeducoes j34SiscomexDeducoes) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexDeducoes
         */
        public void insert(J34SiscomexDeducoes j34SiscomexDeducoes) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexDeducoes
         * @return
         */
        public int update(J34SiscomexDeducoes j34SiscomexDeducoes) ;

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
         * @param j34SiscomexDeducoes
         * @return
         */
        public int delete(J34SiscomexDeducoes j34SiscomexDeducoes) ;

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
         * @param j34SiscomexDeducoes
         * @return
         */
        public boolean exists(J34SiscomexDeducoes j34SiscomexDeducoes) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
