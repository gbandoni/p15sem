package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexTipoRecipiente;

/**
 * J34SiscomexTipoRecipiente: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface TipoRecipienteDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexTipoRecipiente find(String codigo) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexTipoRecipiente
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexTipoRecipiente j34SiscomexTipoRecipiente) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexTipoRecipiente
         */
        public void insert(J34SiscomexTipoRecipiente j34SiscomexTipoRecipiente) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexTipoRecipiente
         * @return
         */
        public int update(J34SiscomexTipoRecipiente j34SiscomexTipoRecipiente) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo
         * @return
         */
        public int delete(String codigo) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexTipoRecipiente
         * @return
         */
        public int delete(J34SiscomexTipoRecipiente j34SiscomexTipoRecipiente) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo
         * @return
         */
        public boolean exists(String codigo) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexTipoRecipiente
         * @return
         */
        public boolean exists(J34SiscomexTipoRecipiente j34SiscomexTipoRecipiente) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
