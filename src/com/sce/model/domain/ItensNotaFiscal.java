package com.sce.model.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

/**
 * Created by Andre on 28/05/2016.
 */
@XmlRootElement
@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"idProd", "idNf"})
)
public class ItensNotaFiscal implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "idProd", referencedColumnName = "id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "idNf", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private NotaFiscal notaFiscal;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private Integer quantidade;

    @Transient
    private Double total;

    public ItensNotaFiscal() {
    }

    public ItensNotaFiscal(Produto produto, NotaFiscal notaFiscal, Double valor, Integer quantidade, Double total) {
        this.produto = produto;
        this.notaFiscal = notaFiscal;
        this.valor = valor;
        this.quantidade = quantidade;
        this.total = total;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @XmlTransient
    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @PostLoad
    public void setTotalLoad() {
        this.setTotal(this.getQuantidade() * this.getValor());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItensNotaFiscal that = (ItensNotaFiscal) o;

        return codigo.equals(that.codigo);

    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
