package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexOrgaosurf;

/**
 * J34SiscomexOrgaosurf: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface OrgaosurfDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexOrgaosurf find(String codigo) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexOrgaosurf
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexOrgaosurf j34SiscomexOrgaosurf) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexOrgaosurf
         */
        public void insert(J34SiscomexOrgaosurf j34SiscomexOrgaosurf) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexOrgaosurf
         * @return
         */
        public int update(J34SiscomexOrgaosurf j34SiscomexOrgaosurf) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @return
         */
        public int delete(String codigo) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexOrgaosurf
         * @return
         */
        public int delete(J34SiscomexOrgaosurf j34SiscomexOrgaosurf) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @return
         */
        public boolean exists(String codigo) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexOrgaosurf
         * @return
         */
        public boolean exists(J34SiscomexOrgaosurf j34SiscomexOrgaosurf) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
