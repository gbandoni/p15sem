package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexTipoDeclaracao;

/**
 * J34SiscomexTipoDeclaracao: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface TipoDeclaracaoDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo_tipo
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexTipoDeclaracao find(Integer codigo_tipo) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexTipoDeclaracao
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexTipoDeclaracao j34SiscomexTipoDeclaracao) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexTipoDeclaracao
         */
        public void insert(J34SiscomexTipoDeclaracao j34SiscomexTipoDeclaracao) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexTipoDeclaracao
         * @return
         */
        public int update(J34SiscomexTipoDeclaracao j34SiscomexTipoDeclaracao) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo_tipo
         * @return
         */
        public int delete(Integer codigo_tipo) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexTipoDeclaracao
         * @return
         */
        public int delete(J34SiscomexTipoDeclaracao j34SiscomexTipoDeclaracao) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo_tipo
         * @return
         */
        public boolean exists(Integer codigo_tipo) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexTipoDeclaracao
         * @return
         */
        public boolean exists(J34SiscomexTipoDeclaracao j34SiscomexTipoDeclaracao) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
