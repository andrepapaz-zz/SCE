package com.sce.model.wrapper;

import com.sce.model.domain.ItensNotaFiscal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Andre on 05/06/2016.
 */
@XmlRootElement(name = "itens")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItensNotaFiscalXml {

    @XmlElement(name = "item")
    private List<ItensNotaFiscal> itensNotaFiscalsList;

    public List<ItensNotaFiscal> getItensNotaFiscalsList() {
        return itensNotaFiscalsList;
    }

    public void setItensNotaFiscalsList(List<ItensNotaFiscal> itensNotaFiscalsList) {
        this.itensNotaFiscalsList = itensNotaFiscalsList;
    }
}
