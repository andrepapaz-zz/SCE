package com.sce.model.domain;

import com.sce.model.wrapper.TipoNFWrapper;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Andre on 28/05/2016.
 */
@XmlRootElement
@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"numero", "idEmp"})
)
public class NotaFiscal implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "idEmp", referencedColumnName = "id")
    private Empresa empresa;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private Double valor;

    @Column(name = "tipo", nullable = false)
    private String tipoBase;

    @Transient
    private TipoNFWrapper tipo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "notaFiscal", cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = ItensNotaFiscal.class)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<ItensNotaFiscal> itens;

    public NotaFiscal() {
    }

    public NotaFiscal(Empresa empresa, String numero, Double valor, String tipoBase, TipoNFWrapper tipo) {
        this.empresa = empresa;
        this.numero = numero;
        this.valor = valor;
        this.tipoBase = tipoBase;
        this.tipo = tipo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @XmlTransient
    public String getTipoBase() {
        return tipoBase;
    }

    public void setTipoBase(String tipoBase) {
        this.tipoBase = tipoBase;
    }

    public TipoNFWrapper getTipo() {
        return tipo;
    }

    public void setTipo(TipoNFWrapper tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<ItensNotaFiscal> getItens() {
        return itens;
    }

    public void setItens(List<ItensNotaFiscal> itens) {
        this.itens = itens;
    }

    @PostLoad
    public void setTipoLoad() {
        TipoNFEnum tipoNFEnum = TipoNFEnum.getValue(tipoBase);
        this.tipo = new TipoNFWrapper(tipoNFEnum.getCodigo(), tipoNFEnum.getDescricao());
    }

    @PrePersist
    public void setPrePersist() {
        List<ItensNotaFiscal> itens = this.getItens();
        if (itens != null) {
            for (ItensNotaFiscal itensNotaFiscal : itens) {
                itensNotaFiscal.setNotaFiscal(this);
            }
        }
        this.tipoBase = tipo.getCodigo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotaFiscal that = (NotaFiscal) o;

        return codigo.equals(that.codigo);

    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
