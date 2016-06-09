package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexModdespacho;

/**
 * J34SiscomexModdespacho: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface ModdespachoDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo_modalidade
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexModdespacho find(Integer codigo_modalidade) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexModdespacho
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexModdespacho j34SiscomexModdespacho) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexModdespacho
         */
        public void insert(J34SiscomexModdespacho j34SiscomexModdespacho) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexModdespacho
         * @return
         */
        public int update(J34SiscomexModdespacho j34SiscomexModdespacho) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo_modalidade
         * @return
         */
        public int delete(Integer codigo_modalidade) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexModdespacho
         * @return
         */
        public int delete(J34SiscomexModdespacho j34SiscomexModdespacho) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo_modalidade
         * @return
         */
        public boolean exists(Integer codigo_modalidade) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexModdespacho
         * @return
         */
        public boolean exists(J34SiscomexModdespacho j34SiscomexModdespacho) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
