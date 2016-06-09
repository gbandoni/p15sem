package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexAtribNcm;

/**
 * J34SiscomexAtribNcm: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface AtribNcmDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param ncm
         * @param atributoncm
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexAtribNcm find(String ncm, String atributoncm) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexAtribNcm
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexAtribNcm j34SiscomexAtribNcm) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexAtribNcm
         */
        public void insert(J34SiscomexAtribNcm j34SiscomexAtribNcm) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexAtribNcm
         * @return
         */
        public int update(J34SiscomexAtribNcm j34SiscomexAtribNcm) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param ncm
         * @param atributoncm
         * @return
         */
        public int delete(String ncm, String atributoncm) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexAtribNcm
         * @return
         */
        public int delete(J34SiscomexAtribNcm j34SiscomexAtribNcm) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param ncm
         * @param atributoncm
         * @return
         */
        public boolean exists(String ncm, String atributoncm) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexAtribNcm
         * @return
         */
        public boolean exists(J34SiscomexAtribNcm j34SiscomexAtribNcm) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
