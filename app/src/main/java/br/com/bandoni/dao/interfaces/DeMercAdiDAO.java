package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexDeMercAdi;

/**
 * J34SiscomexDeMercAdi: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface DeMercAdiDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga
         * @param numeroadicao
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexDeMercAdi find(String numerodocumentocarga, String numeroadicao) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexDeMercAdi
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexDeMercAdi j34SiscomexDeMercAdi) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexDeMercAdi
         */
        public void insert(J34SiscomexDeMercAdi j34SiscomexDeMercAdi) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexDeMercAdi
         * @return
         */
        public int update(J34SiscomexDeMercAdi j34SiscomexDeMercAdi) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param numerodocumentocarga
         * @param numeroadicao
         * @return
         */
        public int delete(String numerodocumentocarga, String numeroadicao) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexDeMercAdi
         * @return
         */
        public int delete(J34SiscomexDeMercAdi j34SiscomexDeMercAdi) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param numerodocumentocarga
         * @param numeroadicao
         * @return
         */
        public boolean exists(String numerodocumentocarga, String numeroadicao) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexDeMercAdi
         * @return
         */
        public boolean exists(J34SiscomexDeMercAdi j34SiscomexDeMercAdi) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
