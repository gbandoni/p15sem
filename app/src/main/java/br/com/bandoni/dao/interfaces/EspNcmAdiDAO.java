package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexEspNcmAdi;

/**
 * J34SiscomexEspNcmAdi: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface EspNcmAdiDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga
         * @param numeroadicao
         * @param codigoabrangenciancm
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexEspNcmAdi find(String numerodocumentocarga, String numeroadicao, String codigoabrangenciancm) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexEspNcmAdi
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexEspNcmAdi j34SiscomexEspNcmAdi) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexEspNcmAdi
         */
        public void insert(J34SiscomexEspNcmAdi j34SiscomexEspNcmAdi) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexEspNcmAdi
         * @return
         */
        public int update(J34SiscomexEspNcmAdi j34SiscomexEspNcmAdi) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param numerodocumentocarga
         * @param numeroadicao
         * @param codigoabrangenciancm
         * @return
         */
        public int delete(String numerodocumentocarga, String numeroadicao, String codigoabrangenciancm) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexEspNcmAdi
         * @return
         */
        public int delete(J34SiscomexEspNcmAdi j34SiscomexEspNcmAdi) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param numerodocumentocarga
         * @param numeroadicao
         * @param codigoabrangenciancm
         * @return
         */
        public boolean exists(String numerodocumentocarga, String numeroadicao, String codigoabrangenciancm) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexEspNcmAdi
         * @return
         */
        public boolean exists(J34SiscomexEspNcmAdi j34SiscomexEspNcmAdi) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
