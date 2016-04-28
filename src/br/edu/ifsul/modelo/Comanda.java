/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "comanda")
public class Comanda implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_comanda", sequenceName = "seq_comanda_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_comanda", strategy = GenerationType.SEQUENCE)
    private Integer id;
//    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL,
//            orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<Produto> listaProdutos = new ArrayList<>();
    @Min(value = 0, message = "A quantidade não pode ser negativa")
    @NotNull(message = "A quantidade deve ser informada")
    @Column(name = "quantidade", nullable = false, columnDefinition = "decimal(12,2)")
    private Double quantidade;
    @ManyToMany
    @JoinTable(name = "pessoa_comanda",
            joinColumns = 
            @JoinColumn(name = "comanda", referencedColumnName = "id", 
                    nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "pessoa", referencedColumnName = "id", 
                    nullable = false))  
    private List<Pessoa> consomem = new ArrayList<>();
    @NotNull(message = "A nota deve ser informada")
    @ManyToOne
    @JoinColumn(name = "nota", referencedColumnName = "id", nullable = false)
    private Nota nota;

    public Comanda() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public List<Produto> getListaProdutos() {
//        return listaProdutos;
//    }
//
//    public void setListaProdutos(List<Produto> listaProdutos) {
//        this.listaProdutos = listaProdutos;
//    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comanda other = (Comanda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comanda{" + "quantidade=" + getQuantidade() + '}';
    }    

    public List<Pessoa> getConsomem() {
        return consomem;
    }

    public void setConsomem(List<Pessoa> consomem) {
        this.consomem = consomem;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }
    
}
