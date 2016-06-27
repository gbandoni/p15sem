package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexUsuarios;

/**
 * J34SiscomexUsuarios: interface para DAOFF
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface UsuariosDAO
{

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param usu_codigo
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexUsuarios find(Integer usu_codigo) ;

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria
         * @param usu_codigo
         * @return O registro procurado ou NULL caso n�o seja
         */
        public J34SiscomexUsuarios find(String usu_login) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexUsuarios
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexUsuarios j34SiscomexUsuarios) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexUsuarios
         */
        public void insert(J34SiscomexUsuarios j34SiscomexUsuarios) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexUsuarios
         * @return
         */
        public int update(J34SiscomexUsuarios j34SiscomexUsuarios) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param usu_codigo
         * @return
         */
        public int delete(Integer usu_codigo) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexUsuarios
         * @return
         */
        public int delete(J34SiscomexUsuarios j34SiscomexUsuarios) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param usu_codigo
         * @return
         */
        public boolean exists(Integer usu_codigo) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexUsuarios
         * @return
         */
        public boolean exists(J34SiscomexUsuarios j34SiscomexUsuarios) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
