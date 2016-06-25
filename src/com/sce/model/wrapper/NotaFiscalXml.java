package com.sce.model.wrapper;

import com.sce.model.domain.NotaFiscal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Andre on 05/06/2016.
 */
@XmlRootElement(name = "notasfiscais")
@XmlAccessorType(XmlAccessType.FIELD)
public class NotaFiscalXml {

    @XmlElement(name = "notafiscal")
    private List<NotaFiscal> notaFiscalList;

    public List<NotaFiscal> getNotaFiscalList() {
        return notaFiscalList;
    }

    public void setNotaFiscalList(List<NotaFiscal> notaFiscalList) {
        this.notaFiscalList = notaFiscalList;
    }
}
