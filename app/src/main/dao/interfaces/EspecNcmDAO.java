package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexEspecNcm;

/**
 * J34SiscomexEspecNcm: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface EspecNcmDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param id
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexEspecNcm find(Integer id) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexEspecNcm
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexEspecNcm j34SiscomexEspecNcm) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexEspecNcm
         */
        public void insert(J34SiscomexEspecNcm j34SiscomexEspecNcm) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexEspecNcm
         * @return
         */
        public int update(J34SiscomexEspecNcm j34SiscomexEspecNcm) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param id
         * @return
         */
        public int delete(Integer id) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexEspecNcm
         * @return
         */
        public int delete(J34SiscomexEspecNcm j34SiscomexEspecNcm) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param id
         * @return
         */
        public boolean exists(Integer id) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexEspecNcm
         * @return
         */
        public boolean exists(J34SiscomexEspecNcm j34SiscomexEspecNcm) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
