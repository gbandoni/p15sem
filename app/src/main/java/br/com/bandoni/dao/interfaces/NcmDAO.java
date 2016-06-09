package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexNcm;

/**
 * J34SiscomexNcm: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface NcmDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigoncm
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexNcm find(String codigoncm) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexNcm
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexNcm j34SiscomexNcm) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexNcm
         */
        public void insert(J34SiscomexNcm j34SiscomexNcm) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexNcm
         * @return
         */
        public int update(J34SiscomexNcm j34SiscomexNcm) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigoncm
         * @return
         */
        public int delete(String codigoncm) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexNcm
         * @return
         */
        public int delete(J34SiscomexNcm j34SiscomexNcm) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigoncm
         * @return
         */
        public boolean exists(String codigoncm) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexNcm
         * @return
         */
        public boolean exists(J34SiscomexNcm j34SiscomexNcm) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
