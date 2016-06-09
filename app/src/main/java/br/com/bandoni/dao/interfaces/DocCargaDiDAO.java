package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexDocCargaDi;

/**
 * J34SiscomexDocCargaDi: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface DocCargaDiDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga
         * @param ordem
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexDocCargaDi find(String numerodocumentocarga, Integer ordem) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexDocCargaDi
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexDocCargaDi j34SiscomexDocCargaDi) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexDocCargaDi
         */
        public void insert(J34SiscomexDocCargaDi j34SiscomexDocCargaDi) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexDocCargaDi
         * @return
         */
        public int update(J34SiscomexDocCargaDi j34SiscomexDocCargaDi) ;

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
         * @param j34SiscomexDocCargaDi
         * @return
         */
        public int delete(J34SiscomexDocCargaDi j34SiscomexDocCargaDi) ;

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
         * @param j34SiscomexDocCargaDi
         * @return
         */
        public boolean exists(J34SiscomexDocCargaDi j34SiscomexDocCargaDi) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
