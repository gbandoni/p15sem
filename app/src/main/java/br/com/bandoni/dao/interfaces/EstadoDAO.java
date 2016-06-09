package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexEstado;

/**
 * J34SiscomexEstado: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface EstadoDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param estado_id
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexEstado find(String estado_id) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexEstado
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexEstado j34SiscomexEstado) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexEstado
         */
        public void insert(J34SiscomexEstado j34SiscomexEstado) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexEstado
         * @return
         */
        public int update(J34SiscomexEstado j34SiscomexEstado) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param estado_id
         * @return
         */
        public int delete(String estado_id) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexEstado
         * @return
         */
        public int delete(J34SiscomexEstado j34SiscomexEstado) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param estadoId
         * @return
         */
        public boolean exists(String estado_id) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexEstado
         * @return
         */
        public boolean exists(J34SiscomexEstado j34SiscomexEstado) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
