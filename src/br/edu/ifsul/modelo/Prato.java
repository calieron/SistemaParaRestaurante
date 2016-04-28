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
@Table(name = "prato")
public class Prato extends Produto implements Serializable{
    @NotBlank(message = "O codigo deve ser informado")
    @Length(max = 5, message = "O código não pode ter mais de {max} caracteres")
    @Column(name = "cod_prato", length = 5, nullable = false)
    private String cod_prato;
    @NotBlank(message = "O cozinheiro deve ser informado")
    @Length(max = 50, message = "O cozinheiro não deve ter mais que {max} caracteres")
    @Column(name = "cozinheiro", length = 50, nullable = false)
    private String cozinheiro;
    @NotNull(message = "A data deve ser informada!")
    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Calendar data;
    @NotBlank(message = "O alimento deve ser informado")
    @Length(max = 50, message = "O alimento não deve ter mais que {max} caracteres")
    @Column(name = "alimento", length = 50, nullable = false)
    private String alimento;

    public Prato() {
    }

    public String getCod_prato() {
        return cod_prato;
    }

    public void setCod_prato(String cod_prato) {
        this.cod_prato = cod_prato;
    }

    public String getCozinheiro() {
        return cozinheiro;
    }

    public void setCozinheiro(String cozinheiro) {
        this.cozinheiro = cozinheiro;
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

    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.cod_prato);
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
        final Prato other = (Prato) obj;
        if (!Objects.equals(this.cod_prato, other.cod_prato)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prato{" + "alimento=" + alimento + '}';
    }
    
}
