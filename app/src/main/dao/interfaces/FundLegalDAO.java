package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexFundLegal;

/**
 * J34SiscomexFundLegal: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface FundLegalDAO
{

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexFundLegal find(String codigo) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexFundLegal
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexFundLegal j34SiscomexFundLegal) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexFundLegal
         */
        public void insert(J34SiscomexFundLegal j34SiscomexFundLegal) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexFundLegal
         * @return
         */
        public int update(J34SiscomexFundLegal j34SiscomexFundLegal) ;

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
         * @param j34SiscomexFundLegal
         * @return
         */
        public int delete(J34SiscomexFundLegal j34SiscomexFundLegal) ;

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
         * @param j34SiscomexFundLegal
         * @return
         */
        public boolean exists(J34SiscomexFundLegal j34SiscomexFundLegal) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
