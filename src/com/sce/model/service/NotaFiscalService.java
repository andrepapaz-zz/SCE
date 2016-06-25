package com.sce.model.service;

import com.sce.model.domain.NotaFiscal;
import org.apache.poi.hssf.record.formula.functions.Not;

import java.util.List;

/**
 * Created by Andre on 29/05/2016.
 */
public interface NotaFiscalService {
    List<NotaFiscal> getNotaFiscais();

    List<NotaFiscal> getNotasFiscaisEntrada();

    List<NotaFiscal> getNotasFiscaisSaida();

    NotaFiscal inserir(NotaFiscal notaFiscal);

    void alterar(NotaFiscal notaFiscal);

    void excluir(NotaFiscal notaFiscal);
}
