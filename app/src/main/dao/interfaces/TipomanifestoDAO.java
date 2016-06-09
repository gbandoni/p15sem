package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexTipomanifesto;

/**
 * J34SiscomexTipomanifesto: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface TipomanifestoDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexTipomanifesto find(Integer codigo) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexTipomanifesto
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexTipomanifesto j34SiscomexTipomanifesto) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexTipomanifesto
         */
        public void insert(J34SiscomexTipomanifesto j34SiscomexTipomanifesto) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexTipomanifesto
         * @return
         */
        public int update(J34SiscomexTipomanifesto j34SiscomexTipomanifesto) ;

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
         * @param j34SiscomexTipomanifesto
         * @return
         */
        public int delete(J34SiscomexTipomanifesto j34SiscomexTipomanifesto) ;

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
         * @param j34SiscomexTipomanifesto
         * @return
         */
        public boolean exists(J34SiscomexTipomanifesto j34SiscomexTipomanifesto) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
