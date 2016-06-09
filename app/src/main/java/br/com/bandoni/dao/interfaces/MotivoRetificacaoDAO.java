package br.com.bandoni.dao.interfaces;

import br.com.bandoni.dao.tables.J34SiscomexMotivoRetificacao;

/**
 * J34SiscomexMotivoRetificacao: interface para DAO
 * 
 * @author Gustavo Bandoni da Silva  
 */
public interface MotivoRetificacaoDAO {

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param codigo_motivo
         * @return O registro procurado ou NULL caso n�o seja 
         */
        public J34SiscomexMotivoRetificacao find(Integer codigo_motivo) ;

        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexMotivoRetificacao
         * @return True se encontrado , false caso nao seja encontrado
         */
        public boolean load(J34SiscomexMotivoRetificacao j34SiscomexMotivoRetificacao) ;
        
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexMotivoRetificacao
         */
        public void insert(J34SiscomexMotivoRetificacao j34SiscomexMotivoRetificacao) ;

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexMotivoRetificacao
         * @return
         */
        public int update(J34SiscomexMotivoRetificacao j34SiscomexMotivoRetificacao) ;

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param codigo_motivo
         * @return
         */
        public int delete(Integer codigo_motivo) ;

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexMotivoRetificacao
         * @return
         */
        public int delete(J34SiscomexMotivoRetificacao j34SiscomexMotivoRetificacao) ;

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param codigo_motivo
         * @return
         */
        public boolean exists(Integer codigo_motivo) ;

        //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexMotivoRetificacao
         * @return
         */
        public boolean exists(J34SiscomexMotivoRetificacao j34SiscomexMotivoRetificacao) ;

    //----------------------------------------------------------------------
        /**
         * Retorna o total de registros na tabela 
         * @return
         */
        public long count() ;

}
