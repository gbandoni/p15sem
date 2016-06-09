package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexTipoEmbalagem;

/**
 * J34SiscomexTipoEmbalagem: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface TipoEmbalagemDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexTipoEmbalagem find(Integer codigo) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexTipoEmbalagem
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexTipoEmbalagem j34SiscomexTipoEmbalagem) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexTipoEmbalagem
         */
        public void insert(J34SiscomexTipoEmbalagem j34SiscomexTipoEmbalagem) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexTipoEmbalagem
         * @return
         */
        public int update(J34SiscomexTipoEmbalagem j34SiscomexTipoEmbalagem) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo
         * @return
         */
        public int delete(Integer codigo) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexTipoEmbalagem
         * @return
         */
        public int delete(J34SiscomexTipoEmbalagem j34SiscomexTipoEmbalagem) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo
         * @return
         */
        public boolean exists(Integer codigo) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexTipoEmbalagem
         * @return
         */
        public boolean exists(J34SiscomexTipoEmbalagem j34SiscomexTipoEmbalagem) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
