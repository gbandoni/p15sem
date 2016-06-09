package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexRecintoalfandegado;

/**
 * J34SiscomexRecintoalfandegado: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface RecintoalfandegadoDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo
         * @param terminal
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexRecintoalfandegado find(String codigo, String terminal) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexRecintoalfandegado
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexRecintoalfandegado j34SiscomexRecintoalfandegado) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexRecintoalfandegado
         */
        public void insert(J34SiscomexRecintoalfandegado j34SiscomexRecintoalfandegado) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexRecintoalfandegado
         * @return
         */
        public int update(J34SiscomexRecintoalfandegado j34SiscomexRecintoalfandegado) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo
         * @param terminal
         * @return
         */
        public int delete(String codigo, String terminal) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexRecintoalfandegado
         * @return
         */
        public int delete(J34SiscomexRecintoalfandegado j34SiscomexRecintoalfandegado) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo
         * @param terminal
         * @return
         */
        public boolean exists(String codigo, String terminal) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexRecintoalfandegado
         * @return
         */
        public boolean exists(J34SiscomexRecintoalfandegado j34SiscomexRecintoalfandegado) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
