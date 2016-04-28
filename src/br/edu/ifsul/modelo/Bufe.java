/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "bufe")
public class Bufe extends Produto implements Serializable{
    @NotBlank(message = "O codigo deve ser informado")
    @Length(max = 5, message = "O código não pode ter mais de {max} caracteres")
    @Column(name = "cod_bufe", length = 5, nullable = false)
    private String cod_bufe;
    @NotBlank(message = "O tipo deve ser informado")
    @Length(max = 50, message = "O tipo não deve ter mais que {max} caracteres")
    @Column(name = "tipo", length = 50, nullable = false)
    private String tipo;
    @NotNull(message = "A data deve ser informada!")
    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Calendar data;
    @NotBlank(message = "O alimento deve ser informado")
    @Length(max = 50, message = "O alimento não deve ter mais que {max} caracteres")
    @Column(name = "alimento", length = 50, nullable = false)
    private String alimento;
    @Min(value = 0, message = "A quantidade não pode ser negativa")
    @NotNull(message = "A quantidade deve ser informada")
    @Column(name = "quantidade", nullable = false, columnDefinition = "decimal(12,2)")
    private Double quantidade;

    public Bufe() {
    }
    
    public String getCod_bufe() {
        return cod_bufe;
    }

    public void setCod_bufe(String cod_bufe) {
        this.cod_bufe = cod_bufe;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.cod_bufe);
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
        final Bufe other = (Bufe) obj;
        if (!Objects.equals(this.cod_bufe, other.cod_bufe)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bufe{" + "tipo=" + tipo + '}';
    }
    
    
}
