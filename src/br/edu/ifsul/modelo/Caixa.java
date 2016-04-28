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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "caixa")
public class Caixa implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_caixa", sequenceName = "seq_caixa_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_caixa", strategy = GenerationType.SEQUENCE)
    private Integer registro;
    @NotNull(message = "A entrada deve ser informado")
    @Column(name = "entrada", nullable = false, columnDefinition = "decimal(12,2)")
    private Double entrada;
    @NotNull(message = "A saida deve ser informado")
    @Column(name = "saida", nullable = false, columnDefinition = "decimal(12,2)")
    private Double saida;
    @NotNull(message = "O fechamento deve ser informado")
    @Column(name = "fechamento", nullable = false, columnDefinition = "decimal(12,2)")
    private Double fechamento;
    @NotNull(message = "A pessoa deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;
    
    public Caixa() {
    }

    public Integer getRegistro() {
        return registro;
    }

    public void setRegistro(Integer registro) {
        this.registro = registro;
    }

    public Double getEntrada() {
        return entrada;
    }

    public void setEntrada(Double entrada) {
        this.entrada = entrada;
    }

    public Double getSaida() {
        return saida;
    }

    public void setSaida(Double saida) {
        this.saida = saida;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public Double getFechamento() {
        return fechamento;
    }

    public void setFechamento(Double fechamento) {
        this.fechamento = fechamento;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.registro);
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
        final Caixa other = (Caixa) obj;
        if (!Objects.equals(this.registro, other.registro)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Caixa{" + "fechamento=" + fechamento + '}';
    }

    
}
