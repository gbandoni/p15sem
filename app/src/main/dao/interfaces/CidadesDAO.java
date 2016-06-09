package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexCidades;

/**
 * J34SiscomexCidades: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface CidadesDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codmun
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexCidades find(String estado, String codmun) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexCidades
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexCidades j34SiscomexCidades) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexCidades
         */
        public void insert(J34SiscomexCidades j34SiscomexCidades) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexCidades
         * @return
         */
        public int update(J34SiscomexCidades j34SiscomexCidades) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codmun
         * @return
         */
        public int delete(String estado, String codmun) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexCidades
         * @return
         */
        public int delete(J34SiscomexCidades j34SiscomexCidades) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codmun
         * @return
         */
        public boolean exists(String estado, String codmun) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexCidades
         * @return
         */
        public boolean exists(J34SiscomexCidades j34SiscomexCidades) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
