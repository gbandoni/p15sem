package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexLocalidadeembarque;

/**
 * J34SiscomexLocalidadeembarque: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface LocalidadeembarqueDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param id
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexLocalidadeembarque find(String id) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexLocalidadeembarque
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexLocalidadeembarque j34SiscomexLocalidadeembarque) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexLocalidadeembarque
         * @return the generated value for the auto-incremented column
         */
        public Integer insert(J34SiscomexLocalidadeembarque j34SiscomexLocalidadeembarque) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexLocalidadeembarque
         * @return
         */
        public int update(J34SiscomexLocalidadeembarque j34SiscomexLocalidadeembarque) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param id
         * @return
         */
        public int delete(String id) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexLocalidadeembarque
         * @return
         */
        public int delete(J34SiscomexLocalidadeembarque j34SiscomexLocalidadeembarque) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param id
         * @return
         */
        public boolean exists(String id) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexLocalidadeembarque
         * @return
         */
        public boolean exists(J34SiscomexLocalidadeembarque j34SiscomexLocalidadeembarque) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
