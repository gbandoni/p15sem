package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexTipoDocumentoDes;

/**
 * J34SiscomexTipoDocumentoDes: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface TipoDocumentoDesDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexTipoDocumentoDes find(Integer codigo) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexTipoDocumentoDes
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexTipoDocumentoDes j34SiscomexTipoDocumentoDes) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexTipoDocumentoDes
         */
        public void insert(J34SiscomexTipoDocumentoDes j34SiscomexTipoDocumentoDes) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexTipoDocumentoDes
         * @return
         */
        public int update(J34SiscomexTipoDocumentoDes j34SiscomexTipoDocumentoDes) ;

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
         * @param j34SiscomexTipoDocumentoDes
         * @return
         */
        public int delete(J34SiscomexTipoDocumentoDes j34SiscomexTipoDocumentoDes) ;

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
         * @param j34SiscomexTipoDocumentoDes
         * @return
         */
        public boolean exists(J34SiscomexTipoDocumentoDes j34SiscomexTipoDocumentoDes) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
