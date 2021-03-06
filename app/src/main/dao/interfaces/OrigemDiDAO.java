package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexOrigemDi;

/**
 * J34SiscomexOrigemDi: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface OrigemDiDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param id
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexOrigemDi find(String id) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexOrigemDi
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexOrigemDi j34SiscomexOrigemDi) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexOrigemDi
         */
        public void insert(J34SiscomexOrigemDi j34SiscomexOrigemDi) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexOrigemDi
         * @return
         */
        public int update(J34SiscomexOrigemDi j34SiscomexOrigemDi) ;

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
         * @param j34SiscomexOrigemDi
         * @return
         */
        public int delete(J34SiscomexOrigemDi j34SiscomexOrigemDi) ;

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
         * @param j34SiscomexOrigemDi
         * @return
         */
        public boolean exists(J34SiscomexOrigemDi j34SiscomexOrigemDi) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
