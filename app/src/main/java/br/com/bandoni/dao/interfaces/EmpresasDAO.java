package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexEmpresas;

/**
 * J34SiscomexEmpresas: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface EmpresasDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexEmpresas find(Integer codigo) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexEmpresas
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexEmpresas j34SiscomexEmpresas) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexEmpresas
         */
        public void insert(J34SiscomexEmpresas j34SiscomexEmpresas) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexEmpresas
         * @return
         */
        public int update(J34SiscomexEmpresas j34SiscomexEmpresas) ;

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
         * @param j34SiscomexEmpresas
         * @return
         */
        public int delete(J34SiscomexEmpresas j34SiscomexEmpresas) ;

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
         * @param j34SiscomexEmpresas
         * @return
         */
        public boolean exists(J34SiscomexEmpresas j34SiscomexEmpresas) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
