package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexNaladiSh;

/**
 * J34SiscomexNaladiSh: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface NaladiShDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo
         * @param ordem
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexNaladiSh find(String codigo, String ordem) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexNaladiSh
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexNaladiSh j34SiscomexNaladiSh) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexNaladiSh
         */
        public void insert(J34SiscomexNaladiSh j34SiscomexNaladiSh) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexNaladiSh
         * @return
         */
        public int update(J34SiscomexNaladiSh j34SiscomexNaladiSh) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo
         * @param ordem
         * @return
         */
        public int delete(String codigo, String ordem) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexNaladiSh
         * @return
         */
        public int delete(J34SiscomexNaladiSh j34SiscomexNaladiSh) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo
         * @param ordem
         * @return
         */
        public boolean exists(String codigo, String ordem) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexNaladiSh
         * @return
         */
        public boolean exists(J34SiscomexNaladiSh j34SiscomexNaladiSh) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
