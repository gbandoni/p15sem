package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexPaises;

/**
 * J34SiscomexPaises: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface PaisesDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo_pais
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexPaises find(String codigo_pais) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexPaises
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexPaises j34SiscomexPaises) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexPaises
         */
        public void insert(J34SiscomexPaises j34SiscomexPaises) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexPaises
         * @return
         */
        public int update(J34SiscomexPaises j34SiscomexPaises) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo_pais
         * @return
         */
        public int delete(String codigo_pais) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexPaises
         * @return
         */
        public int delete(J34SiscomexPaises j34SiscomexPaises) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo_pais
         * @return
         */
        public boolean exists(String codigo_pais) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexPaises
         * @return
         */
        public boolean exists(J34SiscomexPaises j34SiscomexPaises) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
