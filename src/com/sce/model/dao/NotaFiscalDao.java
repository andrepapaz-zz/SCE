package com.sce.model.dao;

import com.sce.model.domain.NotaFiscal;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Andre on 29/05/2016.
 */
public interface NotaFiscalDao {
    List<NotaFiscal> getNotaFiscais();

    List<NotaFiscal> getNotasFiscaisEntrada();

    List<NotaFiscal> getNotasFiscaisSaida();

    NotaFiscal inserir(NotaFiscal notaFiscal);

    void alterar(NotaFiscal notaFiscal);

    void excluir(NotaFiscal notaFiscal);
}
