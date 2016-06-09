package br.com.bandoni.dao.implementation;

import android.content.Context;

import java.util.Date;
import java.util.List;
import android.database.sqlite.SQLiteStatement;
import android.database.Cursor;
import java.sql.SQLException;

import br.com.bandoni.dao.interfaces.DiDAO;
import br.com.bandoni.dao.commons.GenericDAO;
import br.com.bandoni.dao.tables.J34SiscomexDi;

/**
 * J34SiscomexDi: implementa��o do DAO 
 * 
 * @author Gustavo Bandoni da Silva  
 *
 */
public class DiDAOImpl extends GenericDAO<J34SiscomexDi> implements DiDAO {

        private final static String SQL_SELECT = 
                "select numerodocumentocarga, codigotipodocumentocarga, codigomoedaseguro, codigomoedafrete, codigomotivotransmissao, cargapesobruto, cargapesoliquido, codigobandeiratranspote, codigomodalidadedespacho, codigoorigemdi, codigopaisprocedenciacarga, codigopaisimportador, codigorecintoalfandegado, codigosetorarmazenamento, codigotipoagentecarga, codigotipoconsignatario, codigotipodeclaracao, codigotipoimportador, codigotipomanifesto, codigotipopagamentotributario, codigourfcargaentrada, codigourfdespacho, codigoutilizacaodocumentocarga, codigoviatransporte, datachegadacarga, dataembarque, identificacaodeclaracaoimportacao, codigoimportador, indicadormultimodalviatransporte, indicadoroperacaofundap, informacoescomplementares, codigoconsignatorio, codigolocalembarque, nomelocalembarque, codigotransportador, codigoveiculo, numeroagentecarga, numeroconsignatario, numerocontapagamentotributario, numerocpfrepresentantelegal, numerodocumentocargamaster, numeroimportador, numeromanifesto, totaladicoes, valorfreteterritorionacionalmoedanegociada, valortotalfretecollect, valortotalfretemoedanacional, valortotalfreteprepaid, valortotalmlemoedanacional, terminalrecintoalfandegario, valortotalseguromoedanacional, valortotalseguromoedanegociada, id from j34_siscomex_di where numerodocumentocarga = ?";

        private final static String SQL_INSERT = 
                "insert into j34_siscomex_di ( numerodocumentocarga, codigotipodocumentocarga, codigomoedaseguro, codigomoedafrete, codigomotivotransmissao, cargapesobruto, cargapesoliquido, codigobandeiratranspote, codigomodalidadedespacho, codigoorigemdi, codigopaisprocedenciacarga, codigopaisimportador, codigorecintoalfandegado, codigosetorarmazenamento, codigotipoagentecarga, codigotipoconsignatario, codigotipodeclaracao, codigotipoimportador, codigotipomanifesto, codigotipopagamentotributario, codigourfcargaentrada, codigourfdespacho, codigoutilizacaodocumentocarga, codigoviatransporte, datachegadacarga, dataembarque, identificacaodeclaracaoimportacao, codigoimportador, indicadormultimodalviatransporte, indicadoroperacaofundap, informacoescomplementares, codigoconsignatorio, codigolocalembarque, nomelocalembarque, codigotransportador, codigoveiculo, numeroagentecarga, numeroconsignatario, numerocontapagamentotributario, numerocpfrepresentantelegal, numerodocumentocargamaster, numeroimportador, numeromanifesto, totaladicoes, valorfreteterritorionacionalmoedanegociada, valortotalfretecollect, valortotalfretemoedanacional, valortotalfreteprepaid, valortotalmlemoedanacional, terminalrecintoalfandegario, valortotalseguromoedanacional, valortotalseguromoedanegociada, id ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

        private final static String SQL_UPDATE = 
                "update j34_siscomex_di set codigotipodocumentocarga = ?, codigomoedaseguro = ?, codigomoedafrete = ?, codigomotivotransmissao = ?, cargapesobruto = ?, cargapesoliquido = ?, codigobandeiratranspote = ?, codigomodalidadedespacho = ?, codigoorigemdi = ?, codigopaisprocedenciacarga = ?, codigopaisimportador = ?, codigorecintoalfandegado = ?, codigosetorarmazenamento = ?, codigotipoagentecarga = ?, codigotipoconsignatario = ?, codigotipodeclaracao = ?, codigotipoimportador = ?, codigotipomanifesto = ?, codigotipopagamentotributario = ?, codigourfcargaentrada = ?, codigourfdespacho = ?, codigoutilizacaodocumentocarga = ?, codigoviatransporte = ?, datachegadacarga = ?, dataembarque = ?, identificacaodeclaracaoimportacao = ?, codigoimportador = ?, indicadormultimodalviatransporte = ?, indicadoroperacaofundap = ?, informacoescomplementares = ?, codigoconsignatorio = ?, codigolocalembarque = ?, nomelocalembarque = ?, codigotransportador = ?, codigoveiculo = ?, numeroagentecarga = ?, numeroconsignatario = ?, numerocontapagamentotributario = ?, numerocpfrepresentantelegal = ?, numerodocumentocargamaster = ?, numeroimportador = ?, numeromanifesto = ?, totaladicoes = ?, valorfreteterritorionacionalmoedanegociada = ?, valortotalfretecollect = ?, valortotalfretemoedanacional = ?, valortotalfreteprepaid = ?, valortotalmlemoedanacional = ?, terminalrecintoalfandegario = ?, valortotalseguromoedanacional = ?, valortotalseguromoedanegociada = ?, id = ? where numerodocumentocarga = ?";

        private final static String SQL_DELETE = 
                "delete from j34_siscomex_di where numerodocumentocarga = ?";

        private final static String SQL_COUNT_ALL = 
                "select count(*) from j34_siscomex_di";

        private final static String SQL_COUNT = 
                "select count(*) from j34_siscomex_di where numerodocumentocarga = ?";

    //----------------------------------------------------------------------
        /**
         * Construtor do DAO
         */
        public DiDAOImpl(Context context) {
                super(context);
        }

        //----------------------------------------------------------------------
        /**
         * Cria uma instancia do objeto e carrega com os dados fornecidos como chve prim�ria
         * @param numerodocumentocarga;
         * @return A nova inst�ncia
         */
        private J34SiscomexDi newInstanceWithPrimaryKey( String numerodocumentocarga ) {
                J34SiscomexDi j34SiscomexDi = new J34SiscomexDi();
                j34SiscomexDi.setNumerodocumentocarga( numerodocumentocarga );
                return j34SiscomexDi ;
        }

        //----------------------------------------------------------------------
        /**
         * Acha um registro pela chave prim�ria 
         * @param numerodocumentocarga;
         * @return O registro procurado ou NULL caso n�o seja 
         */
        @Override
        public J34SiscomexDi find( String numerodocumentocarga ) {
                J34SiscomexDi j34SiscomexDi = newInstanceWithPrimaryKey( numerodocumentocarga ) ;
                if ( super.doSelect(j34SiscomexDi) ) {
                        return j34SiscomexDi ;
                }
                else {
                        return null ; // Not found
                }
        }
        //----------------------------------------------------------------------
        /**
         * Carrega o objeto fornecido onde � esperado que tenha sido informada a java nos atributos
         * Caso seja localizado os campos restantes ser�o preenchidos com os valores do banco
         * Caso n�o ache fica como est�
         * @param j34SiscomexDi
         * @return True se encontrado , false caso nao seja encontrado
         */
        @Override
        public boolean load( J34SiscomexDi j34SiscomexDi ) {
                return super.doSelect(j34SiscomexDi) ;
        }
    //----------------------------------------------------------------------
        /**
         * Insere o objeto no banco de dados 
         * @param j34SiscomexDi
         */
        @Override
        public void insert(J34SiscomexDi j34SiscomexDi) {
                super.doInsert(j34SiscomexDi);
        }       

    //----------------------------------------------------------------------
        /**
         * Atualiza o objeto no banco de dados 
         * @param j34SiscomexDi
         * @return
         */
        @Override
        public int update(J34SiscomexDi j34SiscomexDi) {
                return super.doUpdate(j34SiscomexDi);
        }       

    //----------------------------------------------------------------------
        /**
         * remove o objeto no banco de dados desde que tenha sido fornecida a chave prim�ria 
         * @param numerodocumentocarga;
         * @return
         */
        @Override
        public int delete( String numerodocumentocarga ) {
                J34SiscomexDi j34SiscomexDi = newInstanceWithPrimaryKey( numerodocumentocarga ) ;
                return super.doDelete(j34SiscomexDi);
        }

    //----------------------------------------------------------------------
        /**
         * Remove o objeto fornecido do banco de dados 
         * @param j34SiscomexDi
         * @return
         */
        @Override
        public int delete( J34SiscomexDi j34SiscomexDi ) {
                return super.doDelete(j34SiscomexDi);
        }

    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada por parametro
         * @param numerodocumentocarga;
         * @return
         */
        @Override
        public boolean exists( String numerodocumentocarga ) {
                J34SiscomexDi j34SiscomexDi = newInstanceWithPrimaryKey( numerodocumentocarga ) ;
                return super.doExists(j34SiscomexDi);
        }
    //----------------------------------------------------------------------
        /**
         * Verifica se um registro existe no banco que coincida com a chave prim�ria passada atrav�s do objeto
         * @param j34SiscomexDi
         * @return
         */
        @Override
        public boolean exists( J34SiscomexDi j34SiscomexDi ) {
                return super.doExists(j34SiscomexDi);
        }

    //----------------------------------------------------------------------
        /**
         * retorna o total de registros na tabela
         * @return
         */
        @Override
        public long count() {
                return super.doCountAll();
        }

    //----------------------------------------------------------------------
        @Override
        protected String getSqlSelect() {
                return SQL_SELECT ;
        }
    //----------------------------------------------------------------------
        @Override
        protected String getSqlInsert() {
                return SQL_INSERT ;
        }
    //----------------------------------------------------------------------
        @Override
        protected String getSqlUpdate() {
                return SQL_UPDATE ;
        }
    //----------------------------------------------------------------------
        @Override
        protected String getSqlDelete() {
                return SQL_DELETE ;
        }
    //----------------------------------------------------------------------
        @Override
        protected String getSqlCount() {
                return SQL_COUNT ;
        }
    //----------------------------------------------------------------------
        @Override
        protected String getSqlCountAll() {
                return SQL_COUNT_ALL ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForPrimaryKey(List<String> list, int i, J34SiscomexDi j34SiscomexDi) throws SQLException {
                
                setRawParameter(list,j34SiscomexDi.getNumerodocumentocarga()) ; // "numerodocumentocarga" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected J34SiscomexDi populateBean(Cursor c, J34SiscomexDi j34SiscomexDi) throws SQLException {

               
                j34SiscomexDi.setNumerodocumentocarga(c.getString(c.getColumnIndex("numerodocumentocarga"))); // java.lang.String
                j34SiscomexDi.setCodigotipodocumentocarga(c.getString(c.getColumnIndex("codigotipodocumentocarga"))); // java.lang.String
                j34SiscomexDi.setCodigomoedaseguro(c.getInt(c.getColumnIndex("codigomoedaseguro"))); // java.lang.Integer
                j34SiscomexDi.setCodigomoedafrete(c.getInt(c.getColumnIndex("codigomoedafrete"))); // java.lang.Integer
                j34SiscomexDi.setCodigomotivotransmissao(c.getInt(c.getColumnIndex("codigomotivotransmissao"))); // java.lang.Integer
                j34SiscomexDi.setCargapesobruto(c.getFloat(c.getColumnIndex("cargapesobruto"))); // java.math.BigDecimal
                j34SiscomexDi.setCargapesoliquido(c.getFloat(c.getColumnIndex("cargapesoliquido"))); // java.math.BigDecimal
                j34SiscomexDi.setCodigobandeiratranspote(c.getString(c.getColumnIndex("codigobandeiratranspote"))); // java.lang.String
                j34SiscomexDi.setCodigomodalidadedespacho(c.getInt(c.getColumnIndex("codigomodalidadedespacho"))); // java.lang.int
                j34SiscomexDi.setCodigoorigemdi(c.getString(c.getColumnIndex("codigoorigemdi"))); // java.lang.String
                j34SiscomexDi.setCodigopaisprocedenciacarga(c.getString(c.getColumnIndex("codigopaisprocedenciacarga"))); // java.lang.String
                j34SiscomexDi.setCodigopaisimportador(c.getString(c.getColumnIndex("codigopaisimportador"))); // java.lang.String
                j34SiscomexDi.setCodigorecintoalfandegado(c.getString(c.getColumnIndex("codigorecintoalfandegado"))); // java.lang.String
                j34SiscomexDi.setCodigosetorarmazenamento(c.getString(c.getColumnIndex("codigosetorarmazenamento"))); // java.lang.String
                j34SiscomexDi.setCodigotipoagentecarga(c.getString(c.getColumnIndex("codigotipoagentecarga"))); // java.lang.String
                j34SiscomexDi.setCodigotipoconsignatario(c.getString(c.getColumnIndex("codigotipoconsignatario"))); // java.lang.String
                j34SiscomexDi.setCodigotipodeclaracao(c.getInt(c.getColumnIndex("codigotipodeclaracao"))); // java.lang.Integer
                j34SiscomexDi.setCodigotipoimportador(c.getInt(c.getColumnIndex("codigotipoimportador"))); // java.lang.Integer
                j34SiscomexDi.setCodigotipomanifesto(c.getInt(c.getColumnIndex("codigotipomanifesto"))); // java.lang.Integer
                j34SiscomexDi.setCodigotipopagamentotributario(c.getString(c.getColumnIndex("codigotipopagamentotributario"))); // java.lang.String
                j34SiscomexDi.setCodigourfcargaentrada(c.getString(c.getColumnIndex("codigourfcargaentrada"))); // java.lang.String
                j34SiscomexDi.setCodigourfdespacho(c.getString(c.getColumnIndex("codigourfdespacho"))); // java.lang.String
                j34SiscomexDi.setCodigoutilizacaodocumentocarga(c.getString(c.getColumnIndex("codigoutilizacaodocumentocarga"))); // java.lang.String
                j34SiscomexDi.setCodigoviatransporte(c.getString(c.getColumnIndex("codigoviatransporte"))); // java.lang.String
                j34SiscomexDi.setDatachegadacarga(new Date(c.getLong(c.getColumnIndex("datachegadacarga")))); // java.util.Date
                j34SiscomexDi.setDataembarque(new Date(c.getLong(c.getColumnIndex("dataembarque")))); // java.util.Date
                j34SiscomexDi.setIdentificacaodeclaracaoimportacao(c.getString(c.getColumnIndex("identificacaodeclaracaoimportacao"))); // java.lang.String
                j34SiscomexDi.setCodigoimportador(c.getInt(c.getColumnIndex("codigoimportador"))); // java.lang.Integer
                j34SiscomexDi.setIndicadormultimodalviatransporte(c.getString(c.getColumnIndex("indicadormultimodalviatransporte"))); // java.lang.String
                j34SiscomexDi.setIndicadoroperacaofundap(c.getString(c.getColumnIndex("indicadoroperacaofundap"))); // java.lang.String
                j34SiscomexDi.setInformacoescomplementares(c.getString(c.getColumnIndex("informacoescomplementares"))); // java.lang.String
                j34SiscomexDi.setCodigoconsignatorio(c.getInt(c.getColumnIndex("codigoconsignatorio"))); // java.lang.Integer
                j34SiscomexDi.setCodigolocalembarque(c.getString(c.getColumnIndex("codigolocalembarque"))); // java.lang.String
                j34SiscomexDi.setNomelocalembarque(c.getInt(c.getColumnIndex("nomelocalembarque"))); // java.lang.Integer
                j34SiscomexDi.setCodigotransportador(c.getInt(c.getColumnIndex("codigotransportador"))); // java.lang.Integer
                j34SiscomexDi.setCodigoveiculo(c.getInt(c.getColumnIndex("codigoveiculo"))); // java.lang.Integer
                j34SiscomexDi.setNumeroagentecarga(c.getString(c.getColumnIndex("numeroagentecarga"))); // java.lang.String
                j34SiscomexDi.setNumeroconsignatario(c.getString(c.getColumnIndex("numeroconsignatario"))); // java.lang.String
                j34SiscomexDi.setNumerocontapagamentotributario(c.getString(c.getColumnIndex("numerocontapagamentotributario"))); // java.lang.String
                j34SiscomexDi.setNumerocpfrepresentantelegal(c.getString(c.getColumnIndex("numerocpfrepresentantelegal"))); // java.lang.String
                j34SiscomexDi.setNumerodocumentocargamaster(c.getString(c.getColumnIndex("numerodocumentocargamaster"))); // java.lang.String
                j34SiscomexDi.setNumeroimportador(c.getString(c.getColumnIndex("numeroimportador"))); // java.lang.String
                j34SiscomexDi.setNumeromanifesto(c.getString(c.getColumnIndex("numeromanifesto"))); // java.lang.String
                j34SiscomexDi.setTotaladicoes(c.getFloat(c.getColumnIndex("totaladicoes"))); // java.math.BigDecimal
                j34SiscomexDi.setValorfreteterritorionacionalmoedanegociada(c.getFloat(c.getColumnIndex("valorfreteterritorionacionalmoedanegociada"))); // java.math.BigDecimal
                j34SiscomexDi.setValortotalfretecollect(c.getFloat(c.getColumnIndex("valortotalfretecollect"))); // java.math.BigDecimal
                j34SiscomexDi.setValortotalfretemoedanacional(c.getFloat(c.getColumnIndex("valortotalfretemoedanacional"))); // java.math.BigDecimal
                j34SiscomexDi.setValortotalfreteprepaid(c.getFloat(c.getColumnIndex("valortotalfreteprepaid"))); // java.math.BigDecimal
                j34SiscomexDi.setValortotalmlemoedanacional(c.getFloat(c.getColumnIndex("valortotalmlemoedanacional"))); // java.math.BigDecimal
                j34SiscomexDi.setTerminalrecintoalfandegario(c.getString(c.getColumnIndex("terminalrecintoalfandegario"))); // java.lang.String
                j34SiscomexDi.setValortotalseguromoedanacional(c.getFloat(c.getColumnIndex("valortotalseguromoedanacional"))); // java.math.BigDecimal
                j34SiscomexDi.setValortotalseguromoedanegociada(c.getFloat(c.getColumnIndex("valortotalseguromoedanegociada"))); // java.math.BigDecimal
                j34SiscomexDi.setId(c.getString(c.getColumnIndex("id"))); // java.lang.String
                return j34SiscomexDi ;
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForInsert(SQLiteStatement ps, int i, J34SiscomexDi j34SiscomexDi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexDi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigotipodocumentocarga() ) ; // "codigotipodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigomoedaseguro() ) ; // "codigomoedaseguro" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDi.getCodigomoedafrete() ) ; // "codigomoedafrete" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDi.getCodigomotivotransmissao() ) ; // "codigomotivotransmissao" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDi.getCargapesobruto() ) ; // "cargapesobruto" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexDi.getCargapesoliquido() ) ; // "cargapesoliquido" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexDi.getCodigobandeiratranspote() ) ; // "codigobandeiratranspote" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigomodalidadedespacho() ) ; // "codigomodalidadedespacho" : java.lang.int
                setValue(ps, i++, j34SiscomexDi.getCodigoorigemdi() ) ; // "codigoorigemdi" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigopaisprocedenciacarga() ) ; // "codigopaisprocedenciacarga" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigopaisimportador() ) ; // "codigopaisimportador" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigorecintoalfandegado() ) ; // "codigorecintoalfandegado" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigosetorarmazenamento() ) ; // "codigosetorarmazenamento" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigotipoagentecarga() ) ; // "codigotipoagentecarga" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigotipoconsignatario() ) ; // "codigotipoconsignatario" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigotipodeclaracao() ) ; // "codigotipodeclaracao" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDi.getCodigotipoimportador() ) ; // "codigotipoimportador" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDi.getCodigotipomanifesto() ) ; // "codigotipomanifesto" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDi.getCodigotipopagamentotributario() ) ; // "codigotipopagamentotributario" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigourfcargaentrada() ) ; // "codigourfcargaentrada" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigourfdespacho() ) ; // "codigourfdespacho" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigoutilizacaodocumentocarga() ) ; // "codigoutilizacaodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigoviatransporte() ) ; // "codigoviatransporte" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getDatachegadacarga() ) ; // "datachegadacarga" : java.util.Date
                setValue(ps, i++, j34SiscomexDi.getDataembarque() ) ; // "dataembarque" : java.util.Date
                setValue(ps, i++, j34SiscomexDi.getIdentificacaodeclaracaoimportacao() ) ; // "identificacaodeclaracaoimportacao" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigoimportador() ) ; // "codigoimportador" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDi.getIndicadormultimodalviatransporte() ) ; // "indicadormultimodalviatransporte" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getIndicadoroperacaofundap() ) ; // "indicadoroperacaofundap" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getInformacoescomplementares() ) ; // "informacoescomplementares" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigoconsignatorio() ) ; // "codigoconsignatorio" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDi.getCodigolocalembarque() ) ; // "codigolocalembarque" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getNomelocalembarque() ) ; // "nomelocalembarque" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDi.getCodigotransportador() ) ; // "codigotransportador" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDi.getCodigoveiculo() ) ; // "codigoveiculo" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDi.getNumeroagentecarga() ) ; // "numeroagentecarga" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getNumeroconsignatario() ) ; // "numeroconsignatario" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getNumerocontapagamentotributario() ) ; // "numerocontapagamentotributario" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getNumerocpfrepresentantelegal() ) ; // "numerocpfrepresentantelegal" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getNumerodocumentocargamaster() ) ; // "numerodocumentocargamaster" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getNumeroimportador() ) ; // "numeroimportador" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getNumeromanifesto() ) ; // "numeromanifesto" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getTotaladicoes() ) ; // "totaladicoes" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexDi.getValorfreteterritorionacionalmoedanegociada() ) ; // "valorfreteterritorionacionalmoedanegociada" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexDi.getValortotalfretecollect() ) ; // "valortotalfretecollect" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexDi.getValortotalfretemoedanacional() ) ; // "valortotalfretemoedanacional" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexDi.getValortotalfreteprepaid() ) ; // "valortotalfreteprepaid" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexDi.getValortotalmlemoedanacional() ) ; // "valortotalmlemoedanacional" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexDi.getTerminalrecintoalfandegario() ) ; // "terminalrecintoalfandegario" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getValortotalseguromoedanacional() ) ; // "valortotalseguromoedanacional" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexDi.getValortotalseguromoedanegociada() ) ; // "valortotalseguromoedanegociada" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexDi.getId() ) ; // "id" : java.lang.String
        }

    //----------------------------------------------------------------------
        @Override
        protected void setValuesForUpdate(SQLiteStatement ps, int i, J34SiscomexDi j34SiscomexDi) throws SQLException {

                
                setValue(ps, i++, j34SiscomexDi.getCodigotipodocumentocarga() ) ; // "codigotipodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigomoedaseguro() ) ; // "codigomoedaseguro" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDi.getCodigomoedafrete() ) ; // "codigomoedafrete" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDi.getCodigomotivotransmissao() ) ; // "codigomotivotransmissao" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDi.getCargapesobruto() ) ; // "cargapesobruto" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexDi.getCargapesoliquido() ) ; // "cargapesoliquido" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexDi.getCodigobandeiratranspote() ) ; // "codigobandeiratranspote" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigomodalidadedespacho() ) ; // "codigomodalidadedespacho" : java.lang.int
                setValue(ps, i++, j34SiscomexDi.getCodigoorigemdi() ) ; // "codigoorigemdi" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigopaisprocedenciacarga() ) ; // "codigopaisprocedenciacarga" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigopaisimportador() ) ; // "codigopaisimportador" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigorecintoalfandegado() ) ; // "codigorecintoalfandegado" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigosetorarmazenamento() ) ; // "codigosetorarmazenamento" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigotipoagentecarga() ) ; // "codigotipoagentecarga" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigotipoconsignatario() ) ; // "codigotipoconsignatario" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigotipodeclaracao() ) ; // "codigotipodeclaracao" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDi.getCodigotipoimportador() ) ; // "codigotipoimportador" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDi.getCodigotipomanifesto() ) ; // "codigotipomanifesto" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDi.getCodigotipopagamentotributario() ) ; // "codigotipopagamentotributario" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigourfcargaentrada() ) ; // "codigourfcargaentrada" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigourfdespacho() ) ; // "codigourfdespacho" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigoutilizacaodocumentocarga() ) ; // "codigoutilizacaodocumentocarga" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigoviatransporte() ) ; // "codigoviatransporte" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getDatachegadacarga() ) ; // "datachegadacarga" : java.util.Date
                setValue(ps, i++, j34SiscomexDi.getDataembarque() ) ; // "dataembarque" : java.util.Date
                setValue(ps, i++, j34SiscomexDi.getIdentificacaodeclaracaoimportacao() ) ; // "identificacaodeclaracaoimportacao" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigoimportador() ) ; // "codigoimportador" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDi.getIndicadormultimodalviatransporte() ) ; // "indicadormultimodalviatransporte" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getIndicadoroperacaofundap() ) ; // "indicadoroperacaofundap" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getInformacoescomplementares() ) ; // "informacoescomplementares" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getCodigoconsignatorio() ) ; // "codigoconsignatorio" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDi.getCodigolocalembarque() ) ; // "codigolocalembarque" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getNomelocalembarque() ) ; // "nomelocalembarque" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDi.getCodigotransportador() ) ; // "codigotransportador" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDi.getCodigoveiculo() ) ; // "codigoveiculo" : java.lang.Integer
                setValue(ps, i++, j34SiscomexDi.getNumeroagentecarga() ) ; // "numeroagentecarga" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getNumeroconsignatario() ) ; // "numeroconsignatario" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getNumerocontapagamentotributario() ) ; // "numerocontapagamentotributario" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getNumerocpfrepresentantelegal() ) ; // "numerocpfrepresentantelegal" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getNumerodocumentocargamaster() ) ; // "numerodocumentocargamaster" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getNumeroimportador() ) ; // "numeroimportador" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getNumeromanifesto() ) ; // "numeromanifesto" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getTotaladicoes() ) ; // "totaladicoes" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexDi.getValorfreteterritorionacionalmoedanegociada() ) ; // "valorfreteterritorionacionalmoedanegociada" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexDi.getValortotalfretecollect() ) ; // "valortotalfretecollect" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexDi.getValortotalfretemoedanacional() ) ; // "valortotalfretemoedanacional" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexDi.getValortotalfreteprepaid() ) ; // "valortotalfreteprepaid" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexDi.getValortotalmlemoedanacional() ) ; // "valortotalmlemoedanacional" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexDi.getTerminalrecintoalfandegario() ) ; // "terminalrecintoalfandegario" : java.lang.String
                setValue(ps, i++, j34SiscomexDi.getValortotalseguromoedanacional() ) ; // "valortotalseguromoedanacional" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexDi.getValortotalseguromoedanegociada() ) ; // "valortotalseguromoedanegociada" : java.math.BigDecimal
                setValue(ps, i++, j34SiscomexDi.getId() ) ; // "id" : java.lang.String
                
                setValue(ps, i++, j34SiscomexDi.getNumerodocumentocarga() ) ; // "numerodocumentocarga" : java.lang.String
        }

}
